package Algo.Test;

import java.util.*;

public class PredictWinner {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2 };
		System.out.println("Is Palyer1 winner ? : " + PredictTheWinner(nums));
	}
    public static boolean PredictTheWinner(int[] nums) {
        
    	if(nums.length < 3)
    		return true;
    	
        LinkedList<Integer> list = new LinkedList<Integer>();
        Random rand = new Random();
        int player1 = 0;
        int player2 = 0;
        
        for(int n : nums){
        	list.add(n);
        }
        
        int choice1 = 0;
        int choice2 = 0;
        
        while(!list.isEmpty()){        	
        	
        	if(!list.isEmpty()){
        		choice1 = rand.nextInt(2);

        		if(choice1 > 1){
        			player1 += list.getLast();
        			list.removeLast();
        		}
        		else{
        			player1 += list.getFirst();
        			list.removeFirst();
        		}
        	}
        	
        	if(!list.isEmpty()){
        		choice2 = rand.nextInt(2);
        		
           		if(choice2 > 1){
        			player2 += list.getLast();
        			list.removeLast();
        		}
        		else{
        			player2 += list.getFirst();
        			list.removeFirst();
        		}
        	}
        }
        
        return player1 >= player2;
    }
}
