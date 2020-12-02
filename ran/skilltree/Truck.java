import java.util.ArrayList;
import java.util.List;

class Solution {
    class Truck {
        int weight;
        int currentPosition;

        public Truck(int weight, int currentPosition) {
            this.weight = weight;
            this.currentPosition = currentPosition;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeTrucksWeight = 0;
        int outTruckCount = 0;

        List<Integer> waitTruckWeights = new ArrayList<>();
        List<Truck> onTrucks = new ArrayList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waitTruckWeights.add(truck_weights[i]);
        }

        while (outTruckCount < truck_weights.length) {
            if (!onTrucks.isEmpty()) {

                int onCandidateTruckWeight = onTrucks.get(0).weight;
                int onCandidateTruckPosition = onTrucks.get(0).currentPosition;

                if (onCandidateTruckPosition == bridge_length) {
                    onTrucks.remove(0);
                    outTruckCount++;
                    bridgeTrucksWeight -= onCandidateTruckWeight;
                }
                for (Truck onTruckWeight : onTrucks) {
                    onTruckWeight.currentPosition++;
                }
            }

            if (!waitTruckWeights.isEmpty()) {
                int inCandidateTruckWeight = waitTruckWeights.get(0);

                if (onTrucks.size() < bridge_length) {
                    if ((inCandidateTruckWeight + bridgeTrucksWeight) <= weight) {
                        bridgeTrucksWeight += inCandidateTruckWeight;

                        onTrucks.add(new Truck(inCandidateTruckWeight, 1));
                        waitTruckWeights.remove(0);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}