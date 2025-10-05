class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int length, width;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
        
        length = heights.length;
        width = heights[0].length;

        boolean[][] isVisitedPacific = new boolean[length][width];
        boolean[][] isVisitedAtlantic = new boolean[length][width];

        for (int i = 0; i < width; i++) {
            dfs(0, i, isVisitedPacific, heights);
            dfs(length - 1, i, isVisitedAtlantic, heights);
        }

        for (int j = 0; j < length; j++) {
            dfs(j, 0, isVisitedPacific, heights);
            dfs(j, width - 1, isVisitedAtlantic, heights);
        }

        for (int r = 0; r < length; r++) {
            for (int j = 0; j < width; j++) {
                if (isVisitedPacific[r][j] && isVisitedAtlantic[r][j]) {
                    result.add(Arrays.asList(r, j));
                }
            }
        }

        return result;
    }

    private void dfs(int len, int wid, boolean[][] visited, int[][] height) {
        if (visited[len][wid]) return;
        visited[len][wid] = true;

        for (int[] d : DIRECTIONS) {
            int addLen = len + d[0];
            int addWid = wid + d[1];

            if (addLen < 0 || addLen >= length || addWid < 0 || addWid >= width) continue;
            if (!visited[addLen][addWid] && height[addLen][addWid] >= height[len][wid]) {
                dfs(addLen, addWid, visited, height);
            }
        }
    }
}