#!/usr/bin/env python3
"""
Table-based PDF parser that properly handles the InvestEngine PDF table structure:
- Header (4 rows) + blank row
- Column headers: Security/ISIN | Transaction Type | Quantity | Share Price | Total Trade Value | Trade Date/Time | Settlement Date | Broker Name
- Multi-line cells for columns with "/" (Security/ISIN, Trade Date/Time)
"""

import pdfplumber
import re
import pandas as pd
from datetime import datetime
import os

class TableBasedPDFParser:
    def __init__(self, pdf_path, portfolio_type="UNKNOWN"):
        self.pdf_path = pdf_path
        self.portfolio_type = portfolio_type
        
    def extract_portfolio_reference_from_page(self, page):
        """Extract portfolio reference from page header (first 4 rows)"""
        try:
            # Extract text from top of page to get header
            bbox = (0, 0, page.width, page.height * 0.3)  # Top 30% of page
            header_text = page.within_bbox(bbox).extract_text() or ''
            
            # Look for reference patterns
            ref_patterns = [
                r'Reference:\s*([A-Z0-9]+)',
                r'([A-Z]{2}\d{8})',  # Pattern like IP00465009
            ]
            
            for pattern in ref_patterns:
                matches = re.findall(pattern, header_text, re.IGNORECASE)
                portfolio_refs = [ref for ref in matches if ref.startswith('IP') and len(ref) == 10]
                if portfolio_refs:
                    return portfolio_refs[0]
                    
        except Exception as e:
            print(f"Error extracting portfolio reference: {e}")
            
        return None
    
    def extract_tables_from_page(self, page):
        """Extract tables from a page using pdfplumber's table detection"""
        try:
            # Try to extract tables
            tables = page.extract_tables()
            
            if not tables:
                # If no tables detected, try with different settings
                tables = page.extract_tables(table_settings={
                    "vertical_strategy": "lines_strict",
                    "horizontal_strategy": "lines_strict",
                })
                
            if not tables:
                # Fall back to text-based extraction
                return self.extract_table_from_text(page)
                
            return tables
            
        except Exception as e:
            print(f"Error extracting tables: {e}")
            return []
    
    def extract_table_from_text(self, page):
        """Fall back method to extract table structure from text"""
        text = page.extract_text() or ''
        lines = text.split('\n')
        
        # Find the header row
        header_keywords = ['Security', 'ISIN', 'Transaction', 'Type', 'Quantity', 'Share', 'Price', 'Total', 'Trade', 'Value', 'Date', 'Time', 'Settlement', 'Broker', 'Name']
        header_row_idx = None
        
        for i, line in enumerate(lines):
            if sum(keyword in line for keyword in header_keywords) >= 5:  # At least 5 keywords match
                header_row_idx = i
                break
        
        if header_row_idx is None:
            return []
        
        # Extract data rows after header
        data_rows = []
        i = header_row_idx + 1
        
        while i < len(lines):
            line = lines[i].strip()
            if not line:
                i += 1
                continue
                
            # Check if this looks like a transaction row (has dates and prices)
            if re.search(r'\d{2}/\d{2}/\d{2}', line) and re.search(r'£[\d,]+\.?\d*', line):
                # This is likely a transaction row
                # Handle multi-line cells by combining with next line if needed
                row_data = self.parse_text_row(lines, i)
                if row_data:
                    data_rows.append(row_data)
                    i += row_data.get('lines_consumed', 1)
                else:
                    i += 1
            else:
                i += 1
        
        return [data_rows] if data_rows else []
    
    def parse_text_row(self, lines, start_idx):
        """Parse a transaction row from text, handling multi-line cells"""
        try:
            current_line = lines[start_idx].strip()
            next_line = lines[start_idx + 1].strip() if start_idx + 1 < len(lines) else ""
            
            # Combine current and next line to handle multi-line cells
            combined_line = current_line
            lines_consumed = 1
            
            # If next line doesn't look like a new transaction, it might be continuation
            if next_line and not re.search(r'\d{2}/\d{2}/\d{2}.*£', next_line):
                combined_line += " " + next_line
                lines_consumed = 2
            
            # Parse the combined line
            row_data = self.parse_transaction_line(combined_line)
            if row_data:
                row_data['lines_consumed'] = lines_consumed
                return row_data
                
        except Exception as e:
            print(f"Error parsing text row: {e}")
            
        return None
    
    def parse_transaction_line(self, line):
        """Parse a single transaction line into components"""
        try:
            # Extract components using patterns
            
            # Find action (Buy/Sell)
            action_match = re.search(r'\b(Buy|Sell)\b', line, re.IGNORECASE)
            if not action_match:
                return None
            action = action_match.group(1).upper()
            
            # Find dates (DD/MM/YY format)
            date_pattern = r'(\d{2}/\d{2}/\d{2})'
            dates = re.findall(date_pattern, line)
            if len(dates) < 1:
                return None
            
            trade_date = dates[0]
            settlement_date = dates[1] if len(dates) > 1 else trade_date
            
            # Find prices and amounts (£X.XX format)
            price_pattern = r'£([\d,]+\.?\d*)'
            prices = re.findall(price_pattern, line)
            if len(prices) < 1:
                return None
            
            # Determine share price and total amount
            if len(prices) >= 2:
                share_price = float(prices[0].replace(',', ''))
                total_amount = float(prices[-1].replace(',', ''))  # Last price is usually total
            else:
                total_amount = float(prices[0].replace(',', ''))
                share_price = total_amount  # Will set quantity to 1
            
            # Find quantity (decimal number, not a price or date)
            quantity_pattern = r'(?<!£)(?<!/)\b(\d+\.?\d*)\b(?!\d|/)'
            quantity_matches = re.findall(quantity_pattern, line)
            
            # Filter out dates and prices from quantity matches
            quantity = 1.0
            for match in quantity_matches:
                val = float(match)
                # Skip if it looks like a date component or matches a price
                if val > 31 and val != share_price and val != total_amount:  # Likely quantity
                    quantity = val
                    break
            
            # Calculate quantity if we have share price and total
            if quantity == 1.0 and share_price > 0:
                quantity = total_amount / share_price
            
            # Extract ISIN (12 character alphanumeric)
            isin_pattern = r'\b([A-Z]{2}[A-Z0-9]{10})\b'
            isin_match = re.search(isin_pattern, line)
            isin = isin_match.group(1) if isin_match else "UNKNOWN"
            
            # Extract fund name (text before action or ISIN)
            fund_name = "Unknown Fund"
            
            # Try different patterns for fund name
            fund_patterns = [
                r'^([^£\d]+?)\s+(?:Buy|Sell)',  # Text before Buy/Sell
                r'^([^£\d]+?)\s+' + re.escape(isin) if isin != "UNKNOWN" else None,  # Text before ISIN
                r'^([A-Za-z\s&]+)',  # Starting letters and spaces
            ]
            
            for pattern in fund_patterns:
                if pattern:
                    fund_match = re.search(pattern, line, re.IGNORECASE)
                    if fund_match:
                        potential_name = fund_match.group(1).strip()
                        # Clean up (remove / and other artifacts)
                        cleaned_name = re.sub(r'[/]|ISIN', '', potential_name).strip()
                        if len(cleaned_name) > 3:
                            fund_name = cleaned_name
                            break
            
            # Extract broker (typically at the end)
            broker = "Unknown"
            # Split line and look for broker at the end
            parts = line.split()
            if parts:
                # Look for text that doesn't contain dates, prices, or ISINs
                for part in reversed(parts):
                    if not re.search(r'\d{2}/\d{2}/\d{2}|£|\d{2}:\d{2}|\b[A-Z]{2}[A-Z0-9]{10}\b', part):
                        if len(part) > 2:
                            broker = part
                            break
            
            return {
                'action': action,
                'trade_date': trade_date,
                'settlement_date': settlement_date,
                'share_price': share_price,
                'total_amount': total_amount,
                'quantity': quantity,
                'isin': isin,
                'fund_name': fund_name,
                'broker': broker,
                'raw_line': line
            }
            
        except Exception as e:
            print(f"Error parsing transaction line: {e}")
            return None
    
    def process_table_data(self, table_data, portfolio_ref):
        """Process table data into transaction records"""
        transactions = []
        
        if not table_data:
            return transactions
        
        # Handle different table formats
        if isinstance(table_data[0], list):
            # List of rows
            rows = table_data
        else:
            # Single table
            rows = table_data
        
        for row in rows:
            if isinstance(row, dict):
                # Already processed row
                transaction = self.convert_row_to_transaction(row, portfolio_ref)
                if transaction:
                    transactions.append(transaction)
            elif isinstance(row, list) and len(row) >= 6:
                # Table row format [Security/ISIN, Transaction Type, Quantity, Share Price, Total Trade Value, Trade Date/Time, Settlement Date, Broker Name]
                transaction = self.convert_table_row_to_transaction(row, portfolio_ref)
                if transaction:
                    transactions.append(transaction)
        
        return transactions
    
    def convert_row_to_transaction(self, row_data, portfolio_ref):
        """Convert parsed row data to transaction format"""
        try:
            trade_date = datetime.strptime(row_data['trade_date'], '%d/%m/%y').date()
            settlement_date = datetime.strptime(row_data['settlement_date'], '%d/%m/%y').date()
            
            return {
                'date': trade_date,
                'settlement_date': settlement_date,
                'action': row_data['action'],
                'fund_name': row_data['fund_name'],
                'isin': row_data['isin'],
                'symbol': row_data['isin'],
                'quantity': row_data['quantity'],
                'price': row_data['share_price'],
                'amount': row_data['total_amount'],
                'broker': row_data['broker'],
                'portfolio_reference': portfolio_ref or 'UNKNOWN',
                'raw_line': row_data['raw_line']
            }
        except Exception as e:
            print(f"Error converting row to transaction: {e}")
            return None
    
    def convert_table_row_to_transaction(self, row, portfolio_ref):
        """Convert table row to transaction format"""
        try:
            # Expected format: [Security/ISIN, Transaction Type, Quantity, Share Price, Total Trade Value, Trade Date/Time, Settlement Date, Broker Name]
            if len(row) < 6:
                return None
            
            # Handle multi-line cells (join if list)
            security_isin = ' '.join(row[0]) if isinstance(row[0], list) else str(row[0] or '')
            transaction_type = str(row[1] or '')
            quantity = str(row[2] or '')
            share_price = str(row[3] or '')
            total_value = str(row[4] or '')
            trade_date_time = ' '.join(row[5]) if isinstance(row[5], list) else str(row[5] or '')
            settlement_date = str(row[6]) if len(row) > 6 else trade_date_time
            broker_name = str(row[7]) if len(row) > 7 else 'Unknown'
            
            # Parse components
            # Extract fund name and ISIN from security_isin
            isin_match = re.search(r'([A-Z]{2}[A-Z0-9]{10})', security_isin)
            isin = isin_match.group(1) if isin_match else "UNKNOWN"
            
            fund_name = re.sub(r'[A-Z]{2}[A-Z0-9]{10}|/|ISIN', '', security_isin).strip()
            if not fund_name:
                fund_name = "Unknown Fund"
            
            # Parse action
            action = 'BUY' if 'buy' in transaction_type.lower() else 'SELL' if 'sell' in transaction_type.lower() else 'UNKNOWN'
            
            # Parse quantities and prices
            quantity_val = float(re.sub(r'[^\d.]', '', quantity)) if re.search(r'\d', quantity) else 1.0
            
            price_match = re.search(r'£?([\d,]+\.?\d*)', share_price)
            price_val = float(price_match.group(1).replace(',', '')) if price_match else 0.0
            
            total_match = re.search(r'£?([\d,]+\.?\d*)', total_value)
            total_val = float(total_match.group(1).replace(',', '')) if total_match else 0.0
            
            # Parse dates
            date_match = re.search(r'(\d{2}/\d{2}/\d{2})', trade_date_time)
            trade_date_str = date_match.group(1) if date_match else None
            
            settle_date_match = re.search(r'(\d{2}/\d{2}/\d{2})', settlement_date)
            settlement_date_str = settle_date_match.group(1) if settle_date_match else trade_date_str
            
            if not trade_date_str:
                return None
            
            trade_date_obj = datetime.strptime(trade_date_str, '%d/%m/%y').date()
            settlement_date_obj = datetime.strptime(settlement_date_str, '%d/%m/%y').date()
            
            return {
                'date': trade_date_obj,
                'settlement_date': settlement_date_obj,
                'action': action,
                'fund_name': fund_name,
                'isin': isin,
                'symbol': isin,
                'quantity': quantity_val,
                'price': price_val,
                'amount': total_val,
                'broker': broker_name.strip(),
                'portfolio_reference': portfolio_ref or 'UNKNOWN',
                'raw_line': ' | '.join(str(cell) for cell in row)
            }
            
        except Exception as e:
            print(f"Error converting table row: {e}")
            return None
    
    def parse_pdf(self):
        """Parse the entire PDF using table-based extraction"""
        all_transactions = []
        portfolio_refs_found = {}
        
        print(f"🔍 Parsing PDF with table-based approach: {self.pdf_path}")
        
        with pdfplumber.open(self.pdf_path) as pdf:
            print(f"Total pages: {len(pdf.pages)}")
            
            for page_num, page in enumerate(pdf.pages, 1):
                # Extract portfolio reference from page header
                portfolio_ref = self.extract_portfolio_reference_from_page(page)
                
                if portfolio_ref:
                    if portfolio_ref not in portfolio_refs_found:
                        portfolio_refs_found[portfolio_ref] = []
                    portfolio_refs_found[portfolio_ref].append(page_num)
                
                # Extract tables from page
                tables = self.extract_tables_from_page(page)
                
                page_transactions = 0
                for table in tables:
                    if table:
                        transactions = self.process_table_data(table, portfolio_ref)
                        all_transactions.extend(transactions)
                        page_transactions += len(transactions)
                
                if page_transactions > 0:
                    print(f"  Page {page_num:3d}: {page_transactions} transactions ({portfolio_ref or 'Unknown ref'})")
        
        # Summary
        print(f"\n📊 Table-Based Parsing Summary:")
        print(f"  Total transactions found: {len(all_transactions)}")
        print(f"  Portfolio references found: {len(portfolio_refs_found)}")
        
        for portfolio_ref, pages in portfolio_refs_found.items():
            count = len([t for t in all_transactions if t.get('portfolio_reference') == portfolio_ref])
            print(f"    {portfolio_ref}: {count} transactions (pages {min(pages)}-{max(pages)})")
        
        return all_transactions, portfolio_refs_found
    
    def save_table_based_analysis(self, output_prefix="table_based"):
        """Parse and save the table-based analysis"""
        transactions, portfolio_refs = self.parse_pdf()
        
        if not transactions:
            print("❌ No transactions found!")
            return None
        
        # Convert to DataFrame
        df = pd.DataFrame(transactions)
        
        # Save to CSV
        csv_filename = f"{output_prefix}_transactions_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        df.to_csv(csv_filename, index=False)
        print(f"\n✅ Table-based transactions saved to: {csv_filename}")
        
        # Generate summary report
        self.generate_summary_report(df, csv_filename, portfolio_refs)
        
        return csv_filename
    
    def generate_summary_report(self, df, csv_filename, portfolio_refs):
        """Generate summary report"""
        report_filename = csv_filename.replace('.csv', '_summary.txt')
        
        with open(report_filename, 'w') as f:
            f.write(f"TABLE-BASED {self.portfolio_type} ANALYSIS\n")
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
    """Parse both GIA and ISA PDFs using table-based parsing"""
    
    # Parse GIA PDF
    if os.path.exists("GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"):
        print("\n🔍 PARSING GIA PDF WITH TABLE-BASED PARSER")
        print("=" * 55)
        gia_parser = TableBasedPDFParser("GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf", "GIA")
        gia_csv = gia_parser.save_table_based_analysis("table_based_gia")
    
    # Parse ISA PDF
    if os.path.exists("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"):
        print("\n🔍 PARSING ISA PDF WITH TABLE-BASED PARSER")
        print("=" * 55)
        isa_parser = TableBasedPDFParser("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf", "ISA")
        isa_csv = isa_parser.save_table_based_analysis("table_based_isa")

if __name__ == "__main__":
    main()
