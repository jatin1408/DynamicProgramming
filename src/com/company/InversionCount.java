package com.company;

import java.util.Arrays;

public class InversionCount{



        public int merge(int[] arr, int[] aux, int low, int mid, int high)
        {
            int k = low, i = low, j = mid + 1;
            int inversionCount = 0;


            while (i <= mid && j <= high)
            {
                if (arr[i] <= arr[j]) {
                    aux[k++] = arr[i++];
                }
                else {
                    aux[k++] = arr[j++];
                    inversionCount += (mid - i + 1);
                }
            }


            while (i <= mid)
                aux[k++] = arr[i++];




            for (i = low; i <= high; i++) {
                arr[i] = aux[i];
            }

            return inversionCount;
        }


        public  int mergeSort(int[] arr, int[] aux, int low, int high)
        {

            if (high == low) {
                return 0;
            }


            int mid = (low + ((high - low) >> 1));
            int inversionCount = 0;




            inversionCount += mergeSort(arr, aux, low, mid);

            inversionCount += mergeSort(arr, aux, mid + 1, high);


            inversionCount += merge(arr, aux, low, mid, high);

            return inversionCount;
        }

        public static void main(String[] args)
        {
            int[] arr = {  1,8,7,5,2,5,5,87,51,4,11,2,1 };
            int[] aux = Arrays.copyOf(arr, arr.length);
            InversionCount i=new InversionCount();

            System.out.println("Inversion count is " +
                    i.mergeSort(arr, aux, 0, arr.length - 1));
        }
    }
