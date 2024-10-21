import java.io.*;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel other) {
        if (this.weight != other.weight) {
            return Integer.compare(this.weight, other.weight);
        }
        return Integer.compare(other.price, this.price);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewels);
        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int jewelIdx = 0;

        for (int bag : bags) {
            while (jewelIdx < N && jewels.get(jewelIdx).weight <= bag) {
                pq.offer(jewels.get(jewelIdx).price);
                jewelIdx++;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}