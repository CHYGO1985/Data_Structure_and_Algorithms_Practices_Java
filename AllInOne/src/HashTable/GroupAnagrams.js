/**
 * 
 * 49. Group Anagrams
 * 
 */
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
 var groupAnagrams = function(strs) {
    
  let result = {};

  for (let str of strs) {
    const key = new Array(26).fill(0);
    for (let char of str) {
      key[char.charCodeAt(0) - 97] += 1;
    }

    if (!result[key]) result[key] = [];
    result[key].push(str);
  }

  return Object.values(result);
};
