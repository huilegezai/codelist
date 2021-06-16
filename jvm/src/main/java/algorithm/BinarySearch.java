package algorithm;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int li = a.length - 1;
        while (lo <= li) {
            int mid = lo + (li - lo) / 2;
            if (key < a[mid]) {
                li = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank1(int key, int[] a) {
        return rank2(key, a, 0, a.length - 1);
    }

    public static int rank2(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank2(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank2(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 7, 8, 9, 10};
        System.out.println(rank(4, a));
        System.out.println(rank1(8, a));
    }
}
