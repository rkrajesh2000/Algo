package Algo.Test;

public class ReversalOfInteger {

	public static void main(String[] args) {

		System.out.println(String.valueOf(reverseInteger(1234)));
		System.out.println(String.valueOf(reverseInteger(-1234)));
		System.out.println(String.valueOf(reverseInteger(1534236469)));
	}

	//Test Case: 1534236469, 1234, -1234
    public static int reverseInteger(int n) {
        try {

        	int number = Math.abs(n);
            int result = 0;
            
            while (number > 0) {
               
            	//Check if integer over flow may occur
            	long checker = ((long)result * 10) + ((long)number % 10);            	
            	if( checker > Integer.MAX_VALUE)
            		return 0;
            	
            	result = (result * 10) + (number % 10);                
                number = number / 10;
            }
            
            if(n < 0)
                result = result * -1;
            
            return result;

        }
        catch (StackOverflowError ex)
        { return 0; }
    }
}
