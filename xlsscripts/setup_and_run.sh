#!/bin/bash
# Trading PDF Analyzer Setup and Run Script

echo "============================================="
echo "Trading PDF Analyzer Setup"
echo "============================================="

# Check if Python is installed
if ! command -v python3 &> /dev/null; then
    echo "Error: Python 3 is not installed. Please install Python 3.8 or higher."
    exit 1
fi

# Check if pip is installed
if ! command -v pip3 &> /dev/null; then
    echo "Error: pip3 is not installed. Please install pip."
    exit 1
fi

# Check if Java is installed (required for tabula-py)
if ! command -v java &> /dev/null; then
    echo "Warning: Java is not installed. Installing Java is recommended for advanced table extraction."
    echo "On macOS: brew install openjdk"
    echo "On Ubuntu: sudo apt install default-jdk"
    echo "On Windows: Download from Oracle or OpenJDK website"
fi

echo "Installing required Python packages..."
pip3 install -r requirements.txt

echo "============================================="
echo "Installation Complete!"
echo "============================================="

# Check if PDF file exists
PDF_FILE="docs/GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"

if [ -f "$PDF_FILE" ]; then
    echo "Found PDF file: $PDF_FILE"
    echo "Running analysis..."
    python3 trading_pdf_analyzer.py "$PDF_FILE"
else
    echo "PDF file not found at: $PDF_FILE"
    echo ""
    echo "Usage:"
    echo "  python3 trading_pdf_analyzer.py <path_to_pdf_file>"
    echo ""
    echo "Example:"
    echo "  python3 trading_pdf_analyzer.py GIA_Trading_statement_1_Sep_2023_to_11_Apr_2025.pdf"
fi

echo "============================================="
