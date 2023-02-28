import java.util.Scanner;

/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/25/23
 * File:	Tower of Hanoi
 * Description:	Tower of Hanoi
 */

public class TowerOfHanoi {

    public static void TOH(int number_of_disks, int start, int end) {
        if (number_of_disks == 1) {
            System.out.println("Move the disk from spindle " + start + " to spindle " + end + ".");
        } else {
            int other = 6 - start - end;
            TOH(number_of_disks - 1, start, other);
            System.out.println("Move the disk from spindle " + start + " to spindle " + end + ".");
            TOH(number_of_disks - 1, other, end);
        }
    }

    public static void main(String[] args) {       
    	Scanner input = new Scanner(System.in);
    	int numOfDisks;
    	int start; 
    	int end;
        System.out.println("Welcome to Tower of Hanoi!" + "\n");
        
        if(args.length > 0) {
        	numOfDisks = Integer.parseInt(args[0]);
        	start = Integer.parseInt(args[1]);
        	end = Integer.parseInt(args[2]);
        }
        else {
            do {
                System.out.println("Enter the number of disks: ");
                while(!input.hasNextInt()) {
                	System.out.println("Invalid Number try again!");
                	input.next();
                }
                numOfDisks = input.nextInt();
            } while(numOfDisks <= 0);
            do {
            	System.out.println("Enter the starting spindle: ");
                while(!input.hasNextInt()) {
                	System.out.println("Invalid Number try again!");
                	input.next();
                }
                start = input.nextInt();
            } while(start <= 0);
            do {
            	System.out.println("Enter the ending spindle: ");
                while(!input.hasNextInt()) {
                	System.out.println("Invalid Number try again!");
                	input.next();
                }
                end = input.nextInt();
            } while(end <= 0);
        }
        System.out.println("\n");
        TOH(numOfDisks, start, end);
    }
}
