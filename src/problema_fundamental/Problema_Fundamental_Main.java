package problema_fundamental;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Problema_Fundamental_Main {
    public  static void main(String[] args) {
        
        EntradaEcuacion ec = new EntradaEcuacion();        
        ec.pedirEcuacion();
        ec.simplificarEcuacion();
        ec.imprimirEcuacion();
        
        int [] ecuacion = ec.getEcuacion();
        float pendiente= 0;
        String [] literal = ec.getLiteral();
        boolean esEcuacion = ec.isEsEcuacion();
        
                
        if(esEcuacion){
        
            Paso_1 ec1= new Paso_1(ecuacion, literal);
            ec1.despejeX();      
            String definicionX= ec1.getDefinicionX();
            ec1.despejeY();
            String definicionY= ec1.getDefinicionY();
            
            
            Paso_2 ec2 = new Paso_2 (ecuacion, literal);
            ec2.extencionX(definicionX);
            ec2.extencionY(definicionY);
            
            
            Paso_3 ec3 = new Paso_3(ecuacion, literal);
            ec3.simetrias();
            pendiente = ec3.getPendiente();
            
            
            Paso_4 ec4 = new Paso_4 (ecuacion, literal, definicionX, definicionY);
            ec4.interseccionX();
            ec4.interseccionY();
            
            Paso_5 ec5 = new Paso_5(ecuacion, literal);
            ec5.asintotas();
            
        }   
        else 
            System.out.println("No se pueden realizar los pasos del problema geometrico");
        
            System.out.print("\033[0;1m" + "made by EQUIPO 1 \n");
            
        try {
            PrintStream out;
            out = new PrintStream(new FileOutputStream("C:\\Users\\Brahian\\Desktop\\consola.txt"));
            System.setOut(out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problema_Fundamental_Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
