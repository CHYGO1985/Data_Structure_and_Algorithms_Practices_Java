/**
 * 
 * 76. Minimum Window Substring
 * 
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    
  const charCntInTMap = new Map();
  for (const char of t) {
    charCntInTMap.set(char, (charCntInTMap.get(char) || 0) + 1);
  }

  const uniCharInT = charCntInTMap.size;
  let left = 0, charMatch = 0;
  let min = Infinity;
  let head, tail;
  const curWinCharCntMap = new Map();

  for (let right = 0; right < s.length; right ++) {
    const char = s[right];
    curWinCharCntMap.set(char, (curWinCharCntMap.get(char) || 0) + 1);

    if (charCntInTMap.has(char) && curWinCharCntMap.get(char) === charCntInTMap.get(char)) {
      charMatch ++;
    }

    // must use <=, in case for "a" and "a"
    while (left <= right && charMatch === uniCharInT) {
      let charInWin = s[left];

      if (min === Infinity || right - left + 1 < min) {
        min = right - left + 1;
        tail = right;
        head = left;
      }

      curWinCharCntMap.set(charInWin, (curWinCharCntMap.get(charInWin) || 0) - 1);

      if (charCntInTMap.has(charInWin) && (curWinCharCntMap.get(charInWin) < charCntInTMap.get(charInWin))) {
        charMatch --;
      }

      left ++;
    }
  }

  return s.slice(head, tail + 1);
};