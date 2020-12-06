package level2;

public class CountryOf124 {

    static class Solution {
        public String solution(int n) {
            StringBuilder answer = new StringBuilder();
            int[] index = {4, 1, 2};


            while (n > 0) {
                int remainder = n % 3;
                n = n / 3;
                answer.insert(0, index[remainder]);

                if(remainder == 0) {
                    n -= 1;
                }

            }

            return answer.toString();
        }
    }
}
