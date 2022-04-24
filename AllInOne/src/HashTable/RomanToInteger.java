/**
 * 
 * 13. Roman to Integer
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
public class RomanToInteger {
  public int romanToInt(String s) {
       
    assert s != null && s.length() >= 1 && s.length() <= 15;

    Map<Character, Integer> romanIntMap = new HashMap<>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};

    int sum = 0;

    for (char letter : s.toCharArray()) {
      sum += romanIntMap.get(letter);
    }

    if (s.contains("IV") || s.contains("IX")) sum -= 2;
    if (s.contains("XL") || s.contains("XC")) sum -= 20;
    if (s.contains("CD") || s.contains("CM")) sum -= 200;

    return sum;
  }
}
