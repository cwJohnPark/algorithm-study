package level2;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] answer1 = s.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(answer1));
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length-1; i++) {
                for (int j = i+1; j < prices.length; j++) {
                    if (prices[i] > prices[j]) {
                        answer[i]++;
                        break;
                    } else {
                        answer[i]++;
                    }
                }
            }

            return answer;
        }

    }

}

