import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class RestoreIPAddresses {
	
	 public List<String> restoreIpAddresses(String s) {
        // round 1: solved, 50 minutes for recursive method, 3 hours for implementation (recursive design)
        // 4ms, beat 70%
        // idea: every section 1 -- 4 n
        // 1. condition check : <= 3 && there at at least 4 - n digits
        // 2. if the first digit of the section is 0, than this section is 0, to to next section
        // 3. if arr left length > neccesary length 3*(4 - section), continue (the section will have more digit);
        // 4. if <= 255, add as current section, go to next section
        
        // *** recursive design 
        // 1. for recursive design that need to keep internal status, every new round, 
        // use a new object (for non-primitive) 
        // e.g. the following code use new StringBuilder for builder and resBuilder each recursive call 
        
        // *** test case:
        // "010010"
        List<String> list = new LinkedList<>();
        if (null == s || s.length() < 4) return list;
        
        char[] arr = s.toCharArray();
        getIpAddress(arr, 0, 1, new StringBuilder(), new StringBuilder(), list);
        
        return list;
    }
    
    // *** recursive
    private static void getIpAddress(char[] arr, int begin, int section, StringBuilder builder,
            StringBuilder resBuilder, List<String> list) {
        
        // *** donot put arr[begin] != 0 in first if, otherwise it will not return 
        if (begin < arr.length && section == 4) {
            String temp = String.valueOf(Arrays.copyOfRange(arr, begin, arr.length));
            int num = Integer.valueOf(temp);
            // *** for 4th section, need to check leading 0 (01..) and > 255
            if ( (arr[begin] == '0' && begin < arr.length - 1) || num > 255) return ;
        		list.add(new StringBuilder(resBuilder).append(Arrays.copyOfRange(arr, begin, arr.length)).toString());
            return ;
        }
        int count = 1;
        
        if (begin >= arr.length || section > 4) return ;
        
        // index < arr.length - (4 - section) is to secure there is at least one digit for each section, e.g. 0000
        for (int index = begin; count <= 3 && index < arr.length - (4 - section); index ++, count ++) {
            
            builder.append(arr[index]);
            
            // *** if put checking 0 after checking range, when first = 0 and the left > range, 
            // it will continue with beginning as 0
            if ( (index == begin && arr[index] == '0') ) {
                getIpAddress(arr, index + 1, section + 1, new StringBuilder()
                        , new StringBuilder(resBuilder).append(builder).append("."), list);
                break;
            }
            
            if (arr.length - index - 1 > 3*(4 - section)) continue;
            
            if (Integer.valueOf(builder.toString()) <= 255)
                getIpAddress(arr, index + 1, section + 1, new StringBuilder()
                        , new StringBuilder(resBuilder).append(builder).append("."), list);
            else break;
        }
        
    }
    
    // failed design: for resBuilder, used the old object for each recursive call, so when trackback, the resBuilder will not
    // return to its original status
    /*
    private void getIpAddress(char[] arr, int begin, int section, StringBuilder builder,
            StringBuilder resBuilder, List<String> list) {
        
        if (begin < arr.length && section == 4) {
            list.add(resBuilder.append(Arrays.copyOfRange(arr, begin, arr.length)).toString());
            return ;
        }
        int count = 1;
        
        for (int index = begin; count <= 3 && index < arr.length - (4 - section); index ++, count ++) {
            
            builder.append(arr[index]);
            if (arr.length - index - 1 > 3*(4 - section)) continue;
            
            if ( (index == begin && arr[index] == '0') ) {
                getIpAddress(arr, index + 1, section + 1, new StringBuilder()
                        , resBuilder.append(builder).append("."), list);
                break;
            }
            if (Integer.valueOf(builder.toString()) <= 255)
                getIpAddress(arr, index + 1, section + 1, new StringBuilder()
                        , resBuilder.append(builder).append("."), list);
            else break;
        }
        
        resBuilder.delete(resBuilder.length() - count, resBuilder.length());
    }
    */
	public static void main(String[] args) {
		String s = "10101010";
	}

}
