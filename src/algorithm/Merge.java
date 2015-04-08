package algorithm;

import Model.Person;

/**
 * Created by David on 2015-04-04.
 */
public class Merge {

    @SuppressWarnings("rawtypes")
    public static void mergeSortFirstName (Person[] x ) {
    	Person[] aux = new Person[x.length];
        mergeSortFirstName(x, aux, 0, x.length-1);
    }

    @SuppressWarnings("rawtypes")
    private static void mergeSortFirstName (Person[] x, Person[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        mergeSortFirstName(x, aux, lo, mid);
        mergeSortFirstName(x, aux, mid+1, hi);
        mergeFirstName(x, aux, lo, mid, hi);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void mergeFirstName(Person[] a, Person[] aux, int lo, int mid, int hi) {
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
    public static void mergeSortLastName (Person[] x ) {
    	Person[] aux = new Person[x.length];
    	mergeSortLastName(x, aux, 0, x.length-1);
    }

    @SuppressWarnings("rawtypes")
    private static void mergeSortLastName (Person[] x, Person[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        mergeSortLastName(x, aux, lo, mid);
        mergeSortLastName(x, aux, mid+1, hi);
        mergeLastName(x, aux, lo, mid, hi);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void mergeLastName(Person[] a, Person[] aux, int lo, int mid, int hi) {
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
