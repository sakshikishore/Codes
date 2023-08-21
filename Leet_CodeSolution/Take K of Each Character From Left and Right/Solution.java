class Solution {
    public int takeCharacters(String s, int k) {
        if(k==0)
        {
            return 0;
        }
        if(k*3>s.length())
        {
            return -1;
        }
        else
        {
            int result=Integer.MAX_VALUE;
            int a=0,b=0,c=0;
            HashMap<Character,HashMap<Integer,Integer>> h1= new HashMap<Character,HashMap<Integer,Integer>>();
            HashMap<Integer,HashMap<Character,Integer>> h= new HashMap<Integer,HashMap<Character,Integer>>();
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='a')
                {
                     a++;
                     if(!h1.containsKey('a'))
                     {
                        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); // Key =count of a, Value=Index
                        map.put(a,i);
                        h1.put(s.charAt(i),map);
                     }
                     else
                     {
                       HashMap<Integer,Integer> map=h1.get('a'); // Key =count of a, Value=Index
                        map.put(a,i);
                        h1.put(s.charAt(i),map);
                     }
                }
                else if(s.charAt(i)=='b')
                {
                     b++;
                     if(!h1.containsKey('b'))
                     {
                        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
                        map.put(b,i);
                        h1.put(s.charAt(i),map);
                     }
                     else
                     {
                        HashMap<Integer,Integer> map=h1.get('b');
                        map.put(b,i);
                        h1.put(s.charAt(i),map);
                     }
                }
                else
                {
                     c++;
                     if(!h1.containsKey('c'))
                     {
                        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
                        map.put(c,i);
                        h1.put(s.charAt(i),map);
                     }
                     else
                     {
                        HashMap<Integer,Integer> map=h1.get('c');
                        map.put(c,i);
                        h1.put(s.charAt(i),map);
                     }
                }
                HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
                hmap.put('a',a);
                hmap.put('b',b);
                hmap.put('c',c);
                h.put(i,hmap);
            }

             if(!h1.containsKey('a') || !h1.containsKey('b') || !h1.containsKey('c'))
            {
                return -1;
            }
            if(!h1.get('a').containsKey(k) || !h1.get('b').containsKey(k) || !h1.get('c').containsKey(k))
            {
                return -1;
            }

            a=0;
            b=0;
            c=0;
            HashMap<Character,HashMap<Integer,Integer>> h2= new HashMap<Character,HashMap<Integer,Integer>>();
            for(int i=s.length()-1;i>=0;i--)
            {
              if(s.charAt(i)=='a')
                {
                     a++;
                     if(!h2.containsKey('a'))
                     {
                        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); // Key =count of a, Value=Index
                        map.put(a,i);
                        h2.put(s.charAt(i),map);
                     }
                     else
                     {
                       HashMap<Integer,Integer> map=h2.get('a'); // Key =count of a, Value=Index
                        map.put(a,i);
                        h2.put(s.charAt(i),map);
                     }
                }
                else if(s.charAt(i)=='b')
                {
                     b++;
                     if(!h2.containsKey('b'))
                     {
                        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
                        map.put(b,i);
                        h2.put(s.charAt(i),map);
                     }
                     else
                     {
                        HashMap<Integer,Integer> map=h2.get('b');
                        map.put(b,i);
                        h2.put(s.charAt(i),map);
                     }
                }
                else
                {
                     c++;
                     if(!h2.containsKey('c'))
                     {
                        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
                        map.put(c,i);
                        h2.put(s.charAt(i),map);
                     }
                     else
                     {
                        HashMap<Integer,Integer> map=h2.get('c');
                        map.put(c,i);
                        h2.put(s.charAt(i),map);
                     }
                }
            }
            int x=h1.get('a').get(k);
            int y=h1.get('b').get(k);
            int z=h1.get('c').get(k);
            int max=Math.max(x,y);
            max=Math.max(max,z);
            result=max+1;
            a=h.get(max).get('a');
            b=h.get(max).get('b');
            c=h.get(max).get('c');
            for(int i=max;i>=0;i--)
            {
                if(s.charAt(i)=='a')
                {
                    a--;
                }
                else if(s.charAt(i)=='b')
                {
                    b--;
                }
                else if(s.charAt(i)=='c')
                {
                    c--;
                }
                int req_a=k-a;
                int req_b=k-b;
                int req_c=k-c;
                x=s.length();
                y=s.length();
                z=s.length();
                if(h2.get('a').containsKey(req_a))
                {
                    x=h2.get('a').get(req_a);
                }
                if(h2.get('b').containsKey(req_b))
                {
                    y=h2.get('b').get(req_b);
                }
                if(h2.get('c').containsKey(req_c))
                {
                    z=h2.get('c').get(req_c);
                }
                int min=Math.min(x,y);
                min=Math.min(min,z);
                if(i+(s.length()-min)<result)
                {
                    result=i+(s.length()-min);
                }
            }

            return result;


        }
        
    }
}
