package Array;

import java.util.List;

/**
 * 
 * @author jingjiejiang Feb 2, 2019 solved
 *
 */
interface NestedInteger {
	public boolean isInteger();
	public Integer getInteger();
	public List<NestedInteger> getList();
}

public class NestedListWeightSum {

	public int depthSum(List<NestedInteger> nestedList) {
		return calDepthSum(nestedList, 1);
    }
    
    public int calDepthSum(List<NestedInteger> nestedList, int depth) {
    	
    	int sum = 0;
    	
    	for (int idx = 0; idx < nestedList.size(); idx ++) {
    		if (nestedList.get(idx).isInteger()) {
    			sum += nestedList.get(idx).getInteger() * depth;
    		}
    		else {
    			sum += calDepthSum(nestedList.get(idx).getList(), depth + 1);
    		}
    	}
    	
		return sum;
    }
}