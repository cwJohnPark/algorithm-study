package etc;

import java.util.LinkedList;
import java.util.List;

public class TreeCutting {
    public static void main(String[] args) {
        TreeCutting.Solution s = new TreeCutting.Solution();

        int ans1 = s.solution(new int[]{3, 4, 5, 3, 7});
        System.out.println(ans1); // 3

        int ans2 = s.solution(new int[]{1, 2, 3, 4});
        System.out.println(ans2); // -1

        int ans3 = s.solution(new int[]{1, 3, 1, 2});
        System.out.println(ans3); // 0

        int ans4 = s.solution(new int[]{1, 3, 1, 2});
        System.out.println(ans4); // 0

        int ans5 = s.solution(new int[]{0, 6, 3, 1000000000});
        System.out.println(ans5); // 0

        int ans6 = s.solution(new int[]{0, 3, 2, 5, 6});
        System.out.println(ans6); // 2

        int ans7 = s.solution(new int[]{0, 1000000000, 0, 1000000000});
        System.out.println(ans7); // 0

        int ans8 = s.solution(new int[]{0, 1000000000, 0, 1000000000});
        System.out.println(ans8); // 0

        int ans9 = s.solution(new int[]{3, 2, 1, 3, 1, 4});
        System.out.println(ans9); // 3

        int ans10 = s.solution(new int[]{3, 4, 4, 5});
        System.out.println(ans10); // -1
    }

    static class Solution {
        public int solution(int[] A) {
            int answer = 0;
            // linked list - 삽입 삭제가 용이해야하므로 링크드 리스트
            List<Integer> list = new LinkedList<>();

            // 링크드리스트 만들기
            for (int i = 0; i < A.length; i++) {
                list.add(A[i]);
            }

            // no removal need 한지 먼저 체크
            boolean noRemovalNeeded = true;
            for (int i = 0; i < list.size() - 2; i++) {
                int t1 = list.get(i);
                int t2 = list.get(i+1);
                int t3 = list.get(i+2);

                // 같은 높이여선 안됨
                if (t1 - t2 == 0 || t3 - t2 == 0) {
                    noRemovalNeeded = false;
                    break;
                }
                if(t2 - t1 > 0) {       // 상승
                    if(t3 - t2 > 0) {  // 상승?
                        noRemovalNeeded = false;
                        break;                      // 해당없으므로 빠져나감
                    }
                } else {                                     // 하강
                    if (t3 - t2 < 0) {// 하강?
                        noRemovalNeeded = false;
                        break; // 해당 없으므로 빠져나감
                    }
                }

            }

            if (noRemovalNeeded) {
                return 0;
            }

            for (int i = 0; i < list.size(); i++) {
                Integer removed = list.remove(i);
                boolean isAesthetical = true;
                for (int j = 0; j < list.size()-2; j++) {
                    int t1 = list.get(j);
                    int t2 = list.get(j+1);
                    int t3 = list.get(j+2);

                    // 같은 높이여선 안됨
                    if (t1 - t2 == 0 || t3 - t2 == 0) {
                        isAesthetical = false;
                        break;
                    }
                    if(t2 - t1 > 0) {       // 상승
                        if(t3 - t2 > 0) {  // 상승?
                            isAesthetical = false;
                            break;                      // 해당없으므로 빠져나감
                        }
                    } else {                                     // 하강
                        if (t3 - t2 < 0) { // 하강?
                            isAesthetical = false;
                            break; // 해당 없으므로 빠져나감
                        }
                    }
                }

                answer += isAesthetical ? 1 : 0;
                list.add(i, removed);
            }

            return answer == 0 ? -1 : answer;
        }
    }
}
