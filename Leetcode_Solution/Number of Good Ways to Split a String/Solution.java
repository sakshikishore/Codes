class Solution {
    public int numSplits(String s) {
        int arr1[]=new int[s.length()];
        ArrayList<Character> l=new ArrayList<Character>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(!l.contains(s.charAt(i)))
            {
                l.add(s.charAt(i));
                count++;
                
            }
          arr1[i]=count;
        }
        
        int arr2[]=new int[s.length()];
        count=0;
        ArrayList<Character> m=new ArrayList<Character>();
        int k=0;
        for(int i=s.length()-1;i>=0;i--)
        {
             if(!m.contains(s.charAt(i)))
            {
                m.add(s.charAt(i));
                count++;
                
            }
          arr2[k]=count;
          k++;
        }
        
        int result=0;
        for(int i=0;i<arr1.length-1;i++)
        {
            if(arr1[i]==arr2[arr1.length-2-i])
            {
                result++;
            }
        }
        
        return result;
        
    }
}
