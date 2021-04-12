package exercise;
/**

This program shows the time needed to read input records from a file into java.util.ArrayList
**/
import java.util.*;
import java.io.*;
public class ShowCPU3
{
public static void main(String []args)
  {
  try {
  FileReader f = new FileReader("myfile");
  BufferedReader inFile = new BufferedReader(f);
  ArrayList <String> list = new ArrayList <String>();
  String line;
  long startTime = System.currentTimeMillis();
  while ((line = inFile.readLine()) != null)
        {
        list.add(line);
        }
  System.out.print("CPU time used: " +  (System.currentTimeMillis() - startTime) + " ms");
  inFile.close();
  } catch (IOException ioe) { System.err.println(ioe); }
  } // main
}// ShowCPU3