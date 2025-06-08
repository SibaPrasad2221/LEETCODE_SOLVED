class Solution {
    private int area=0;

    public void dfs(int[][] grid,int r,int c)
    {
        int row=grid.length,col=grid[0].length;

        if(r<0||c<0||r>=row||c>=col||grid[r][c]==0) return;
        if(grid[r][c]==1) area++;

        grid[r][c]=0;

        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);

    }

    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length,col=grid[0].length,maxarea=0;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(grid,i,j);
                    if(area>maxarea) maxarea=area;
                    area=0;
                }
            }
        }

        return maxarea;
    }
}