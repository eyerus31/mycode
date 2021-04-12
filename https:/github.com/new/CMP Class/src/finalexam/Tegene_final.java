/*
 * Final Exam 
 * @author Tegene
 * 
 * 
 */
package finalexam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Tegene_final {
	
	    public Tegene_final() {
	        TreeSet<Credentials> binaryTree = new TreeSet<>();
	        readData(binaryTree, "TreeSet");
	        System.out.println(binaryTree);
	        
	        HashSet<Credentials> hashSet = new HashSet<>();
	        readData(hashSet, "HashSet");
	        System.out.println(hashSet);
	    }

	    private void readData(Collection<Credentials> record, String collectionName) {
	        try {
	            Scanner file = new Scanner(new File("⁩hw5Data.csv"));
	            
	            while (file.hasNextLine()) {
	                String[] data = file.nextLine().split(",");

	                if (data.length < 2) {
	                    continue;
	                }

	                Credentials creds = new Credentials(data[0], data[1]);
	                record.add(creds);
	            }

	            long startTime = System.currentTimeMillis();
	            for (int i = 0; i < 4000; i++) {
	              /* 
	            	BufferedReader pass = new BufferedReader(new FileReader("passwordInput.txt"));
	            			while (pass.ready())
	            			{
	            				String P = pass.readLine();
	            				System.out.println("Searching allStates hashset for " + P);
	            				if (HashSet.)
							}
	            	*/
	                file = new Scanner(new File("passwordInput.txt"));

	                while (file.hasNextLine()) {
	                    String username = file.nextLine();
	                    if (collectionName.equals("TreeSet")) {
	                        record.stream().filter(b -> b.username.equalsIgnoreCase(username))
	                                .collect(Collectors.toCollection(TreeSet::new));
	                    } else {
	                        record.stream().filter(b -> b.username.equalsIgnoreCase(username))
	                                .collect(Collectors.toCollection(HashSet::new));
	                    }
	                }
	            }
	            long endTime = System.currentTimeMillis();

	            System.out.println(String.format("CPU Time used for the search is  ", collectionName, (endTime - startTime) + "ms"));
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Tegene_final.class.getName()).log(Level.SEVERE,
	                    "Cannot find the file", ex);
	        }
	    }

	    public static void main(String[] args) {
	        new Tegene_final();
	    }

	    private class Credentials implements Comparable<Credentials> {

	        private String username;
	        private String password;

	        public Credentials(String username, String password) {
	            this.username = username;
	            this.password = password;
	        }

	        @Override
	        public int compareTo(Credentials c) {
	            return this.username.compareTo(c.username);
	        }

	        @Override
	        public String toString() {
	            return String.format("%s%s", username, password);
	        }

	    }
	}

