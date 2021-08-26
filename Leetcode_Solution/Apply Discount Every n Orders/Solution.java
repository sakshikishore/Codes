class Cashier {
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    int count=0;
    double discountOffer=0.0;
    int m=0;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        for(int i=0;i<products.length;i++)
        {
            h.put(products[i],prices[i]);
        }
        discountOffer=discount;
        m=n;
        
    }
    
    public double getBill(int[] product, int[] amount) {
        count++;
        double bill=0.0;
       for(int i=0;i<product.length;i++)
       {
          bill+=(h.get(product[i])*amount[i]);
       }
        if(count%m==0)
        {
            bill=bill*((100-discountOffer)/100);
        }
        
        return bill;
    }
    
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
