class Solution {
    public List<String> letterCombinations(String digits) {
        String arr[]={"a b c","d e f","g h i","j k l","m n o","p q r s","t u v","w x y z"};
        ArrayList<String> result=new ArrayList<String>();
        if(digits.length()==1)
        {
            String p[]=arr[Integer.parseInt(digits)-2].split(" ");
            for(int i=0;i<p.length;i++)
            {
                result.add(p[i]);
            }
        }
        else if(digits.length()==2)
        {
            String p[]=arr[Integer.parseInt(digits.substring(0,1))-2].split(" ");
            String q[]=arr[Integer.parseInt(digits.substring(1,2))-2].split(" ");
            for(int i=0;i<p.length;i++)
            {
                for(int j=0;j<q.length;j++)
                {
                    result.add(p[i]+q[j]);
                }
            }
        }
        else if(digits.length()==3)
        {
            String p[]=arr[Integer.parseInt(digits.substring(0,1))-2].split(" ");
            String q[]=arr[Integer.parseInt(digits.substring(1,2))-2].split(" ");
            String r[]=arr[Integer.parseInt(digits.substring(2,3))-2].split(" ");
            for(int i=0;i<p.length;i++)
            {
                for(int j=0;j<q.length;j++)
                {
                    for(int k=0;k<r.length;k++)
                    {
                        result.add(p[i]+q[j]+r[k]);
                    }
                }
            }
        }
        else if(digits.length()==4)
        {
            String p[]=arr[Integer.parseInt(digits.substring(0,1))-2].split(" ");
            String q[]=arr[Integer.parseInt(digits.substring(1,2))-2].split(" ");
            String r[]=arr[Integer.parseInt(digits.substring(2,3))-2].split(" ");
            String s[]=arr[Integer.parseInt(digits.substring(3,4))-2].split(" ");
            for(int i=0;i<p.length;i++)
            {
                for(int j=0;j<q.length;j++)
                {
                    for(int k=0;k<r.length;k++)
                    {
                        for(int l=0;l<s.length;l++)
                        {
                          result.add(p[i]+q[j]+r[k]+s[l]);
                        }
                    }
                }
            }
        }
        return result;
    }
}
