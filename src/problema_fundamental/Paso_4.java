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

    public String interseccionX() {
        // if y=0 we have
        //aX + bY + c = 0 --> aX + b(0) + c= 0 --> aX = -c --> X=-c/a     
        
        System.out.print("\n Interseccion en Eje X    ---->\t");
        
        int mcd = Mcd_Recursivo.mcd(ecuacion[2], ecuacion[0]);
        int c = ecuacion[2] / mcd;
        int a = ecuacion[0] / mcd;

        String interseccionS = "Default X";

        switch (tipoX) {
            
            case "pFijo" :
                // fall through
                
            case "normal" :
               String interseccionX;
               interseccionX = ( a != 0 & a != 1) ?(-c + "/" + a) :(-c != 1) ?Integer.toString(-c) :Integer.toString(c);
               interseccionXFloat = (float) -c / a;
               interseccionS = String.format("P (%s , %d)  \u2248  P (%.2f, %d)\n", interseccionX, 0, interseccionXFloat, 0);           
               break;
               
            case "indefinido" :
                interseccionS = "No tiene\n";
                break;
        }
        
        System.out.print( interseccionS );
        return interseccionS;

    }

    public String interseccionY() {
        System.out.print("\n Interseccion en Eje Y    ---->\t");
        // if X=0 we have
        //aX + bY + c = 0 --> a(0) + bY + c= 0 --> bY = -c --> Y=-c/b
        int mcd = Mcd_Recursivo.mcd(ecuacion[2], ecuacion[1]);
        int c = ecuacion[2] / mcd;
        int b = ecuacion[1] / mcd;

        String interseccionS= "Default Y";
        
        switch (tipoY) {
            
            case "pFijo":
                // fal through
                
            case "normal":
                String interseccionY;
                interseccionY = ( b != 0 & b != 1 ) ?(-c + "/" + b) :(-c != 1) ?Integer.toString(-c) :Integer.toString(c);      
                interseccionYFloat = (float) -c / b;
                interseccionS= String.format ("P ( %d ,%s )  \u2248  P ( %d ,%.2f )\n", 0, interseccionY, 0, interseccionYFloat);
                break;
                
            case "indefinido":
                interseccionS="No tiene\n";
                break;
        }
        
        System.out.print( interseccionS );
        return interseccionS;
    }

    public float getInterseccionXFloat() {
        return interseccionXFloat;
    }

    public float getInterseccionYFloat() {
        return interseccionYFloat;
    }

}
