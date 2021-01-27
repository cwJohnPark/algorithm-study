package codility.lesson;

public class CountDiv {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(6, 11, 2);
        System.out.println(ans1); // 3

        int ans2 = s.solution(8, 10, 2);
        System.out.println(ans2); // 2

        int ans3 = s.solution(1, 2_000_000_000, 2_000_000_000);
        System.out.println(ans3); // 1

        int ans4 = s.solution(1, 2_000_000_000, 2);
        System.out.println(ans4); // 1_000_000_000

        // 0은 어느 수로도 나누어 떨어짐
        int ans5 = s.solution(0, 1, 2);
        System.out.println(ans5); // 1

        int ans6 = s.solution(0, 2_000_000_000, 1);
        System.out.println(ans6); // 2_000_000_001
    }

    static class Solution {
        public int solution(int A, int B, int K) {
            return A == 0 ? (B / K) + 1 : (B / K) - ((A-1) / K);
        }
    }
}
