package ppf;

public class Paso_4 {

    private int ecuacion[] = new int[3];
    private float interseccionXFloat;
    private float interseccionYFloat;
    private final String tipoX;
    private final String tipoY;


    Paso_4(int[] ecuacion, String extencionX, String extencionY) {
        this.ecuacion = ecuacion;
        this.tipoX = extencionX;
        this.tipoY = extencionY;
        System.out.println();
        System.out.println("\n 4)  INTERSECCIONES EN LOS EJES:");
    }

    public String interseccionX() {
        // if y=0 we have
        //aX + bY + c = 0 --> aX + b(0) + c= 0 --> aX = -c --> X=-c/a     

        System.out.print("\n Interseccion en Eje X    ----> \t");

        int mcd = Mcd_Recursivo.mcd(ecuacion[2], ecuacion[0]);
        int c = ecuacion[2] / mcd;
        int a = ecuacion[0] / mcd;

        String interseccionS = "si ves esto algo asio mal en el paso 4 con el switch";
        String interseccionX;

        switch (tipoX) {

            case "indefinido" -> interseccionS = "No tiene\n";

            case "pFijo" -> {
                interseccionX = (a != 0 & a != 1) ? (-c + "/" + a) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c);
                interseccionXFloat = (float) -c / a;

                interseccionS = String.format("P (%s, %s)  \u2248  P (%.2f ,%d)\n", interseccionX, 0, interseccionXFloat, 0);
            }

            case "normal" -> {
                interseccionX = (a != 0 & a != 1) ? (-c + "/" + a) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c);
                interseccionXFloat = (float) -c / a;
                interseccionS = String.format("P (%s , %d)  \u2248  P (%.2f, %d)\n", interseccionX, 0, interseccionXFloat, 0);           //\u2248 simbolo aprox
            }
        }
        System.out.print(interseccionS + "<- el nuevo");
        return interseccionS;

    }

    public String interseccionY() {
        System.out.print("\n  Interseccion en Eje Y    ----> \t");
        // if X=0 we have
        //aX + bY + c = 0 --> a(0) + bY + c= 0 --> bY = -c --> Y=-c/b
        int mcd = Mcd_Recursivo.mcd(ecuacion[2], ecuacion[1]);
        int c = ecuacion[2] / mcd;
        int b = ecuacion[1] / mcd;

        String interseccionY;
        String interseccionS = "si ves esto algo saliio mal en paso_4";

        switch (tipoY) {

            case "indefinido" ->
                interseccionS = "No tiene\n";

            case "pFijo" -> {
                interseccionY = (b != 0 & b != 1) ? (-c + "/" + b) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                interseccionYFloat = (float) -c / b;
                interseccionS = String.format("P (%s, %s)  \u2248  P (%d ,%.2f)\n", 0, interseccionY, 0, interseccionYFloat);
            }

            case "normal" -> {
                interseccionY = (b != 0 & b != 1) ? (-c + "/" + b) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                interseccionYFloat = (float) -c / b;
                interseccionS = String.format("P (%d ,%s)  \u2248  P (%d ,%.2f)\n", 0, interseccionY, 0, interseccionYFloat);
            }
        }
        System.out.print(interseccionS + "<- el nuevo");
        return interseccionS;
    }

    public float getInterseccionXFloat() {
        return interseccionXFloat;
    }

    public float getInterseccionYFloat() {
        return interseccionYFloat;
    }

}
