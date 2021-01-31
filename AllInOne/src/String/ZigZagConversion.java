import javax.xml.transform.stax.StAXResult;

/**
 * 
 * 6. ZigZag Conversion
 * 
 * @author jingjiejiang
 * @history Jan 30, 2021
 * 
 * ref: https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        
        assert s != null && s.length() >= 1 && numRows >= 1;

        char[] sChar = s.toCharArray();
        int len = sChar.length;
        StringBuffer[] strBuf = new StringBuffer[numRows];
        for (int idx = 0; idx < strBuf.length; idx ++) strBuf[idx] = new StringBuffer();

        int pos = 0;
        while (pos < len) {

            // vertically down, add to stringbuffer
            for (int idx = 0; idx < numRows && pos < len; idx ++) {
                strBuf[idx].append(sChar[pos ++]);
            }

            // obliquely up
            for (int idx = numRows - 2; idx >= 1 && pos < len; idx --) {
                strBuf[idx].append(sChar[pos ++]);
            }
        }

        for (int idx = 1; idx < strBuf.length; idx ++) {
            strBuf[0].append(strBuf[idx]);
        }

        return strBuf[0].toString();
    }
}