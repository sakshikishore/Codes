class Solution {
    public int[] findArray(int[] pref) {
        int result[]=new int[pref.length];
        result[0]=pref[0];
        int res=result[0];
        for(int i=1;i<pref.length;i++)
        {
           result[i]=res^pref[i];
           res=res^result[i];
        }
        
        return result;
    }
}
