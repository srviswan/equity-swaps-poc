#!/usr/bin/env python3
"""
Create the FINAL CORRECTED comprehensive Excel analysis with ALL 5 portfolio accounts
using the properly parsed data from the fixed parser.
"""

import pandas as pd
import numpy as np
from datetime import datetime
import glob
import os

def load_corrected_data():
    """Load the corrected data from fixed parser"""
    all_transactions = []
    
    # Load GIA data
    print("📊 Loading corrected GIA data...")
    gia_files = glob.glob("fixed_gia_transactions_*.csv")
    if gia_files:
        latest_gia = max(gia_files, key=os.path.getctime)
        print(f"   Loading: {latest_gia}")
        gia_df = pd.read_csv(latest_gia)
        gia_df['date'] = pd.to_datetime(gia_df['date'])
        gia_df['settlement_date'] = pd.to_datetime(gia_df['settlement_date'])
        gia_df['portfolio_name'] = 'GIA Account'
        gia_df['account_type'] = 'GIA'
        all_transactions.append(gia_df)
        print(f"   ✅ {gia_df['portfolio_reference'].iloc[0]}: {len(gia_df)} transactions")
    
    # Load ISA data
    print("📊 Loading corrected ISA data...")
    isa_files = glob.glob("fixed_isa_transactions_*.csv")
    if isa_files:
        latest_isa = max(isa_files, key=os.path.getctime)
        print(f"   Loading: {latest_isa}")
        isa_df = pd.read_csv(latest_isa)
        isa_df['date'] = pd.to_datetime(isa_df['date'])
        isa_df['settlement_date'] = pd.to_datetime(isa_df['settlement_date'])
        
        # Add portfolio names and account type
        portfolio_names = {
            'IP00465009': '5 year ISA',
            'IP00824935': 'Main ISA Portfolio',
            'IP00824949': 'Managed 5 years',
            'IP00843395': 'Sree ISA Growth'
        }
        isa_df['portfolio_name'] = isa_df['portfolio_reference'].map(portfolio_names)
        isa_df['account_type'] = 'ISA'
        
        all_transactions.append(isa_df)
        
        # Show ISA breakdown
        for portfolio_ref in sorted(isa_df['portfolio_reference'].unique()):
            count = len(isa_df[isa_df['portfolio_reference'] == portfolio_ref])
            name = portfolio_names.get(portfolio_ref, 'Unknown')
            print(f"   ✅ {portfolio_ref} ({name}): {count} transactions")
    
    if not all_transactions:
        print("❌ No corrected transaction data found!")
        return None
    
    # Combine all data
    combined_df = pd.concat(all_transactions, ignore_index=True)
    print(f"\n🎯 TOTAL CORRECTED: {len(combined_df)} transactions across {combined_df['portfolio_reference'].nunique()} portfolios")
    
    return combined_df

def create_portfolio_performance_summary(df):
    """Create detailed portfolio performance summary"""
    summary_data = []
    
    total_invested_all = 0
    total_received_all = 0
    
    for portfolio_ref in sorted(df['portfolio_reference'].unique()):
        portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
        portfolio_name = portfolio_df['portfolio_name'].iloc[0]
        account_type = portfolio_df['account_type'].iloc[0]
        
        buys = portfolio_df[portfolio_df['action'] == 'BUY']
        sells = portfolio_df[portfolio_df['action'] == 'SELL']
        
        total_invested = buys['amount'].sum()
        total_received = sells['amount'].sum()
        net_cash_flow = total_received - total_invested
        return_pct = (net_cash_flow / total_invested * 100) if total_invested > 0 else 0
        
        total_invested_all += total_invested
        total_received_all += total_received
        
        # Calculate remaining positions
        remaining_positions = 0
        total_remaining_value = 0
        
        for isin in portfolio_df['isin'].unique():
            fund_df = portfolio_df[portfolio_df['isin'] == isin]
            total_bought = fund_df[fund_df['action'] == 'BUY']['quantity'].sum()
            total_sold = fund_df[fund_df['action'] == 'SELL']['quantity'].sum()
            remaining_qty = total_bought - total_sold
            
            if remaining_qty > 0.001:  # Small tolerance for floating point
                remaining_positions += 1
                # Estimate value using most recent price
                recent_transactions = fund_df.sort_values('date')
                if not recent_transactions.empty:
                    last_price = recent_transactions['price'].iloc[-1]
                    total_remaining_value += remaining_qty * last_price
        
        portfolio_status = '100% Liquidated' if remaining_positions == 0 else f'{remaining_positions} funds held'
        
        period_days = (portfolio_df['date'].max() - portfolio_df['date'].min()).days
        
        summary_data.append({
            'Portfolio Reference': portfolio_ref,
            'Portfolio Name': portfolio_name,
            'Account Type': account_type,
            'Total Transactions': len(portfolio_df),
            'Buy Transactions': len(buys),
            'Sell Transactions': len(sells),
            'Total Invested (£)': total_invested,
            'Total Received (£)': total_received,
            'Net Cash Flow (£)': net_cash_flow,
            'Return (%)': return_pct,
            'Unique Funds': portfolio_df['isin'].nunique(),
            'Remaining Positions': remaining_positions,
            'Est. Remaining Value (£)': total_remaining_value,
            'Portfolio Status': portfolio_status,
            'First Transaction': portfolio_df['date'].min().strftime('%Y-%m-%d'),
            'Last Transaction': portfolio_df['date'].max().strftime('%Y-%m-%d'),
            'Active Period (Days)': period_days,
            'Avg Transaction Size (£)': portfolio_df['amount'].mean()
        })
    
    # Add overall summary row
    net_all = total_received_all - total_invested_all
    return_all = (net_all / total_invested_all * 100) if total_invested_all > 0 else 0
    
    summary_data.append({
        'Portfolio Reference': 'TOTAL ALL PORTFOLIOS',
        'Portfolio Name': 'Combined Performance',
        'Account Type': 'ALL',
        'Total Transactions': len(df),
        'Buy Transactions': len(df[df['action'] == 'BUY']),
        'Sell Transactions': len(df[df['action'] == 'SELL']),
        'Total Invested (£)': total_invested_all,
        'Total Received (£)': total_received_all,
        'Net Cash Flow (£)': net_all,
        'Return (%)': return_all,
        'Unique Funds': df['isin'].nunique(),
        'Remaining Positions': '',
        'Est. Remaining Value (£)': '',
        'Portfolio Status': 'Mixed',
        'First Transaction': df['date'].min().strftime('%Y-%m-%d'),
        'Last Transaction': df['date'].max().strftime('%Y-%m-%d'),
        'Active Period (Days)': (df['date'].max() - df['date'].min()).days,
        'Avg Transaction Size (£)': df['amount'].mean()
    })
    
    return pd.DataFrame(summary_data)

def create_fund_performance_analysis(df):
    """Create fund performance analysis across all portfolios"""
    fund_summary = []
    
    for portfolio_ref in sorted(df['portfolio_reference'].unique()):
        portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
        portfolio_name = portfolio_df['portfolio_name'].iloc[0]
        
        for isin in portfolio_df['isin'].unique():
            fund_df = portfolio_df[portfolio_df['isin'] == isin].copy()
            fund_name = fund_df['fund_name'].iloc[0]
            
            buys = fund_df[fund_df['action'] == 'BUY']
            sells = fund_df[fund_df['action'] == 'SELL']
            
            if buys.empty:
                continue
            
            total_invested = buys['amount'].sum()
            total_received = sells['amount'].sum() if not sells.empty else 0
            net_pnl = total_received - total_invested
            return_pct = (net_pnl / total_invested * 100) if total_invested > 0 else 0
            
            total_bought = buys['quantity'].sum()
            total_sold = sells['quantity'].sum() if not sells.empty else 0
            remaining_position = total_bought - total_sold
            
            avg_buy_price = (buys['quantity'] * buys['price']).sum() / total_bought if total_bought > 0 else 0
            avg_sell_price = (sells['quantity'] * sells['price']).sum() / total_sold if total_sold > 0 else 0
            
            # Calculate current estimated value
            current_value = 0
            if remaining_position > 0.001:
                # Use most recent price
                recent_price = fund_df.sort_values('date')['price'].iloc[-1]
                current_value = remaining_position * recent_price
            
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
                'Current Est. Value (£)': current_value,
                'Avg Buy Price (£)': avg_buy_price,
                'Avg Sell Price (£)': avg_sell_price if avg_sell_price > 0 else 'N/A',
                'Transaction Count': len(fund_df),
                'First Purchase': buys['date'].min().strftime('%Y-%m-%d'),
                'Last Transaction': fund_df['date'].max().strftime('%Y-%m-%d'),
                'Status': 'Liquidated' if remaining_position <= 0.001 else 'Holding'
            }
            
            fund_summary.append(fund_data)
    
    return pd.DataFrame(fund_summary)

def create_monthly_transaction_analysis(df):
    """Create monthly transaction analysis"""
    df_copy = df.copy()
    df_copy['year_month'] = df_copy['date'].dt.strftime('%Y-%m')
    
    monthly_summary = df_copy.groupby(['portfolio_reference', 'portfolio_name', 'year_month', 'action']).agg({
        'amount': ['sum', 'count', 'mean'],
        'isin': 'nunique'
    }).reset_index()
    
    # Flatten column names
    monthly_summary.columns = ['Portfolio Reference', 'Portfolio Name', 'Month', 'Action', 
                              'Total Amount (£)', 'Transaction Count', 'Avg Amount (£)', 'Unique Funds']
    
    return monthly_summary

def create_top_performers_analysis(df):
    """Create top performing funds analysis"""
    fund_performance = []
    
    for isin in df['isin'].unique():
        fund_df = df[df['isin'] == isin]
        fund_name = fund_df['fund_name'].iloc[0]
        
        # Aggregate across all portfolios
        buys = fund_df[fund_df['action'] == 'BUY']
        sells = fund_df[fund_df['action'] == 'SELL']
        
        if buys.empty:
            continue
        
        total_invested = buys['amount'].sum()
        total_received = sells['amount'].sum() if not sells.empty else 0
        net_pnl = total_received - total_invested
        return_pct = (net_pnl / total_invested * 100) if total_invested > 0 else 0
        
        # Portfolio involvement
        portfolios_involved = fund_df['portfolio_reference'].nunique()
        portfolio_list = ', '.join(sorted(fund_df['portfolio_reference'].unique()))
        
        # Performance metrics
        total_quantity_bought = buys['quantity'].sum()
        total_quantity_sold = sells['quantity'].sum() if not sells.empty else 0
        remaining_quantity = total_quantity_bought - total_quantity_sold
        
        fund_performance.append({
            'Fund Name': fund_name,
            'ISIN': isin,
            'Total Invested (£)': total_invested,
            'Total Received (£)': total_received,
            'Net P&L (£)': net_pnl,
            'Return (%)': return_pct,
            'Total Transactions': len(fund_df),
            'Remaining Shares': remaining_quantity,
            'Portfolios Involved': portfolios_involved,
            'Portfolio List': portfolio_list,
            'Investment Period': f"{fund_df['date'].min().strftime('%Y-%m-%d')} to {fund_df['date'].max().strftime('%Y-%m-%d')}",
            'Avg Buy Price (£)': (buys['quantity'] * buys['price']).sum() / total_quantity_bought if total_quantity_bought > 0 else 0,
            'Status': 'Liquidated' if remaining_quantity <= 0.001 else 'Holding'
        })
    
    # Sort by return percentage (descending)
    fund_performance_df = pd.DataFrame(fund_performance)
    return fund_performance_df.sort_values('Return (%)', ascending=False)

def format_corrected_excel(writer, df_transactions, df_summary, df_funds, df_monthly, df_top_performers):
    """Format the corrected Excel file with enhanced styling"""
    
    # Write all tabs
    df_transactions.to_excel(writer, sheet_name='All Transactions', index=False)
    df_summary.to_excel(writer, sheet_name='Portfolio Performance', index=False)
    df_funds.to_excel(writer, sheet_name='Fund Analysis', index=False)
    df_monthly.to_excel(writer, sheet_name='Monthly Analysis', index=False)
    df_top_performers.to_excel(writer, sheet_name='Top Performers', index=False)
    
    # Get workbook for formatting
    workbook = writer.book
    
    # Define formats
    money_format = workbook.add_format({'num_format': '£#,##0.00'})
    percent_format = workbook.add_format({'num_format': '0.00%'})
    big_percent_format = workbook.add_format({'num_format': '0.00%', 'bg_color': '#90EE90'})  # Green for large returns
    date_format = workbook.add_format({'num_format': 'yyyy-mm-dd'})
    header_format = workbook.add_format({
        'bold': True,
        'bg_color': '#1F4E79',
        'font_color': 'white',
        'border': 1,
        'align': 'center',
        'valign': 'vcenter'
    })
    
    # Portfolio-specific colors (lighter shades)
    portfolio_formats = {
        'IP00839191': workbook.add_format({'bg_color': '#E8F4FD'}),  # Light blue for GIA
        'IP00465009': workbook.add_format({'bg_color': '#E8F8E8'}),  # Light green for 5 year ISA
        'IP00824935': workbook.add_format({'bg_color': '#FFF8E8'}),  # Light yellow for Main ISA
        'IP00824949': workbook.add_format({'bg_color': '#F8E8FF'}),  # Light purple for Managed 5 years
        'IP00843395': workbook.add_format({'bg_color': '#E8FFFF'}),  # Light cyan for Sree ISA Growth
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
    
    # Apply portfolio-specific row colors
    for row_num in range(1, len(df_transactions) + 1):
        portfolio_ref = df_transactions.iloc[row_num - 1]['portfolio_reference']
        row_format = portfolio_formats.get(portfolio_ref, None)
        
        if row_format:
            for col_num in range(len(df_transactions.columns)):
                cell_value = df_transactions.iloc[row_num - 1, col_num]
                if pd.isna(cell_value):
                    cell_value = ''
                transactions_sheet.write(row_num, col_num, cell_value, row_format)
    
    # Format headers for all sheets
    sheets_config = [
        ('All Transactions', df_transactions, None),
        ('Portfolio Performance', df_summary, [6, 7, 8, 9, 12, 17]),  # Money columns
        ('Fund Analysis', df_funds, [4, 5, 6, 7, 11, 12, 13]),  # Money columns  
        ('Monthly Analysis', df_monthly, [4, 6]),  # Money columns
        ('Top Performers', df_top_performers, [2, 3, 4, 5, 11])  # Money columns
    ]
    
    for sheet_name, df_data, money_cols in sheets_config:
        if sheet_name in writer.sheets:
            sheet = writer.sheets[sheet_name]
            
            # Format headers
            for col_num, value in enumerate(df_data.columns.values):
                sheet.write(0, col_num, str(value), header_format)
            
            # Apply money format to specified columns
            if money_cols:
                for col_num in money_cols:
                    if col_num < len(df_data.columns):
                        sheet.set_column(col_num, col_num, 15, money_format)
            
            # Special formatting for Portfolio Performance sheet
            if sheet_name == 'Portfolio Performance':
                # Highlight high returns
                return_col = None
                for i, col in enumerate(df_data.columns):
                    if 'Return (%)' in col:
                        return_col = i
                        break
                
                if return_col is not None:
                    for row_num in range(1, len(df_data) + 1):
                        return_val = df_data.iloc[row_num - 1, return_col]
                        if isinstance(return_val, (int, float)) and return_val > 100:  # Highlight returns > 100%
                            sheet.write(row_num, return_col, return_val, big_percent_format)

def create_corrected_comprehensive_analysis():
    """Create the final corrected comprehensive analysis"""
    print("🔍 CREATING FINAL CORRECTED COMPREHENSIVE ANALYSIS")
    print("=" * 60)
    
    # Load corrected data
    combined_df = load_corrected_data()
    if combined_df is None:
        return None
    
    print("\n📊 Creating comprehensive analysis with corrected data...")
    
    # Create all analysis components
    df_portfolio_summary = create_portfolio_performance_summary(combined_df)
    df_fund_analysis = create_fund_performance_analysis(combined_df)
    df_monthly = create_monthly_transaction_analysis(combined_df)
    df_top_performers = create_top_performers_analysis(combined_df)
    
    # Prepare transactions data for Excel
    df_transactions = combined_df.copy()
    df_transactions['date'] = df_transactions['date'].dt.strftime('%Y-%m-%d')
    df_transactions['settlement_date'] = df_transactions['settlement_date'].dt.strftime('%Y-%m-%d')
    
    # Reorder columns for best display
    base_cols = ['portfolio_reference', 'portfolio_name', 'account_type', 'date', 'settlement_date', 
                'action', 'fund_name', 'isin', 'quantity', 'price', 'amount', 'broker']
    extra_cols = [col for col in df_transactions.columns if col not in base_cols]
    df_transactions = df_transactions[base_cols + extra_cols]
    
    # Clean data for Excel
    print("Cleaning data for Excel export...")
    dataframes = [df_transactions, df_portfolio_summary, df_fund_analysis, df_monthly, df_top_performers]
    
    for df in dataframes:
        # Convert object columns to string
        for col in df.columns:
            if df[col].dtype == 'object':
                df[col] = df[col].astype(str)
        
        # Fill NaN values and replace inf
        df.fillna('', inplace=True)
        df.replace([np.inf, -np.inf], '', inplace=True)
    
    # Create Excel file
    excel_filename = f"FINAL_CORRECTED_Portfolio_Analysis_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
    print(f"Creating corrected Excel file: {excel_filename}")
    
    try:
        with pd.ExcelWriter(excel_filename, engine='xlsxwriter') as writer:
            format_corrected_excel(writer, df_transactions, df_portfolio_summary, df_fund_analysis, 
                                 df_monthly, df_top_performers)
        
        print(f"✅ SUCCESS! Corrected comprehensive analysis: {excel_filename}")
        
        # Print detailed summary
        print("\n" + "="*80)
        print("🎉 FINAL CORRECTED COMPREHENSIVE PORTFOLIO ANALYSIS COMPLETE!")
        print("="*80)
        
        print(f"📄 All Transactions: {len(df_transactions)} records (CORRECTED)")
        print(f"🏦 Portfolio Performance: {len(df_portfolio_summary)} accounts analyzed")
        print(f"🏆 Fund Analysis: {len(df_fund_analysis)} fund positions")
        print(f"📅 Monthly Analysis: {len(df_monthly)} monthly data points")
        print(f"🎯 Top Performers: {len(df_top_performers)} funds ranked")
        
        print("\n💼 CORRECTED PORTFOLIO PERFORMANCE SUMMARY:")
        for _, row in df_portfolio_summary.iterrows():
            if row['Portfolio Reference'] != 'TOTAL ALL PORTFOLIOS':
                print(f"   📊 {row['Portfolio Reference']} ({row['Portfolio Name']})")
                print(f"      {row['Total Transactions']} transactions, £{row['Net Cash Flow (£)']:,.2f} profit, {row['Return (%)']:.1f}% return")
        
        # Print overall totals
        totals_row = df_portfolio_summary[df_portfolio_summary['Portfolio Reference'] == 'TOTAL ALL PORTFOLIOS'].iloc[0]
        print(f"\n🎯 OVERALL PERFORMANCE:")
        print(f"   📈 Total Net Profit: £{totals_row['Net Cash Flow (£)']:,.2f}")
        print(f"   📈 Overall Return: {totals_row['Return (%)']:.2f}%")
        print(f"   📈 Total Transactions: {totals_row['Total Transactions']}")
        
        return excel_filename
        
    except Exception as e:
        print(f"Error creating corrected Excel file: {e}")
        return None

if __name__ == "__main__":
    create_corrected_comprehensive_analysis()
