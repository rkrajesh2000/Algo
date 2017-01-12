package Algo.Test;

import java.util.HashMap;

public class NumberAndLetterConvertor {

	public static void main(String[] args) {

		System.out.println("Convert Numbers to Letters");
		System.out.println(
		numberToLetters(1)
		+ ", " + numberToLetters(25)
		+ ", " + numberToLetters(26)		
		+ ", " + numberToLetters(27)
        + ", " + numberToLetters(51)
        + ", " + numberToLetters(52)
        + ", " + numberToLetters(53)
        + ", " + numberToLetters(77)
        + ", " + numberToLetters(78)
        + ", " + numberToLetters(79)
        + ", " + numberToLetters(702)
        + ", " + numberToLetters(703)
        );

		System.out.println(numberToLetters(704)
		        + ", " + numberToLetters(705)
		        + ", " + numberToLetters(2600)
		        + ", " + numberToLetters(25999)
		        + ", " + numberToLetters(26000)
		        + ", " + numberToLetters(26001)
				);
		
		System.out.println("");
		System.out.println("Convert Numbers to Letters");
		System.out.println("ALLA = " + lettersToNumber("ALLA"));		
	}

	public static String numberToLetters(int number){
		
		if(number <= 0)
			return "Not Applicable";
		
		char[] charArr = new char[]{ 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		if(number > 0 && number < 27)
			return String.valueOf(number) + " = " + String.valueOf(charArr[number]);
		
		StringBuffer sb = new StringBuffer();
		int runnerNum = number;
		String remainderLetter = "";
		
		while(runnerNum > 26){			
		
			int quotient = runnerNum / 26;
			int remainder = runnerNum % 26;
			
			if(remainder == 0)
				--quotient;
			
			if(quotient > 0 && quotient < 27) {
				
				if( (runnerNum % 26) == 0)
					sb.append(String.valueOf(charArr[quotient]) + String.valueOf(charArr[0]) );
				else
					sb.append(String.valueOf(charArr[quotient]));
				
			}
			
			if(quotient > 26){				
				
				remainderLetter = String.valueOf(charArr[remainder]) + remainderLetter;
			}
			else if( remainder > 0){
				
					sb.append(String.valueOf(charArr[remainder]));
			}	
			
			runnerNum = quotient;
		}
		
		return String.valueOf(number) + " = " + sb.toString() + remainderLetter;
	}
	
	public static int lettersToNumber(String letters){
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		map.put('F', 6);
		map.put('G', 7);
		map.put('H', 8);
		map.put('I', 9);
		map.put('J', 10);
		map.put('K', 11);
		map.put('L', 12);
		map.put('M', 13);
		map.put('N', 14);
		map.put('O', 15);
		map.put('P', 16);
		map.put('Q', 17);
		map.put('R', 18);
		map.put('S', 19);
		map.put('T', 20);
		map.put('U', 21);
		map.put('V', 22);
		map.put('W', 23);
		map.put('X', 24);
		map.put('Y', 25);
		map.put('Z', 26);
		
		if(letters == null || letters == "")
			return 0;
		
		int len = letters.length();
		int number = 0;
		
		for(int i=0; i < len; i++){
			
			char c = letters.charAt(i);
			
			number = number + (map.get(c) * (int)Math.pow((double)26, (double)(len-1-i)));
		}
		
		return number;
	}
	

}
