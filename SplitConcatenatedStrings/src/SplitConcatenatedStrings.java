
public class SplitConcatenatedStrings {
    // round 1: 3 hours, unsovled 
    // *** when check whether need to reverse a string, compare head and tail is not enough
	// 2. *** [ "cgd", "ehv","bzy","zxx"] checking only reverse string is not enough, is the biggest char is in the 
    // the middle of a string, both direction of that string will need to be checked, e.g. bzy is reversed as yzb
    // but bzy is bigger than yzb when cutting
    
    // test case: ["bdz", "xga"] : "zxgabd"
    // [ "cgd", "ehk","bdz","zyx"] : "zzyxdgckhebd"
    // [ "cgd", "ehv","bzy","zxx"] : "zyzxxdgcvheb"
    // idea:
    // 1. concatenate: if tail > head, reverse 
    // 2. cut: find the biggest char, if multiple, find the ones have the biggest following char
    // zdca : zdcb --> zdcb
    
    // *** java: StringBuilder reverse
    // *** Java: String compareTo method
	// 2. create array of linkedlist
    // ref: https://stackoverflow.com/questions/20202889/how-can-i-create-an-array-of-linked-lists-in-java
	public static String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0)
                strs[i] = rev;
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st: new String[] {strs[i], rev}) { // rev is the original string, strs[i] is the reversed one (if the original is reversed)
                for (int k = 0; k < st.length(); k++) { // every st, get all its substrings and combine with the rest of reversed string
                    StringBuilder t = new StringBuilder(st.substring(k));
                    for (int j = i + 1; j < strs.length; j++) // current string combine with the rest of reversed strings after st (at i)
                        t.append(strs[j]);
                    for (int j = 0; j < i; j++) // add all strings in strs before i
                        t.append(strs[j]);
                    t.append(st.substring(0, k));
                    if (t.toString().compareTo(res) > 0)
                        res = t.toString();
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = splitLoopedString(new String[]{"cgd", "ehv","bzy","zxx"});
	}

}
