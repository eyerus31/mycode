package Others;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hashclass {
	public static void main(String []args) {
		
		} // main
		

class pjdatahash {
int Ordernum;
String City;
String State;
String ZipCode;
double Amount;
String  Date;
String  Email ;


//public public public
pjdatahash() { Ordernum = -99999; City = null; State = null; ZipCode = null; Amount = 0.0; Date = null; Email = null; }
pjdatahash(int num, String c, String s, String zc, double a, String d, String e ) 
{ Ordernum = num; City = c; State = s; ZipCode = zc; Amount = a;Date = d; Email= e; } 
pjdatahash(String s, String d)
{
StringTokenizer st = new StringTokenizer(s, d);
Ordernum = Integer.valueOf(st.nextToken(d));
City = st.nextToken();
State = st.nextToken();
ZipCode = st.nextToken();
Amount = Double.valueOf(st.nextToken(d));
Date = st.nextToken();
Email = st.nextToken();

}
 // OrderRec
int getOrdernum() { return Ordernum; }
String getCity() { return City; }
String getState() { return State; }
double getAmount() { return Amount; }

}
}