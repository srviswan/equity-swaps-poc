#!/usr/bin/env python3
"""
Trading PDF Analyzer
A comprehensive script to extract trading transactions from PDF statements and calculate P&L.
"""

import re
import pandas as pd
import numpy as np
from datetime import datetime
from decimal import Decimal, ROUND_HALF_UP
import sys
import os

# PDF processing libraries
try:
    import PyPDF2
    import pdfplumber
    import tabula
    TABULA_AVAILABLE = True
except ImportError as e:
    print(f"Warning: Some PDF libraries not available: {e}")
    print("Install with: pip install PyPDF2 pdfplumber tabula-py")
    TABULA_AVAILABLE = False

class TradingPDFAnalyzer:
    def __init__(self, pdf_path):
        self.pdf_path = pdf_path
        self.transactions = []
        self.raw_text = ""
        
    def extract_text_pypdf2(self):
        """Extract text using PyPDF2"""
        try:
            with open(self.pdf_path, 'rb') as file:
                pdf_reader = PyPDF2.PdfReader(file)
                text = ""
                for page in pdf_reader.pages:
                    text += page.extract_text() + "\n"
                return text
        except Exception as e:
            print(f"PyPDF2 extraction failed: {e}")
            return ""
    
    def extract_text_pdfplumber(self):
        """Extract text using pdfplumber (more accurate)"""
        try:
            with pdfplumber.open(self.pdf_path) as pdf:
                text = ""
                for page in pdf.pages:
                    page_text = page.extract_text()
                    if page_text:
                        text += page_text + "\n"
                return text
        except Exception as e:
            print(f"pdfplumber extraction failed: {e}")
            return ""
    
    def extract_tables_tabula(self):
        """Extract tables using tabula-py"""
        if not TABULA_AVAILABLE:
            return []
        
        try:
            # Extract all tables from PDF
            tables = tabula.read_pdf(self.pdf_path, pages='all', multiple_tables=True)
            return tables
        except Exception as e:
            print(f"Tabula table extraction failed: {e}")
            return []
    
    def parse_transactions_from_text(self, text):
        """Parse transactions from extracted text using regex patterns"""
        transactions = []
        
        # Common patterns for trading statements
        patterns = [
            # Pattern 1: Date, Type, Symbol, Quantity, Price, Amount
            r'(\d{1,2}[/-]\d{1,2}[/-]\d{2,4})\s+(BUY|SELL|B|S)\s+([A-Z]{1,5})\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+([+-]?\d+(?:,\d{3})*(?:\.\d{2})?)',
            
            # Pattern 2: More flexible date format
            r'(\d{1,2}\s+(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\s+\d{4})\s+(BUY|SELL|Purchase|Sale)\s+([A-Z]{1,5})\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)',
            
            # Pattern 3: Different format with symbols
            r'([A-Z]{1,5})\s+(\d{1,2}[/-]\d{1,2}[/-]\d{2,4})\s+(BUY|SELL)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)\s+(\d+(?:,\d{3})*(?:\.\d{2})?)',
            
            # Pattern 4: GIA specific format (if applicable)
            r'(\d{1,2}/\d{1,2}/\d{4})\s+([A-Z]{3,5})\s+(BUY|SELL)\s+(\d+(?:,\d{3})*)\s+(\d+\.\d{2})\s+([+-]?\d+(?:,\d{3})*\.\d{2})',
        ]
        
        for pattern in patterns:
            matches = re.findall(pattern, text, re.IGNORECASE | re.MULTILINE)
            for match in matches:
                try:
                    if len(match) >= 6:
                        date_str, action, symbol, quantity, price, amount = match[:6]
                    elif len(match) >= 5:
                        date_str, action, symbol, quantity, price = match[:5]
                        amount = str(float(quantity.replace(',', '')) * float(price.replace(',', '')))
                    else:
                        continue
                    
                    # Normalize action
                    action = action.upper()
                    if action in ['B', 'PURCHASE']:
                        action = 'BUY'
                    elif action in ['S', 'SALE']:
                        action = 'SELL'
                    
                    # Parse date
                    parsed_date = self.parse_date(date_str)
                    
                    transaction = {
                        'date': parsed_date,
                        'action': action,
                        'symbol': symbol.upper(),
                        'quantity': float(quantity.replace(',', '')),
                        'price': float(price.replace(',', '')),
                        'amount': float(amount.replace(',', '').replace('+', '').replace('-', '')),
                        'raw_match': str(match)
                    }
                    transactions.append(transaction)
                    
                except (ValueError, IndexError) as e:
                    print(f"Error parsing transaction: {match}, Error: {e}")
                    continue
        
        return transactions
    
    def parse_date(self, date_str):
        """Parse various date formats"""
        date_formats = [
            '%m/%d/%Y', '%d/%m/%Y', '%m-%d-%Y', '%d-%m-%Y',
            '%m/%d/%y', '%d/%m/%y', '%m-%d-%y', '%d-%m-%y',
            '%d %b %Y', '%d %B %Y'
        ]
        
        for fmt in date_formats:
            try:
                return datetime.strptime(date_str, fmt).date()
            except ValueError:
                continue
        
        # If no format matches, try to extract year, month, day
        numbers = re.findall(r'\d+', date_str)
        if len(numbers) >= 3:
            try:
                # Assume MM/DD/YYYY format by default
                month, day, year = numbers[0], numbers[1], numbers[2]
                if len(year) == 2:
                    year = '20' + year if int(year) < 50 else '19' + year
                return datetime(int(year), int(month), int(day)).date()
            except ValueError:
                pass
        
        return None
    
    def extract_transactions(self):
        """Main method to extract transactions from PDF"""
        print(f"Analyzing PDF: {self.pdf_path}")
        
        # Try different extraction methods
        print("Extracting text with pdfplumber...")
        text = self.extract_text_pdfplumber()
        
        if not text:
            print("Trying PyPDF2...")
            text = self.extract_text_pypdf2()
        
        self.raw_text = text
        
        if text:
            print("Parsing transactions from text...")
            self.transactions = self.parse_transactions_from_text(text)
        
        # Try table extraction if available
        if TABULA_AVAILABLE:
            print("Extracting tables with tabula...")
            tables = self.extract_tables_tabula()
            if tables:
                self.parse_transactions_from_tables(tables)
        
        # Remove duplicates
        self.remove_duplicates()
        
        print(f"Found {len(self.transactions)} transactions")
        return self.transactions
    
    def parse_transactions_from_tables(self, tables):
        """Parse transactions from extracted tables"""
        for table in tables:
            if isinstance(table, pd.DataFrame) and not table.empty:
                # Look for columns that might contain transaction data
                for index, row in table.iterrows():
                    try:
                        # Try to identify transaction rows
                        row_str = ' '.join(str(cell) for cell in row.values if pd.notna(cell))
                        
                        # Look for buy/sell indicators
                        if any(word in row_str.upper() for word in ['BUY', 'SELL', 'PURCHASE', 'SALE']):
                            # Parse this row as a potential transaction
                            parsed = self.parse_transactions_from_text(row_str)
                            self.transactions.extend(parsed)
                    except Exception as e:
                        continue
    
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
            return None
        
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
            
            # Calculate FIFO P&L
            buy_queue = []
            realized_pnl = 0
            total_fees = 0
            
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
                # Use last known price or average buy price for unrealized calculation
                avg_buy_price = sum(buy['price'] * buy['remaining'] for buy in buy_queue) / remaining_qty
                # For unrealized P&L, we'd need current market price
                # Using last sell price as approximation if available
                last_price = sells['price'].iloc[-1] if not sells.empty else avg_buy_price
                unrealized_pnl = remaining_qty * (last_price - avg_buy_price)
            
            pnl_summary[symbol] = {
                'realized_pnl': realized_pnl,
                'unrealized_pnl': unrealized_pnl,
                'total_pnl': realized_pnl + unrealized_pnl,
                'remaining_quantity': remaining_qty,
                'total_bought': buys['quantity'].sum(),
                'total_sold': sells['quantity'].sum(),
                'total_buy_amount': (buys['quantity'] * buys['price']).sum(),
                'total_sell_amount': (sells['quantity'] * sells['price']).sum()
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
            report.append(f"{txn['date']} | {txn['symbol']} | {txn['quantity']:,.0f} @ ${txn['price']:.2f} | Total: ${txn['amount']:,.2f}")
        report.append("")
        
        # Sell Transactions
        report.append("SELL TRANSACTIONS")
        report.append("-" * 40)
        sells = df[df['action'] == 'SELL'].sort_values('date')
        for _, txn in sells.iterrows():
            report.append(f"{txn['date']} | {txn['symbol']} | {txn['quantity']:,.0f} @ ${txn['price']:.2f} | Total: ${txn['amount']:,.2f}")
        report.append("")
        
        # P&L Summary
        report.append("PROFIT & LOSS SUMMARY")
        report.append("-" * 40)
        total_realized_pnl = 0
        total_unrealized_pnl = 0
        
        for symbol, pnl in pnl_summary.items():
            report.append(f"\n{symbol}:")
            report.append(f"  Realized P&L: ${pnl['realized_pnl']:,.2f}")
            report.append(f"  Unrealized P&L: ${pnl['unrealized_pnl']:,.2f}")
            report.append(f"  Total P&L: ${pnl['total_pnl']:,.2f}")
            report.append(f"  Remaining Position: {pnl['remaining_quantity']:,.0f} shares")
            
            total_realized_pnl += pnl['realized_pnl']
            total_unrealized_pnl += pnl['unrealized_pnl']
        
        report.append("\nOVERALL SUMMARY:")
        report.append(f"Total Realized P&L: ${total_realized_pnl:,.2f}")
        report.append(f"Total Unrealized P&L: ${total_unrealized_pnl:,.2f}")
        report.append(f"Total P&L: ${total_realized_pnl + total_unrealized_pnl:,.2f}")
        
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

def main():
    """Main function to run the analyzer"""
    if len(sys.argv) != 2:
        print("Usage: python trading_pdf_analyzer.py <pdf_file_path>")
        print("Example: python trading_pdf_analyzer.py GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf")
        return
    
    pdf_path = sys.argv[1]
    
    if not os.path.exists(pdf_path):
        print(f"Error: File '{pdf_path}' not found.")
        return
    
    # Initialize analyzer
    analyzer = TradingPDFAnalyzer(pdf_path)
    
    # Extract transactions
    try:
        transactions = analyzer.extract_transactions()
        
        if transactions:
            # Generate and print report
            report = analyzer.generate_report()
            print(report)
            
            # Save to CSV
            analyzer.save_to_csv()
            
            # Save report to file
            report_filename = f"trading_report_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
            with open(report_filename, 'w') as f:
                f.write(report)
            print(f"\nReport saved to: {report_filename}")
            
        else:
            print("No transactions found in the PDF.")
            print("This could be due to:")
            print("1. Unsupported PDF format")
            print("2. Encrypted/protected PDF")
            print("3. Non-standard transaction format")
            print("4. PDF contains images instead of text")
            
            # Save raw text for manual inspection
            if analyzer.raw_text:
                with open('raw_pdf_text.txt', 'w') as f:
                    f.write(analyzer.raw_text)
                print("Raw PDF text saved to 'raw_pdf_text.txt' for manual inspection.")
    
    except Exception as e:
        print(f"Error analyzing PDF: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    main()
