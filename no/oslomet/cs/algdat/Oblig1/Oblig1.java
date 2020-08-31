package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
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

        for (int i = 1; i < a.length; i++)
        {
            int j;
            for (j = 0; j < i; j++)
                if (a[i] == a[j])
                    break;

            if (i == j)
                teller++;
        }
        if(a.length==0){
            teller=0;
        }
        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j + 1] && a[j] % 2 == 0) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j + 1] && a[j] % 2 == 1 && a[j+1] % 2 == 1) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
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
    public static void rotasjon(char[] a, int k) {
        if(k > 0){
            for(int j = 0; j <= k; j++) {
                if (a.length == 0) {
                } else {
                    char temp = a[a.length - 1]; //Siste bokstaven
                    for (int i = a.length - 1; i > 0; i--) {
                        a[i] = a[i - 1];
                    }
                    a[0] = temp;
                }
            }
        } else {
            for(int j = 0; j <= k; j++) {
                if (a.length == 0) {
                } else {
                    char temp = a[0]; //Siste bokstaven
                    for (int i = 0; i < a.length - 1; i++) {
                        a[i] = a[i + 1];
                    }
                    a[a.length-1] = temp;
                }
            }
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
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
