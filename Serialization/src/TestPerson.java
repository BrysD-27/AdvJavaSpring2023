//Bryson Davis
// 4-2-23

import java.util.*;
import java.io.*;

public class TestPerson {
  public static void main(String [] args){
	List<Person> p = new ArrayList<Person>();
	String fileName = null;
	
	fileName = promptLoadExistingFile(args, fileName);
	if(fileName.contentEquals("1")) {
		p = addPerson();
		Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a file name to load from or 1 to continue : ");
        fileName = sc.nextLine();
		loadToFile(p, fileName);
	} else {	
		readFile(fileName, p);
		p = loadExistingFile(fileName);
	    List<Person> newList = new ArrayList<Person>();
	    newList.addAll(p);
	    newList.addAll(addPerson());
	    loadToFile(newList, fileName);
	}
  }
  
  static String promptLoadExistingFile(String[] args, String fileName) {	
    if (args.length == 0) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a file name to load from or 1 to continue : ");
        fileName = sc.nextLine();
        if(fileName.contentEquals("1")) {
        	return fileName;
        } else {
        	return fileName;
        }
    }
    else {
        fileName = args[0];
    }
    return fileName;
  }
  
  static void readFile(String fileName, List<Person> q) {
	  q = new ArrayList<Person>();
	  int character = 0;
	  System.out.println("Reading " + fileName + "...");
	    try{
	      FileInputStream fin = new FileInputStream(fileName);
	      ObjectInputStream oin = new ObjectInputStream(fin);
	      Object o;
	      do {
	    	  if(oin.readObject().getClass().equals(Person.class))
	    			  o = (Person) oin.readObject();
	    	  else
	    		  continue;
	        System.out.println(o.getClass());

	        if (o.getClass().equals(OCCCPerson.class)){
	          System.out.println("Got me an OCCC Person");
	          q.add((OCCCPerson) o);
	        }
	        else if (o.getClass().equals(RegisteredPerson.class)){
	          System.out.println("This is a Registered Person");
	          q.add((RegisteredPerson) o);
	        } else {
		          System.out.println("This is a Person");
		          q.add((Person) o);
	        }
	      } while((character = fin.read()) != -1);
	      fin.close();
	    }
	    catch(Exception e){
	      System.out.println("INPUT ERROR");
	      System.out.println(e.toString());
	    }

	    for(int i = 0; i < q.size(); ++i){
	      System.out.println(q.get(i).toString());
	    }
  }
  
  static Person deserializePerson(InputStream fin) throws IOException, ClassNotFoundException {
      ObjectInputStream oin = new ObjectInputStream(fin);
      Person o = (Person) oin.readObject();
	  return o;
  }
  
  static List<Person> loadExistingFile(String fileName) {
	  List<Person> q = new ArrayList<Person>();
	  int character = 0;
	    try{
	      FileInputStream fin = new FileInputStream(fileName);
	      Object o;
	      do {
	        o = deserializePerson(fin);

	        if (o.getClass().equals(OCCCPerson.class)){
	          q.add((OCCCPerson) o);
	        }
	        else if (o.getClass().equals(RegisteredPerson.class)){
	          q.add((RegisteredPerson) o);
	        } else {
		          q.add((Person) o);
	        }
	      } while((character = fin.read()) != -1);
	    }
	    catch(Exception e){
	      System.out.println("INPUT ERROR");
	      System.out.println(e.toString());
	    }
	    return q;
  }
  
  static List<Person> addPerson() {
	List<Person> p = new ArrayList<Person>();
  	Scanner input = new Scanner(System.in);
  	Scanner inputData = new Scanner(System.in);

	String firstName;
	String lastName;
	String govID;
	String studentID;
	
  	int userInput;

  	do {
  		 do {
  	          System.out.println("Enter which person you'd like to add(Person-1, RegisteredPerson-2, OCCCPerson-3) or type 0 to exit: ");
  	          while(!input.hasNextInt()) {
  	          	System.out.println("Invalid Number try again(1,2,3 or 0 to exit)!");
  	          	input.next();
  	          }
  	          userInput = input.nextInt();
  	      } while(userInput > 3 || userInput < 0);
  	      
  	          switch (userInput) {
  	        	case 1:
  	        		System.out.println("Enter the Person's first name: ");
  	        		firstName = inputData.nextLine();
  	        		System.out.println("Enter the Person's last name: ");
  	        		lastName = inputData.nextLine();
  	        		p.add(new Person(firstName, lastName));
  	        		break;
  	        	case 2:
  	        		System.out.println("Enter the Person's first name: ");
  	        		firstName = inputData.nextLine();
  	        		System.out.println("Enter the Person's last name: ");
  	        		lastName = inputData.nextLine();
  	        		System.out.println("Enter the Person's government ID: ");
  	        		govID = inputData.nextLine();
  	        		p.add(new RegisteredPerson(firstName, lastName, govID));
  	        		break;
  	        	case 3:
  	        		System.out.println("Enter the Person's first name: ");
  	        		firstName = inputData.nextLine();
  	        		System.out.println("Enter the Person's last name: ");
  	        		lastName = inputData.nextLine();
  	        		System.out.println("Enter the Person's government ID: ");
  	        		govID = inputData.nextLine();
  	        		System.out.println("Enter the Person's student ID: ");
  	        		studentID = inputData.nextLine();
  	        		p.add(new OCCCPerson(firstName, lastName, govID, studentID));
  	        		break;
  	        	default:
  	        		break;
  	        }
  	      	for(int i = 0; i < p.size(); i++) {
  	    		System.out.println(p.get(i));
  	    	}
  	} while(userInput != 0);
     
  	return p;
  }
  
  static void loadToFile(List<Person> p, String fileName) {
	    System.out.println("Dumping objects to " + fileName + "...");
	    if(p.isEmpty()) {
	    	System.out.println("Exit without adding items...");
	    }
	    try{
	      FileOutputStream   fout = new FileOutputStream(fileName);
	      ObjectOutputStream oout = new ObjectOutputStream(fout);
	      for(int i = 0; i < p.size(); ++i){
	    	  if(oout.getClass().equals((OCCCPerson.class)))
	    		  oout.writeObject(p.get(i));
	    	  else if(oout.getClass().equals((RegisteredPerson.class)))
	    		  oout.writeObject(p.get(i));
	    	  else
	    		  oout.writeObject(p.get(i));
	      }
	      System.out.println("Done");
	      fout.close();
	      oout.close();
	    }
	    catch(IOException e){
	      System.out.println("OH NO BAD THINGS HAPPEN");
	      System.out.println(e.toString());
	    }
  }
}
    