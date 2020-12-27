// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        //boolean[] check = new boolean[A.length+1];
        Set<Integer> check = new HashSet<>();

        for(int i=0; i< A.length; i++) {
            if (check.contains(A[i])) {
                return 0;
            } 
            else if(A[i] > A.length) {
                return 0;
            }
            else if(!check.contains(A[i])){
                //check[A[i]] = true;
                check.add(A[i]);
            } 
        }
        return 1;
    }
}