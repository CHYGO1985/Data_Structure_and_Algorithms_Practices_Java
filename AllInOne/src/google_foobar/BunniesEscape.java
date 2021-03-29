import java.util.PriorityQueue;

/**
 * 
 * @author jingjiejiang
 * @history MAr 29, 20221
 */
public class BunniesEscape {

    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static class State implements Comparable<State> {

        int[] coord;
        int steps;
        boolean isThroughWall;

        public State(int[] coord, int steps, boolean isThroughWall) {

            this.coord = coord;
            this.steps = steps;
            this.isThroughWall = isThroughWall;
        }

        public int compareTo(State state) {
            return steps - state.steps;
        }
    }

    public static int solution(int[][] map) {
        // Your code here
        int minSteps = Integer.MAX_VALUE;
        PriorityQueue<State> statePriQueue = new PriorityQueue<>();
        // visted[2][0] : through a wal, visited[2][1] : not through a wall
        boolean[][][] visited = new boolean[map.length][map[0].length][2];

        statePriQueue.offer(new State(new int[]{0, 0}, 1, false));

        while (!statePriQueue.isEmpty()) {

            State curState = statePriQueue.poll();
            if (curState.coord[0] == map.length - 1 
                && curState.coord[1] == map[0].length - 1) {
                    minSteps = Math.min(minSteps, curState.steps);
                    continue;
                }

            if (visited[curState.coord[0]][curState.coord[1]][curState.isThroughWall ? 0 : 1]) {
                continue;
            }

            visited[curState.coord[0]][curState.coord[1]][curState.isThroughWall ? 0 : 1] = true;
            for (int idx = 0; idx < dirs.length; idx ++) {
                
                int nextX = curState.coord[0] + dirs[idx][0];
                int nextY = curState.coord[1] + dirs[idx][1];

                if (nextX < 0 || nextX >= map.length 
                 || nextY < 0 || nextY >= map[0].length
                 || (map[nextX][nextY] == 1 && curState.isThroughWall)) {
                     continue;
                 } 

                 if (map[nextX][nextY] == 1) {
                    statePriQueue.offer(new State(new int[]{nextX, nextY}, 
                        curState.steps + 1, true));
                 } else {
                    statePriQueue.offer(new State(new int[]{nextX, nextY},
                        curState.steps + 1, curState.isThroughWall));
                 }
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

    public static void main(String[] args) {
        // int a = solution(new int[]{13, 5, 6, 2, 5}, new int[]{5, 2, 5, 13});
  
        int [][] test = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        System.out.println(BunniesEscape.solution(test));
    }
}