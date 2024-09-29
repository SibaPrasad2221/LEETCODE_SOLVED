class Solution {
    public int tribonacci(int n) {
        HashMap<Integer, Integer> check = new HashMap<>();
        if (n==0){ 
        return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        check.put(0,0);
        check.put(1,1);
        check.put(2,1);
        for (int i=3;i<=n;i++) {
            int result = check.get(i - 1)+check.get(i - 2)+check.get(i - 3);
            check.put(i,result);
        }
        return check.get(n);
    }
}