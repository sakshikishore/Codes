class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int count=0;
        int arr[][]=new int[m][n];
        for(int i=0;i<walls.length;i++)
        {
            int r=walls[i][0];
            int c=walls[i][1];
            arr[r][c]=-1;
        }
         for(int i=0;i<guards.length;i++)
        {
            int r=guards[i][0];
            int c=guards[i][1];
            arr[r][c]=1;
        }
        HashMap<Integer,ArrayList<Integer>> guardRowCol=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> guardColRow=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> wallRowCol=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> wallColRow=new HashMap<Integer,ArrayList<Integer>>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                {
                    if(!guardRowCol.containsKey(i))
                    {
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(j);
                        guardRowCol.put(i,list);
                    }
                    else
                    {
                        ArrayList<Integer> list=guardRowCol.get(i);
                        list.add(j);
                        guardRowCol.put(i,list);
                    }
                     if(!guardColRow.containsKey(j))
                    {
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(i);
                        guardColRow.put(j,list);
                    }
                    else
                    {
                        ArrayList<Integer> list=guardColRow.get(j);
                        list.add(i);
                        guardColRow.put(j,list);
                    }
                }
                else if(arr[i][j]==-1)
                {
                  
                    if(!wallRowCol.containsKey(i))
                    {
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(j);
                        wallRowCol.put(i,list);
                    }
                    else
                    {
                        ArrayList<Integer> list=wallRowCol.get(i);
                        list.add(j);
                        wallRowCol.put(i,list);
                    }
                     if(!wallColRow.containsKey(j))
                    {
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(i);
                        wallColRow.put(j,list);
                    }
                    else
                    {
                        ArrayList<Integer> list=wallColRow.get(j);
                        list.add(i);
                        wallColRow.put(j,list);
                    }
                
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==0)
                {
                    
                    int flag=0;
                    if(guardRowCol.containsKey(i))
                    {
                        if(!wallRowCol.containsKey(i))
                        {
                           flag=1;
                           continue;
                        }
                        ArrayList<Integer> l=guardRowCol.get(i);
                        int low=0,high=l.size()-1,index=0;
                        while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>j)
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
    
                         int left=-1,right=-1;
                        if(index==0)
                        {
                             right=l.get(0);
                        }
                        else if(index==l.size())
                        {
                            left=l.get(l.size()-1);
                        }
                        else
                        {
                            right=l.get(index);
                            left=l.get(index-1);
                        }

                        l=wallRowCol.get(i);
                        low=0;
                        high=l.size()-1;
                        index=0;
                         while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>j)
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
                        int wallleft=-1,wallright=-1;
                        if(index==0)
                        {
                             wallright=l.get(0);
                        }
                        else if(index==l.size())
                        {
                            wallleft=l.get(l.size()-1);
                        }
                        else
                        {
                            wallright=l.get(index);
                            wallleft=l.get(index-1);
                        }
                        if((left!=-1 && wallleft==-1 ) || (right!=-1 && wallright==-1))
                        {
                            
                            flag=1;
                            continue;
                        }
                        if(left>wallleft || (right<wallright && right!=-1))
                        {
                            
                            flag=1;
                           continue;
                        }
    
        
                    }
                    if(guardColRow.containsKey(j))
                    {
                        if(!wallColRow.containsKey(j))
                        {
                            flag=1;
                           continue;
                        }
                        ArrayList<Integer> l=guardColRow.get(j);
                        int low=0,high=l.size()-1,index=0;
                        while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>i)
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
    
                         int left=-1,right=-1;
                        if(index==0)
                        {
                             right=l.get(0);
                        }
                        else if(index==l.size())
                        {
                            left=l.get(l.size()-1);
                        }
                        else
                        {
                            right=l.get(index);
                            left=l.get(index-1);
                        }

                        l=wallColRow.get(j);
                        low=0;
                        high=l.size()-1;
                        index=0;
                         while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>i)
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
                        int wallleft=-1,wallright=-1;
                        if(index==0)
                        {
                             wallright=l.get(0);
                        }
                        else if(index==l.size())
                        {
                            wallleft=l.get(l.size()-1);
                        }
                        else
                        {
                            wallright=l.get(index);
                            wallleft=l.get(index-1);
                        }
                        if((left!=-1 && wallleft==-1 ) || (right!=-1 && wallright==-1))
                        {
                           
                            flag=1;
                            continue;
                        }
                        if(left>wallleft || (right<wallright && right!=-1))
                        {
                            flag=1;
                            continue;
                        }
                    }

                   if(flag==0)
                   {
                       count++;
                   }
                }
            }
        }

        return count;

    }
}
