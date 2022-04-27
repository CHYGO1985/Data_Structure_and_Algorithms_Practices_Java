package src.String;
/**
 * 
 * 38. Count and Say
 * 
 * @author jingjiejiang
 * @history Aor 27, 2022
 * 
 */
public class CountAndSay {
  public String countAndSay(int n) {

    assert n >= 1;
    String strRes = "1";

    for (int count = 2; count <= n ; count ++) {
      char preDigit = '0';
      int repeatCount = 0;
      StringBuilder strBuilder = new StringBuilder();

      for (int idx = 0; idx < strRes.length(); idx ++) {

        char curDigit = strRes.charAt(idx);

        if (curDigit != preDigit && idx != 0) {
          strBuilder.append(repeatCount).append(preDigit);
          repeatCount = 0;
        }

        repeatCount ++;
        preDigit = curDigit;
      }

      strBuilder.append(repeatCount).append(preDigit);
      strRes = strBuilder.toString();
    }
    return strRes;
  }
}
