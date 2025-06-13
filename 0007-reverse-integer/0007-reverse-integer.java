class Solution {
    public int reverse(int x) {
        int num = Math.abs(x); 

        int rev = 0;  // Reversed number
        
        while (num != 0) {
            int ld = num % 10;  

            // Overflow check
            if (rev > (Integer.MAX_VALUE - ld) / 10) {
                return 0;  
            }
            
            rev = rev * 10 + ld; 
            num = num / 10;  
        }
        
        return (x < 0) ? (-rev) : rev; 
    }
}