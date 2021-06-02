class Main{
    public static void main(String[] args){
        int [] arr = new int[9];
        arr[1] = 1;
        System.out.println(dp(arr,9));
    }
    
    public static int dp(int arr[], int num){
        if (num==1){
            return 0;
        }else if (arr[num-1]!=0){
            return arr[num-1];
        }
        int res = dp(arr,num-1)+dp(arr,num-2);
        arr[num-1] = res;
        return res;
    }
}



/////Bottom up (Tabulation)
/*
public static int fibonacciBottomUpDp(int n, int dp[]){
		
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
*/
