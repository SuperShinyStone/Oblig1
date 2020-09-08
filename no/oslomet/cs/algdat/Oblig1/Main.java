package no.oslomet.cs.algdat.Oblig1;

import javax.swing.*;
import java.util.Arrays;
import java.util.*;

public class Main {
    private static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }

    private static int partition(int[] a, int begin, int end){
        int pivot = a[end];
        int j = (begin-1);

        for(int i = begin; i < end; i++){
            if(a[i] >= pivot){
                j++;
                bytt(a, i, j);
            }
        }
        bytt(a, j+1, end);
        return j+1;
    }

    private static void quickSort(int[] values, int left, int right){
        if(left < right){
            int pivot_index = partition(values, left, right);
            quickSort(values, left, pivot_index-1);
            quickSort(values, pivot_index+1, right);
        }
    }

    static int[] indekssortering(int[] a) {
        int teller = 0;
        int[] index = new int[a.length];

        int[] aNegative = a.clone();
        for(int i = 0; i < aNegative.length; i++){
            aNegative[i] = -aNegative[i];
        }

        int[] aSorted = aNegative.clone();
        quickSort(aSorted, 0, a.length-1);

        /*for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < aSorted.length-1; j++){
                if(aSorted[j] == a[i] && teller < 11){
                    index[teller] = i;
                    teller++;
                }
            }
        }*/
        //loop gjennom, if aSorted(j) == aNegative(i) -> aNegative(i) = -aNegative(i)

        for(int i = 0; i < aSorted.length; i++){
            for(int j = 0; j < aNegative.length; j++){
                if(aNegative[j] == aSorted[i]){
                    index[teller] = j;
                    teller++;
                    aNegative[j] = -aNegative[j];
                    break;
                }
            }
        }


        return index;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6,10,16,11,7,12,3,9,8,5};
        int[] indeks = indekssortering(a);
        int[] test = new int[]{6, 9, 0, 4, 8, 7, 1, 3, 5, 2};

        System.out.println(Arrays.toString(indeks));
        System.out.println(Arrays.toString(test));

    }
}

