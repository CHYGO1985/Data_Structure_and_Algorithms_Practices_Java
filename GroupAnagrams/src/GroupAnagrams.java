import java.util.Arrays;


public class GroupAnagrams {
	
	public static int count(String temp) {
		
		int sum = 0;
		
		for (int j = 0; j < temp.length(); j ++) {
            sum += temp.charAt(j) - 'a';
        }
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "duh";
		String b = "ill";
		
		System.out.println("a = " + count(a) + " b = " + count(b));
		
		String s = "abc";
		char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String keyStr = String.valueOf(ca);
        
        System.out.println(keyStr);

	}

}
