package Algo.Test;

import java.util.*;

public class ReverseBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		System.out.println("Input number is " + n + ". After Bit revers number is reverseBits():" + reverseBits(n));
		//System.out.println("Input number is " + n + ". After Bit revers number is reverseBitsApproach2()(Not Working): " + reverseBitsApproach2(n));
		
		n = 536870912 ;
		System.out.println("Input number is " + n + ". After Bit revers number is reverseBits():" + reverseBits(n));
		//System.out.println("Input number is " + n + ". After Bit revers number is reverseBitsApproach2()(Not Working): " + reverseBitsApproach2(n));
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
	
	//Not working
	private static int reverseBitsApproach2(int n) {
		int x = 0;
		int num = n;
		List<Integer> list = new ArrayList<>();
		
		while(num > 0){
			list.add(num & 1);
			num = num >> 1;
		}

		while(list.size() % 4  != 0){
			list.add(0, 0);
		}
		
		int size = list.size();
		if(size < 32){
			for(int i = 0; i < 32 - size ; i++)	{
				list.add(0);
			}
		}
		for(int i=0; i < list.size(); i++)	
			x = x + (list.get(i) * (int)Math.pow((double)2, (double)(list.size()-1-i)));
				
		return x;
	}
}
