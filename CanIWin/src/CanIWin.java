import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 464. Can I Win
 * 
 * round 1: unsolved.464. stuck at go to design recursive dp.
 * 
 * idea: I first try to used formula DP (reverse)
 *  1 2 3 ... desiredTotal
 *  T T F ... result
 * However, I found out that it is not possible for non repeatable candidate
 * so I tried two dimensional array, and it still not word, e.g. 4 9
 * when it is 9, reversely it can choose 
 * P1: 9 - 2 = 7
 * P2: 7 - 1 = 6
 * now only 3/4 left, to P2 wins
 * or P1: 9 - 4
 * there are multiple choices. So I realised there is not possible to do with
 * formula DP, it is a recursive DP.
 * 
 * And for every step, i will need to keep the intermediate status of every 
 * available element. I did not know how to check it quickly except using 
 * brutal force method. (*** then i got stuck)
 * 
 * *** the solution is that use hashmap, coz the length is <= 20, so we can
 * 
 * 1) use an int to keep the availability of elements, like 0001010101...
 * use int will pass 
 * 2) or further use Arrays.toString() method to convert it to a string
 * use string will generate TLE error
 * ref: https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation/2
 * 
 * for recursive method, I also do not know how to differentiate player 1 and player 2. 
 * *** the method is: player 1 return true, then the next call of the recursive method
 * (player2's turn), return false
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 13, 2017
 */
public class CanIWin {

	/*
    // TLE error: use string as a key is worst than use int as a key
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        Map<String, Boolean> map = new HashMap<>();
        // false: available ; true: used
        boolean[] isAvail = new boolean[maxChoosableInteger];
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        
        return checkWin(isAvail, map, desiredTotal);
    }
    
    private boolean checkWin(boolean[] isAvail, Map<String, Boolean> map, int desiredTotal) {
         
        String key = Arrays.toString(isAvail);
        
        // get kep from isAvaIl, if we can't find match in map
        // iterate through isAvail, check the next avail ele
        // else return map.get(key) 
        if (map.containsKey(key) == true) return map.get(key);
            
        for (int i = 0; i < isAvail.length; i ++) {
            if (isAvail[i] == false) {
                // desiredTotal -= (i + 1);
                isAvail[i] = true;
                // ***do not change desiredTotal here, otherwise it will change the state
                if (desiredTotal <= i + 1 || checkWin(isAvail, map, desiredTotal - (i + 1)) == false) {

                    map.put(key, true);
                    // *** this one is easy to forget
                    isAvail[i] = false;
                    return true;
                } 

                isAvail[i] = false;
            }
        }

        // *** if all next ele used and return true, current player lose which return false
        map.put(key, false);
        return false;
    }
    */
    
	// ref: https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation/2
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        map = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal);
    }
    
    public boolean helper(int desiredTotal){
        if(desiredTotal <= 0) return false;
        int key = format(used);
        if(!map.containsKey(key)){
    // try every unchosen number as next step
            for(int i=1; i<used.length; i++){
                if(!used[i]){
                    used[i] = true;
     // check whether this lead to a win (i.e. the other player lose)
                    if(!helper(desiredTotal-i)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
   
// transfer boolean[] to an Integer 
    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
