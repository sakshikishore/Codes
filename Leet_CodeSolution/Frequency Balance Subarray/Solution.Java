class Solution {
    public int getLength(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> numFreq = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> freqTotalNum = new HashMap<Integer, Integer>();
            for (int j = i; j < nums.length; j++) {
                if (!numFreq.containsKey(nums[j])) {
                    numFreq.put(nums[j], 1);
                    if (!freqTotalNum.containsKey(1)) {
                        freqTotalNum.put(1, 1);
                    } else {
                        freqTotalNum.put(1, freqTotalNum.get(1) + 1);
                    }
                } else {
                    int prev = numFreq.get(nums[j]);
                    numFreq.put(nums[j], prev + 1);
                    freqTotalNum.put(prev, freqTotalNum.get(prev) - 1);
                    if (freqTotalNum.get(prev) == 0) {
                        freqTotalNum.remove(prev);
                    }
                    if (!freqTotalNum.containsKey(prev + 1)) {
                        freqTotalNum.put(prev + 1, 1);
                    } else {
                        freqTotalNum.put(prev + 1, freqTotalNum.get(prev + 1) + 1);
                    }
                }
                if (numFreq.size() == 1) {
                    res = Math.max(res, numFreq.get(nums[j]));
                }
                 else if (freqTotalNum.size() == 2) {
                    int key1 = -1, key2 = -1, val1 = 0, val2 = 0;
                    for (Map.Entry<Integer, Integer> entry : freqTotalNum.entrySet()) {
                        if (key1 == -1) {
                            key1 = entry.getKey();
                            val1 = entry.getValue();
                        } else {
                            key2 = entry.getKey();
                            val2 = entry.getValue();
                        }
                    }

                    if (key1 == 2 * key2 || key2 == 2 * key1) {
                        res = Math.max(res, (key1 * val1) + (key2 * val2));
                    }
                }
            }
        }

        return res;
    }
}
