class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sum1=0,sum2=0,targetSum=0;
        boolean result=false;
        for(int i=0;i<firstWord.length();i++)
        {
            int p=firstWord.charAt(i)-'a';
            sum1=sum1*10+p;
        }
        
        for(int i=0;i<secondWord.length();i++)
        {
            int p=secondWord.charAt(i)-'a';
            sum2=sum2*10+p;
        }
        
        for(int i=0;i<targetWord.length();i++)
        {
            int p=targetWord.charAt(i)-'a';
            targetSum=targetSum*10+p;
        }
        
        if(sum1+sum2==targetSum)
        {
            result=true;
        }
        
        return result;
        
    }
}
