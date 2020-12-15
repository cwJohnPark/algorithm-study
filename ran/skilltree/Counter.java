// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int max = 0;
        int maxmax = 0;

        for(int K=0; K< A.length; K++) {
            int X = A[K];
            if(X >= 1 && X <= N) {
                if(result[X-1] < maxmax) {
                    result[X-1] += maxmax;                    
                }
                result[X-1] = result[X-1] + 1;
                max = Math.max(max, result[X-1]);
            }
            else if(X == (N+1)) {
                maxmax = Math.max(maxmax, max);
            }
        }

        for(int i=0; i< result.length; i++) {
            if(result[i] < maxmax) {
                result[i] = maxmax;
            }
        }
        return result;
    }
}