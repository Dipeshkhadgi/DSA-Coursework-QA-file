public class VenueDecorationCost {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length; // Number of venues
        int k = costs[0].length; // Number of themes
        
        // Create a dp array to store the minimum cost of decorating each venue with each theme
        int[][] dp = new int[n][k];
        
        // Initialize the dp array with the costs of decorating the first venue
        System.arraycopy(costs[0], 0, dp[0], 0, k);
        
        // Iterate through each venue starting from the second venue
        for (int i = 1; i < n; i++) {
            // Iterate through each theme for the current venue
            for (int j = 0; j < k; j++) {
                // Initialize the minimum cost of decorating the current venue with the current theme
                dp[i][j] = Integer.MAX_VALUE;
                
                // Iterate through each theme for the previous venue
                for (int l = 0; l < k; l++) {
                    // Skip the same theme as the previous venue
                    if (j == l) continue;
                    
                    // Calculate the cost of decorating the current venue with the current theme
                    // and consider the minimum cost of the previous venue
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + costs[i][j]);
                }
            }
        }
        
        // Find the minimum cost of decorating the last venue
        int minCost = Integer.MAX_VALUE;
        for (int cost : dp[n - 1]) {
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 3, 2}, {4, 6, 8}, {3, 1, 5}};
        System.out.println("Minimum cost: " + minCost(costs));
    }
}
