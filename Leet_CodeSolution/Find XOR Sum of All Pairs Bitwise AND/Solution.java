class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int x=0;
        for(int i=0;i<arr1.length;i++)
        {
            x=x^arr1[i];
        }
        int y=0;
        for(int i=0;i<arr2.length;i++)
        {
            y=y^arr2[i];
        }

        return x & y;

    }
}
