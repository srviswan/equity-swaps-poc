#!/usr/bin/env python3
"""
Structured PDF parser that follows the exact InvestEngine PDF format:
- Header (4 rows) + blank row
- Column headers: Security/ISIN | Transaction Type | Quantity | Share Price | Total Trade Value | Trade Date/Time | Settlement Date | Broker Name
- Multi-line values for columns with "/" 
"""

import pdfplumber
import re
import pandas as pd
from datetime import datetime
import os

class StructuredPDFParser:
    def __init__(self, pdf_path, portfolio_type="UNKNOWN"):
        self.pdf_path = pdf_path
        self.portfolio_type = portfolio_type  # "GIA" or "ISA"
        self.portfolio_references = {}
        
    def extract_portfolio_reference_from_page(self, page_text):
        """Extract portfolio reference from page header"""
        # Look for reference patterns in the header
        ref_patterns = [
            r'Reference:\s*([A-Z0-9]+)',
            r'([A-Z]{2}\d{8})',  # Pattern like IP00465009
        ]
        
        for pattern in ref_patterns:
            matches = re.findall(pattern, page_text, re.IGNORECASE)
            portfolio_refs = [ref for ref in matches if ref.startswith('IP') and len(ref) == 10]
            if portfolio_refs:
                return portfolio_refs[0]
        
        return None
    
    def parse_structured_page(self, page_text, page_num):
        """Parse a single page following the structured format"""
        lines = page_text.split('\n')
        transactions = []
        
        # Extract portfolio reference from this page
        portfolio_ref = self.extract_portfolio_reference_from_page(page_text)
        
        # Find the header row (contains the column names)
        header_row_idx = None
        for i, line in enumerate(lines):
            if 'Security' in line and 'ISIN' in line and 'Transaction' in line:
                header_row_idx = i
                break
        
        if header_row_idx is None:
            print(f"Warning: No header row found on page {page_num}")
            return transactions, portfolio_ref
        
        # Parse transactions starting after the header row
        i = header_row_idx + 1
        while i < len(lines):
            # Skip empty lines
            if not lines[i].strip():
                i += 1
                continue
            
            # Check if this looks like a transaction row
            # Transaction rows typically have dates and prices
            current_line = lines[i].strip()
            
            # Look for date patterns to identify transaction rows
            date_pattern = r'\d{2}/\d{2}/\d{2}'
            if not re.search(date_pattern, current_line):
                i += 1
                continue
            
            # Parse this transaction
            transaction = self.parse_transaction_row(lines, i, portfolio_ref)
            if transaction:
                transactions.append(transaction)
                # Skip the lines we've processed (transaction might span multiple lines)
                i += transaction.get('lines_processed', 1)
            else:
                i += 1
        
        return transactions, portfolio_ref
    
    def parse_transaction_row(self, lines, start_idx, portfolio_ref):
        """Parse a single transaction that might span multiple lines"""
        try:
            # Get the main transaction line
            main_line = lines[start_idx].strip()
            if not main_line:
                return None
            
            # Split by whitespace and try to identify the components
            parts = main_line.split()
            
            # Look for patterns in the transaction line
            # Expected format has dates, prices (with £), quantities
            
            # Find date patterns (DD/MM/YY)
            date_pattern = r'(\d{2}/\d{2}/\d{2})'
            dates = re.findall(date_pattern, main_line)
            
            # Find price patterns (£X.XX)
            price_pattern = r'£([\d,]+\.?\d*)'
            prices = re.findall(price_pattern, main_line)
            
            # Find action (Buy/Sell)
            action_match = re.search(r'\b(Buy|Sell)\b', main_line, re.IGNORECASE)
            action = action_match.group(1).upper() if action_match else None
            
            if not dates or not prices or not action:
                return None
            
            # Try to extract components
            trade_date = dates[0] if len(dates) > 0 else None
            settlement_date = dates[1] if len(dates) > 1 else trade_date
            
            # Prices: typically [share_price, total_value] or just [total_value]
            if len(prices) >= 2:
                share_price = float(prices[0].replace(',', ''))
                total_value = float(prices[1].replace(',', ''))
            elif len(prices) == 1:
                total_value = float(prices[0].replace(',', ''))
                share_price = total_value  # Will calculate quantity as 1
            else:
                return None
            
            # Calculate quantity (Total / Share Price)
            quantity = total_value / share_price if share_price > 0 else 1.0
            
            # Extract fund name and ISIN - might be on previous lines or split across lines
            fund_name, isin = self.extract_fund_info(lines, start_idx)
            
            # Extract broker - might be at the end of the line or on next lines
            broker = self.extract_broker_info(lines, start_idx, main_line)
            
            # Parse dates
            try:
                trade_date_obj = datetime.strptime(trade_date, '%d/%m/%y').date()
                settlement_date_obj = datetime.strptime(settlement_date, '%d/%m/%y').date()
            except:
                return None
            
            transaction = {
                'date': trade_date_obj,
                'settlement_date': settlement_date_obj,
                'action': action,
                'fund_name': fund_name,
                'isin': isin,
                'symbol': isin,
                'quantity': quantity,
                'price': share_price,
                'amount': total_value,
                'broker': broker,
                'portfolio_reference': portfolio_ref or 'UNKNOWN',
                'raw_line': main_line,
                'lines_processed': 1
            }
            
            return transaction
            
        except Exception as e:
            print(f"Error parsing transaction at line {start_idx}: {e}")
            return None
    
    def extract_fund_info(self, lines, current_idx):
        """Extract fund name and ISIN from surrounding lines"""
        fund_name = "Unknown Fund"
        isin = "UNKNOWN"
        
        # Look in previous 3 lines and current line
        search_lines = []
        for i in range(max(0, current_idx - 3), current_idx + 1):
            if i < len(lines):
                search_lines.append(lines[i])
        
        combined_text = ' '.join(search_lines)
        
        # Extract ISIN (12 character alphanumeric starting with letters)
        isin_pattern = r'\b([A-Z]{2}[A-Z0-9]{10})\b'
        isin_match = re.search(isin_pattern, combined_text)
        if isin_match:
            isin = isin_match.group(1)
        
        # Extract fund name (look for text before ISIN or action words)
        # Common patterns: "Fund Name / ISIN" or "Fund Name ISIN"
        fund_patterns = [
            r'([^/\n]+?)\s*/\s*ISIN',
            r'([^/\n]+?)\s+' + re.escape(isin) if isin != "UNKNOWN" else r'([^/\n]+?)\s+[A-Z]{2}[A-Z0-9]{10}',
            r'^([^/\n]+?)\s+(?:Buy|Sell)',
        ]
        
        for pattern in fund_patterns:
            fund_match = re.search(pattern, combined_text, re.IGNORECASE)
            if fund_match:
                potential_name = fund_match.group(1).strip()
                # Clean up the name (remove dates, prices, etc.)
                cleaned_name = re.sub(r'\d{2}/\d{2}/\d{2}|\£[\d,\.]+|Buy|Sell', '', potential_name, flags=re.IGNORECASE).strip()
                if len(cleaned_name) > 3:  # Valid fund name
                    fund_name = cleaned_name
                    break
        
        return fund_name, isin
    
    def extract_broker_info(self, lines, current_idx, main_line):
        """Extract broker information"""
        # Look for broker at the end of current line or in next few lines
        broker = "Unknown"
        
        # Common broker patterns at end of line
        broker_patterns = [
            r'(?:Buy|Sell).*?(\w+\s+\w+)$',  # Two words at end
            r'(?:Buy|Sell).*?(\w+)$',        # One word at end
        ]
        
        for pattern in broker_patterns:
            broker_match = re.search(pattern, main_line, re.IGNORECASE)
            if broker_match:
                potential_broker = broker_match.group(1).strip()
                # Filter out dates, prices, times
                if not re.search(r'\d{2}/\d{2}/\d{2}|\£|\d{2}:\d{2}:\d{2}', potential_broker):
                    broker = potential_broker
                    break
        
        # If not found, look in next line
        if broker == "Unknown" and current_idx + 1 < len(lines):
            next_line = lines[current_idx + 1].strip()
            # Remove timestamps and common patterns
            cleaned_next = re.sub(r'\d{2}:\d{2}:\d{2}|[A-Z]{2}[A-Z0-9]{10}', '', next_line).strip()
            if cleaned_next and len(cleaned_next) < 20:  # Reasonable broker name length
                broker = cleaned_next
        
        return broker
    
    def parse_pdf(self):
        """Parse the entire PDF and extract all transactions"""
        all_transactions = []
        portfolio_refs_found = {}
        
        print(f"🔍 Parsing structured PDF: {self.pdf_path}")
        
        with pdfplumber.open(self.pdf_path) as pdf:
            print(f"Total pages: {len(pdf.pages)}")
            
            for page_num, page in enumerate(pdf.pages, 1):
                page_text = page.extract_text() or ''
                
                if not page_text.strip():
                    continue
                
                # Parse this page
                page_transactions, portfolio_ref = self.parse_structured_page(page_text, page_num)
                
                if portfolio_ref:
                    if portfolio_ref not in portfolio_refs_found:
                        portfolio_refs_found[portfolio_ref] = []
                    portfolio_refs_found[portfolio_ref].append(page_num)
                
                if page_transactions:
                    all_transactions.extend(page_transactions)
                    print(f"  Page {page_num:3d}: {len(page_transactions)} transactions ({portfolio_ref or 'Unknown ref'})")
        
        # Summary
        print(f"\n📊 Parsing Summary:")
        print(f"  Total transactions found: {len(all_transactions)}")
        print(f"  Portfolio references found: {len(portfolio_refs_found)}")
        
        for portfolio_ref, pages in portfolio_refs_found.items():
            count = len([t for t in all_transactions if t.get('portfolio_reference') == portfolio_ref])
            print(f"    {portfolio_ref}: {count} transactions (pages {min(pages)}-{max(pages)})")
        
        return all_transactions, portfolio_refs_found
    
    def save_structured_analysis(self, output_prefix="structured"):
        """Parse and save the structured analysis"""
        transactions, portfolio_refs = self.parse_pdf()
        
        if not transactions:
            print("❌ No transactions found!")
            return None
        
        # Convert to DataFrame
        df = pd.DataFrame(transactions)
        
        # Save to CSV
        csv_filename = f"{output_prefix}_transactions_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        df.to_csv(csv_filename, index=False)
        print(f"\n✅ Structured transactions saved to: {csv_filename}")
        
        # Generate summary report
        self.generate_structured_summary(df, csv_filename, portfolio_refs)
        
        return csv_filename
    
    def generate_structured_summary(self, df, csv_filename, portfolio_refs):
        """Generate summary report"""
        report_filename = csv_filename.replace('.csv', '_summary.txt')
        
        with open(report_filename, 'w') as f:
            f.write(f"STRUCTURED {self.portfolio_type} ANALYSIS\n")
            f.write("=" * 60 + "\n\n")
            f.write(f"PDF File: {self.pdf_path}\n")
            f.write(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n")
            f.write(f"Total Transactions: {len(df)}\n\n")
            
            # Summary by portfolio reference
            if 'portfolio_reference' in df.columns:
                for portfolio_ref in sorted(df['portfolio_reference'].unique()):
                    portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
                    
                    buys = portfolio_df[portfolio_df['action'] == 'BUY']
                    sells = portfolio_df[portfolio_df['action'] == 'SELL']
                    
                    total_invested = buys['amount'].sum() if not buys.empty else 0
                    total_received = sells['amount'].sum() if not sells.empty else 0
                    net_flow = total_received - total_invested
                    
                    f.write(f"PORTFOLIO: {portfolio_ref}\n")
                    f.write("-" * 40 + "\n")
                    f.write(f"  Transactions: {len(portfolio_df)}\n")
                    f.write(f"  Buy Transactions: {len(buys)}\n")
                    f.write(f"  Sell Transactions: {len(sells)}\n")
                    f.write(f"  Total Invested: £{total_invested:,.2f}\n")
                    f.write(f"  Total Received: £{total_received:,.2f}\n")
                    f.write(f"  Net Cash Flow: £{net_flow:,.2f}\n")
                    f.write(f"  Unique Funds: {portfolio_df['isin'].nunique()}\n")
                    if not portfolio_df.empty:
                        f.write(f"  Date Range: {portfolio_df['date'].min()} to {portfolio_df['date'].max()}\n")
                    f.write("\n")
        
        print(f"📊 Summary report saved to: {report_filename}")

def main():
    """Parse both GIA and ISA PDFs using structured parsing"""
    
    # Parse GIA PDF
    if os.path.exists("GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"):
        print("\n🔍 PARSING GIA PDF WITH STRUCTURED PARSER")
        print("=" * 50)
        gia_parser = StructuredPDFParser("GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf", "GIA")
        gia_csv = gia_parser.save_structured_analysis("structured_gia")
    
    # Parse ISA PDF
    if os.path.exists("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"):
        print("\n🔍 PARSING ISA PDF WITH STRUCTURED PARSER")
        print("=" * 50)
        isa_parser = StructuredPDFParser("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf", "ISA")
        isa_csv = isa_parser.save_structured_analysis("structured_isa")

if __name__ == "__main__":
    main()
