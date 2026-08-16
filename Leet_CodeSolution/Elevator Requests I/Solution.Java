class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans = 0, currentFloor = 0;
        for (int i = 0; i < requests.length; i++) {
            int time = Math.abs(currentFloor - requests[i]);
            ans += time;
            currentFloor = requests[i];
        }

        return ans;
    }
}
