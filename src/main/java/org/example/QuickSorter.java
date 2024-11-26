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

        int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

        int pivotValue = array[middleIndex];
        int tempVal = array[middleIndex];

        array[middleIndex] = array[lastIndex];
        array[lastIndex] = tempVal;

        int newPivotndex = (firstIndex - 1);
        for (int i = firstIndex; i < lastIndex; i++) {

            if (array[i] < pivotValue) {
                newPivotndex++;

                tempVal = array[newPivotndex];
                array[newPivotndex] = array[i];
                array[i] = tempVal;
            }
        }
        newPivotndex++;

        tempVal = array[newPivotndex];
        array[newPivotndex] = array[lastIndex];
        array[lastIndex] = tempVal;

        return newPivotndex;
    }
}
