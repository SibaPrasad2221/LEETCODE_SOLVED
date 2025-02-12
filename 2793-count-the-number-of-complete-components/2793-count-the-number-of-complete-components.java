class Solution {
    public int dfs(List<List<Integer>> graph, int src, boolean[] vis, HashSet<Integer> set) {
        vis[src] = true;
        set.add(graph.get(src).size());
        int ans =1;//for src itself


        for (int nbrs : graph.get(src)) {
            if (!vis[nbrs]) {
                ans += dfs(graph, nbrs, vis, set);
            }
        }
        return ans;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        //dfs
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            //unconnected
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int ans =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){//for no of components
                HashSet<Integer> set = new HashSet<>();
                int count = dfs(graph, i, vis, set);
                if(set.size()==1 && set.contains(count-1)){
                    ans++;
                }
            }
        }

        return ans;
    }
}