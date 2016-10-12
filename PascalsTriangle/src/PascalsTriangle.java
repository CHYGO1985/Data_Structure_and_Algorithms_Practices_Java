import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
	
	public static List<List<Integer>> generate(int numRows) {
        // * idea: straight forward method 
        // 1. (A[i], Row) = (A[i - 1], Row - 1) + (A[i], Row - 1);
        // 2. A[0] = 1  and A[Row - 1] = 1
        // do i need to use a map<int, map<int, int>> to store intrim result?
        // *** result: 1ms, fastest solution.
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        int size = (numRows % 2 == 0) ? numRows / 2 : numRows / 2 + 1; 
        int triRow = 1;
        
        while (triRow <= numRows) {
            List<Integer> temp = new ArrayList<Integer>(triRow);
            for (int i = 0; i < triRow; i ++) {
                
                if ( 0 == i || i == triRow - 1) {
                    temp.add(1);
                }
                else {
                    temp.add(result.get(triRow - 2).get(i - 1) + result.get(triRow - 2).get(i));
                }
            }
            
            triRow ++;
            result.add(temp);
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
