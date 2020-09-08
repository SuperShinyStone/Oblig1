package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if(a.length == 0){
            throw new NoSuchElementException("Tom tabell");
        }

        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        if(a.length == 0){
            throw new NoSuchElementException("Tom tabell");
        }

        int teller = 0;

        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                teller++;
            }
        }
        return teller;
    }
    /*
    -Flest ombyttninger når største tallet først (n-1) antall ombyttninger
    der n er antall elementer i tabellen.

    -Minst antall ombyttninger når minste tallet ligger bakerst, 0 ombyttninger.

    -Gjennomsnittsregning;
    Det største tallet s kan ligge i n antall plasser i en tabell.
    n! for å få alle mulige kombinasjoner av en tilfeldig tabell.
    p = (n-1) * (n-2) * (n-3) * ...  * (n-(n-1)) //An   tall


    120*5 + 120*4 + 120*3 + 120*2 + 120*1 = 120(n-1) = 120*15 / 720 = 2,5
     */

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antall = 1;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>a[i+1]){
                throw new IllegalStateException("Tallene er ikke sortert stigende, DONT WORRY BOUT IT SWEETHEART!<3");
            }
            if (a[i] != a[i + 1]){
                antall++;
            }
        }
        if(a.length==0){
            antall=0;
        }
        System.out.println(antall);
        return antall;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int teller = 1;

        for (int i = 1; i < a.length; i++){
            int j;
            for (j = 0; j < i; j++) {
                if (a[i] == a[j])
                    break;
            }

            if (i == j) {
                teller++;
            }
        }

        if(a.length==0){
            teller=0;
        }
        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    private static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }

    private static int partition(int[] a, int begin, int end){
        int pivot = a[end];
        int j = (begin-1);

        for(int i = begin; i < end; i++){
            if(a[i] <= pivot){
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
    public static void delsortering(int[] a) {

        if(a.length > 1) {

            int oddetall = 0;

            for(int i = 0; i < a.length; i++){
                if(a[i] % 2 != 0){
                    int temp = a[oddetall];
                    a[oddetall] = a[i];
                    a[i] = temp;
                    oddetall++;
                }
            }

            // Sort odd number in ascending order
            quickSort(a, 0, oddetall-1);

            // Sort even number in ascending order
            quickSort(a, oddetall, a.length-1);

        } else {
            return;
        }

    }

    ///// Oppgave 5 //////////////////////////////////////
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

    ///// Oppgave 6 //////////////////////////////////////
    public static int gcd(int a, int b)  // Euklids algoritme
    {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void rotasjon(char[] a, int d)    // 3. versjon
    {
        int n = a.length;  if (n < 2) return;         // ingen rotasjon
        if ((d %= n) < 0) d += n;                     // motsatt vei?

        int s = gcd(n, d);                            // største felles divisor

        for (int k = 0; k < s; k++)                   // antall sykler
        {
            char verdi = a[k];                          // hjelpevariabel

            for (int i = k - d, j = k; i != k; i -= d)  // løkke
            {
                if (i < 0) i += n;                        // sjekker fortegnet til i
                a[j] = a[i]; j = i;                       // kopierer og oppdaterer j
            }

            a[k + d] = verdi;                           // legger tilbake verdien
        }
    }
    public static void rotasjon3(char[] a, int k) {
        if(a.length < 2 || k == 0){
            return;
        }
        int n = k;

        if(n > 0) {
            for (int i = 0; i < n; i++) {
                char last;
                last = a[a.length - 1];

                for (int j = a.length - 1; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = last;
            }
        } else if(n < 0){
            for (int i = 0; i < -n; i++) {
                char first;
                first = a[0];

                for (int j = 0; j < a.length-1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length-1] = first;
            }
        } else {
            //nothing
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        char[] ut = new char[sArray.length + tArray.length];  // en tabell av rett størrelse
        int i = 0, j = 0, k = 0;                 // løkkevariabler

        while (i < sArray.length && j < tArray.length)
        {
            ut[k++] = sArray[i++];      // først en verdi fra a
            ut[k++] = tArray[j++];      // så en verdi fra b
        }
        // vi må ta med resten
        while (i < sArray.length) ut[k++] = sArray[i++];
        while (j < tArray.length) ut[k++] = tArray[j++];

        return new String(ut);
    }

    /// 7b)
    public static String flett(String... s) {
        int maxLength = 0;
        for (String i : s) {
            if (i.length() > maxLength) {
                maxLength = i.length();
            }
        }

        String utString = "";

        for (int bokstav = 0; bokstav < maxLength; bokstav++) {
            for (String ord : s) {
                if (ord.length() > bokstav) {
                    utString += ord.charAt(bokstav);
                }
            }
        }
        return utString;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int teller = 0;
        int[] index = new int[a.length];

        int[] aSorted = a.clone();

        quickSort(aSorted, 0, a.length-1);

        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < aSorted.length-1; j++){
                if(aSorted[j] == a[i]){
                    index[teller] = j;
                    teller++;
                }
            }
        }

        return index;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
