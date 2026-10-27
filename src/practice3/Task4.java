package practice3;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<List<Integer>> layers = new ArrayList<>();
        int processedNodes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLayer = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                currentLayer.add(u);
                processedNodes++;
                
                for (int v : adj.get(u)) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
            Collections.sort(currentLayer);
            layers.add(currentLayer);
        }

        if (processedNodes != n) {
            System.out.println("CYCLE");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < layers.size(); i++) {
                for (int j = 0; j < layers.get(i).size(); j++) {
                    result.append(layers.get(i).get(j));
                    if (j < layers.get(i).size() - 1) result.append(" ");
                }
                if (i < layers.size() - 1) result.append(" | ");
            }
            System.out.println("layers: " + result.toString());
        }
    }
}