/**
 * 
 * 38. Count and Say
 * 
 * @history Oct 23, 2022
 * 
 */
/**
 * @param {number} n
 * @return {string}
 */
 var countAndSay = function(n) {
    
  let strRes = '1';

  for (let count = 2; count <= n; count ++) {
    let preDigit = '0';
    let repeatCount = 0;
    let tmpString = '';

    for (let idx = 0; idx < strRes.length; idx ++) {
      if (idx != 0 && strRes[idx] != preDigit) {
        tmpString += repeatCount + preDigit;
        repeatCount = 0;
      }

      repeatCount ++;
      preDigit = strRes[idx];
    }

    tmpString += repeatCount + preDigit;
    strRes = tmpString;
  }

  return strRes;
};