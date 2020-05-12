import java.util.regex.*;
class Solution {
    public boolean isMatch(String s, String p) {
        boolean result=false;
        Pattern k=Pattern.compile("^"+p+"$");
        Matcher m=k.matcher(s);
        while(m.find())
        {
            result=true;
        }
        return result;
    }
}
