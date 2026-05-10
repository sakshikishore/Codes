class Solution {
    public int[] scoreValidator(String[] events) {
        int arr[] = new int[2]; // score=arr[0], count=arr[1]
        for (int i = 0; i < events.length; i++) {
            if (events[i].equals("W")) {
                arr[1]++;
                if (arr[1] == 10) {
                    break;
                }
            } else if (events[i].equals("WD") || events[i].equals("NB")) {
                arr[0]++;
            } else {
                arr[0] += Integer.parseInt(events[i]);
            }
        }

        return arr;

    }
}
