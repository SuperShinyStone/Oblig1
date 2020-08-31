package no.oslomet.cs.algdat.Oblig1;


import java.util.Arrays;

public class Main {
    static void delsortering(int[] a) {

        /*
        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < a.length-1; j++) {
                //PARTALL KASTES BAKOVER
                if (a[j] > a[j + 1] || (a[j] % 2 == 0 && a[j+1] % 2 == 1)) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

         */

        /* KAST FRAMOVER START BAK??
        for(int i = a.length-1; i > 0; i--){
            for(int j = a.length-1; j > 0; j--) {
                //PARTALL KASTES BAKOVER
                if (a[j] > a[j - 1] || (a[j] % 2 == 1 && a[j+1] % 2 == 1)) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
         */

    }

    public static void rotasjon(char[] a) {

        if(a.length == 0){
        } else {
            char temp = a[a.length-1]; //Siste bokstaven
            for (int i = a.length-1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
    }


    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6};
        delsortering(arr);
        System.out.println(Arrays.toString(arr));

        char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        rotasjon(d);
        System.out.println(Arrays.toString(d));

    }
}
