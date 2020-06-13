class Solution {
    public boolean detectCapitalUse(String word) {
        boolean result=false;
        String p=word.toLowerCase();
        String q=word.toUpperCase();
        String r=q.substring(0,1)+p.substring(1);
        if(word.equals(p) || word.equals(q) || word.equals(r))
        {
            result=true;
        }
        return result;
    }
}
