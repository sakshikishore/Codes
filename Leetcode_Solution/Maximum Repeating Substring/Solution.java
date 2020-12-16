class Solution {
    public int maxRepeating(String sequence, String word) {
     int count=0;
    String str=word;
     while(sequence.contains(str))
     {
         count++;
         str=str+word;
     }
        
        return count;
        
    }
}
