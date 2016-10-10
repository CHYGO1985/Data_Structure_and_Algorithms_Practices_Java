
public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
        // * build two hash tables for mapping
        // *** result: 14ms, beat 80%, fastest in the database is 2ms.
        
        // special case: s.length() = 0 and t.length() = 0
        // build a hash table for s (using array), store the differnce between s.charAt(i) - t.charAt(i)
        
        // 3ms solution from https://discuss.leetcode.com/category/213/isomorphic-strings
        // this solution used hash tables as well, but it used char as key directly (without the trouble of doing minus)
        // also the solution decrease the use of ifs, by combine comparing two default values together
        // also, it used the corresponding char in another string as the value of key.
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int length = sArr.length;
        if(length != tArr.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = sArr[i];
            char tc = tArr[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
        
        /*
        // *** "character" means string can contain not only chars but also nums or simbles.
        int[] sToT = new int[128];
        
        // *** another hash table is need for t, to prevent two same chars match to dif chars in s
        int[] tToS = new int[128];
        
        for (int i = 0; i < sToT.length; i++) {
            // do not use -1, cause the s.charAt(i) - t.charAt(i) can be -1.
            sToT[i] = 129;    
            tToS[i] = 129;
        }
        
        // if s.charAt(i) - 'a' has no value in the array, then add the s.charAt(i) - t.charAt(i) to array
        for (int i = 0; i < s.length(); i ++) {
            
            int indexS = Math.abs(s.charAt(i) - Character.MIN_VALUE);
            int indexT = Math.abs(t.charAt(i) - Character.MIN_VALUE);
            int value = s.charAt(i) - t.charAt(i);
            
            if (129 == sToT[indexS]) {
                sToT[indexS] = value;
            }
            // if s.charAt(i) - 'a' is in the array, then if s.charAt(i) - t.charAt(i) != existin value, return false
            else if (sToT[indexS] != value) {
                    return false;
            }
            
            if (129 == tToS[indexT]) {
                tToS[indexT] = value;
            }
            else if (tToS[indexT] != value) {
                return false;
            }
        }
        
        // continue until the end
        return true;
        */
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       boolean result = isIsomorphic("egg", "add");
	}

}
