import java.util.PriorityQueue;

/**
 * 
 * 378. Kth Smallest Element in a Sorted Matrix
 * 
 * @author jingjiejiang
 * @history Apr 13, 2021
 * 
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        int rowLen = matrix.length;

        PriorityQueue<Tuple> priQueue = new PriorityQueue<>();

        for (int col = 0; col < matrix[0].length; col ++) {
            
            priQueue.offer(new Tuple(0, col, matrix[0][col]));
        }

        for (int count = 0; count < k - 1; count ++) {
            
            Tuple curTuple = priQueue.poll();
            if (curTuple.x >= rowLen - 1) {
                continue;
            }
            priQueue.offer(new Tuple(curTuple.x + 1, curTuple.y, 
                matrix[curTuple.x + 1][curTuple.y]));
        }
            
        return priQueue.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {

    int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
