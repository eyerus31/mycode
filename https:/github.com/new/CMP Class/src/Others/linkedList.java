	package Others;
	import java.io.File;
import java.util.*;
	public class linkedList {
		
		
			//@SuppressWarnings("deprecation")
			public static void main(String []args){
				LinkedList <Integer> numberList=new LinkedList<Integer>();
				long startTime = System.currentTimeMillis();
				Random  r = new Random();
				Integer n = 0;
				int index = 0;
				System.out.println("Original numbers: ");
				for (int k=1; numberList.size() < 10; ++k){
					n = r.nextInt(100);
					System.out.println(n);
					if (numberList.size() < 1){// an empty list
						numberList.add(n);
						continue;  
				
					}  // The first number 
					if (numberList.contains(n)) { 
						System.out.println("Duplicated: " + n); 
						continue; 
						} 
					// a duplicated number
					index = 0;
					for (Integer j : numberList){
						if (j.intValue() > n.intValue()){ 
						// The new number is smaller 
							numberList.add(index, n);
						break;
						}
					++index;} // for  j
					if (index >= numberList.size()) // The current largest 
						numberList.add(n);   // append to the end of the list
					 // for k
					System.out.println("In ascending order:" );
					for (Integer l : numberList) 
					System.out.println(l);
					System.out.print("The CPU time used is: " );
					System.out.println((System.currentTimeMillis() - startTime) + " ms");
					
					
	} // main
			
			}
			}
	
