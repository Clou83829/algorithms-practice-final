package practice3;

import java.util.*;

public class Task2 {
    static class Edge {
        int to;
        long weight;
        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long w = scanner.nextLong();
            adj.get(u).add(new Edge(v, w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, s});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int u = (int) current[1];

            if (d > dist[u]) continue;

            for (Edge edge : adj.get(u)) {
                if (dist[u] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[u] + edge.weight;
                    pq.add(new long[]{dist[edge.to], edge.to});
                }
            }
        }

        if (dist[t] == Long.MAX_VALUE) {
            System.out.println("distance=unreachable");
        } else {
            System.out.println("distance=" + dist[t]);
        }
    }
}