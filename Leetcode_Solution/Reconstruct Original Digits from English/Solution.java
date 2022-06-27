class Solution {
    public String originalDigits(String s) {
        int arr[]=new int[10];
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                h.put(s.charAt(i),1);
            }
            else
            {
                h.put(s.charAt(i),h.get(s.charAt(i))+1);
            }
        }
        // For Zero
        if(h.containsKey('z'))
        {
            int x=h.get('z');
            arr[0]=x;
            h.remove('z');
            h.put('e',h.get('e')-x);
            if(h.get('e')==0)
            {
                h.remove('e');
            }
             h.put('r',h.get('r')-x);
            if(h.get('r')==0)
            {
                h.remove('r');
            }
             h.put('o',h.get('o')-x);
            if(h.get('o')==0)
            {
                h.remove('o');
            }
        }
        // For Two
        if(h.containsKey('w'))
        {
            int x=h.get('w');
            arr[2]=x;
            h.remove('w');
            h.put('t',h.get('t')-x);
            if(h.get('t')==0)
            {
                h.remove('t');
            }
             h.put('o',h.get('o')-x);
            if(h.get('o')==0)
            {
                h.remove('o');
            }
            
        }
        // For Four
        if(h.containsKey('u'))
        {
            int x=h.get('u');
            arr[4]=x;
            h.remove('u');
            h.put('f',h.get('f')-x);
            if(h.get('f')==0)
            {
                h.remove('f');
            }
            h.put('o',h.get('o')-x);
            if(h.get('o')==0)
            {
                h.remove('o');
            }
            h.put('r',h.get('r')-x);
            if(h.get('r')==0)
            {
                h.remove('r');
            }
            
            
        }
        // For Six
        if(h.containsKey('x'))
        {
            int x=h.get('x');
            arr[6]=x;
            h.remove('x');
            h.put('s',h.get('s')-x);
            if(h.get('s')==0)
            {
                h.remove('s');
            }
            h.put('i',h.get('i')-x);
            if(h.get('i')==0)
            {
                h.remove('i');
            }         
            
        }
        // For Eight
         if(h.containsKey('g'))
         {
            int x=h.get('g');
            arr[8]=x;
            h.remove('g');
            h.put('e',h.get('e')-x);
            if(h.get('e')==0)
            {
                h.remove('e');
            }
            h.put('i',h.get('i')-x);
            if(h.get('i')==0)
            {
                h.remove('i');
            }   
            h.put('h',h.get('h')-x);
            if(h.get('h')==0)
            {
                h.remove('h');
            }
            h.put('t',h.get('t')-x);
            if(h.get('t')==0)
            {
                h.remove('t');
            }         
            
        }   
        // For Three
        if(h.containsKey('t'))
        {
            int x=h.get('t');
            arr[3]=x;
            h.remove('t');
            h.put('h',h.get('h')-x);
            if(h.get('h')==0)
            {
                h.remove('h');
            }
            h.put('r',h.get('r')-x);
            if(h.get('r')==0)
            {
                h.remove('r');
            }
            h.put('e',h.get('e')-(2*x));
            if(h.get('e')==0)
            {
                h.remove('e');
            }
        }
                          
        // For Five
        if(h.containsKey('f'))
        {
           int x=h.get('f');
           arr[5]=x;
           h.remove('f');
           h.put('i',h.get('i')-x);
            if(h.get('i')==0)
            {
                h.remove('i');
            }  
            h.put('e',h.get('e')-x);
            if(h.get('e')==0)
            {
                h.remove('e');
            }
             h.put('v',h.get('v')-x);
            if(h.get('v')==0)
            {
                h.remove('v');
            }
        }
        
        // For One
        if(h.containsKey('o'))
        {
             int x=h.get('o');
             arr[1]=x;
             h.remove('o');
            h.put('e',h.get('e')-x);
            if(h.get('e')==0)
            {
                h.remove('e');
            }
             h.put('n',h.get('n')-x);
            if(h.get('n')==0)
            {
                h.remove('n');
            }
        }
        // For Seven             
        if(h.containsKey('s'))
        {
           int x=h.get('s');
            arr[7]=x;
            h.remove('s');
            h.put('v',h.get('v')-x);
            if(h.get('v')==0)
            {
                h.remove('v');
            }
            h.put('n',h.get('n')-x);
            if(h.get('n')==0)
            {
                h.remove('n');
            }
            h.put('e',h.get('e')-(2*x));
            if(h.get('e')==0)
            {
                h.remove('e');
            }                 
        }
        // For Nine
         if(h.containsKey('i'))
         {
            int x=h.get('i');
            arr[9]=x;                  
         }
             
        String str="";
         for(int i=0;i<10;i++)
         {
                    for(int j=0;j<arr[i];j++)
                    {
                        str=str+Integer.toString(i);
                    }
         }
        
        return str;
    }
}
