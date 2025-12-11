"""run_demo.py - demo that runs allocator with local sample Excel template
This script uses the excel template to load data, run allocator, and write allocations back to an Excel output.
"""
import pandas as pd, json
from pathlib import Path
from allocate_fully_optimized import fully_optimized_allocator
from excel_io import create_template

BASE = Path(__file__).resolve().parent
excel_path = BASE.parent / 'excel' / 'budget_planner_template.xlsx'
out_path = BASE.parent / 'excel' / 'budget_planner_allocations.xlsx'

# create template if not exists
if not excel_path.exists():
    create_template(str(excel_path))

# load
xls = pd.ExcelFile(str(excel_path))
employees = pd.read_excel(xls, 'Employees')
projects = pd.read_excel(xls, 'Projects')
scenarios = pd.read_excel(xls, 'Scenarios')

# choose scenario id 1
scenario_id = 1
# run allocator for all projects between min(start_month) and max(end_month)
global_start = projects['start_month'].min()
global_end = projects['end_month'].max()

allocs = fully_optimized_allocator(
    employees, projects, scenario_id,
    global_start=global_start, global_end=global_end
)
allocs_df = pd.DataFrame(allocs)

# Separate actual allocations from available capacity
actual_allocations = allocs_df[allocs_df['project_id'].notna()].copy()
available_capacity = allocs_df[(allocs_df['available_capacity'] == True) | (allocs_df['project_id'].isna())].copy()

print(f'\nAllocation Summary:')
print(f'  Actual allocations: {len(actual_allocations)}')
print(f'  Total cost: ${actual_allocations["cost"].sum():,.2f}')
print(f'  Available capacity records: {len(available_capacity)}')
if len(available_capacity) > 0:
    print(f'  Total available FTE: {available_capacity["allocation_fraction"].sum():.2f}')

# write output Excel
with pd.ExcelWriter(str(out_path), engine='openpyxl') as writer:
    allocs_df.to_excel(writer, sheet_name='Allocations', index=False)
    if len(actual_allocations) > 0:
        actual_allocations.to_excel(writer, sheet_name='Project_Allocations', index=False)
    if len(available_capacity) > 0:
        available_capacity.to_excel(writer, sheet_name='Available_Capacity', index=False)
    employees.to_excel(writer, sheet_name='Employees', index=False)
    projects.to_excel(writer, sheet_name='Projects', index=False)

print('Demo run complete. Output written to', out_path)
