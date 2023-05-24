package Smokers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class S {
	
	public static Semaphore mutex = new Semaphore(1);
	public static Semaphore nothing = new Semaphore(1);
	public static Semaphore something = new Semaphore(0);
	public static ArrayList<AtomicBoolean> cig = new ArrayList<AtomicBoolean>();
	public static ArrayList<String> name = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfSmokers;
		
		do {
			System.out.println("How many smokers would you like (three minimum): ");
            while(!input.hasNextInt()) {
            	System.out.println("Invalid number try again!");
            	input.next();
            }
			numOfSmokers = input.nextInt();
		} while(numOfSmokers < 3);
		
		ArrayList<Smoker> smokers = new ArrayList<Smoker>(numOfSmokers-1);

		AtomicBoolean paper = new AtomicBoolean(false);
		AtomicBoolean tobacco = new AtomicBoolean(false);
		AtomicBoolean match = new AtomicBoolean(false);
		cig.add(paper);
		cig.add(tobacco);
		cig.add(match);
		name.add("paper");
		name.add("tobacco");
		name.add("matches");
		
		for(int i = 0; i < numOfSmokers; i++) {
			Smoker s = new Smoker();
			if(i >= 3) {
				Random rand = new Random();
				int itemNum = rand.nextInt(3);
				s.number = i+1;
				s.itemNum = itemNum;
			} else {
				s.number = i+1;
				s.itemNum = i;
			}
			s.setDaemon(true);
			smokers.add(s);
			System.out.println("Starting Smoker " + (i+1) + "...");
			s.start();
		}
		Agent agent = new Agent(numOfSmokers);
		System.out.println("Starting program!!!");
		agent.start();
	}

}

class Smoker extends Thread {
	public int number;
	public int itemNum;
	
	Smoker(int number, int itemNum) {
		this.number = number;
		this.itemNum = itemNum;
	}
	
	public Smoker() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		while(true) {
			System.out.println("Smoker " + number + " is trying to acquire the table...");
			try {
				S.something.acquire();
				System.out.println("Smoker " + number + " has the table!");
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			try {
				S.mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(!S.cig.get(itemNum).get()) {
				for(int i = 0; i < 3; i++) {
					if( i != itemNum) {
						S.cig.get(i).set(false);
					}
				}
				System.out.println("Smoker " + number + " found " + S.name.get(itemNum) + "!");
				System.out.println("Smoker " + number + " is smoking!");
				S.nothing.release();
				System.out.println("Agent is awake!");
			} else {
				System.out.println("Smoker " + number + " didn't find " + S.name.get(itemNum) + "...");
				S.something.release();
			}
			S.mutex.release();
			try {
				System.out.println("Smoker " + number + " going back to sleep...");
				Smoker.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Agent extends Thread {

	int numOfSmokers;
	Agent(int numOfSmokers) {
		this.numOfSmokers = numOfSmokers;
	}
	
	public void run() {
		System.out.println("Agent is running...");
		while(true) {
			try {
				System.out.println("Agent is trying to acquire the table...");
				S.nothing.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				S.mutex.acquire();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Agent has the table...");
			place();
			S.something.release();
			S.mutex.release();
			try {
				System.out.println("Agent going to sleep...");
				Smoker.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void place() {
		Random r = new Random();
		StringBuilder result = new StringBuilder();
		result.append("Agent put");
		int m = r.nextInt(3);
		for(int i =0; i < 3; i++) {
			if(i!= m) {
				S.cig.get(i).set(true);
			} else
				result.append(" " + S.name.get(i) + " on the table...");
		}
		System.out.println(result.toString());
	}

}