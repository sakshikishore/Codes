class Solution {
    public int countPathsWithXorValue(int[][] grid, int target) {
       List<HashMap<Integer,Long>> list = new ArrayList();
        for (int i = grid.length - 1; i >= 0; i--) {
            List<HashMap<Integer,Long>> list1 = new ArrayList();
            for (int j = grid[0].length - 1; j >= 0; j--) {
                HashMap<Integer,Long> map=new HashMap<Integer,Long>();
                if (i == grid.length - 1) {
                    if (j == grid[0].length - 1) {
                        map.put(grid[i][j],1l);
                        list1.add(map);
                    } else {
                       HashMap<Integer,Long> h1=list1.get(0);
                       for(int k=0;k<16;k++)
                           {
                               if(h1.containsKey(k))
                               {
                                   map.put(k^grid[i][j],1l);
                                   break;
                               }
                           }

                        list1.add(0,map);
                    }
                } else if (j == grid[0].length - 1) {
                     HashMap<Integer,Long> h1=list.get(j);
                     for(int k=0;k<16;k++)
                           {
                               if(h1.containsKey(k))
                               {
                                   map.put(k^grid[i][j],1l);
                                   break;
                               }
                           }
                    
                    list1.add(map);
                } else {
                     HashMap<Integer,Long> h1=list1.get(0);
                    for (int k = 0; k <16; k++) {
                        if(h1.containsKey(k))
                        {
                            long x=h1.get(k);
                            int p=grid[i][j]^k;
                             if(map.containsKey(p))
                            {
                                 long t=(map.get(p)+x)%(1000000007);
                                  map.put(p,t);
                            }
                            else
                            {
                                map.put(p,x);
                            }
                        }
                    }
                   h1=list.get(j);
                    for (int k = 0; k <16; k++) {
                        if(h1.containsKey(k))
                        {
                            long x=h1.get(k);
                           
                            int p=grid[i][j]^k;
                            if(map.containsKey(p))
                            {
                            long t=(map.get(p)+x)%(1000000007);
                            map.put(p,t);
                            }
                            else
                            {
                                map.put(p,x);
                            }
                        }
                    }
                    list1.add(0, map);
                }

            }

            list = list1;
        }
        long result = 0;
        HashMap<Integer,Long> h1=list.get(0);
        if(h1.containsKey(target))
        {
            result=h1.get(target);
        }
        return (int) (result % 1000000007);
    }
}
