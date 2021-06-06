import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {

	static long[][] dp = new long[1000][1000];

	public static long solve(long p[], int i, int j){ //solve(1,4)
		if(i == j){
			return 0;
		}
		if(dp[i][j] != -1){
			return dp[i][j];
		}
		dp[i][j] = Long.MAX_VALUE;
		for(int k = i; k < j; k++){
			//solve(1,1) + solve(2, 4) + p[0]*p[1]*p[4] => A(BCD)
			//solve(1,2) + solve(3, 4) + p[0]*p[2]*p[4] => (AB)(CD)//
			//solve(1,3) + solve(4, 4) + p[0]*p[3]*p[4] => (ABC) D
			dp[i][j] = Math.min(dp[i][j], solve(p, i, k) + solve(p, k+1, j) + 
							p[i-1]*p[k]*p[j]
						);
		}
		return dp[i][j];
	}

	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n = 5, matrix = ABCD
		long p[] = new long[n];
		for(int i = 0; i < n; i++){
			p[i] = sc.nextLong();
		}
		for(long[] row: dp){
			Arrays.fill(row, -1);
		}
		System.out.println(solve(p, 1, n-1)); //(1, n-1), solve(1,4)



	}
}
