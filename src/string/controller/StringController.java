package string.controller;

import java.util.Scanner;
import java.lang.StringBuilder;

public class StringController 
{
	
	
	
	StringBuilder number1;
	StringBuilder number2;
	StringBuilder total;
	int cNumber;
	int carry;
	private Scanner userInput;
	
	
	
	
	
	
	
	
	
	
	StringController()
	{
		userInput = new Scanner(System.in);
		
		number1 = new StringBuilder(userInput.nextLine());
		number2 = new StringBuilder(userInput.nextLine());
		
		
	}
	
	
	public void start()
	{
		int length;
		if(number1.length() > number2.length())
		{
			length = number1.length();
		}
		else
		{
			StringBuilder temp = number1;
			number1 = number2;
			number2 = temp;
			length = number1.length();
		}
		
		
		
		
		
		for(int index = 0; index < length; index++)
		{
			int digit1 = Integer.parseInt(Character.toString(number1.charAt(0)));
			number2.deleteCharAt(0);
			System.out.println(digit1);
			int digit2 = Integer.parseInt(Character.toString(number1.charAt(0)));
			number2.deleteCharAt(0);
			System.out.println(digit1);
			
			StringBuilder result = new StringBuilder(digit1 + digit2);
			System.out.println(result);
		}
		
	}
	
	public  void print(String print)
	{
		System.out.println(print);
	}

}
