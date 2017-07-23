package cs320.Homework1;


import java.lang.*;
import java.util.Scanner;

public class testing {
 
	public static void main(String[] args)
	{
	Scanner str=new Scanner(System.in);
	String name = str.nextLine();
	
	String[] arr= name.split("\\s");
	String fname="";
	System.out.println(arr[arr.length-1]);
	for (int i = 0; i <= arr.length-2; i++) {
		//System.out.println(arr[i]);
		fname = fname +" "+ arr[i];
	}
	System.out.println("fname :"+fname);
	}
}