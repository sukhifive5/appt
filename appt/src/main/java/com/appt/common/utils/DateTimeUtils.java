package com.appt.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateTimeUtils {
	protected static Logger log = Logger.getLogger(DateTimeUtils.class.getName());
	
    // default patterns
    private static final String DEFAULT_DATE_PATTERN = "MM/dd/yyyy";
    private static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
    private static final String DEFAULT_DATE_PATTERN_W_TIME = "MM/dd/yyyy hh:mm aa";
    private static SimpleDateFormat  simpleDateFormatterDefault = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
    private static SimpleDateFormat  simpleDateFormatterWithTime = new SimpleDateFormat(DEFAULT_DATE_PATTERN_W_TIME);
    private static DateTimeFormatter dateFormatterDefault = DateTimeFormat.forPattern(DEFAULT_DATE_PATTERN);
    private static DateTimeFormatter dateFormatterYYYYMMDD = DateTimeFormat.forPattern(DATE_PATTERN_YYYYMMDD);
    private static DateTimeFormatter dateFormatterWithTime = DateTimeFormat.forPattern(DEFAULT_DATE_PATTERN_W_TIME);

    // average values
    private static final int DEFAULT_PRECISION = 15;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    public static final double DAYS_IN_A_YEAR = 365.25;
    private static final BigDecimal DECIMAL_DAYS_IN_A_YEAR = new BigDecimal("365.25");
    private static final BigDecimal AVG_DAYS_IN_A_MONTH = BigDecimal.valueOf(30);
    private static final Integer NUM_MINUTES_IN_DAY = 1440;
    	
    // date comparator
    private static final DateTimeComparator DATE_ONLY_COMPARATOR = DateTimeComparator.getDateOnlyInstance();

    // accepted patterns
    private static final List<String> ACCEPTED_PATTERNS = Arrays.asList(
    			"MM/dd/yyyy","MM-dd-yyyy", "yyyyMMdd", "yyyy-MM-dd", "dd-MMM-yy");

    /**
     * returns the current system java date
     *
     * @return A Date object of the current time.
     */
    public static Date currentJavaTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Returns a DateTime object which represents the current time, measured to
     * the nearest millisecond. The behavior of this function changes in the
     * context of batch - it will return the batch date.
     *
     * @return The current time.
     */
    public static DateTime currentTime() {
        return new DateTime();
    }

    /**
     * Returns a DateTime object which represents the current system time,
     * measured to the nearest millisecond. Use this function when you need the
     * system time, not the "current" time (which may change for batch). If in
     * doubt, use currentTime().
     *
     * @return The system time.
     */
    public static DateTime systemTime() {
        return new DateTime(System.currentTimeMillis());
    }

    /**
     * Returns a new date time starting at midnight of the date given.
     * The return date time object has time starting at midnight of the date.
     * @param year
     *            The year of the new DateTime
     * @param month
     *            The month of the new DateTime.input month, 1 based not like native Java calendar.
     * @param dayOfMonth
     *            The day of the new DateTime
     * @return A DateTime object with all 0s for hours, minutes, seconds, and
     *         milliseconds
     */
    public static DateTime atMidnightOf(int year, int month, int dayOfMonth) {
        return new DateTime(year, month, dayOfMonth, 0, 0, 0, 0);
    }

    /**
     * Returns a new DateTime with current system time, and date from {@code aDate}
     *
     * @param aDate is a DateTime from which the return value is derived
     * @return <code>DateTime</code>
     */
    public static DateTime getCurrentTimeOf(DateTime aDate) {
        return DateTimeUtils.systemTime()
                            .withDate(aDate.getYear(), aDate.getMonthOfYear(),
            aDate.getDayOfMonth());
    }

    /**
     * Returns a new date time starting at midnight of the date given.
     *
     * @param dateTime
     *            DateTime object to normalize to mid night
     * @return A DateTime object with all 0s for hours, minutes, seconds, and
     *         milliseconds
     */
    public static DateTime toMidnight(DateTime dateTime) {
        validateDateNotNull(dateTime);

        return atMidnightOf(dateTime.getYear(), dateTime.getMonthOfYear(),
            dateTime.getDayOfMonth());
    }

    /**
     * Determines if the given date is today.
     *
     * @param dateTime
     *            A dateTime object
     * @return True if the given date is today. False otherwise.
     *
     */
    public static boolean isToday(DateTime dateTime) {
        return DATE_ONLY_COMPARATOR.compare(currentTime(), dateTime) == 0;
    }

    /**
     * Determines if the provided date is after today.<br>
     * The time component is ignored
     *
     * @param date is the date to evaluate
     * @return <code>boolean</code>
     */
    public static boolean isAFutureDate(DateTime date) {
        return DATE_ONLY_COMPARATOR.compare(currentTime(), date) < 0;
    }

    /**
     * Return today at mid night.
     * The return date time object has time starting at midnight of the date.
     * @return today at mid night.
     */
    public static DateTime today() {
        return toMidnight(currentTime());
    }

    /**
     * Convenience method for converting a DateTime object to a Date object.
     *
     * @param dateTime
     *            A DateTime object.
     * @return The converted Date object.
     */
    public static Date toDate(DateTime dateTime) {
        Date retval = null;

        if (dateTime != null) {
            retval = dateTime.toDate();
        }

        return retval;
    }

    /**
     * This method returns Last of Current Month.The return date time object has time
     * starting at midnight of the date.
     *
     * @param inputDate
     *                Input Date
     * @return Last Date of the Current Month
     */
    public static DateTime getLastDayOfMonth(DateTime inputDate) {
        return getFirstDayOfMonth(inputDate).plusMonths(1).minusDays(1);
    }

    /**
     * This method returns the First of the current month of a given input date
     * i.e June 1st, July 1st.The return date time object has time starting at
     * midnight of the date.
     *
     * @param inputDate
     *                Input Date
     * @return Start Date of the current month.
     */
    public static DateTime getFirstDayOfMonth(DateTime inputDate) {
        return toMidnight(inputDate).withDayOfMonth(1);
    }

    /**
     * return MIDNIGHT  date. Overload of {@link #toMidnight(DateTime)}
     * The return date time object has time starting at midnight of the date.
     *
     * @param dateTime incoming date
     *
     * @return final date
     */
    public static DateTime truncateDateTime(DateTime dateTime) {
        return toMidnight(dateTime);
    }

    
    /**
     * This method is used to add hours to a date.
     *
     * @param inputDate
     *                input date
     * @param hours
     *                number of hours to be added to date
     * @return DateTime new dateTime
     */
    public static DateTime addHours(DateTime inputDate, int hours) {
        return inputDate.plusHours(hours);
    }
    
    /**
     * This method is used to add minutes to a date.
     *
     * @param inputDate
     *                input date
     * @param hours
     *                number of hours to be added to date
     * @return DateTime new dateTime
     */
    public static DateTime addMinutes(DateTime inputDate, int minutes) {
        return inputDate.plusMinutes(minutes);
    }
    
    /**
     * This method is used to add days to a date.
     * The return date time object has time starting at midnight of the date.
     *
     * @param inputDate
     *                input date
     * @param days
     *                number of days to be added to date
     * @return Date new date
     */
    public static DateTime addDays(DateTime inputDate, int days) {
        return toMidnight(inputDate).plusDays(days);
    }

    /**
     * This method creates January 1st Date for an Input Year.
     * The return date time object has time starting at midnight of the date.
     *
     * @param year
     *                Input Year
     * @return Date - January 1st of the Year
     *
     */
    public static DateTime firstDayOfYear(int year) {
        return atMidnightOf(year, 01, 01);
    }

    /**
     * This method creates January 2nd Date for an Input Year.
     * The return date time object has time starting at midnight of the date.
     * @param year
     *                Input Year
     * @return DateTime - January 2nd of the Year
     */
    public static DateTime secondDayOfYear(int year) {
        return atMidnightOf(year, 01, 02);
    }

    /**
     * This method creates December 31st Date for an Input Year.
     * The return date time object has time starting at midnight of the date.
     * @param year
     *                Input Year
     * @return Date - December 31st of the Year
     *
     */
    public static DateTime lastDayOfYear(int year) {
        return atMidnightOf(year, 12, 31);
    }

    /**
     * This method is used to add months to a date. The return date time object
     * has time starting at midnight of the date.
     *
     * @param inputDate
     *                input date
     * @param months
     *                number of months to be added to date
     * @return Date new date
     */
    public static DateTime addMonths(DateTime inputDate, int months) {
        return toMidnight(inputDate).plusMonths(months);
    }

    /**
     * This method is used to add years to a date. The return date time object
     * has time starting at midnight of the date.
     *
     * @param inputDate
     *                input date
     * @param years
     *                number of years to be added to date
     * @return Date new date
     */
    public static DateTime addYears(DateTime inputDate, int years) {
        return toMidnight(inputDate).plusYears(years);
    }

    /**
     * This method returns the difference in dates. Time portions in the input dates
     * are ignored in calculation. In particular, the duration between two instances
     * of dates in the same day with different time will return 0. If end date
     * is before start date, the duration returned may be negative.
     *
     * Do not use this method to perform interest calculations. Use
     * {@link #getDaysInclusive(Date, Date)}
     *
     * Examples:
     * <pre>
     * [12/01/2009 6:30AM, 12/01/2009 5:30AM] => 0
     * [02/25/2009 6:30AM, 02/26/2009 5:30AM] => 1
     * [02/26/2009 6:30AM, 02/25/2009 5:30AM] => -1
     * </pre>
     *
     * @param startDate
     *                start date
     * @param endDate
     *                end date
     * @return int difference between start and end dates in days
     */
    public static int getDuration(DateTime startDate, DateTime endDate) {
        DateTime startDateTime = toMidnight(startDate);
        DateTime endDateTime = toMidnight(endDate);

        return new Period(startDateTime, endDateTime, PeriodType.days()).getDays();
    }

    /**
     * Convenience method for converting a Date object to a DateTime object.
     *
     * @param date A Date object.
     * @return The converted DateTime object.
     */
    public static DateTime fromDate(Date date) {
        DateTime retval = null;

        if (date != null) {
            retval = new DateTime(date);
        }

        return retval;
    }

    /**
     * Converts a Date from String of format (yyyy-MM-dd) to DateTime object.
     *
     * @param date A Date represented as String in (yyyy-MM-dd) format
     * @return The converted DateTime object.
     */
    public static DateTime dateFromString(String date) {
        return dateFormatterDefault.parseDateTime(date);
    }

    /**
     * Parse the date using MM/dd/yyyy,MM-dd-yyyy, MMddyyyy formats.
     * The return date time object has time starting at midnight of the date.
     *
     * @param dateString input date
     * @return return a date
     */
    public static DateTime parseDate(String dateString) {
        for (String acceptedFormat : ACCEPTED_PATTERNS) {
        	try {
        		DateTime dt = DateTime.parse(dateString,
        				DateTimeFormat.forPattern(acceptedFormat));
        		return dt;
        	} catch (IllegalArgumentException e) {
        		
        	}
        }

        return null;
    }

    
    /**
     * Builds a DateTime object with date, time interval, and number of intervals in day
     *
     * @param dateString input date (date only)
     * @param intervalNum interval in day
     * @param numIntervalsInDay total number of intervals in day
     * @return return a date
     */
    public static DateTime toDateTime(String dateString, Integer intervalNum, Integer numIntervalsInDay) {
    	// parse date only portion
    	DateTime dt = parseDate(dateString);
    	
    	// calculate time of day (using mod function to round - should be even number anyhow)
    	Integer numMinPerInterval = NUM_MINUTES_IN_DAY / numIntervalsInDay;
    	Integer minOfDay = numMinPerInterval * intervalNum;
    	return addMinutes(dt, minOfDay); 
    }
    
    /**
     * This method checks for Leap Year.
     *
     * @param inputYear Input Year
     * @return <code>boolean</code> true if Leap Year
     */
    public static boolean isLeapYear(int inputYear) {
        //not using JODA API due to the simplicity of leap year calculation and faster performance
        return ((inputYear % 4) == 0) &&
        (((inputYear % 100) != 0) || ((inputYear % 400) == 0));
    }

    /**
     * This method returns the First of the month following a given input date.
     * i.e June 1st, July 1st.
     * The return date time object has time starting at midnight of the date.
     *
     * @param inputDate Input Date
     * @return Date Start Date
     *
     */
    public static DateTime getFirstOfNextMonth(DateTime inputDate) {
        return getFirstDayOfMonth(inputDate).plusMonths(1);
    }

    /**
     * This method returns the First of the following month.
     * i.e date used as a basis is system date.
     *
     *  if today is first of the month - today is returned.
     *
     * The return date time object has time starting at midnight of the date.
     *
     * @return Date Start Date
     *
     */
    public static DateTime getNextFirstOfTheMonth() {
        DateTime firstOfTheMonth = DateTimeUtils.getFirstDayOfMonth(DateTimeUtils.today());

        if (DateTimeUtils.isSameDate(DateTimeUtils.today(), firstOfTheMonth)) {
            return firstOfTheMonth;
        }

        return getFirstDayOfMonth(DateTimeUtils.today()).plusMonths(1);
    }

    /**
     * This method returns the Last of the month following a given input date
     * i.e June 30th, July 31st.
     * The return date time object has time starting at midnight of the date.
     *
     * @param inputDate Input Date
     * @return Date Effective Date
     */
    public static DateTime getLastOfNextMonth(DateTime inputDate) {
        return getFirstDayOfMonth(inputDate).plusMonths(2).minusDays(1);
    }

    /**
     * This method returns the first of January of the year following the
     * current system year.
     * The return date time object has time starting at midnight of the date.
     * @return Date Start Date
     */
    public static DateTime getJanuaryFirstOfNextYear() {
        return getJanuaryFirstOfCurrentYear().plusYears(1);
    }

    /**
     * This method returns the first of January of the current system year.
     * The return date time object has time starting at midnight of the date.
     * @return Date Start Date
     */
    public static DateTime getJanuaryFirstOfCurrentYear() {
        return getJanuaryFirstForYear(currentTime().getYear());
    }

    /**
     * This method returns the first of January of the given year.
     * The return date time object has time starting at midnight of the date.
     * @param year
     *                Year to Find the January for
     * @return Date Start Date
     */
    public static DateTime getJanuaryFirstForYear(int year) {
        return atMidnightOf(year, 1, 1);
    }

    /**
     * This method returns the last of the month before to a given input date i.e
     * July 1, then last of prior month June 30.
     * The return date time object has time starting at midnight of the date.
     * @param inputDate
     *                Input Date
     * @return Date Effective Date
     */
    public static DateTime getLastDayOfMonthBefore(DateTime inputDate) {
        return toMidnight(inputDate).withDayOfMonth(1).minusDays(1);
    }

    /**
     * This method returns Last of Current Month.
     * The return date time object has time starting at midnight of the date.
     * @return Last day of Current Year
     */
    public static DateTime getLastDayOfCurrentYear() {
        return getJanuaryFirstOfNextYear().minusDays(1);
    }

    /**
     * This method returns the First of a month after a number of months given
     * as in input.The return date time object has time starting at midnight of the date.
     *
     * @param inputDate
     *                Input Date
     * @param months input months
     * @return first of a month after a number of months given
     */
    public static DateTime getFirstOfMonthAfterMonths(DateTime inputDate,
        int months) {
        return toMidnight(inputDate.withDayOfMonth(1)).plusMonths(months);
    }

    /**
     * This method returns the day of the month of a given input date i.e. May
     * 10th, 2008 will return 10
     *
     * @param inputDate
     *                Input Date
     * @return int dayOfMonth
     */
    public static int getDayOfMonth(DateTime inputDate) {
        validateDateNotNull(inputDate);

        return inputDate.getDayOfMonth();
    }

    /**
     * This method gets the day of the month of a given input date.
     * The return date time object has time starting at midnight of the date.
     * @param inputDate
     *                Input Date
     * @param day
     *                day
     *
     * @return int dayOfMonth
     */
    public static DateTime withDayOfMonth(DateTime inputDate, int day) {
        return toMidnight(inputDate).withDayOfMonth(day);
    }

    /**
     * This method returns the 15th of the input date month i.e June 15th, July
     * 15th.The return date time object has time starting at midnight of the date.
     *
     * @param inputDate
     *                Input Date
     * @return Date Effective Date
     */
    public static DateTime getFifteenthOfMonth(DateTime inputDate) {
        return withDayOfMonth(inputDate, 15);
    }

    /**
     * This method returns the 14th of the input date month if the month is February.
     * The return date time object has time starting at midnight of the date.
     *
     * @param inputDate
     *                Input Date
     * @return Date Effective Date
     */
    public static DateTime getFourteenthOfMonth(DateTime inputDate) {
        return withDayOfMonth(inputDate, 14);
    }

    /**
     * The purpose of this method is to find the last day of the week.
     * The return date time object has time starting at midnight of the date.
     * Jan/30/2010 returns Jan/30/2010
     * Mar/26/2010 returns Mar/27/2010
     * @param inputDate
     *                Input Date
     * @return Date Effective Date
     */
    public static DateTime getLastDayOfTheWeek(DateTime inputDate) {
        return toMidnight(inputDate).withDayOfWeek(6);
    }

    /**
     * The purpose of this method is to find the first day(Sunday) of the week.
     * The return date time object has time starting at midnight of the date.
     *
     *  Jan/26/2010 returns  Jan/24/2010
     *  Mar/26/2010 returns Mar/21/2010
     *
     * @param inputDate
     *                Input Date
     * @return Date Effective Date
     */
    public static DateTime getFirstDayOfTheWeek(DateTime inputDate) {
        return toMidnight(inputDate).plusDays(1).withDayOfWeek(1).minusDays(1);
    }

    /**
     * This method checks if a date falls between two dates including those two
     * days.
     *
     * @param checkDate -
     *                the date needs to be checked.
     * @param beginDate -
     *                Begin Date
     * @param endDate -
     *                End Date
     *
     * @return boolean true if the date is between the range
     */
    public static boolean isDateBetweenRange(DateTime checkDate,
        DateTime beginDate, DateTime endDate) {
        validateDateNotNull(checkDate);
        validateDateNotNull(beginDate);
        validateDateNotNull(endDate);

        if (beginDate.isAfter(endDate)) {
            throw new IllegalArgumentException(
                "Begin date must be before end date.");
        }

        return (DATE_ONLY_COMPARATOR.compare(checkDate, beginDate) >= 0) &&
        (DATE_ONLY_COMPARATOR.compare(checkDate, endDate) <= 0);
    }

    /**
     * Checks if dates are in the same year.
     *
     * @param date1 the date1
     * @param date2 the date2
     *
     * @return true, if is same year
     */
    public static boolean isInSameYear(DateTime date1, DateTime date2) {
        validateDateNotNull(date1);
        validateDateNotNull(date2);

        return date1.getYear() == date2.getYear();
    }

    /**
     * Determines the date at which a person attains a given age.
     * The return date time object has time starting at midnight of the date.
     * @param birthDate
     *                Persons date of birth
     * @param age
     *                The attained age for which the date is determined
     * @return <code>Date</code>
     */
    public static DateTime getDateOfAGivenAge(DateTime birthDate, int age) {
        return toMidnight(birthDate).plusYears(age);
    }

    /**
     * Checks if is in same day, month and year
     *
     * @param date1 the date1
     * @param date2 the date2
     *
     * @return true, if is same day, month and year
     *
     */
    public static boolean isSameDate(DateTime date1, DateTime date2) {
        validateDateNotNull(date1);
        validateDateNotNull(date2);

        return (date1.getDayOfMonth() == date2.getDayOfMonth()) &&
        (date1.getMonthOfYear() == date2.getMonthOfYear()) &&
        (date1.getYear() == date2.getYear());
    }

    /**
     * Checks if dates is in same week. 2 dates are in same week if they both
     * fall within Monday to Sunday of the week per ISO8601.
     *
     * @param date1
     *            the date1
     * @param date2
     *            the date2
     *
     * @return true, if is same week
     *
     */
    public static boolean isInSameWeek(DateTime date1, DateTime date2) {
        validateDateNotNull(date1);
        validateDateNotNull(date2);

        return (date1.getWeekOfWeekyear() == date2.getWeekOfWeekyear()) &&
        (Math.abs(DateTimeUtils.getDaysBetween(date1, date2)) < 7);
    }

    /**
     * Checks if is in same month.
     *
     * @param date1 the date1
     * @param date2 the date2
     *
     * @return true, if is same month
     *
     */
    public static boolean isInSameMonth(DateTime date1, DateTime date2) {
        validateDateNotNull(date1);
        validateDateNotNull(date2);

        return (date1.getMonthOfYear() == date2.getMonthOfYear()) &&
        (date1.getYear() == date2.getYear());
    }

    /**
     * Return next month , the return date time object has time starting at midnight of the date.
     *
     * @param date input date
     *
     * @return next month date
     */
    public static DateTime getNextMonth(DateTime date) {
        return addMonths(date, 1);
    }

    /**
     * return the difference as fraction of years
     * @param startDate input start date
     * @param endDate input end date
     * @return difference as fraction of years
     *
     */
    public static BigDecimal getYearsBetweenDatesAsFraction(
        DateTime startDate, DateTime endDate) {
        validateDateNotNull(startDate);
        validateDateNotNull(endDate);

        Days days = Days.daysBetween(startDate, endDate);

        return BigDecimal.valueOf(days.getDays())
                         .divide(DECIMAL_DAYS_IN_A_YEAR, DEFAULT_PRECISION,
            ROUNDING_MODE);
    }

    /**
     * Return the difference as fraction of months. The returned value is at best an estimate for the number of months.
     * This API may be removed in future releases.
     *
     * @param startDate input start date
     * @param endDate input end date
     * @return difference as fraction of years
     */
    public static BigDecimal getMonthsBetweenDatesAsFraction(
        DateTime startDate, DateTime endDate) {
        validateDateNotNull(startDate);
        validateDateNotNull(endDate);

        Days days = Days.daysBetween(startDate, endDate);

        return BigDecimal.valueOf(days.getDays())
                         .divide(AVG_DAYS_IN_A_MONTH, DEFAULT_PRECISION,
            ROUNDING_MODE);
    }

    /**
     * This method will return max date for the passed in array of date times.
     * Null date times are ignored. If all passed in dates are null, this method returns null.
     *
     * @param dateTimes date times to search for max date
     *
     * @return max date for the passed in array of date times.
     */
    public static DateTime maxDate(DateTime... dateTimes) {
        DateTime maxDate = null;

        if (dateTimes != null) {
            for (DateTime d : dateTimes) {
                if ((maxDate == null) || ((d != null) && maxDate.isBefore(d))) {
                    maxDate = d;
                }
            }
        }

        return maxDate;
    }

    /**
     * This method will return minimum date for the passed in array of date times.
     * Null date times are ignored. If all passed in dates are null, this method returns null.
     *
     * @param dateTimes date times to search for minimum date
     *
     * @return minimum date for the passed in array of date times.
     */
    public static DateTime minDate(DateTime... dateTimes) {
        DateTime minDate = null;

        if (dateTimes != null) {
            for (DateTime d : dateTimes) {
                if ((minDate == null) || ((d != null) && minDate.isAfter(d))) {
                    minDate = d;
                }
            }
        }

        return minDate;
    }

    /**
     * This method returns the actual month number - 1 for January (not 0), 2
     * for February, etc.
     *
     * @param date
     *                The date from which to obtain the month
     * @return month The month integer (between 1 and 12)
     */
    public static int month(DateTime date) {
        validateDateNotNull(date);

        return date.getMonthOfYear();
    }

    /**
     * This method returns the year of a given date.
     *
     * @param date
     *                The date from which to obtain the year
     * @return year The year integer
     */
    public static int year(DateTime date) {
        validateDateNotNull(date);

        return date.getYear();
    }

    /**
     * Get months between two dates.
     *
     * @param startDate startDate
     * @param endDate endDate
     * @return number of months.
     */
    public static int getMonthsBetween(DateTime startDate, DateTime endDate) {
        return new Period(toMidnight(startDate), toMidnight(endDate),
            PeriodType.months()).getMonths();
    }

    /**
     * Get days between two dates.
     *
     * @param startDate startDate
     * @param endDate endDate
     * @return number of days.
     */
    public static int getDaysBetween(DateTime startDate, DateTime endDate) {
        return new Period(toMidnight(startDate), toMidnight(endDate),
            PeriodType.days()).getDays();
    }

    /**
     * Get months between two dates. Process is exclusive for BRS 253
     *
     *  In case negative value is determined. It will default to Zero value.
     *
     *  This will occur if START and END date in the same month:
     *   -  Start date is NOT first of the month.
     *   -  End date is NOT last day of the month.
     *
     * @param startDate startDate
     * @param endDate endDate
     * @return number of months.
     */
    public static int getFullCalendarMonthsFor(DateTime startDate,
        DateTime endDate) {
        int numberOfFullCalendarMonths = 0;
        boolean isLastDayOfTheMonth = DateTimeUtils.isSameDate(endDate,
                DateTimeUtils.getLastDayOfMonth(endDate));

        if (DateTimeUtils.isInSameMonth(startDate, endDate) &&
                isLastDayOfTheMonth && (startDate.getDayOfMonth() == 1)) {
            numberOfFullCalendarMonths = getMonthsBetween(startDate, endDate);
        } else {
            numberOfFullCalendarMonths = getCalendarMonthsBetween(startDate,
                    endDate, isLastDayOfTheMonth);
        }

        return numberOfFullCalendarMonths;
    }

    /**
     *  Gets calendar months for given start and end date.
     *
     *
     * @param startDate The start date of the month.
     * @param endDate The end date of the month
     * @param isLastDayOfTheMonth Indicator if end date if last day of the month.
     *
     * @return <code>int</code>
     */
    private static int getCalendarMonthsBetween(DateTime startDate,
        DateTime endDate, boolean isLastDayOfTheMonth) {
        if (startDate.getDayOfMonth() > 1) {
            startDate = getFirstOfNextMonth(startDate);
        }

        if (!isLastDayOfTheMonth) {
            endDate = getLastDayOfMonth(endDate.minusMonths(1));
        }

        return Math.max(getMonthsInclusive(toMidnight(startDate),
                toMidnight(endDate)), 0);
    }

    /**
     * Calculate months between two dates including the start and end date.
     *
     * @param startDate startDate
     * @param endDate endDate
     * @return number of months.
     */
    public static int getMonthsInclusive(DateTime startDate, DateTime endDate) {
        return new Period(toMidnight(startDate),
            toMidnight(endDate.plusDays(1)), PeriodType.months()).getMonths();
    }

    /**
     * Ensure parameter is not null.
     * @param dateTime dateTime to validate.
     */
    private static void validateDateNotNull(DateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }

    /**
     * Ensure parameter is not null.
     * @param dateTime dateTime to validate.
     */
    private static void validateDateNotNull(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }
        
    /**
     * Converts a Date from DateTime object to String forma
     *
     * @param date A Date represented as by DateTime object
     * @return The String representation of the DataTime object in format.
     */
    public static String toString(Date date) {
        if (date != null)
        	return simpleDateFormatterDefault.format(date);
        else
        	return "";
    }
    
    /**
     * Converts a Date from DateTime object to String forma
     *
     * @param date A Date represented as by DateTime object
     * @return The String representation of the DataTime object in format.
     */
    public static String toString(DateTime date) {
        if (date != null)
        	return dateFormatterDefault.print(date);
        else
        	return "";
    }

    /**
     * Converts a Date from DateTime object to String format.
     *
     * @param date A Date represented as by DateTime object
     * @return The String representation of the DataTime object in format.
     */
    public static String toStringYYYYMMDD(DateTime date) {
        if (date != null)
        	return dateFormatterYYYYMMDD.print(date);
        else
        	return "";
    }
    
    /**
     * Converts a Date from DateTime object to String format (MM/dd/yyyy hh:mm aa).
     *
     * @param date
     *            A Date represented as by DateTime object
     * @return The String representation of the DataTime object in (MM/dd/yyyy hh:mm aa)
     *         format.
     */
    public static String toDisplayStringWithTime(DateTime date) {
        if (date != null)
        	return dateFormatterWithTime.print(date);
        else
        	return "";
    }
    
    
    /**
     * Converts a Date from DateTime object to String format (MM/dd/yyyy hh:mm aa).
     *
     * @param date
     *            A Date represented as by Date object
     * @return The String representation of the DataTime object in (MM/dd/yyyy hh:mm aa)
     *         format.
     */
    public static String toDisplayStringWithTime(Date date) {
        if (date != null)
        	return simpleDateFormatterWithTime.format(date); 
        else
        	return "";
    }
    
    /**
     * Prevailing time ignores Daylight savings time adjustment - this method
     * will convert back to Daylight Savings Time.
     * 
     * @param date
     * @return DST date
     */
    public static boolean isDayLightSaving(Date prevailingDate) {
    	 Calendar calendar = Calendar.getInstance();  
         calendar.setTime(prevailingDate); 
         TimeZone timezone=calendar.getTimeZone(); 
         int offset = timezone.getOffset(prevailingDate.getTime());
         //log.debug(toDisplayStringWithTime(prevailingDate) + " " + timezone.getDisplayName() + "  offset: " + offset);
         
         // -8 hours offset is standard time
         // -7 hours offset is day light savings time
         if (offset != -28800000)
         {
        	 return true;
         }
         else
         {
        	 return false;
         }
    }
}
