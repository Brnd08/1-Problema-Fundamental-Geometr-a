// Made by Velazquez Tellez Brandon
package ppf;

public class EntradaEcuacion {
    //vars de instancia

    private int ecuacion[] = new int[3]; //datos de entrada

    final private String literal[] = {"x", "y", " c"}; //Strings para desplegar 

    private boolean esEcuacion = true;
    
    private int mcd;

    public EntradaEcuacion() {
    }
    // Metodos 

    public void pedirEcuacion(double a, double b, double c) {

        System.out.println("\tSOLUCIONADOR DEL 1er PROBLEMA FUNDAMENTAL");
        
        
        ecuacion[0] = (int) a;
        ecuacion[1] = (int) b;
        ecuacion[2] = (int) c;

        System.out.println("\n Los valores son: a = " + ecuacion[0] + ", b = " + ecuacion[1] + " y c: " + ecuacion[2] + "*\t \b*De la forma: aX+bY+c=0");
        System.out.println();

        if (ecuacion[0] == 0 & ecuacion[1] == 0) {
            esEcuacion = false;
        }
        
    }

    public String simplificarEcuacion() {
         String simplificarS = null;

        if (esEcuacion) {

             mcd = Mcd_Recursivo.mcd(ecuacion[0], ecuacion[1], ecuacion[2]);

            if (mcd != 1) {
                simplificarS = String.format("%s\u2193\u2193\u2193\n", "Al dividir entre " + mcd + " tenemos ");
            }

            if (mcd != 1) {
                for (int i = 0; i < 3; i++) // AQUI SE DIVIDE LA ECUACION ENTRE EL MCD 
                {
                    ecuacion[i] = ecuacion[i] / mcd;
                }
            }
        }

        System.out.print("\n" + simplificarS);
        return simplificarS;
    }

    public String imprimirEcuacion() {

        String ecuacionS = "0 = 0";
        if (ecuacion[0] != 0 || ecuacion[1] != 0 || ecuacion[2] != 0) {
            ecuacionS
                    = ((ecuacion[0] > 0) ? " " + ecuacion[0] + literal[0] : (ecuacion[0] < 0) ? ecuacion[0] + literal[0] : "")
                    + ((ecuacion[1] > 0) ? (ecuacion[0] == 0 ? ecuacion[1] + literal[1] : " + " + ecuacion[1] + literal[1]) : (ecuacion[1] < 0) ? " " + ecuacion[1] + literal[1] : "")
                    + ((ecuacion[2] > 0) ? (ecuacion[0] == 0 && ecuacion[1] == 0 ? ecuacion[2] : " + " + ecuacion[2]) : (ecuacion[2] < 0) ? " " + ecuacion[2] : "")
                    + (((ecuacion[0] == 0 & ecuacion[1] == 0 & ecuacion[2] == 0) ? "0 = 0" : " = 0") + "\n");
        }

        System.out.printf("%39s", ecuacionS);

        String noValidoS;
        if (!esEcuacion) {
            noValidoS = "Esta expresion no es una ecuacion valida :( ";
            System.out.println("\n" + noValidoS);
        }
        return ecuacionS;
    }//quite el signo mas en la primera varible y ademas en todas puse >= 0   

    public int[] getEcuacion() {
        return ecuacion;
    }

    public String[] getLiteral() {
        return literal;
    }

    public boolean esEcuacion() {
        return esEcuacion;
    }
}
