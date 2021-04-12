package exercise;
import java.io.*;

public class WriteData{
	public static void main(String args[]){
		try {
			FileOutputStream f = new FileOutputStream("file.txt");
			DataOutputStream out = new DataOutputStream(f);
			out.write(1);
			out.close();
			f.close();
			
		}
		catch (IOException e){ e.printStackTrace();}	
		}
}
