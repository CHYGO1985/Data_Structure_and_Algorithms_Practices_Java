/**
 * 
 * 171. Excel Sheet Column Number
 *
 * @author jingjiejiang
 * @history Apr 7, 2021
 * 
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        
        assert columnTitle != null;

        if (columnTitle.length() == 0) return 0;
        
        // build char to integer mapper via using array
        int[] numLetterMap = new int[26];

        for (int idx = 0; idx < numLetterMap.length; idx ++) {
            numLetterMap[idx] = idx + 1;
        }

        int sum = numLetterMap[columnTitle.charAt(0) - 'A'];

        for (int idx = 1; idx < columnTitle.length(); idx ++) {
            
            int val = numLetterMap[columnTitle.charAt(idx) - 'A'];
            sum = sum * 26 + val;
        }

        return sum;
    }
}
