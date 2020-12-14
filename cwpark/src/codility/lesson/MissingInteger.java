package codility.lesson;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(ans1); // 5
        int ans2 = s.solution(new int[]{1, 2, 3});
        System.out.println(ans2); // 4
        int ans3 = s.solution(new int[]{-1, -2});
        System.out.println(ans3); // 1
        int ans4 = s.solution(new int[]{2});
        System.out.println(ans4); // 1
        int ans5 = s.solution(new int[]{0});
        System.out.println(ans5); // 1

    }
    static class Solution {
        public int solution(int[] A) {
            int max = 0;
            Set<Integer> set = new HashSet<>();

            for(int a : A) {
                // 음수는 정답이 될 수 없음
                if (a < 0)
                    continue;
                if (a > max)
                    max = a;
                set.add(a);
            }

            // 음수밖에 없다면 1을 반환
            if (set.isEmpty()) return 1;

            for (int i = 1; i < max; i++) {
                if(!set.contains(i)) {
                    return i;
                }
            }
            // 배열에 빠짐없이 순서대로 있다면, 최대값+1을 반환
            return max + 1;
        }
    }

}
