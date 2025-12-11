#!/usr/bin/env python3
"""
GIA Trading Statement Analyzer
Specialized script to extract trading transactions from GIA trading statements.
"""

import re
import pandas as pd
import numpy as np
from datetime import datetime
import sys
import os

# PDF processing libraries
try:
    import pdfplumber
    import PyPDF2
except ImportError as e:
    print(f"Error: Required PDF libraries not available: {e}")
    print("Install with: pip install pdfplumber PyPDF2 pandas")
    sys.exit(1)

class GIATradingAnalyzer:
    def __init__(self, pdf_path):
        self.pdf_path = pdf_path
        self.transactions = []
        self.raw_text = ""
        
    def extract_text(self):
        """Extract text using pdfplumber"""
        try:
            with pdfplumber.open(self.pdf_path) as pdf:
                text = ""
                for page_num, page in enumerate(pdf.pages):
                    print(f"Processing page {page_num + 1}...")
                    page_text = page.extract_text()
                    if page_text:
                        text += page_text + "\n"
                return text
        except Exception as e:
            print(f"PDF extraction failed: {e}")
            return ""
    
    def parse_gia_transactions(self, text):
        """Parse GIA-specific transaction format"""
        transactions = []
        
        # Split text into lines and process
        lines = text.split('\n')
        
        for i, line in enumerate(lines):
            line = line.strip()
            if not line:
                continue
            
            # Pattern 1: Complete transaction on one line
            # Example: "iShares MSCI World Small Cap / ISIN Buy 8.047885 £4.9391 £39.75 06/11/23 08/11/23 Jane Street"
            complete_pattern = r'([^/]+)\s*/\s*ISIN\s+([A-Z0-9]{12})\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d.]+)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})\s+(.+)'
            
            complete_match = re.search(complete_pattern, line, re.IGNORECASE)
            if complete_match:
                fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker = complete_match.groups()
                # Debug output for SELL transactions
                if action.upper() == 'SELL':
                    print(f"DEBUG: Processing SELL - {fund_name.strip()} - £{total_value}")
                self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line)
                continue
            
            # Pattern 2: Split format - main line with Buy/Sell
            # Example: "iShares MSCI World Small Cap / ISIN Buy 8.047885 £4.9391 £39.75 06/11/23 08/11/23 Jane Street"
            split_main_pattern = r'([^/]+)\s*/\s*ISIN\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d.]+)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})'
            
            split_main_match = re.search(split_main_pattern, line, re.IGNORECASE)
            if split_main_match and i + 1 < len(lines):
                fund_name, action, quantity, price, total_value, trade_date, settlement_date = split_main_match.groups()
                
                # Look at next line for ISIN and broker
                next_line = lines[i + 1].strip()
                isin_pattern = r'([A-Z0-9]{12})'
                isin_match = re.search(isin_pattern, next_line)
                
                if isin_match:
                    isin = isin_match.group(1)
                    # Extract broker info from the rest of the next line
                    broker = next_line.replace(isin, '').strip()
                    # Remove time pattern if present
                    broker = re.sub(r'\d{2}:\d{2}:\d{2}', '', broker).strip()
                    
                    self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line + " " + next_line)
                    continue
            
            # Pattern 3: Alternative split format
            # Some transactions might be in: "Xtrackers S&P 500 / ISIN IE00BM67HX07 Buy 0.973033 £71.8475 £69.91 06/11/23 08/11/23 Winterflood"
            alt_complete_pattern = r'([^/]+)\s*/\s*ISIN\s+([A-Z0-9]{12})\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d.]+)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})\s*(.*)$'
            
            alt_match = re.search(alt_complete_pattern, line, re.IGNORECASE)
            if alt_match:
                fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker = alt_match.groups()
                # If broker is empty, look at next line
                if not broker.strip() and i + 1 < len(lines):
                    next_line = lines[i + 1].strip()
                    # Extract broker from next line, remove time if present
                    broker = re.sub(r'\d{2}:\d{2}:\d{2}', '', next_line).strip()
                
                self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line)
                continue
        
        return transactions
    
    def _add_transaction(self, transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, raw_line):
        """Helper method to add a transaction"""
        try:
            # Clean and parse data
            fund_name = fund_name.strip()
            action = action.upper()
            # Remove commas from numeric values before converting to float
            quantity = float(str(quantity).replace(',', ''))
            price = float(str(price).replace(',', ''))
            total_value = float(str(total_value).replace(',', ''))
            broker = broker.strip()
            
            # Parse dates (format: DD/MM/YY)
            trade_date = datetime.strptime(trade_date, '%d/%m/%y').date()
            settlement_date = datetime.strptime(settlement_date, '%d/%m/%y').date()
            
            transaction = {
                'date': trade_date,
                'settlement_date': settlement_date,
                'action': action,
                'fund_name': fund_name,
                'isin': isin,
                'symbol': isin,  # Using ISIN as symbol for consistency
                'quantity': quantity,
                'price': price,
                'amount': total_value,
                'broker': broker,
                'raw_line': raw_line
            }
            transactions.append(transaction)
            print(f"Found transaction: {trade_date} {action} {fund_name} {quantity} @ £{price}")
            
        except (ValueError, AttributeError) as e:
            print(f"Error parsing transaction: {raw_line}")
            print(f"Error: {e}")
    
    def extract_transactions(self):
        """Main method to extract transactions from PDF"""
        print(f"Analyzing GIA PDF: {self.pdf_path}")
        
        # Extract text
        print("Extracting text from PDF...")
        text = self.extract_text()
        
        if not text:
            print("Could not extract text from PDF")
            return []
        
        print(f"Extracted {len(text)} characters of text")
        self.raw_text = text
        
        # Parse transactions
        print("Parsing GIA transactions...")
        self.transactions = self.parse_gia_transactions(text)
        
        # Remove duplicates
        self.remove_duplicates()
        
        print(f"Found {len(self.transactions)} unique transactions")
        return self.transactions
    
    def remove_duplicates(self):
        """Remove duplicate transactions"""
        seen = set()
        unique_transactions = []
        
        for txn in self.transactions:
            # Create a key based on date, action, ISIN, quantity, price
            key = (txn['date'], txn['action'], txn['isin'], txn['quantity'], txn['price'])
            if key not in seen:
                seen.add(key)
                unique_transactions.append(txn)
        
        self.transactions = unique_transactions
    
    def calculate_portfolio_summary(self):
        """Calculate portfolio summary by fund"""
        if not self.transactions:
            return {}
        
        df = pd.DataFrame(self.transactions)
        
        # Group by fund (ISIN)
        fund_summary = {}
        
        for isin in df['isin'].unique():
            fund_df = df[df['isin'] == isin].copy()
            fund_name = fund_df['fund_name'].iloc[0]
            
            # Separate buys and sells
            buys = fund_df[fund_df['action'] == 'BUY']
            sells = fund_df[fund_df['action'] == 'SELL']
            
            total_bought = buys['quantity'].sum() if not buys.empty else 0
            total_sold = sells['quantity'].sum() if not sells.empty else 0
            net_position = total_bought - total_sold
            
            total_invested = (buys['amount']).sum() if not buys.empty else 0
            total_received = (sells['amount']).sum() if not sells.empty else 0
            
            # Calculate average buy price
            avg_buy_price = (buys['quantity'] * buys['price']).sum() / total_bought if total_bought > 0 else 0
            
            fund_summary[isin] = {
                'fund_name': fund_name,
                'isin': isin,
                'total_bought': total_bought,
                'total_sold': total_sold,
                'net_position': net_position,
                'total_invested': total_invested,
                'total_received': total_received,
                'net_invested': total_invested - total_received,
                'avg_buy_price': avg_buy_price,
                'first_purchase': buys['date'].min() if not buys.empty else None,
                'last_purchase': buys['date'].max() if not buys.empty else None,
                'transaction_count': len(fund_df)
            }
        
        return fund_summary
    
    def generate_report(self):
        """Generate comprehensive trading report"""
        if not self.transactions:
            return "No transactions found in the PDF."
        
        report = []
        report.append("=" * 100)
        report.append("GIA TRADING STATEMENT ANALYSIS")
        report.append("=" * 100)
        report.append(f"PDF File: {self.pdf_path}")
        report.append(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
        report.append("")
        
        # Transaction Summary
        df = pd.DataFrame(self.transactions)
        
        total_transactions = len(self.transactions)
        buy_transactions = len(df[df['action'] == 'BUY'])
        sell_transactions = len(df[df['action'] == 'SELL'])
        unique_funds = df['isin'].nunique()
        
        report.append("TRANSACTION SUMMARY")
        report.append("-" * 50)
        report.append(f"Total Transactions: {total_transactions}")
        report.append(f"Buy Transactions: {buy_transactions}")
        report.append(f"Sell Transactions: {sell_transactions}")
        report.append(f"Unique Funds: {unique_funds}")
        report.append(f"Date Range: {df['date'].min()} to {df['date'].max()}")
        report.append(f"Total Amount Invested: £{df[df['action'] == 'BUY']['amount'].sum():,.2f}")
        report.append("")
        
        # Portfolio Summary by Fund
        portfolio_summary = self.calculate_portfolio_summary()
        
        report.append("PORTFOLIO SUMMARY BY FUND")
        report.append("-" * 50)
        
        total_net_invested = 0
        
        for isin, summary in portfolio_summary.items():
            report.append(f"\n{summary['fund_name']}")
            report.append(f"ISIN: {isin}")
            report.append(f"  Net Position: {summary['net_position']:,.4f} shares")
            report.append(f"  Total Invested: £{summary['total_invested']:,.2f}")
            report.append(f"  Average Price: £{summary['avg_buy_price']:,.4f}")
            report.append(f"  Transactions: {summary['transaction_count']}")
            report.append(f"  First Purchase: {summary['first_purchase']}")
            report.append(f"  Last Purchase: {summary['last_purchase']}")
            
            total_net_invested += summary['net_invested']
        
        report.append(f"\nTOTAL NET INVESTED: £{total_net_invested:,.2f}")
        report.append("")
        
        # Detailed Transaction List
        report.append("DETAILED TRANSACTION HISTORY")
        report.append("-" * 50)
        
        df_sorted = df.sort_values(['date', 'fund_name'])
        
        for _, txn in df_sorted.iterrows():
            report.append(f"{txn['date']} | {txn['action']:>4} | {txn['fund_name'][:40]:40} | "
                         f"{txn['quantity']:>10.4f} @ £{txn['price']:>8.4f} | Total: £{txn['amount']:>10.2f}")
        
        report.append("")
        report.append("=" * 100)
        
        return "\n".join(report)
    
    def save_to_csv(self, filename=None):
        """Save transactions to CSV"""
        if not self.transactions:
            print("No transactions to save.")
            return
        
        if not filename:
            filename = f"gia_transactions_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        
        df = pd.DataFrame(self.transactions)
        df.to_csv(filename, index=False)
        print(f"Transactions saved to: {filename}")
        return filename

def main():
    """Main function to run the analyzer"""
    if len(sys.argv) != 2:
        print("Usage: python3 gia_trading_analyzer.py <pdf_file_path>")
        print("Example: python3 gia_trading_analyzer.py GIA_Trading_statement.pdf")
        return
    
    pdf_path = sys.argv[1]
    
    if not os.path.exists(pdf_path):
        print(f"Error: File '{pdf_path}' not found.")
        return
    
    # Initialize analyzer
    analyzer = GIATradingAnalyzer(pdf_path)
    
    # Extract transactions
    try:
        transactions = analyzer.extract_transactions()
        
        if transactions:
            # Generate and print report
            report = analyzer.generate_report()
            print(report)
            
            # Save to CSV
            csv_file = analyzer.save_to_csv()
            
            # Save report to file
            report_filename = f"gia_trading_report_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
            with open(report_filename, 'w') as f:
                f.write(report)
            print(f"\nReport saved to: {report_filename}")
            
        else:
            print("No transactions found in the PDF.")
            # Save raw text for manual inspection
            if analyzer.raw_text:
                raw_text_file = f"gia_raw_text_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
                with open(raw_text_file, 'w') as f:
                    f.write(analyzer.raw_text)
                print(f"Raw PDF text saved to '{raw_text_file}' for manual inspection.")
    
    except Exception as e:
        print(f"Error analyzing PDF: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    main()
