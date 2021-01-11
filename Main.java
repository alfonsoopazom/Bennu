import java.io.*;
import java.nio.file.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        int valorOpcion = 0;
        int valorOrdenamiento = 0;
        boolean opcion = true;
        String directorioRaiz = "/Users/alfonsoopazom/Documents/IdeaProjects";

        Scanner lector = new Scanner(System.in);

        System.out.println("Bienvenido al programa"
                +"\n----------------------"
                +"\nElegir una opcion:");

        while(opcion){
            Menu();
            try {
                System.out.println("Ingrese su opcion:");
                valorOpcion = lector.nextInt();

                switch (valorOpcion) {
                        case 0://Mostrar menu
                            System.out.println("Eleccion 0");
                            Menu();
                        break;
                        case 1://Generar archivos con numeros aletaorios
                            System.out.println("Eleccion 1");
                            System.out.println("¿Cuantos numeros desea generar?\n"
                                    + "Ingrese la cantidad de numeros");
                            int totalNumeros = lector.nextInt();
                            Fichero ficha = new Fichero();

                            if (ficha.crearFichero(directorio()+"_Numeros.txt")){
                                System.out.println("Archivo creado correctamente!");
                                ficha.escribirFichero(totalNumeros, directorio()+"_Numeros.txt");
                            }
                            break;
                        case 2://Leer el archivo con numeros aletorios
                            System.out.println("Eleccion 2");
                            System.out.println("Leer datos de archivo generado");

                            Fichero leerNumeros = new Fichero();
                            leerNumeros.leerDatosOrdenados(directorio()+"_Numeros.txt");
                            break;
                        case 3://Utilizar metodos de ordenamiento
                            System.out.println("Eleccion 3"
                                    + "\n¿Que algoritmo de ordenamiento desea usar?\n"
                                    + "1. QuickSort\n"
                                    + "2. BubbleSort\n"
                                    + "3. Volver atras");

                            File fichero = new File(directorio() + "_Numeros.txt");
                            FileReader fl = new FileReader(fichero);
                            BufferedReader br = new BufferedReader(fl);
                            Scanner entrada = new Scanner(fichero);

                            int cantidadDatos = 0;
                            String cadena;
                            int[] arreglo;

                            while((cadena=br.readLine())!=null){cantidadDatos++;}
                             arreglo = new int[cantidadDatos];;
                            for (int i = 0; i < arreglo.length; i++) {arreglo[i] = entrada.nextInt();}

                            System.out.println("Ingrese su opcion de algoritmo:");
                            valorOrdenamiento = lector.nextInt();

                            try {
                                switch (valorOrdenamiento) {
                                    case 1:
                                        Quick quick = new Quick();
                                        quick.quicksort(arreglo, 0, (arreglo.length - 1));
                                        escribirAlgoritmo(arreglo, "_Quick.txt");
                                        System.out.println("Archivo ordenado correctamente por Quicksort!");
                                        break;
                                    case 2:
                                        Bubble burbuja = new Bubble();
                                        burbuja.bubbleSort(arreglo);
                                        escribirAlgoritmo(arreglo, "_Bubble.txt");
                                        System.out.println("Archivo ordenado correctamente por BubbleSort!");
                                        break;
                                    default:
                                        System.out.println("Eleccion incorrecta, vuelva a ingresar la opcion");
                                }
                            }catch (InputMismatchException e)
                            {
                                System.out.println("Opcion incorrecta, vuelve a intentarlo");
                                valorOrdenamiento = lector.nextInt();
                            }
                            br.close();
                            entrada.close();
                            break;
                        case 4://Leer los archivos en el directorio ordenado
                            System.out.println("Eleccion 4");
                            System.out.println("Archivos que se encuentran en el directorio");

                            File carpetaRaiz = new File(directorioRaiz);
                            String[] archivos = carpetaRaiz.list();
                            for (int i = 1; i < archivos.length; i++) {
                                System.out.println("* "+archivos[i]);
                            }
                            System.out.println("¿Que archivo desea leer ?"
                            +"\n1- Archivo QuickSort"
                            +"\n2- Archivo BubbleSort"
                            +"\n3- Archivo Con datos aleatorios");

                            int valorLectura = lector.nextInt();

                            switch (valorLectura){
                                case 1:
                                    Fichero archivoQuick = new Fichero();
                                    archivoQuick.leerDatosOrdenados(directorio()+"_Quick.txt");
                                    break;
                                case 2:
                                    Fichero archivoBubble = new Fichero();
                                    archivoBubble.leerDatosOrdenados(directorio()+"_Bubble.txt");
                                    break;
                                case 3:
                                    Fichero archivoNumeros = new Fichero();
                                    archivoNumeros.leerDatosOrdenados(directorio()+"_Numeros.txt");
                                    break;
                                default:
                                    System.out.println("Debe ingresar una opcion valida");
                            }
                            break;
                        case 5://Buscar un numero en los archivos
                            System.out.println("Eleccion 5");
                            System.out.println("Ingrese el numero que desea buscar:");

                            int valor = lector.nextInt();

                            Busqueda busqueda = new Busqueda();
                            Fichero ordenar = new Fichero();

                            System.out.println("Ingrese el algoritmo que desea utilizar:"
                                    +"\n1-Busqueda Secuencial"
                                    +"\n2-Busqueda Binaria");

                            int valor1 = lector.nextInt();

                            if (valor1==1){
                                //Busqueda secuencial
                                int resultadoSecuencial = busqueda.busquedaSecuencial(ordenar.guardarArreglo(directorio()+"_Numeros.txt"),valor);

                                if (resultadoSecuencial!=-1){
                                    System.out.println("El valor a sido encontrado en la posicion "+resultadoSecuencial);
                                }else {
                                    System.out.println("El valor no fue encontrado");
                                }
                            }else if (valor1==2){
                                //Busqueda Binaria
                                int resultadoBinario = busqueda.busquedaBinaria(ordenar.guardarArreglo(directorio()+"_Numeros.txt"),valor);

                                if (resultadoBinario>0) {
                                    System.out.println("El valor a sido encontrado en la posicion "+resultadoBinario);
                                }else {
                                    System.out.println("El valor no fue encontrado");
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Hasta pronto!");
                            opcion = false;
                            break;
                    default: System.out.print("Debe ingresar una opcion correcta, Vuelva a intentarlo");
                }

            }catch (InputMismatchException e){
                System.out.println("Debes insertar un número, vuelve a intentarlo");
                lector.next();
            }
        }
    }

    public static void escribirAlgoritmo(int[]arr, String a){
        try{
            FileWriter arch = new FileWriter(directorio()+a);
            PrintWriter escribir = new PrintWriter(arch);

            for (int i=0 ; i<(arr.length-1); i++){
                escribir.print (arr[i] + "\n");
            }
            escribir.close();
        }catch(IOException e){};
    }

    public static String directorio(){
        String carpeta = System.getProperty("user.dir");
        String directorio = carpeta;
        return directorio;
    }

    public static void Menu(){
        System.out.println("\n 0-Menu"
                +"\n 1-Generar nuevo archivo"
                +"\n 2-Leer archivo generado"
                +"\n 3-Ordenar archivo"
                +"\n 4-Leer archivo ordenado"
                +"\n 5-Buscar numero en archivo"
                +"\n 6-Salir");
    }
}
