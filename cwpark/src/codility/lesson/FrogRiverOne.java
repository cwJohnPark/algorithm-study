package codility.lesson;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrogRiverOne {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(ans1); // 6

        int ans2 = s.solution(5, new int[]{5, 4, 3, 2, 1});
        System.out.println(ans2); // 4

        int ans3 = s.solution(1, new int[]{1});
        System.out.println(ans3); // 0

        int ans4 = s.solution(2, new int[]{1});
        System.out.println(ans4); // -1

    }

    static class Solution {
        public int solution(int X, int[] A) {
            Set<Integer> set = IntStream.range(1, X + 1).boxed().collect(Collectors.toSet());

            for (int i = 0; i < A.length; i++) {
                set.remove(A[i]);

                if(set.isEmpty())
                    return i;
            }

            return -1;
        }
    }

}
