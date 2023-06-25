package src.DyanmicProgramming;

import java.util.Stack;

public class SumOfScoresOfBuiltStrings {
  private long getSummation(int n) {
        if (n < 0)
            return 0;

        return (long)((long)n * (long)(n + 1)) / 2;
    }
    
    public long maximumBooks(int[] books) {
        int len = books.length;
        long[] dp = new long[len];

        // dp[i] represents max number of books that can be taken
        // between shelf 0 and shelf i (both inclusive)

        // use monotonic stack to populate dp array; for every index i,
        // find the nearest break point j < i such that books[i ~ j] <
        // books[i] - i + j

        // this becomes the restraining point for picking books as now
        // instead of picking (books[i] - i + j) books, we can only pick
        // books[i ~j ] books; so we will pick the maximum dp[j] books +
        // (books[i] + books[i] - 1 + books[i] - 2 + ... + books[i] - (i - j - 1))
        // sum (4 ~8) = sum (8) - sum(3) [3 = booksp[i] - i + j]
        // Deque<Integer> stack = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        long maxBooks = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - i + stack.peek())
                stack.pop();

            // pick dp[j] books and (books[i] + books[i] - 1 + ... + books[i] -
            // (i - j - 1)) books, where j is the current stack top; the latter
            // expression can be rewritten as a difference of two n-summations
            dp[i] = (stack.isEmpty() ? 0 : dp[stack.peek()]) + 
              getSummation(books[i]) - getSummation(books[i] - i + (stack.isEmpty() ? -1 : stack.peek()));

            maxBooks = Math.max(maxBooks, dp[i]);
            stack.push(i);
        }

        return maxBooks;
    }
}
