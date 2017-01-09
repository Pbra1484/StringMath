package string.controller;

public class StringController 
{
	
	
	
	String number1;
	String number2;
	int cNumber;
	int carry;
	
	
	
	
	
	
	
	
	
	
	
	StringController()
	{
		
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
			String temp = number1;
			number1 = number2;
			number2 = temp;
			length = number1.length();
		}
		
		for(int index = 0; index < length; index++)
		{
			
			
		}
		
	}
	
	public  void print(String print)
	{
		System.out.println(print);
	}

}
