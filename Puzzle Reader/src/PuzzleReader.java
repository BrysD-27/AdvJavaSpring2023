/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/11/23
 * File:	Puzzle Reader
 * Description:	Puzzle Reader
 */


import java.util.*;
import java.io.*;

public class PuzzleReader{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String Matrix[][] = new String[6][6];
		int size = 0;
		String fileName;
		
		if(args.length == 1) {
			fileName = args[0];
		} else {
			System.out.println("Enter file name: ");
			fileName = input.nextLine();
		}
		
		try{
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			int row = 0;
			int entries = 0;
			
			while(line != null){
				String[] chars=line.split(" ");
	
				for(int col = 0; col < chars.length; col++) {
					Matrix[row][col] = chars[col];
					entries++;
				}
				row++;
				line = reader.readLine();
			}

			if(row * row != entries){
				System.out.println("Puzzle is not a perfect square!!");
				System.exit(0);
			}

			size = row;
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println("Puzzle as chars: ");
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(Matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n" + "Puzzle as int: ");
		
		String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(Matrix[i][j].equals("-")) {
					System.out.print(Matrix[i][j]+" ");
				}
				else{
					System.out.print(s.indexOf(Matrix[i][j].toUpperCase())+" ");
				}
			}
			System.out.println();
		}
	}
}