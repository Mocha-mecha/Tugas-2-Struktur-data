public class Mergesortdesc {

    // Mengurutkan array dari terbesar ke terkecil dengan Merge Sort
    static void mergeSort(int[] arr, int kiri, int kanan) {
        if (kiri < kanan) {
            int tengah = (kiri + kanan) / 2;
            mergeSort(arr, kiri, tengah);        // urutkan bagian kiri
            mergeSort(arr, tengah + 1, kanan);   // urutkan bagian kanan
            merge(arr, kiri, tengah, kanan);     // gabungkan
        }
    }

    static void merge(int[] arr, int kiri, int tengah, int kanan) {
        int n1 = tengah - kiri + 1;
        int n2 = kanan - tengah;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[kiri + i];
        for (int j = 0; j < n2; j++) R[j] = arr[tengah + 1 + j];

        int i = 0, j = 0, k = kiri;
        while (i < n1 && j < n2) {
            
            if (L[i] >= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void cetak(String label, int[] arr) {
        System.out.print(label);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // a1 .. a8
        int[] data = {45, 12, 78, 23, 56, 12, 91, 34};

        cetak("Sebelum diurutkan : ", data);
        mergeSort(data, 0, data.length - 1);
        cetak("Sesudah (Merge Sort, besar ke kecil): ", data);
    }
}