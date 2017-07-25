package Algo.Test;

import java.util.*;

public class FindMaxPointInShape {

	/**
	 * Definition for a point.
	 */
	 static class Point {
	      int x;
	      int y;
	      Point() { 
	    	  x = 0; 
	    	  y = 0; 
	      }
	      
	      Point(int a, int b) { 
	    	  x = a; 
	    	  y = b; 
	      }
	 }
	 
	public static void main(String[] args) {

		Point[] points = new Point[]{new Point(1,1), new Point(2,1), new Point(1,2), 
				new Point(3,4), new Point(4,3), new Point(1,1), new Point(6,6), new Point(6,7)};
		
		System.out.println("maxPointsInLine() :" + maxPointsInLine(points));
	}
	
	/* 149
	 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
	 */
    public static int maxPointsInLine(Point[] points) {
    	
        if(points.length <= 0) 
        	return 0;
        
        if(points.length <= 2) 
        	return points.length;
        
        int result = 0;
        
        for(int i = 0; i < points.length; i++){
        	
            HashMap<Double, Integer> map = new HashMap<>();
            int sameX = 1;
            int sameP = 0;
            
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        sameP++;
                    }
                    
                    if(points[j].x == points[i].x){
                        sameX++;
                        continue;
                    }
                    
                    //double k = 0.0000d;
                    double k = (double)((points[j].y - points[i].y) / (points[j].x - points[i].x));
                    
                    if(map.containsKey(k)){
                        map.put(k,map.get(k) + 1);
                    }else{
                        map.put(k, 2);
                    }
                    
                    result = Math.max(result, map.get(k) + sameP);
                }
            }
            
            result = Math.max(result, sameX);
        }
        
        return result;         
    }
}
