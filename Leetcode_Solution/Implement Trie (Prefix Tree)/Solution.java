class Trie {

    /** Initialize your data structure here. */
    ArrayList<String> l;
    public Trie() {
        l=new ArrayList<String>();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        l.add(word);
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        boolean result=false;
        if(l.contains(word))
        {
            result=true;
        }
        
        return result;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        boolean result=false;
        for(int i=0;i<l.size();i++)
        {
            String str=l.get(i);
            if(str.length()>=prefix.length())
            {
                if(str.substring(0,prefix.length()).equals(prefix))
                {
                    result=true;
                    break;
                }
            }
        }
        
        return result;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
