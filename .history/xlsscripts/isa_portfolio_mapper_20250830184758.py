#!/usr/bin/env python3
"""
Enhanced ISA analyzer that maps transactions to correct portfolio references
based on the page ranges where each portfolio appears in the PDF.
"""

import pdfplumber
import re
import pandas as pd
from datetime import datetime
import os

class ISAPortfolioMapper:
    def __init__(self, pdf_path):
        self.pdf_path = pdf_path
        self.portfolio_page_ranges = {}
        self.transactions_with_portfolios = []
        
    def map_portfolio_page_ranges(self):
        """Map each portfolio reference to its page ranges"""
        print("🔍 Mapping portfolio references to page ranges...")
        
        with pdfplumber.open(self.pdf_path) as pdf:
            current_portfolio = None
            portfolio_ranges = {}
            
            for page_num, page in enumerate(pdf.pages, 1):
                text = page.extract_text() or ''
                
                # Find portfolio reference on this page
                ref_patterns = [r'([A-Z]{2}\d{8})']
                page_refs = []
                for pattern in ref_patterns:
                    matches = re.findall(pattern, text, re.IGNORECASE)
                    page_refs.extend([ref for ref in matches if ref.startswith('IP') and len(ref) == 10])
                
                if page_refs:
                    portfolio_ref = page_refs[0]  # Take first valid reference
                    
                    if portfolio_ref != current_portfolio:
                        # Portfolio change detected
                        if current_portfolio:
                            # Close previous portfolio range
                            if current_portfolio not in portfolio_ranges:
                                portfolio_ranges[current_portfolio] = []
                            portfolio_ranges[current_portfolio].append((start_page, page_num - 1))
                        
                        # Start new portfolio range
                        current_portfolio = portfolio_ref
                        start_page = page_num
            
            # Close last portfolio range
            if current_portfolio:
                if current_portfolio not in portfolio_ranges:
                    portfolio_ranges[current_portfolio] = []
                portfolio_ranges[current_portfolio].append((start_page, len(pdf.pages)))
        
        self.portfolio_page_ranges = portfolio_ranges
        
        print("\n📊 Portfolio Page Ranges:")
        for portfolio, ranges in portfolio_ranges.items():
            total_pages = sum(end - start + 1 for start, end in ranges)
            print(f"  {portfolio}: {ranges} ({total_pages} pages)")
        
        return portfolio_ranges
    
    def determine_portfolio_for_transaction(self, transaction_text, page_estimate=None):
        """Determine which portfolio a transaction belongs to"""
        
        # If we have page ranges mapped, use them
        if self.portfolio_page_ranges and page_estimate:
            for portfolio, ranges in self.portfolio_page_ranges.items():
                for start, end in ranges:
                    if start <= page_estimate <= end:
                        return portfolio
        
        # Fallback: try to extract portfolio from transaction text
        ref_patterns = [r'([A-Z]{2}\d{8})']
        for pattern in ref_patterns:
            matches = re.findall(pattern, transaction_text, re.IGNORECASE)
            portfolio_refs = [ref for ref in matches if ref.startswith('IP') and len(ref) == 10]
            if portfolio_refs:
                return portfolio_refs[0]
        
        # Default fallback
        return "IP00465009"  # Default to first ISA portfolio
    
    def parse_isa_transactions_with_portfolios(self):
        """Parse ISA transactions and assign correct portfolio references"""
        print(f"🔍 Analyzing ISA PDF with portfolio mapping: {self.pdf_path}")
        
        # First map the portfolio page ranges
        self.map_portfolio_page_ranges()
        
        # Now extract transactions with portfolio mapping
        text_by_page = []
        
        with pdfplumber.open(self.pdf_path) as pdf:
            for page_num, page in enumerate(pdf.pages, 1):
                page_text = page.extract_text() or ''
                text_by_page.append((page_num, page_text))
        
        # Combine all text for transaction parsing
        full_text = '\n'.join([f"PAGE_{page_num}: {text}" for page_num, text in text_by_page])
        
        # Save raw text for debugging
        raw_text_file = f"isa_raw_text_with_pages_{datetime.now().strftime('%Y%m%d_%H%M%S')}.txt"
        with open(raw_text_file, 'w') as f:
            f.write(full_text)
        print(f"Raw text with page markers saved to: {raw_text_file}")
        
        # Parse transactions
        transactions = self._parse_transactions_from_text(full_text)
        
        # Assign portfolio references
        for transaction in transactions:
            # Estimate page number from raw_line content
            page_estimate = self._estimate_page_from_raw_line(transaction.get('raw_line', ''), text_by_page)
            portfolio_ref = self.determine_portfolio_for_transaction(transaction.get('raw_line', ''), page_estimate)
            transaction['portfolio_reference'] = portfolio_ref
            transaction['estimated_page'] = page_estimate
        
        print(f"\n📊 Transactions by Portfolio:")
        portfolio_counts = {}
        for transaction in transactions:
            portfolio = transaction.get('portfolio_reference', 'Unknown')
            portfolio_counts[portfolio] = portfolio_counts.get(portfolio, 0) + 1
        
        for portfolio, count in sorted(portfolio_counts.items()):
            print(f"  {portfolio}: {count} transactions")
        
        return transactions
    
    def _estimate_page_from_raw_line(self, raw_line, text_by_page):
        """Estimate which page a transaction came from"""
        if not raw_line:
            return None
            
        # Look for the transaction text in pages
        for page_num, page_text in text_by_page:
            if len(raw_line) > 20 and raw_line[:20] in page_text:
                return page_num
        
        return None
    
    def _parse_transactions_from_text(self, text):
        """Parse transactions using the same logic as the original analyzer"""
        transactions = []
        lines = text.split('\n')
        
        for i, line in enumerate(lines):
            line = line.strip()
            if not line or line.startswith('PAGE_'):
                continue
            
            # Use same parsing patterns as original ISA analyzer
            # Pattern 1: Complete transaction on one line
            complete_pattern = r'([^/]+)\s*/\s*ISIN\s+([A-Z0-9]{12})\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d,]+\.?\d*)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})\s*(.+)'
            complete_match = re.search(complete_pattern, line, re.IGNORECASE)
            
            if complete_match:
                fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker = complete_match.groups()
                self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line)
                continue
            
            # Pattern 2: Split format
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
                    self._add_transaction(transactions, fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker, line + " " + next_line)
                    continue
            
            # Pattern 3: Alternative complete format
            alt_complete_pattern = r'([^/]+)\s*/\s*ISIN\s+([A-Z0-9]{12})\s+(Buy|Sell)\s+([\d.]+)\s+£([\d.]+)\s+£([\d,]+\.?\d*)\s+(\d{2}/\d{2}/\d{2})\s+(\d{2}/\d{2}/\d{2})\s*(.*)$'
            alt_match = re.search(alt_complete_pattern, line, re.IGNORECASE)
            
            if alt_match:
                fund_name, isin, action, quantity, price, total_value, trade_date, settlement_date, broker = alt_match.groups()
                if not broker.strip() and i + 1 < len(lines):
                    next_line = lines[i + 1].strip()
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
                'raw_line': raw_line
            }
            transactions.append(transaction)
            
        except (ValueError, AttributeError) as e:
            print(f"Error parsing transaction: {raw_line[:100]}...")
            print(f"Error: {e}")
    
    def save_transactions_with_portfolios(self):
        """Extract and save transactions with portfolio references"""
        transactions = self.parse_isa_transactions_with_portfolios()
        
        if not transactions:
            print("No transactions found!")
            return None
        
        # Convert to DataFrame
        df = pd.DataFrame(transactions)
        
        # Save to CSV with portfolio reference
        csv_filename = f"isa_transactions_with_portfolios_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        df.to_csv(csv_filename, index=False)
        print(f"\n✅ Transactions with portfolio references saved to: {csv_filename}")
        
        # Generate summary report
        self._generate_portfolio_summary_report(df, csv_filename)
        
        return csv_filename
    
    def _generate_portfolio_summary_report(self, df, csv_filename):
        """Generate summary report by portfolio"""
        report_filename = csv_filename.replace('.csv', '_summary.txt')
        
        with open(report_filename, 'w') as f:
            f.write("ISA PORTFOLIO BREAKDOWN SUMMARY\n")
            f.write("=" * 60 + "\n\n")
            f.write(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n")
            f.write(f"Total Transactions: {len(df)}\n\n")
            
            # Summary by portfolio
            for portfolio in sorted(df['portfolio_reference'].unique()):
                portfolio_df = df[df['portfolio_reference'] == portfolio]
                total_invested = portfolio_df[portfolio_df['action'] == 'BUY']['amount'].sum()
                total_received = portfolio_df[portfolio_df['action'] == 'SELL']['amount'].sum()
                net_flow = total_received - total_invested
                
                f.write(f"PORTFOLIO: {portfolio}\n")
                f.write("-" * 40 + "\n")
                f.write(f"  Transactions: {len(portfolio_df)}\n")
                f.write(f"  Buy Transactions: {len(portfolio_df[portfolio_df['action'] == 'BUY'])}\n")
                f.write(f"  Sell Transactions: {len(portfolio_df[portfolio_df['action'] == 'SELL'])}\n")
                f.write(f"  Total Invested: £{total_invested:,.2f}\n")
                f.write(f"  Total Received: £{total_received:,.2f}\n")
                f.write(f"  Net Cash Flow: £{net_flow:,.2f}\n")
                f.write(f"  Unique Funds: {portfolio_df['isin'].nunique()}\n")
                f.write(f"  Date Range: {portfolio_df['date'].min()} to {portfolio_df['date'].max()}\n\n")
        
        print(f"📊 Portfolio summary report saved to: {report_filename}")

if __name__ == "__main__":
    mapper = ISAPortfolioMapper("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf")
    csv_file = mapper.save_transactions_with_portfolios()
