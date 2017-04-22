
public class FlipGameII {
	
	public boolean canWin(String s) {
        // round 1: spend hours, stuck on a wrong a idea
        // idea: backtracking (moneyExchange)
        
        // method 1:
        // https://discuss.leetcode.com/topic/35574/neat-java-solution-beats-92
        // *** i+1 is for i ++
        for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
            // *** use ! here is, 1st round, is false, then p1 win; 2nd, if true, means p2 win, then p1 false, so use !...
            if (!canWin(s.substring(0, i) + "-" + s.substring(i+2)))
                return true;
        return false;
        
        // method 2:
        // https://discuss.leetcode.com/topic/27287/short-java-ruby/2
        /*
        HashMap<String, Boolean> memoize = new HashMap<String, Boolean>();
        return canWinRec(s, memoize);
        */
    }
    
    /*
    public boolean canWinRec(String s, HashMap<String, Boolean> memoize) {
        if(memoize.containsKey(s)){
            return memoize.get(s);
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                String flipedString = s.substring(0,i) + "--" +  s.substring(i+2);
                if(canWinRec(flipedString, memoize)){ // 
                    continue;
                }
                memoize.put(s, true);
                return true;
            }
        }
        memoize.put(s, false);
        return false;
    }
    */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "+++++++++";
		String s = "++++";
		int a = s.indexOf("++", 0);
	}

}
