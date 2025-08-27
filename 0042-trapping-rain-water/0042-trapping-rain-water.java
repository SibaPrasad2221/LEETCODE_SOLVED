class Solution {

    //TC: O(N^2) SC:O(1)
    // public int trap(int[] height) {
    //     int n=height.length;
    //     int amt=0;
    //     for(int i=0;i<n;i++){
    //         int lmax=0;
    //         for(int j=0;j<=i-1;j++){
    //             lmax=Math.max(lmax,height[j]);
    //         }

    //         int rmax=0;
    //         for(int j=i+1;j<n;j++){
    //             rmax=Math.max(rmax,height[j]);
    //         }
    //         int total_height=Math.min(lmax,rmax);
    //         if(total_height>height[i]){    //that means there are some water above to it
    //             int waterHeight=total_height-height[i];
    //             amt += waterHeight;
    //         }
    //     }
    //     return amt;
    // }

    //TC:as we are calculating for loop individually o(n)+o(n)+o(n) that is o(n)  
    //but in previous approach, we are using nested loop complexity so complexity is O(n^2)

    //SC: o(N)
    public int trap(int[] height){
        //step1 get right max array
        int n=height.length;
        int [] rmax=new int[n];
        rmax[n-1]=0; //last element right max is always zero
        for(int i=n-2;i>=0;i--)
            rmax[i]=Math.max(height[i+1],rmax[i+1]);

        int [] lmax=new int[n];
        lmax[0]=0; //last element right max is always zero
        for(int i=1;i<n;i++)
            lmax[i]=Math.max(height[i-1],lmax[i-1]);

        int amts_of_water=0;
        for(int i=0;i<n;i++){
            int total_height=Math.min(lmax[i],rmax[i]);
            if(total_height>height[i]){    //that means there are some water above to it
                int waterHeight=total_height-height[i];
                amts_of_water += waterHeight;
            }
        }
        return amts_of_water;
        
    }
}