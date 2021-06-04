import java.util.*;

class Main{
    public static void main(String[] args){
      Scanner inp = new Scanner(System.in);
      String x = inp.next();
      String y = inp.next();
      int m = x.length();
      int n = y.length();
      int [][] dp = new int[m+1][n+1];
      int max = 0;
      for (int i=m-1;i>=0;i--){
          for (int j=n-1;j>=0;j--){
              char c1 = x.charAt(i);
              char c2 = y.charAt(j);
              if (c1==c2){
                  dp[i][j] = 1+dp[i+1][j+1];
              }else{
                  dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
              }
              max = Math.max(max,dp[i][j]);
          }
      }
      System.out.println(max);
    }
}
