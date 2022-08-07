class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<items1.length;i++)
        {
            h.put(items1[i][0],items1[i][1]);
        }
        
        for(int i=0;i<items2.length;i++)
        {
            if(!h.containsKey(items2[i][0]))
            {
                h.put(items2[i][0],items2[i][1]);
            }
            else
            {
                h.put(items2[i][0],h.get(items2[i][0])+items2[i][1]);
            }
        }
        int arr1[]=new int[h.size()];
        int arr2[]=new int[h.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int key=entry.getKey();
            int val=entry.getValue();
            arr1[i]=key;
            arr2[i]=val;
            i++;
        }
        
        for(i=0;i<arr1.length;i++)
        {
            for(int j=i+1;j<arr1.length;j++)
            {
                if(arr1[i]>arr1[j])
                {
                    int temp=arr1[i];
                    arr1[i]=arr1[j];
                    arr1[j]=temp;
                    
                    temp=arr2[i];
                    arr2[i]=arr2[j];
                    arr2[j]=temp;
                }
            }
        }
        List<List<Integer>> list=new ArrayList();
        for(i=0;i<arr1.length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(arr1[i]);
            l.add(arr2[i]);
            list.add(l);
        }
        
        return list;
        
    }
}
