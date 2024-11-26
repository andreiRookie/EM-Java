package org.example;

public class Main {
    public static void main(String[] args) {

        int[] stubArray = new int[] {2, 23, 7, 32, 19, 4, 28, 13, 3, 17, 10, 8};
        System.out.println("Initial array: " + arrayToString(stubArray));

        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sort(stubArray, 0 , stubArray.length-1);

        System.out.println("Sorted array: " + arrayToString(stubArray));
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                sb.append(array[i]).append("; ");
            } else {
                sb.append(array[i]).append(".");
            }
        }
        return sb.toString();
    }
}