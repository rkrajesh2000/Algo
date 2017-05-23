package Algo.Test;

import java.util.*;

public class NonOverlappingIntervals {

	
	  //Definition for an interval.
	  static class Interval {
	      int start;
	      int end;
	      Interval() { 
	    	  start = 0; 
	    	  end = 0; 
	      }
	      
	      Interval(int s, int e) { 
	    	  start = s; 
	    	  end = e; 
	      }
	  }
	 
	public static void main(String[] args) {
		
		Interval[] intervals1 = new Interval[5];
		intervals1[0] = new Interval(1,2);		
		intervals1[1] = new Interval(2,3);
		intervals1[2] = new Interval(3,4);
		intervals1[3] = new Interval(1,3);	
		intervals1[4] = new Interval(2,3);	
		System.out.println("Number Of Interval to Remove : " + removeOverlapIntervals(intervals1));
		System.out.print("Merged Intervals : ");
		displayMergeIntervals(mergeIntervals(intervals1));
		
		Interval[] intervals2 = new Interval[3];
		intervals2[0] = new Interval(1,2);
		intervals2[1] = new Interval(1,2);
		intervals2[2] = new Interval(1,2);
		System.out.println("Number Of Interval to Remove : " + removeOverlapIntervals(intervals2));
		System.out.print("Merged Intervals : ");
		displayMergeIntervals(mergeIntervals(intervals2));
		
		Interval[] intervals3 = new Interval[2];
		intervals3[0] = new Interval(1,2);
		intervals3[1] = new Interval(2,3);
		System.out.println("Number Of Interval to Remove : " + removeOverlapIntervals(intervals3));
		System.out.print("Merged Intervals : ");
		displayMergeIntervals(mergeIntervals(intervals3));
	}
	
	private static int removeOverlapIntervals(Interval[] intervals){
		
		int intervalCount = 0;
		
		if(intervals == null || intervals.length < 2)
			return 0;
		
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	    
	    Interval pre = intervals[0];
	    		
	    for(int i=1; i < intervals.length; i++){
	    	Interval curr = intervals[i];
	    	
	    	if(curr.start >= pre.end){	            
	            pre = curr;
	    	}
	    	else{
	            Interval merged = new Interval(pre.start, Math.min(pre.end, curr.end));
	            pre = merged;
	            ++intervalCount;
	    	}
	    }
	    
		return intervalCount;
	}
	
	private static List<Interval> mergeIntervals(Interval[] intervals){
		
		List<Interval> result = new ArrayList<Interval>();
		
		if(intervals == null || intervals.length < 2)
			return result;
		
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	    
	    Interval pre = intervals[0];
	    		
	    for(int i=1; i < intervals.length; i++){
	    	Interval curr = intervals[i];

	    	if(curr.start >= pre.end){
	            result.add(pre);
	            pre = curr;
	    	}
	    	else{
	            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
	            pre = merged;
	    	}
	    }

	    result.add(pre);
		return result;
	}
	
	private static void displayMergeIntervals(List<Interval> list){
		for(Interval val: list){
			System.out.print("["+ val.start + ", " + val.end + "],");
		}
		System.out.println();
	}
}
