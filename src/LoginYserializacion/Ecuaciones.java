package LoginYserializacion;

import java.io.Serializable;
import java.util.Arrays;

public class Ecuaciones implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private  String expresion;
    private  String [] Despejes
            , intervalos
            , simetria
            , interceptos
            , asintotas;

    public Ecuaciones(String expresion, String[] Despejes, String[] intervalos, String[] simetria, String[] interceptos, String[] asintotas) {
        this.expresion = expresion;
        this.Despejes = Despejes;
        this.intervalos = intervalos;
        this.simetria = simetria;
        this.interceptos = interceptos;
        this.asintotas = asintotas;
    }

    public Ecuaciones() {
        this.expresion = "";
        this.Despejes = new String [2];
        this.intervalos = new String [2];
        this.simetria = new String [3];
        this.interceptos = new String [2];
        this.asintotas = new String [2];
    }
    
    
    public void setExpresion ( String expresion){
        this.expresion = expresion;
    }
    
    public void setDespejeX (String DespejeX ) {
        this.Despejes[0] = DespejeX;
    }
    public void setDespejeY (String DespejeY ) {
        this.Despejes[1] = DespejeY;
    }
    
    public void setIntervaloX (String intervaloX ) {
        this.intervalos[0] = intervaloX;
    }
    public void setIntervaloY (String intervaloY ) {
        this.intervalos[1] = intervaloY;
    }
    
    public void setSimetriaX (String simetriaX ){
        this.simetria[0] = simetriaX;
    }
    public void setSimetriaY (String simetriaY ){
        this.simetria[1] = simetriaY;
    }
    public void setSimetriaO (String simetriaY ){
        this.simetria[2] = simetriaY;
    }
    
    public void setInterceptoX(String interceptoX){
        this.interceptos[0] = interceptoX;
    }
    public void setInterceptoY(String interceptoY){
        this.interceptos[1] = interceptoY;
    }
    
    public void setAsintotaH(String asintotaH){
        this.asintotas[0] = asintotaH;
    }
    public void setAsintotaV(String asintotaV){
        this.asintotas[1] = asintotaV;
    }
    
    
    public String getExpresion (){
        return this.expresion ;
    }
    
    public String getDespejeX ( ) {
        return this.Despejes[0];
    }
    public String getDespejeY ( ) {
        return this.Despejes[1];
    }
    
    public String getIntervaloX ( ) {
        return this.intervalos[0];
    }
    public String getIntervaloY ( ) {
        return this.intervalos[1];
    }
    
    public String getSimetriaX ( ){
        return this.simetria[0];
    }
    public String getSimetriaY ( ){
        return this.simetria[1];
    }
    public String getSimetriaO ( ){
        return this.simetria[2];
    }
    
    public String getInterceptoX(){
        return this.interceptos[0] ;
    }
    public String getInterceptoY(){
        return this.interceptos[1] ;
    }
    
    public String getAsintotaH(){
        return this.asintotas[0] ;
    }
    public String getAsintotaV(){
        return this.asintotas[1] ;
    }

    @Override
    public String toString() {
        String representacion = "[" + " expresion-> " + this.expresion 
                + " Despejes-> " + Arrays.toString(Despejes) 
                + " Intervalos-> " + Arrays.toString(intervalos)
                + " Simetrias-> "  + Arrays.toString(simetria)
                + " Interceptos-> " + Arrays.toString(interceptos)
                + " Asintotas-> " +  Arrays.toString(asintotas)
                + "]";
        return representacion;
    }
    
    
    
    
    
    
}
