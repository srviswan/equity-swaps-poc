"""allocate_enhanced.py - Enhanced OR-Tools LP allocator with multiple optimizations

Optimizations implemented:
1. Skill quality scoring - Prefer better skill matches
2. Reduced fragmentation - Penalize small allocations
3. Workload balancing - Minimize variance in employee utilization
4. Allocation continuity - Prefer stable allocations across months
5. Project priority - Weight by project impact/importance
"""

import pandas as pd
import json
from datetime import datetime
from collections import defaultdict
from ortools.linear_solver import pywraplp
from allocate import months_range, parse_required_skills, skill_score, _employee_has_required_skills


def enhanced_fractional_allocator(
    employees_df, 
    projects_df, 
    scenario_id, 
    global_start=None, 
    global_end=None,
    weights=None
):
    """Enhanced OR-Tools LP allocator with multiple optimization objectives.
    
    Args:
        employees_df: DataFrame with employee details
        projects_df: DataFrame with projects
        scenario_id: Scenario ID for allocations
        global_start: Global start month (YYYY-MM)
        global_end: Global end month (YYYY-MM)
        weights: Dict with optimization weights:
            - cost_weight: Weight for cost minimization (default: 0.5)
            - skill_weight: Weight for skill quality (default: 0.2)
            - fragmentation_weight: Weight for fragmentation penalty (default: 0.1)
            - continuity_weight: Weight for allocation continuity (default: 0.1)
            - balance_weight: Weight for workload balance (default: 0.1)
    
    Returns:
        List of allocation dictionaries
    """
    # Default weights
    if weights is None:
        weights = {
            'cost_weight': 0.5,
            'skill_weight': 0.2,
            'fragmentation_weight': 0.1,
            'continuity_weight': 0.1,
            'balance_weight': 0.1
        }
    
    # Prepare data
    employees = employees_df.copy()
    employees['technical_skills'] = employees['technical_skills'].fillna('').astype(str)
    employees['functional_skills'] = employees['functional_skills'].fillna('').astype(str)
    employees['fte_capacity'] = employees['fte_capacity'].fillna(1.0).astype(float)
    employees['cost_per_month'] = employees['cost_per_month'].fillna(0.0).astype(float)
    employees['region'] = employees['region'].fillna('').astype(str)
    
    # Filter active employees
    active_employees = employees[employees['status'] == 'active'].copy()
    if len(active_employees) == 0:
        return []
    
    # Determine months
    if global_start and global_end:
        global_months = pd.date_range(start=global_start + "-01", end=global_end + "-01", freq='MS').strftime('%Y-%m').tolist()
    else:
        global_months = None
    
    # Collect all project-month combinations
    project_months = []
    project_data = {}
    all_months = set()
    
    for _, proj in projects_df.iterrows():
        start = proj.get('start_month') or (global_start or pd.Timestamp.now().strftime('%Y-%m'))
        end = proj.get('end_month') or (global_end or pd.Timestamp.now().strftime('%Y-%m'))
        months = months_range(start, end) if start and end else (global_months or [])
        req_skills = parse_required_skills(proj.get('required_skills'))
        max_budget = float(proj.get('max_budget') or 0.0)
        per_month_budget = max_budget / max(1, len(months)) if months else 0.0
        region_pref = str(proj.get('region_preference') or '')
        impact = str(proj.get('impact') or 'Medium').lower()
        priority = {'high': 3, 'medium': 2, 'low': 1}.get(impact, 2)
        
        project_data[int(proj['project_id'])] = {
            'required_skills': req_skills,
            'per_month_budget': per_month_budget,
            'region_preference': region_pref,
            'priority': priority
        }
        
        for m in months:
            project_months.append((int(proj['project_id']), m))
            all_months.add(m)
    
    if not project_months:
        return []
    
    all_months = sorted(list(all_months))
    
    # Create LP solver
    solver = pywraplp.Solver.CreateSolver('GLOP')
    if not solver:
        raise RuntimeError('Could not create solver')
    
    # Decision variables: x[employee_id, project_id, month] = allocation fraction
    variables = {}
    employee_ids = active_employees['employee_id'].tolist()
    skill_scores = {}  # Cache skill scores
    
    for eid in employee_ids:
        emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
        for pid, month in project_months:
            proj_info = project_data[pid]
            req_skills = proj_info['required_skills']
            has_skills = _employee_has_required_skills(emp_row, req_skills)
            
            if has_skills:
                var_name = f'x_e{eid}_p{pid}_m{month}'
                variables[(eid, pid, month)] = solver.NumVar(0.0, float(emp_row['fte_capacity']), var_name)
                # Cache skill score for objective
                skill_scores[(eid, pid)] = skill_score(emp_row, req_skills)
            else:
                variables[(eid, pid, month)] = None
    
    # Helper: Get previous month
    def prev_month(month_str):
        year, month = map(int, month_str.split('-'))
        if month == 1:
            return f"{year-1}-12"
        return f"{year}-{month-1:02d}"
    
    # Fragmentation penalty variables: penalize small allocations
    fragmentation_vars = {}
    if weights['fragmentation_weight'] > 0:
        for (eid, pid, month), var in variables.items():
            if var is not None:
                # Binary indicator: 1 if allocation < 0.25 FTE
                frag_var = solver.NumVar(0.0, 1.0, f'frag_e{eid}_p{pid}_m{month}')
                fragmentation_vars[(eid, pid, month)] = frag_var
                # Constraint: frag_var >= 1 - (allocation / 0.25) if allocation < 0.25
                # Simplified: frag_var >= 1 - 4 * allocation (relaxed)
                constraint = solver.Constraint(-solver.infinity(), 1.0, f'frag_const_e{eid}_p{pid}_m{month}')
                constraint.SetCoefficient(frag_var, 1.0)
                constraint.SetCoefficient(var, 4.0)  # frag_var + 4*allocation <= 1
    
    # Continuity penalty variables: penalize month-to-month changes
    continuity_vars = {}
    if weights['continuity_weight'] > 0:
        for eid in employee_ids:
            for pid, month in project_months:
                if variables.get((eid, pid, month)) is not None:
                    prev_m = prev_month(month)
                    if (eid, pid, prev_m) in variables and variables[(eid, pid, prev_m)] is not None:
                        # Change variable: absolute difference
                        change_var = solver.NumVar(0.0, 1.0, f'change_e{eid}_p{pid}_m{month}')
                        continuity_vars[(eid, pid, month)] = change_var
                        # Constraint: change_var >= |x[month] - x[prev_month]|
                        # Using: change_var >= x[month] - x[prev_month] and change_var >= x[prev_month] - x[month]
                        constraint1 = solver.Constraint(0.0, solver.infinity(), f'cont1_e{eid}_p{pid}_m{month}')
                        constraint1.SetCoefficient(change_var, 1.0)
                        constraint1.SetCoefficient(variables[(eid, pid, month)], -1.0)
                        constraint1.SetCoefficient(variables[(eid, pid, prev_m)], 1.0)
                        
                        constraint2 = solver.Constraint(0.0, solver.infinity(), f'cont2_e{eid}_p{pid}_m{month}')
                        constraint2.SetCoefficient(change_var, 1.0)
                        constraint2.SetCoefficient(variables[(eid, pid, month)], 1.0)
                        constraint2.SetCoefficient(variables[(eid, pid, prev_m)], -1.0)
    
    # Workload balance: minimize variance in employee utilization
    # We'll use a simplified approach: minimize max utilization
    max_utilization_var = None
    if weights['balance_weight'] > 0:
        max_utilization_var = solver.NumVar(0.0, len(project_months), 'max_utilization')
        for eid in employee_ids:
            for month in all_months:
                constraint = solver.Constraint(0.0, solver.infinity(), f'balance_e{eid}_m{month}')
                constraint.SetCoefficient(max_utilization_var, -1.0)
                for pid, m in project_months:
                    if m == month:
                        var = variables.get((eid, pid, month))
                        if var is not None:
                            constraint.SetCoefficient(var, 1.0)
    
    # Objective: Multi-objective weighted sum
    objective = solver.Objective()
    
    # 1. Cost minimization (primary)
    for (eid, pid, month), var in variables.items():
        if var is not None:
            emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
            cost = float(emp_row['cost_per_month'])
            proj_info = project_data[pid]
            
            # Region penalty
            region_penalty = 0.0
            if proj_info['region_preference'] and emp_row['region'] != proj_info['region_preference']:
                region_penalty = cost * 0.1
            
            # Project priority adjustment (higher priority = lower effective cost)
            priority_factor = 1.0 / proj_info['priority']  # High priority (3) = 0.33, Low (1) = 1.0
            
            objective.SetCoefficient(var, (cost + region_penalty) * priority_factor * weights['cost_weight'])
    
    # 2. Skill quality maximization (invert to minimize)
    max_skill_score = max(skill_scores.values()) if skill_scores else 1.0
    for (eid, pid, month), var in variables.items():
        if var is not None:
            skill_qual = skill_scores.get((eid, pid), 0.0)
            # Normalize and invert (higher skill = lower penalty)
            skill_penalty = (max_skill_score - skill_qual) / max_skill_score if max_skill_score > 0 else 0
            # Use average cost as scaling factor
            avg_cost = active_employees['cost_per_month'].mean()
            objective.SetCoefficient(var, skill_penalty * avg_cost * weights['skill_weight'])
    
    # 3. Fragmentation penalty
    if weights['fragmentation_weight'] > 0:
        avg_cost = active_employees['cost_per_month'].mean()
        for (eid, pid, month), frag_var in fragmentation_vars.items():
            objective.SetCoefficient(frag_var, avg_cost * weights['fragmentation_weight'])
    
    # 4. Continuity penalty
    if weights['continuity_weight'] > 0:
        avg_cost = active_employees['cost_per_month'].mean()
        for (eid, pid, month), change_var in continuity_vars.items():
            objective.SetCoefficient(change_var, avg_cost * weights['continuity_weight'])
    
    # 5. Workload balance
    if weights['balance_weight'] > 0 and max_utilization_var is not None:
        avg_cost = active_employees['cost_per_month'].mean()
        objective.SetCoefficient(max_utilization_var, avg_cost * weights['balance_weight'])
    
    objective.SetMinimization()
    
    # Constraints
    
    # Constraint 1: Employee capacity per month
    for eid in employee_ids:
        emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
        capacity = float(emp_row['fte_capacity'])
        
        for month in all_months:
            constraint = solver.Constraint(0.0, capacity, f'capacity_e{eid}_m{month}')
            for pid, m in project_months:
                if m == month:
                    var = variables.get((eid, pid, month))
                    if var is not None:
                        constraint.SetCoefficient(var, 1.0)
    
    # Constraint 2: Budget per project per month
    for pid, month in project_months:
        proj_info = project_data[pid]
        budget = proj_info['per_month_budget']
        if budget > 0:
            constraint = solver.Constraint(0.0, budget, f'budget_p{pid}_m{month}')
            for eid in employee_ids:
                var = variables.get((eid, pid, month))
                if var is not None:
                    emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
                    cost = float(emp_row['cost_per_month'])
                    constraint.SetCoefficient(var, cost)
    
    # Constraint 3: Minimum allocation per project per month
    for pid, month in project_months:
        proj_info = project_data[pid]
        budget = proj_info['per_month_budget']
        
        min_alloc = 0.0
        if budget > 0:
            cheapest_cost = float('inf')
            for eid in employee_ids:
                var = variables.get((eid, pid, month))
                if var is not None:
                    emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
                    cost = float(emp_row['cost_per_month'])
                    if cost < cheapest_cost:
                        cheapest_cost = cost
            
            if cheapest_cost < float('inf') and budget >= cheapest_cost * 0.1:
                min_alloc = 0.1
        
        if min_alloc > 0:
            constraint = solver.Constraint(min_alloc, solver.infinity(), f'min_alloc_p{pid}_m{month}')
            for eid in employee_ids:
                var = variables.get((eid, pid, month))
                if var is not None:
                    constraint.SetCoefficient(var, 1.0)
    
    # Solve
    status = solver.Solve()
    
    if status != pywraplp.Solver.OPTIMAL and status != pywraplp.Solver.FEASIBLE:
        status_names = {
            pywraplp.Solver.NOT_SOLVED: 'NOT_SOLVED',
            pywraplp.Solver.INFEASIBLE: 'INFEASIBLE',
            pywraplp.Solver.UNBOUNDED: 'UNBOUNDED',
            pywraplp.Solver.ABNORMAL: 'ABNORMAL',
            pywraplp.Solver.MODEL_INVALID: 'MODEL_INVALID'
        }
        print(f'Warning: Solver status = {status} ({status_names.get(status, "UNKNOWN")})')
        return []
    
    # Extract results
    allocations = []
    for (eid, pid, month), var in variables.items():
        if var is not None:
            value = var.solution_value()
            if value > 1e-6:
                emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
                cost = value * float(emp_row['cost_per_month'])
                allocations.append({
                    'scenario_id': scenario_id,
                    'employee_id': eid,
                    'project_id': pid,
                    'month': month,
                    'allocation_fraction': round(value, 4),
                    'cost': round(cost, 2)
                })
    
    return allocations

