package hw1;
/*
This program is developed to:
   Read all numbers from hw1Data.txt into a static array (int array) and calculate and 
Display the CPU time used to complete ;reading all numbers from hw1Data.txt into a static array
**/
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class TegeneHW1{

	public static void main(String args[]) 
    {
      int [] hw1 = new int [12000]; // creating an int array of size 12000
  
//the start time from the current time of the system 
long startTime = System.currentTimeMillis();

int count=0;
try   {
      Scanner in = new Scanner(new File("C:\\Users\\user\\Downloads\\CMP 561_ algorithms\\hw1Data.txt"));
   
  while (in.hasNextInt())
        {
	  hw1 [count] = in.nextInt();      
                ++count;
                }
          in.close(); 
          }
          catch (Exception e) {  e.printStackTrace(); 
          };
   
 	 // End time is calculated from the system current where the program process ends 
  long endTime = System.currentTimeMillis();  // end time
System.out.println();

      //The final resuult calculated from the start time and end time of the program process 
	  System.out.print("CPU time used: " + (endTime - startTime) + " ms"); 
    } 
} 
