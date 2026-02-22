class Solution {
    public int scoreDifference(int[] nums) {
        int firstPlayerScore = 0, secondPlayerScore = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                if ((i + 1) % 6 != 0) {
                    if (flag == 0) {
                        secondPlayerScore += nums[i];
                        flag = 1;
                    } else {
                        firstPlayerScore += nums[i];
                        flag = 0;
                    }
                } else {
                    if (flag == 0) {
                        firstPlayerScore += nums[i];
                    } else {
                        secondPlayerScore += nums[i];
                    }
                }
            } else if ((i + 1) % 6 == 0) {
                if (flag == 0) {
                    secondPlayerScore += nums[i];
                    flag = 1;
                } else {
                    firstPlayerScore += nums[i];
                    flag = 0;
                }
            } else {
                if (flag == 0) {
                    firstPlayerScore += nums[i];
                } else {
                    secondPlayerScore += nums[i];
                }
            }
        }

        return firstPlayerScore - secondPlayerScore;
    }
}
