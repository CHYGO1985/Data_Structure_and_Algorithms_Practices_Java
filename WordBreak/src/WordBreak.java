import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class WordBreak {
	
		
	        
    public static boolean wordBreak(String s, List<String> wordDict) {
            
    	boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		List<String> list = new LinkedList<String>();
		list.add("leet");
		list.add("code");
		boolean res = wordBreak(s, list);
	}

}
