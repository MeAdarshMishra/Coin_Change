import java.util.Scanner;
// Coin changing Program
public class Coin_Change {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int amount=sc.nextInt();
        int n=sc.nextInt();
        int[] coin =new int[n];
        for (int i = 0; i < coin.length; i++) {
            coin[i]=sc.nextInt();
        }
        int [][] dp=new int [amount+1][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]=-1;
            }

            
        }
        System.out.println(numberOfWays(coin,amount,0,dp));
       // System.out.println(coin,amount,0);
    }
    public static int numberOfWays(int[] coin,int amount,int i,int [][]dp) {
        if (amount==0){
            return 1;
        }
        if (i==coin.length){
            return 0;
        }
        if (dp[amount][i]!=-1 ){
            return dp[amount][i];
        }
        int include=0;
        int exclude=0;
        if (amount>=coin[i]){
            include=numberOfWays(coin , amount-coin[i],i,dp);
        }
        exclude=numberOfWays(coin, amount, i+1,dp);
        return dp[amount][i]=include+exclude;
    }
}
