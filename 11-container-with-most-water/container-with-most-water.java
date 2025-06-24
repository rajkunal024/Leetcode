class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int ans=Integer.MIN_VALUE;
        int area=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int wt=j-i;
        //         int ht=Math.min(height[i],height[j]);
        //         area=ht*wt;
        //         if(area>ans)
        //         {
        //             ans=area;
        //         }
        //     }
        // }
        int left=0;
        int right=n-1;
        while(left<right){
            int wt=right-left;
            int ht=Math.min(height[left],height[right]);
            area=ht*wt;
            ans=Math.max(ans,area);
            if(height[left]<height[right])
            {
                left++;
            }
            else right--;
        }
        return ans;
    }
}