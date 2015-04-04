package group5.offlinefriends;

/**
 * Created by David on 2015-04-04.
 */
public class Merge {

    @SuppressWarnings("rawtypes")
    public static void sortMerge (Comparable[] x ) {
        Comparable[] aux = new Comparable[x.length];
        sortMerge(x, aux, 0, x.length-1);
    }

    @SuppressWarnings("rawtypes")
    public static void sortMerge (Comparable[] x, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sortMerge(x, aux, lo, mid);
        sortMerge(x, aux, mid+1, hi);
        merge(x, aux, lo, mid, hi);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i])>0) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }
}
