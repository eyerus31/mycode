package exercise;


//A template used to read integer numbers from a file.
//Input file: HW1Data.txt
//Input file must be saved under the same directory/folder as the program.

import java.io.*;

import java.util.*;
public class ReadNumbers
{
  public static void main(String args[]) 
    {
    int count=0;
    try   {
          Scanner in = new Scanner(new File("sortData.csv"));
          while (in.hasNextInt())
                {
                System.out.println(in.nextInt());
                ++count;
                }
          in.close(); 
          }
          catch (Exception e) {  e.printStackTrace(); };
    System.out.println(count + " numbers found");
    } // main
} // ReadNumbers

