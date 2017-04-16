import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class QueueReconsbyHeight {
	
	public int[][] reconstructQueue(int[][] people) {
        // round 1: did not solve it, should draw on paper to test the idea before implementation
        
        // idea: I should tried different sorting when my previous sorting is not working
        // method 1: sort it as (height descending order first, if height equals, num natural ordering)
		// ref: https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution/5
        // [7.0] [7,1] [6,1] [5,0] []
        // [7,0]
        // [7,0] [7,1]
        // [7,0] [6,1] [7,1] (pos of conflict 1: [7,1] shift to next)
        // [5,0] [7,0] [6,1] [7,1] (conflict 0: all shift to next)
        // ...
        
        // things learned:
        // 1) *** I do not mecessarily need to use Collections 
        // 2) *** papameter for new Comparator new Comparator<int[]>(){
        // 3) *** i was confused about the order again compare(a, b) a-b or b-a
        // Compare(a, b): a -b >0 means a >b, put like b, a
        // use  b - a >0 (in reality) (note the parameters' order are still (a , b)) so now is a > b (the result)
        // so put b, a (desending order)
        
        
        if (people.length == 0 || people[0].length == 0) {
            return people;
        }
        
        Arrays.sort(people,new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
