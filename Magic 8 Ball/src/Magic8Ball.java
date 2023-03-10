/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	01/21/23
 * File:	Magic 8 Ball
 * Description:	Magic 8 Ball
 */
import java.util.Random;
import java.util.Scanner;

public class Magic8Ball {
	static String [] answers = new String[] {
			"Yes",
			"No",
			"The world is your oyster!",
			"Ask again later",
			"Maybe in another life",
			"Without a doubt",
			"Nope no way",
			"Outlook good",
			"A big no",
			"Real hazy"
	};
	static int numOfQuestionsAnswered;
	static String usersQuestion;
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Welcome to the Magic 8 Ball!" + "\n" + "Ask any question: ");
		
		while(true) {
			usersQuestion = input.nextLine();
			
			if(usersQuestion.isEmpty()) {
				System.out.println("Thanks for playing!" + "\n" + "Number of questions answered: " + numOfQuestionsAnswered);
				System.exit(0);
			}
			randomAnswer();
			System.out.print("Ask another question: ");
		}
	}
	
	public static void randomAnswer() {
		numOfQuestionsAnswered++;
		Random rand = new Random();
		int randomNum = rand.nextInt(10);
		
		System.out.println("\n" + answers[randomNum] + "\n");
	}
}
