package problema_fundamental;

public class Paso_4 {

    private int ecuacion[] = new int[3];
    private float interseccionXFloat;
    private float interseccionYFloat;
    private final String tipoX;
    private final String tipoY;

    private String variable[] = new String[3];

    Paso_4(int[] ecuacion, String[] variable, String extencionX, String extencionY) {        
        this.ecuacion = ecuacion;
        this.variable = variable;
        this.tipoX = extencionX;
        this.tipoY = extencionY;
        System.out.println();
        System.out.println("\n 4)  INTERSECCIONES EN LOS EJES:");        
    }

    public void interseccionX() {
        // if y=0 we have
        //aX + bY + c = 0 --> aX + b(0) + c= 0 --> aX = -c --> X=-c/a     
        
        System.out.print("\n " + "Interseccion en Eje X    ---->" + "\t ");
        int mcd = Mcd_Recursivo.mcd(ecuacion[2], ecuacion[0]);
        int c = ecuacion[2] / mcd;
        int a = ecuacion[0] / mcd;

        String interseccionX;

        switch (tipoX) {

            case "indefinido":
                System.out.print("No tiene\n");
                break;

            case "pFijo":
                interseccionX = (a != 0 & a != 1) ? (-c + "/" + a) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c);
                interseccionXFloat = (float) -c / a;
                System.out.printf("P (%s, %s)  \u2248  P ( %.2f ,%d )\n", interseccionX, 0, interseccionXFloat, 0);
                break;

            case "normal":
                interseccionX = (a != 0 & a != 1) ? (-c + "/" + a) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c);
                interseccionXFloat = (float) -c / a;
                System.out.printf("P ( %s ,%d )  \u2248  P ( %.2f, %d )\n", interseccionX, 0, interseccionXFloat, 0);           //\u2248 simbolo aprox
                break;
        }

    }

    public void interseccionY() {
        System.out.print("\n " + "Interseccion en Eje Y    ---->" + "\t ");
        // if X=0 we have
        //aX + bY + c = 0 --> a(0) + bY + c= 0 --> bY = -c --> Y=-c/b
        int mcd = Mcd_Recursivo.mcd(ecuacion[2], ecuacion[1]);
        int c = ecuacion[2] / mcd;
        int b = ecuacion[1] / mcd;

        String interseccionY;
        
        switch (tipoY) {
            
            case "indefinido":
                System.out.print("No tiene\n");
                break;
                
            case "pFijo":
                interseccionY = (b != 0 & b != 1) ? (-c + "/" + b) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                interseccionYFloat = (float) -c / b;
                System.out.printf("P (%s, %s)  \u2248  P ( %d ,%.2f )\n", 0, interseccionY, 0, interseccionYFloat);
                break;
                
            case "normal":
                interseccionY = (b != 0 & b != 1) ? (-c + "/" + b) : (-c != 1) ? Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                interseccionYFloat = (float) -c / b;
                System.out.printf("P ( %d ,%s )  \u2248  P ( %d ,%.2f )\n", 0, interseccionY, 0, interseccionYFloat);
                break;
        }
    }

    public float getInterseccionXFloat() {
        return interseccionXFloat;
    }

    public float getInterseccionYFloat() {
        return interseccionYFloat;
    }

}
