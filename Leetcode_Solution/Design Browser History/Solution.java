class BrowserHistory {
    ArrayList<String> l;
    int a=0;
    public BrowserHistory(String homepage) {
        l=new ArrayList<String>(); 
        l.add(homepage);
    }
    
    public void visit(String url) {      
            if(l.size()-1==a)
            {
              l.add(url);
               a++;
            }
            else
            {
              
                int p=l.size();
                for(int i=a+1;i<p;i++)
                {
                    l.remove(a+1);
                }
                l.add(url);
                a=l.size()-1;
            }       
    }
    
    public String back(int steps) {
        int p=a-steps;
        if(p<0)
        {
            a=0;
        }
        else
        {
            a=p;
        }
        
        return l.get(a);
      
    }
    
    public String forward(int steps) {
        int p=a+steps;
        if(p<l.size())
        {
            a=p;
        }
        else
        {
            a=l.size()-1;
        }
        
        return l.get(a);
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
