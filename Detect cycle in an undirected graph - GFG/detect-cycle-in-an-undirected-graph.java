//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends




class Solution {
    
    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int src){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);

		while(q.size() > 0){
			//step 1: remeove 
			int curr_node = q.remove();

			//step 2: mark
			if(vis[curr_node]==true) return true; //we are visiting someone for second time because it's already marked and we are visiting again to cycle present

			//if above condition no run and we are here so we saw that node for first first node so mark it
			vis[curr_node] = true;

			//step 3: work
			//we don't have any work for this question

			//step 4: add unvisited neightbours
			for(int nbr :  graph.get(curr_node)){
				//only add those nbrs which is not visited
				if(!vis[nbr]){ //or vis[nbr]==false
					q.add(nbr);
				}
			}
		}
		return false;//if at anypoint it doesn't satify line no 14 then cycle not present so return false
	}
	
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        		//using BFS

		//so there is alos a unconnected graph , that means we can't consider one course node so
		boolean [] visited = new boolean[V];
		
		for(int i=0;i<V;i++){
			if(visited[i]) continue; //this means this node/ith node is already visited/or already covered in previous iteration so no need to visit again

			//if not visited before
			boolean isCyclic = BFS(adj, visited, i);

			if(isCyclic) return true;
		}
		return false;
    }
}