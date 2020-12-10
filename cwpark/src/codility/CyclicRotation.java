package codility;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans1 = s.solution(new int[]{3, 8, 9, 7, 6}, 3);
        System.out.println(Arrays.toString(ans1)); // 7,6,3,8,9
        int[] ans2 = s.solution(new int[]{0, 0, 0, 0}, 1);
        System.out.println(Arrays.toString(ans2)); // 0,0,0,0
        int[] ans3 = s.solution(new int[]{1, 2, 3, 4}, 4);
        System.out.println(Arrays.toString(ans3)); // 1,2,3,4


    }

    static class Solution {
        public int[] solution(int[] A, int K) {
            if(A == null || A.length == 0) {
                return new int[]{};
            }

            int start = A.length - (K % A.length);
            int[] result = new int[A.length];

            // copy array from start to Length-1
            for (int i = 0; i < A.length - start; i++) {
                result[i] = A[i + start];
            }

            // copy array from 0 to start-1
            for (int j = A.length - start, k = 0; j < A.length; j++) {
                result[j] = A[k++];
            }

            return result;
        }
    }
}
