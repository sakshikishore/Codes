class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int startTimeSecond=(Integer.parseInt(startTime.substring(0,2))*3600)+(Integer.parseInt(startTime.substring(3,5))*60)+(Integer.parseInt(startTime.substring(6)));
        int endTimeSecond=(Integer.parseInt(endTime.substring(0,2))*3600)+(Integer.parseInt(endTime.substring(3,5))*60)+(Integer.parseInt(endTime.substring(6)));

        return endTimeSecond-startTimeSecond;
        
    }
}
