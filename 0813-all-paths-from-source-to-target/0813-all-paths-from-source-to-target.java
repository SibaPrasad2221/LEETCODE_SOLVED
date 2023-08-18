class Solution {
    public void dfs(int[][] graph,boolean[] vis,int src,int dest,List<List<Integer>> res, List<Integer> sub_list){

        sub_list.add(src);

        if(src==dest){
            res.add(new ArrayList(sub_list));
        }
        
        // vis[src]=true;
        // sub_list.add(src);

        for(int nbr:graph[src]){
            // if(!vis[nbr]){}
            dfs(graph,vis,nbr,dest,res,sub_list);
        }

        // vis[src]=false;
        sub_list.remove(sub_list.size()-1);
        // List<Integer> sub_list = new List<>();
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n= graph.length;

        boolean vis[] = new boolean[n];
        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> sub_list= new ArrayList<>();
        
        
        dfs(graph, vis, 0, n-1, res, sub_list);

        return res;


    }
}