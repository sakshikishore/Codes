class MovieRentingSystem {
    HashMap<Integer,TreeMap<Integer,ArrayList<Integer>>> moviePriceShop=new HashMap<Integer,TreeMap<Integer,ArrayList<Integer>>>();// UnRented
     HashMap<Integer,TreeMap<Integer,ArrayList<Integer>>> rentedMoviePriceShop=new HashMap<Integer,TreeMap<Integer,ArrayList<Integer>>>();
    int totalShop=0;
     HashMap<Integer,HashMap<Integer,Integer>> movieShopPrice=new HashMap<Integer,HashMap<Integer,Integer>>();
     TreeMap<Integer,List<List<Integer>>> priceShopMovie=new TreeMap<Integer,List<List<Integer>>>();
    public MovieRentingSystem(int n, int[][] entries) {
        totalShop=n;
        for(int i=0;i<entries.length;i++)
        {
            if(!movieShopPrice.containsKey(entries[i][1]))
            {
                HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
                h.put(entries[i][0],entries[i][2]);
                movieShopPrice.put(entries[i][1],h);
            }
            else
            {
                HashMap<Integer,Integer> h=movieShopPrice.get(entries[i][1]);
                h.put(entries[i][0],entries[i][2]);
                movieShopPrice.put(entries[i][1],h);
            }
            if(!moviePriceShop.containsKey(entries[i][1]))
            {
                TreeMap<Integer,ArrayList<Integer>> t=new TreeMap<Integer,ArrayList<Integer>>();
                    ArrayList<Integer> shopsList=new ArrayList<Integer>();
                    shopsList.add(entries[i][0]);
                    t.put(entries[i][2],shopsList);
                    moviePriceShop.put(entries[i][1],t);
            }
            else
            {
                 TreeMap<Integer,ArrayList<Integer>> t=moviePriceShop.get(entries[i][1]);
                if(!t.containsKey(entries[i][2]))
                {
                    ArrayList<Integer> shopsList=new ArrayList<Integer>();
                    shopsList.add(entries[i][0]);
                    t.put(entries[i][2],shopsList);
                    moviePriceShop.put(entries[i][1],t);
                }
                else
                {
                    ArrayList<Integer> shopsList=t.get(entries[i][2]);
                    int low=0,high=shopsList.size()-1,index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(shopsList.get(mid)>entries[i][0])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            index=mid+1;
                            low=mid+1;
                        }
                    }
                    shopsList.add(index,entries[i][0]);
                    t.put(entries[i][2],shopsList);
                    moviePriceShop.put(entries[i][1],t);

                }
            }
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> result=new ArrayList<Integer>();
        if(!moviePriceShop.containsKey(movie))
        {
            return result;
        }
        else
        {
            TreeMap<Integer,ArrayList<Integer>> t=moviePriceShop.get(movie);
            for(Map.Entry<Integer,ArrayList<Integer>> entry:t.entrySet())
            {
                ArrayList<Integer> shopsList=entry.getValue();
                for(int i=0;i<shopsList.size();i++)
                {
                    result.add(shopsList.get(i));
                    if(result.size()==5)
                    {
                        break;
                    }
                }
                if(result.size()==5)
                    {
                        break;
                    }
            }

            return result;
        }
    }
    
    public void rent(int shop, int movie) {
         HashMap<Integer,Integer> shopPrice= movieShopPrice.get(movie);
         int price=shopPrice.get(shop);
         TreeMap<Integer,ArrayList<Integer>> priceShop=moviePriceShop.get(movie);
         ArrayList<Integer> shopsList=priceShop.get(price);
         int low=0,high=shopsList.size()-1;
         while(low<=high)
         {
             int mid=(low+high)/2;
             if(shopsList.get(mid)==shop)
             {
                 shopsList.remove(mid);
                 break;
             }
             else if(shopsList.get(mid)>shop)
             {
                 high=mid-1;
             }
             else
             {
                 low=mid+1;
             }
         }
         priceShop.put(price,shopsList);
         moviePriceShop.put(movie,priceShop);
         
         if(priceShopMovie.containsKey(price))
         {
            
             List<List<Integer>> list=priceShopMovie.get(price);
              int index=list.size();
             for(int i=0;i<list.size();i++)
             {
                 if(list.get(i).get(0)>shop)
                 {
                     index=i;
                     break;
                 }
                 else if(list.get(i).get(0)==shop)
                 {
                     if(list.get(i).get(1)>movie)
                     {
                         index=i;
                         break;
                     }
                 }
             }

             ArrayList<Integer> al=new ArrayList<Integer>();
             al.add(shop);
             al.add(movie);
             list.add(index,al);
             priceShopMovie.put(price,list);
         }
         else
         {
             List<List<Integer>> list=new ArrayList();
             ArrayList<Integer> al=new ArrayList<Integer>();
             al.add(shop);
             al.add(movie);
             list.add(al);
             priceShopMovie.put(price,list);
         }

         // Add movie,Price,Shop in rentedMoviePriceShop
         if(!rentedMoviePriceShop.containsKey(movie))
         {
              priceShop=new TreeMap<Integer,ArrayList<Integer>>();
              shopsList=new ArrayList<Integer>();
              shopsList.add(shop);
              priceShop.put(price,shopsList);
              rentedMoviePriceShop.put(movie,priceShop);
         }
         else
         {
              priceShop = rentedMoviePriceShop.get(movie);
             if(!priceShop.containsKey(price))
                {
                    shopsList=new ArrayList<Integer>();
                    shopsList.add(shop);
                    priceShop.put(price,shopsList);
                    rentedMoviePriceShop.put(movie,priceShop);
                }
                else
                {
                    shopsList=priceShop.get(price);
                    low=0;
                    high=shopsList.size()-1;
                    int index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(shopsList.get(mid)>shop)
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            index=mid+1;
                            low=mid+1;
                        }
                    }
                    shopsList.add(index,shop);
                    priceShop.put(price,shopsList);
                    rentedMoviePriceShop.put(movie,priceShop);

                }

             
         }


    }
    
    public void drop(int shop, int movie) {
        HashMap<Integer,Integer> shopPrice= movieShopPrice.get(movie);
         int price=shopPrice.get(shop);
         TreeMap<Integer,ArrayList<Integer>> priceShop=rentedMoviePriceShop.get(movie);
         ArrayList<Integer> shopsList=priceShop.get(price);
         int low=0,high=shopsList.size()-1;
         while(low<=high)
         {
             int mid=(low+high)/2;
             if(shopsList.get(mid)==shop)
             {
                 shopsList.remove(mid);
                 break;
             }
             else if(shopsList.get(mid)>shop)
             {
                 high=mid-1;
             }
             else
             {
                 low=mid+1;
             }
         }
         priceShop.put(price,shopsList);
         rentedMoviePriceShop.put(movie,priceShop);
         if(priceShopMovie.containsKey(price))
         {
             List<List<Integer>> list=priceShopMovie.get(price);
             for(int j=0;j<list.size();j++)
             {
                 if(list.get(j).get(0)==shop && list.get(j).get(1)==movie)
                 {
                     list.remove(j);
                     break;
                 }
             }
             priceShopMovie.put(price,list);
         }

         // Add movie,Price,Shop in UnrentedMoviePriceShop
         if(!moviePriceShop.containsKey(movie))
         {
              priceShop=new TreeMap<Integer,ArrayList<Integer>>();
              shopsList=new ArrayList<Integer>();
              shopsList.add(shop);
              priceShop.put(price,shopsList);
              moviePriceShop.put(movie,priceShop);
         }
         else
         {
              priceShop = moviePriceShop.get(movie);
             if(!priceShop.containsKey(price))
                {
                    shopsList=new ArrayList<Integer>();
                    shopsList.add(shop);
                    priceShop.put(price,shopsList);
                    moviePriceShop.put(movie,priceShop);
                }
                else
                {
                    shopsList=priceShop.get(price);
                    low=0;
                    high=shopsList.size()-1;
                    int index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(shopsList.get(mid)>shop)
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            index=mid+1;
                            low=mid+1;
                        }
                    }
                    shopsList.add(index,shop);
                    priceShop.put(price,shopsList);
                    moviePriceShop.put(movie,priceShop);

                }

             
         }
      
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result=new ArrayList();
        for(Map.Entry<Integer,List<List<Integer>>> entry:priceShopMovie.entrySet())
        {
           List<List<Integer>> list=entry.getValue();
           for(int i=0;i<list.size();i++)
           {
               result.add(list.get(i));
               if(result.size()==5)
               {
                   break;
               }
           }
           if(result.size()==5)
           {
               break;
           }

        }
        return result;
    }
}
