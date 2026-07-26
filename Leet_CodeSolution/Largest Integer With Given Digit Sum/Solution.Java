class Solution {
    public int largestInteger(int n, int s) {
        if (s > 45) {
            return -1;
        }
        if ((n == 1 && s > 9) || (n == 2 && s > 18) || (n == 3 && s > 27) || (n == 4 && s > 36)) {
            return -1;
        }
        if (n == 1) {
            return s;
        } else if (n == 2) {
            if (s >= 0 && s <= 9) {
                return s * 10;
            } else {
                return (9 * 10) + ((s + 1) % 10);
            }
        } else if (n == 3) {
            if (s >= 0 && s <= 9) {
                return s * 100;
            } else if (s >= 10 && s <= 18) {
                return ((9 * 10) + ((s + 1) % 10)) * 10;
            } else {
                return (99 * 10) + ((s + 2) % 10);
            }
        } else if (n == 4) {
            if (s >= 0 && s <= 9) {
                return s * 1000;
            } else if (s >= 10 && s <= 18) {
                return ((9 * 10) + ((s + 1) % 10)) * 100;
            } else if (s >= 19 && s <= 27) {
                return ((99 * 10) + ((s + 2) % 10)) * 10;
            } else {
                return (999 * 10) + ((s + 3) % 10);
            }
        } else {
            if (s >= 0 && s <= 9) {
                return s * 10000;
            } else if (s >= 10 && s <= 18) {
                return ((9 * 10) + ((s + 1) % 10)) * 1000;
            } else if (s >= 19 && s <= 27) {
                return ((99 * 10) + ((s + 2) % 10)) * 100;
            } else if (s >= 28 && s <= 36) {
                return ((999 * 10) + ((s + 3) % 10)) * 10;
            } else {
                return (9999 * 10) + ((s + 4) % 10);
            }
        }

    }
}
