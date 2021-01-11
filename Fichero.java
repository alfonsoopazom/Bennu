import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Fichero {

    String directorio;

    public String setDirectorio(String directorio) {
        this.directorio = directorio;
        return directorio;
    }

    public String getDirectorio() {
        return directorio;
    }

    public boolean crearFichero(String directorio){

        File archivo = new File(directorio);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void escribirFichero(int Numeros, String directorio){
        try {
            File fichero = new File(directorio);
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 1; i <= Numeros; i++) {
                int rango = (char) (Math.random() * Numeros) + 1;
                String rango1 = String.valueOf(rango);
                bw.write(rango1 + "\n");
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerDatosOrdenados(String directorio) throws IOException {
        try {
            File archivo = new File(directorio);
            FileReader f = new FileReader(archivo);
            BufferedReader buf = new BufferedReader(f);
            String datosArchivo;

            while ((datosArchivo= buf.readLine())!=null){
                System.out.println(datosArchivo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int[] guardarArreglo(String directorio) throws IOException {

        String cadena;
        int[] arreglo1;
        int cantidadDatos = 0;

        File archivoLectura = new File(directorio);
        FileReader FR = new FileReader(archivoLectura);
        BufferedReader Buffer = new BufferedReader(FR);
        Scanner sca = new Scanner(archivoLectura);

        while ((cadena = Buffer.readLine()) != null) {cantidadDatos++;}
        arreglo1 = new int[cantidadDatos];
        for (int i = 0; i < arreglo1.length; i++) { arreglo1[i] = sca.nextInt();}

        return arreglo1;
    }
}
