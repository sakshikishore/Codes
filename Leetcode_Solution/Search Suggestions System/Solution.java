import java.util.regex.*;
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list=new ArrayList<>();
        for(int i=0;i<products.length;i++)
        {
            for(int j=i+1;j<products.length;j++)
            {
                if(products[i].compareTo(products[j])>0)
                {
                    String temp=products[i];
                    products[i]=products[j];
                    products[j]=temp;
                }
            }
        }
        
        for(int i=0;i<searchWord.length();i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            String p=searchWord.substring(0,i+1);
            for(int j=0;j<products.length;j++)
            {
                if(products[j].length()>=p.length())
                {
                    if(products[j].substring(0,i+1).equals(p))
                    {
                        l.add(products[j]);
                        if(l.size()==3)
                        {
                            break;
                        }
                    }
                }
            }
                           
                           list.add(l);
            
            
        }
                           
                           return list;
        
    }
}
