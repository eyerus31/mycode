package Others;


import java.io.*;
import java.util.*;
public class SortArray
{
public static void main(String [] args)
  {
  DataRec []recs = new DataRec[5000]; // max. 5,000 records
  int cnt=0;
  try {
      BufferedReader inFile = new BufferedReader(new FileReader("sortData.csv"));  
      String line;
      while ((line = inFile.readLine()) != null)
            {
            recs[cnt] = new DataRec(line);
            ++cnt;
            }
      inFile.close();
      }
  catch(IOException ioe) {  System.err.print(ioe); }
  long startTime = System.currentTimeMillis(); 
  (new SortArray()).sortRecs(recs, cnt);
  //sortRecs(recs, cnt);
  System.out.print("CPU time used: " + (System.currentTimeMillis() - startTime) + " ms");
  } // main

void sortRecs(DataRec []rec, int n)
//static void sortRecs(DataRec []rec, int n)
  {
// Implements the selection sort algorithm.
// Find the current smallest and then swaps at the end of each loop.
  DataRec temp;
  int  index;  // points to the index of the current smallest element
  for (int i=0; i < n; ++i)
	{
	index = i;
	for (int k = i + 1; k < n; ++k)
	    if (rec[index].getLastName().compareTo(rec[k].getLastName()) > 0)
		index = k;
        temp = rec[i];
	rec[i] = rec[index];
	rec[index] = temp;
	}
  } // sortRecs
} // SortArray


// Data class
class DataRec
{
String  date, ID, firstName, lastName;
public DataRec(String s)
  {
  StringTokenizer  st = new StringTokenizer(s, ",");
  date = st.nextToken(",");
  ID = st.nextToken(",");
  firstName = st.nextToken(",");
  lastName = st.nextToken(",");
  }
public String getLastName() { return lastName; };
public String getFirstName() { return firstName; }
public String getID() { return ID; }
public String getDate() { return date; }

public String toString() { return (lastName + "   " + firstName + "  " + ID + "   " + date); };
} // DataRec