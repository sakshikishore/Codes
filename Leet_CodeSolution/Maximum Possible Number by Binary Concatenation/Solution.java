class Solution {
    public int maxGoodNumber(int[] nums) {
      String str=Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[2]);
      int x=Integer.parseInt(str,2);
      str=Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[1]);
      x=Math.max(x,Integer.parseInt(str,2));
       str=Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[0]);
      x=Math.max(x,Integer.parseInt(str,2));
       str=Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[2]);
      x=Math.max(x,Integer.parseInt(str,2));

       str=Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[1]);
      x=Math.max(x,Integer.parseInt(str,2));
       str=Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[0]);
      x=Math.max(x,Integer.parseInt(str,2));

      return x;

    }
}
