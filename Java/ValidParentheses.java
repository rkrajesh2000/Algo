package Algo.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.print("Is Valid Parentheses : ");
		System.out.print(isValid("[{()}]") + ", ");
		System.out.print(isValid("[") + ", ");
		System.out.print(isValid("][") + ", ");		
		System.out.print(isValid("{)(}") + ", ");
		System.out.print(isValid("[(])") + ", ");
		System.out.print(isValid("((}") + ", ");
		System.out.print(isValid("[)}") + ", ");
		System.out.print("\nLongest Valid Parentheses : ");
		System.out.print(longestValidParentheses(")))(((()))))()") + ", ");
		System.out.print(longestValidParentheses("(())(()"));
		
		System.out.print("\nCreate Parentheses : ");
		
		for(String s : generateParentheses(3)){
			System.out.print(s + ",");
		}		
	}
	
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}	

	public static int longestValidParentheses(String s) {
		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;
	 
		for(int i=0; i<=s.length()-1; i++){
			char c = s.charAt(i);
			if(c=='('){
				int[] a = {i,0};
				stack.push(a);
			}else{
				if(stack.empty()||stack.peek()[1]==1){
					int[] a = {i,1};
					stack.push(a);
				}else{
					stack.pop();
					int currentLen;
					if(stack.empty()){
						currentLen = i+1;
					}else{
						currentLen = i-stack.peek()[0];
					}
					result = Math.max(result, currentLen);
				}
			}
		}
	 
		return result;
	}

    public static List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<String>();
        char[] str = new char[n * 2];
        addParenthesis(n, n, str, 0, list);  
        return list;
    }
    
    private static void addParenthesis(int l, int r, char[] str, int count, List<String> list)  {
        if (l < 0 || r < l) return; // invalid state
        
        if (l == 0 && r == 0) 
        {
            list.add(String.copyValueOf(str)); // found one, so print it
        } 
        else 
        {
            if (l > 0) 
            { // try a left paren, if there are some available
            	str[count] = '(';
                addParenthesis(l - 1, r, str, count + 1, list);
            }

            if (r > l) 
            { // try a right paren, if there’s a matching left

            	str[count] = ')';
                addParenthesis(l, r - 1, str, count + 1, list);
            }
        }
    } 
}
