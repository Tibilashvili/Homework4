package com.lesson4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int myArray[] = {64, 3, 1, 5, 62, 11, 0, 6};
        int startIndex = 0; //
        int endIndex = myArray.length - 1; // 7;


        quickSort(myArray, startIndex, endIndex);






        System.out.println("bubble sort: " + Arrays.toString(bubbleSort(myArray)));
        System.out.println("selection sort: " + Arrays.toString(selectionSort(myArray)));
        System.out.println("merge sort1: " + Arrays.toString(mergeSort1(myArray)));
        System.out.println("merge sort2: " + Arrays.toString(mergeSort2(myArray)));
        quickSort(myArray, startIndex, endIndex);

    // System.out.println("quick sort: " +  Arrays.toString(quickSort2(myArray)));
    //  quickSort2(myArray2);
     // mainQuickSort(myArray2, startIndex, endIndex);



    }


    public static int[] bubbleSort(int[] myArray) {


        for (int i = myArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = 0;
                if (myArray[j] > myArray[j + 1]) {
                    temp = myArray[j + 1];
                    myArray[j + 1] = myArray[j];
                    myArray[j] = temp;
                }
            }


        }
        return myArray;

    }

    public static int[] selectionSort(int[] myArray) {


        for (int i = 0; i < myArray.length - 1; i++) { // - 1 потому, что если в массиве остался 1 элемент, то нам его не с чем срвнить, значит он отсортирован (нет необходимости делать еще одну итерацию)_

            int min = i; // индекс минимального элемента (будем считать, что i с индексом 0 - минимальный элемент)

            for (int j = i; j < myArray.length; j++) { // начинать будем не от 0, а от текущего индекса i, чтобы не проверять отсортированную часть массива

                if (myArray[j] < myArray[min]) {
                    min = j; // нашли индекс минимального элемента
                }

            }

            int temp = myArray[i];
            myArray[i] = myArray[min];
            myArray[min] = temp;


        }

        return myArray;

    }


    public static int[] mergeSort1(int myArray[]) {

        if (myArray.length > 1) {
            int[] mainArray = myArray;

            int left = mainArray.length / 2;
            int right = mainArray.length - left;
            //   System.out.println(left); // 4
            //   System.out.println(right); // 4

            int[] leftArray = new int[left];
            int[] rightArray = new int[right];
            //   System.out.println(Arrays.toString(leftArray)); // [0, 0, 0, 0]
            //   System.out.println(Arrays.toString(rightArray)); // [0, 0, 0, 0]

            for (int i = 0; i < left; i++) {
                leftArray[i] = mainArray[i];

            }

            for (int i = left; i < left + right; i++) {
                rightArray[i - left] = mainArray[i];
            }


            mergeSort1(leftArray);
            mergeSort1(rightArray);


            int MainArrayId = 0, RightArrayId = 0, LeftArrayId = 0;


            while (LeftArrayId != leftArray.length && RightArrayId != rightArray.length) {
                if (leftArray[LeftArrayId] < rightArray[RightArrayId]) {
                    myArray[MainArrayId] = leftArray[LeftArrayId];
                    MainArrayId++;
                    LeftArrayId++;
                } else if (leftArray[LeftArrayId] > rightArray[RightArrayId]) {
                    myArray[MainArrayId] = rightArray[RightArrayId];
                    MainArrayId++;
                    RightArrayId++;

                }
            }

            while (leftArray.length != LeftArrayId) {
                myArray[MainArrayId] = leftArray[LeftArrayId];
                MainArrayId++;
                LeftArrayId++;
            }

            while (rightArray.length != RightArrayId) {
                myArray[MainArrayId] = rightArray[RightArrayId];
                MainArrayId++;
                RightArrayId++;

            }


        }

        return myArray;
    }


    public static int[] mergeSort2(int[] myArray) {


        int[] mainArray = myArray;

        int left = mainArray.length / 2;
        int right = mainArray.length - left;
        //   System.out.println(left); // 4
        //   System.out.println(right); // 4

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];
        //   System.out.println(Arrays.toString(leftArray)); // [0, 0, 0, 0]
        //   System.out.println(Arrays.toString(rightArray)); // [0, 0, 0, 0]

        for (int i = 0; i < left; i++) {
            leftArray[i] = mainArray[i];

        }

        for (int i = left; i < left + right; i++) {
            rightArray[i - left] = mainArray[i];
        }

        //   System.out.println(Arrays.toString(leftArray)); // [64, 3, 1, -14]
        //   System.out.println(Arrays.toString(rightArray));  // [62, 11, 0, 6]


        int idLeft = 0;
        int idRight = 0;

        if (mainArray.length / 2 > 0) {
            mergeSort2(leftArray);
            mergeSort2(rightArray);

            for (int idMainArray = 0; idMainArray < myArray.length; idMainArray++) {
                if (idLeft < leftArray.length && idRight < rightArray.length) {
                    if (leftArray[idLeft] > rightArray[idRight]) {
                        mainArray[idMainArray] = rightArray[idRight];
                        idRight++;

                    } else if (leftArray[idLeft] < rightArray[idRight]) {
                        mainArray[idMainArray] = leftArray[idLeft];
                        idLeft++;
                    }

                } else if (idLeft == leftArray.length && idRight < rightArray.length) {
                    mainArray[idMainArray] = rightArray[idRight];
                    idRight++;

                } else if (idLeft < leftArray.length && idRight == rightArray.length) {
                    mainArray[idMainArray] = leftArray[idLeft];
                    idLeft++;
                }


            }

        }
        return mainArray;
    }




    public static void quickSort(int[] array, int startIndex, int endIndex)
    {

        int idLeft = startIndex;
        int idRight = endIndex;
        int temp = 0;
        int middle = array[(endIndex + startIndex) / 2];

        while (idLeft < idRight)
        {
            while (array[idLeft] < middle)
            {
                idLeft++;
            }
            while (array[idRight] > middle)
            {
                idRight--;
            }
            if (idLeft <= idRight)
            {
                temp = array[idLeft];
                array[idLeft] = array[idRight];
                array [idRight]=temp;
                idLeft++;
                idRight--;
            }
        }


        if (startIndex < idRight)
        {
            quickSort(array, startIndex, idRight);
        }
        if (idLeft < endIndex)
        {
            quickSort(array, idLeft, endIndex);
        }

        System.out.println("quick sort: " + Arrays.toString(array));
    }
}

    










