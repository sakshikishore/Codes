class Solution {
    public int maxDistance(String s, int k) {
        int arr[] = new int[4];
        int max = 0;
        int p = k;
        for (int i = 0; i < s.length(); i++) {
            k = p;
            if (s.charAt(i) == 'N') {
                arr[0]++;
            } else if (s.charAt(i) == 'S') {
                arr[1]++;
            } else if (s.charAt(i) == 'E') {
                arr[2]++;
            } else {
                arr[3]++;
            }
            int min1 = Math.min(arr[0], arr[1]);
            int max1 = Math.max(arr[0], arr[1]);
            int min2 = Math.min(arr[2], arr[3]);
            int max2 = Math.max(arr[2], arr[3]);

            if (min1 >= k) {
                max = Math.max(max, Math.abs(max2 - min2) + max1 + k + k - min1);
            } else {
                max1 += min1;
                k = k - min1;
                if (min2 >= k) {
                    max = Math.max(max, Math.abs(max2 + k + k - min2) + max1);
                } else {
                    max2 = max2 + min2;
                    max = Math.max(max, max1 + max2);
                }
            }

        }

        return max;
    }
}
