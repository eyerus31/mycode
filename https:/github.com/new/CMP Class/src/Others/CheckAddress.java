package Others;

/**
Snynopsis:
      java  CheckAddress  InputFileName
Sample input line:
      800 South Rolling Road, Baltimore, MD  21228
Tasks:
Read and divide each input line into tokens.
Identify each token, ignoring the cases sensitivity, as one of the following
      Street number
      Street name
      City name
      State name
      Zip code
Sample output:
      Street number: 800
      Street name: South Rolling Road
      City name: Baltimore
      State name: Maryland
      Zip code: 21228
*/
import java.io.*;
import java.util.*;
public class CheckAddress
{
  public static void main(String args[]) 
   {
   String line, state;
   StringTokenizer st, st2;
   if (args.length != 1)
      {
      System.err.println("java  CheckAddress  InputFileName");
      System.exit(1);
      }
   ArrayList <String> stateRec = new ArrayList <String>(); 
   ArrayList <String> stateName = new ArrayList <String>(); 
   setStateRec(stateRec, stateName);
   boolean valid = false;
    try   {
          FileReader f = new FileReader(args[0]);
          BufferedReader in = new BufferedReader(f);
          while ((line = in.readLine()) != null)
             {
             st = new StringTokenizer(line);
             System.out.println("Street number: " + st.nextToken().trim());
             System.out.println("Street name: " + st.nextToken(",").trim());
             System.out.println("City: " + st.nextToken(",").trim());
             st.nextToken(" ");   // rid of the comma after the city name
             state = st.nextToken().trim().toUpperCase();
// Validate the state, ignoring the case sensitivity
             if (! stateRec.contains(state))
                System.out.println(state + " is an invalid state!");
             else  // display the state's full name
                System.out.println("State: " +  stateName.get(stateRec.indexOf(state)));
             System.out.println("Zip code: " + st.nextToken().trim());
             } // loop until the end of file
          in.close(); 
          f.close();
          }
           catch (Exception e) {  e.printStackTrace(); };
    } // main

/**
Read the state information from the file into a look-up table.
Sample Input line:
   MD, Maryland
*/
static void setStateRec(ArrayList <String> rec, ArrayList <String> name)
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
             name.add(st.nextToken().trim());
             } 
          inFile.close(); 
          f.close();
          }
          catch (IOException ioe) {  System.err.println(ioe); };
  } // setStateRec

} // CheckAddress
