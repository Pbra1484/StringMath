package string.controller;

import java.util.Scanner;
import java.lang.StringBuilder;

public class StringController 
{
	StringBuilder number1;
	StringBuilder number2;
	StringBuilder total;
	StringBuilder result;
	int carry;
	private Scanner userInput;
	int digit1;
	int digit2;
	
	StringController()
	{
		userInput = new Scanner(System.in);
		carry = 0;
		number1 = new StringBuilder();
		number2 = new StringBuilder();
		total = new StringBuilder();
		result = new StringBuilder();
		digit1 = 0;
		digit2 = 0;
	}
	
	public void start()
	{
		
		String exit = "";
		while(exit.equalsIgnoreCase("Exit")  != true)
		{
			System.out.println("Would you like to add something or exit? (Add/Exit)");
			exit = userInput.nextLine();
			if(exit.equalsIgnoreCase("Add"))
			{
				addFromInput();
			}
		}
		System.out.println("Exiting");
	}
	
	private void addFromInput()
	{
		System.out.println("Please input two positive numbers with one or less decimals and no other non number characters");
		number1.append(userInput.nextLine());
		number2.append(userInput.nextLine());
		total.delete(0, total.length());
		
		if(isValid(number1) && isValid(number2))
		{
			System.out.println("valid numbers");
			
			ajustDecimals();

			
			if(number1.length() >= number2.length())
			{
				addFormated(number1, number2);
			}
			else
			{
				addFormated(number2, number1);
			}
			
			/*
			 * reverses and prints total so it can be read
			 */
			total.reverse();
			System.out.println("the total is:");
			System.out.println(total);
		}
		else
		{
			number1.delete(0, number1.length());
			number2.delete(0, number2.length());
			
			System.out.println("invalid numbers");
		}
	}
	
	//startComplexity
	
	private void addFormated(StringBuilder one, StringBuilder two)
	{
		for(int index = one.length() - 1; index >= 0; index--)
		{
			if(one.charAt(one.length()-1) != '.')
			{
				getDigits(one, two);				
				addDigits();
			}
			else
			{
				one.deleteCharAt(one.length() -1);
				two.deleteCharAt(two.length() -1);
				total.append(".");
			}
		}
		
		/*
		 * adds the last carry to the end of total
		 */
		if(carry != 0)
		{
			total.append(carry);
		}
	}
	
	//endComplexity
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//startAbstraction
	private void addDigits()
	{
			/*
			 * clears the result StringBuilder and adds the digits together into result
			 */
			result.delete(0, result.length());
			result.append(digit1 + digit2 + carry);
			
			/*
			 * adds result to the end of total
			 */
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
	
	//endAbstraction
	
	private void getDigits(StringBuilder one, StringBuilder two)
	{
		digit1 = Integer.parseInt(Character.toString(one.charAt(one.length()-1)));
		
		one.deleteCharAt(one.length()-1);
		
		if(two.length() != 0)
		{
			digit2 = Integer.parseInt(Character.toString(two.charAt(two.length()-1)));;
			two.deleteCharAt(two.length()-1);
		}
		else
		{
			digit2 = 0;
		}
		
	}
	
	private boolean isValid(StringBuilder test)
	{
		try
		{
			int dots = 0;
			for(int index = 0; index < test.length(); index++)
			{			
				if(test.charAt(index) == '.')
				{
					dots++;
				}
				else
				{
					int temp = Integer.parseInt(test.substring(index, index+1));
				}
			}
			
			if(dots < 2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(NumberFormatException except)
		{
			return false;
		}
	}
	
	private void ajustDecimals()
	{
		if(number1.indexOf(".") != -1 || number2.indexOf(".") != -1)
		{

			if(number1.indexOf(".") == -1)
			{
				number1.append(".");
			}
			else if(number2.indexOf(".") == -1)
			{
				number2.append(".");
			}
			
			StringBuilder sub = new StringBuilder(number1.substring(number1.indexOf(".") + 1));
			StringBuilder sub2 = new StringBuilder(number2.substring(number2.indexOf(".") + 1));
			
			for(int zeros = Math.abs(sub2.length() - sub.length()); zeros > 0; zeros--)
			{
				
				if(sub.length() > sub2.length())
				{
					number2.append("0");
				}
				else
				{
					number1.append("0");
				}
			}
		}
	}
}