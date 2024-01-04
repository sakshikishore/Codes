public class Node
{
   long price;
    char c;
    public Node(long price, char c)
    {
         this.price=price;
         this.c=c;
    }
}
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        HashMap<Character,HashSet<Character>> h=new HashMap<Character,HashSet<Character>>();
        for(int i=0;i<original.length;i++)
        {
           String str=original[i]+" "+changed[i];
            if(!h.containsKey(original[i]))
            {
                HashSet<Character> hset=new HashSet<Character>();
                hset.add(changed[i]);
                h.put(original[i],hset);
            }
            else
            {
                HashSet<Character> hset=h.get(original[i]);
               if(!hset.contains(changed[i]))
               {
                  
                   hset.add(changed[i]);
                   h.put(original[i],hset);

               }
                
            }
            if(!map.containsKey(str))
            {
               map.put(str,cost[i]);
            }
            else
            {
                if(map.get(str)>cost[i])
                {
                     map.put(str,cost[i]);
                }
            }
        }
        long totalCost=0;
        long arr[][]=new long[26][26];
        for(int i=0;i<source.length();i++)
        {
            if(source.charAt(i)!=target.charAt(i))
            {
                if(arr[source.charAt(i)-'a'][target.charAt(i)-'a']!=0)
                {
                     totalCost+=arr[source.charAt(i)-'a'][target.charAt(i)-'a'];

                     continue;
                }
                int track[]=new int[26];
                Queue<Node> q=new LinkedList<Node>();
                Node node=new Node(0L,source.charAt(i));
                q.add(node);
                track[source.charAt(i)-'a']++;
                int flag=0;
                long p=0;
                while(q.size()>0)
                {
                    node=q.poll();
                    if(h.containsKey(node.c))
                    {
                        HashSet<Character> hset=h.get(node.c);
                        Iterator<Character> itr=hset.iterator();
                        while(itr.hasNext())
                        {
                            char ch=itr.next();
                                if(track[ch-'a']==0)
                                {
                                    track[ch-'a']=1;
                                    if(arr[source.charAt(i)-'a'][ch-'a']>node.price+map.get(node.c+" "+ch) || arr[source.charAt(i)-'a'][ch-'a']==0)
                                    {
                                      arr[source.charAt(i)-'a'][ch-'a']=node.price+map.get(node.c+" "+ch);
                                       Node temp=new Node(node.price+map.get(node.c+" "+ch),ch);
                                       q.add(temp);
                                    }
                                    else
                                    {
                                        Node temp=new Node(arr[source.charAt(i)-'a'][ch-'a'],ch);
                                       q.add(temp);
                                    }
                                 }
                                else
                                {
                                    long prevPrice=arr[source.charAt(i)-'a'][ch-'a'];
                                    long currCost=node.price+map.get(node.c+" "+ch);
                                    if(currCost<prevPrice)
                                    {
                                         arr[source.charAt(i)-'a'][ch-'a']=currCost;
                                         Node temp=new Node(currCost,ch);
                                        q.add(temp);
                                    }
                                }
                            }
                        }
                    }
                if(arr[source.charAt(i)-'a'][target.charAt(i)-'a']==0)
                {
                    return -1;
                }
                else
                {
                    totalCost+=arr[source.charAt(i)-'a'][target.charAt(i)-'a'];
                }
            }
        }
 
        
        return totalCost;
    }
}
