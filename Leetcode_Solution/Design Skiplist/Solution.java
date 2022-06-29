class Skiplist {
    HashMap<Integer,Integer> h;

    public Skiplist() {
       h= new HashMap<Integer,Integer>();
    }
    
    public boolean search(int target) {
        if(h.containsKey(target))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void add(int num) {
        if(!h.containsKey(num))
        {
            h.put(num,1);
        }
        else
        {
            h.put(num,h.get(num)+1);
        }
    }
    
    public boolean erase(int num) {
        if(h.containsKey(num))
        {
            if(h.get(num)==1)
            {
                h.remove(num);
            }
            else
            {
                h.put(num,h.get(num)-1);
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
