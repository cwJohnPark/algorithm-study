package codility.lesson;

public class TapeEquilibrium {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(ans1); // 1
        int ans2 = s.solution(new int[]{-1000, 1000});
        System.out.println(ans2); // 2000
        int ans3 = s.solution(new int[]{-1000, 0, 1000});
        System.out.println(ans3); // 2000
        int ans4 = s.solution(new int[]{-1000, 0});
        System.out.println(ans4); // 1000
    }

    static class Solution {
        public int solution(int[] A) {
            int minDistance = 2000;
            // 순회하여 전체합구함
            int total = 0;
            for (int a : A) {
                total += a;
            }

            int leftSum = 0;
            int rightSum = total;
            for (int i = 0; i < A.length-1; i++) {
                leftSum += A[i];
                rightSum -= A[i];

                int distance = Math.abs(leftSum - rightSum);
                minDistance = minDistance > distance ? distance : minDistance;

            }

            return minDistance;
        }
    }
}
