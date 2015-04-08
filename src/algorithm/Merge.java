package algorithm;

import Model.Person;

/**
 * Created by David on 2015-04-04.
 */
public class Merge {

    @SuppressWarnings("rawtypes")
    public static void sortMerge (Person[] x ) {
    	Person[] aux = new Person[x.length];
        sortMerge(x, aux, 0, x.length-1);
    }

    @SuppressWarnings("rawtypes")
    public static void sortMerge (Person[] x, Person[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sortMerge(x, aux, lo, mid);
        sortMerge(x, aux, mid+1, hi);
        merge(x, aux, lo, mid, hi);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void merge(Person[] a, Person[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j].compareToFirst(aux[i])<0) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }
    
    @SuppressWarnings("rawtypes")
    public static void sortMergeLast (Person[] x ) {
    	Person[] aux = new Person[x.length];
    	sortMergeLast(x, aux, 0, x.length-1);
    }

    @SuppressWarnings("rawtypes")
    public static void sortMergeLast (Person[] x, Person[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sortMergeLast(x, aux, lo, mid);
        sortMergeLast(x, aux, mid+1, hi);
        mergeLast(x, aux, lo, mid, hi);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void mergeLast(Person[] a, Person[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j].compareToLast(aux[i])<0) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }
    
    
}
