class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (need1 == 0 && need2 == 0) {
            return 0l;
        }
        if (need1 == 0) {
            long n2 = need2 * 1l;
            if (cost2 > costBoth) {
                return costBoth * n2;
            } else {
                return cost2 * n2;
            }
        }
        if (need2 == 0) {
            long n1 = need1 * 1l;
            if (cost1 > costBoth) {
                return costBoth * n1;
            } else {
                return cost1 * n1;
            }
        }
        if (cost1 + cost2 < costBoth) {
            long n1 = need1 * 1l;
            long n2 = need2 * 1l;
            return (n1 * cost1) + (n2 * cost2);
        } else {
            long n1 = need1 * 1l;
            long n2 = need2 * 1l;
            long ans = 0;
            long min=Math.min(n1,n2);
            ans=ans+(min*costBoth);
                n1=n1-min;
                n2=n2-min;
            if (n1 == 0) {
                if (cost2 > costBoth) {
                    return ans + (costBoth * n2);
                } else {
                    return ans + (cost2 * n2);
                }
            } else {
                if (cost1 > costBoth) {
                    return ans + (costBoth * n1);
                } else {
                    return ans + (cost1 * n1);
                }
            }
        }

    }
}
