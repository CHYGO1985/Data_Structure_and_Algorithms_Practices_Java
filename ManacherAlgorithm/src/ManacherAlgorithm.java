
//ref: https://www.youtube.com/watch?v=nbTSfrEfo6M

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
			mir = 2 * center - i;
			if (i < right) 
				// *** why use min here?? it might be the case that i + pal[i] > R
				pal[i] = Math.min(pal[mir], right - i);
				//pal[i] = pal[mir];
			
			while (arr[i + pal[i] + 1] == arr[i - pal[i] - 1]) pal[i] ++;
			
			if (i + pal[i] > right) {
				center = i;
				right = i + pal[i];
			}
		}
		
		return pal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = buildPalinArray("abababa");

	}

}
