class Encrypter {
    HashMap<Character,String> h=new HashMap<Character,String>();
    HashMap<String,Integer> map=new HashMap<String,Integer>();
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i=0;i<keys.length;i++)
        {
            h.put(keys[i],values[i]);
        }
        for(int i=0;i<dictionary.length;i++)
        {
            String str="";
            int flag=0;
            for(int j=0;j<dictionary[i].length();j++)
            {
                if(!h.containsKey(dictionary[i].charAt(j)))
                {
                    flag=1;
                    break;
                }
               str+=h.get(dictionary[i].charAt(j));
            }
            if(flag==0)
            {
                if(!map.containsKey(str))
                {
                    map.put(str,1);
                }
                else
                {
                    map.put(str,map.get(str)+1);
                }
            }
        }
    }
    
    public String encrypt(String word1) {
        String str="";
        for(int i=0;i<word1.length();i++)
        {
            str+=h.get(word1.charAt(i));
        }

        return str;
        
    }
    
    public int decrypt(String word2) {
        if(map.containsKey(word2))
        {
            return map.get(word2);
        }

        return 0;
        
    }
}
