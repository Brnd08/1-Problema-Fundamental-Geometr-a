package ppf;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * Variables de instancia
     */

    private String nombre;
    private String password;
    public ArrayList<Ecuaciones> aEcuaciones;

    /*
     * Contructores
     */
    public Users(String nombre, String password) {

        this.nombre = nombre;
        this.password = password;
        aEcuaciones = new ArrayList<>();
    }

    public Users() {
        aEcuaciones = new ArrayList<>();
    }

    /*
     * Metodos
     */
    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCorrectPass(String password2) {
        return this.password.equals(password2);
    }

    public void agregarEcuacion(Ecuaciones nuevaEcuacion) {
        this.aEcuaciones.add(nuevaEcuacion);
        System.out.println(nuevaEcuacion.toString());
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Ecuaciones> regresarListaEcuaciones() {

        aEcuaciones.forEach(ecuacion -> {
            System.out.println(ecuacion.toString());
        });

        return (ArrayList<Ecuaciones>) aEcuaciones.clone();
    }

    @SuppressWarnings("unchecked")
    public void actualizarListaEcuaciones(ArrayList<Ecuaciones> nuevoaEcuaciones) {

        this.aEcuaciones = (ArrayList<Ecuaciones>) nuevoaEcuaciones.clone();

        aEcuaciones.forEach(ecuacion -> {
            System.out.println(ecuacion.toString());
        });

    }

    @Override
    public String toString() {
        String representacion;

        representacion = "[" + "Usuario-> " + this.nombre + " pass-> " + this.password + "]";

        return representacion;
    }

}
