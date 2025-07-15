class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer,HashSet<Integer>> h=new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<languages.length;i++)
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            for(int j=0;j<languages[i].length;j++)
            {
                hset.add(languages[i][j]);
            }
            h.put(i+1,hset);
        }
        HashSet<Integer> commonLanguageFriend=new HashSet<Integer>();
            for(int i=0;i<friendships.length;i++)
            {
                int x=friendships[i][0];
                int y=friendships[i][1];
                HashSet<Integer> hs=new HashSet<Integer>();
                for(int j=0;j<languages[x-1].length;j++)
                {
                    hs.add(languages[x-1][j]);
                }
                for(int j=0;j<languages[y-1].length;j++)
                {
                   if(hs.contains(languages[y-1][j]))
                   {
                        commonLanguageFriend.add(i);
                        break;
                   }
                }
            }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
            HashSet<Integer> hs=new HashSet<Integer>();
            int count=0; 
            for(int j=0;j<friendships.length;j++)
            {
                if(!commonLanguageFriend.contains(j))
                {
                    HashSet<Integer> hset1=h.get(friendships[j][0]);
                    HashSet<Integer> hset2=h.get(friendships[j][1]);
                    if(!hset1.contains(i) && !hs.contains(friendships[j][0]))
                    {
                        count++;
                        hs.add(friendships[j][0]);
                    }
                    if(!hset2.contains(i) && !hs.contains(friendships[j][1]))
                    {
                        count++;
                        hs.add(friendships[j][1]);
                    }
                }     
            }
            res=Math.min(res,count);

        }

        return res;

    }
}
