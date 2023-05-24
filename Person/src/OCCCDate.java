import java.text.DateFormatSymbols;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class OCCCDate {
	private int dayOfMonth;
	private int monthOfYear;
	private int year;
	private GregorianCalendar gc;
	private boolean dateFormat = FORMAT_US;
	private boolean dateStyle = STYLE_NUMBERS;
	private boolean dateDayName = SHOW_DAY_NAME;
	
	private static final boolean FORMAT_US = true;
	private static final boolean FORMAT_EURO = false;
	private static final boolean STYLE_NUMBERS = true;
	private static final boolean STYLE_NAMES = false;
	private static final boolean SHOW_DAY_NAME = true;
	private static final boolean HIDE_DAY_NAME = false;
	
	public OCCCDate() throws InvalidOCCCDateException {}
	
	public OCCCDate(int day, int month, int year) throws InvalidOCCCDateException {
		boolean validDate = isValidDate(day,month,year);	
		if(!validDate){
			throw new InvalidOCCCDateException("The date: " + month +"/" + day + "/"+ year +" in not a valid Date");
		} else {
			this.dayOfMonth = day;
			this.monthOfYear = month;
			this.year = year;
			this.gc = new GregorianCalendar(year, month, day);
		}
	}
	
	public OCCCDate(GregorianCalendar gc) throws InvalidOCCCDateException {
		boolean validDate = isValidDate(gc.get(gc.DAY_OF_MONTH), gc.get(gc.MONTH), gc.get(gc.YEAR));

		if(!validDate) {
			throw new InvalidOCCCDateException("Test Date Validity df");
		} else {
			this.dayOfMonth = gc.get(gc.DAY_OF_MONTH);
			this.monthOfYear = gc.get(gc.MONTH);
			this.year = gc.get(gc.YEAR);
		}
	}
	
	public OCCCDate(OCCCDate d) throws InvalidOCCCDateException {}
	
	public int getDayOfMonth(){
		return dayOfMonth;
	}
	
	public String getDayName(){
	    String[] weekdays = new DateFormatSymbols().getWeekdays(); 
		return weekdays[gc.get(Calendar.DAY_OF_WEEK)];
	}
	
	public int getMonthNumber(){
		return monthOfYear;
	}
	
	public String getMonthName() { 
	      int d = getDayOfMonth();
	      int m = getMonthNumber();
	      int y = getYear();
	      int dayOfMonth = getMonthNumber();
	      String month;
	      switch (dayOfMonth) {
	      case 1:
	         month = "JANUARY";
	         break;
	      case 2:
	         month = "FEBRUARY";
	         break;
	      case 3:
	         month = "MARCH";
	         break;
	      case 4:
	         month = "APRIL";
	         break;
	      case 5:
	         month = "MAY";
	         break;
	      case 6:
	         month = "JUNE";
	         break;
	      case 7:
	         month = "JULY";
	         break;
	      case 8:
	         month = "AUGUST";
	         break;
	      case 9:
	         month = "SEPTEMBER";
	         break;
	      case 10:
	         month = "OCTOBER";
	         break;
	      case 11:
	         month = "NOVEMBER";
	         break;
	      case 12:
	         month = "DECEMBER";
	         break;
	      default:
	         month = "";
	         System.out.println("Invalid month");
	         break;
	      }
	      return month ;
	   }
	
	public int getYear(){
		return year;
	}
	
	public void setDateFormat(boolean df){
		this.dateFormat = df;
	}
	
	public void setStyleFormat(boolean sf){
		this.dateStyle = sf;
	}
	
	public void setDayName(boolean nf){
		this.dateDayName = nf;
	}

	public int getDifferenceInYears(){
		int currentYear = Year.now().getValue();
		return diff(currentYear, this.year);
	}
	
	public int getDifferenceInYears(OCCCDate d){
		return diff(d.year, this.year);
	}
	
	public int diff(int a, int b){
		if(a>b){
			return a-b;
		}
		else{
			return b-a;
		}
	}	
	
	public boolean equals(OCCCDate d) {
		if (this.dayOfMonth == d.dayOfMonth && this.monthOfYear == d.monthOfYear && this.year == d.year) {
			return true;
        } else {
            return false;
        }
    }
	
	public boolean isValidDate(int day, int month, int year){
		GregorianCalendar cal = new GregorianCalendar(year, month, day);
		boolean isLeapYear = cal.isLeapYear(year);

		if( month < 1 || month > 12) return false; 
		if( year < 0) return false; 
		if(month == 4 || month == 6 || month == 9 || month == 11){ 
			if( day > 30) return false;
		} else if(day > 31) return false;
		if(!isLeapYear && month == 2 && day > 28) return false;
		if(isLeapYear && month == 2 && day > 29) return false;
		
		return true;
	}
	
	public boolean isLeapYear(){
		GregorianCalendar cal = new GregorianCalendar(this.year, this.monthOfYear, this.dayOfMonth);
		return cal.isLeapYear(year);
	}
	
    public String toString() {
        if (dateFormat && dateStyle) {
            String result = getMonthNumber() + "/" + getDayOfMonth() + "/" + getYear();
            return result;
        } else if (dateFormat && !dateStyle) {
            String result = getMonthNumber() + "/" + getDayOfMonth() + "/" + getYear();
            return result;
        } else if (!dateFormat && dateStyle) {
            String result = getDayOfMonth() + "/" + getMonthNumber() + "/" + getYear();
            return result;
        } else {
            String result = getDayOfMonth() + "/" + getMonthName() + "/" + getYear();
            return result;
        }
    }
}