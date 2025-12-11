package com.finos.cashflow.model;

import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Paginated response for daily accrual queries.
 */
public class DailyAccrualPageResponse {
    
    private List<DailyAccrual> content;
    private CashflowPageResponse.PageInfo pageable;
    private long totalElements;
    private int totalPages;
    
    // Constructors
    public DailyAccrualPageResponse() {}
    
    public DailyAccrualPageResponse(Page<DailyAccrual> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.pageable = new CashflowPageResponse.PageInfo(page.getNumber(), page.getSize());
    }
    
    // Getters and Setters
    public List<DailyAccrual> getContent() {
        return content;
    }
    
    public void setContent(List<DailyAccrual> content) {
        this.content = content;
    }
    
    public CashflowPageResponse.PageInfo getPageable() {
        return pageable;
    }
    
    public void setPageable(CashflowPageResponse.PageInfo pageable) {
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
}
