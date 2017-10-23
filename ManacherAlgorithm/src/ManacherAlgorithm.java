import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ref: https://www.youtube.com/watch?v=nbTSfrEfo6M
 * Comments: I extend the method which is to find all palindrome substrings of a given string.
 * 1. longest palindrome: return the max in arr[] : 
 * reason, for aaa
 * arr:  # a # a # a #
 * index:1 2 3 4 5 6 7
 * len:  0 1 2 3 2 1 0
 *  for odd: len[3] = 2, means (left 1) + (right 1) = 2
 *  for even: len[4] = 2, mean (left 1) + (centre 1) + (right 1) = 3   
 *  
 * 2. number of palindromes: sum of arr[i]/2
 * arr:  # a # a # a #
 * index:1 2 3 4 5 6 7
 * len:  0 1 2 3 2 1 0 
 * reason: 
 *  for odd: len[3] = 2,  2/2 = 1, means get rid of #, so = a | a
 *  for even: len[4] = 3, 3/2 = 1, means get rid of all #, get a | a | a, so = 1    
 *  
 * arr:  # a # a # a # a #
 * index:1 2 3 4 5 6 7 8 9
 * len:  0 1 2 3 4 3 2 1 0
 * len[4] = 4. 4/4 = 2, means left = 2 and right = 2. so a | a and aa | aa
 *  
 * Leetcode: 647. Palindromic Substrings
 *  
 * @author jingjiejiang
 *
 */
class ManacherAlgorithm {
	
	private static char[] preProcessor (String s) {
		
		char[] arr = new char[s.length() * 2 + 3];
		
		arr[0] = '@';
		int index = 1;
		for (; index < arr.length - 1; index ++) {
			arr[index] = (index % 2 == 0) ? s.charAt(index / 2 - 1) : '#';
			
		}
		arr[index] = '&';
		return arr;
	}
	
	private static int[] buildPalinArray(String s) {
		
		char[] arr = preProcessor(s);
		int[] pal = new int[arr.length]; 
		
		pal[0] = pal[1] = 0;
		
		int center = 0, right = 0, mir = 0;
		for (int i = 1; i < pal.length - 1; i ++) {
			// *** what is mir? the left part of the array (corresponding to i)
			mir = 2 * center - i;
			if (i < right) 
				// *** why use min here?? it might be the case that i + pal[i] > R
				pal[i] = Math.min(pal[mir], right - i);
				//pal[i] = pal[mir];
			
			// *** from i + (i + pal[i]) && i - (pal[i] + 1) : why pal[i] + 1
			// pal[i]: the current palindrome length
			// pal[i] + 1: the next char pos
			// i + pal[i] + 1: the next char pos at right
			// i - (pal[i] + 1): the next char pos at left
			while (arr[i + pal[i] + 1] == arr[i - pal[i] - 1]) pal[i] ++;
			
			if (i + pal[i] > right) {
				// center move to i
				center = i;
				// right boundary = pal[i](palindrome length) + i
				right = i + pal[i];
			}
		}
		
		return pal;
	}
	
	// Manacher's algorithm to get all palindroms substring of a given string
	// for test case: "bccbbbbc"
	// the map will be:  {16=[cbbbbc], 2=[b, bccb], 4=[c, cc], 6=[cc, cbbbbc], 8=[bccb, bb, bbb, bbbb], 10=[bb], 12=[bbb], 14=[bbbb]}
	// it can be seem that "cc" belonds to 4 and 6 
	// the method can be improve to only connect the palindrome to highest number
	private static Map<Integer, List<String>> findAllPalin1(String s, Map<Integer, List<String>> map, Set<String> set) {
		
		char[] arr = preProcessor(s);
		int[] pal = new int[arr.length]; 
		// it is used to keep the temp string corresponding to pal[i], so do not need iterate everytime
		String[] palString = new String[arr.length];
		pal[0] = pal[1] = 0;
		// temp;
		
		int center = 0, right = 0, mir = 0;
		for (int i = 1; i < pal.length - 1; i ++) {
			StringBuilder builder = new StringBuilder();
			
			mir = 2 * center - i;
			if (arr[i] != '#') {
				
				builder.append(arr[i]);
				palString[i] = String.valueOf(arr[i]);
				if (set.add(builder.toString()) == true) {
					List<String> list = map.getOrDefault(i, new LinkedList<String>());
					list.add(builder.toString());
					map.put(i, list);
				}
			}
			
			if (i < right) {
				// *** why use min here?? it might be the case that i + pal[i] > R
				pal[i] = Math.min(pal[mir], right - i);
				if (pal[i] == pal[mir] && palString[mir] != null)  {
					if (builder.length() > 0) builder.deleteCharAt(0);
					builder.append(palString[mir]);
				}
				else if (pal[i] == right - i && palString[mir] != null) {
					int count = 1;
					while ( count <= pal[i] ) { // arr[i - count] != '#' ?? is it
						if (arr[i - count] != '#')
							builder.insert(0, arr[i - count]).append(arr[i + count]);
						count ++;
					}
				}
				if (builder != null) palString[i] = builder.toString();
			}
			
			while (arr[i + pal[i] + 1] == arr[i - pal[i] - 1]) {
				
				if (arr[i + pal[i] + 1] != '#') {
					builder.insert(0, arr[i - pal[i] - 1]).append(arr[i + pal[i] + 1]);
					String tmp = builder.toString();
					if (set.add(tmp) == true) {
						List<String> list = map.getOrDefault(i - pal[i] - 1, new LinkedList<String>());
						list.add(tmp);
						map.put(i - pal[i] - 1 , list);
						list = map.getOrDefault(i + pal[i] + 1, new LinkedList<String>());
						list.add(tmp);
						map.put(i + pal[i] + 1, list);
					}
					palString[i] = tmp;
				}
				pal[i] ++;
			}
			
			if (i + pal[i] > right) {
				center = i;
				right = i + pal[i];
			}
		}
		
		return map;
	}
	
	// Manacher's algorithm to get all palindroms substring of a fiven string and put it in a map with the highest index of a palinfrome
	// for test case: "bccbbbbc"
	// the output of the map is : {16=[cbbbbc], 2=[b], 4=[c], 6=[cc], 8=[bccb], 10=[bb], 12=[bbb], 14=[bbbb]}
	private static Map<Integer, String> findAllPalin2(char[] arr, Map<Integer, String> map, Set<String> set) {
		
		int[] pal = new int[arr.length]; 
		// it is used to keep the temp string corresponding to pal[i], so do not need iterate everytime
		String[] palString = new String[arr.length];
		pal[0] = pal[1] = 0;
		// temp;
		
		int center = 0, right = 0, mir = 0;
		for (int i = 1; i < pal.length - 1; i ++) {
			StringBuilder builder = new StringBuilder();
			
			mir = 2 * center - i;
			if (arr[i] != '#') {
				// add sigle char to map
				builder.append(arr[i]);
				palString[i] = String.valueOf(arr[i]);
				if (set.add(builder.toString()) == true) {
					String list = map.getOrDefault(i, "");
					list = builder.toString();
					map.put(i, list);
				}
			}
			
			if (i < right) {
				// *** why use min here?? it might be the case that i + pal[i] > R
				pal[i] = Math.min(pal[mir], right - i);
				if (pal[i] == pal[mir] && palString[mir] != null)  {
					if (builder.length() > 0) builder.deleteCharAt(0);
					builder.append(palString[mir]);
				}
				else if (pal[i] == right - i && palString[mir] != null) {
					int count = 1;
					while ( count <= pal[i] && i + count < arr.length ) { // arr[i - count] != '#' ?? is it
						if (arr[i - count] != '#')
							builder.insert(0, arr[i - count]).append(arr[i + count]);
						count ++;
					}
				}
				if (builder != null) palString[i] = builder.toString();
			}
			
			while (arr[i + pal[i] + 1] == arr[i - pal[i] - 1]) {
				
				if (arr[i + pal[i] + 1] != '#') {
					builder.insert(0, arr[i - pal[i] - 1]).append(arr[i + pal[i] + 1]);
					String tmp = builder.toString();
					if (set.add(tmp) == true) {
						String list = map.getOrDefault(i + pal[i] + 1, "");
						list = tmp;
						map.put(i + pal[i] + 1, list);
					}
					palString[i] = tmp;
				}
				pal[i] ++;
			}
			
			if (i + pal[i] > right) {
				center = i;
				right = i + pal[i];
			}
		}
		
		return map;
	}
	
	// more clean and neat implementation
	private static Map<Integer, String> findAllPalin3(char[] arr, Map<Integer, String> map, Set<String> set) {
		
		int[] pal = new int[arr.length]; 
		// it is used to keep the temp string corresponding to pal[i], so do not need iterate everytime
		pal[0] = pal[1] = 0;
		// temp;
		
		int center = 0, right = 0, mir = 0;
		for (int i = 1; i < pal.length - 1; i ++) {
			String builder = "";
			
			mir = 2 * center - i;
			if (i % 2 == 0) {
				// add sigle char to map
				builder = String.valueOf(arr[i]);
				if (set.add(builder) == true) {
					//String list = builder.toString();
					map.put(i, builder);
				}
			}
			if (i < right) {
				// *** why use min here?? it might be the case that i + pal[i] > R
				pal[i] = Math.min(pal[mir], right - i);
				char[] copy = Arrays.copyOfRange(arr, i - pal[i], i + pal[i] + 1);
				builder = String.valueOf(removeBoundaries(copy));
				// if (builder != null) palString[i] = builder.toString();
			}
			
			while (arr[i + pal[i] + 1] == arr[i - pal[i] - 1]) {
				
				if ((i + pal[i] + 1) % 2 == 0) {
					builder = arr[i - pal[i] - 1] + builder + arr[i + pal[i] + 1];
					if (set.add(builder) == true) map.put(i + pal[i] + 1, builder);
				}
				pal[i] ++;
			}
			
			if (i + pal[i] > right) {
				center = i;
				right = i + pal[i];
			}
		}
		
		return map;
	}
    private static char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// bccbbbbc, abababa
		int[] res = buildPalinArray("aaa");
		//int[] res = buildPalinArray("aaaa");
	}

}
