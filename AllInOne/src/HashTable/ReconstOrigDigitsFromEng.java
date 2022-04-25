/**
 * 
 * 423. Reconstruct Original Digits from English
 * 
 * @author jingjiejiang
 * @history Apr 25, 2022
 * 
 */
public class ReconstOrigDigitsFromEng {
  public String originalDigits(String s) {

    assert s != null && s.length() >= 1;

    int[] numCounts = new int[26];
    
    for (char letter : s.toCharArray()) {
      numCounts[letter - 'a'] += 1;
    }

    int[] nums = new int[10];
    /// letter "z" is present only in "zero"
    nums[0] = numCounts['z' - 'a'];
    // letter "w" is present only in "two"
    nums[2] = numCounts['w' - 'a'];
    // letter "u" is present only in "four"
    nums[4] = numCounts['u' - 'a'];
    // letter "x" is present only in "six"
    nums[6] = numCounts['x' - 'a'];
    // letter "g" is present only in "eight"
    nums[8] = numCounts['g' - 'a'];
    // letter "h" is present only in "three" and "eight"
    nums[3] = numCounts['h'- 'a'] - nums[8];
    // letter "f" is present only in "five" and "four"
    nums[5] = numCounts['f'- 'a'] - nums[4];
    // letter "s" is present only in "seven" and "six"
    nums[7] = numCounts['s'- 'a'] - nums[6];
    // letter "i" is present in "nine", "five", "six", and "eight"
    nums[9] = numCounts['i' - 'a'] - nums[5] - nums[6] - nums[8];
    // letter "n" is present in "one", "nine", and "seven"
    nums[1] = numCounts['n' - 'a'] - nums[7] - 2 * nums[9];

    StringBuilder output = new StringBuilder();
    for (int num = 0; num < 10; num ++)
      for (int cnt = 0; cnt < nums[num]; cnt ++)
        output.append(num);

    return output.toString();
  }
}
