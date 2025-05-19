class Node {
    int x, y;

    public Node(int i, int j) {
        x = i;
        y = j;
    }
}

class Solution {
    public int minMoves(String[] matrix) {
        int ch[] = new int[26];
        HashMap<Character, ArrayList<Node>> map = new HashMap<Character, ArrayList<Node>>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                if (matrix[i].charAt(j) >= 'A' && matrix[i].charAt(j) <= 'Z') {
                    if (!map.containsKey(matrix[i].charAt(j))) {
                        ArrayList<Node> l = new ArrayList<Node>();
                        l.add(new Node(i, j));
                        map.put(matrix[i].charAt(j), l);
                    } else {
                        ArrayList<Node> l = map.get(matrix[i].charAt(j));
                        l.add(new Node(i, j));
                        map.put(matrix[i].charAt(j), l);
                    }
                }
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        int arr[][] = new int[matrix.length][matrix[0].length()];
        int a[][] = new int[matrix.length][matrix[0].length()];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }
        if(matrix[0].charAt(0)>='A' && matrix[0].charAt(0)<='Z')
        {
             char c = matrix[0].charAt(0);
             ArrayList<Node> l = map.get(c);
                for (int j = 0; j < l.size(); j++) {
                    Node node = l.get(j);
                    arr[node.x][node.y]=0;
                    a[node.x][node.y]=1;
                    q.add(new Node(node.x,node.y));
                }
             ch[c-'A']=1;
        }
        else
        {
           arr[0][0] = 0;
           a[0][0] = 1;
           q.add(new Node(0, 0));
        }
        while (q.size() > 0) {
            int len=q.size();
            for(int i=0;i<len;i++)
                {
                    Node node=q.poll();
                    if(node.x==arr.length-1 && node.y==arr[0].length-1)
                    {
                        return arr[node.x][node.y];
                    }
                    if(node.x-1>=0 && matrix[node.x-1].charAt(node.y)!='#')
                    {
                        if(matrix[node.x-1].charAt(node.y)=='.')
                        {
                            if(arr[node.x-1][node.y]==-1)
                            {
                            arr[node.x-1][node.y]=arr[node.x][node.y]+1;
                            a[node.x-1][node.y]=1;
                            q.add(new Node(node.x-1,node.y));
                            }
                        }
                        else
                        {
                            char c=matrix[node.x-1].charAt(node.y);
                            if(ch[c-'A']==0)
                            {
                                ArrayList<Node> l = map.get(c);
                                for (int j = 0; j < l.size(); j++) {
                                    Node p = l.get(j);
                                    arr[p.x][p.y]=arr[node.x][node.y]+1;
                                    a[p.x][p.y]=1;
                                    q.add(new Node(p.x,p.y));
                                }
                                ch[c-'A']=1;
                            }
                        }
                    }
                    if(node.y-1>=0 && matrix[node.x].charAt(node.y-1)!='#')
                    {
                        if(matrix[node.x].charAt(node.y-1)=='.')
                        {
                            if(arr[node.x][node.y-1]==-1)
                            {
                            arr[node.x][node.y-1]=arr[node.x][node.y]+1;
                            a[node.x][node.y-1]=1;
                            q.add(new Node(node.x,node.y-1));
                            }
                        }
                        else
                        {
                            char c=matrix[node.x].charAt(node.y-1);
                            if(ch[c-'A']==0)
                            {
                                ArrayList<Node> l = map.get(c);
                                for (int j = 0; j < l.size(); j++) {
                                    Node p = l.get(j);
                                    arr[p.x][p.y]=arr[node.x][node.y]+1;
                                    a[p.x][p.y]=1;
                                    q.add(new Node(p.x,p.y));
                                }
                                ch[c-'A']=1;
                            }
                        }
                    }
                    if(node.y+1<arr[0].length && matrix[node.x].charAt(node.y+1)!='#')
                    {
                        if(matrix[node.x].charAt(node.y+1)=='.')
                        {
                            if(arr[node.x][node.y+1]==-1)
                            {
                                arr[node.x][node.y+1]=arr[node.x][node.y]+1;
                                a[node.x][node.y+1]=1;
                                q.add(new Node(node.x,node.y+1));
                            }
                        }
                        else
                        {
                            char c=matrix[node.x].charAt(node.y+1);
                            if(ch[c-'A']==0)
                            {
                                ArrayList<Node> l = map.get(c);
                                for (int j = 0; j < l.size(); j++) {
                                    Node p = l.get(j);
                                    arr[p.x][p.y]=arr[node.x][node.y]+1;
                                    a[p.x][p.y]=1;
                                    q.add(new Node(p.x,p.y));
                                }
                                ch[c-'A']=1;
                            }
                        }
                    }
                    if(node.x+1<arr.length && matrix[node.x+1].charAt(node.y)!='#')
                    {
                        if(matrix[node.x+1].charAt(node.y)=='.')
                        {
                            if(arr[node.x+1][node.y]==-1)
                            {
                            arr[node.x+1][node.y]=arr[node.x][node.y]+1;
                            a[node.x+1][node.y]=1;
                            q.add(new Node(node.x+1,node.y));
                            }
                        }
                        else
                        {
                            char c=matrix[node.x+1].charAt(node.y);
                            if(ch[c-'A']==0)
                            {
                                ArrayList<Node> l = map.get(c);
                                for (int j = 0; j < l.size(); j++) {
                                    Node p = l.get(j);
                                    arr[p.x][p.y]=arr[node.x][node.y]+1;
                                    a[p.x][p.y]=1;
                                    q.add(new Node(p.x,p.y));
                                }
                                ch[c-'A']=1;
                            }
                        }
                    }
                }
        }

        return -1;

    }
}
