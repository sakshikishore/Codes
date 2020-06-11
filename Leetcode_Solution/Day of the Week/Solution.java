import java.time.LocalDate;
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        LocalDate dt=LocalDate.of(year,month,day);
        String result=dt.getDayOfWeek().name();
        
        return result.substring(0,1)+result.substring(1).toLowerCase();
        
    }
}
