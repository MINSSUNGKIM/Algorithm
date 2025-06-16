import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        Arrays.sort(numbers);
        
        // 1. 산술평균
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        int mean = (int) Math.round((double) sum / N);
        
        // 2. 중앙값 (N은 홀수)
        int median = numbers[N / 2];
        
        // 3. 최빈값
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        int maxFreq = Collections.max(freqMap.values());
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }
        Collections.sort(modes);
        
        int mode = modes.size() == 1 ? modes.get(0) : modes.get(1);
        
        // 4. 범위
        int range = numbers[N - 1] - numbers[0];
        
        // 출력
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}