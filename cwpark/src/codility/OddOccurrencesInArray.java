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
        int unpaired = -1;
        public int solution(int[] A) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < A.length; i++) {
                int num = A[i];
                if(set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
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
