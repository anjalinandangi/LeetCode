class Solution {

    public static void solve(int i, int j, int n, int m,int[][] grid, boolean[][] visited, int[] area) {

        visited[i][j] = true;
        area[0]++;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1 && visited[nx][ny]== false) {

                solve(nx, ny, n, m, grid, visited, area);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && visited[i][j]== false) {

                    int[] area = new int[1];

                    solve(i, j, n, m, grid, visited, area);

                    max = Math.max(max, area[0]);
                }
            }
        }

        return max;
    }
}