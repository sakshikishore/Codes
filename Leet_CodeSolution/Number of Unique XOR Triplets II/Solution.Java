 class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> hset1 = new HashSet<Integer>();
        HashSet<Integer> hset = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        hset.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (!hset1.contains(nums[i])) {
                hset1.add(nums[i]);
                for (int j = i + 1; j < nums.length; j++) {
                    hset.add(nums[i] ^ nums[j]);
                }
            }
        }
        nums = new int[hset1.size()];
        int t = 0;
        Iterator<Integer> it = hset1.iterator();
        while (it.hasNext()) {
            nums[t] = it.next();
            t++;
        }
        int arr[]=new int[hset.size()];
        t=0;
        it = hset.iterator();
        while (it.hasNext()) {
            arr[t] = it.next();
            t++;
        }

        for (int i = 0; i < nums.length; i++) {
            for(int j=0;j<arr.length;j++)
            {
                result.add(nums[i]^arr[j]);
            }
        }

        return result.size();

    }
}
