import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestOCCCDate {

    public static void main(String args[]){
    	int userDayOfMonth;
    	int userMonthOfYear;
    	int userYear;
    	Scanner input = new Scanner(System.in);
    	while(true) {
	    	System.out.println("Enter in the day of the month: ");
	    	userDayOfMonth = input.nextInt();
	    	System.out.println("Enter in the month of the year: ");
	    	userMonthOfYear = input.nextInt();
	    	System.out.println("Enter in the year: ");
	    	userYear = input.nextInt();
	    	
		    OCCCDate occcDate1 = new OCCCDate(userDayOfMonth, userMonthOfYear, userYear);
	    	
		    System.out.println("\n" + "Date: " + occcDate1.toString());
		    System.out.println("Is a leap year: " + occcDate1.isLeapYear() + "\n");
    	}
    }
}