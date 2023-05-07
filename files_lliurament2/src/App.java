import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {

    public static void main(String[] args) throws Exception {

        //TODO Crear un fitxer amb la classe File
        //el nom del fitxer serà testfile.html


        String str = urlReader("http://inslaguineueta.cat");

        //TODO cridar la funció perquè guardi str al fitxer
        File file = new File("files-lliura2.out");
        saveToFile(str,file,false);
        //TODO LLegir el contingut del fitxer i imprimir-lo
        //per pantalla.
        System.out.println(readFromFile(file));;
    }

    static String readFromFile(File file) throws IOException {
        // TODO usando FileReader y BufferedReader
        FileReader fr = new FileReader(file); // Crea un objeto FileReader que lee el archivo especificado
        BufferedReader bufer = new BufferedReader(fr); // Crea un objeto BufferedReader que lee el archivo FileReader
        StringBuilder sb = new StringBuilder(); // Crea un objeto StringBuilder para almacenar el contenido del archivo
        String line;
        while((line = bufer.readLine()) != null){ // Lee el archivo línea por línea y guarda cada línea en la variable 'line'
            sb.append(line); // Agrega cada línea al objeto StringBuilder
        }
        bufer.close(); // Cierra el objeto BufferedReader
        return sb.toString(); // Devuelve el contenido del archivo como una cadena de caracteres
    }


    static void saveToFile(String str, File file, boolean append) throws IOException {
        //TODO using FileWriter and BufferedWriter
        // Crea un nuevo objeto FileWriter que escribe en el archivo especificado
        // Si append es verdadero, los datos se agregarán al final del archivo
        FileWriter fw = new FileWriter(file, append);

        // Crea un nuevo objeto BufferedWriter que escribe en el objeto FileWriter
        BufferedWriter bufw = new BufferedWriter(fw);

        // Escribir la cadena especificada en el objeto BufferedWriter
        bufw.write(str);

        // Cierra el objeto BufferedWriter
        bufw.close();
    }


    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

