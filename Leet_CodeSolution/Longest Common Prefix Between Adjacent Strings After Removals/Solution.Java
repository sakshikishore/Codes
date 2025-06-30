class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int result[] = new int[words.length];
        if (words.length <= 2) {
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int arr[] = new int[words.length];
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while (j < words[i - 1].length() && j < words[i].length() && words[i - 1].charAt(j) == words[i].charAt(j)) {
                j++;
            }
            arr[i] = j;
            pq.add(j);
        }
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                int x = pq.peek();
                if (arr[1] != x) {
                    result[i] = x;
                } else {
                    pq.poll();
                    result[i] = pq.peek();
                    pq.add(x);
                }
            } else if (i == words.length - 1) {
                int x = pq.peek();
                if (arr[words.length - 1] != x) {
                    result[i] = x;
                } else {
                    pq.poll();
                    result[i] = pq.peek();
                    pq.add(x);
                }
            } else {
                int j = 0;
                while (j < words[i - 1].length() && j < words[i + 1].length()
                        && words[i - 1].charAt(j) == words[i + 1].charAt(j)) {
                    j++;
                }
                int x = pq.poll();
                int y = pq.poll();
                if ((arr[i] == x && arr[i + 1] == y) || arr[i] == y && arr[i + 1] == x) {
                    if (pq.size() == 0) {
                        result[i] = j;
                    } else {
                        if (pq.peek() > j) {
                            result[i] = pq.peek();
                        } else {
                            result[i] = j;
                        }
                    }
                    pq.add(x);
                    pq.add(y);
                } else if (arr[i] == x || arr[i + 1] == x) {
                    if (y > j) {
                        result[i] = y;
                    } else {
                        result[i] = j;
                    }
                    pq.add(x);
                    pq.add(y);
                } else {
                    if (x > j) {
                        result[i] = x;
                    } else {
                        result[i] = j;
                    }
                    pq.add(x);
                    pq.add(y);
                }
            }

        }

        return result;

    }
}
