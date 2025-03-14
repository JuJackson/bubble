/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.impbubblesort;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ArrayUtilities {

    // Create an array of random integers between 0 and 100
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int j = 0; j < arrayLength; j++) {
            array[j] = random.nextInt(101); // Random integer between 0 and 100
        }
        return array;
    }

    // Write the array to a file, one integer per line
    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                write.write(Integer.toString(num));
                write.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Read integers from a file into an array
    public static int[] readFileToArray(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int[] tempArray = new int[1000]; // Temporary array with a large size
            int count = 0;

            while (scanner.hasNextInt()) {
                tempArray[count++] = scanner.nextInt();
            }

            int[] resultArray = new int[count]; // Copy only the valid elements
            System.arraycopy(tempArray, 0, resultArray, 0, count);
            return resultArray;

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return new int[0]; // Return an empty array on error
        }
    }

    // Sort the array in-place using bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Main function to handle user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the array:");
        int arrayLength = scanner.nextInt();
        int[] array = createRandomArray(arrayLength);

        System.out.println("Enter the filename to save the array:");
        String filename = scanner.next();
        writeArrayToFile(array, filename);

        System.out.println("Array written to file: " + filename);

        System.out.println("Reading the array back from file...");
        int[] readArray = readFileToArray(filename);

        System.out.println("Sorting the array...");
        bubbleSort(readArray);

        System.out.println("Sorted array:");
        for (int num : readArray) {
            System.out.print(num + " ");
        }
    }
}

/**
 *
 * @author julian Jackso
 */
