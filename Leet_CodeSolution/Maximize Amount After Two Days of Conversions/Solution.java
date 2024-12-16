class Node
    {
        String curr;
        double rate;
        public Node(String c, double r)
        {
            curr=c;
            rate=r;
        }
    }
class Solution {
    public void Solve(String s, double rate, HashMap<String,ArrayList<Node>> h2, HashMap<String,Double> h)
    {
            Queue<String> q=new LinkedList<String>();
            h.put(s,rate);
            q.add(s);
            while(q.size()>0)
            {
                s=q.poll();
                rate=h.get(s);
                if(h2.containsKey(s))
                {
                    ArrayList<Node> list=h2.get(s);
                    for(int i=0;i<list.size();i++)
                        {
                            Node node=list.get(i);
                            if(h.containsKey(node.curr))
                            {
                                if(rate*node.rate>h.get(node.curr))
                                {
                                    h.put(node.curr,rate*node.rate);
                                    q.add(node.curr);
                                }
                            }
                            else
                            {
                                h.put(node.curr,rate*node.rate);
                                q.add(node.curr);
                            }
                        }
                }
            }
    }
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        double result=0;
        HashMap<String,ArrayList<Node>> h1=new HashMap<String,ArrayList<Node>>();
        HashMap<String,ArrayList<Node>> h2=new HashMap<String,ArrayList<Node>>();
        for(int i=0;i<pairs1.size();i++)
            {
                String str1=pairs1.get(i).get(0);
                String str2=pairs1.get(i).get(1);
                if(!h1.containsKey(str1))
                {
                    ArrayList<Node> list=new ArrayList<Node>();
                    Node node=new Node(str2,rates1[i]);
                    list.add(node);
                    h1.put(str1,list);
                }
                else
                {
                    ArrayList<Node> list=h1.get(str1);
                    Node node=new Node(str2,rates1[i]);
                    list.add(node);
                    h1.put(str1,list);
                }    
                if(!h1.containsKey(str2))
                {
                    ArrayList<Node> list=new ArrayList<Node>();
                    Node node=new Node(str1,1/rates1[i]);
                    list.add(node);
                    h1.put(str2,list);
                }
                else
                {
                    ArrayList<Node> list=h1.get(str2);
                    Node node=new Node(str1,1/rates1[i]);
                    list.add(node);
                    h1.put(str2,list);
                }    
            }

        for(int i=0;i<pairs2.size();i++)
            {
                String str1=pairs2.get(i).get(0);
                String str2=pairs2.get(i).get(1);
                if(!h2.containsKey(str1))
                {
                    ArrayList<Node> list=new ArrayList<Node>();
                    Node node=new Node(str2,rates2[i]);
                    list.add(node);
                    h2.put(str1,list);
                }
                else
                {
                    ArrayList<Node> list=h2.get(str1);
                    Node node=new Node(str2,rates2[i]);
                    list.add(node);
                    h2.put(str1,list);
                }   
                if(!h2.containsKey(str2))
                {
                    ArrayList<Node> list=new ArrayList<Node>();
                    Node node=new Node(str1,1/rates2[i]);
                    list.add(node);
                    h2.put(str2,list);
                }
                else
                {
                    ArrayList<Node> list=h2.get(str2);
                    Node node=new Node(str1,1/rates2[i]);
                    list.add(node);
                    h2.put(str2,list);
                }   
            }
            HashMap<String,Double> map=new HashMap<String,Double>();
            Queue<String> q=new LinkedList<String>();
            map.put(initialCurrency,1.0);
            q.add(initialCurrency);
            while(q.size()>0)
            {
                String s=q.poll();
                double rate=map.get(s);
                HashMap<String,Double> h=new HashMap<String,Double>();
                Solve(s,rate,h2,h);
                if(h.containsKey(initialCurrency))
                {
                    result=Math.max(result,h.get(initialCurrency));
                }
                if(h1.containsKey(s))
                {
                    ArrayList<Node> list=h1.get(s);
                    for(int i=0;i<list.size();i++)
                        {
                            Node node=list.get(i);
                            if(map.containsKey(node.curr))
                            {
                                if(rate*node.rate>map.get(node.curr))
                                {
                                    map.put(node.curr,rate*node.rate);
                                    q.add(node.curr);
                                }
                            }
                            else
                            {
                                map.put(node.curr,rate*node.rate);
                                q.add(node.curr);
                            }
                        }
                }
            }

        return Math.max(result,map.get(initialCurrency));
        
        
    }
}
