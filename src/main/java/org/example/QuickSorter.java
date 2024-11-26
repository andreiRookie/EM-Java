package org.example;

public class QuickSorter {

    public void sort(int[] array, int firstIndex, int lastIndex) {

        if (firstIndex< lastIndex) {

            int pivotIndex = splitArray(array, firstIndex, lastIndex);

            sort(array, pivotIndex + 1, lastIndex);
            sort(array, firstIndex, pivotIndex - 1);

        }
    }

    private int splitArray(int[] array, int firstIndex, int lastIndex) {

        int middleIndex = array.length / 2;

        int pivotValue = array[middleIndex];
        int tempVal = array[middleIndex];

        array[middleIndex] = array[lastIndex];
        array[lastIndex] = tempVal;

        int newFirstndex = (firstIndex - 1);
        for (int i = firstIndex; i < lastIndex; i++) {

            if (array[i] < pivotValue) {
                newFirstndex++;

                tempVal = array[newFirstndex];
                array[newFirstndex] = array[i];
                array[i] = tempVal;
            }
        }
        newFirstndex++;

        tempVal = array[newFirstndex];
        array[newFirstndex] = array[lastIndex];
        array[lastIndex] = tempVal;

        return newFirstndex;
    }
}
