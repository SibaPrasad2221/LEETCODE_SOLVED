class Solution {
    public boolean dfs(List<List<Integer>> graph, int src, int dest, boolean vis[]) {
        if (src == dest)
            return true;// stop dfs when src reach dest

        vis[src] = true;

        for (int nbr : graph.get(src)) {
            if (!vis[nbr]) {
                if (dfs(graph, nbr, dest, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        int ans[] = new int[2]; // as to store only last occurs finding
        for (int i = 0; i < n; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;

            boolean[] vis = new boolean[n];

            if (dfs(graph, u, v, vis)) {
                ans[0] = u+1;
                ans[1] = v+1;
                return ans;

            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];

    }
}