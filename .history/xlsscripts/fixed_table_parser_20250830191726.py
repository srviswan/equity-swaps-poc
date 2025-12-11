#!/usr/bin/env python3
"""
Fixed table parser that handles the InvestEngine PDF structure where
transaction data is packed into the first column of the table.
"""

import pdfplumber
import re
import pandas as pd
from datetime import datetime
import os

class FixedTableParser:
    def __init__(self, pdf_path, portfolio_type="UNKNOWN"):
        self.pdf_path = pdf_path
        self.portfolio_type = portfolio_type
        
    def extract_portfolio_reference_from_page(self, page):
        """Extract portfolio reference from page header"""
        try:
            text = page.extract_text() or ''
            lines = text.split('\n')[:10]  # Check first 10 lines
            
            for line in lines:
                ref_match = re.search(r'Reference:\s*([A-Z0-9]+)', line)
                if ref_match:
                    return ref_match.group(1)
                    
                # Also look for IP pattern
                ip_match = re.search(r'([A-Z]{2}\d{8})', line)
                if ip_match and ip_match.group(1).startswith('IP'):
                    return ip_match.group(1)
                    
        except Exception as e:
            print(f"Error extracting portfolio reference: {e}")
            
        return None
    
    def parse_transaction_data_from_first_column(self, transaction_text):
        """Parse transaction data that's packed into the first column"""
        try:
            # Clean up the text
            text = transaction_text.replace('\n', ' ').strip()
            
            # Pattern to match the transaction format:
            # Fund Name / ISIN [ISIN_CODE] Buy/Sell [quantity] £[price] £[total] [date1] [date2] [broker] [time] [other]
            
            # Find the ISIN code (12 character alphanumeric)
            isin_match = re.search(r'([A-Z]{2}[A-Z0-9]{10})', text)
            if not isin_match:
                return None
            isin = isin_match.group(1)
            
            # Find action (Buy/Sell)
            action_match = re.search(r'\b(Buy|Sell)\b', text, re.IGNORECASE)
            if not action_match:
                return None
            action = action_match.group(1).upper()
            
            # Find dates (DD/MM/YY format)
            date_pattern = r'(\d{2}/\d{2}/\d{2})'
            dates = re.findall(date_pattern, text)
            if len(dates) < 2:
                return None
            trade_date = dates[0]
            settlement_date = dates[1]
            
            # Find prices (£X.XX format)
            price_pattern = r'£([\d,]+\.?\d*)'
            prices = re.findall(price_pattern, text)
            if len(prices) < 2:
                return None
            
            share_price = float(prices[0].replace(',', ''))
            total_value = float(prices[1].replace(',', ''))
            
            # Find quantity (should be between action and first price)
            action_pos = text.find(action)
            first_price_pos = text.find('£' + prices[0])
            
            quantity_text = text[action_pos + len(action):first_price_pos].strip()
            quantity_match = re.search(r'([\d.]+)', quantity_text)
            if quantity_match:
                quantity = float(quantity_match.group(1))
            else:
                # Fallback: calculate from total/price
                quantity = total_value / share_price if share_price > 0 else 1.0
            
            # Extract fund name (everything before " / ISIN")
            fund_name_match = re.search(r'^(.+?)\s*/\s*ISIN', text)
            if fund_name_match:
                fund_name = fund_name_match.group(1).strip()
            else:
                # Fallback: text before the action
                fund_name_match = re.search(r'^(.+?)\s+' + action, text)
                fund_name = fund_name_match.group(1).strip() if fund_name_match else "Unknown Fund"
            
            # Extract broker (look for known broker names at the end)
            broker_patterns = [
                r'(Jane Street)',
                r'(Winterflood)',
                r'(Financial)',
                r'([A-Z][a-z]+\s+[A-Z][a-z]+)',  # Two capitalized words
                r'([A-Z][a-z]+)(?:\s+\d{2}:\d{2}:\d{2})?$',  # Last word before timestamp
            ]
            
            broker = "Unknown"
            for pattern in broker_patterns:
                broker_match = re.search(pattern, text)
                if broker_match:
                    broker = broker_match.group(1)
                    break
            
            return {
                'fund_name': fund_name,
                'isin': isin,
                'action': action,
                'quantity': quantity,
                'share_price': share_price,
                'total_value': total_value,
                'trade_date': trade_date,
                'settlement_date': settlement_date,
                'broker': broker,
                'raw_text': text
            }
            
        except Exception as e:
            print(f"Error parsing transaction: {e}")
            return None
    
    def parse_page_transactions(self, page):
        """Extract transactions from a page"""
        transactions = []
        portfolio_ref = self.extract_portfolio_reference_from_page(page)
        
        try:
            # Extract tables
            tables = page.extract_tables()
            
            if not tables:
                return transactions, portfolio_ref
            
            table = tables[0]  # Use first table
            
            # Find header row
            header_row = None
            data_start_idx = 0
            
            for i, row in enumerate(table):
                if row and any(cell for cell in row if cell and 'Security' in str(cell)):
                    header_row = row
                    data_start_idx = i + 1
                    break
            
            if header_row is None:
                print(f"No header row found")
                return transactions, portfolio_ref
            
            # Process data rows
            for i in range(data_start_idx, len(table)):
                row = table[i]
                if not row or not row[0]:
                    continue
                
                # The transaction data is in the first column
                transaction_text = str(row[0])
                
                # Skip if this doesn't look like transaction data
                if not re.search(r'(Buy|Sell)', transaction_text, re.IGNORECASE):
                    continue
                
                # Parse the transaction
                parsed_transaction = self.parse_transaction_data_from_first_column(transaction_text)
                
                if parsed_transaction:
                    # Convert to standard format
                    try:
                        trade_date_obj = datetime.strptime(parsed_transaction['trade_date'], '%d/%m/%y').date()
                        settlement_date_obj = datetime.strptime(parsed_transaction['settlement_date'], '%d/%m/%y').date()
                        
                        transaction = {
                            'date': trade_date_obj,
                            'settlement_date': settlement_date_obj,
                            'action': parsed_transaction['action'],
                            'fund_name': parsed_transaction['fund_name'],
                            'isin': parsed_transaction['isin'],
                            'symbol': parsed_transaction['isin'],
                            'quantity': parsed_transaction['quantity'],
                            'price': parsed_transaction['share_price'],
                            'amount': parsed_transaction['total_value'],
                            'broker': parsed_transaction['broker'],
                            'portfolio_reference': portfolio_ref or 'UNKNOWN',
                            'raw_line': parsed_transaction['raw_text']
                        }
                        
                        transactions.append(transaction)
                        
                    except Exception as e:
                        print(f"Error converting transaction: {e}")
                        continue
            
        except Exception as e:
            print(f"Error parsing page: {e}")
        
        return transactions, portfolio_ref
    
    def parse_pdf(self):
        """Parse the entire PDF"""
        all_transactions = []
        portfolio_refs_found = {}
        
        print(f"🔍 Parsing PDF with fixed table parser: {self.pdf_path}")
        
        with pdfplumber.open(self.pdf_path) as pdf:
            print(f"Total pages: {len(pdf.pages)}")
            
            for page_num, page in enumerate(pdf.pages, 1):
                page_transactions, portfolio_ref = self.parse_page_transactions(page)
                
                if portfolio_ref:
                    if portfolio_ref not in portfolio_refs_found:
                        portfolio_refs_found[portfolio_ref] = []
                    portfolio_refs_found[portfolio_ref].append(page_num)
                
                if page_transactions:
                    all_transactions.extend(page_transactions)
                    print(f"  Page {page_num:3d}: {len(page_transactions)} transactions ({portfolio_ref or 'Unknown'})")
        
        # Summary
        print(f"\n📊 Fixed Parser Summary:")
        print(f"  Total transactions found: {len(all_transactions)}")
        print(f"  Portfolio references found: {len(portfolio_refs_found)}")
        
        for portfolio_ref, pages in portfolio_refs_found.items():
            count = len([t for t in all_transactions if t.get('portfolio_reference') == portfolio_ref])
            print(f"    {portfolio_ref}: {count} transactions (pages {min(pages)}-{max(pages)})")
        
        return all_transactions, portfolio_refs_found
    
    def save_fixed_analysis(self, output_prefix="fixed"):
        """Parse and save the analysis"""
        transactions, portfolio_refs = self.parse_pdf()
        
        if not transactions:
            print("❌ No transactions found!")
            return None
        
        # Convert to DataFrame
        df = pd.DataFrame(transactions)
        
        # Save to CSV
        csv_filename = f"{output_prefix}_{self.portfolio_type.lower()}_transactions_{datetime.now().strftime('%Y%m%d_%H%M%S')}.csv"
        df.to_csv(csv_filename, index=False)
        print(f"\n✅ Fixed transactions saved to: {csv_filename}")
        
        # Generate summary report
        self.generate_summary_report(df, csv_filename, portfolio_refs)
        
        return csv_filename
    
    def generate_summary_report(self, df, csv_filename, portfolio_refs):
        """Generate summary report"""
        report_filename = csv_filename.replace('.csv', '_summary.txt')
        
        portfolio_names = {
            'IP00839191': 'GIA Account',
            'IP00465009': '5 year ISA',
            'IP00824935': 'Main ISA Portfolio',
            'IP00824949': 'Managed 5 years',
            'IP00843395': 'Sree ISA Growth'
        }
        
        with open(report_filename, 'w') as f:
            f.write(f"FIXED {self.portfolio_type} ANALYSIS\n")
            f.write("=" * 60 + "\n\n")
            f.write(f"PDF File: {self.pdf_path}\n")
            f.write(f"Analysis Date: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n")
            f.write(f"Total Transactions: {len(df)}\n\n")
            
            # Summary by portfolio reference
            if 'portfolio_reference' in df.columns:
                for portfolio_ref in sorted(df['portfolio_reference'].unique()):
                    portfolio_df = df[df['portfolio_reference'] == portfolio_ref]
                    portfolio_name = portfolio_names.get(portfolio_ref, 'Unknown Portfolio')
                    
                    buys = portfolio_df[portfolio_df['action'] == 'BUY']
                    sells = portfolio_df[portfolio_df['action'] == 'SELL']
                    
                    total_invested = buys['amount'].sum() if not buys.empty else 0
                    total_received = sells['amount'].sum() if not sells.empty else 0
                    net_flow = total_received - total_invested
                    return_pct = (net_flow / total_invested * 100) if total_invested > 0 else 0
                    
                    f.write(f"PORTFOLIO: {portfolio_ref} ({portfolio_name})\n")
                    f.write("-" * 50 + "\n")
                    f.write(f"  Transactions: {len(portfolio_df)}\n")
                    f.write(f"  Buy Transactions: {len(buys)}\n")
                    f.write(f"  Sell Transactions: {len(sells)}\n")
                    f.write(f"  Total Invested: £{total_invested:,.2f}\n")
                    f.write(f"  Total Received: £{total_received:,.2f}\n")
                    f.write(f"  Net Cash Flow: £{net_flow:,.2f}\n")
                    f.write(f"  Return: {return_pct:.2f}%\n")
                    f.write(f"  Unique Funds: {portfolio_df['isin'].nunique()}\n")
                    if not portfolio_df.empty:
                        f.write(f"  Date Range: {portfolio_df['date'].min()} to {portfolio_df['date'].max()}\n")
                    f.write("\n")
        
        print(f"📊 Summary report saved to: {report_filename}")

def main():
    """Parse both GIA and ISA PDFs using the fixed parser"""
    
    # Parse GIA PDF
    if os.path.exists("GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"):
        print("\n🔍 PARSING GIA PDF WITH FIXED PARSER")
        print("=" * 45)
        gia_parser = FixedTableParser("GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf", "GIA")
        gia_csv = gia_parser.save_fixed_analysis("fixed")
        print(f"GIA parsing complete: {gia_csv}")
    
    # Parse ISA PDF
    if os.path.exists("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"):
        print("\n🔍 PARSING ISA PDF WITH FIXED PARSER")
        print("=" * 45)
        isa_parser = FixedTableParser("ISA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf", "ISA")
        isa_csv = isa_parser.save_fixed_analysis("fixed")
        print(f"ISA parsing complete: {isa_csv}")

if __name__ == "__main__":
    main()
