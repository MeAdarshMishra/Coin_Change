import java.util.Scanner;

public class Coin_Change {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int amount=sc.nextInt();
        int n=sc.nextInt();
        int[] coin =new int[n];
        for (int i = 0; i < coin.length; i++) {
            coin[i]=sc.nextInt();
        }
        System.out.println(numberOfWays(coin,amount,0));
       // System.out.println(coin,amount,0);
    }
    public static int numberOfWays(int[] coin,int amount,int i) {
        if (amount==0){
            return 1;
        }
        if (i==coin.length){
            return 0;
        }
        int include=0;
        int exclude=0;
        if (amount>=coin[i]){
            include=numberOfWays(coin , amount-coin[i],i);
        }
        exclude=numberOfWays(coin, amount, i+1);
        return include+exclude;
    }
}
