/**
 * 
 * 44. Wildcard Matching
 * 
 */
/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
 var isMatch = function(s, p) {
    
  let dp = Array(p.length + 1).fill(null).map(_ => Array(s.length + 1).fill(false));
    
  dp[0][0] = true;
  
  for (let row = 1; row <= p.length; row ++) {
    dp[row][0] = (p[row - 1] === '*' ? dp[row - 1][0] : false); 
  }

  for (let row = 1; row <= p.length; row ++) {
    for (let col = 1; col <= s.length; col ++) {

      if (p[row - 1] === s[col - 1] || p[row - 1] === '?') {
        dp[row][col] = dp[row - 1][col - 1];
      } else if (p[row - 1] === '*') {
        dp[row][col] = dp[row - 1][col - 1] || dp[row - 1][col] || dp[row][col - 1];
      } else {
        dp[row][col] = false;
      }
    }
  }

  return dp[p.length][s.length];
};