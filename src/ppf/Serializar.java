package ppf;

import java.io.*;
import java.util.ArrayList;

public class Serializar {

    public static void GUARDAR_USUARIOS(ArrayList<Users> arraySerializar) {
        String mensaje = "";
        try {
            FileOutputStream fos = new FileOutputStream("registros.ppf");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(arraySerializar);

            fos.close();
            out.close();
            mensaje = "\tSe han guardado los datos\t";

        } catch (IOException e) {
            mensaje = "No se pudo crear/sobrescribir el archivo || " + e.getMessage();
        } finally {
            System.out.println(mensaje);
        }
    }

    public static ArrayList<Users> RECUPERAR_USUARIOS() {
        ArrayList<Users> arrayUsersRecuperado = null;
        String mensaje = "";
        try {
            FileInputStream fis = new FileInputStream("registros.ppf");
            ObjectInputStream entrada = new ObjectInputStream(fis);

            arrayUsersRecuperado = (ArrayList<Users>) entrada.readObject();
            mensaje = "\tSe han recuperado los datos\t";

        } catch (Exception e) {
            mensaje = "\tNo hay datos previos/ No se pudieron recuperar los datos || " + e.getMessage();
        } finally {
            System.out.println(mensaje);
        }

        return arrayUsersRecuperado;

    }

}
