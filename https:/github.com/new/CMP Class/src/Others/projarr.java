package Others;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//import project_1.arrpjdata;

public class projarr {
	public static void main(String  []args) {
		String line;
		ArrayList <arrpjdata> recs = new ArrayList <arrpjdata> ();
		
		try {
			BufferedReader inFile= 
					new BufferedReader(new FileReader("pjData.csv"));
			while ((line = inFile.readLine()) != null)
				recs.add(new arrpjdata(line));
			inFile.close();
		}
		catch (IOException e) { System.err.println(e); System.exit(1);}
		System.out.println(recs.size()+ " records are processed!");
		
		// Choose the data structure to use, to perform data retrieval 
		System.out.println("Which Data Staructure would you like to use? ");
		Scanner choice = new Scanner (System.in);
	
		for (arrpjdata vals : recs)
			System.out.println(vals);
		}//Main
	}// Reading the data

class arrpjdata{
	int OrderNum;
	String City;
	String  State;
	int ZipCode;
	double Amount;
	String  Date;
	String  Email ;
	
	
	public arrpjdata() {}
	public arrpjdata (String s) {
	
	
		StringTokenizer st = new StringTokenizer(s, ",");
		//Integer.toString(int) (OrderNum) = st.nextToken(",");
		State = st.nextToken(",");
		  Email = st.nextToken(",");
}
	public int getOrderNum() {return OrderNum;}
	public void setOrder(int ordernum) {OrderNum = ordernum;}
	public String getCity() {return City;}
	public void setCity(String city) {City = city;}
	public String getState() {return State;}
	public void setState(String state) {State = state;}
	public int getZipCode() {return ZipCode;}
	public void setZipCode(int zipCode) {	ZipCode = zipCode;}
	public double getAmount() {return Amount;}
	public void setAmount(double amount) {Amount = amount;}
	public String getDate() {return Date;}
	public void setDate(String date) {Date = date;}
	public String getEmail() {return Email;}
	public void setEmail(String email) {Email = email;}

	@Override
	public String toString() 
		{
		return OrderNum + "  " + City + " " + State + " " + ZipCode + " " + Amount + " " + Date + " " + Email +" ";}
	
		
	
	
}


