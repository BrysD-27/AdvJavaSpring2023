// Bryson Davis
// CS-2463-TW01S
// 4-30-2023

import java.util.HashMap;
import java.util.Map.Entry;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Sorting {
	
    public static void main(String[] args)throws Exception {
    	String fileName;
    	Scanner input = new Scanner(System.in);
    	
		if(args.length == 1) {
			fileName = args[0];
		} else {
			System.out.println("Enter file name: ");
			fileName = input.nextLine();
		}
    	
		String list = new String(Files.readAllBytes(Paths.get(fileName))); 
		

		int l = list.length();
		for(int i = 0; i < l; i++){
		  if((list.charAt(i) > 32 && list.charAt(i) < 47) || (list.charAt(i) > 48 && list.charAt(i) < 64) || (list.charAt(i) > 91 && list.charAt(i) < 96) || (list.charAt(i) > 123 && list.charAt(i) < 126)) {
			list = list.replace("" + list.charAt(i), "");
			l--;
		  }
		}		

		String[] split = list.split(" "); 
		HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
		for (int i = 0; i < split.length; i++) {
			String key = split[i];
			int freq = freqMap.getOrDefault(key, 0);
			freqMap.put(key, ++freq);
		}


		TreeMap<String, Integer> sorted = new TreeMap<>(String.CASE_INSENSITIVE_ORDER); 

		sorted.putAll(freqMap); 

		for (Map.Entry<String, Integer> entry : sorted.entrySet()) 
		if (entry.getValue() > 1)
			System.out.println(entry.getKey() + " (" + entry.getValue()+")");
		else
			System.out.println(entry.getKey());
    }
}