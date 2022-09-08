class Solution {
    public int maxChunksToSorted(int[] arr) {
        List<List<String>> list=new ArrayList();
        int sortedArray[]=new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            sortedArray[i]=arr[i];
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        Arrays.sort(sortedArray);
        String str="";
        for(int i=0;i<arr.length;i++)
        {
           if(i==0)
           {
               str=Integer.toString(arr[i]);
               list.get(i).add(str);
           }
           else
           {
               str=str+","+Integer.toString(arr[i]);
               list.get(i).add(str);
               String res="";
               for(int j=i;j>=1;j--)
               {
                   if(j==i)
                   {
                       res=Integer.toString(arr[j]);
                   }
                   else
                   {
                       res=Integer.toString(arr[j])+","+res;
                   }
                   
                   for(int k=0;k<list.get(j-1).size();k++)
                   {
                       String s=list.get(j-1).get(k);
                       s=s+" "+res;
                       list.get(i).add(s);
                   }
                   
               }
           }
        }
        int n=arr.length-1;
        int max=0;
        for(int i=0;i<list.get(n).size();i++)
        {
            String st[]=list.get(n).get(i).split(" ");
            int len=st.length;
            int a[]=new int[n+1];
            int k=0;
            for(int j=0;j<len;j++)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                String s[]=st[j].split(",");
                for(int r=0;r<s.length;r++)
                {
                    l.add(Integer.parseInt(s[r]));
                }
                Collections.sort(l);
                for(int r=0;r<l.size();r++)
                {
                    a[k]=l.get(r);
                    k++;
                }
            }
            if(Arrays.equals(sortedArray,a))
            {
                if(len>max)
                {
                    max=len;
                }
            }
        }
        
        return max;
        
        
    }
}
