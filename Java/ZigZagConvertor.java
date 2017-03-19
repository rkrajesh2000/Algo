package Algo.Test;

public class ZigZagConvertor {

	public static void main(String[] args) {

		System.out.println(convertToZigZag("PAYPALISHIRING", 3));
		System.out.println(convertToZigZag("INTELISHIRING", 3));
		System.out.println(convertToZigZag("INTELISHIRING", 3));
		int[] arr = new int[] {4, 3, 7, 8, 6, 2, 1};
		//System.out.println(convertToZigZagArr(arr, arr.length/2).toString());
		for(int i : convertToZigZagArr(arr, 3)){
			System.out.print(i + ",");
		}
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
	
	public static int[] convertToZigZagArr(int[] arrIn, int numRows) {
		if (numRows == 1)
			return arrIn;
	 
		int[] arrOut = new int[arrIn.length];
		int count = 0;

		int step = 2 * numRows - 2;
		
		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < arrIn.length; j = j + step) {
					arrOut[count++]= arrIn[j];
				}

			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
				
				while (j < arrIn.length) {
					arrOut[count++]= arrIn[j];

					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
	 
		return arrOut;
	}	
}
