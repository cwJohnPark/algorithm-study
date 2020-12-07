package codility;

public class BinaryGap {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(32);
        System.out.println(ans1); // 0
    }
    static class Solution {
        public int solution(int N) {
            int num = N;
            int maxGap = 0;
            int gap = 0;
            boolean firstAppeard = false;
            while (num > 0) {

                if((num & 1) == 1) {
                    if (!firstAppeard) {
                        firstAppeard = true;
                    } else if(maxGap < gap) {
                        maxGap = gap;
                    }
                    gap = 0;
                } else {
                    gap++;
                }

                num = num >> 1;

            }

            return maxGap;
        }
    }

}
