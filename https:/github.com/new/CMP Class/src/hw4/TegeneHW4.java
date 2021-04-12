package hw4;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
	Using java.util.LinkedList to implement an insertion sort.
	This program reads a file into a linkedList 
	sorts the books in an ascending order by title
	Searches for the book by requesting the user to put the publishing year of the book
	Exits the program when user enters 3
	 
	*/
	
	public class TegeneHW4   {
	static String FileName = "hw4Data.txt"; 
	void readFile(LinkedList<Book> l) {
		String line;
		try {
			  BufferedReader inFile = new BufferedReader(new FileReader(FileName)); 
		      while ((line = inFile.readLine()) != null){
		    	  StringTokenizer st = new StringTokenizer(line, ",");
		    	  if(st.countTokens() == 3) // ignore dirty data, if the data doesn't contain three fields it will be considered dirty
		    		  l.add(new Book(st));
		            }
		      inFile.close();
		      sortBooks(l);
		      
		      }
		  catch(IOException ioe) {  System.err.print(ioe); }
	}// Reading the file in to the linkedlist 
	
	void search(LinkedList <Book> l, int year) {
		LinkedList <Book> r = new LinkedList();
		for(int i = 0; i < l.size(); i++)
			if(l.get(i).getYear() == year)
				r.add(l.get(i));
		print(r);		
	}// Searching through the linkedlist for a specific book based on user entry of the year the book is published 
	
	void print(LinkedList <Book> l) {
		System.out.println("ID\tYear\tTitle");// Header for the printed data 
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i).toString()); 	
	}//Print all the books in the data set 
	
	void sortBooks(LinkedList <Book> l) { 
		Book temp;
		int  index;  // points to the index of the current smallest element
		for (int i=0; i < l.size(); ++i){
			index = i;
			for (int k = i + 1; k < l.size(); ++k)
			    if (l.get(index).getTitle().compareTo(l.get(k).getTitle()) > 0)
				index = k;
		      temp = l.get(i);
			l.set(i, l.get(index));
			l.set(index, temp);
		}
	}// The sorting function which sorts the books ascending using the title as a sorting method 
	
	void menu() {
		System.out.println("Press 1 To print the book list\nPress 2 To search for a book by the publishing Year\nPress 3 to Exit");
	}// Creating the menu to guide and prompt the user what to select 
	
	int input(String text) {
		Scanner s = new Scanner(System.in);
		int userInput = 0;
		boolean ok = false;
		do {
			try {
				System.out.println(text);
				userInput = Integer.parseInt(s.next());
				ok = true;
			}catch(Exception e) {
				System.out.println("ERROR");
				ok = false;
			};
		}while(!ok);
		return userInput;
	} // Using a scanner function to take instructions from the user 
	
	public static void main(String []args)    {
		LinkedList <Book> l = new LinkedList();
		int Selection = 0;
		TegeneHW4 t = new TegeneHW4();
		t.readFile(l);
		
		do { //Using Switch Case to choose between the Menus depending on the selection of the user
			switch(Selection) {
			case 0: t.menu(); Selection = t.input("Enter a number?"); break;
			case 1: t.print(l); Selection  = 0; break; 
			case 2: t.search(l, t.input("Enter a Year for search?")); Selection  = 0; break;
			case 3: System.out.println("Good bye! your selection is not recognized "); System.gc(); Selection = -1; break;//Terminate the program with a message 
			default : System.out.println("Error!!! Not a menu item " + Selection); Selection  = 0; break; 
			}
		}while(Selection != -1); 			
	}// The main method     
	
	
	public class Book // The data class 
	{
		int ID; String title; int year;
	public Book() { }
	public Book(int i, String t, int y) 
	{ID = i; title = t; year = y;}
	public Book(StringTokenizer st) 
	{ID = Integer.parseInt(st.nextToken()); title = st.nextToken(); year = Integer.parseInt(st.nextToken());}
	public int getID() { 
		return ID; }
	public String getTitle() { 
		return title; }
	public int getYear() { 
		return year;}
	public void setTitle(String t) { title = t; }
	public void setYear(int y) { year = y; }
	public String toString() { 
		return ID + "\t" + year + "\t"+ title;
		}
	} // Book
	

}

	