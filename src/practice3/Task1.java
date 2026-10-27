package practice3;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        String mode = scanner.next();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
        }

        for (List<Integer> list : adj) Collections.sort(list);

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        
        StringBuilder order = new StringBuilder();
        int edgesChecked = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.append(u).append(" ");
            
            for (int v : adj.get(u)) {
                edgesChecked++;
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }
        
        System.out.println("order= " + order.toString().trim() + " parent= " + Arrays.toString(parent).replace("[", "").replace("]", "").replace(",", ""));
    }
}