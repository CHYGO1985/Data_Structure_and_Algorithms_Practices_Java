
public class FlipGameII {
	
	public static boolean canWin(String s) {
		// i ++ is implemented in (i+1)
		for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
	        if (!canWin(s.substring(0, i) + "-" + s.substring(i+2)))
	            return true;
	    return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "+++++++++";
		String s = "++++";
		int a = s.indexOf("++", 0);
		boolean res = canWin(s);
	}

}
