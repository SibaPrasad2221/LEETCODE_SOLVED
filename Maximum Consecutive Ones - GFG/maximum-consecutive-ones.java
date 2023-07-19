//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int longestOnes(int n, int[] arr, int k) {
        // code here
        //Write your code here
		int sp =0;
		int ep =0;
		int numZeroes =0; 

		int ans =0; //max lenght of consecutive 1 so far

		
		while(ep<n){
			//step 1 introduce the new person
			if(arr[ep]==0) numZeroes++;

			//step 2 due to the addtion of new person, it is possible my window might 
			//so i will keep on shrinking until the window have become valid
			while(numZeroes > k){ //my window can have no of zeores <=k
				//shrink
				if(arr[sp]==0) numZeroes--;
				sp++;
			}
			//if i am standing on this line that means that window is valid

			//step:3 update ans
			ans = Math.max(ans, ep-sp+1); //ep-sp+1 is the length of window

			//step 4: expand
			ep++;
		}
		return ans;
    }
}
        
