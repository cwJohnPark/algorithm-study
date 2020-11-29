package level2;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        Printer.Solution s = new Printer.Solution();
        int ans1 = s.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(ans1);

        int ans2 = s.solution(new int[]{1, 1, 1, 9, 1, 1, 1}, 0);
        System.out.println(ans2);
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 1;
            Queue<Document> q = getDeque(priorities);

            while(!q.isEmpty()) {
                int max = getMaxPriority(q);
                Document d = q.poll();
                if(d.priority == max) {
                    if(d.location == location) {
                        return answer;
                    }
                    answer++;
                } else {
                    q.add(d);
                }

            }

            return answer;
        }

        private int getMaxPriority(Queue<Document> q) {
            int max = 0;
            for (Document d : q) {
                if (d.priority > max ) {
                    max = d.priority;
                }
            }
            return max;
        }

        private Deque<Document> getDeque(int[] priorities) {
            Deque<Document> q = new ArrayDeque<>();
            for (int i = 0; i < priorities.length; i++) {
                q.add(new Document(priorities[i], i));
            }
            return q;
        }

        class Document {
            int priority;
            int location;
            public Document(int priority, int location) {
                this.priority = priority;
                this.location = location;
            }
        }
    }
}
