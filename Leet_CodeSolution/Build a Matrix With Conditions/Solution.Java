class Node
{
    int x,rank;
    public Node(int a, int r)
    {
        x=a;
        rank=r;
    }
}
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
         HashMap<Integer,ArrayList<Integer>> row=new HashMap<Integer,ArrayList<Integer>>();
         HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<rowConditions.length;i++)
        {
            if(!row.containsKey(rowConditions[i][0]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(rowConditions[i][1]);
                row.put(rowConditions[i][0],list);
            }
            else
            {
                ArrayList<Integer> list=row.get(rowConditions[i][0]);
                list.add(rowConditions[i][1]);
                row.put(rowConditions[i][0],list);
            }
            if(!h1.containsKey(rowConditions[i][1]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(rowConditions[i][0]);
                h1.put(rowConditions[i][1],list); 
            }
            else
            {
                ArrayList<Integer> list=h1.get(rowConditions[i][1]);
                list.add(rowConditions[i][0]);
                h1.put(rowConditions[i][1],list);
            }
        }
       
         HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
         Queue<Node> q=new LinkedList<Node>();
        for(int i=1;i<=k;i++)
        {
            if(!row.containsKey(i))
            {
                q.add(new Node(i,0));
                if(!h2.containsKey(0))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    h2.put(0,list);
                }
                else
                {
                     ArrayList<Integer> list=h2.get(0);
                    list.add(i);
                    h2.put(0,list);
                }
            }
        }
        
        if(q.size()==0)
        {
            int result[][]=new int[0][0];
            return result;
        }
        int maxRank=0;
        while(q.size()>0)
        {
            Node node=q.poll();
             
            if(node.rank>maxRank)
            {
                maxRank=node.rank;
            }
            if(h1.containsKey(node.x))
            {
            ArrayList<Integer> l=h1.get(node.x);
            for(int i=0;i<l.size();i++)
            {
                 ArrayList<Integer> list=row.get(l.get(i));
                 if(list.size()==1)
                 {
                    row.remove(l.get(i));
                    q.add(new Node(l.get(i),node.rank+1));
                     if(!h2.containsKey(node.rank+1))
                    {
                        ArrayList<Integer> al=new ArrayList<Integer>();
                        al.add(l.get(i));
                        h2.put(node.rank+1,al);
                    }
                    else
                    {
                        ArrayList<Integer> al=h2.get(node.rank+1);
                       al.add(l.get(i));
                        h2.put(node.rank+1,al);
                    }
                 }
                 else
                 {
                    int index=list.indexOf(node.x);
                    list.remove(index);
                    row.put(l.get(i),list);
                 }
            }
            }
        }
       
        ArrayList<Integer> rowList=new ArrayList<Integer>();
        for(int i=maxRank;i>=0;i--)
        {
            ArrayList<Integer> l=h2.get(i);
            for(int j=0;j<l.size();j++)
            {
                rowList.add(l.get(j));
            }
        }
       if(rowList.size()<k)
        {
          int result[][]=new int[0][0];
            return result;  
        }

        HashMap<Integer,ArrayList<Integer>> col=new HashMap<Integer,ArrayList<Integer>>();
        h1=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<colConditions.length;i++)
        {
            if(!col.containsKey(colConditions[i][0]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(colConditions[i][1]);
                col.put(colConditions[i][0],list);
            }
            else
            {
                ArrayList<Integer> list=col.get(colConditions[i][0]);
                list.add(colConditions[i][1]);
                col.put(colConditions[i][0],list); 
            }
            if(!h1.containsKey(colConditions[i][1]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(colConditions[i][0]);
                h1.put(colConditions[i][1],list);
            }
            else
            {
                ArrayList<Integer> list=h1.get(colConditions[i][1]);
                list.add(colConditions[i][0]);
                h1.put(colConditions[i][1],list);
            }
        }
   
        h2=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=k;i++)
        {
            if(!col.containsKey(i))
            {
                q.add(new Node(i,0));
                if(!h2.containsKey(0))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    h2.put(0,list);
                }
                else
                {
                     ArrayList<Integer> list=h2.get(0);
                    list.add(i);
                    h2.put(0,list);
                }
            }
        }
        if(q.size()==0)
        {
            int result[][]=new int[0][0];
            return result;
        }
        maxRank=0;
        while(q.size()>0)
        {
            Node node=q.poll();
            if(node.rank>maxRank)
            {
                maxRank=node.rank;
            }
           
            if(h1.containsKey(node.x))
            {
            ArrayList<Integer> l=h1.get(node.x);
            for(int i=0;i<l.size();i++)
            {
                 ArrayList<Integer> list=col.get(l.get(i));
                 if(list.size()==1)
                 {
                    col.remove(l.get(i));
                    q.add(new Node(l.get(i),node.rank+1));
                     if(!h2.containsKey(node.rank+1))
                    {
                        ArrayList<Integer> al=new ArrayList<Integer>();
                        al.add(l.get(i));
                        h2.put(node.rank+1,al);
                    }
                    else
                    {
                        ArrayList<Integer> al=h2.get(node.rank+1);
                        al.add(l.get(i));
                        h2.put(node.rank+1,al);
                    }
                 }
                 else
                 {
                    int index=list.indexOf(node.x);
                    list.remove(index);
                    col.put(l.get(i),list);
                 }
            }
            }
        }
        ArrayList<Integer> colList=new ArrayList<Integer>();
        for(int i=maxRank;i>=0;i--)
        {
            ArrayList<Integer> l=h2.get(i);
            for(int j=0;j<l.size();j++)
            {
                colList.add(l.get(j));
            }
        }
        if(colList.size()<k)
        {
          int result[][]=new int[0][0];
            return result;  
        }
     
        int result[][]=new int[k][k];
        for(int i=0;i<rowList.size();i++)
        {
            int index=colList.indexOf(rowList.get(i));
            
            result[i][index]=rowList.get(i);
        }

        return result;



    }
}
