import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Question:
 * n: total cities L: number of visits
 * parent (length n - 1): parent[i] connects to i + 1
 * 
 * get the max num of cities can visit.
 * 
 * @author jingjiejiang
 * @history 
 * 1. Sep 9, 2017
 */
public class NetEasePath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int L = sc.nextInt();
		int[] parent = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			parent[i] = sc.nextInt();
		}

		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		visited[0] = true;

		int max = 1;

		for (int i = 0; i < parent.length; i++) {
			if (parent[i] == 0) {
				max = Math.max(max, L - dfs(i + 1, parent, visited, L));
			}
		}

		System.out.println(max);
	}
	
	private static int dfs(int start, int[] parent, boolean[] visited, int L) {
		if (visited[start] == true || L == 0)
			return L;
		visited[start] = true;
		for (int i = 0; i < parent.length; i++) {
			if (parent[i] == start && visited[i + 1] == false) {
				L = dfs(i + 1, parent, visited, L - 1);
				visited[start] = false;
			}
		}
		return L;
	}

}