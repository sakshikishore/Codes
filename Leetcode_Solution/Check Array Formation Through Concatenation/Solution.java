class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i=0,count=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        boolean result=true;
        while(i<arr.length)
        {
            int flag=0;          
            if(count==0)
            {
                for(int j=0;j<pieces.length;j++)
                {
                   
                        if(pieces[j][0]==arr[i])
                        {
                            l.add(j);
                            flag=1;
                            if(pieces[j].length>1)
                            {
                                count++;
                            }
                            
                            break;
                        }
                }
                
            }
            else
                {
                    if(pieces[l.get(l.size()-1)][count]!=arr[i])
                    {
                        result=false;
                        break;
                    }
                    else
                    {
                        flag=1;
                            if(pieces[l.get(l.size()-1)].length>count+1)
                            {
                                count++;
                            }
                            else
                            {
                                 count=0;
                            }
                    }
                }
            
            if(flag==0)
            {
                result=false;
                break;
            }
               
            i++;
        }
                                      
       return result;
        
    }
}
