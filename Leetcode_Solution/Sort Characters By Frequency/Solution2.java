class Solution {
    public String frequencySort(String s) {
       int ch1[]=new int[26];
       int ch2[]=new int[26];
       int ch3[]=new int[10];
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)>='a' && s.charAt(i)<='z')
           {
            ch1[s.charAt(i)-'a']++;
           }
           else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
           {
               ch2[s.charAt(i)-'A']++;
           }
           else
           {
               ch3[s.charAt(i)-'0']++;
           }
       }
       PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Integer,String> map=new HashMap<Integer,String>();
       for(int i=0;i<26;i++)
       {
           if(!map.containsKey(ch1[i]))
           {
               String str="";
               str+=(char)(97+i);
               pq.add(ch1[i]);
               map.put(ch1[i],str);
              
           }
           else
           {
                String str=map.get(ch1[i])+(char)(97+i);
                map.put(ch1[i],str);
           }
            if(!map.containsKey(ch2[i]))
           {
               String str="";
               str+=(char)(65+i);
               pq.add(ch2[i]);
               map.put(ch2[i],str);
              
           }
           else
           {
                String str=map.get(ch2[i])+(char)(65+i);
                map.put(ch2[i],str);
           }
       }
       for(int i=0;i<10;i++)
       {
            if(!map.containsKey(ch3[i]))
           {
               String str="";
               str+=Integer.toString(i);
               pq.add(ch3[i]);
               map.put(ch3[i],str);
              
           }
           else
           {
                String str=map.get(ch1[i])+Integer.toString(i);
                map.put(ch3[i],str);
           }
       }
       String res="";
       while(pq.size()>0)
       {
           int x=pq.poll();
           String p=map.get(x);
           for(int j=0;j<p.length();j++)
           {
               for(int k=0;k<x;k++)
               {
                   res+=p.charAt(j);
               }
           }
       }

       return res;
       
    }
}
