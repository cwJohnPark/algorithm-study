import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < skill.length(); i++) {
            orderMap.put(skill.charAt(i), i);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            String candidate = skill_trees[i];

            boolean isValid = true;
            int prevIndex = -1;

            for (int j = 0; j < candidate.length(); j++) {

                char key = candidate.charAt(j);
                if (orderMap.containsKey(key)) {
                    if ((orderMap.get(key) - prevIndex) != 1) {
                        isValid = false;
                        break;
                    }
                    prevIndex = orderMap.get(key);
                }
            }
            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}