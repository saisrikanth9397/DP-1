#time complexity-O(m*n) m = coins length+1, n=amount+1
#space complexity - O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] mat = new int[coins.length+1][amount+1];
        for(int i=1;i<mat[0].length;i++){
            mat[0][i] = amount+1;
        }
        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(j<coins[i-1]){
                   mat[i][j] = mat[i-1][j];  
                }else{
                   mat[i][j] = Math.min(mat[i-1][j], 1+mat[i][j - coins[i-1]]);   
                }
            }
        }
        if(mat[coins.length][amount] == amount+1){
            return -1;
        }
        return mat[coins.length][amount];
    }
}
