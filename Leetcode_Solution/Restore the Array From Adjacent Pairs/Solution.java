class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<adjacentPairs.length;i++)
        {
            
            if(!h.containsKey(adjacentPairs[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(adjacentPairs[i][1]);
                h.put(adjacentPairs[i][0],l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(adjacentPairs[i][0]);
                 l.add(adjacentPairs[i][1]);
                 h.put(adjacentPairs[i][0],l);
            }
            if(!h.containsKey(adjacentPairs[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(adjacentPairs[i][0]);
                h.put(adjacentPairs[i][1],l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(adjacentPairs[i][1]);
                 l.add(adjacentPairs[i][0]);
                 h.put(adjacentPairs[i][1],l);
            }
        }
        int arr[]=new int[adjacentPairs.length+1];
        HashSet<Integer> res=new HashSet<Integer>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry: h.entrySet())
        {
            if(entry.getValue().size()==1)
            {
                arr[0]=entry.getKey();
                res.add(arr[0]);
                break;
            }
        }
        for(int i=1;i<arr.length;i++)
        {
            ArrayList<Integer> p=h.get(arr[i-1]);
            
                if(res.contains(p.get(0)))
                {
                    arr[i]=p.get(1);
                }
                else
                {
                    arr[i]=p.get(0);
                }
            
            res.add(arr[i]);
        }
        
        return arr;
        
    }
}
