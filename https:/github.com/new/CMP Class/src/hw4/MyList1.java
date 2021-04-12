package hw4;


// Linked list -- A non-object oriented approach
public class MyList1  {
 public static void main(String [] args)   
 { 
 int  []n = { 20, 10, 50, 40 }; 

   MyList1   head = null, tail = null, temp;
   for (int k = 0; k < n.length; ++k)
        {
         temp = new MyList1(n[k]);
         if (head == null)  // Is the list empty?
	{
	head = temp;
	tail = temp;
	}
// Otherwise, a new node is appended to the list
        else 
	{
	tail.next = temp;
	tail = temp;
	}
        } // for
// Display the list elements
	temp = head;
	while (temp != null)
	{
	temp.show();
	temp = temp.next;
	} // while
  } //main
	
int      value;
MyList1  next;   // link to the next node

public MyList1() 
  {  next = null; }

public MyList1(int  x) // constructor
  {  
   value = x;  
   next = null;  
   }

public String toString()  
  { return (" " + value); }

public void show()  
  {
	//System.out.println("here are the numbers...");
  System.out.println( toString()); 
  }

} // MyList1
