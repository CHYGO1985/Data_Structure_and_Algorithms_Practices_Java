/**
 * 
 * 735. Asteroid Collision
 * 
 * @author jingjiejiang
 * @history Oct 21, 2020
 * 
 */
class Solution {
  // public int[] asteroidCollision(int[] asteroids) {
        
  //   Stack<Integer> remains = new Stack<>();
    
  //   for (int idx = 0; idx < asteroids.length; idx ++) {
        
  //       if (asteroids[idx] < 0) {
            
  //           if (remains.isEmpty() || (!remains.isEmpty() && remains.peek() < 0)) {
  //               remains.add(asteroids[idx]);
  //               continue;
  //           }
               
  //           boolean isDestroyed = false;
  //           while (!remains.isEmpty() && remains.peek() > 0) {
                
  //               int posVal = Math.abs(asteroids[idx]);
                
  //               if (remains.peek() > posVal) { // if peek > cur, then the peek one left
                    
  //                   isDestroyed = true;
  //                   break;
  //               } else if (remains.peek() < posVal) { // if peek < cur, then pop the top one, continue to compare
                    
  //                   remains.pop();
  //               } else { // if equals, then pop the top one
                    
  //                   isDestroyed = true;
  //                   remains.pop();
  //                   break;
  //               }
  //           }
            
  //           // [1, 2, -5], then should be [-5]
  //           if (!isDestroyed) {
  //               remains.add(asteroids[idx]);
  //           }
            
  //       } else {
  //           remains.add(asteroids[idx]);
  //       }
  //   }
    
  //   int[] res = new int[remains.size()];
  //   int idx = res.length - 1;
    
  //   while (idx >= 0) {
  //       res[idx --] = remains.pop();
  //   }
    
  //   return res;
  // }

  // refactoring of previous method
  public int[] asteroidCollision(int[] asteroids) {
        
    Stack<Integer> remains = new Stack<>();
        
    for (int idx = 0; idx < asteroids.length; idx ++) {
        
        // only check the situation when there will be collision 
        boolean isDestroyed = false;
        
        if (asteroids[idx] < 0) {
            
            while (!remains.isEmpty() && remains.peek() > 0) {
                
                int posVal = Math.abs(asteroids[idx]);
                
                if (remains.peek() > posVal) { // if peek > cur, then the peek one left
                    
                    isDestroyed = true;
                    break;
                } else if (remains.peek() < posVal) { // if peek < cur, then pop the top one, continue to compare
                    
                    remains.pop();
                } else { // if equals, then pop the top one
                    
                    isDestroyed = true;
                    remains.pop();
                    break;
                }
            }
        } 
        
        // [1, 2, -5], then should be [-5]
        if (!isDestroyed) {
            remains.add(asteroids[idx]);
        }
    }
    
    int[] res = new int[remains.size()];
    int idx = res.length - 1;
    
    while (idx >= 0) {
        res[idx --] = remains.pop();
    }
    
    return res;
  }
}