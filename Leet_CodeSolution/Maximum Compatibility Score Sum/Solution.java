class Solution {
    int max=0;
    public void Solve(int[][] students, int[][] mentors,int visitedMentors[],int index, int score)
    {
       if(index==students.length)
       {
           if(score>max)
           {
               max=score;
           }
           return;
       }
           for(int i=0;i<mentors.length;i++)
           {
               if(visitedMentors[i]==0)
               {
                   visitedMentors[i]=1;
                   int p=0;
                   for(int j=0;j<mentors[i].length;j++)
                   {
                       if(mentors[i][j]==students[index][j])
                       {
                           p++;
                       }
                   }
                   Solve(students,mentors,visitedMentors,index+1,score+p);
                   visitedMentors[i]=0;
               }
           
       }
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int visitedMentors[]=new int[students.length];
        Solve(students,mentors,visitedMentors,0,0);
        return max;

    }
}
