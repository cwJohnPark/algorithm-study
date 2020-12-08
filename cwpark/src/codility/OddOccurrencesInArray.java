package codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        final int MAX_NUM = 1_000_000_000;
        Solution s = new Solution();
        int ans1 = s.solution(new int[] {9, 3, 9, 3, 9, 7, 9});
        System.out.println(ans1); // 7
        int ans2 = s.solution(new int[] {MAX_NUM, 3, MAX_NUM, 3, 9, 7, 9});
        System.out.println(ans2); // 7
    }

    static class Solution {

        public int solution(int[] A) {
            int unpaired = -1;
            int buf = 0;
            for(int i = 0; i < A.length; i++) {
                if((buf & A[i]) > 0) {

                }
            }

            for(int num : set) {
                unpaired = num;
                break;
            }

            return unpaired;
        }
    }

}
