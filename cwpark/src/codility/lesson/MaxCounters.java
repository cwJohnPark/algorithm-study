package codility.lesson;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans1 = s.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        System.out.println(Arrays.toString(ans1));
        int[] ans2 = s.solution(4, new int[]{1, 1, 1});
        System.out.println(Arrays.toString(ans2)); // 3, 0, 0, 0
        int[] ans3 = s.solution(3, new int[]{1, 4, 1});
        System.out.println(Arrays.toString(ans3)); // 2, 1, 1
        int[] ans4 = s.solution(3, new int [] {2, 1, 2 });
        System.out.println(Arrays.toString(ans4)); // 1, 2, 0
        int[] ans5 = s.solution(1, new int [] {2, 1, 2 });
        System.out.println(Arrays.toString(ans5)); // 1
        int[] ans6 = s.solution(2, new int [] { 2, 1, 3, 2, 3, 1, 2});
        System.out.println(Arrays.toString(ans6)); // 3, 3


    }

    static class Solution {
        public int[] solution(int N, int[] A) {
            int[] ans = new int[N];
            int max = 0;
            int min = 0;
            for (int i = 0; i < A.length; i++) {
                int num = A[i];

                if (num > N) {
                    min = max;
                    continue;
                }

                // increase
                if (ans[num-1] < min) {
                    ans[num-1] = min+1;
                } else {
                    ans[num-1]++;
                }

                // set max
                if (ans[num-1] > max) {
                    max = ans[num-1];
                }
            }

            for (int i = 0 ; i < N; i++) {
                if(ans[i] < min) {
                    ans[i] = min;
                }
            }

            return ans;
        }
    }

}
