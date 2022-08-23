class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer,HashSet<Integer>> h= new HashMap<Integer,HashSet<Integer>>();
        HashMap<Integer,ArrayList<Integer>> connections= new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<paths.length;i++)
        {
            if(!connections.containsKey(paths[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(paths[i][1]);
                connections.put(paths[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=connections.get(paths[i][0]);
                l.add(paths[i][1]);
                connections.put(paths[i][0],l);
            }
            if(!connections.containsKey(paths[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(paths[i][0]);
                connections.put(paths[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=connections.get(paths[i][1]);
                l.add(paths[i][0]);
                connections.put(paths[i][1],l);
            }
        }
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(!connections.containsKey(i+1))
            {
                arr[i]=1;
            }
            else
            {
            if(i==0)
            {
                arr[i]=1;
                ArrayList<Integer> l=connections.get(i+1);
                for(int j=0;j<l.size();j++)
                {
                    if(!h.containsKey(l.get(j)))
                    {
                        HashSet<Integer> hset=new HashSet<Integer>();
                        hset.add(1);
                        h.put(l.get(j),hset);
                    }
                    else
                    {
                        HashSet<Integer> hset=h.get(l.get(j));
                        hset.add(1);
                        h.put(l.get(j),hset);
                    }
                }
            }
            else
            {
                if(h.containsKey(i+1))
                {
                    HashSet<Integer> h1=h.get(i+1);
                    for(int j=1;j<=4;j++)
                    {
                        if(!h1.contains(j))
                        {
                            arr[i]=j;
                            break;
                        }
                    }
                    ArrayList<Integer> l=connections.get(i+1);
                    for(int j=0;j<l.size();j++)
                    {
                        if(!h.containsKey(l.get(j)))
                        {
                            HashSet<Integer> hset=new HashSet<Integer>();
                            hset.add(arr[i]);
                            h.put(l.get(j),hset);
                        }
                        else
                        {
                            HashSet<Integer> hset=h.get(l.get(j));
                            hset.add(arr[i]);
                            h.put(l.get(j),hset);
                        }

                    }
                }
                else
                {
                    arr[i]=1;
                    ArrayList<Integer> l=connections.get(i+1);
                    for(int j=0;j<l.size();j++)
                    {
                        if(!h.containsKey(l.get(j)))
                        {
                            HashSet<Integer> hset=new HashSet<Integer>();
                            hset.add(1);
                            h.put(l.get(j),hset);
                        }
                        else
                        {
                            HashSet<Integer> hset=h.get(l.get(j));
                            hset.add(1);
                            h.put(l.get(j),hset);
                        }

                    }
            }
        }
            }
    }
        
        return arr;
        
    }
}
