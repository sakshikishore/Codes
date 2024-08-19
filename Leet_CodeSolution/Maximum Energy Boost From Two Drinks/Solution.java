class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
      long arr1[]=new long[energyDrinkA.length];
      long arr2[]=new long[energyDrinkB.length];
      arr1[0]=energyDrinkA[0]*1l;
      arr1[1]=energyDrinkA[1]+arr1[0];
      arr2[0]=energyDrinkB[0]*1l;
      arr2[1]=energyDrinkB[1]+arr2[0];
      for(int i=2;i<energyDrinkA.length;i++)
      {
        arr1[i]=Math.max(arr1[i-1],arr2[i-2])+energyDrinkA[i];
        arr2[i]=Math.max(arr2[i-1],arr1[i-2])+energyDrinkB[i];
      }

      return Math.max(arr1[arr1.length-1],arr2[arr2.length-1]);

    }
}
