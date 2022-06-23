class Solution {
    public double angleClock(int hour, int minutes) {
        double angle=11/2.0;
        angle=Math.abs((hour*30)-angle*minutes);
        
        return Math.min(angle,360-angle);
        
    }
}
