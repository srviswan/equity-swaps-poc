#!/usr/bin/env python3
"""
Complete ISA analyzer that captures ALL 4 portfolio references
and their transactions from the ISA PDF.
"""

import pdfplumber
import re
import pandas as pd
from datetime import datetime
import os

class CompleteISAAnalyzer:
    def __init__(self, pdf_path):
        self.pdf_path = pdf_path
        self.portfolio_page_ranges = {
            'IP00465009': (2, 22),    # 5 year ISA
            'IP00824935': (23, 62),   # Main ISA portfolio 
            'IP00824949': (63, 66),   # Managed 5 years
            'IP00843395': (67, 114)   # Sree ISA Growth
        }
        
    def extract_all_portfolios(self):
        """Extract transactions from all 4 ISA portfolios"""
        all_transactions = []
        
        print("🔍 Extracting transactions from ALL ISA portfolios...")
        
        with pdfplumber.open(self.pdf_path) as pdf:
            for portfolio_ref, (start_page, end_page) in self.portfolio_page_ranges.items():
                print(f"\n📊 Processing {portfolio_ref} (pages {start_page}-{end_page})...")
                
                # Extract text from this portfolio's pages
                portfolio_text = ""
                for page_num in range(start_page - 1, min(end_page, len(pdf.pages))):  # Convert to 0-based
                    page = pdf.pages[page_num]
                    page_text = page.extract_text() or ''
                    portfolio_text += page_text + "\n"
                
                # Parse transactions from this portfolio's text
                portfolio_transactions = self._parse_transactions_from_text(portfolio_text, portfolio_ref)
                
                print(f"   Found {len(portfolio_transactions)} transactions")
                all_transactions.extend(portfolio_transactions)
        
        return all_transactions
    
    def _parse_transactions_from_text(self, text, portfolio_ref):
        """Parse transactions from text using comprehensive patterns"""
        transactions = []
        lines = text.split('\n')
        
        for i, line in enumerate(lines):
            line = line.strip()
            if not line:
                continue
            
            # Pattern 1: Complete transaction on one line
            # Example: "iShares MSCI World Small Cap / ISIN IE00BF4RFH31 Buy 8.047885 £4.9391 £39.75 06/11/23 08/11/23 Jane Street"
            complete_pattern = r'([^/]+)\s*/\s*ISIN\s+([A-Z0-9]{12})\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d,]+\.?\d*)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})\s*(.+)'
            complete_match = re.search(complete_pattern, line, re.IGNORECASE)
            
            if complete_match:
                fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker = complete_match.groups()
                self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line, portfolio_ref)
                continue
            
            # Pattern 2: Split format - main line with Buy/Sell
            split_main_pattern = r'([^/]+)\s*/\s*ISIN\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d,]+\.?\d*)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})'
            split_main_match = re.search(split_main_pattern, line, re.IGNORECASE)
            
            if split_main_match and i + 1 < len(lines):
                fund_name, action, quantity, price, total_value, trade_date, settlement_date = split_main_match.groups()
                next_line = lines[i + 1].strip()
                isin_pattern = r'([A-Z0-9]{12})'
                isin_match = re.search(isin_pattern, next_line)
                
                if isin_match:
                    isin = isin_match.group(1)
                    broker = next_line.replace(isin, '').strip()
                    broker = re.sub(r'\d{2}:\d{2}:\d{2}', '', broker).strip()
                    self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line + " " + next_line, portfolio_ref)
                    continue
            
            # Pattern 3: Alternative complete format
            alt_complete_pattern = r'([^/]+)\s*/\s*ISIN\s+([A-Z0-9]{12})\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d,]+\.?\d*)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})\s*(.*)$'
            alt_match = re.search(alt_complete_pattern, line, re.IGNORECASE)
            
            if alt_match:
                fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker = alt_match.groups()
                if not broker.strip() and i + 1 < len(lines):
                    next_line = lines[i + 1].strip()
                    broker = re.sub(r'\d{2}:\d{2}:\d{2}', '', next_line).strip()
                self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line, portfolio_ref)
                continue
            
            # Pattern 4: Simplified pattern for transactions that might be formatted differently
            # Look for basic Buy/Sell with amounts and dates
            simple_pattern = r'(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d,]+\.?\d*)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})'
            simple_match = re.search(simple_pattern, line, re.IGNORECASE)
            
            if simple_match:
                action, quantity, price, total_value, trade_date, settlement_date = simple_match.groups()
                
                # Look for fund name and ISIN in previous or next lines
                fund_name = "Unknown Fund"
                isin = "UNKNOWN"
                broker = "Unknown"
                
                # Check previous lines for fund name and ISIN
                for j in range(max(0, i-3), i):
                    prev_line = lines[j].strip()
                    isin_match = re.search(r'([A-Z0-9]{12})', prev_line)
                    if isin_match:
                        isin = isin_match.group(1)
                    if '/' in prev_line and 'ISIN' in prev_line:
                        fund_parts = prev_line.split('/')
                        if fund_parts:
                            fund_name = fund_parts[0].strip()
                
                # Check next lines for broker
                for j in range(i+1, min(len(lines), i+3)):
                    next_line = lines[j].strip()
                    if next_line and not re.search(r'[\d/£]', next_line):
                        broker = next_line
                        break
                
                if fund_name != "Unknown Fund" or isin != "UNKNOWN":
                    self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line, portfolio_ref)
                    continue
        
        return transactions
    
    def _add_transaction(self, transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, raw_line, portfolio_ref):
        """Helper method to add a transaction"""
        try:
            # Clean and parse data
            fund_name = fund_name.strip()
            action = action.upper()
            quantity = float(str(quantity).replace(',', ''))
            price = float(str(price).replace(',', ''))
            total_value = float(str(total_value).replace(',', ''))
            broker = broker.strip()
            
            # Parse dates
            trade_date = datetime.strptime(trade_date, '%d/%m/%y').date()
            settlement_date = datetime.strptime(settlement_date, '%d/%m/%y').date()
            
            transaction = {
                'date': trade_date,
                'settlement_date': settlement_date,
                'action': action,
                'fund_name': fund_name,
                'isin': isin,
                'symbol': isin,
                'quantity': quantity,
                'price': price,
                'amount': total_value,
                'broker': broker,
                'raw_line': raw_line,
                'portfolio_reference': portfolio_ref
            }
            transactions.append(transaction)
            
        except (ValueError, AttributeError) as e:
            print(f"Warning: Error parsing transaction: {raw_line[:100]}...")
    
    def save_complete_isa_analysis(self):
        """Extract and save complete ISA analysis"""
        transactions = self.extract_all_portfolios()
        
        if not transactions:
            print("❌ No transactions found!")
            return None
        
        # Convert to DataFrame
        df = pd.DataFrame(transactions)
        
        # Save to CSV
        csv_filename = f"complete_isa_transactions_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        df.to_csv(csv_filename, index=False)
        print(f"\n✅ Complete ISA transactions saved to: {csv_filename}")
        
        # Generate comprehensive summary
        self._generate_complete_summary_report(df, csv_filename)
        
        return csv_filename
    
    def _generate_complete_summary_report(self, df, csv_filename):
        """Generate comprehensive summary report for all portfolios"""
        report_filename = csv_filename.replace('.csv', '_complete_summary.txt')
        
        with open(report_filename, 'w') as f:
            f.write("COMPLETE ISA PORTFOLIO ANALYSIS\n")
            f.write("=" * 60 + "\n\n")
            f.write(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n")
            f.write(f"Total Transactions: {len(df)}\n\n")
            
            # Summary by portfolio
            portfolio_names = {
                'IP00465009': '5 year ISA',
                'IP00824935': 'Main ISA Portfolio',
                'IP00824949': 'Managed 5 years',
                'IP00843395': 'Sree ISA Growth'
            }
            
            for portfolio in sorted(df['portfolio_reference'].unique()):
                portfolio_df = df[df['portfolio_reference'] == portfolio]
                total_invested = portfolio_df[portfolio_df['action'] == 'BUY']['amount'].sum()
                total_received = portfolio_df[portfolio_df['action'] == 'SELL']['amount'].sum()
                net_flow = total_received - total_invested
                
                portfolio_name = portfolio_names.get(portfolio, 'Unknown Portfolio')
                
                f.write(f"PORTFOLIO: {portfolio} ({portfolio_name})\n")
                f.write("-" * 50 + "\n")
                f.write(f"  Transactions: {len(portfolio_df)}\n")
                f.write(f"  Buy Transactions: {len(portfolio_df[portfolio_df['action'] == 'BUY'])}\n")
                f.write(f"  Sell Transactions: {len(portfolio_df[portfolio_df['action'] == 'SELL'])}\n")
                f.write(f"  Total Invested: £{total_invested:,.2f}\n")
                f.write(f"  Total Received: £{total_received:,.2f}\n")
                f.write(f"  Net Cash Flow: £{net_flow:,.2f}\n")
                f.write(f"  Unique Funds: {portfolio_df['isin'].nunique()}\n")
                if not portfolio_df.empty:
                    f.write(f"  Date Range: {portfolio_df['date'].min()} to {portfolio_df['date'].max()}\n")
                f.write("\n")
        
        print(f"📊 Complete portfolio summary report saved to: {report_filename}")

if __name__ == "__main__":
    analyzer = CompleteISAAnalyzer("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf")
    csv_file = analyzer.save_complete_isa_analysis()
