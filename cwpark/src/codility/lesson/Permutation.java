package codility.lesson;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Permutation {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(new int[]{4, 3, 1, 2});
        System.out.println(ans1); // 1
        int ans2 = s.solution(new int[]{4, 3, 1});
        System.out.println(ans2); // 0
        int ans3 = s.solution(new int[]{1});
        System.out.println(ans3); // 1
        int ans4 = s.solution(new int[]{1, 1_000_000_000});
        System.out.println(ans4); // 0
        int ans5 = s.solution(IntStream.range(1_000_000_001-1, 1_000_000_001).toArray());
        System.out.println(ans5); // 0
        int ans6 = s.solution(IntStream.range(1, 100_001).toArray());
        System.out.println(ans6); // 1


    }
    static class Solution {
        public int solution(int[] A) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < A.length; i++) {
                set.add(A[i]);
            }

            for (int i = 1; i <= A.length; i++) {
                if(!set.contains(i)) {
                    return 0;
                }
            }
            return 1;
        }
    }
}
