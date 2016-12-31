package Algo.Test;
import java.util.HashMap;
import java.lang.Math;
import java.util.TreeMap;

public class Convertor {

	public static void main(String[] args) {

		System.out.println(convertToZigZag("PAYPALISHIRING", 3));
		System.out.println(convertToZigZag("INTELISHIRING", 3));
	}
   
	public static String convertToZigZag(String s, int numRows) {
		if (numRows == 1)
			return s;
	 
		StringBuilder sb = new StringBuilder();
		// step
		int step = 2 * numRows - 2;
		//System.out.println("numRows : " + numRows);
		//System.out.println("step : " + step);
		
		for (int i = 0; i < numRows; i++) {
			//first & last rows
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					sb.append(s.charAt(j));
					//System.out.println("1-j :" + j + ", i : " + i + ", Val : " + s.charAt(j));
				}
			//middle rows	
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
				
				//System.out.println("step1 : " + step1);
				//System.out.println("step2 : " + step2);
				
				while (j < s.length()) {
					sb.append(s.charAt(j));
					//System.out.println("2-j :" + j + ", i : " + i + ", Val : " + s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
	 
		return sb.toString();
	}	
}
