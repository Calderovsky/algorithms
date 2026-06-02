import java.lang.reflect.Array;
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

        lh = Arrays.copyOfRange(numeros, 0, tamano/2);
        rh = Arrays.copyOfRange(numeros, tamano/2, tamano);

        lho = mergesort(lh);
        rho = mergesort(rh);

        return merge(lho, rho);

    }

    public static int[] merge(int[] lh, int[] rh) {
        int n = lh.length + rh.length;
        int[] result = new int[n]; 
        int li = 0;
        int ri = 0;

        for(int k = 0; k < n; k++) {
            if(li == lh.length) {
                System.arraycopy(rh, ri, result, k, rh.length - ri); 
                break;
            }

            if(ri == rh.length) {
                System.arraycopy(lh, li, result, k, lh.length - li);
                break;
            }

            if(lh[li] < rh[ri]) {
                result[k] = lh[li];
                li = li + 1;
            } else {
                result[k] = rh[ri];
                ri = ri + 1;
            }
        }

        return result;
    }
}

public class TestMergeSort {
    public static void main(String[] args) {
            int[] numeros = {10, 5, 4, 2, 1, 8, 7, 2, 9, 6, 3};
        System.out.println(Arrays.toString(MergeSort.mergesort(numeros)));
    }
}