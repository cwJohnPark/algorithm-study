package etc;

public class AscendingNumber {
    public static void main(String[] args) {
        AscendingNumber.Solution s = new AscendingNumber.Solution();
        boolean ans1 = s.solution(new int[]{1, 2, 3, 4, 5, 6}, 6);
        System.out.println(ans1); // true

        boolean ans2 = s.solution(new int[]{1, 2, 3, 4, 5, 6}, 7);
        System.out.println(ans2); // false

        boolean ans3 = s.solution(new int[]{1, 1, 3}, 2);
        System.out.println(ans3); // false

        boolean ans4 = s.solution(new int[]{1, 1, 3}, 3);
        System.out.println(ans4); // false

        boolean ans5 = s.solution(new int[]{1, 2, 3}, 3);
        System.out.println(ans5); // true



    }
    static class Solution {
        public boolean solution(int[] A, int K) {
            int n = A.length;
            for (int i = 0; i < n - 1; i++) {
                //if (A[i] + 1 < A[i + 1]) {
                if (A[i] + 1 != A[i + 1] ) {
                    return false;
                }
            }

            //if (A[0] != 1 && A[n-1] != K)
            if (A[0] != 1 || A[n-1] != K)
                return false;
            else
                return true;
        }
    }
}
