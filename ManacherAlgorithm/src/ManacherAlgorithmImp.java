
/**
 * 
 * Manacher Algorithm Implementation
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 23, 2017
 */
public class ManacherAlgorithmImp {
	
	private static char[] preprocess(String str) {
		
		char[] newStr = new char[2 * str.length() + 3];
		
		newStr[0] = '@';
		int index = 1;
		for (; index < newStr.length - 1; index ++)
			newStr[index] = (index % 2 == 0) ? str.charAt(index / 2 - 1) : '#';
			
		newStr[index] = '$';
		
		return newStr;
	}
	
	public static int[] manacher(String str) {
		
		char[] arr = preprocess(str);
				
		int[] lens = new int[arr.length];
		
		int center = 0;
		int right = 0;
		// mirror is needed
		int mirOfRight = 0;
		
		// **** i start from 1, otherwise while will get -1 index detect i - (1 + lens[i]) = -1
		// *** i < arr.length - 1, if < length then, the last mirror will detect i + (1 + lens[i]) = 9
		for (int i = 1; i < arr.length - 1; i ++) {
		
			mirOfRight = 2 * center - i;
			
			if (i < right)
				lens[i] = Math.min(lens[mirOfRight], right - i);
			
			while (arr[i + (1 + lens[i])] == arr[i - (1 + lens[i])]) {
				lens[i] ++;
			}
			
			if (i + lens[i] > right) {
				
				center = i;
				right = i + lens[i];
			}
		}
		
		return lens;
	}

	public static void main(String[] args) {
		
		int[] palinLens = manacher("aaa");
		
		for (int i = 0; i < palinLens.length; i ++)
			System.out.println(palinLens[i]);
	}
}
