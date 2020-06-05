class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        for(int i=0;i<arr2.length;i++)
        {
            l.add(arr2[i]);
        }
        
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<arr1.length;i++)
        {
            if(l.contains(arr1[i]))
            {
                if(!h.containsKey(arr1[i]))
                {
                    h.put(arr1[i],1);
                }
                else
                {
                    h.put(arr1[i],h.get(arr1[i])+1);
                }
            }
            else
            {
                m.add(arr1[i]);
            }
        }
        Collections.sort(m);
        int k=0;
        for(int i=0;i<arr2.length;i++)
        {
            for(int j=0;j<h.get(arr2[i]);j++)
            {
                arr1[k]=arr2[i];
                k++;
            }
        }
        for(int i=0;i<m.size();i++)
        {
            arr1[k]=m.get(i);
            k++;
        }
        
        return arr1;
    }
}
