package no.oslomet.cs.algdat.Oblig1;

import java.util.Arrays;
import java.util.*;

public class Main {

    static void delsortering(int[] a) {

        if(a.length > 1) {

            int v = 0;
            int h = a.length - 1;

            long tid = System.currentTimeMillis();
            for (int i = 0; i < a.length; i++) {
                while (a[v] % 2 != 0 && v < a.length-1) {
                    v++;
                }
                while (a[h] % 2 == 0 && h > 0) {
                    h--;
                }
                if (v < h) {
                    int temp = a[v];
                    a[v] = a[h];
                    a[h] = temp;
                }
            }

            int skilleIndex = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] % 2 == 0) {
                    skilleIndex = i;
                    break;
                }
            }

            v = skilleIndex;
            h = a.length - 1;
            //partall sortering
            for (int i = v; i <= a.length -1; i++) {

                for (int j = v; j <= h; j++) {
                    if (a[j] > a[h]) {
                        int temp = a[j];
                        a[j] = a[h];
                        a[h] = temp;
                    }
                }
                h--;
            }

            v = 0;
            h = skilleIndex - 1;
            //odetall sortering
            for (int i = v; i <= h; i++) {

                for (int j = v; j <= h; j++) {
                    if (a[j] > a[h]) {
                        int temp = a[j];
                        a[j] = a[h];
                        a[h] = temp;
                    }
                }
                h--;
            }
            tid = System.currentTimeMillis() - tid;
            if(tid > 100){
                System.out.println("For lang tid");
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[] a = {-4, -1, 3, 0, 2, -3, -2, 4, 1};
        int[] b = {-3, -1, 1, 3, -4, -2, 0, 2, 4};


        delsortering(a);
        //sortAsc(a);
        System.out.println(Arrays.toString(a));
    }
}
