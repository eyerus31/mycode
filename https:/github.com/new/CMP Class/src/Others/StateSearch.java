package Others;


/**
Objective: Using java.util.ArrayList as a look-up table and to implement an insertion sort.
Synopsis:
	Java  StateSearch  InputFileName
Input line format:
    StreetNumber StreetName, CityName, State ZipCode
Sample input lines:
    11200 Waples Mill Road, Fairfax, VA  22030
    19827 King Street, Baltimore, mD 21237
Each line of the file staterecs.txt contains the abbreviation for a state:
   AL 
   AK 
   ....
*/
import java.io.*;
import java.util.*;
public class StateSearch  {
  public static void main(String args[]) {
   String line, state, ui, zipCode;
   StringTokenizer st;
   if (args.length != 1)        {
      System.err.println("Java  StateSearch  InputFileName");
      System.exit(1);
      }
   ArrayList <String> stateRec = new ArrayList<String>();
   setStateRec(stateRec);  // set up the look-up table for states
   ArrayList <String> outputRec = new ArrayList<String>();
   do  { // loop until a valid state is received
    System.out.print("Enter a state abbriviation : ");
    Scanner input = new Scanner(System.in); // Keyboard input
    ui = input.next();
//  Validate the state, ignoring the case sensitivity
    if (stateRec.contains(ui.toUpperCase())) break;  // A valid state was entered
    System.out.println(ui + " is an invalid state!");
    } while (true);
    int cnt=0;
    try {
        FileReader f = new FileReader(args[0]);
        BufferedReader inFile = new BufferedReader(f);
        while ((line = inFile.readLine()) != null) {
          state = line.substring(line.lastIndexOf(",")+1);
          st = new StringTokenizer(state);
          state = st.nextToken().trim();
          zipCode = st.nextToken().trim();
          if (state.toUpperCase().equals(ui.toUpperCase()))
             insertRec(outputRec, line, zipCode);
          } // loop until the end of file
          inFile.close(); 
          f.close();
          }  catch (Exception e) {  e.printStackTrace(); };
    for (String n : outputRec)  System.out.println(n);
    } // main

// Put the matched record onto the list sorted by zip code.
// Insertion sort
static void insertRec(ArrayList<String> rec, String s, String zip)  {
  if (rec.size() < 1)       
   {  rec.add(s);   return;   }
  int index = 0;
  String z;
  StringTokenizer st;
  for (String j : rec)         {
      z = j.substring(j.lastIndexOf(",")+1);
      st = new StringTokenizer(z);
      z = st.nextToken();
      z = st.nextToken().trim(); 
      if (z.compareTo(zip) > 0)   {
         rec.add(index, s);
         break;
         }
      ++index;
      } // for  j
  if (index >= rec.size())  rec.add(s);   // append to the end of the list
  } // insertRec

/**
Read the state abbreviations from the file into a look-up table. Sample Input line:
   MD
*/
static void setStateRec(ArrayList <String> rec)    {
    String line;
    try   {
          FileReader f = new FileReader("staterecs.txt");
          BufferedReader inFile = new BufferedReader(f);
          while ((line = inFile.readLine()) != null)
                rec.add(line.trim());
          inFile.close(); 
          f.close();
          }   catch (IOException ioe) {  System.err.println(ioe); };
  } // setStateRec
} // StateSearch
