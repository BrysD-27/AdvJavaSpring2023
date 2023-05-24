import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OCCCDateException, FileNotFoundException {
        int numDatesProcessed = 0;
        int numDatesWithException = 0;
        int numDatesInJuly = 0;
        int numDatesOnTuesday = 0;
        int numDatesBefore2001 = 0;
        String fileName = "OCCCDate.txt";
        Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");
                int day = Integer.parseInt(fields[0]);
                int month = Integer.parseInt(fields[1]);
                int year = Integer.parseInt(fields[2]);
                OCCCDate date;

                try {
                    date = new OCCCDate(day, month, year);
                } catch (OCCCDateException e) {
                    date = new OCCCDate(1, 1, 1);
                    numDatesWithException++;
                }

                numDatesProcessed++;

                if (date.isJuly()) {
                    numDatesInJuly++;
                }

                if (date.isTuesday()) {
                    numDatesOnTuesday++;
                }

                if (date.isBefore(new OCCCDate(1, 1, 2001))) {
                    numDatesBefore2001++;
                }
            }
            scanner.close();


        System.out.println("Number of dates processed: " + numDatesProcessed);
        System.out.println("Number of dates with exception: " + numDatesWithException);
        System.out.println("Number of dates in July: " + numDatesInJuly);
        System.out.println("Number of dates on Tuesday: " + numDatesOnTuesday);
         System.out.println("Number of dates before 2001: " + numDatesBefore2001);
    }
}