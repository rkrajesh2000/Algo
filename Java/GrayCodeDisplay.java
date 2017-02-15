package Algo.Test;

import java.util.*;

public class GrayCodeDisplay {

	public static void main(String[] args) {

		for(int i : grayCode(3)){
			System.out.println(i);
		}
	}
	
	public static List<Integer> grayCode(int n) {
	    if(n==0){
	        List<Integer> list = new ArrayList<Integer>();
	        list.add(0);
	        return list;
	    }
	 
	    List<Integer> result = grayCode(n-1);
	    int numToAdd = 1<<(n-1);
	 
	    for(int i=result.size()-1; i>=0; i--){
	        result.add( numToAdd + result.get(i) );
	    }
	 
	    return result;
	}
}
