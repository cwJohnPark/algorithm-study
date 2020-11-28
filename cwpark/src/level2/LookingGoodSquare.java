package level2;

public class LookingGoodSquare {
    public static void main(String[] args) {
        Solution s = new Solution();
        long ans1 = s.solution(8, 12);
        System.out.println(ans1);
    }
    public static class Solution {
        public long solution(int w, int h) {
            if (w <= 1 || h <= 1) return 0;
            if (w == h) return w*h - w;

            long answer = 1;
            //swap
            if (w > h) {
                int temp = h;
                h = w;
                w = temp;
            }

            if (w % 2 == 0 ){
                answer = (w * h) - ( ( w * 2 ) + (h + (h % 3) - (w+2)));
            } else {
                answer = (w * h) - ( (w * 2) + ( h - (w + 1)));
            }

            return answer;
        }
    }
}
