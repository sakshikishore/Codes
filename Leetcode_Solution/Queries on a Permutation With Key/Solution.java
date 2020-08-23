class Solution {
    public int[] processQueries(int[] queries, int m) {
       ArrayList<Integer> l=new ArrayList<Integer>();
        int arr[]=new int[queries.length];
        for(int i=0;i<m;i++)
        {
           l.add(i+1);
        }
        for(int i=0;i<queries.length;i++)
        {
            arr[i]=l.indexOf(queries[i]);
            l.remove(new Integer(queries[i]));
            l.add(0,queries[i]);
        }
        
        
        return arr;
        
    }
}
