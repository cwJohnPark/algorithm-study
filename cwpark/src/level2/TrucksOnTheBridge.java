package level2;

import java.util.*;

public class TrucksOnTheBridge {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans1 = s.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(ans1); // 8
        int ans2 = s.solution(100, 100, new int[]{10});
        System.out.println(ans2); // 101
        int ans3 = s.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        System.out.println(ans3); // 110
        int ans4 = s.solution(3, 10, new int[]{7, 2, 1});
        System.out.println(ans4); // 6
        int ans5 = s.solution(2, 4, new int[]{1, 2, 1, 2});
        System.out.println(ans5); // 6
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Deque<Truck> trucks = Truck.getStack(truck_weights, bridge_length);
            int popCount = 1;

            while (!trucks.isEmpty()) {
                answer++;
                Truck[] tempTrucks = new Truck[popCount];
                int nextCapacity = 0;

                for (int i = 0; i < popCount; i++) {
                    Truck truck = trucks.pop();
                    tempTrucks[i] = truck;
                    nextCapacity += truck.remaining > 1 ? truck.weight : 0; // 이 부분 중요!!!
                }

                if(!trucks.isEmpty()) {
                    if (weight - nextCapacity >= trucks.getFirst().weight) {
                        popCount++;
                    }
                }

                for(int i = tempTrucks.length - 1; i >= 0; i--) {
                    Truck t = tempTrucks[i];
                    t.remaining--;
                    if (t.remaining != 0) {
                        trucks.push(t);
                    } else {
                        popCount--;
                        popCount = popCount == 0 ? 1 : popCount;
                    }
                }

            }

            return answer+1;
        }
    }

    static class Truck {
        int weight;
        int remaining;

        public Truck(int truck, int bridge_length) {
            this.weight = truck; this.remaining = bridge_length;
        }

        public static Deque<Truck> getStack(int[] truck_weights, int bridge_length) {
            Deque<Truck> trucks = new ArrayDeque<>();
            for (int truck : truck_weights) {
                trucks.add(new Truck(truck, bridge_length));
            }
            return trucks;
        }
    }
}
