#!/usr/bin/env python3
"""
Create Excel file with multiple tabs:
- Transactions tab: All raw transaction data
- P&L Summary tab: Comprehensive profit/loss analysis
- Fund Performance tab: Fund-by-fund breakdown
"""

import pandas as pd
import numpy as np
from datetime import datetime
import sys
import os

def load_transactions(csv_file):
    """Load transactions from CSV"""
    try:
        df = pd.read_csv(csv_file)
        df['date'] = pd.to_datetime(df['date'])
        df['settlement_date'] = pd.to_datetime(df['settlement_date'])
        return df
    except Exception as e:
        print(f"Error loading CSV: {e}")
        return None

def calculate_fund_summary(df):
    """Calculate fund-by-fund summary"""
    fund_summary = []
    
    for isin in df['isin'].unique():
        fund_df = df[df['isin'] == isin].copy()
        fund_name = fund_df['fund_name'].iloc[0]
        
        buys = fund_df[fund_df['action'] == 'BUY']
        sells = fund_df[fund_df['action'] == 'SELL']
        
        total_invested = buys['amount'].sum()
        total_received = sells['amount'].sum() if not sells.empty else 0
        net_pnl = total_received - total_invested
        return_pct = (net_pnl / total_invested * 100) if total_invested > 0 else 0
        
        total_bought = buys['quantity'].sum()
        total_sold = sells['quantity'].sum() if not sells.empty else 0
        remaining_position = total_bought - total_sold
        
        avg_buy_price = (buys['quantity'] * buys['price']).sum() / total_bought if total_bought > 0 else 0
        avg_sell_price = (sells['quantity'] * sells['price']).sum() / total_sold if total_sold > 0 else 0
        
        fund_summary.append({
            'Fund Name': fund_name,
            'ISIN': isin,
            'Total Invested (£)': total_invested,
            'Total Received (£)': total_received,
            'Net P&L (£)': net_pnl,
            'Return (%)': return_pct,
            'Shares Bought': total_bought,
            'Shares Sold': total_sold,
            'Remaining Position': remaining_position,
            'Avg Buy Price (£)': avg_buy_price,
            'Avg Sell Price (£)': avg_sell_price if avg_sell_price > 0 else 'N/A',
            'Transaction Count': len(fund_df),
            'First Purchase': buys['date'].min().strftime('%Y-%m-%d'),
            'Last Purchase': buys['date'].max().strftime('%Y-%m-%d'),
            'Status': 'Liquidated' if remaining_position == 0 else 'Holding'
        })
    
    return pd.DataFrame(fund_summary)

def create_portfolio_summary(df):
    """Create overall portfolio summary"""
    total_invested = df[df['action'] == 'BUY']['amount'].sum()
    total_received = df[df['action'] == 'SELL']['amount'].sum()
    net_cash_flow = total_received - total_invested
    total_return_pct = (net_cash_flow / total_invested * 100) if total_invested > 0 else 0
    
    buy_count = len(df[df['action'] == 'BUY'])
    sell_count = len(df[df['action'] == 'SELL'])
    
    date_range_start = df['date'].min().strftime('%Y-%m-%d')
    date_range_end = df['date'].max().strftime('%Y-%m-%d')
    
    summary_data = {
        'Metric': [
            'Total Amount Invested (£)',
            'Total Amount Received (£)',
            'Net Cash Flow (£)',
            'Total Return (%)',
            'Total Transactions',
            'Buy Transactions',
            'Sell Transactions',
            'Unique Funds Traded',
            'Investment Period Start',
            'Investment Period End',
            'Portfolio Status',
            'Analysis Date'
        ],
        'Value': [
            f"{total_invested:,.2f}",
            f"{total_received:,.2f}",
            f"{net_cash_flow:,.2f}",
            f"{total_return_pct:.2f}%",
            len(df),
            buy_count,
            sell_count,
            df['isin'].nunique(),
            date_range_start,
            date_range_end,
            '100% Liquidated',
            datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        ]
    }
    
    return pd.DataFrame(summary_data)

def create_transaction_summary(df):
    """Create monthly transaction summary"""
    df['year_month'] = df['date'].dt.to_period('M')
    
    monthly_summary = df.groupby(['year_month', 'action']).agg({
        'amount': 'sum',
        'quantity': 'sum',
        'isin': 'nunique'
    }).reset_index()
    
    monthly_summary['year_month'] = monthly_summary['year_month'].astype(str)
    monthly_summary = monthly_summary.rename(columns={
        'year_month': 'Month',
        'action': 'Action',
        'amount': 'Total Amount (£)',
        'quantity': 'Total Shares',
        'isin': 'Funds Traded'
    })
    
    return monthly_summary

def format_excel_file(writer, df_transactions, df_summary, df_fund_performance, df_monthly):
    """Format the Excel file with styling"""
    
    # Write transactions tab
    df_transactions.to_excel(writer, sheet_name='Transactions', index=False)
    
    # Write portfolio summary tab
    df_summary.to_excel(writer, sheet_name='Portfolio Summary', index=False)
    
    # Write fund performance tab
    df_fund_performance.to_excel(writer, sheet_name='Fund Performance', index=False)
    
    # Write monthly summary tab
    df_monthly.to_excel(writer, sheet_name='Monthly Summary', index=False)
    
    # Get workbook and worksheets for formatting
    workbook = writer.book
    
    # Define formats
    money_format = workbook.add_format({'num_format': '£#,##0.00'})
    percent_format = workbook.add_format({'num_format': '0.00%'})
    date_format = workbook.add_format({'num_format': 'yyyy-mm-dd'})
    header_format = workbook.add_format({
        'bold': True,
        'bg_color': '#4472C4',
        'font_color': 'white',
        'border': 1
    })
    
    # Format transactions sheet
    transactions_sheet = writer.sheets['Transactions']
    transactions_sheet.set_column('A:A', 12, date_format)  # date
    transactions_sheet.set_column('B:B', 12, date_format)  # settlement_date
    transactions_sheet.set_column('C:C', 8)   # action
    transactions_sheet.set_column('D:D', 35)  # fund_name
    transactions_sheet.set_column('E:E', 15)  # isin
    transactions_sheet.set_column('F:F', 15)  # symbol
    transactions_sheet.set_column('G:G', 12)  # quantity
    transactions_sheet.set_column('H:H', 12, money_format)  # price
    transactions_sheet.set_column('I:I', 12, money_format)  # amount
    transactions_sheet.set_column('J:J', 15)  # broker
    
    # Format headers
    for col_num, value in enumerate(df_transactions.columns.values):
        transactions_sheet.write(0, col_num, value, header_format)
    
    # Format portfolio summary sheet
    summary_sheet = writer.sheets['Portfolio Summary']
    summary_sheet.set_column('A:A', 30)  # Metric
    summary_sheet.set_column('B:B', 20)  # Value
    
    # Format headers
    for col_num, value in enumerate(df_summary.columns.values):
        summary_sheet.write(0, col_num, value, header_format)
    
    # Format fund performance sheet
    fund_sheet = writer.sheets['Fund Performance']
    fund_sheet.set_column('A:A', 35)  # Fund Name
    fund_sheet.set_column('B:B', 15)  # ISIN
    fund_sheet.set_column('C:C', 15, money_format)  # Total Invested
    fund_sheet.set_column('D:D', 15, money_format)  # Total Received
    fund_sheet.set_column('E:E', 12, money_format)  # Net P&L
    fund_sheet.set_column('F:F', 10, percent_format)  # Return %
    fund_sheet.set_column('G:H', 12)  # Shares
    fund_sheet.set_column('I:I', 15)  # Remaining Position
    fund_sheet.set_column('J:K', 12, money_format)  # Avg Prices
    fund_sheet.set_column('L:L', 10)  # Transaction Count
    fund_sheet.set_column('M:N', 12, date_format)  # Dates
    fund_sheet.set_column('O:O', 12)  # Status
    
    # Format headers
    for col_num, value in enumerate(df_fund_performance.columns.values):
        fund_sheet.write(0, col_num, value, header_format)
    
    # Format monthly summary sheet
    monthly_sheet = writer.sheets['Monthly Summary']
    monthly_sheet.set_column('A:A', 12)  # Month
    monthly_sheet.set_column('B:B', 8)   # Action
    monthly_sheet.set_column('C:C', 15, money_format)  # Total Amount
    monthly_sheet.set_column('D:D', 12)  # Total Shares
    monthly_sheet.set_column('E:E', 12)  # Funds Traded
    
    # Format headers
    for col_num, value in enumerate(df_monthly.columns.values):
        monthly_sheet.write(0, col_num, value, header_format)

def main():
    # Find the most recent transactions CSV
    import glob
    csv_files = glob.glob("gia_transactions_*.csv")
    if not csv_files:
        print("No transaction CSV files found!")
        return
    
    latest_csv = max(csv_files, key=os.path.getctime)
    print(f"Processing: {latest_csv}")
    
    # Load data
    df = load_transactions(latest_csv)
    if df is None:
        return
    
    print(f"Loaded {len(df)} transactions")
    
    # Prepare data for Excel tabs
    print("Creating portfolio summary...")
    df_summary = create_portfolio_summary(df)
    
    print("Creating fund performance analysis...")
    df_fund_performance = calculate_fund_summary(df)
    
    print("Creating monthly transaction summary...")
    df_monthly = create_transaction_summary(df)
    
    # Prepare transactions data (clean up for Excel)
    df_transactions = df.copy()
    df_transactions['date'] = df_transactions['date'].dt.strftime('%Y-%m-%d')
    df_transactions['settlement_date'] = df_transactions['settlement_date'].dt.strftime('%Y-%m-%d')
    
    # Create Excel file
    excel_filename = f"GIA_Trading_Analysis_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
    
    print(f"Creating Excel file: {excel_filename}")
    
    try:
        with pd.ExcelWriter(excel_filename, engine='xlsxwriter') as writer:
            format_excel_file(writer, df_transactions, df_summary, df_fund_performance, df_monthly)
        
        print(f"✅ Success! Excel file created: {excel_filename}")
        
        # Print summary
        print("\n📊 Excel File Contents:")
        print("  📄 Transactions - All 100 raw transactions")
        print("  📈 Portfolio Summary - Overall performance metrics")
        print("  🏆 Fund Performance - Fund-by-fund P&L analysis")
        print("  📅 Monthly Summary - Monthly transaction breakdown")
        
    except Exception as e:
        print(f"Error creating Excel file: {e}")
        print("Make sure you have xlsxwriter installed: pip install xlsxwriter")

if __name__ == "__main__":
    main()
