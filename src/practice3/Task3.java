package practice3;

import java.util.*;

public class Task3 {
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int[] parent;

    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int budget = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int totalCost = 0;
        int edgesCount = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalCost += edge.w;
                edgesCount++;
                if (edgesCount == n - 1) break;
            }
        }

        if (totalCost <= budget) {
            System.out.println("YES " + totalCost);
        } else {
            System.out.println("NO " + totalCost);
        }
    }
}