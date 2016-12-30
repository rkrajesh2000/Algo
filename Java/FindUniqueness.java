
package Algo.Test;

public class FindUniqueness {

	public static void main(String[] args) {		
		
		System.out.println("Is Unique Charachters in string : " );
		System.out.println(FindUniqueness.IsUniqueChars("abcdefgh"));
		System.out.println(FindUniqueness.IsUniqueChars("abcdefgha"));

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
