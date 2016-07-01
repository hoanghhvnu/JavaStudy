package hoanghh.study.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

public class DateUtils {

	public static String humanReadableDuration(final Date start, final Date end) {
		final long milis = end.getTime() - start.getTime();
		long tempLong = milis;
		long[] convert = {1000, 60, 60, 24};
		StringBuilder sb = new StringBuilder();
		for (long con : convert) {
			sb.insert(0, " " + String.valueOf(tempLong % con));
//			System.out.println(tempLong + "%" + con + "=" + String.valueOf(tempLong % con));
			tempLong /= con;
//			System.out.println("Remain: " + tempLong);
			if (con == 24) {
				sb.insert(0, String.valueOf(tempLong) + " days");
			}
			if (tempLong == 0) {
				break;
			}
		}
		
		return sb.toString();
	} // end method
	
    public static Date parseDate(final String s) {
        String[] separators = { "/", "-" };
        String separator = "";
        for (String se : separators) {
            if (s.contains(se)) {
                separator = se;
            }
        }
        if (separator.length() == 0) {
            throw new IllegalArgumentException("Cannot determine separator with date string:'" + s + "'");
        }
        String[] dateArr = s.split(separator);
        Date ret = parseDate(dateArr);

        return ret;
    } // end method

    protected static Date parseDate(String[] arr) {
        try {
            DateFormat dFormat;
            String year = "";
            String month = "";
            String day = "";
            switch (arr.length) {
                case 1:
                    // parse only year
                    dFormat = new SimpleDateFormat("yyyy");
                    return dFormat.parse(arr[0]);
                case 2:
                    // parse year, month
                    if (arr[0].length() > arr[1].length()) {
                        year = arr[0];
                        month = arr[1];
                    } else {
                        year = arr[1];
                        month = arr[0];
                    }

                    dFormat = new SimpleDateFormat("yyyy/MM");
                    return dFormat.parse(year + "/" + month);
                case 3:
                    // parse year, month, day
                    int yearIndex = Integer.MAX_VALUE;
                    int monthIndex = Integer.MAX_VALUE;
                    int dayIndex = Integer.MAX_VALUE;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i].length() == 4) {
                            year = arr[i];
                            yearIndex = i;
                        } else {
                            int value = Integer.parseInt(arr[i]);
                            if (value > 12) {
                                day = arr[i];
                                dayIndex = i;
                            }
                        }
                    }

                    if (dayIndex != Integer.MAX_VALUE) {
                        for (int i = 0; i < arr.length; i++) {
                            if (i != yearIndex && i != dayIndex) {
                                month = arr[i];
                            }
                        }
                    } else {
                        if (yearIndex == 0) {
                            monthIndex = 1;
                            dayIndex = 2;
                            month = arr[monthIndex];
                            day = arr[dayIndex];
                        } else {
                            throw new IllegalArgumentException("Cannot determine which is month, day:'"
                                    + arr.toString() + "'");
                        }
                    }

                    if (day.length() != 0 && month.length() != 0 && year.length() != 0) {
                        dFormat = new SimpleDateFormat("yyyy/MM/dd");
                        return dFormat.parse(String.format("%s/%s/%s", year, month, day));
                    }
                    break;
                default:
                    return null;
            }

        } catch (ParseException e) {
            //
        }

        return null;
    }

    /**
     * convert unix time to Date time readable
     * 
     * @return
     */
    public static String convertUnixTimeToDateString(long unixMilis) {
        Date date = new Date(unixMilis); // *1000 is to convert seconds to
                                         // milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // the
                                                                            // format
                                                                            // of
                                                                            // your
                                                                            // date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7")); // give a timezone
                                                        // reference for
                                                        // formating (see
                                                        // comment at the bottom

        return sdf.format(date);
    } // end method

    /**
     * 
     * @return String represent current time with specify format
     */
    public static String currentTime() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

        return formater.format(date);
    } // end method

    public static String rangeDateAsString(final Iterable<String> rangeDate) {
        String ret = "";
        for (String date : rangeDate) {
            ret += date + "\t";
        }

        return ret;
    } // end method

    /**
     * Generate list of string date from to with format yyyy/MM/dd
     * 
     * @param from
     * @param to
     * @return
     */
    public static List<String> generateRangeDate(String from, String to) {
        List<String> rangeDate = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date fromDate = format.parse(from);
            Date toDate = format.parse(to);

            Calendar current = Calendar.getInstance();
            current.setTime(fromDate);
            while (current.getTime().compareTo(toDate) <= 0) {
                rangeDate.add(format.format(current.getTime()));
                current.add(Calendar.DAY_OF_MONTH, 1);
            } // end while
        } catch (ParseException e) {
            e.printStackTrace();
            // log here
        } // end try

        return rangeDate;
    } // end method

    public static List<String> generateRangeDate(TreeSet<String> rangeDate) {
        boolean isFirst = true;
        String from = "";
        String to = "";
        for (String date : rangeDate) {
            if (isFirst) {
                from = date;
                isFirst = false;
            } else {
                to = date;
            } // end if
        } // end for

        return generateRangeDate(from, to);
    } // end method

    /**
     * 
     * @param dateString
     * @return
     */
    public static Date parse(String dateString, String formaterString) {
        SimpleDateFormat formater = new SimpleDateFormat(formaterString);
        try {
            return formater.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    } // end method

    public static boolean dayDiffNotFar(Date dateFrom, Date dateTo, int days) {
        Calendar calFrom = Calendar.getInstance();
        calFrom.setTime(dateFrom);
        Calendar carTo = Calendar.getInstance();
        carTo.setTime(dateTo);
        calFrom.add(Calendar.DAY_OF_YEAR, days);

        return !isBeforeDay(calFrom, carTo) || isAfterDay(calFrom, carTo);

    }

    /**
     * <p>
     * Checks if two dates are on the same day ignoring time.
     * </p>
     * 
     * @param date1
     *            the first date, not altered, not null
     * @param date2
     *            the second date, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException
     *             if either date is <code>null</code>
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * <p>
     * Checks if two calendars represent the same day ignoring time.
     * </p>
     * 
     * @param cal1
     *            the first calendar, not altered, not null
     * @param cal2
     *            the second calendar, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException
     *             if either calendar is <code>null</code>
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2
                .get(Calendar.DAY_OF_YEAR));
    }

    /**
     * <p>
     * Checks if a date is today.
     * </p>
     * 
     * @param date
     *            the date, not altered, not null.
     * @return true if the date is today.
     * @throws IllegalArgumentException
     *             if the date is <code>null</code>
     */
    public static boolean isToday(Date date) {
        return isSameDay(date, Calendar.getInstance().getTime());
    }

    /**
     * <p>
     * Checks if a calendar date is today.
     * </p>
     * 
     * @param cal
     *            the calendar, not altered, not null
     * @return true if cal date is today
     * @throws IllegalArgumentException
     *             if the calendar is <code>null</code>
     */
    public static boolean isToday(Calendar cal) {
        return isSameDay(cal, Calendar.getInstance());
    }

    /**
     * <p>
     * Checks if the first date is before the second date ignoring time.
     * </p>
     * 
     * @param date1
     *            the first date, not altered, not null
     * @param date2
     *            the second date, not altered, not null
     * @return true if the first date day is before the second date day.
     * @throws IllegalArgumentException
     *             if the date is <code>null</code>
     */
    public static boolean isBeforeDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isBeforeDay(cal1, cal2);
    }

    /**
     * <p>
     * Checks if the first calendar date is before the second calendar date
     * ignoring time.
     * </p>
     * 
     * @param cal1
     *            the first calendar, not altered, not null.
     * @param cal2
     *            the second calendar, not altered, not null.
     * @return true if cal1 date is before cal2 date ignoring time.
     * @throws IllegalArgumentException
     *             if either of the calendars are <code>null</code>
     */
    public static boolean isBeforeDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        if (cal1.get(Calendar.ERA) < cal2.get(Calendar.ERA))
            return true;
        if (cal1.get(Calendar.ERA) > cal2.get(Calendar.ERA))
            return false;
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR))
            return true;
        if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR))
            return false;
        return cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * <p>
     * Checks if the first date is after the second date ignoring time.
     * </p>
     * 
     * @param date1
     *            the first date, not altered, not null
     * @param date2
     *            the second date, not altered, not null
     * @return true if the first date day is after the second date day.
     * @throws IllegalArgumentException
     *             if the date is <code>null</code>
     */
    public static boolean isAfterDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isAfterDay(cal1, cal2);
    }

    /**
     * <p>
     * Checks if the first calendar date is after the second calendar date
     * ignoring time.
     * </p>
     * 
     * @param cal1
     *            the first calendar, not altered, not null.
     * @param cal2
     *            the second calendar, not altered, not null.
     * @return true if cal1 date is after cal2 date ignoring time.
     * @throws IllegalArgumentException
     *             if either of the calendars are <code>null</code>
     */
    public static boolean isAfterDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        if (cal1.get(Calendar.ERA) < cal2.get(Calendar.ERA))
            return false;
        if (cal1.get(Calendar.ERA) > cal2.get(Calendar.ERA))
            return true;
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR))
            return false;
        if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR))
            return true;
        return cal1.get(Calendar.DAY_OF_YEAR) > cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * <p>
     * Checks if a date is after today and within a number of days in the
     * future.
     * </p>
     * 
     * @param date
     *            the date to check, not altered, not null.
     * @param days
     *            the number of days.
     * @return true if the date day is after today and within days in the future
     *         .
     * @throws IllegalArgumentException
     *             if the date is <code>null</code>
     */
    public static boolean isWithinDaysFuture(Date date, int days) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return isWithinDaysFuture(cal, days);
    }

    /**
     * <p>
     * Checks if a calendar date is after today and within a number of days in
     * the future.
     * </p>
     * 
     * @param cal
     *            the calendar, not altered, not null
     * @param days
     *            the number of days.
     * @return true if the calendar date day is after today and within days in
     *         the future .
     * @throws IllegalArgumentException
     *             if the calendar is <code>null</code>
     */
    public static boolean isWithinDaysFuture(Calendar cal, int days) {
        if (cal == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar today = Calendar.getInstance();
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DAY_OF_YEAR, days);
        return (isAfterDay(cal, today) && !isAfterDay(cal, future));
    }
} // end class
