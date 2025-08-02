#!/bin/bash

# CDM Source Navigation Script
# This script helps you navigate and explore CDM source files

CDM_SOURCES_DIR="cdm-sources"

echo "🔍 CDM Source Navigation Helper"
echo "================================"
echo ""

if [ ! -d "$CDM_SOURCES_DIR" ]; then
    echo "❌ CDM sources directory not found: $CDM_SOURCES_DIR"
    echo "Please run: jar -xf ~/.m2/repository/org/finos/cdm/cdm-java/6.0.0/cdm-java-6.0.0-sources.jar"
    exit 1
fi

echo "📁 CDM Sources Directory: $CDM_SOURCES_DIR"
echo ""

# Function to show menu
show_menu() {
    echo "Choose an option:"
    echo "1) 🔍 Find equity swap related files"
    echo "2) 📋 List all Java files"
    echo "3) 🏗️  Show product template classes"
    echo "4) 📄 Show legal documentation classes"
    echo "5) 💰 Show asset classes"
    echo "6) 📊 Show settlement classes"
    echo "7) 🔧 Show event classes"
    echo "8) 📝 View specific file"
    echo "9) 🔎 Search for specific class"
    echo "0) Exit"
    echo ""
    read -p "Enter your choice (0-9): " choice
}

# Function to find equity swap files
find_equity_swap_files() {
    echo "🔍 Finding equity swap related files..."
    echo ""
    find "$CDM_SOURCES_DIR" -name "*.java" | grep -i "equity\|swap" | head -20
    echo ""
    echo "Found $(find "$CDM_SOURCES_DIR" -name "*.java" | grep -i "equity\|swap" | wc -l) equity/swap related files"
}

# Function to list all Java files
list_java_files() {
    echo "📋 Listing all Java files..."
    echo ""
    find "$CDM_SOURCES_DIR" -name "*.java" | head -20
    echo ""
    echo "Total Java files: $(find "$CDM_SOURCES_DIR" -name "*.java" | wc -l)"
}

# Function to show product template classes
show_product_templates() {
    echo "🏗️  Product Template Classes:"
    echo ""
    find "$CDM_SOURCES_DIR/cdm/product/template" -name "*.java" | head -15
    echo ""
}

# Function to show legal documentation classes
show_legal_docs() {
    echo "📄 Legal Documentation Classes:"
    echo ""
    find "$CDM_SOURCES_DIR/cdm/legaldocumentation" -name "*.java" | head -15
    echo ""
}

# Function to show asset classes
show_asset_classes() {
    echo "💰 Asset Classes:"
    echo ""
    find "$CDM_SOURCES_DIR/cdm/product/asset" -name "*.java" | head -15
    echo ""
}

# Function to show settlement classes
show_settlement_classes() {
    echo "📊 Settlement Classes:"
    echo ""
    find "$CDM_SOURCES_DIR/cdm/product/common/settlement" -name "*.java" | head -15
    echo ""
}

# Function to show event classes
show_event_classes() {
    echo "🔧 Event Classes:"
    echo ""
    find "$CDM_SOURCES_DIR/cdm/event" -name "*.java" | head -15
    echo ""
}

# Function to view specific file
view_file() {
    read -p "Enter file path (e.g., cdm/product/template/Product.java): " file_path
    if [ -f "$CDM_SOURCES_DIR/$file_path" ]; then
        echo "📝 Viewing: $file_path"
        echo "=================================="
        head -30 "$CDM_SOURCES_DIR/$file_path"
        echo ""
        echo "... (showing first 30 lines)"
    else
        echo "❌ File not found: $CDM_SOURCES_DIR/$file_path"
    fi
}

# Function to search for specific class
search_class() {
    read -p "Enter class name to search: " class_name
    echo "🔎 Searching for: $class_name"
    echo ""
    find "$CDM_SOURCES_DIR" -name "*.java" | xargs grep -l "$class_name" | head -10
}

# Main loop
while true; do
    show_menu
    
    case $choice in
        1)
            find_equity_swap_files
            ;;
        2)
            list_java_files
            ;;
        3)
            show_product_templates
            ;;
        4)
            show_legal_docs
            ;;
        5)
            show_asset_classes
            ;;
        6)
            show_settlement_classes
            ;;
        7)
            show_event_classes
            ;;
        8)
            view_file
            ;;
        9)
            search_class
            ;;
        0)
            echo "👋 Goodbye!"
            exit 0
            ;;
        *)
            echo "❌ Invalid choice. Please enter 0-9."
            ;;
    esac
    
    echo ""
    read -p "Press Enter to continue..."
    echo ""
done 