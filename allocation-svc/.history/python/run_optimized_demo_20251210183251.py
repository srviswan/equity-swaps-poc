"""run_optimized_demo.py - Demo with fully optimized allocator
Compares basic vs enhanced vs fully optimized allocators
"""
import pandas as pd
import json
from pathlib import Path
from allocate import simple_fractional_allocator
from allocate_enhanced import enhanced_fractional_allocator
from allocate_fully_optimized import fully_optimized_allocator
from excel_io import create_template

BASE = Path(__file__).resolve().parent
excel_path = BASE.parent / 'excel' / 'budget_planner_template.xlsx'
out_path_basic = BASE.parent / 'excel' / 'allocations_basic.xlsx'
out_path_enhanced = BASE.parent / 'excel' / 'allocations_enhanced.xlsx'
out_path_optimized = BASE.parent / 'excel' / 'allocations_fully_optimized.xlsx'

# Create template if not exists
if not excel_path.exists():
    create_template(str(excel_path))

# Load data
xls = pd.ExcelFile(str(excel_path))
employees = pd.read_excel(xls, 'Employees')
projects = pd.read_excel(xls, 'Projects')
scenarios = pd.read_excel(xls, 'Scenarios')

scenario_id = 1
global_start = projects['start_month'].min()
global_end = projects['end_month'].max()

print("=" * 80)
print("ALLOCATION OPTIMIZER COMPARISON")
print("=" * 80)

# 1. Basic allocator
print("\n1. Running BASIC allocator (cost minimization only)...")
allocs_basic = simple_fractional_allocator(employees, projects, scenario_id, global_start=global_start, global_end=global_end)
allocs_basic_df = pd.DataFrame(allocs_basic)
print(f"   Generated {len(allocs_basic)} allocations")
if len(allocs_basic) > 0:
    print(f"   Total cost: ${allocs_basic_df['cost'].sum():,.2f}")
    print(f"   Avg allocation size: {allocs_basic_df['allocation_fraction'].mean():.3f} FTE")

# 2. Enhanced allocator
print("\n2. Running ENHANCED allocator (multi-objective)...")
allocs_enhanced = enhanced_fractional_allocator(
    employees, projects, scenario_id, 
    global_start=global_start, global_end=global_end,
    weights={
        'cost_weight': 0.5,
        'skill_weight': 0.2,
        'fragmentation_weight': 0.1,
        'continuity_weight': 0.1,
        'balance_weight': 0.1
    }
)
allocs_enhanced_df = pd.DataFrame(allocs_enhanced)
print(f"   Generated {len(allocs_enhanced)} allocations")
if len(allocs_enhanced) > 0:
    print(f"   Total cost: ${allocs_enhanced_df['cost'].sum():,.2f}")
    print(f"   Avg allocation size: {allocs_enhanced_df['allocation_fraction'].mean():.3f} FTE")

# 3. Fully optimized allocator
print("\n3. Running FULLY OPTIMIZED allocator (all enhancements)...")
allocs_optimized = fully_optimized_allocator(
    employees, projects, scenario_id,
    global_start=global_start, global_end=global_end,
    weights={
        'cost_weight': 0.35,
        'skill_weight': 0.20,
        'fragmentation_weight': 0.10,
        'continuity_weight': 0.10,
        'balance_weight': 0.10,
        'preference_weight': 0.05,
        'diversity_weight': 0.05,
        'leveling_weight': 0.05
    },
    config={
        'max_employee_per_project': 0.8,
        'min_team_size': 1,
        'allow_skill_development': True,
        'skill_dev_max_fte': 0.2,
        'discrete_allocations': False,
        'budget_flexibility': True,
        'enable_team_diversity': True,
        'enable_employee_preferences': True
    }
)
allocs_optimized_df = pd.DataFrame(allocs_optimized)
print(f"   Generated {len(allocs_optimized)} allocations")
if len(allocs_optimized) > 0:
    print(f"   Total cost: ${allocs_optimized_df['cost'].sum():,.2f}")
    print(f"   Avg allocation size: {allocs_optimized_df['allocation_fraction'].mean():.3f} FTE")
    skill_dev = allocs_optimized_df.get('skill_development', pd.Series([False] * len(allocs_optimized_df)))
    if skill_dev.any():
        print(f"   Skill development allocations: {skill_dev.sum()}")

# Comparison summary
print("\n" + "=" * 80)
print("COMPARISON SUMMARY")
print("=" * 80)

comparison_data = []
if len(allocs_basic) > 0:
    comparison_data.append({
        'Allocator': 'Basic',
        'Total Cost': allocs_basic_df['cost'].sum(),
        'Allocations': len(allocs_basic),
        'Avg Size (FTE)': allocs_basic_df['allocation_fraction'].mean(),
        'Features': 'Cost only'
    })

if len(allocs_enhanced) > 0:
    comparison_data.append({
        'Allocator': 'Enhanced',
        'Total Cost': allocs_enhanced_df['cost'].sum(),
        'Allocations': len(allocs_enhanced),
        'Avg Size (FTE)': allocs_enhanced_df['allocation_fraction'].mean(),
        'Features': 'Cost, Skills, Fragmentation, Continuity, Balance'
    })

if len(allocs_optimized) > 0:
    comparison_data.append({
        'Allocator': 'Fully Optimized',
        'Total Cost': allocs_optimized_df['cost'].sum(),
        'Allocations': len(allocs_optimized),
        'Avg Size (FTE)': allocs_optimized_df['allocation_fraction'].mean(),
        'Features': 'All 12 optimizations'
    })

if comparison_data:
    comparison_df = pd.DataFrame(comparison_data)
    print(comparison_df.to_string(index=False))

# Write outputs
print("\n" + "=" * 80)
print("Writing output files...")

if len(allocs_basic) > 0:
    allocs_basic_actual = allocs_basic_df[allocs_basic_df['project_id'].notna()].copy()
    allocs_basic_available = allocs_basic_df[(allocs_basic_df['available_capacity'] == True) | (allocs_basic_df['project_id'].isna())].copy()
    with pd.ExcelWriter(str(out_path_basic), engine='openpyxl') as writer:
        allocs_basic_df.to_excel(writer, sheet_name='Allocations', index=False)
        if len(allocs_basic_actual) > 0:
            allocs_basic_actual.to_excel(writer, sheet_name='Project_Allocations', index=False)
        if len(allocs_basic_available) > 0:
            allocs_basic_available.to_excel(writer, sheet_name='Available_Capacity', index=False)
        employees.to_excel(writer, sheet_name='Employees', index=False)
        projects.to_excel(writer, sheet_name='Projects', index=False)
    print(f"✓ Basic: {out_path_basic}")

if len(allocs_enhanced) > 0:
    allocs_enhanced_actual = allocs_enhanced_df[allocs_enhanced_df['project_id'].notna()].copy()
    allocs_enhanced_available = allocs_enhanced_df[(allocs_enhanced_df['available_capacity'] == True) | (allocs_enhanced_df['project_id'].isna())].copy()
    with pd.ExcelWriter(str(out_path_enhanced), engine='openpyxl') as writer:
        allocs_enhanced_df.to_excel(writer, sheet_name='Allocations', index=False)
        if len(allocs_enhanced_actual) > 0:
            allocs_enhanced_actual.to_excel(writer, sheet_name='Project_Allocations', index=False)
        if len(allocs_enhanced_available) > 0:
            allocs_enhanced_available.to_excel(writer, sheet_name='Available_Capacity', index=False)
        employees.to_excel(writer, sheet_name='Employees', index=False)
        projects.to_excel(writer, sheet_name='Projects', index=False)
    print(f"✓ Enhanced: {out_path_enhanced}")

if len(allocs_optimized) > 0:
    allocs_optimized_actual = allocs_optimized_df[allocs_optimized_df['project_id'].notna()].copy()
    allocs_optimized_available = allocs_optimized_df[(allocs_optimized_df['available_capacity'] == True) | (allocs_optimized_df['project_id'].isna())].copy()
    with pd.ExcelWriter(str(out_path_optimized), engine='openpyxl') as writer:
        allocs_optimized_df.to_excel(writer, sheet_name='Allocations', index=False)
        if len(allocs_optimized_actual) > 0:
            allocs_optimized_actual.to_excel(writer, sheet_name='Project_Allocations', index=False)
        if len(allocs_optimized_available) > 0:
            allocs_optimized_available.to_excel(writer, sheet_name='Available_Capacity', index=False)
        employees.to_excel(writer, sheet_name='Employees', index=False)
        projects.to_excel(writer, sheet_name='Projects', index=False)
    print(f"✓ Fully Optimized: {out_path_optimized}")

print("\n" + "=" * 80)
print("Demo complete!")
print("=" * 80)

