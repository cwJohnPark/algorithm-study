import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int[] remains = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int remainProgress = (100 - progresses[i]);
            remains[i] =  remainProgress / speeds[i];
            
            if (remainProgress % speeds[i] != 0) {
                remains[i] += 1;
            }
        }
        
        int index = 0;
        int count = 1;
        int totalCount = 0;
        int prevValue = remains[0];
        
        for (int i = 1; i < remains.length; i++) {
            if (remains[i] <= prevValue) {
                count++;
            } else {
                answer[index++] = count;
                totalCount += count;
                count = 1;
                prevValue = remains[i];
            }
        }
        
        if(totalCount < progresses.length) {
            answer[index] = progresses.length - totalCount;
        }
        return Arrays.copyOfRange(answer, 0, index+1);
    }
}