package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringCompaction {

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution("aabbaccc");
        System.out.println(ans1); // 7
        int ans2 = s.solution("ababcdcdababcdcd");
        System.out.println(ans2); // 9
        int ans3 = s.solution("abcabcdede");
        System.out.println(ans3); // 8
        int ans4 = s.solution("abcabcabcabcdededededede");
        System.out.println(ans4); // 14
        int ans5 = s.solution("xababcdcdababcdcd");
        System.out.println(ans5); // 17

    }

    static class Solution {
        public int solution(String s) {
            int minCompacted = s.length();

            for (int i = 1; i <= s.length() / 2; i++) {
                List<CompactedString> compactedResult = new ArrayList<>();
                compactedResult.add(new CompactedString(s.substring(0,i), 1));
                int currentIndex = 0;
                for (int j = i; j < s.length(); j+=i) {
                    CompactedString pivotStr = compactedResult.get(currentIndex);

                    if (j+i > s.length()) {
                        compactedResult.add(new CompactedString(s.substring(j), 1));
                        break;
                    }

                    String comparedStr = s.substring(j, j+i);

                    if(pivotStr.str.equals(comparedStr)) {
                        pivotStr.length++;
                    } else {
                        compactedResult.add(new CompactedString(comparedStr, 1));
                        currentIndex++;
                    }
                }
                int compactLength = CompactedString.getLength(compactedResult);
                minCompacted = minCompacted > compactLength ? compactLength : minCompacted;
            }
            return minCompacted;
        }

        static class CompactedString {
            String str;
            int length;
            public CompactedString(String str, int length) {
                this.str = str;
                this.length = length;
            }

            public static int getLength(List<CompactedString> compactedResult) {
                int result = 0;
                for(CompactedString s : compactedResult) {
                    if(s.length != 1) {
                        result += s.str.length() + String.valueOf(s.length).length();
                    } else {
                        result += s.str.length();
                    }
                }
                return result;
            }
        }
    }


}
