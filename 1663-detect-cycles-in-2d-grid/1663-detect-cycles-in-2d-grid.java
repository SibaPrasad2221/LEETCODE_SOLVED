class Solution {
    boolean status;  // whether contains cycle
    boolean[][] visited; // keeps track of visited cell
    
    public boolean containsCycle(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
				// No need to check further cell if cycle found i.e. status = true.
                if(!status) {
                    if(!visited[i][j]) {
                        dfs(grid, i, j, -1, -1);
                    }
                } else {
                    return status;
                }
            }
        }
        
        return status;
    }
    
	// prow = parent row, pcol = parent col 
    public void dfs(char[][] grid, int row, int col, int prow, int pcol) {
        if(visited[row][col]) {
            status = true;
            return;
        }
        visited[row][col] = true;
		
        // Condition 1: Check whether it is with in range(row and col) or not.
		// Condition 2: Check whether the new range does not belongs to parent row and col.
		// Condition 3: Check whether the new range have the same data value.
		
        if(row > 0 && row-1 != prow && grid[row-1][col] == grid[row][col]) {
            dfs(grid, row-1, col, row, col);
        }
        if(col+1 < grid[0].length && col+1 != pcol && grid[row][col+1] == grid[row][col]) {
            dfs(grid, row, col+1, row, col);
        }
        if(row+1 < grid.length && row+1 != prow && grid[row+1][col] == grid[row][col]) {
            dfs(grid, row+1, col, row, col);
        }
        if(col > 0 && col-1 != pcol && grid[row][col-1] == grid[row][col]) {
            dfs(grid, row, col-1, row, col);
        }
    }
}