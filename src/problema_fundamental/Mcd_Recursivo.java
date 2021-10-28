package problema_fundamental;

public class Mcd_Recursivo {
    public static int mcd (int num_1, int num_2){

            int menor = Math.min(Math.abs(num_1), Math.abs(num_2));
            int mayor = Math.max(Math.abs(num_1), Math.abs(num_2));

            if(mayor == 0)
                    return 1;			
            else 
                    if(menor == 0)
                            return mayor;
            else 
                    if (mayor % menor != 0){
                            int residuo = mayor % menor;
                            mayor = menor;
                            menor = residuo;
                            return mcd(mayor, menor);
                    }
            else
                    return menor;					
    }

    public static int mcd (int num_1, int num_2, int num_3){		

            return mcd(mcd(num_1, num_2), num_3);
    }
}
