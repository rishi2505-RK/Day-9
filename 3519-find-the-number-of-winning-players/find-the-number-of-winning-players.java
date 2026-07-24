class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] count = new int[n][11];

        for (int[] p : pick) {
            count[p[0]][p[1]]++;
        }

        int ans = 0;

        for (int player = 0; player < n; player++) {
            for (int color = 0; color <= 10; color++) {
                if (count[player][color] > player) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}