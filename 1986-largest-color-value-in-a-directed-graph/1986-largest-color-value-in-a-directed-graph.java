public class Solution { 
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        int[][] count = new int[n][26];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int visited = 0;
        int res = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            count[node][colorIndex]++; 

            res = Math.max(res, count[node][colorIndex]);

            for(int neighbor : graph.get(node)){
                for (int c = 0; c < 26; c++)
                    count[neighbor][c] = Math.max(count[neighbor][c], count[node][c]);

                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return (visited == n ? res : -1);
    }
}