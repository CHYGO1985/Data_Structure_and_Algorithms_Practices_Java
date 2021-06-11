/**
 *
 * 149. Max Points on a Line
 * 
 * @author jingjiejiang
 * @history Apr 2, 2021
 * Jun 11, 2021
 * 
 */
class Solution {

    // cannot use float key = Math.abs((float) difY / difX) as key
    // e.g. [[0,0],[1,-1],[1,1]]
    public int maxPoints(int[][] points) {
        
        if (points == null) return 0;

        int res = 0;

        for (int leftIdx = 0; leftIdx < points.length; leftIdx ++) {

            Map<Integer, Integer> map = new HashMap<>();
            int dup = 0;
            int max = 0;

            // skip when points.length - 1 - leftIdx + 1 <= res
            if (points.length - leftIdx <= res) break;

            for (int rightIdx = leftIdx + 1; rightIdx < points.length; rightIdx ++) {

                int difX = points[rightIdx][0] - points[leftIdx][0];
                int difY = points[rightIdx][1] - points[leftIdx][1];

                if (difX == 0 && difY == 0) {
                    dup ++;
                    continue;
                }

                int gcd = getGDC(difX, difY);
                difX = difX / gcd;
                difY = difY / gcd;
                
                String key = difX + "" + difY;

                int count = map.getOrDefault(key, 0) + 1;
                max = Math.max(max, count);
                map.put(key, count);
            }

            res = Math.max(res, max + dup + 1);
        }

        return res;
    }

    private int getGDC(int a, int b) {

        if (b == 0) return a;
        return getGDC(b, a % b);
    }
}
