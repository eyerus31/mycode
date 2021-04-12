package Others;

/**
Making ArrayList synchronized.
**/
import java.util.*;

public class SyncArrayList
{
public static void main(String []args)
  {
  List <Integer> aList1 = new ArrayList <Integer>();
  List <Integer> aList2 = Collections.synchronizedList(aList1);
  aList1.add(new Integer(99));
  aList1.add(new Integer(77));
  System.out.println(aList1.size());
  System.out.println(aList2.size());
  aList2.add(new Integer(882));
  aList2.add(new Integer(233));
  System.out.println(aList2.size());
  System.out.println(aList1.size());
  } // main
} // SyncArrayList