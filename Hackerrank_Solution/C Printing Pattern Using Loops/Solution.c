#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{

    int n;
    scanf("%d", &n);
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<2*n-1;j++)
        {
            if(j<i)
            {
              printf("%d ",n-j);
            }
            else if(j>=(2*n)-i-1)
            {
              int p=(2*n)-2-j;
              printf("%d ",n-p);
            }
            else {
              printf("%d ",n-i);
            }
        }
        printf("\n");
    }
    for(int i=n-2;i>=0;i--)
    {
        for(int j=0;j<2*n-1;j++)
        {
              if(j<i)
            {
              printf("%d ",n-j);
            }
            else if(j>=(2*n)-i-1)
            {
              int p=(2*n)-2-j;
              printf("%d ",n-p);
            }
            else {
              printf("%d ",n-i);
            }
        }
        printf("\n");
    }
    return 0;
}
