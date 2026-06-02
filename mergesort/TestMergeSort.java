import java.util.Arrays;

class MergeSort {
    public static int[] mergesort(int[] numeros) {
        int[] lho;
        int[] rho;
        int[] lh;
        int[] rh;
        int tamano = numeros.length;

        if(tamano == 0 || tamano == 1) {
            return numeros;
        }

        lh = Arrays.copyOfRange(numeros, 0, tamano / 2);
        rh = Arrays.copyOfRange(numeros, tamano / 2, tamano);

        lho = mergesort(lh);
        rho = mergesort(rh);

        return merge(lho, rho);

    }

    public static int[] merge(int[] lh, int[] rh) {
        int[] result = new int[2 * lh.length]; 
        int i = 0;
        int j = 0;

        for(int k = 0; k < 2 * lh.length; k++) {
            if(i == lh.length) {
                result[k] = rh[j];
                break;
            }

            if(j == rh.length) {
                result[k] = lh[i];
                break;
            }

            if(lh[i] < rh[j]) {
                result[k] = lh[i];
                i = i + 1;
            } else {
                result[k] = rh[j];
                j = j + 1;
            }
        }

        return result;
    }
}

public class TestMergeSort {
    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1};
        System.out.println(Arrays.toString(MergeSort.mergesort(numeros)));
    }
}