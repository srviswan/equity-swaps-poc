package com.lifecycle.cashflow.util;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

@Component
public class BusinessDayCalculator {
    
    private final Set<LocalDate> holidays = new HashSet<>();
    
    public BusinessDayCalculator() {
        // Initialize with some common holidays (can be loaded from external source)
        initializeCommonHolidays();
    }
    
    /**
     * Check if a date is a business day
     */
    public boolean isBusinessDay(LocalDate date) {
        // Weekend check
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }
        
        // Holiday check
        return !holidays.contains(date);
    }
    
    /**
     * Get the next business day
     */
    public LocalDate getNextBusinessDay(LocalDate date) {
        LocalDate nextDay = date.plusDays(1);
        while (!isBusinessDay(nextDay)) {
            nextDay = nextDay.plusDays(1);
        }
        return nextDay;
    }
    
    /**
     * Get the previous business day
     */
    public LocalDate getPreviousBusinessDay(LocalDate date) {
        LocalDate prevDay = date.minusDays(1);
        while (!isBusinessDay(prevDay)) {
            prevDay = prevDay.minusDays(1);
        }
        return prevDay;
    }
    
    /**
     * Add business days to a date
     */
    public LocalDate addBusinessDays(LocalDate date, int businessDays) {
        LocalDate result = date;
        int added = 0;
        
        while (added < businessDays) {
            result = result.plusDays(1);
            if (isBusinessDay(result)) {
                added++;
            }
        }
        
        return result;
    }
    
    /**
     * Subtract business days from a date
     */
    public LocalDate subtractBusinessDays(LocalDate date, int businessDays) {
        LocalDate result = date;
        int subtracted = 0;
        
        while (subtracted < businessDays) {
            result = result.minusDays(1);
            if (isBusinessDay(result)) {
                subtracted++;
            }
        }
        
        return result;
    }
    
    /**
     * Count business days between two dates (inclusive)
     */
    public long countBusinessDays(LocalDate startDate, LocalDate endDate) {
        return startDate.datesUntil(endDate.plusDays(1))
                .filter(this::isBusinessDay)
                .count();
    }
    
    /**
     * Get the number of days between two dates
     */
    public long countDays(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    
    /**
     * Check if a date is a weekend
     */
    public boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    
    /**
     * Check if a date is a holiday
     */
    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
    
    /**
     * Add a holiday
     */
    public void addHoliday(LocalDate holiday) {
        holidays.add(holiday);
    }
    
    /**
     * Remove a holiday
     */
    public void removeHoliday(LocalDate holiday) {
        holidays.remove(holiday);
    }
    
    /**
     * Get all holidays
     */
    public Set<LocalDate> getHolidays() {
        return new HashSet<>(holidays);
    }
    
    /**
     * Initialize common holidays (US holidays as example)
     */
    private void initializeCommonHolidays() {
        int currentYear = LocalDate.now().getYear();
        
        // New Year's Day
        holidays.add(LocalDate.of(currentYear, 1, 1));
        holidays.add(LocalDate.of(currentYear + 1, 1, 1));
        
        // Martin Luther King Jr. Day (third Monday in January)
        holidays.add(getThirdMonday(currentYear, 1));
        holidays.add(getThirdMonday(currentYear + 1, 1));
        
        // Presidents' Day (third Monday in February)
        holidays.add(getThirdMonday(currentYear, 2));
        holidays.add(getThirdMonday(currentYear + 1, 2));
        
        // Memorial Day (last Monday in May)
        holidays.add(getLastMonday(currentYear, 5));
        holidays.add(getLastMonday(currentYear + 1, 5));
        
        // Independence Day
        holidays.add(LocalDate.of(currentYear, 7, 4));
        holidays.add(LocalDate.of(currentYear + 1, 7, 4));
        
        // Labor Day (first Monday in September)
        holidays.add(getFirstMonday(currentYear, 9));
        holidays.add(getFirstMonday(currentYear + 1, 9));
        
        // Columbus Day (second Monday in October)
        holidays.add(getSecondMonday(currentYear, 10));
        holidays.add(getSecondMonday(currentYear + 1, 10));
        
        // Veterans Day
        holidays.add(LocalDate.of(currentYear, 11, 11));
        holidays.add(LocalDate.of(currentYear + 1, 11, 11));
        
        // Thanksgiving Day (fourth Thursday in November)
        holidays.add(getFourthThursday(currentYear, 11));
        holidays.add(getFourthThursday(currentYear + 1, 11));
        
        // Christmas Day
        holidays.add(LocalDate.of(currentYear, 12, 25));
        holidays.add(LocalDate.of(currentYear + 1, 12, 25));
    }
    
    /**
     * Get the first Monday of a month
     */
    private LocalDate getFirstMonday(int year, int month) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        int daysUntilMonday = (8 - firstDay.getDayOfWeek().getValue()) % 7;
        return firstDay.plusDays(daysUntilMonday);
    }
    
    /**
     * Get the second Monday of a month
     */
    private LocalDate getSecondMonday(int year, int month) {
        return getFirstMonday(year, month).plusWeeks(1);
    }
    
    /**
     * Get the third Monday of a month
     */
    private LocalDate getThirdMonday(int year, int month) {
        return getFirstMonday(year, month).plusWeeks(2);
    }
    
    /**
     * Get the fourth Monday of a month
     */
    private LocalDate getFourthMonday(int year, int month) {
        return getFirstMonday(year, month).plusWeeks(3);
    }
    
    /**
     * Get the last Monday of a month
     */
    private LocalDate getLastMonday(int year, int month) {
        LocalDate lastDay = LocalDate.of(year, month, 1).plusMonths(1).minusDays(1);
        int daysUntilMonday = (lastDay.getDayOfWeek().getValue() - 1) % 7;
        return lastDay.minusDays(daysUntilMonday);
    }
    
    /**
     * Get the fourth Thursday of a month
     */
    private LocalDate getFourthThursday(int year, int month) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        int daysUntilThursday = (5 - firstDay.getDayOfWeek().getValue() + 7) % 7;
        return firstDay.plusDays(daysUntilThursday).plusWeeks(3);
    }
}
