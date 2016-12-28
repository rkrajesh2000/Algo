
package Algo.Test;

public class TestArray {

	public static void main(String[] args) {		
		
		System.out.print("IsUniqueChars : " );
		System.out.println(TestArray.IsUniqueChars("abcdefgh"));

	}
	
	public static boolean isNullOrWhiteSpace(String a) {
		return a == null || (a.length() > 0 && a.trim().length() <= 0);
		}
	
    public static boolean IsUniqueChars(String str)
    {
        if (isNullOrWhiteSpace(str))
            return false;

        int checker = 0;

        for (int i = 0, n = str.length(); i < n; i++) {
            char c = str.charAt(i);

            int val = (int)c ;

            if ((checker & (1 << val)) > 0)
            {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }
}
