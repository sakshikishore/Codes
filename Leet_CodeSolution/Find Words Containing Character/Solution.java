class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        String str=Character.toString(x);
        for(int i=0;i<words.length;i++)
        {
            if(words[i].contains(str))
            {
                result.add(i);
            }
        }

        return result;
    }
}
