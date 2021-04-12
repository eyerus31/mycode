package Others;

/**
Using java.util.ArrayList.
Synopsis:
      java  Java  SearchAddress2  InputFileName

Input line format:
      Street, City, state zipCOde
Sample input line:
      11200 Waples Mill Road, Fairfax, VA  22030
This program:
Validates the user entered state.
Displays all records matching the user entered state.
*/
import java.io.*;
import java.util.*;
public class SearchAddress2
{
  public static void main(String args[]) 
   {
   String line, state=null, ui=null;
   StringTokenizer st;

   if (args.length != 1)
      {
      System.err.println("Java  SerachAddress2  InputFileName");
      System.exit(1);
      }
   ArrayList <String> stateRec = new ArrayList<String>();
   setStateRec(stateRec);  // set up the look-up table for states
   do   // loop until a valid state is received
    {
    System.out.print("Enter a state abbreviation : ");
    Scanner input = new Scanner(System.in); // Keyboard input
    ui = input.next();
//  Validate the state, ignoring the case sensitivity
    if (stateRec.contains(ui.toUpperCase()))
       break;  // A valid state was entered
    System.out.println(ui + " is an invalid state!");
    } while (true);
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
Sample Input line:
   MD, Maryland
*/
static void setStateRec(ArrayList <String> rec)
  {
    String line;
    StringTokenizer  st;
    try   {
          FileReader f = new FileReader("states.txt");
          BufferedReader inFile = new BufferedReader(f);
          while ((line = inFile.readLine()) != null)
             {  
             st = new StringTokenizer(line, ",");
             rec.add(st.nextToken().trim());
             } 
          inFile.close(); 
          f.close();
          }
          catch (IOException ioe) {  System.err.println(ioe); };
  } // setStateRec

} // SerachAddress2

