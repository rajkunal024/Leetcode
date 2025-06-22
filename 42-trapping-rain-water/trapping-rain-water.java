class Solution {
    public int trap(int[] height) {
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        int sum=0;
        leftmax[0]=height[0];
        rightmax[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++)
        {
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }

        for(int i=height.length-2;i>=0;i--)
        {
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }
        for(int i=0; i<height.length;i++)
        {
            sum +=(Math.min(rightmax[i],leftmax[i])-height[i]);

        }
        return sum;
    }
}