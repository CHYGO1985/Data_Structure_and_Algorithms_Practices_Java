package PartitionLabels;

import java.util.LinkedList;
import java.util.List;

// First thought:
// 1) start from the first leter as 0, find its last pos as curEnd
// 2) search from 0 to curEnd, see if any char appear further than curEnd, if
// so curEnd = new char farthest pos
// 3) repeat the process of step 2, start from step previous pos i to curEnd
// ====> disadvantage: multi search through the string

// Optimise:
// use an array with length 25 to indicate the start of each letter and another
// to record the end of each letter 
// use one for loop to get the start and end of each letter
// 1) from pos 0, when meet a new letter, record the pos as its start and end pos
// 2) only update the end pos array

// further optimise:
// start array can be got rid of.
/**
 * 
 * @author jingjiejiang created on Aug 29, 2018
 *
 */
public class PartitionLabels {
	
	public static List<Integer> partitionLabels(String S) {
		List<Integer> res = new LinkedList<Integer>();
		int[] end = new int[26];
		
		for (int index = 0; index < S.length(); index ++) {
			end[S.charAt(index) - 'a'] = index;
		}
		
		int curEnd = 0;
        // here require some time of thinking
		int preEnd = -1;
		for (int index = 0; index < S.length(); index ++) {
			int curLetter = S.charAt(index) - 'a';
			if (end[curLetter] > curEnd) {
				curEnd = end[curLetter];
			};
			if (index == curEnd) {
				res.add(index - preEnd);
				preEnd = index;
			}
		}
		
		return res;
    }

	public static void main(String[] args) {
//		String S = "ababcbacadefegdehijhklij";
		String S = "qvmwtmzzse";
		List<Integer> list = partitionLabels(S);
		for (int index = 0; index < list.size(); index ++) {
			System.out.println(list.get(index));
		}
	}

}
