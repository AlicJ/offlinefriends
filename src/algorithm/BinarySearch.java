package algorithm;

/**
 * Created by David on 2015-04-04.
 */
public class BinarySearch {

    public static int rank(String key, String[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key.compareTo(a[mid])<0 && !a[mid].contains(key)) hi = mid - 1;
            else if (key.compareTo(a[mid])>0 && !a[mid].contains(key)) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
