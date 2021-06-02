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
        return dp(arr,num-1)+dp(arr,num-2);
    }
}
