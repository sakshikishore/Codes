class FrequencyTracker {
   HashMap<Integer,Integer> h;
   int freq[]=new int[100001];
    public FrequencyTracker() {
        h=new HashMap<Integer,Integer>();
    }
    
    public void add(int number) {
        if(!h.containsKey(number))
        {
            h.put(number,1);
            freq[1]++;
        }
        else
        {
            int x=h.get(number);
            freq[x]--;
            freq[x+1]++;
            h.put(number,x+1);
            
        }
    }
    
    public void deleteOne(int number) {
        if(h.containsKey(number))
        {
            if(h.get(number)==1)
            {
                h.remove(number);
                freq[1]--;
            }
            else
            {
                int x=h.get(number);
                freq[x]--;
                freq[x-1]++;
                h.put(number,x-1);
            }
        }
    }
    
    public boolean hasFrequency(int frequency) {
        if(freq[frequency]>0)
        {
            return true;
        }
        
        return false;
    }
}
