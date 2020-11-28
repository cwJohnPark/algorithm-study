package level2;

import java.util.*;

public class DevelopFeatures {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans1 = s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(ans1));

        int[] ans2 = s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(ans2));
    }

    // 다른 사람의 풀이
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    // 나의 풀이
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            return toArray(solutionHelper(Feature.from(progresses, speeds), new LinkedList<>()));
        }

        private int[] toArray(List<Integer> toArray) {
            int[] ans = new int[toArray.size()];
            for (int i = 0; i < toArray.size(); i++) {
                ans[i] = toArray.get(i);
            }
            return ans;
        }

        private List<Integer> solutionHelper(Deque<Feature> features, List<Integer> answer) {
            if (features.isEmpty()) {
                return answer;
            }
            Deque<Feature> completed = Feature.doProgress(features);
            answer.add(Feature.getCount(completed));
            Deque<Feature> reduced = Feature.reduce(completed);

            return solutionHelper(reduced, answer);
        }


    }

    static class Feature {
        int progress;
        int speed;

        public Feature(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public static Deque<Feature> from(int[] progresses, int[] speeds) {
            Deque<Feature> result = new ArrayDeque<>(progresses.length);
            for(int i = 0; i < progresses.length; i++) {
                result.add(new Feature(progresses[i], speeds[i]));
            }
            return result;
        }

        public static Deque<Feature> doProgress(Deque<Feature> features) {

            while( features.getFirst().progress < 100) {
                for(Feature f : features) {
                    f.progress += f.speed;
                }
            }

            return features;
        }

        public static Deque<Feature> reduce(Deque<Feature> features) {
            if(features.isEmpty())
                return features;
            Feature first = features.removeFirst();
            if(first.progress >= 100) {
                return reduce(features);
            } else {
                features.addFirst(first);
                return features;
            }
        }

        public static int getCount(Deque<Feature> reduced) {
            int count = 0;
            for (Feature f : reduced ){
                if(f.progress < 100) {
                    return count;
                } else {
                    count++;
                }
            }
            return count;
        }
    }
}
