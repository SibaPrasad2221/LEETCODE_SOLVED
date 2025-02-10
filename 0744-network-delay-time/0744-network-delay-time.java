class Solution {
    class Pair{
        int dest;
        int wt;
        Pair(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time: times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        //perform bfs
        Queue<Pair> q = new LinkedList<>();
        dist[k] = 0;
        q.add(new Pair(k, 0));

        while(!q.isEmpty()){
            Pair rnode = q.remove();
            int curr_dest = rnode.dest;
            int curr_wt = rnode.wt;

            for(Pair nbr: adj.get(curr_dest)){
                int adjNode = nbr.dest;
                int t = nbr.wt;
                if (dist[curr_dest] + t < dist[adjNode]) {
                    dist[adjNode] = dist[curr_dest] + t;
                    q.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        int max =0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}