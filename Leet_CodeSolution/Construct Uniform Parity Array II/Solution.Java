class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0) {
                oddCount++;
                if (minOdd > nums1[i]) {
                    minOdd = nums1[i];
                }
            } else {
                if (minEven > nums1[i]) {
                    minEven = nums1[i];
                }
            }
        }

        if (oddCount == 0 || oddCount == nums1.length) {
            return true;
        }

        if (minEven - minOdd >= 1) {
            return true;
        }

        return false;
    }
}
