import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortAndMerge
{
    public String[] splitCustom(String str){ 
        char[] ch = str.toCharArray(); // Convert string into char array
        String temp = "";
        int j = 0,length = 0,size = 0;
        
        for(int i = 0; i<str.length(); i++){

            if(str.charAt(i) == ' '){ // look for space char
                size++;
            }

        }
        String[] arr = new String[size + 1]; // array to store the split items

        for(int i = 0; i<ch.length; i++){ // Iterate through the char array

            if(length > j){ // Both are set to 0 initially, here length determines the each split and j the index of new string array getting created
                j++;
                temp = "";
            }

            if(ch[i] == ' '){

                length++; // the length variable determines each split of the string

            }else{

                temp += Character.toString(ch[i]); // temp holds the value of each char that is converted into string, until a space char found
            }

            arr[j] = temp; // The space char determines the end of string per split. Now add the split into a string array
        }

        return arr;
    }

    public static void main(String[] args) throws Exception
    {
        // read the file - provide your file path here
        SortAndMerge s  =  new SortAndMerge();
        String fileLine;
        String [] splits;

        File file  =  new File("D:\\Documents\\AdvJavaSpring2023\\SplitAlgo\\src\\split.txt"); // File path of split.txt
        List<String []> splitList  =  new ArrayList<String[]>(); // Store all the split arrays into an array list
        Scanner sc  =  new Scanner(file); // Use scanner class to read a file instead of BufferedReader

        while (sc.hasNextLine()){ // Read each line from the file

           fileLine  =  sc.nextLine();
            if (fileLine.contains(" ")) { // Read the file line by line a
                splits  =  s.splitCustom(fileLine); // Make a call to the method which splits the line
                splitList.add(splits); // store each string array into an array list
            }

        }

         int count = 0;
        // if you only need FIRST, then -> System.out.println("The length of split " + ++count + " : " + splitList.get(0).length);
         for (int i = 0; i < splitList.size(); i++){
        	 System.out.println(splitList.get(i));
            System.out.println("The length of split " + ++count + " : " + splitList.get(i).length); // Displaying the split length

         }

    }
} 