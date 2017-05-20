import java.util.Comparator;
import java.util.PriorityQueue;


public class BallsAndBoxes {
	
	/*
	// method 1: error
	public static void BallsAndBoxes(int n, int m, int[] A, int C[], int B[][] ) {
		
		// used the score for each iteration to record the max score
        int score = 0;
        
        // constrains
        if (n < 1 || n > 100 || m < 1 || m > 100) System.out.print(score);
        
        // total avail color;
        int totalBall = 0;
        for (int i : A) {
            if (i < 1 || i > 100) System.out.print(score);
            totalBall += i;
        }
        
        // priority queue in descend order in terms scores
        PriorityQueue<int[]> list = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        
        // initialise priorityqueue
        for (int row = 0; row < n; row ++) // n is color
            for (int col = 0; col < m; col ++) {// m is box
                if (B[row][col] < 0 || B[row][col] > 1000) System.out.print(score);
                list.add(new int[]{B[row][col], row, col});
            }
        
        // recorder for the avail colors in each box 
        // B[x] = 0 means there is avail color but no space ; 
        // B[x] = -n, means there is no avail color, the box cannot be put colors anymore
        boolean[][] availColo = new boolean[m][n];
        
        // the amount of avail colo for each box, if coloBox[x] = -n, means all the colors have been added to the box
        // ???
        int[] coloBox = new int[m];
        
        // iterate throught the priotityqueue to get the max scores 
        // may not use all color, if colors for all box begin to generate negative value
        while (totalBall > 0 && list.size() > 0) {
            int[] fstMax = list.poll();
            // if list does not have scdMax, then it is null
            int[] scdMax = list.peek();
            int curColo = fstMax[1];
            int curBox = fstMax[2];
            
            if (availColo[curBox][curColo] == false && A[curColo] > 0 && coloBox[curBox] > -n) {
                // update availColo, totalBall and coloBox, A[curColo]
                availColo[curBox][curColo] = true;
                // *** each color needs to
                A[curColo] --;
                coloBox[curBox] --;
                totalBall --;
                // check the box capacity, if C[curBox] > 0, add the score, 
                if (C[curBox] > 0) { 
                    score += fstMax[0];
                    C[curBox] --;
                }
                else {
                    // when exceed 2, par 2*2, however, 1 has been paid, so - 2*2 + 1*1
                    int tmp = fstMax[0] - (C[curBox] - 1)*(C[curBox] - 1) + C[curBox] * C[curBox];
                    // if fstMax is the last ele
                    if ( (list.size() == 0 && tmp > 0) || (scdMax != null && tmp > scdMax[0]) ) {
                        score += tmp;
                        C[curBox] --;
                    }
                }
            }
        }
        
        System.out.print(score);
	}
	*/
	
	// method 2: accepted
	public static void BallsAndBoxes (int n, int m, int[] A, int C[], int B[][]) {
		// Write Your Code Here
        // int amount = 0: used the amount for each iteration to record the max score
        // 1. check from every color (iterate)
        // 1) build a priority queue for all cells (int[score, color, boxNum])
        // 2) start from the highest score if colorNum > 0 &&
        // if exceed box capacity && if score - exceedNum ^ 2 > next_Score, use current socre, else contimue to next
        // 3) every box keep a color recorder boolean[n], if it is false, it the color is free, 
        // if == true, then it is used already 
        
        // test case --> need to change the algorithm for comparison
        /*
        2 2
        1 1
        0 0
        1 9
        1 9
        output = 8 (skip the first 9)
        */
        
        // used the score for each iteration to record the max score
		int score = 0;
        // constrains
        if (n < 1 || n > 100 || m < 1 || m > 100) return ;
        for (int box = 0; box < m; box ++)
            if (C[box] < 0 || C[box] > 100) return ;
        
        for (int colo = 0; colo < n; colo ++) {
            
            if (A[colo] < 1 || A[colo] > 100) return ;
            // add the whole row (the whole avail box cells for i's colo
            PriorityQueue<int[]> list = new PriorityQueue<>(new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    return b[0] - a[0];
                }
            });
            
            for (int box = 0; box < m; box ++) {
                if (B[colo][box] < 0 || B[colo][box] > 1000) return ;
                list.add(new int[]{B[colo][box], box});
            }
            
            int coloCount = A[colo];
            while ( coloCount > 0 && list.size() > 0 ) {
                int[] fstMax = list.poll();
                // if list does not have scdMax, then it is null
                int[] scdMax = list.peek();
                int curBox = fstMax[1];
                coloCount --;
                
                if (C[curBox] > 0) { 
                    score += fstMax[0];
                    C[curBox] --;
                }
                else {
                    // when exceed 2, par 2*2, however, 1 has been paid, so - 2*2 + 1*1
                    int fstTmp = fstMax[0] - (C[curBox] - 1)*(C[curBox] - 1) + C[curBox] * C[curBox];
                    // means for current color, there is only neg result
                    if (fstTmp <= 0) break;
                    // *** tmp >= scdMax[0], use >=
                    if ( (list.size() == 0 && fstTmp > 0) 
                    		|| (scdMax != null && fstTmp >= scdMax[0] - (C[scdMax[1]] - 1)*(C[scdMax[1]] - 1) + C[scdMax[1]] * C[scdMax[1]]) ) {
                        score += fstTmp;
                        C[curBox] --;
                    }
                }
            }
        }
        System.out.print(score);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BallsAndBoxes(2, 2, new int[]{1,1}, new int[]{0,0}, new int[][]{{3,9},{6,9}});
	}

}
