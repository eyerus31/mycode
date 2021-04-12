package Others;

/**
Using String array.
Synopsis:
      java  Java  SearchAddress  InputFileName
Input line format:
      Street, City, state zipCode
Sample input line:
800 South Rolling Road, Catonsville, Md 21228
This program:
Validates the user entered state.
Displays all records matching the user entered state.
*/
import java.io.*;
import java.util.*;
public class SearchAddress
{
  public static void main(String args[]) 
   {
   String line, state=null, ui=null;
   StringTokenizer st;

   if (args.length != 1)
      {
      System.err.println("Java  SerachAddress  InputFileName");
      System.exit(1);
      }
   String []stateRec = new String[50]; // 50 states
   setStateRec(stateRec);  // set up the look-up table for states
   boolean valid = false;
   do   // loop until a valid state is received
    {
    System.out.print("Enter a state abbreviation : ");
    Scanner input = new Scanner(System.in); // Keyboard input
    ui = input.next();
//  Validate the state, ignoring the case sensitivity
    for (int k=0; k < stateRec.length; ++k) 
        {
        if (stateRec[k].toUpperCase().contains(ui.toUpperCase()))
           {
           valid = true;
           break;   // stop the loop, a match was found
           }
        }
    if (! valid)
       System.out.println(ui + " is an invalid state!");
    } while (! valid);
    int cnt=0;
    try {
        FileReader f = new FileReader(args[0]);
        BufferedReader inFile = new BufferedReader(f);
        while ((line = inFile.readLine()) != null)
          {
          state = line.substring(line.lastIndexOf(",")+1);
          st = new StringTokenizer(state);
          state = st.nextToken().trim();
          if (state.toUpperCase().equals(ui.toUpperCase()))
             {
             System.out.println(line);
             ++cnt;
             }
          } // loop until the end of file
        if (cnt < 1)
           System.out.println("No record found.");
          inFile.close(); 
          f.close();
          }
          catch (Exception e) {  e.printStackTrace(); };
    } // main

/**
Read the state information from the file into a look-up table.
*/
 static void setStateRec(String []rec)
  {
    String line;
    try   {
          int k = 0;
          FileReader f = new FileReader("states.txt");
          BufferedReader inFile = new BufferedReader(f);
          while ((line = inFile.readLine()) != null)
             {  
             rec[k] = line;
             ++k;
             } 
          inFile.close(); 
          f.close();
          }
          catch (IOException ioe) {  System.err.println(ioe); };
  } // setStateRec

} // SerachAddress

