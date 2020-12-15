// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i< A.length; i++) {
            set.add(A[i]);
            max = Math.max(max, A[i]);
        }

        for(int i=1; ; i++) {
            if(!set.contains(i)) {
                result = i;
                break;
            }
        }
        return result;
        // write your code in Java SE 8
    }
}