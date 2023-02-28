/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/25/23
 * File:	Sudoku
 * Description:	Sudoku
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Sudoku {

    static final int Size = 9;

    static boolean solve(char grid[][], int row, int col) {
        if (row == Size - 1 && col == Size) 
            return true;
        if (col == Size) { 
            row++; 
            col = 0;
        }

        if (grid[row][col] != '*' && grid[row][col] != '-')
            return solve(grid, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(grid, row, col, num)) { 
                grid[row][col] = num;
                if (solve(grid, row, col + 1))
                    return true;
            }
            grid[row][col] = '*'; 
        }
        return false;
    }

    static void print(char[][] grid) {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(char[][] grid, int row, int col, int num) {
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;

        int startRow = row - row % 3; 
        int startCol = col - col % 3; 

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true; 
    }

    public static void main(String[] args) {
    	System.out.println("Welcome to Sudoku Solver!!" + "\n");
    	
        String fileName = "";
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter a sudoku file name :");
            fileName = sc.nextLine();
        }
        else {
            fileName = args[0];
        }
        char grid[][] = new char[Size][Size];
        int row = 0, col = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = in.readLine()) != null && row < Size) { 
                String[] arrOfStr = str.split(" ");
                col = 0;
                for (int i = 0; i < arrOfStr.length && col < Size; i++) {
                    String string = arrOfStr[i].trim(); 
                    if (string.equals("")) { 
                        continue;
                    }
                    grid[row][col] = string.charAt(0); 
                    col++;
                }
                row++;
            }
            System.out.println("Original Puzzle: " + "\n");
            print(grid);
            System.out.println();
            if (solve(grid, 0, 0)) {
            	System.out.println("Solved Puzzle: " + "\n");
                print(grid);
            }
            else
                System.out.println("No Solution!!");
        } catch (Exception e) {
            System.out.println("FIle N/A!!");
            e.printStackTrace();
        }
    }
}