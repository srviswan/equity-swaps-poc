"""db.py - SQL Server helper (pyodbc) for Budget Planner"""
import pyodbc
import pandas as pd

def connect(server='localhost\\SQLEXPRESS', database='budgetdb', trusted=True, user=None, password=None):
    if trusted:
        conn_str = f"DRIVER={{ODBC Driver 17 for SQL Server}};SERVER={server};DATABASE={database};Trusted_Connection=yes;"
    else:
        conn_str = f"DRIVER={{ODBC Driver 17 for SQL Server}};SERVER={server};DATABASE={database};UID={user};PWD={password};"
    return pyodbc.connect(conn_str, autocommit=True)

def load_table(conn, table_name):
    return pd.read_sql(f"SELECT * FROM [{table_name}]", conn)

def write_allocations(conn, allocations):
    """Write allocations (list of dicts or DataFrame) into allocation table using executemany"""
    df = allocations if hasattr(allocations, 'to_dict') else pd.DataFrame(allocations)
    cur = conn.cursor()
    sql = "INSERT INTO allocation (scenario_id, employee_id, project_id, month, allocation_fraction, cost) VALUES (?,?,?,?,?,?)"
    data = [(int(row['scenario_id']), int(row['employee_id']), int(row['project_id']), row['month'], float(row['allocation_fraction']), float(row['cost'])) for idx,row in df.iterrows()]
    cur.fast_executemany = True
    cur.executemany(sql, data)
    cur.commit()
    cur.close()

