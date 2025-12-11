"""allocate.py - Fractional multi-month allocator for Budget Planner
Uses OR-Tools Linear Programming to minimize cost subject to capacity, skill, region, and budget constraints.
"""
import pandas as pd
import json
from datetime import datetime
from collections import defaultdict
from ortools.linear_solver import pywraplp

def months_range(start_ym, end_ym):
    """Return list of YYYY-MM strings inclusive"""
    start = pd.to_datetime(start_ym + "-01")
    end = pd.to_datetime(end_ym + "-01")
    months = pd.date_range(start=start, end=end, freq='MS').strftime('%Y-%m').tolist()
    return months

def parse_required_skills(field):
    if not field or pd.isna(field):
        return {'technical': [], 'functional': []}
    if isinstance(field, str):
        try:
            val = json.loads(field)
            return {'technical': val.get('technical', []), 'functional': val.get('functional', [])}
        except Exception:
            # fallback: assume comma-separated technical skills
            return {'technical': [s.strip() for s in field.split(',') if s.strip()], 'functional': []}
    if isinstance(field, dict):
        return {'technical': field.get('technical', []), 'functional': field.get('functional', [])}
    return {'technical': [], 'functional': []}

def skill_score(emp_row, req):
    """Score an employee against required skills dict{'technical':[...],'functional':[...]}"""
    score = 0.0
    emp_tech = (emp_row.get('technical_skills') or '').lower()
    emp_func = (emp_row.get('functional_skills') or '').lower()
    for t in req.get('technical', []):
        if t.lower() in emp_tech:
            score += 2.0
    for f in req.get('functional', []):
        if f.lower() in emp_func:
            score += 1.0
    return score

def simple_fractional_allocator(employees_df, projects_df, scenario_id, global_start=None, global_end=None):
    """OR-Tools LP allocator that minimizes cost subject to constraints:
    - employees_df: DataFrame with employee details & availability (status, fte_capacity)
    - projects_df: DataFrame with projects and required_skills (JSON)
    Returns list of allocations dicts with month (YYYY-MM), fraction and cost.
    
    Constraints:
    1. Capacity: Employee allocations per month <= fte_capacity
    2. Skills: Only employees with required skills can be allocated
    3. Budget: Project costs per month <= budget per month
    4. Region: Prefer employees matching region_preference (soft constraint via penalty)
    """
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
    
    for _, proj in projects_df.iterrows():
        start = proj.get('start_month') or (global_start or pd.Timestamp.now().strftime('%Y-%m'))
        end = proj.get('end_month') or (global_end or pd.Timestamp.now().strftime('%Y-%m'))
        months = months_range(start, end) if start and end else (global_months or [])
        req_skills = parse_required_skills(proj.get('required_skills'))
        max_budget = float(proj.get('max_budget') or 0.0)
        per_month_budget = max_budget / max(1, len(months)) if months else 0.0
        region_pref = str(proj.get('region_preference') or '')
        
        project_data[int(proj['project_id'])] = {
            'required_skills': req_skills,
            'per_month_budget': per_month_budget,
            'region_preference': region_pref
        }
        
        for m in months:
            project_months.append((int(proj['project_id']), m))
    
    if not project_months:
        return []
    
    # Create LP solver
    solver = pywraplp.Solver.CreateSolver('GLOP')
    if not solver:
        raise RuntimeError('Could not create solver')
    
    # Decision variables: x[employee_id, project_id, month] = allocation fraction
    variables = {}
    employee_ids = active_employees['employee_id'].tolist()
    
    for eid in employee_ids:
        emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
        for pid, month in project_months:
            # Check if employee has required skills for this project
            proj_info = project_data[pid]
            req_skills = proj_info['required_skills']
            has_skills = _employee_has_required_skills(emp_row, req_skills)
            
            if has_skills:
                var_name = f'x_e{eid}_p{pid}_m{month}'
                variables[(eid, pid, month)] = solver.NumVar(0.0, float(emp_row['fte_capacity']), var_name)
            else:
                variables[(eid, pid, month)] = None  # Cannot allocate
    
    # Objective: Minimize total cost
    objective = solver.Objective()
    for (eid, pid, month), var in variables.items():
        if var is not None:
            emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
            cost = float(emp_row['cost_per_month'])
            # Add region penalty (soft constraint)
            proj_info = project_data[pid]
            region_penalty = 0.0
            if proj_info['region_preference'] and emp_row['region'] != proj_info['region_preference']:
                region_penalty = cost * 0.1  # 10% penalty for region mismatch
            objective.SetCoefficient(var, cost + region_penalty)
    objective.SetMinimization()
    
    # Constraint 1: Employee capacity per month
    # For each employee e and month m: sum(x[e,p,m] for all p) <= fte_capacity[e]
    for eid in employee_ids:
        emp_row = active_employees[active_employees['employee_id'] == eid].iloc[0]
        capacity = float(emp_row['fte_capacity'])
        
        # Group by month
        months_for_emp = set()
        for pid, month in project_months:
            if variables.get((eid, pid, month)) is not None:
                months_for_emp.add(month)
        
        for month in months_for_emp:
            constraint = solver.Constraint(0.0, capacity, f'capacity_e{eid}_m{month}')
            for pid, m in project_months:
                if m == month:
                    var = variables.get((eid, pid, month))
                    if var is not None:
                        constraint.SetCoefficient(var, 1.0)
    
    # Constraint 2: Budget per project per month
    # For each project p and month m: sum(x[e,p,m] * cost[e] for all e) <= budget_per_month[p]
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
    
    # Constraint 3: Minimum allocation per project per month (optional - ensure projects get some resources)
    # For each project p and month m: sum(x[e,p,m] for all e) >= min_allocation (e.g., 0.1 FTE)
    # This is optional - comment out if not needed
    min_allocation_per_project_month = 0.0  # Set to 0.1 or higher if you want minimum allocation
    
    if min_allocation_per_project_month > 0:
        for pid, month in project_months:
            constraint = solver.Constraint(min_allocation_per_project_month, solver.infinity(), f'min_alloc_p{pid}_m{month}')
            for eid in employee_ids:
                var = variables.get((eid, pid, month))
                if var is not None:
                    constraint.SetCoefficient(var, 1.0)
    
    # Solve
    status = solver.Solve()
    
    if status == pywraplp.Solver.OPTIMAL:
        print(f'Solver found optimal solution. Objective value: {solver.Objective().Value():.2f}')
    elif status == pywraplp.Solver.FEASIBLE:
        print(f'Solver found feasible solution. Objective value: {solver.Objective().Value():.2f}')
    else:
        status_names = {
            pywraplp.Solver.NOT_SOLVED: 'NOT_SOLVED',
            pywraplp.Solver.INFEASIBLE: 'INFEASIBLE',
            pywraplp.Solver.UNBOUNDED: 'UNBOUNDED',
            pywraplp.Solver.ABNORMAL: 'ABNORMAL',
            pywraplp.Solver.MODEL_INVALID: 'MODEL_INVALID'
        }
        print(f'Warning: Solver status = {status} ({status_names.get(status, "UNKNOWN")})')
        print(f'  Variables created: {len([v for v in variables.values() if v is not None])}')
        print(f'  Project-months: {len(project_months)}')
        print(f'  Active employees: {len(active_employees)}')
        return []
    
    # Extract results
    allocations = []
    for (eid, pid, month), var in variables.items():
        if var is not None:
            value = var.solution_value()
            if value > 1e-6:  # Only include non-zero allocations
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


def _employee_has_required_skills(emp_row, req_skills):
    """Check if employee has required skills for a project.
    Returns True if employee has at least one of the required skills (OR logic).
    This allows employees to contribute if they have any matching skill.
    """
    if not req_skills or (not req_skills.get('technical') and not req_skills.get('functional')):
        return True  # No requirements means any employee can be allocated
    
    emp_tech = (emp_row.get('technical_skills') or '').lower()
    emp_func = (emp_row.get('functional_skills') or '').lower()
    
    # Check if employee has at least one required skill (technical OR functional)
    has_match = False
    
    # Check technical skills
    if req_skills.get('technical'):
        for tech in req_skills.get('technical', []):
            if tech.lower() in emp_tech:
                has_match = True
                break
    
    # Check functional skills (if no technical match yet)
    if not has_match and req_skills.get('functional'):
        for func in req_skills.get('functional', []):
            if func.lower() in emp_func:
                has_match = True
                break
    
    return has_match

