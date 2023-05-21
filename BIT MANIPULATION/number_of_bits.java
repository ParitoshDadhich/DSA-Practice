// METHOD 1

// Java program to
// find total bit
// in given number
import java.io.*;

class Practice
{
	static int countBits(int number)
	{

		return (int)(Math.log(number) 
					Math.log(2) + 1);
	}
	
	public static void main (String[] args)
	{
		int num = 65;
		
		System.out.println(countBits(num));
								
	}
}


// method 2
 
representation of positive integer */
class Practice {

	static int countBits(int n)
	{
		int count = 0;
		while (n != 0)
		{
			count++;
			n >>= 1;
		}
		
		return count;
	}
 
	public static void main(String[] arg)
	{
		int i = 65;
		System.out.print(countBits(i));
	}
}

