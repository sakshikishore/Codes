class ProductOfNumbers {
   ArrayList<Integer> l;
    public ProductOfNumbers() {
        
        l=new ArrayList<Integer>();
    }
    
    public void add(int num) {
        l.add(num);
        
    }
    
    public int getProduct(int k) {
        int i=0;
        int p=l.size()-1;
        int result=1;
        while(i<k)
        {
            result=result*l.get(p);
            p--;
            i++;
        }
        
        return result;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
