import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class OCCCDate {
    private GregorianCalendar calendar;

    public OCCCDate(int day, int month, int year) throws OCCCDateException {
        if (day <= 0 || month <= 0 || month > 12 || year < 0) {
            throw new OCCCDateException();
        }
        if (day > getDaysInMonth(month, year)) {
            throw new OCCCDateException();
        }
        this.calendar = new GregorianCalendar(year, month - 1, day);
        if (this.calendar.get(Calendar.DAY_OF_MONTH) != day ||
                this.calendar.get(Calendar.MONTH) != month - 1 ||
                this.calendar.get(Calendar.YEAR) != year) {
            throw new OCCCDateException();
        }
    }

    public boolean isTuesday() {
	    String[] weekdays = new DateFormatSymbols().getWeekdays(); 
		String day = weekdays[calendar.get(Calendar.DAY_OF_WEEK)];
		if(calendar.get(Calendar.DAY_OF_MONTH) == Calendar.TUESDAY && calendar.get(Calendar.YEAR) != 1)
			return true;
        return false;
    }

    public boolean isBefore(OCCCDate other) {
    	if(calendar.get(Calendar.YEAR) == 1)
    		return false;
        return calendar.before(other.calendar);
    }

    public boolean isJuly() {
    	if(calendar.get(Calendar.YEAR) == 1)
    		return false;
    	return calendar.get(Calendar.MONTH ) == 7;
    }

    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    @Override
    public String toString() {
        return calendar.get(Calendar.DAY_OF_MONTH) + " " +
                (calendar.get(Calendar.MONTH) + 1) + " " +
                calendar.get(Calendar.YEAR);
    }
}

class OCCCDateException extends Exception {
}

