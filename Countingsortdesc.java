public class Countingsortdesc {

    // Mengurutkan array dari terbesar ke terkecil dengan Counting Sort
    static int[] countingSortDesc(int[] arr) {
        // 1. 
        int min = arr[0], max = arr[0];
        for (int x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        // 2
        int[] count = new int[max - min + 1];
        for (int x : arr) {
            count[x - min]++;
        }

        // 3. 
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // 4
        int[] hasil = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = arr[i] - min;
            hasil[count[idx] - 1] = arr[i];
            count[idx]--;
        }
        return hasil;
    }

    static void cetak(String label, int[] arr) {
        System.out.print(label);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //
        int[] data = {45, 12, 78, 23, 56, 12, 91, 34};

        cetak("Sebelum diurutkan : ", data);
        int[] hasil = countingSortDesc(data);
        cetak("Sesudah (Counting Sort, besar ke kecil): ", hasil);
    }
}