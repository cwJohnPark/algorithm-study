import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 프린터
class Solution {
    public int solution(int[] priorities, int location) {
        
        List<Integer> sortedPriorities = new ArrayList<>();
        List<Integer> priorityQueue = new ArrayList<>();
    
        for (int i = 0; i < priorities.length; i++) {
            sortedPriorities.add(priorities[i]);
            priorityQueue.add(priorities[i]);
        }
        sortedPriorities.sort(Comparator.reverseOrder());
        
        int answer = 0;
        int queueIndex = 0;
    
        while (!sortedPriorities.isEmpty()) {
            int queueValue = priorityQueue.get(queueIndex);
            int sortedValue = sortedPriorities.get(0);
            
            if(sortedValue == queueValue) {
                answer++;
                
                if(queueIndex == location) {
                    break;
                }
                sortedPriorities.remove(0);
            }
            queueIndex = (queueIndex + 1) % priorityQueue.size();
        }
        
        return answer;
    }
}