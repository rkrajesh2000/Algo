package Algo.Test;

public class ReverseBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		System.out.println("Input number is " + n + ". After Bit revers number is " + reverseBits(n));
		
		n = 536870912 ;
		System.out.println("Input number is " + n + ". After Bit revers number is " + reverseBits(n));
		
//		System.out.println(reverseBitsApproach2(4));
//		System.out.println(reverseBitsApproach2(43261596));
	}

	private static int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32 - i - 1);
		}
	 
		return n;
	}
	 
	private static int swapBits(int n, int i, int j) {
		
		int num = n;
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;		
		
		if ((a ^ b) != 0) {
			//return n ^= (1 << i) | (1 << j);
			num = num ^ ((1 << i) | (1 << j));
		}
	 
		//return n;
		return num;
	}
	
	//Not Correct
	private static int reverseBitsApproach2(int n) {
		int x = 0;
		int y = 65536;
		int num = n;
		
		for(int i = 0; i < 32; i++)	{
			
			int r = num & 1;
			num = num >> 1;
			x = x >> 1;
			
			if( r == 1)				
				x = x | y;

		}
		
		return x;
	}
}
