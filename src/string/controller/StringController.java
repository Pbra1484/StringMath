package string.controller;

import java.util.Scanner;
import java.lang.StringBuilder;

public class StringController 
{
	
	
	
	StringBuilder number1;
	StringBuilder number2;
	StringBuilder total;
	StringBuilder result;
	int cNumber;
	int carry;
	private Scanner userInput;
	
	
	
	
	
	
	
	
	
	
	StringController()
	{
		userInput = new Scanner(System.in);
		carry = 0;
		number1 = new StringBuilder();
		number2 = new StringBuilder();
		total = new StringBuilder();
		result = new StringBuilder();
		
	}
	
	
	public void start()
	{
		number1.append(userInput.nextLine());
		number2.append(userInput.nextLine());
		
		/*
		 * makes the longer StringBuilder into number1
		 */
		int length = -1;
		int slength = -1;
		if(number1.length() >= number2.length())
		{
			length = number1.length() - 1;
			slength = number2.length() - 1;
			
		}
		else
		{
			StringBuilder temp = number1;
			number1 = number2;
			number2 = temp;
			length = number1.length() - 1;
			slength = number2.length() - 1;
		}
		
		
		
		
		
		for(int index = length; index >= 0; index--)
		{
			/*
			 * gets the first characters in the number strings
			 * cannot handle being fed non number characters or doubles
			 */
			int digit1 = Integer.parseInt(Character.toString(number1.charAt(number1.length()-1)));
			int digit2 = 0;
			number1.deleteCharAt(number1.length()-1);
			print("digit 1 is:");
			System.out.println(digit1);
			
			if(number2.length() != 0)
			{
				digit2 = Integer.parseInt(Character.toString(number2.charAt(number2.length()-1)));;
				number2.deleteCharAt(number2.length()-1);
				print("digit 2 is:");
				System.out.println(digit2);
			}
			else
			{
				print("Number 2 complete defalting to 0");
			}
			
			/*
			 * prints out the amount being carried over
			 */
			print("carry is:");
			System.out.println(carry);
			
			/*
			 * clears the result StringBuilder and adds the digits together into result
			 */
			result.delete(0, result.length());
			result.append(digit1 + digit2 + carry);
			

			/*
			 * prints the result and adds it to the end of total
			 */
			print("result is:");
			System.out.println(result.toString());
			total.append(result.charAt(result.length()-1));
			result.deleteCharAt(result.length()-1);
			
			/*
			 * checks for carrying over
			 */
			if(result.length() != 0)
			{
				carry = Integer.parseInt(Character.toString(result.charAt(0)));
			}
			else
			{
				carry = 0;
			}
			
		}
		/*
		 * adds the last carry to the end of total
		 */
		if(carry != 0)
		{
			total.append(carry);
		}
		/*
		 * reverses and prits total so it can be read
		 */
		total.reverse();
		print("the total is:");
		System.out.println(total);
	}
	
	public  void print(String print)
	{
		System.out.println(print);
	}

}
