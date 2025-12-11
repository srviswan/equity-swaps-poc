#!/usr/bin/env python3
"""
Simple Trading PDF Analyzer
A streamlined script to extract trading transactions from PDF statements without Java dependencies.
"""

import re
import pandas as pd
import numpy as np
from datetime import datetime
from decimal import Decimal, ROUND_HALF_UP
import sys
import os

# PDF processing libraries (without tabula)
try:
    import PyPDF2
    import pdfplumber
except ImportError as e:
    print(f"Error: Required PDF libraries not available: {e}")
    print("Install with: pip install PyPDF2 pdfplumber pandas")
    sys.exit(1)

class SimpleTradingPDFAnalyzer:
    def __init__(self, pdf_path):
        self.pdf_path = pdf_path
        self.transactions = []
        self.raw_text = ""
        
    def extract_text_pdfplumber(self):
        """Extract text using pdfplumber (more accurate)"""
        try:
            with pdfplumber.open(self.pdf_path) as pdf:
                text = ""
                for page_num, page in enumerate(pdf.pages):
                    print(f"Processing page {page_num + 1}...")
                    page_text = page.extract_text()
                    if page_text:
                        text += f"\n--- PAGE {page_num + 1} ---\n"
                        text += page_text + "\n"
                return text
        except Exception as e:
            print(f"pdfplumber extraction failed: {e}")
            return ""
    
    def extract_text_pypdf2(self):
        """Extract text using PyPDF2 as fallback"""
        try:
            with open(self.pdf_path, 'rb') as file:
                pdf_reader = PyPDF2.PdfReader(file)
                text = ""
                for page_num, page in enumerate(pdf_reader.pages):
                    print(f"Processing page {page_num + 1} with PyPDF2...")
                    text += f"\n--- PAGE {page_num + 1} ---\n"
                    text += page.extract_text() + "\n"
                return text
        except Exception as e:
            print(f"PyPDF2 extraction failed: {e}")
            return ""
    
    def parse_transactions_from_text(self, text):
        """Parse transactions from extracted text using multiple patterns"""
        transactions = []
        
        # Enhanced patterns for GIA and common trading statements
        patterns = [
            # Pattern 1: Standard format with clear BUY/SELL
            r'(\d{1,2}[/-]\d{1,2}[/-]\d{2,4})\s+(BUY|SELL|Purchase|Sale)\s+([A-Z0-9]{1,8})\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)',
            
            # Pattern 2: Date first, then action and symbol
            r'(\d{1,2}\s+(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\s+\d{4})\s+(BUY|SELL|Purchase|Sale)\s+([A-Z0-9]{1,8})\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)',
            
            # Pattern 3: Symbol first format
            r'([A-Z0-9]{1,8})\s+(\d{1,2}[/-]\d{1,2}[/-]\d{2,4})\s+(BUY|SELL|Purchase|Sale)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)',
            
            # Pattern 4: More flexible with amounts
            r'(\d{1,2}/\d{1,2}/\d{4})\s+([A-Z0-9]{1,8})\s+(BUY|SELL|Purchase|Sale)\s+(\d+(?:,\d{3})*)\s+(\$?\d+\.\d{2})',
            
            # Pattern 5: GIA specific - look for common GIA format
            r'(\d{1,2}/\d{1,2}/\d{4})\s+.*?(BUY|SELL|Purchase|Sale)\s+([A-Z0-9]{1,8}).*?(\d+(?:,\d{3})*)\s+.*?(\$?\d+\.\d{2})',
            
            # Pattern 6: Transaction with amounts and fees
            r'(\d{1,2}/\d{1,2}/\d{4})\s+([A-Z0-9]{1,8})\s+(BUY|SELL)\s+(\d+)\s+@\s+\$?(\d+\.\d{2})',
            
            # Pattern 7: Very flexible pattern for any buy/sell with numbers
            r'(\d{1,2}[/-]\d{1,2}[/-]\d{2,4}).*?(BUY|SELL|Purchase|Sale).*?([A-Z0-9]{1,8}).*?(\d+(?:,\d{3})*).*?(\d+\.\d{2})',
        ]
        
        print("Searching for transaction patterns...")
        total_matches = 0
        
        for pattern_num, pattern in enumerate(patterns, 1):
            print(f"Trying pattern {pattern_num}...")
            matches = re.findall(pattern, text, re.IGNORECASE | re.MULTILINE)
            print(f"Pattern {pattern_num} found {len(matches)} matches")
            
            for match in matches:
                try:
                    # Handle different match structures
                    if len(match) == 5:
                        date_str, action, symbol, quantity, price = match
                    elif len(match) == 6:
                        date_str, symbol, action, quantity, price, _ = match[:6]
                    else:
                        print(f"Unexpected match structure: {match}")
                        continue
                    
                    # Clean up the data
                    action = action.upper().strip()
                    if action in ['PURCHASE']:
                        action = 'BUY'
                    elif action in ['SALE']:
                        action = 'SELL'
                    
                    symbol = symbol.upper().strip()
                    
                    # Clean numerical values
                    quantity_clean = re.sub(r'[^\d.]', '', str(quantity))
                    price_clean = re.sub(r'[^\d.]', '', str(price))
                    
                    if not quantity_clean or not price_clean:
                        continue
                    
                    quantity_val = float(quantity_clean)
                    price_val = float(price_clean)
                    amount_val = quantity_val * price_val
                    
                    # Parse date
                    parsed_date = self.parse_date(date_str)
                    if not parsed_date:
                        continue
                    
                    transaction = {
                        'date': parsed_date,
                        'action': action,
                        'symbol': symbol,
                        'quantity': quantity_val,
                        'price': price_val,
                        'amount': amount_val,
                        'raw_match': str(match),
                        'pattern_used': pattern_num
                    }
                    transactions.append(transaction)
                    total_matches += 1
                    
                except (ValueError, IndexError) as e:
                    print(f"Error parsing match {match}: {e}")
                    continue
        
        print(f"Total transactions found: {total_matches}")
        return transactions
    
    def parse_date(self, date_str):
        """Parse various date formats"""
        date_formats = [
            '%m/%d/%Y', '%d/%m/%Y', '%m-%d-%Y', '%d-%m-%Y',
            '%m/%d/%y', '%d/%m/%y', '%m-%d-%y', '%d-%m-%y',
            '%d %b %Y', '%d %B %Y', '%b %d %Y', '%B %d %Y'
        ]
        
        # Clean the date string
        date_str = date_str.strip()
        
        for fmt in date_formats:
            try:
                return datetime.strptime(date_str, fmt).date()
            except ValueError:
                continue
        
        # Try to extract numbers and construct date
        numbers = re.findall(r'\d+', date_str)
        if len(numbers) >= 3:
            try:
                # Try different arrangements
                arrangements = [
                    (0, 1, 2),  # MM/DD/YYYY
                    (1, 0, 2),  # DD/MM/YYYY
                    (2, 0, 1),  # YYYY/MM/DD
                ]
                
                for month_idx, day_idx, year_idx in arrangements:
                    try:
                        month, day, year = int(numbers[month_idx]), int(numbers[day_idx]), int(numbers[year_idx])
                        if len(str(year)) == 2:
                            year = 2000 + year if year < 50 else 1900 + year
                        if 1 <= month <= 12 and 1 <= day <= 31:
                            return datetime(year, month, day).date()
                    except (ValueError, IndexError):
                        continue
            except:
                pass
        
        print(f"Could not parse date: {date_str}")
        return None
    
    def extract_transactions(self):
        """Main method to extract transactions from PDF"""
        print(f"Analyzing PDF: {self.pdf_path}")
        
        # Try pdfplumber first
        print("Extracting text with pdfplumber...")
        text = self.extract_text_pdfplumber()
        
        if not text:
            print("Trying PyPDF2...")
            text = self.extract_text_pypdf2()
        
        if not text:
            print("Could not extract text from PDF")
            return []
        
        print(f"Extracted {len(text)} characters of text")
        self.raw_text = text
        
        # Parse transactions
        print("Parsing transactions from text...")
        self.transactions = self.parse_transactions_from_text(text)
        
        # Remove duplicates
        self.remove_duplicates()
        
        print(f"Found {len(self.transactions)} unique transactions")
        return self.transactions
    
    def remove_duplicates(self):
        """Remove duplicate transactions"""
        seen = set()
        unique_transactions = []
        
        for txn in self.transactions:
            # Create a key based on date, action, symbol, quantity, price
            key = (txn['date'], txn['action'], txn['symbol'], txn['quantity'], txn['price'])
            if key not in seen:
                seen.add(key)
                unique_transactions.append(txn)
        
        self.transactions = unique_transactions
    
    def calculate_pnl(self):
        """Calculate P&L using FIFO method"""
        if not self.transactions:
            return None, []
        
        # Convert to DataFrame for easier manipulation
        df = pd.DataFrame(self.transactions)
        df = df.sort_values('date')
        
        # Group by symbol
        pnl_summary = {}
        detailed_trades = []
        
        for symbol in df['symbol'].unique():
            symbol_df = df[df['symbol'] == symbol].copy()
            
            # Separate buys and sells
            buys = symbol_df[symbol_df['action'] == 'BUY'].copy()
            sells = symbol_df[symbol_df['action'] == 'SELL'].copy()
            
            if buys.empty and sells.empty:
                continue
            
            # Calculate FIFO P&L
            buy_queue = []
            realized_pnl = 0
            
            # Add all buys to queue
            for _, buy in buys.iterrows():
                buy_queue.append({
                    'date': buy['date'],
                    'quantity': buy['quantity'],
                    'price': buy['price'],
                    'remaining': buy['quantity']
                })
            
            # Process sells against buys (FIFO)
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
                        
                        detailed_trades.append({
                            'symbol': symbol,
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
                        
                        detailed_trades.append({
                            'symbol': symbol,
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
            unrealized_pnl = 0
            remaining_qty = sum(buy['remaining'] for buy in buy_queue)
            
            if remaining_qty > 0:
                # Use average buy price for remaining positions
                avg_buy_price = sum(buy['price'] * buy['remaining'] for buy in buy_queue) / remaining_qty
                # For unrealized P&L, we'd need current market price
                # Using last sell price as approximation if available, otherwise 0
                last_price = sells['price'].iloc[-1] if not sells.empty else avg_buy_price
                unrealized_pnl = remaining_qty * (last_price - avg_buy_price)
            
            pnl_summary[symbol] = {
                'realized_pnl': realized_pnl,
                'unrealized_pnl': unrealized_pnl,
                'total_pnl': realized_pnl + unrealized_pnl,
                'remaining_quantity': remaining_qty,
                'total_bought': buys['quantity'].sum() if not buys.empty else 0,
                'total_sold': sells['quantity'].sum() if not sells.empty else 0,
                'total_buy_amount': (buys['quantity'] * buys['price']).sum() if not buys.empty else 0,
                'total_sell_amount': (sells['quantity'] * sells['price']).sum() if not sells.empty else 0
            }
        
        return pnl_summary, detailed_trades
    
    def generate_report(self):
        """Generate comprehensive trading report"""
        if not self.transactions:
            return "No transactions found in the PDF."
        
        # Calculate P&L
        pnl_summary, detailed_trades = self.calculate_pnl()
        
        report = []
        report.append("=" * 80)
        report.append("TRADING ANALYSIS REPORT")
        report.append("=" * 80)
        report.append(f"PDF File: {self.pdf_path}")
        report.append(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}")
        report.append("")
        
        # Transaction Summary
        report.append("TRANSACTION SUMMARY")
        report.append("-" * 40)
        df = pd.DataFrame(self.transactions)
        
        total_transactions = len(self.transactions)
        buy_transactions = len(df[df['action'] == 'BUY'])
        sell_transactions = len(df[df['action'] == 'SELL'])
        
        report.append(f"Total Transactions: {total_transactions}")
        report.append(f"Buy Transactions: {buy_transactions}")
        report.append(f"Sell Transactions: {sell_transactions}")
        report.append(f"Symbols Traded: {df['symbol'].nunique()}")
        report.append(f"Date Range: {df['date'].min()} to {df['date'].max()}")
        report.append("")
        
        # Buy Transactions
        report.append("BUY TRANSACTIONS")
        report.append("-" * 40)
        buys = df[df['action'] == 'BUY'].sort_values('date')
        for _, txn in buys.iterrows():
            report.append(f"{txn['date']} | {txn['symbol']:>6} | {txn['quantity']:>8,.0f} @ ${txn['price']:>8.2f} | Total: ${txn['amount']:>12,.2f}")
        report.append("")
        
        # Sell Transactions
        report.append("SELL TRANSACTIONS")
        report.append("-" * 40)
        sells = df[df['action'] == 'SELL'].sort_values('date')
        for _, txn in sells.iterrows():
            report.append(f"{txn['date']} | {txn['symbol']:>6} | {txn['quantity']:>8,.0f} @ ${txn['price']:>8.2f} | Total: ${txn['amount']:>12,.2f}")
        report.append("")
        
        # P&L Summary
        if pnl_summary:
            report.append("PROFIT & LOSS SUMMARY")
            report.append("-" * 40)
            total_realized_pnl = 0
            total_unrealized_pnl = 0
            
            for symbol, pnl in pnl_summary.items():
                report.append(f"\n{symbol}:")
                report.append(f"  Realized P&L: ${pnl['realized_pnl']:>12,.2f}")
                report.append(f"  Unrealized P&L: ${pnl['unrealized_pnl']:>12,.2f}")
                report.append(f"  Total P&L: ${pnl['total_pnl']:>12,.2f}")
                report.append(f"  Remaining Position: {pnl['remaining_quantity']:>8,.0f} shares")
                
                total_realized_pnl += pnl['realized_pnl']
                total_unrealized_pnl += pnl['unrealized_pnl']
            
            report.append("\nOVERALL P&L SUMMARY:")
            report.append(f"Total Realized P&L: ${total_realized_pnl:>12,.2f}")
            report.append(f"Total Unrealized P&L: ${total_unrealized_pnl:>12,.2f}")
            report.append(f"TOTAL P&L: ${total_realized_pnl + total_unrealized_pnl:>12,.2f}")
        
        return "\n".join(report)
    
    def save_to_csv(self, filename=None):
        """Save transactions to CSV"""
        if not self.transactions:
            print("No transactions to save.")
            return
        
        if not filename:
            filename = f"trading_transactions_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        
        df = pd.DataFrame(self.transactions)
        df.to_csv(filename, index=False)
        print(f"Transactions saved to: {filename}")
        return filename

def main():
    """Main function to run the analyzer"""
    if len(sys.argv) != 2:
        print("Usage: python3 simple_pdf_analyzer.py <pdf_file_path>")
        print("Example: python3 simple_pdf_analyzer.py GIA_Trading_statement.pdf")
        return
    
    pdf_path = sys.argv[1]
    
    if not os.path.exists(pdf_path):
        print(f"Error: File '{pdf_path}' not found.")
        return
    
    # Initialize analyzer
    analyzer = SimpleTradingPDFAnalyzer(pdf_path)
    
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
            report_filename = f"trading_report_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
            with open(report_filename, 'w') as f:
                f.write(report)
            print(f"\nReport saved to: {report_filename}")
            
            # Save raw text for inspection
            raw_text_file = f"raw_pdf_text_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
            with open(raw_text_file, 'w') as f:
                f.write(analyzer.raw_text)
            print(f"Raw PDF text saved to: {raw_text_file}")
            
        else:
            print("No transactions found in the PDF.")
            print("This could be due to:")
            print("1. Unsupported PDF format")
            print("2. Non-standard transaction format")
            print("3. PDF contains only images")
            
            # Save raw text for manual inspection
            if analyzer.raw_text:
                raw_text_file = f"raw_pdf_text_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
                with open(raw_text_file, 'w') as f:
                    f.write(analyzer.raw_text)
                print(f"Raw PDF text saved to '{raw_text_file}' for manual inspection.")
    
    except Exception as e:
        print(f"Error analyzing PDF: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    main()
