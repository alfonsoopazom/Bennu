import java.util.Arrays;

public class Busqueda {

    public int busquedaSecuencial(int arr[], int a){
        int posicion = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == a){
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public int busquedaBinaria(int arr[], int a) {
        Arrays.sort(arr);
        int resultado =Arrays.binarySearch(arr, a);
        return resultado;
    }
}
