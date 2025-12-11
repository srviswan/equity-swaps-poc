#!/usr/bin/env python3
"""
Create the FINAL comprehensive Excel analysis with ALL 5 portfolio accounts:
1 GIA + 4 ISA portfolios with complete transaction data and analysis.
"""

import pandas as pd
import numpy as np
from datetime import datetime
import sys
import os
import glob

def load_all_portfolio_data():
    """Load all portfolio data from GIA and complete ISA files"""
    all_transactions = []
    
    # Load GIA transactions
    print("📊 Loading GIA data...")
    gia_files = glob.glob("gia_transactions_*.csv")
    if gia_files:
        latest_gia = max(gia_files, key=os.path.getctime)
        print(f"   Loading: {latest_gia}")
        gia_df = pd.read_csv(latest_gia)
        gia_df['date'] = pd.to_datetime(gia_df['date'])
        gia_df['settlement_date'] = pd.to_datetime(gia_df['settlement_date'])
        gia_df['portfolio_reference'] = 'IP00839191'  # GIA reference
        gia_df['portfolio_name'] = 'GIA Account'
        all_transactions.append(gia_df)
        print(f"   ✅ GIA Account (IP00839191): {len(gia_df)} transactions")
    
    # Load complete ISA transactions
    print("📊 Loading complete ISA data...")
    isa_files = glob.glob("complete_isa_transactions_*.csv")
    if isa_files:
        latest_isa = max(isa_files, key=os.path.getctime)
        print(f"   Loading: {latest_isa}")
        isa_df = pd.read_csv(latest_isa)
        isa_df['date'] = pd.to_datetime(isa_df['date'])
        isa_df['settlement_date'] = pd.to_datetime(isa_df['settlement_date'])
        
        # Add portfolio names
        portfolio_names = {
            'IP00465009': '5 year ISA',
            'IP00824935': 'Main ISA Portfolio',
            'IP00824949': 'Managed 5 years',
            'IP00843395': 'Sree ISA Growth'
        }
        isa_df['portfolio_name'] = isa_df['portfolio_reference'].map(portfolio_names)
        
        all_transactions.append(isa_df)
        
        # Show ISA breakdown
        for portfolio_ref in sorted(isa_df['portfolio_reference'].unique()):
            count = len(isa_df[isa_df['portfolio_reference'] == portfolio_ref])
            name = portfolio_names.get(portfolio_ref, 'Unknown')
            print(f"   ✅ {name} ({portfolio_ref}): {count} transactions")
    
    if not all_transactions:
        print("❌ No transaction data found!")
        return None
    
    # Combine all data
    combined_df = pd.concat(all_transactions, ignore_index=True)
    print(f"\n🎯 TOTAL: {len(combined_df)} transactions across {combined_df['portfolio_reference'].nunique()} portfolios")
    
    return combined_df

def create_portfolio_performance_comparison(df):
    """Create detailed portfolio performance comparison"""
    comparison_data = []
    
    for portfolio_ref in sorted(df['portfolio_reference'].unique()):
        portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
        portfolio_name = portfolio_df['portfolio_name'].iloc[0]
        
        total_invested = portfolio_df[portfolio_df['action'] == 'BUY']['amount'].sum()
        total_received = portfolio_df[portfolio_df['action'] == 'SELL']['amount'].sum()
        net_cash_flow = total_received - total_invested
        total_return_pct = (net_cash_flow / total_invested * 100) if total_invested > 0 else 0
        
        buy_count = len(portfolio_df[portfolio_df['action'] == 'BUY'])
        sell_count = len(portfolio_df[portfolio_df['action'] == 'SELL'])
        
        # Calculate remaining positions
        remaining_positions = 0
        total_remaining_value = 0
        for isin in portfolio_df['isin'].unique():
            fund_df = portfolio_df[portfolio_df['isin'] == isin]
            total_bought = fund_df[fund_df['action'] == 'BUY']['quantity'].sum()
            total_sold = fund_df[fund_df['action'] == 'SELL']['quantity'].sum()
            remaining_qty = total_bought - total_sold
            if remaining_qty > 0:
                remaining_positions += 1
                # Estimate value using last known price
                last_price = fund_df['price'].iloc[-1] if not fund_df.empty else 0
                total_remaining_value += remaining_qty * last_price
        
        account_type = 'GIA' if portfolio_ref == 'IP00839191' else 'ISA'
        portfolio_status = '100% Liquidated' if remaining_positions == 0 else f'{remaining_positions} funds held'
        
        comparison_data.append({
            'Portfolio Reference': portfolio_ref,
            'Portfolio Name': portfolio_name,
            'Account Type': account_type,
            'Total Transactions': len(portfolio_df),
            'Buy Transactions': buy_count,
            'Sell Transactions': sell_count,
            'Total Invested (£)': total_invested,
            'Total Received (£)': total_received,
            'Net Cash Flow (£)': net_cash_flow,
            'Return (%)': total_return_pct,
            'Unique Funds': portfolio_df['isin'].nunique(),
            'Remaining Positions': remaining_positions,
            'Est. Remaining Value (£)': total_remaining_value,
            'Portfolio Status': portfolio_status,
            'First Transaction': portfolio_df['date'].min().strftime('%Y-%m-%d'),
            'Last Transaction': portfolio_df['date'].max().strftime('%Y-%m-%d'),
            'Active Period (Days)': (portfolio_df['date'].max() - portfolio_df['date'].min()).days
        })
    
    return pd.DataFrame(comparison_data)

def create_fund_analysis_by_portfolio(df):
    """Create comprehensive fund analysis across all portfolios"""
    fund_summary = []
    
    for portfolio_ref in sorted(df['portfolio_reference'].unique()):
        portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
        portfolio_name = portfolio_df['portfolio_name'].iloc[0]
        
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
                'Portfolio Name': portfolio_name,
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
                'First Purchase': buys['date'].min().strftime('%Y-%m-%d') if not buys.empty else 'N/A',
                'Last Transaction': fund_df['date'].max().strftime('%Y-%m-%d'),
                'Status': 'Liquidated' if remaining_position <= 0.001 else 'Holding'  # Small tolerance for floating point
            }
            
            fund_summary.append(fund_data)
    
    return pd.DataFrame(fund_summary)

def create_monthly_analysis(df):
    """Create monthly analysis across all portfolios"""
    df_copy = df.copy()
    df_copy['year_month'] = df_copy['date'].dt.strftime('%Y-%m')
    
    monthly_summary = df_copy.groupby(['portfolio_reference', 'portfolio_name', 'year_month', 'action']).agg({
        'amount': 'sum',
        'quantity': 'sum',
        'isin': 'nunique'
    }).reset_index()
    
    monthly_summary = monthly_summary.rename(columns={
        'portfolio_reference': 'Portfolio Reference',
        'portfolio_name': 'Portfolio Name',
        'year_month': 'Month',
        'action': 'Action',
        'amount': 'Total Amount (£)',
        'quantity': 'Total Shares',
        'isin': 'Funds Traded'
    })
    
    return monthly_summary

def create_top_performing_funds(df):
    """Create analysis of top performing funds across all portfolios"""
    fund_performance = []
    
    for isin in df['isin'].unique():
        fund_df = df[df['isin'] == isin]
        fund_name = fund_df['fund_name'].iloc[0]
        
        # Calculate across all portfolios for this fund
        buys = fund_df[fund_df['action'] == 'BUY']
        sells = fund_df[fund_df['action'] == 'SELL']
        
        if buys.empty:
            continue
            
        total_invested = buys['amount'].sum()
        total_received = sells['amount'].sum() if not sells.empty else 0
        net_pnl = total_received - total_invested
        return_pct = (net_pnl / total_invested * 100) if total_invested > 0 else 0
        
        # Count portfolios holding this fund
        portfolios_with_fund = fund_df['portfolio_reference'].nunique()
        portfolio_list = ', '.join(fund_df['portfolio_reference'].unique())
        
        fund_performance.append({
            'Fund Name': fund_name,
            'ISIN': isin,
            'Total Invested (£)': total_invested,
            'Total Received (£)': total_received,
            'Net P&L (£)': net_pnl,
            'Return (%)': return_pct,
            'Total Transactions': len(fund_df),
            'Portfolios Holding': portfolios_with_fund,
            'Portfolio List': portfolio_list,
            'First Purchase': buys['date'].min().strftime('%Y-%m-%d'),
            'Last Transaction': fund_df['date'].max().strftime('%Y-%m-%d')
        })
    
    # Sort by return percentage
    fund_performance_df = pd.DataFrame(fund_performance)
    return fund_performance_df.sort_values('Return (%)', ascending=False)

def format_final_excel(writer, df_transactions, df_portfolio_comparison, df_fund_analysis, df_monthly, df_top_funds):
    """Format the final comprehensive Excel file"""
    
    # Write all tabs
    df_transactions.to_excel(writer, sheet_name='All Transactions', index=False)
    df_portfolio_comparison.to_excel(writer, sheet_name='Portfolio Comparison', index=False)
    df_fund_analysis.to_excel(writer, sheet_name='Fund Analysis', index=False)
    df_monthly.to_excel(writer, sheet_name='Monthly Analysis', index=False)
    df_top_funds.to_excel(writer, sheet_name='Top Performing Funds', index=False)
    
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
    
    # Portfolio-specific colors
    gia_format = workbook.add_format({'bg_color': '#E7F3FF'})  # Light blue for GIA
    isa1_format = workbook.add_format({'bg_color': '#F0F8E7'})  # Light green for ISA1
    isa2_format = workbook.add_format({'bg_color': '#FFF2E7'})  # Light orange for ISA2
    isa3_format = workbook.add_format({'bg_color': '#F5E7FF'})  # Light purple for ISA3
    isa4_format = workbook.add_format({'bg_color': '#E7FFFF'})  # Light cyan for ISA4
    
    portfolio_colors = {
        'IP00839191': gia_format,   # GIA
        'IP00465009': isa1_format,  # 5 year ISA
        'IP00824935': isa2_format,  # Main ISA
        'IP00824949': isa3_format,  # Managed 5 years
        'IP00843395': isa4_format   # Sree ISA Growth
    }
    
    # Format All Transactions sheet with color coding
    transactions_sheet = writer.sheets['All Transactions']
    
    # Set column widths
    transactions_sheet.set_column('A:A', 15)  # portfolio_reference
    transactions_sheet.set_column('B:B', 20)  # portfolio_name
    transactions_sheet.set_column('C:C', 12, date_format)  # date
    transactions_sheet.set_column('D:D', 12, date_format)  # settlement_date
    transactions_sheet.set_column('E:E', 8)   # action
    transactions_sheet.set_column('F:F', 35)  # fund_name
    transactions_sheet.set_column('G:G', 15)  # isin
    transactions_sheet.set_column('H:H', 12)  # quantity
    transactions_sheet.set_column('I:I', 12, money_format)  # price
    transactions_sheet.set_column('J:J', 12, money_format)  # amount
    transactions_sheet.set_column('K:K', 15)  # broker
    
    # Color-code rows by portfolio
    for row_num in range(1, len(df_transactions) + 1):
        portfolio_ref = df_transactions.iloc[row_num - 1]['portfolio_reference']
        row_format = portfolio_colors.get(portfolio_ref, None)
        if row_format:
            for col_num in range(len(df_transactions.columns)):
                cell_value = df_transactions.iloc[row_num - 1, col_num]
                if pd.isna(cell_value):
                    cell_value = ''
                transactions_sheet.write(row_num, col_num, cell_value, row_format)
    
    # Format headers for all sheets
    sheets_info = [
        ('All Transactions', df_transactions, None),
        ('Portfolio Comparison', df_portfolio_comparison, [6, 7, 8, 9, 12]),  # Money columns
        ('Fund Analysis', df_fund_analysis, [4, 5, 6, 7, 11, 12]),  # Money columns
        ('Monthly Analysis', df_monthly, [4]),  # Money columns
        ('Top Performing Funds', df_top_funds, [2, 3, 4, 5])  # Money columns
    ]
    
    for sheet_name, df, money_cols in sheets_info:
        if sheet_name in writer.sheets:
            sheet = writer.sheets[sheet_name]
            
            # Format headers
            for col_num, value in enumerate(df.columns.values):
                sheet.write(0, col_num, value, header_format)
            
            # Apply money format to specified columns
            if money_cols:
                for col_num in money_cols:
                    if col_num < len(df.columns):
                        sheet.set_column(col_num, col_num, 15, money_format)

def create_final_comprehensive_excel():
    """Create the final comprehensive Excel analysis"""
    print("🔍 CREATING FINAL COMPREHENSIVE ANALYSIS WITH ALL 5 PORTFOLIOS")
    print("=" * 70)
    
    # Load all data
    combined_df = load_all_portfolio_data()
    if combined_df is None:
        return None
    
    print("\n📊 Creating comprehensive analysis tabs...")
    
    # Create all analysis tabs
    df_portfolio_comparison = create_portfolio_performance_comparison(combined_df)
    df_fund_analysis = create_fund_analysis_by_portfolio(combined_df)
    df_monthly = create_monthly_analysis(combined_df)
    df_top_funds = create_top_performing_funds(combined_df)
    
    # Prepare transactions data for Excel
    df_transactions = combined_df.copy()
    df_transactions['date'] = df_transactions['date'].dt.strftime('%Y-%m-%d')
    df_transactions['settlement_date'] = df_transactions['settlement_date'].dt.strftime('%Y-%m-%d')
    
    # Reorder columns for better display
    base_cols = ['portfolio_reference', 'portfolio_name', 'date', 'settlement_date', 'action', 'fund_name', 'isin', 'quantity', 'price', 'amount', 'broker']
    extra_cols = [col for col in df_transactions.columns if col not in base_cols]
    df_transactions = df_transactions[base_cols + extra_cols]
    
    # Clean data for Excel
    print("Cleaning data for Excel export...")
    for df in [df_transactions, df_portfolio_comparison, df_fund_analysis, df_monthly, df_top_funds]:
        for col in df.columns:
            if df[col].dtype == 'object':
                df[col] = df[col].astype(str)
        df.fillna('', inplace=True)
        df.replace([np.inf, -np.inf], '', inplace=True)
    
    # Create final Excel file
    excel_filename = f"FINAL_Complete_Portfolio_Analysis_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
    print(f"Creating final Excel file: {excel_filename}")
    
    try:
        with pd.ExcelWriter(excel_filename, engine='xlsxwriter') as writer:
            format_final_excel(writer, df_transactions, df_portfolio_comparison, df_fund_analysis, df_monthly, df_top_funds)
        
        print(f"✅ SUCCESS! Final comprehensive analysis created: {excel_filename}")
        
        # Print comprehensive summary
        print("\n" + "=" * 70)
        print("🎉 FINAL COMPREHENSIVE PORTFOLIO ANALYSIS COMPLETE!")
        print("=" * 70)
        
        print(f"📄 All Transactions: {len(df_transactions)} records across ALL portfolios")
        print(f"🏦 Portfolio Comparison: {len(df_portfolio_comparison)} portfolio accounts analyzed")
        print(f"🏆 Fund Analysis: {len(df_fund_analysis)} fund positions tracked")
        print(f"📅 Monthly Analysis: {len(df_monthly)} monthly data points")
        print(f"🎯 Top Performing Funds: {len(df_top_funds)} funds ranked by performance")
        
        print("\n💼 ALL 5 PORTFOLIO ACCOUNTS INCLUDED:")
        portfolio_summary = df_portfolio_comparison[['Portfolio Reference', 'Portfolio Name', 'Total Transactions', 'Net Cash Flow (£)', 'Return (%)']].copy()
        for _, row in portfolio_summary.iterrows():
            print(f"   📊 {row['Portfolio Reference']} ({row['Portfolio Name']}): {row['Total Transactions']} transactions, £{row['Net Cash Flow (£)']:,.2f} net flow, {row['Return (%)']:.2f}% return")
        
        return excel_filename
        
    except Exception as e:
        print(f"Error creating final Excel file: {e}")
        return None

if __name__ == "__main__":
    create_final_comprehensive_excel()
