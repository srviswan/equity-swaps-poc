"""run_scenario_comparison.py - Compare allocations across multiple scenarios
Creates scenario 2 with different parameters and compares with scenario 1
"""
import pandas as pd
import json
from pathlib import Path
from allocate import simple_fractional_allocator
from excel_io import create_template

BASE = Path(__file__).resolve().parent
excel_path = BASE.parent / 'excel' / 'budget_planner_template.xlsx'
out_path = BASE.parent / 'excel' / 'scenario_comparison.xlsx'

# Create template if not exists
if not excel_path.exists():
    create_template(str(excel_path))

# Load data
xls = pd.ExcelFile(str(excel_path))
employees = pd.read_excel(xls, 'Employees')
projects = pd.read_excel(xls, 'Projects')
scenarios = pd.read_excel(xls, 'Scenarios')

global_start = projects['start_month'].min()
global_end = projects['end_month'].max()

print("=" * 80)
print("SCENARIO COMPARISON")
print("=" * 80)

# Scenario 1: Baseline (current allocations)
print("\n1. Running Scenario 1 (Baseline)...")
scenario_id_1 = 1
allocs_1 = simple_fractional_allocator(employees, projects, scenario_id_1, 
                                       global_start=global_start, global_end=global_end)
allocs_1_df = pd.DataFrame(allocs_1)

if len(allocs_1) > 0:
    actual_1 = allocs_1_df[allocs_1_df['project_id'].notna()]
    print(f"   Allocations: {len(actual_1)}")
    print(f"   Total cost: ${actual_1['cost'].sum():,.2f}")
    print(f"   Total FTE allocated: {actual_1['allocation_fraction'].sum():.2f}")

# Scenario 2: Modified scenario with different parameters
print("\n2. Running Scenario 2 (Modified - Higher Budget & Different Priorities)...")

# Create modified projects for scenario 2
projects_2 = projects.copy()
# Increase budgets significantly to allow more allocation
projects_2['max_budget'] = projects_2['max_budget'] * 2.0  # 100% budget increase

# Also modify project Alpha to have higher priority (by increasing budget more)
alpha_idx = projects_2[projects_2['project_name'] == 'Alpha'].index
if len(alpha_idx) > 0:
    projects_2.loc[alpha_idx, 'max_budget'] = projects_2.loc[alpha_idx, 'max_budget'] * 1.5

print(f"   Project budgets:")
for _, proj in projects_2.iterrows():
    orig_budget = projects[projects['project_id'] == proj['project_id']]['max_budget'].iloc[0]
    print(f"     {proj['project_name']}: ${orig_budget:,.0f} -> ${proj['max_budget']:,.0f}")

scenario_id_2 = 2
allocs_2 = simple_fractional_allocator(employees, projects_2, scenario_id_2,
                                       global_start=global_start, global_end=global_end)
allocs_2_df = pd.DataFrame(allocs_2)

if len(allocs_2) > 0:
    actual_2 = allocs_2_df[allocs_2_df['project_id'].notna()]
    print(f"   Allocations: {len(actual_2)}")
    print(f"   Total cost: ${actual_2['cost'].sum():,.2f}")
    print(f"   Total FTE allocated: {actual_2['allocation_fraction'].sum():.2f}")

# Comparison Analysis
print("\n" + "=" * 80)
print("COMPARISON ANALYSIS")
print("=" * 80)

if len(allocs_1) > 0 and len(allocs_2) > 0:
    actual_1 = allocs_1_df[allocs_1_df['project_id'].notna()].copy()
    actual_2 = allocs_2_df[allocs_2_df['project_id'].notna()].copy()
    
    # Summary comparison
    summary_data = []
    summary_data.append({
        'Metric': 'Total Allocations',
        'Scenario 1': len(actual_1),
        'Scenario 2': len(actual_2),
        'Delta': len(actual_2) - len(actual_1),
        'Change %': f"{((len(actual_2) - len(actual_1)) / len(actual_1) * 100):.1f}%"
    })
    
    cost_1 = actual_1['cost'].sum()
    cost_2 = actual_2['cost'].sum()
    summary_data.append({
        'Metric': 'Total Cost',
        'Scenario 1': f"${cost_1:,.2f}",
        'Scenario 2': f"${cost_2:,.2f}",
        'Delta': f"${cost_2 - cost_1:,.2f}",
        'Change %': f"{((cost_2 - cost_1) / cost_1 * 100):.1f}%"
    })
    
    fte_1 = actual_1['allocation_fraction'].sum()
    fte_2 = actual_2['allocation_fraction'].sum()
    summary_data.append({
        'Metric': 'Total FTE Allocated',
        'Scenario 1': f"{fte_1:.2f}",
        'Scenario 2': f"{fte_2:.2f}",
        'Delta': f"{fte_2 - fte_1:.2f}",
        'Change %': f"{((fte_2 - fte_1) / fte_1 * 100):.1f}%"
    })
    
    summary_df = pd.DataFrame(summary_data)
    print("\nSummary Comparison:")
    print(summary_df.to_string(index=False))
    
    # By Project comparison
    print("\n\nBy Project Comparison:")
    proj_1 = actual_1.groupby('project_name').agg({
        'cost': 'sum',
        'allocation_fraction': 'sum'
    }).round(2)
    proj_1.columns = ['Cost_S1', 'FTE_S1']
    
    proj_2 = actual_2.groupby('project_name').agg({
        'cost': 'sum',
        'allocation_fraction': 'sum'
    }).round(2)
    proj_2.columns = ['Cost_S2', 'FTE_S2']
    
    proj_comp = pd.concat([proj_1, proj_2], axis=1)
    proj_comp['Cost_Delta'] = proj_comp['Cost_S2'] - proj_comp['Cost_S1']
    proj_comp['FTE_Delta'] = proj_comp['FTE_S2'] - proj_comp['FTE_S1']
    print(proj_comp.to_string())
    
    # By Employee comparison
    print("\n\nBy Employee Comparison:")
    emp_1 = actual_1.groupby('employee_name').agg({
        'cost': 'sum',
        'allocation_fraction': 'sum'
    }).round(2)
    emp_1.columns = ['Cost_S1', 'FTE_S1']
    
    emp_2 = actual_2.groupby('employee_name').agg({
        'cost': 'sum',
        'allocation_fraction': 'sum'
    }).round(2)
    emp_2.columns = ['Cost_S2', 'FTE_S2']
    
    emp_comp = pd.concat([emp_1, emp_2], axis=1)
    emp_comp['Cost_Delta'] = emp_comp['Cost_S2'] - emp_comp['Cost_S1']
    emp_comp['FTE_Delta'] = emp_comp['FTE_S2'] - emp_comp['FTE_S1']
    print(emp_comp.to_string())
    
    # By Month comparison
    print("\n\nBy Month Comparison:")
    month_1 = actual_1.groupby('month').agg({
        'cost': 'sum',
        'allocation_fraction': 'sum'
    }).round(2)
    month_1.columns = ['Cost_S1', 'FTE_S1']
    
    month_2 = actual_2.groupby('month').agg({
        'cost': 'sum',
        'allocation_fraction': 'sum'
    }).round(2)
    month_2.columns = ['Cost_S2', 'FTE_S2']
    
    month_comp = pd.concat([month_1, month_2], axis=1)
    month_comp['Cost_Delta'] = month_comp['Cost_S2'] - month_comp['Cost_S1']
    month_comp['FTE_Delta'] = month_comp['FTE_S2'] - month_comp['FTE_S1']
    print(month_comp.to_string())
    
    # Detailed comparison - merged view
    print("\n\nDetailed Allocation Comparison:")
    # Merge allocations for side-by-side comparison
    actual_1_marked = actual_1.copy()
    actual_1_marked['scenario'] = 'Scenario 1'
    actual_2_marked = actual_2.copy()
    actual_2_marked['scenario'] = 'Scenario 2'
    
    # Create comparison key
    actual_1_marked['key'] = (actual_1_marked['employee_name'].astype(str) + '_' + 
                              actual_1_marked['project_name'].astype(str) + '_' + 
                              actual_1_marked['month'].astype(str))
    actual_2_marked['key'] = (actual_2_marked['employee_name'].astype(str) + '_' + 
                              actual_2_marked['project_name'].astype(str) + '_' + 
                              actual_2_marked['month'].astype(str))
    
    # Merge for comparison
    merged = pd.merge(
        actual_1_marked[['key', 'employee_name', 'project_name', 'month', 
                         'allocation_fraction', 'cost']],
        actual_2_marked[['key', 'allocation_fraction', 'cost']],
        on='key',
        how='outer',
        suffixes=('_S1', '_S2')
    )
    merged = merged.fillna(0)
    merged['FTE_Delta'] = merged['allocation_fraction_S2'] - merged['allocation_fraction_S1']
    merged['Cost_Delta'] = merged['cost_S2'] - merged['cost_S1']
    
    # Show only rows with changes
    changed = merged[(merged['FTE_Delta'].abs() > 0.001) | (merged['Cost_Delta'].abs() > 0.01)]
    if len(changed) > 0:
        print("\nChanged Allocations:")
        display_cols = ['employee_name', 'project_name', 'month', 
                       'allocation_fraction_S1', 'allocation_fraction_S2', 'FTE_Delta',
                       'cost_S1', 'cost_S2', 'Cost_Delta']
        display_cols = [c for c in display_cols if c in changed.columns]
        print(changed[display_cols].to_string(index=False))
    else:
        print("No changes in allocations between scenarios")
    
    # Write to Excel
    print("\n" + "=" * 80)
    print("Writing comparison to Excel...")
    
    with pd.ExcelWriter(str(out_path), engine='openpyxl') as writer:
        # Summary
        summary_df.to_excel(writer, sheet_name='Summary', index=False)
        
        # Scenario 1 allocations
        allocs_1_df.to_excel(writer, sheet_name='Scenario_1_All', index=False)
        actual_1.to_excel(writer, sheet_name='Scenario_1_Projects', index=False)
        avail_1 = allocs_1_df[(allocs_1_df['available_capacity'] == True) | 
                              (allocs_1_df['project_id'].isna())]
        if len(avail_1) > 0:
            avail_1.to_excel(writer, sheet_name='Scenario_1_Available', index=False)
        
        # Scenario 2 allocations
        allocs_2_df.to_excel(writer, sheet_name='Scenario_2_All', index=False)
        actual_2.to_excel(writer, sheet_name='Scenario_2_Projects', index=False)
        avail_2 = allocs_2_df[(allocs_2_df['available_capacity'] == True) | 
                              (allocs_2_df['project_id'].isna())]
        if len(avail_2) > 0:
            avail_2.to_excel(writer, sheet_name='Scenario_2_Available', index=False)
        
        # Comparisons
        proj_comp.to_excel(writer, sheet_name='Comparison_By_Project', index=True)
        emp_comp.to_excel(writer, sheet_name='Comparison_By_Employee', index=True)
        month_comp.to_excel(writer, sheet_name='Comparison_By_Month', index=True)
        
        if len(changed) > 0:
            changed[display_cols].to_excel(writer, sheet_name='Changed_Allocations', index=False)
        
        # Original data
        employees.to_excel(writer, sheet_name='Employees', index=False)
        projects.to_excel(writer, sheet_name='Projects_Original', index=False)
        projects_2.to_excel(writer, sheet_name='Projects_Scenario2', index=False)
    
    print(f"✓ Comparison written to: {out_path}")
    
else:
    print("Error: Could not generate allocations for comparison")

print("\n" + "=" * 80)
print("Comparison complete!")
print("=" * 80)

