class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // Total True Consecutive
        int trueMax=0;
        Queue<Integer> q=new LinkedList<Integer>();
        int start=0;
        for(int i=0;i<answerKey.length();i++)
        {
            if(answerKey.charAt(i)=='F')
            {
                if(q.size()==k)
                {
                    if(i-start>trueMax)
                    {
                        trueMax=i-start;
                    }
                    int x=q.poll();
                    start=x+1;
                    q.add(i);
                }
                else
                {
                    q.add(i);
                }
            }
        }
        if(answerKey.length()-start>trueMax)
        {
            trueMax=answerKey.length()-start;
        }
        
        // Total False Consecutive
        int falseMax=0;
        q=new LinkedList<Integer>();
        start=0;
        for(int i=0;i<answerKey.length();i++)
        {
            if(answerKey.charAt(i)=='T')
            {
                if(q.size()==k)
                {
                    if(i-start>falseMax)
                    {
                        falseMax=i-start;
                    }
                    int x=q.poll();
                    start=x+1;
                    q.add(i);
                }
                else
                {
                    q.add(i);
                }
            }
        }
        if(answerKey.length()-start>falseMax)
        {
            falseMax=answerKey.length()-start;
        }
        
        return Math.max(trueMax,falseMax);
    }
}
