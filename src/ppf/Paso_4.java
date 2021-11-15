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

        String interseccionS = "";
        String interseccionX;

        switch (tipoX) {

            case "indefinido" ->
                interseccionS = "x = NO";

            case "pFijo" -> {
                interseccionX = (a != 0 & a != 1) ? (-c + "/" + a) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c);
                interseccionXFloat = (float) -c / a;

                interseccionS = String.format("x = (%s,%s)", interseccionX, 0, interseccionXFloat, 0);
                System.out.println();
            }

            case "normal" -> {
                interseccionX = (a != 0 & a != 1) ? (-c + "/" + a) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c);
                interseccionXFloat = (float) -c / a;

                interseccionS = String.format("x = (%s,%d)", interseccionX, 0, interseccionXFloat, 0);
                System.out.println();
                //\u2248 simbolo aprox
            }
        }
        System.out.print(interseccionS);
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
        String interseccionS = "";

        switch (tipoY) {

            case "indefinido" ->
                interseccionS = "y = NO";

            case "pFijo" -> {
                interseccionY = (b != 0 & b != 1) ? (-c + "/" + b) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                interseccionYFloat = (float) -c / b;
                interseccionS = String.format("y = (%s,%s)", 0, interseccionY, 0, interseccionYFloat);
            }

            case "normal" -> {
                interseccionY = (b != 0 & b != 1) ? (-c + "/" + b) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                interseccionYFloat = (float) -c / b;
                interseccionS = String.format("y = (%d,%s)", 0, interseccionY, 0, interseccionYFloat);
            }
        }
        System.out.print(interseccionS);
        return interseccionS;
    }

    public float getInterseccionXFloat() {
        return interseccionXFloat;
    }

    public float getInterseccionYFloat() {
        return interseccionYFloat;
    }

}
