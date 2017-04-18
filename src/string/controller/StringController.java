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
		number1.append(userInput.nextLine());
		number2.append(userInput.nextLine());
		
		
		if(isValid(number1) && isValid(number2))
		{
			System.out.println("is valid");
		}
		else
		{
			
			number1.delete(0, number1.length());
			number2.delete(0, number2.length());
			
			System.out.println("invalid numbers");
		}
		
		/*
		 * makes the longer StringBuilder into number1
		 */
		
		
//		int length = -1;
		
		
//		if(number1.length() >= number2.length())
//		{
//			length = number1.length() - 1;
//
//			
//		}
//		else
//		{
//			StringBuilder temp = number1;
//			number1 = number2;
//			number2 = temp;
//			length = number1.length() - 1;
//		}
		
		
//		System.out.println(number1);
//		System.out.println(number2);
		
		
		
//		if(number1.indexOf(".") != -1 || number2.indexOf(".") != -1)
//		{
//			if(number1.indexOf(".") != -1)
//			{
//				StringBuilder sub = new StringBuilder(number1.substring(number1.indexOf(".") + 1));
//
//				System.out.println(sub);
//				
//				if(number2.indexOf(".") != -1)
//				{
//					StringBuilder sub2 = new StringBuilder(number2.substring(number2.indexOf(".") + 1));
//					
//					System.out.println(sub2);
//					
//					for(int zeros = Math.abs(sub2.length() - sub.length()); zeros > 0; zeros--)
//					{
//						
//						if(sub.length() > sub2.length())
//						{
//							number2.append("0");
//						}
//						else
//						{
//							number1.append("0");
//						}
//					}
//				}
//				else
//				{
//					number2.append(".");
//					for(int zeros = 0; zeros < sub.length(); zeros++)
//					{
//						number2.append("0");
//					}
//				}
//			}
//			else if(number2.indexOf(".") != -1)
//			{
//				StringBuilder sub2 = new StringBuilder(number2.substring(number2.indexOf(".") + 1));
//
//				
//				if(number1.indexOf(".") != -1)
//				{
//					
//					for(int zeros = Math.abs((number1.length() - number1.indexOf(".")) - sub2.length()); zeros < sub2.length(); zeros++)
//					{
//						number1.append("0");
//					}
//				}
//				else
//				{
//					number1.append(".");
//					for(int zeros = 0; zeros < sub2.length(); zeros++)
//					{
//						number1.append("0");
//					}
//				}
//			}
//		}
		
		ajustDecemals();
		
		
		
		
		
		
		
		
		System.out.println(number1);
		System.out.println(number2);
		

		
//		for(int index = number1.length()-1; index >= 0; index--)
//		{
//			/*
//			 * gets the first characters in the number strings
//			 * cannot handle being fed non number characters or doubles
//			 */
//			digit1 = Integer.parseInt(Character.toString(number1.charAt(number1.length()-1)));
//			digit2 = 0;
//			number1.deleteCharAt(number1.length()-1);
//			System.out.println("digit 1 is:");
//			System.out.println(digit1);
//			
//			if(number2.length() != 0)
//			{
//				digit2 = Integer.parseInt(Character.toString(number2.charAt(number2.length()-1)));;
//				number2.deleteCharAt(number2.length()-1);
//				System.out.println("digit 2 is:");
//				System.out.println(digit2);
//			}
//			else
//			{
//				System.out.println("Number 2 complete defalting to 0");
//			}
//			
//			/*
//			 * prints out the amount being carried over
//			 */
//			System.out.println("carried from previous:");
//			System.out.println(carry);
//			
//			/*
//			 * clears the result StringBuilder and adds the digits together into result
//			 */
//			result.delete(0, result.length());
//			result.append(digit1 + digit2 + carry);
//			
//
//			/*
//			 * prints the result and adds it to the end of total
//			 */
//			System.out.println("result is:");
//			System.out.println(result.toString());
//			total.append(result.charAt(result.length()-1));
//			result.deleteCharAt(result.length()-1);
//			
//			/*
//			 * checks for carrying over
//			 */
//			if(result.length() != 0)
//			{
//				carry = Integer.parseInt(Character.toString(result.charAt(0)));
//			}
//			else
//			{
//				carry = 0;
//			}
//			
//		}
//		/*
//		 * adds the last carry to the end of total
//		 */
//		if(carry != 0)
//		{
//			total.append(carry);
//		}
		
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
	


	private void addFormated(StringBuilder one, StringBuilder two)
	{
		for(int index = one.length() - 1; index >= 0; index--)
		{
			if(one.charAt(one.length()-1) != '.')
			{
				getDigits(one, two);
				
				/*
				 * prints out the amount being carried over
				 */
				System.out.println("carried from previous:");
				System.out.println(carry);
				
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
	
	private void addDigits()
	{
			/*
			 * clears the result StringBuilder and adds the digits together into result
			 */
			result.delete(0, result.length());
			result.append(digit1 + digit2 + carry);
			
			/*
			 * prints the result and adds it to the end of total
			 */
			System.out.println("result is:");
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
	
	private void getDigits(StringBuilder one, StringBuilder two)
	{
		digit1 = Integer.parseInt(Character.toString(one.charAt(one.length()-1)));
		
		one.deleteCharAt(one.length()-1);
		System.out.println("digit 1 is:");
		System.out.println(digit1);
		
		if(two.length() != 0)
		{
			digit2 = Integer.parseInt(Character.toString(two.charAt(two.length()-1)));;
			two.deleteCharAt(two.length()-1);
			System.out.println("digit 2 is:");
			System.out.println(digit2);
		}
		else
		{
			System.out.println("Number 2 complete defalting to 0");
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
	
	private void ajustDecemals()
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
			
//			System.out.println(sub);
//			System.out.println(sub2);
			
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






