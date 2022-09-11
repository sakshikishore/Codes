class TopVotedCandidate {
   int time[];
    ArrayList<Integer> result;
    int ch[]=new int[5000];
    int max=0;
    int winner=-1;
    public TopVotedCandidate(int[] persons, int[] times) {
        time=new int[times.length];
        time=times;
        result=new ArrayList<Integer>();
        for(int i=0;i<persons.length;i++)
        {
            ch[persons[i]]++;
            if(ch[persons[i]]>=max)
            {
                max=ch[persons[i]];
                winner=persons[i];
            }
            result.add(winner);
        }
        
    }
    
    public int q(int t) {
        int i=0;
        int ans=0;
        while(i<time.length && time[i]<=t)
        {
            ans=result.get(i);       
            i++;
        }

        
        return ans;
    }
}
