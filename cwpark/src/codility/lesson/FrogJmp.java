package codility.lesson;

public class FrogJmp {
    static class Solution {
        public static void main(String[] args) {
            Solution s = new Solution();
            int ans1 = s.solution(10, 85, 30);
            System.out.println(ans1); // 3
            int ans2 = s.solution(1, 2, 1);
            System.out.println(ans2); // 1
            int ans3 = s.solution(1, 2, 2);
            System.out.println(ans3); // 1

        }
        public int solution(int X, int Y, int D) {
            return (Y-X) % D == 0 ? (Y-X) / D : (Y-X) / D + 1;
        }
    }
}
