package com.finos.cashflow.model;

import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Paginated response for cashflow queries.
 */
public class CashflowPageResponse {
    
    private List<Cashflow> content;
    private PageInfo pageable;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;
    private int size;
    private int number;
    
    // Constructors
    public CashflowPageResponse() {}
    
    public CashflowPageResponse(Page<Cashflow> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.last = page.isLast();
        this.first = page.isFirst();
        this.size = page.getSize();
        this.number = page.getNumber();
        this.pageable = new PageInfo(page.getNumber(), page.getSize());
    }
    
    // Getters and Setters
    public List<Cashflow> getContent() {
        return content;
    }
    
    public void setContent(List<Cashflow> content) {
        this.content = content;
    }
    
    public PageInfo getPageable() {
        return pageable;
    }
    
    public void setPageable(PageInfo pageable) {
        this.pageable = pageable;
    }
    
    public long getTotalElements() {
        return totalElements;
    }
    
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    
    public int getTotalPages() {
        return totalPages;
    }
    
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
    public boolean isLast() {
        return last;
    }
    
    public void setLast(boolean last) {
        this.last = last;
    }
    
    public boolean isFirst() {
        return first;
    }
    
    public void setFirst(boolean first) {
        this.first = first;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    // Supporting class
    public static class PageInfo {
        private int pageNumber;
        private int pageSize;
        
        public PageInfo() {}
        
        public PageInfo(int pageNumber, int pageSize) {
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
        }
        
        public int getPageNumber() {
            return pageNumber;
        }
        
        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
        
        public int getPageSize() {
            return pageSize;
        }
        
        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }
}
