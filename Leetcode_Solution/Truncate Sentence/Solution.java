class Solution {
    public String truncateSentence(String s, int k) {
        String str[]=s.split(" ");
        String result="";
        for(int i=0;i<k;i++)
        {
            result=result+str[i];
            if(i!=k-1)
            {
                result=result+" ";
            }
        }
        
        return result;
    }
}
