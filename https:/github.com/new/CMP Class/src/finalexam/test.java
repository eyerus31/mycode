package finalexam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class test {
	
		public static void main( String[] args ) throws Exception
		{
			BufferedReader records = new BufferedReader( new FileReader("hw5Data.csv") );
			HashSet<String> recs = new HashSet<String>();
			while ( records.ready() ) recs.add( records.readLine() ); 
			System.out.println("Stored these states in hashset allStates:");
			for ( String state : recs ) System.out.print( state + " ");
			System.out.println( "\n\nNow searching through a file of strings that may or may not be states\n" );
				
			BufferedReader credentials = new BufferedReader(new FileReader("passwordInput.txt"));
			while ( credentials.ready() ) 
			{ 
				String Pass = credentials.readLine(); 
				System.out.print("Searching password in the hashset for " + Pass );
				if ( recs.contains( Pass ) )
					System.out.println( " FOUND");
				else
					System.out.println( " NOT in in record");
			}

		} // END MAIN
	} // END CLASS


