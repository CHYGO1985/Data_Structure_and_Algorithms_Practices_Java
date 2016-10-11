
class RectangleArea {
	
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // *** 1st round: I misunderstood the question "Find the total area covered by two rectilinear rectangles in a 2D plane." not the intersected area.
        
        // *** I couldn't find the general solution for finding whether there is intersect area, coz I didn't bother to
        // draw draft to observe the laws, which wasted many time.
        
        // * reach to the solution: draw examples (difficult part: think about different typical cases) --> find laws --> coding (write down main steps as comments --> coding)
        // 1. draw four dif cases that A is covered by B in four dif directions: bot-left, bot-right, top-leff, top-right
        // 2. find the laws: the covered area: 
        // 1) for bottom-left, get higher x and y
        // 2) for top-right, get lower x and y
        
        /*
        int intersect = 0;
        
        // areaA + areaB - intersection = total area.
        
        // check whether there is intersection between the two
        if ( ( (E >= A && E <= C) && F <= D ) 
            || ( (A >= E && A <= G) && B <= H ) ) {
            
            // find higher x and y for bot-left (A,B and E,F)
            int botLX = Math.max(A, E);
            int botLY = Math.max(B, F);
            
            // find lower x and y for top right (C,D and G,H)
            int topRX = Math.min(C, G);
            int topRY = Math.min(D, H);
            
            // cal the area
            // length = top.x - bot.x
            // wide = top.y - bot.y;
            intersect = calArea(botLX, botLY, topRX, topRY);
        }
        
        int area1 = calArea(A, B, C, D);
        int area2 = calArea(E, F, G, H);
        
        return area1 + area2 - intersect;
        */
        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);
        
        return areaOfSqrA + areaOfSqrB - overlap;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int area = computeArea(-2, -2, 2, 2, 1, -3, 3, -1); 
		// int area = computeArea(-2, -2, 2, 2, -4, 3, -3, 4); 
		int area = computeArea(-5, 4, 0, 5, -3, -3, 3, 3); 
	}

}
