class Solution {
    public double[] internalAngles(int[] sides) {
        double result[] = new double[0];
        if (sides[0] + sides[1] <= sides[2] || sides[0] + sides[2] <= sides[1] || sides[1] + sides[2] <= sides[0]) {
            return result;
        }
        result = new double[3];

        double cosA = (((sides[1] * sides[1] * 1.0) + (sides[2] * sides[2])) - (sides[0] * sides[0]))
                / (2 * sides[1] * sides[2]);
        double cosB = (((sides[0] * sides[0] * 1.0) + (sides[2] * sides[2])) - (sides[1] * sides[1]))
                / (2 * sides[0] * sides[2]);
        double cosC = (((sides[1] * sides[1] * 1.0) + (sides[0] * sides[0])) - (sides[2] * sides[2]))
                / (2 * sides[1] * sides[0]);

        result[0] = Math.toDegrees(Math.acos(cosA));
        result[1] = Math.toDegrees(Math.acos(cosB));
        result[2] = Math.toDegrees(Math.acos(cosC));

        Arrays.sort(result);
        return result;
    }
}
