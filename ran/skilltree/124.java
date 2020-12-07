class Solution {
    public String solution(int n) {
        StringBuilder result = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int divider = n;
        int mod;

        while (divider != 0) {
            mod = divider % 3;
            if (mod == 0) {
                result.append('4');
            } else {
                result.append(mod);
            }

            divider = divider / 3;
            if (mod == 0) {
                divider -= 1;
            }
        }

        for (int i = result.length() - 1; i >= 0; i--) {
            answer.append(result.charAt(i));
        }
        return answer.toString();
    }
}