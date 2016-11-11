import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FourSum {

	/*
	   // method 3
	    public List<Integer> add(int i,int j,int k,int m){
	        List<Integer> l = new ArrayList<Integer>();
	        l.add(i);
	        l.add(j);
	        l.add(k);
	        l.add(m);
	        return l;
	    }
	    */
	    
	    // method 2
	     public static List<Integer> add(int[] a,int i,int j,int k,int m){
	        List<Integer> l=new ArrayList<Integer>();
	        l.add(a[i]);
	        l.add(a[j]);
	        l.add(a[k]);
	        l.add(a[m]);
	        return l;
	    }
	    
	    public static int[] sortAndMergeArray(int[] nums, int[] array1, int[] array2) {
		        
	        int[] sum = new int[4];
	        
	        sum[0] = nums[array1[0]];
	        sum[1] = nums[array1[1]];
	        sum[2] = nums[array2[0]];
	        sum[3] = nums[array2[1]];
	        
	        Arrays.sort(sum);
	        
	        return sum;
	    }
	    
	    public static List<List<Integer>> fourSum(int[] nums, int target) {
	        // method 1: brutal force
	        // * idea: combination / permutation --> how to solve it
	        
	        // * things learned : hash table for the 2sum problems. 
	        // I was thinking to split 4sum to 2sum + 2sum, 3*(2sum + 1) + 1 which is one of the solution.
	        // steps:
	        // 1. sort array;
	        // 2. find all the two sums with their indexes stored
	        // 3. two sum methods to find all the matched two sums
	        
	        // leetcode: 7ms solution
	        // https://discuss.leetcode.com/topic/29585/7ms-java-code-win-over-100
	        
	        // method 2: http://blog.csdn.net/taxueguilai1992/article/details/45584533
	        // result: 72ms, beat 68%
	        
	        
	        // method 3: my method: same idea as 2, but with different strategy to compare Map
	        // sort the numbers in the result, eliminate quadratic that has repeat index first, then check all the repeated 
	        // results, runtime: 100ms, beat 14%
	        int[] num = nums;
	        Arrays.sort(num);
	        int len = num.length;
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        Map<Integer,List<int[]>> map = new HashMap<Integer,List<int[]>>();
	        
	        // two loops to build maps of two sums
	        for(int i = 0; i < len - 1; i ++){
	            
	            for(int j = i + 1; j < len; j ++){
	                
	                int[] temp = new int[2];
	                temp[0] = i;
	                temp[1] = j;
	                int sum = num[i]+num[j];
	                if(!map.containsKey(sum)){
	                    List<int[]> list = new ArrayList<int[]>();
	                    list.add(temp);
	                    map.put(sum, list);
	                }
	                else{
	                    List<int[]> list = map.get(sum);
	                    list.add(temp);
	                    map.put(sum, list);
	                }
	            }
	        }
	        
	        for(int i=0;i<len-3;i++){
	            // differnt index may have the same numbers
	            if(i!=0&&num[i]==num[i-1])
	                continue;
	            for(int j=i+1;j<len-2;j++){
	                if(j!=i+1&&num[j]==num[j-1])
	                    continue;
	                int targetMinus=target-num[i]-num[j];
	                //直接从map中寻找是否存在对应的键值
	                if(map.containsKey(targetMinus)){
	                    List<int[]> list=map.get(targetMinus);
	                    boolean flag=false;//记录此次循环是否为第一次添加到结果
	                    for(int p = 0;p < list.size();p ++){
	                        int[]  temp=list.get(p);
	                        //如果小标小于j忽略，这里是为了避免重复// for example, when [x,0,0,y] to void 00, 00,
	                        if(temp[0]<=j)
	                            continue;
	                        // flag = true, 表示之前有添加过数据，将这一次的结果与该循环中上一次添加的结果对比，如果相同
	                        // 则继续下一次循环 (
	                        // 1) if get(2) = num[temp[0]], and since num[i] + num[j] + num[temp[0]] + num[temp[1]] = target,
	                        // if the first three are the same, then temp[1] must be the same as previous, so continue
	                        // 2) according to 1), is makes no dif to comapre temp[1] or temp[0] (I have tested the code)
	                        if(flag&&res.get(res.size()-1).get(3)==num[temp[1]])
	                            continue;
	                        List<Integer> l = add(num, i,j,temp[0],temp[1]);
	                        res.add(l);
	                        flag=true;
	                    }
	                }
	            }
	        }
	        
	        /*
	        
	        for (int key: map.keySet()) {
	            // if there is a match key for current key,then check whether there is repeated index in the correspinding
	            // arrays
	            if (true == map.containsKey(target - key)) {
	                
	                List<int[]> list1 = map.get(key);
	                List<int[]> list2 = map.get(target - key);
	                
	                for (int[] array1: list1) {
	                
	                    for (int[] array2: list2) {
	                        
	                        boolean isValid = true;
	                        int[] indexArr = sortAndMergeArray(num, array1, array2);
	                        
	                        // cal the sum of the four index
	                        int sum = 0;
	                        
	                        if (array1[0] == array2[0] || array1[0] == array2[1]
	                            || array1[1] == array2[0] || array1[1] == array2[1]) {
	                            isValid = false;
	                        }
	                        
	                        // compare two array has same index: 1) bit manipulation, not available, length may exist 32/64
	                        // 2) if use sum of index,it can not tell the dif, e.g. 0,1,4,5 = 1,2,3,4...
	                        if (true == isValid) {
	                            
	                            boolean isRepeat = false;
	                            
	                            for (List<Integer> list: res) {
	                                
	                                if ( (0 == list.get(0) - indexArr[0]) && (0 == list.get(1) - indexArr[1])
	                                    && (0 == list.get(2) - indexArr[2]) && (0 == list.get(3) - indexArr[3]) ) {
	                                    isRepeat = true;
	                                }
	                            }
	                            
	                            if (false == isRepeat) {
	                                    
	                                List<Integer> temp = add (indexArr[0], indexArr[1]
	                                , indexArr[2], indexArr[3]);
	                                res.add(temp);
	                            }
	                                // test
	                               // List<Integer> temp = add (array1[0], array1[1], array2[0], array2[1]);
	                        }
	                    }
	                }
	            }
	        }  
	        
	        */
	        return res;
	    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {-3,-2,-1,0,0,1,2,3};
		 int[] a = {1,0,-1,0,-2,2};
		List<List<Integer>> list = fourSum(a, 0);
		
		int b = 0;
		int c = b;
		
		for (int i = 0; i < 10; i ++) {
			int j = i;
			if (j == 2) {
				break;
			}
			int hh = j;
		}
		/*
		Set<int[]> set = new HashSet<int[]>();
		int[] b = {1,2,3,4};
		int[] c = {1,2,3,4};
		set.add(b);
		System.out.println(set.add(c));
		*/
		/*
		Map<int[], Integer> map = new HashMap<>();
		int[] b = {1,2,3,4};
		int[] c = {1,2,3,4};
        map.put(b, 1);
		map.put(c, 1);
		System.out.print(map.getOrDefault(c, 0));
		*/
	}

}
