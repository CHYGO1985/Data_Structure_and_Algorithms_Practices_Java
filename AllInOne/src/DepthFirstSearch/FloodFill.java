package DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author jingjiejiang Feb 5, 2019
 *
 */
public class FloodFill {
	
	private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	/*
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		Queue<int[]> nextPoints = new LinkedList<int[]>();
		boolean[][] visitMap = new boolean[image.length][image[0].length];
		
		nextPoints.offer(new int[] {sr, sc});
		bfs(image, nextPoints, visitMap, newColor);
		
        return image;
    }
	
	private static void bfs(int[][] image, Queue<int[]> nextPoints, boolean[][] visitMap
			, int newColor) {
		
		if (nextPoints.size() == 0) return;
		
		int[] nextPoint = nextPoints.poll();
		int curRow = nextPoint[0], curCol = nextPoint[1];
		
		if (visitMap[curRow][curCol] == false) {
			int preColor = image[curRow][curCol];
			image[curRow][curCol] = newColor;
			visitMap[curRow][curCol] = true;
			for (int[] direction : directions) {
				int nextRow = curRow + direction[0], nextCol = curCol + direction[1];
				if (nextRow >= 0 && nextRow < visitMap.length
						&& nextCol >= 0 && nextCol < visitMap[0].length
						&& visitMap[nextRow][nextCol] == false
						&& image[nextRow][nextCol] == preColor) {
					nextPoints.offer(new int[]{nextRow, nextCol});
				}
			}
		}
		
		bfs(image, nextPoints, visitMap, newColor);
	}
	*/
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        
        for (int[] direction : directions) {
        	fill(image, sr + direction[0], sc + direction[1], color, newColor);
        }
    }
	
//	public static void main(String[] args) {
//		int[][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
//		floodFill(image, 1, 1, 2);
//	}
}
