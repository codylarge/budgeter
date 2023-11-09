package utils;

public class Utils
{
    public static int getIntArraySum(int[] array)
    {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
