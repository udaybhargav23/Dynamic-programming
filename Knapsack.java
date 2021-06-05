import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed

/*

value[]= {120,100,80}
weight[]= {40,30,20}, W = 50
Greedy approach: pick the most valuable item till I reach capacity
120, 40, 50-40 = 10, solution = 120
100+80 = 180, weight = 50

Profit	24	18	18	10
Weight	24	10	10	7
W = 25
You choose 24 only greedy

Profit	100	280	120
Weight	10	40	20
Ratio	  10	7	  6 // p / w
W = 60
You choose 100 + 280, 120 + 280 is the answer

If we have n items, the theif can either choose an item or reject an item
If we iterate over all possibilities we will get our answer

Total number of possibilities: 2^n

wt[] = {1, 1, 1}, W = 2, val[] = {10, 20, 30}
                       K(n, W)
                       K(3, 2)  
                   /            \ 
                 /                \               
            K(2, 2)                  K(2, 1)
          /       \                  /    \ 
        /           \              /        \
       K(1, 2)      K(1, 1)        K(1, 1)     K(1, 0)
       /  \         /   \              /        \
     /      \     /       \          /            \
K(0, 2)  K(0, 1)  K(0, 1)  K(0, 0)  K(0, 1)   K(0, 0)
Recursion tree for Knapsack capacity 2 
units and 3 items of 1 unit weight.

if j >= wt[i-1]
  K(3, 2) = max(K(2,2), K(2, 1) + 30)
  K(i, j) = max(K(i-1, j), K(i-1, j-wt[i-1]) + val[i-1])
else
  K(i, j) = K(i-1, j)

 K[n+1][W+1]

	0	 1	2  //capacity, max(K(1,2), K(1, 1) + 20)
0 0	 0	0

1	0 10 10  

2	0	20 30

3	0	30 50	
//items
*/
class Main {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
          int n = sc.nextInt();
          int capacity = sc.nextInt();
          int value[] = new int[n];
          int weight[] = new int[n];
          for(int i = 0; i < n; i++){
            value[i] = sc.nextInt();
          }
          for(int i = 0; i < n; i++){
            weight[i] = sc.nextInt();
          }

          int dp[]                     [] = new int[n+1][capacity+1];
          for(int i = 1; i <= n; i++){
            for(int j = 1; j <= capacity; j++){
                if(weight[i-1] > j){
                  //have to skip the element
                  dp[i][j] = dp[i-1][j];
                } 
                else{
                  dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }      
            }
          }

          System.out.println(dp[n][capacity]);
        }
	}
}
