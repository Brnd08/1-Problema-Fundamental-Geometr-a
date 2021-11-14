package ppf;

import static java.lang.Double.isInfinite;

public class Paso_3 {

    private int ecuacion[] = new int[3];
    private float pendiente;

    Paso_3(int[] ecuacion) {
        this.ecuacion = ecuacion;
        this.pendiente = this.calcularPendiente(ecuacion);
        System.out.println();

        System.out.println("\n 3)  SIMETRIAS:");
    }

    private float calcularPendiente(int[] ecuacion2) {
        //pendiente = - a/b
        int b = ecuacion2[1];
        int a = ecuacion2[0];
        String sPendiente = (-a) + "/" + (b) + " = ";
        float pendiente2;
        try {
            pendiente2 = (float) -a / b;
            System.out.println(" Pendiente:\t" + sPendiente + pendiente2);
        } catch (Exception e) {
            pendiente2 = (float) -a / b;
            System.out.println(" Pendiente:\t" + sPendiente + pendiente2);
        }
        return pendiente2;
    }

    public String[] simetrias() {

        System.out.print("\n Eje X \t");

        String simetriasS[] = {"si ves esto alg sucedio con simetria en X", "si ves esto alg sucedio con simetria en Y", "si ves esto alg sucedio con simetria en O"};

        if (this.esSimetricaX()) {
            simetriasS[0] = String.format("\tSimetria respecto a eje X");
        } else {
            simetriasS[0] = String.format("\tNo existe simetria en el eje X");
        }

        System.out.print(simetriasS[0]);

        System.out.print("\n Eje Y \t");

        if (this.esSimetricaY()) {
            simetriasS[1] = String.format("\tSimetria respecto a eje Y");
        } else {
            simetriasS[1] = String.format("\tNo existe simetria en el eje Y");
        }

        System.out.print(simetriasS[1]);

        System.out.print("\n Origen Y \t");

        if (this.esSimetricaOrigen()) {
            simetriasS[2] = String.format("Simetria respecto al Origen");
        } else {
            simetriasS[2] = String.format("No existe simetria respecto al Origen");
        }

        System.out.print(simetriasS[2]);

        return simetriasS;
    }

    private boolean esSimetricaX() {

        return isInfinite(pendiente);
    }

    private boolean esSimetricaY() {

        return (pendiente == 0.0f);
    }

    private boolean esSimetricaOrigen() {

        return ecuacion[2] == 0;
    }

    public float getPendiente() {
        return pendiente;
    }

}
