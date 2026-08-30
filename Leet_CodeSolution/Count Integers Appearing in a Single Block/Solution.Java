class Solution {
    public int countSpecialIntegers(int[] nums) {
        int arr[] = new int[101];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (arr[nums[i - 1]] == count) {
                    result++;
                }
                count = 1;
            } else {
                count++;
            }
        }
        if(arr[nums[nums.length-1]]==count)
        {
            result++;
        }

        return result;
    }
}
