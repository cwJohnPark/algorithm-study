package codility.lesson;

import java.util.stream.IntStream;

public class PermMissingElem {
    final static int MAX_INTEGER = 100_000;
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(new int[]{2, 3, 1, 5});
        System.out.println(ans1); // 4

        int ans2 = s.solution(IntStream.range(1, MAX_INTEGER+1).toArray());
        System.out.println(ans2); // 100_001
        int ans3 = s.solution(IntStream.range(1, MAX_INTEGER).toArray());
        System.out.println(ans3); // 100_000
    }
    static class Solution {

        public int solution(int[] A) {
            boolean[] buf = new boolean[MAX_INTEGER+2];
            for(int i = 0; i < A.length; i++) {
                buf[A[i]] = true;
            }

            for(int i = 1; i <= MAX_INTEGER+2; i++) {
                if(buf[i] == false) {
                    return i;
                }
            }
            return -1;
        }
    }
}
