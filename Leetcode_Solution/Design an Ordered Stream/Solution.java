class OrderedStream {
    String arr[];
    int count=0;
    ArrayList<Integer> p=new ArrayList<Integer>();
    public OrderedStream(int n) {
        arr=new String[n];
    }
    
    public List<String> insert(int id, String value) {
        arr[id-1]=value;
        ArrayList<String> l=new ArrayList<String>();
        p.add(id-1);
        int flag=0;
        for(int i=0;i<id-1;i++)
        {
            if(!p.contains(i))
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            int j=id-1;
            while(p.contains(j))
            {
                l.add(arr[j]);
                j++;
            }
        }
        
        return l;
        
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
