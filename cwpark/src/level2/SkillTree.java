package level2;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(answer);
        int answer2 = s.solution("CBD", new String[]{"AAAB", "CBADF", "AECB", "BDA"});
        System.out.println(answer2);
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }

        for (String tree : skill_trees) {
            int lastIndex = -1;
            answer++;
            int skillStep = -1;
            for (int i = 0; i < tree.length(); i++) {
                Integer mapIndex = map.get(tree.charAt(i));

                if (mapIndex == null)
                    continue;

                if (lastIndex > mapIndex || skillStep+1 != mapIndex) {
                    answer--;
                    break;
                }
                skillStep++;
                lastIndex = mapIndex;
            }
        }
        return answer;
    }
}

// map 없이 푸는 방법
class SolutionAnother {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        for (String skillTree : skill_trees) {
            int learningIdx = 0;

            boolean isAble = true;

            for (char curSkill : skillTree.toCharArray()) {

                int skillIdx = skill.indexOf(curSkill);

                if (skillIdx == -1)
                    continue;
                else if (skillIdx == learningIdx)
                    learningIdx++;
                else {
                    isAble = false;
                    break;
                }
            }

            if (isAble)
                answer++;
        }

        return answer;
    }
}