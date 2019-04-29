/****************************************************************************
 *
 * Created by: James Lee
 * Created on: Apr 2019
 * Created for: ICS4U
 * This program generates a list of 250 value and performs binary search
 *
 ****************************************************************************/

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] arg)
    {
        Random rand = new Random();
        Scanner userInput = new Scanner(System.in);
        int array[] = new int[250];
        int numToFind = 0;
        boolean isValidInput = false;

        // Generates list of 250 numbers, each ranging from 1 to 500
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rand.nextInt(500) + 1;
        }

        // Prints both unsorted and sorted arrays
        System.out.print("List of 250 values: " + Arrays.toString(array) + "\n\n");
        System.out.print("Sorted list of 250 values : " + Arrays.toString(sortArray(array)) + "\n");

        // User enters a number to find in list
        // If in list, computer outputs index of value
        // If not in list, computer outputs a message stating so
        do
        {
            System.out.print("\n" + "Please enter number to find : ");

            try
            {
                numToFind = Integer.parseInt(userInput.nextLine());
                if (numToFind >= 0 && numToFind <= 500)
                {
                    isValidInput = true;
                }
                else
                {
                    System.out.print("\n" + "Error : Invalid input!");
                    isValidInput = false;
                }
            }
            catch(NumberFormatException nfe)
            {
                System.out.print("\n" + "Error : Invalid input!");
                isValidInput = false;
            }
        }
        while(!isValidInput);

        System.out.print(binarySearch(sortArray(array), numToFind, 0, 0, array.length - 1));

    }

    public static int[] sortArray(int array[])
    {
        // For every index in list
        for (int j = 0; j < array.length; j++)
        {
            // Look at the other indexes, and compares its values
            for (int k = 0; k < array.length; k++)
            {
                if (array[j] < array[k])
                {
                    // If greater, then values switch place
                    int replace;
                    replace = array[j];
                    array[j] = array[k];
                    array[k] = replace;
                }
            }
        }
    return array;
    }

    public static String binarySearch(int num[], int numToFind, int i, int j, int k)
    {
        // i is the lowest value
        // j is the middle value
        // k is the high value

        if (i <= k)
        {
            //Middle value is the average of the high and low values
            j = (i + k)/2;
            if (num[j] == numToFind)
            {
                String result = "Found at position " + (j+1);
                return result;
            }
            // If the number is lower than the middle value
            else if (num[j] > numToFind)
            {
                return binarySearch(num, numToFind, i, j,j-1);
            }
            // If the number is higher than the middle value
            else if (num[j] < numToFind)
            {
                return binarySearch(num, numToFind, j+1, j, k);
            }
            // If the low value is greater than the higher value
            else if (i > k)
            {
                String result = "Not found";
                return result;
            }
        }
        return "Not found";
    }
}
