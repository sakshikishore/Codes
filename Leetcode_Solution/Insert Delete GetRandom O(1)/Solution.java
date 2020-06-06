class RandomizedSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> l;
    public RandomizedSet() {
        l=new ArrayList<Integer>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!l.contains(val))
        {
            l.add(val);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(l.contains(val))
        {
              
           l.remove(new Integer(val));
           
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int min=0;
        int max=l.size();
        int p=(int)(Math.random()*(max-min))+min;
            
        return l.get(p);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
