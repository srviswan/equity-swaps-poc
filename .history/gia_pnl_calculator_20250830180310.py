#!/usr/bin/env python3
"""
GIA P&L Calculator
Calculate realized and unrealized P&L from GIA trading transactions.
"""

import pandas as pd
import numpy as np
from datetime import datetime
import sys

def load_transactions(csv_file):
    """Load transactions from CSV file"""
    try:
        df = pd.read_csv(csv_file)
        df['date'] = pd.to_datetime(df['date'])
        return df
    except Exception as e:
        print(f"Error loading CSV file: {e}")
        return None

def calculate_detailed_pnl(df):
    """Calculate detailed P&L with FIFO methodology"""
    results = {}
    
    for isin in df['isin'].unique():
        fund_df = df[df['isin'] == isin].copy()
        fund_df = fund_df.sort_values('date')
        
        fund_name = fund_df['fund_name'].iloc[0]
        
        # Separate buys and sells
        buys = fund_df[fund_df['action'] == 'BUY'].copy()
        sells = fund_df[fund_df['action'] == 'SELL'].copy()
        
        # FIFO calculation
        buy_queue = []
        realized_pnl = 0
        realized_transactions = []
        
        # Build buy queue
        for _, buy in buys.iterrows():
            buy_queue.append({
                'date': buy['date'],
                'quantity': buy['quantity'],
                'price': buy['price'],
                'remaining': buy['quantity']
            })
        
        # Process sells
        for _, sell in sells.iterrows():
            sell_qty = sell['quantity']
            sell_price = sell['price']
            
            while sell_qty > 0 and buy_queue:
                buy = buy_queue[0]
                
                if buy['remaining'] <= sell_qty:
                    # Use entire buy position
                    trade_qty = buy['remaining']
                    trade_pnl = trade_qty * (sell_price - buy['price'])
                    realized_pnl += trade_pnl
                    
                    realized_transactions.append({
                        'buy_date': buy['date'],
                        'sell_date': sell['date'],
                        'quantity': trade_qty,
                        'buy_price': buy['price'],
                        'sell_price': sell_price,
                        'pnl': trade_pnl
                    })
                    
                    sell_qty -= buy['remaining']
                    buy_queue.pop(0)
                else:
                    # Partial buy position
                    trade_qty = sell_qty
                    trade_pnl = trade_qty * (sell_price - buy['price'])
                    realized_pnl += trade_pnl
                    
                    realized_transactions.append({
                        'buy_date': buy['date'],
                        'sell_date': sell['date'],
                        'quantity': trade_qty,
                        'buy_price': buy['price'],
                        'sell_price': sell_price,
                        'pnl': trade_pnl
                    })
                    
                    buy['remaining'] -= sell_qty
                    sell_qty = 0
        
        # Calculate unrealized P&L for remaining positions
        remaining_position = sum(buy['remaining'] for buy in buy_queue)
        unrealized_value = 0
        cost_basis = 0
        
        if remaining_position > 0:
            # Calculate weighted average cost for remaining position
            cost_basis = sum(buy['price'] * buy['remaining'] for buy in buy_queue)
            
            # Use last known price (last sell price or last buy price)
            if not sells.empty:
                current_price = sells['price'].iloc[-1]
            else:
                current_price = buys['price'].iloc[-1]
            
            unrealized_value = remaining_position * current_price
            unrealized_pnl = unrealized_value - cost_basis
        else:
            unrealized_pnl = 0
        
        # Summary statistics
        total_invested = buys['amount'].sum()
        total_received = sells['amount'].sum() if not sells.empty else 0
        
        results[isin] = {
            'fund_name': fund_name,
            'total_bought': buys['quantity'].sum(),
            'total_sold': sells['quantity'].sum() if not sells.empty else 0,
            'remaining_position': remaining_position,
            'total_invested': total_invested,
            'total_received': total_received,
            'cost_basis_remaining': cost_basis,
            'unrealized_value': unrealized_value,
            'realized_pnl': realized_pnl,
            'unrealized_pnl': unrealized_pnl,
            'total_pnl': realized_pnl + unrealized_pnl,
            'realized_transactions': realized_transactions,
            'avg_buy_price': buys['price'].mean(),
            'avg_sell_price': sells['price'].mean() if not sells.empty else 0
        }
    
    return results

def generate_pnl_report(pnl_results):
    """Generate comprehensive P&L report"""
    report = []
    report.append("=" * 100)
    report.append("COMPREHENSIVE P&L ANALYSIS - GIA TRADING STATEMENT")
    report.append("=" * 100)
    report.append(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
    report.append("")
    
    # Overall summary
    total_invested = sum(result['total_invested'] for result in pnl_results.values())
    total_received = sum(result['total_received'] for result in pnl_results.values())
    total_realized_pnl = sum(result['realized_pnl'] for result in pnl_results.values())
    total_unrealized_pnl = sum(result['unrealized_pnl'] for result in pnl_results.values())
    total_pnl = total_realized_pnl + total_unrealized_pnl
    net_cash_flow = total_received - total_invested
    
    report.append("OVERALL PORTFOLIO SUMMARY")
    report.append("-" * 50)
    report.append(f"Total Amount Invested:     £{total_invested:>12,.2f}")
    report.append(f"Total Amount Received:     £{total_received:>12,.2f}")
    report.append(f"Net Cash Flow:             £{net_cash_flow:>12,.2f}")
    report.append(f"Realized P&L:              £{total_realized_pnl:>12,.2f}")
    report.append(f"Unrealized P&L:            £{total_unrealized_pnl:>12,.2f}")
    report.append(f"TOTAL P&L:                 £{total_pnl:>12,.2f}")
    
    if total_invested > 0:
        total_return_pct = (total_pnl / total_invested) * 100
        report.append(f"Total Return %:            {total_return_pct:>12.2f}%")
    
    report.append("")
    
    # Fund-by-fund analysis
    report.append("FUND-BY-FUND P&L ANALYSIS")
    report.append("-" * 50)
    
    for isin, result in pnl_results.items():
        report.append(f"\n{result['fund_name']}")
        report.append(f"ISIN: {isin}")
        report.append(f"  Total Invested:        £{result['total_invested']:>10,.2f}")
        report.append(f"  Total Received:        £{result['total_received']:>10,.2f}")
        report.append(f"  Realized P&L:          £{result['realized_pnl']:>10,.2f}")
        report.append(f"  Unrealized P&L:        £{result['unrealized_pnl']:>10,.2f}")
        report.append(f"  Total P&L:             £{result['total_pnl']:>10,.2f}")
        
        if result['total_invested'] > 0:
            return_pct = (result['total_pnl'] / result['total_invested']) * 100
            report.append(f"  Return %:              {return_pct:>10.2f}%")
        
        report.append(f"  Remaining Position:    {result['remaining_position']:>10.4f} shares")
        
        if result['remaining_position'] > 0:
            avg_cost = result['cost_basis_remaining'] / result['remaining_position']
            report.append(f"  Average Cost Basis:    £{avg_cost:>10.4f}")
        
        # Show realized transactions if any
        if result['realized_transactions']:
            report.append(f"  Realized Transactions: {len(result['realized_transactions'])}")
            for txn in result['realized_transactions']:
                pnl_per_share = txn['pnl'] / txn['quantity']
                report.append(f"    {txn['buy_date'].strftime('%Y-%m-%d')} -> {txn['sell_date'].strftime('%Y-%m-%d')}: "
                            f"{txn['quantity']:>8.4f} shares @ £{pnl_per_share:>6.2f}/share = £{txn['pnl']:>8.2f}")
    
    report.append("")
    report.append("=" * 100)
    
    return "\n".join(report)

def main():
    # Look for the most recent CSV file
    import glob
    import os
    
    csv_files = glob.glob("gia_transactions_*.csv")
    if not csv_files:
        print("No GIA transaction CSV files found. Please run gia_trading_analyzer.py first.")
        return
    
    # Use the most recent file
    latest_csv = max(csv_files, key=os.path.getctime)
    print(f"Loading transactions from: {latest_csv}")
    
    # Load and analyze transactions
    df = load_transactions(latest_csv)
    if df is None:
        return
    
    print(f"Loaded {len(df)} transactions")
    
    # Calculate P&L
    pnl_results = calculate_detailed_pnl(df)
    
    # Generate report
    report = generate_pnl_report(pnl_results)
    print(report)
    
    # Save report
    report_filename = f"gia_pnl_analysis_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
    with open(report_filename, 'w') as f:
        f.write(report)
    print(f"\nP&L analysis saved to: {report_filename}")

if __name__ == "__main__":
    main()
