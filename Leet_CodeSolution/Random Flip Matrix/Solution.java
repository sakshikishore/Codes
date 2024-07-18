import java.math.*;
class Solution {
   int row=0,col=0,temprow=0,tempcol=0;
   HashMap<Integer,HashSet<Integer>> h=new HashMap<Integer,HashSet<Integer>>();
   HashSet<Integer> hset=new HashSet<Integer>();
    public Solution(int m, int n) {
        row=m;
        col=n;
        temprow=m;
        tempcol=n;
    }
    
    public int[] flip() {
        int result[]=new int[2];
     Random rand=new Random();
     int r=rand.nextInt(row-hset.size());
     int count=0;
     for(int i=0;i<row;i++)
     {
        if(!hset.contains(i))
        {
            if(count==r)
            {
                r=i;
                break;
            }
            count++;         
        }
     }
     if(h.containsKey(r))
     {
          HashSet<Integer> hs=h.get(r);
          count=0;
          int c=rand.nextInt(col-hs.size());
          for(int i=0;i<col;i++)
          {
                if(!hs.contains(i))
                {
                    if(c==count)
                    {
                          c=i;
                          break;
                    }
                    count++;
                }
          }
          hs.add(c);
          h.put(r,hs);
          if(hs.size()==col)
          {
            hset.add(r);
          }  
              result[1]=c;

     }else
     {
        int c=rand.nextInt(col);
        HashSet<Integer> hs=new HashSet<Integer>();
         hs.add(c);
          h.put(r,hs);
          if(hs.size()==col)
          {
            hset.add(r);
          }  
              result[1]=c;
     }
     result[0]=r;
     return result;
    }
    
    public void reset() {
        row=temprow;
        col=tempcol;
        h=new HashMap<Integer,HashSet<Integer>>();
        hset=new HashSet<Integer>();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
