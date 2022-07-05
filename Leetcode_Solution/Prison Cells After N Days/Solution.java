class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
       
       HashMap<ArrayList<Integer>,Integer> h=new HashMap<ArrayList<Integer>,Integer>();
       HashMap<Integer,int []> h1=new HashMap<Integer, int []>();
       if(n<64)
       {
           for(int i=0;i<n;i++)
           {
               int arr[]=new int[8];
               for(int j=1;j<7;j++)
               {
                   arr[j]=(cells[j-1]^cells[j+1])==0?1:0;
               }
               cells=arr;
           }
       }
       else
       {
           int p=0;
           int start=0,end=0;
           for(int i=1;i<=66;i++)
           {
               int arr[]=new int[8];
               for(int j=1;j<7;j++)
               {
                  arr[j]=(cells[j-1]^cells[j+1])==0?1:0;
               }
               
               ArrayList<Integer> l=new ArrayList<Integer>();
               for(int s=0;s<8;s++)
               {
                   l.add(arr[s]);
               }
               if(!h.containsKey(l))
               {
                   h.put(l,i);
                   h1.put(i,arr);
                   cells=arr;
               }
               else
               {
                   p=i-h.get(l);
                   start=h.get(l);
                   end=i-1;
           
                   break;
               }
           }
           for(int i=start;i<=end;i++)
           {
               int x=1+((n-i)/p);
               if(i+((x-1)*p)==n)
               {
                   cells=h1.get(i);
                   break;
               }
           }
       }
        
        return cells;
  }
}
