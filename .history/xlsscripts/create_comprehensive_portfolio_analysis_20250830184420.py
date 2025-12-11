#!/usr/bin/env python3
"""
Create comprehensive Excel analysis with actual portfolio reference numbers
for both GIA and ISA accounts, including sub-portfolios within ISA.
"""

import pandas as pd
import numpy as np
from datetime import datetime
import sys
import os
import glob

def load_transactions_with_portfolio_ref(csv_file):
    """Load transactions from CSV, handling portfolio reference column"""
    try:
        df = pd.read_csv(csv_file)
        df['date'] = pd.to_datetime(df['date'])
        if 'settlement_date' in df.columns:
            df['settlement_date'] = pd.to_datetime(df['settlement_date'])
        
        # Ensure portfolio_reference column exists
        if 'portfolio_reference' not in df.columns:
            if 'portfolio' in df.columns:
                df['portfolio_reference'] = df['portfolio']
            else:
                # Infer from filename
                if 'gia' in csv_file.lower():
                    df['portfolio_reference'] = 'IP00839191'
                else:
                    df['portfolio_reference'] = 'IP00465009'  # Default ISA
        
        return df
    except Exception as e:
        print(f"Error loading CSV: {e}")
        return None

def calculate_fund_summary_by_portfolio(df):
    """Calculate fund-by-fund summary with portfolio breakdown"""
    fund_summary = []
    
    for portfolio_ref in df['portfolio_reference'].unique():
        portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
        
        for isin in portfolio_df['isin'].unique():
            fund_df = portfolio_df[portfolio_df['isin'] == isin].copy()
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
            
            fund_data = {
                'Portfolio Reference': portfolio_ref,
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
            }
            
            fund_summary.append(fund_data)
    
    return pd.DataFrame(fund_summary)

def create_portfolio_summary_by_ref(df):
    """Create portfolio summary grouped by portfolio reference"""
    summary_data = []
    
    for portfolio_ref in sorted(df['portfolio_reference'].unique()):
        portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
        
        total_invested = portfolio_df[portfolio_df['action'] == 'BUY']['amount'].sum()
        total_received = portfolio_df[portfolio_df['action'] == 'SELL']['amount'].sum()
        net_cash_flow = total_received - total_invested
        total_return_pct = (net_cash_flow / total_invested * 100) if total_invested > 0 else 0
        
        buy_count = len(portfolio_df[portfolio_df['action'] == 'BUY'])
        sell_count = len(portfolio_df[portfolio_df['action'] == 'SELL'])
        
        date_range_start = portfolio_df['date'].min().strftime('%Y-%m-%d')
        date_range_end = portfolio_df['date'].max().strftime('%Y-%m-%d')
        
        # Determine portfolio status
        remaining_positions = 0
        for isin in portfolio_df['isin'].unique():
            fund_df = portfolio_df[portfolio_df['isin'] == isin]
            total_bought = fund_df[fund_df['action'] == 'BUY']['quantity'].sum()
            total_sold = fund_df[fund_df['action'] == 'SELL']['quantity'].sum()
            if total_bought > total_sold:
                remaining_positions += 1
        
        portfolio_status = '100% Liquidated' if remaining_positions == 0 else f'{remaining_positions} funds still held'
        
        # Determine account type
        account_type = 'GIA Account' if portfolio_ref == 'IP00839191' else 'ISA Account'
        
        summary_data.append({
            'Portfolio Reference': portfolio_ref,
            'Account Type': account_type,
            'Total Invested (£)': f"{total_invested:,.2f}",
            'Total Received (£)': f"{total_received:,.2f}",
            'Net Cash Flow (£)': f"{net_cash_flow:,.2f}",
            'Total Return (%)': f"{total_return_pct:.2f}%",
            'Total Transactions': len(portfolio_df),
            'Buy Transactions': buy_count,
            'Sell Transactions': sell_count,
            'Unique Funds': portfolio_df['isin'].nunique(),
            'Period Start': date_range_start,
            'Period End': date_range_end,
            'Portfolio Status': portfolio_status
        })
    
    return pd.DataFrame(summary_data)

def create_monthly_summary_by_portfolio(df):
    """Create monthly transaction summary by portfolio"""
    df['year_month'] = df['date'].dt.to_period('M')
    
    monthly_summary = df.groupby(['portfolio_reference', 'year_month', 'action']).agg({
        'amount': 'sum',
        'quantity': 'sum',
        'isin': 'nunique'
    }).reset_index()
    
    monthly_summary['year_month'] = monthly_summary['year_month'].astype(str)
    monthly_summary = monthly_summary.rename(columns={
        'portfolio_reference': 'Portfolio Reference',
        'year_month': 'Month',
        'action': 'Action',
        'amount': 'Total Amount (£)',
        'quantity': 'Total Shares',
        'isin': 'Funds Traded'
    })
    
    return monthly_summary

def format_comprehensive_excel(writer, df_transactions, df_portfolio_summary, df_fund_performance, df_monthly):
    """Format the comprehensive Excel file with enhanced styling"""
    
    # Write all tabs
    df_transactions.to_excel(writer, sheet_name='All Transactions', index=False)
    df_portfolio_summary.to_excel(writer, sheet_name='Portfolio Summary', index=False)
    df_fund_performance.to_excel(writer, sheet_name='Fund Performance', index=False)
    df_monthly.to_excel(writer, sheet_name='Monthly Summary', index=False)
    
    # Get workbook for formatting
    workbook = writer.book
    
    # Define formats
    money_format = workbook.add_format({'num_format': '£#,##0.00'})
    percent_format = workbook.add_format({'num_format': '0.00%'})
    date_format = workbook.add_format({'num_format': 'yyyy-mm-dd'})
    header_format = workbook.add_format({
        'bold': True,
        'bg_color': '#2E75B6',
        'font_color': 'white',
        'border': 1,
        'align': 'center'
    })
    portfolio_gia_format = workbook.add_format({'bg_color': '#E7F3FF'})  # Light blue for GIA
    portfolio_isa_format = workbook.add_format({'bg_color': '#F0F8E7'})  # Light green for ISA
    
    # Format All Transactions sheet
    transactions_sheet = writer.sheets['All Transactions']
    transactions_sheet.set_column('A:A', 15)  # portfolio_reference
    transactions_sheet.set_column('B:B', 12, date_format)  # date
    transactions_sheet.set_column('C:C', 12, date_format)  # settlement_date
    transactions_sheet.set_column('D:D', 8)   # action
    transactions_sheet.set_column('E:E', 35)  # fund_name
    transactions_sheet.set_column('F:F', 15)  # isin
    transactions_sheet.set_column('G:G', 15)  # symbol
    transactions_sheet.set_column('H:H', 12)  # quantity
    transactions_sheet.set_column('I:I', 12, money_format)  # price
    transactions_sheet.set_column('J:J', 12, money_format)  # amount
    transactions_sheet.set_column('K:K', 15)  # broker
    
    # Color-code rows by portfolio
    for row_num in range(1, len(df_transactions) + 1):
        portfolio_ref = df_transactions.iloc[row_num - 1]['portfolio_reference']
        row_format = portfolio_gia_format if portfolio_ref == 'IP00839191' else portfolio_isa_format
        for col_num in range(len(df_transactions.columns)):
            transactions_sheet.write(row_num, col_num, df_transactions.iloc[row_num - 1, col_num], row_format)
    
    # Format headers
    for col_num, value in enumerate(df_transactions.columns.values):
        transactions_sheet.write(0, col_num, value, header_format)
    
    # Format Portfolio Summary sheet
    summary_sheet = writer.sheets['Portfolio Summary']
    summary_sheet.set_column('A:A', 15)  # Portfolio Reference
    summary_sheet.set_column('B:B', 15)  # Account Type
    summary_sheet.set_column('C:E', 15)  # Money columns
    summary_sheet.set_column('F:F', 12)  # Return %
    summary_sheet.set_column('G:J', 12)  # Count columns
    summary_sheet.set_column('K:L', 12, date_format)  # Dates
    summary_sheet.set_column('M:M', 20)  # Status
    
    # Format headers
    for col_num, value in enumerate(df_portfolio_summary.columns.values):
        summary_sheet.write(0, col_num, value, header_format)
    
    # Format Fund Performance sheet
    fund_sheet = writer.sheets['Fund Performance']
    fund_sheet.set_column('A:A', 15)  # Portfolio Reference
    fund_sheet.set_column('B:B', 35)  # Fund Name
    fund_sheet.set_column('C:C', 15)  # ISIN
    fund_sheet.set_column('D:F', 15, money_format)  # Money columns
    fund_sheet.set_column('G:G', 10, percent_format)  # Return %
    fund_sheet.set_column('H:J', 12)  # Share columns
    fund_sheet.set_column('K:L', 12, money_format)  # Price columns
    fund_sheet.set_column('M:M', 10)  # Transaction count
    fund_sheet.set_column('N:O', 12, date_format)  # Dates
    fund_sheet.set_column('P:P', 12)  # Status
    
    # Format headers
    for col_num, value in enumerate(df_fund_performance.columns.values):
        fund_sheet.write(0, col_num, value, header_format)
    
    # Format Monthly Summary sheet
    monthly_sheet = writer.sheets['Monthly Summary']
    monthly_sheet.set_column('A:A', 15)  # Portfolio Reference
    monthly_sheet.set_column('B:B', 12)  # Month
    monthly_sheet.set_column('C:C', 8)   # Action
    monthly_sheet.set_column('D:D', 15, money_format)  # Total Amount
    monthly_sheet.set_column('E:F', 12)  # Shares and Funds
    
    # Format headers
    for col_num, value in enumerate(df_monthly.columns.values):
        monthly_sheet.write(0, col_num, value, header_format)

def create_comprehensive_analysis():
    """Create comprehensive portfolio analysis with all reference numbers"""
    print("🔍 CREATING COMPREHENSIVE PORTFOLIO ANALYSIS")
    print("=" * 60)
    
    # Load all available transaction data
    all_transactions = []
    
    # Load GIA transactions
    gia_files = glob.glob("gia_transactions_*.csv")
    if gia_files:
        latest_gia = max(gia_files, key=os.path.getctime)
        print(f"📊 Loading GIA data: {latest_gia}")
        gia_df = load_transactions_with_portfolio_ref(latest_gia)
        if gia_df is not None:
            gia_df['portfolio_reference'] = 'IP00839191'  # Ensure correct GIA reference
            all_transactions.append(gia_df)
            print(f"   ✅ GIA: {len(gia_df)} transactions")
    
    # Load ISA transactions with portfolio references
    isa_files = glob.glob("isa_transactions_with_portfolios_*.csv")
    if isa_files:
        latest_isa = max(isa_files, key=os.path.getctime)
        print(f"📊 Loading ISA data with portfolio refs: {latest_isa}")
        isa_df = load_transactions_with_portfolio_ref(latest_isa)
        if isa_df is not None:
            all_transactions.append(isa_df)
            portfolio_counts = isa_df['portfolio_reference'].value_counts()
            for portfolio, count in portfolio_counts.items():
                print(f"   ✅ {portfolio}: {count} transactions")
    
    if not all_transactions:
        print("❌ No transaction data found!")
        return None
    
    # Combine all transactions
    combined_df = pd.concat(all_transactions, ignore_index=True)
    print(f"\n📊 Total combined transactions: {len(combined_df)}")
    
    # Prepare data for Excel
    print("Creating comprehensive analysis...")
    df_portfolio_summary = create_portfolio_summary_by_ref(combined_df)
    df_fund_performance = calculate_fund_summary_by_portfolio(combined_df)
    df_monthly = create_monthly_summary_by_portfolio(combined_df)
    
    # Prepare transactions data (clean dates for Excel)
    df_transactions = combined_df.copy()
    df_transactions['date'] = df_transactions['date'].dt.strftime('%Y-%m-%d')
    if 'settlement_date' in df_transactions.columns:
        df_transactions['settlement_date'] = df_transactions['settlement_date'].dt.strftime('%Y-%m-%d')
    
    # Reorder columns for better display
    base_cols = ['portfolio_reference', 'date', 'settlement_date', 'action', 'fund_name', 'isin', 'symbol', 'quantity', 'price', 'amount', 'broker']
    extra_cols = [col for col in df_transactions.columns if col not in base_cols]
    df_transactions = df_transactions[base_cols + extra_cols]
    
    # Create comprehensive Excel file
    excel_filename = f"Comprehensive_Portfolio_Analysis_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
    print(f"Creating comprehensive Excel file: {excel_filename}")
    
    try:
        with pd.ExcelWriter(excel_filename, engine='xlsxwriter') as writer:
            format_comprehensive_excel(writer, df_transactions, df_portfolio_summary, df_fund_performance, df_monthly)
        
        print(f"✅ Success! Comprehensive analysis created: {excel_filename}")
        
        # Print summary
        print("\n📊 COMPREHENSIVE PORTFOLIO ANALYSIS COMPLETE!")
        print("=" * 60)
        print(f"📄 All Transactions: {len(df_transactions)} records across all portfolios")
        print(f"🏦 Portfolio Summary: {len(df_portfolio_summary)} portfolio accounts")
        print(f"🏆 Fund Performance: {len(df_fund_performance)} fund positions")
        print(f"📅 Monthly Summary: {len(df_monthly)} monthly data points")
        
        print("\n💼 Portfolio References Included:")
        for portfolio in sorted(combined_df['portfolio_reference'].unique()):
            count = len(combined_df[combined_df['portfolio_reference'] == portfolio])
            account_type = 'GIA Account' if portfolio == 'IP00839191' else 'ISA Account'
            print(f"   📊 {portfolio} ({account_type}): {count} transactions")
        
        return excel_filename
        
    except Exception as e:
        print(f"Error creating comprehensive Excel file: {e}")
        return None

if __name__ == "__main__":
    create_comprehensive_analysis()
