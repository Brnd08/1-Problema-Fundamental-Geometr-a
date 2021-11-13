/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class Grafico extends JFrame implements KeyListener{
    
    private JButton botoncito;
    private JTextField texto1, texto2, texto3, texto4;
    
    private JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4;
    
    public Grafico(){
        this.setLayout(null);
        this.setBounds(100, 100, 400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        etiqueta1 = new JLabel ("numeros");
        etiqueta1.setBounds(10, 30, 150, 30);
        add(etiqueta1);
        
        texto1 = new JTextField();
        texto1.setBounds(200, 30, 150, 30);
        texto1.addKeyListener(this);
        add(texto1);
        
        etiqueta2 = new JLabel ("letras y espacios");
        etiqueta2.setBounds(10, 100, 150, 30);
        add(etiqueta2);
        
        texto2 = new JTextField();
        texto2.setBounds(200, 100, 150, 30);
        texto2.addKeyListener(this);
        add(texto2);
        
        etiqueta3 = new JLabel ("solo enteros");
        etiqueta3.setBounds(10, 170, 150, 30);
        add(etiqueta3);
        
        texto3 = new JTextField();
        texto3.setBounds(200, 170, 150, 30);
        texto3.addKeyListener(this);
        add(texto3);
        
        etiqueta4 = new JLabel ("entero con un decimal");
        etiqueta4.setBounds(10, 240, 150, 30);
        add(etiqueta4);
        
        texto4 = new JTextField();
        texto4.setBounds(200, 240, 150, 30);
        texto4.addKeyListener(this);
        add(texto4);
        
        
        
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char car;
        String cadenita = "123456789";
        String condecimal = "123456789.";
        boolean usado = false;
        boolean usado2 = false;
        
        // solo enteros
        if (e.getSource() == texto1){
            car = e.getKeyChar();
            if( !( (car >= '0') && (car <= '9') ))
                e.consume();
        }else 
            //solo letras y espacios
            if(e.getSource() == texto2){
                car = e.getKeyChar();
                if ( (!((car >= 'a') && (car <='z') )) && (! (car ==' ')) ){
                    e.consume();
                }
            }
            else
                if(e.getSource() == texto3){
                    car = e.getKeyChar();
                    if(cadenita.indexOf(car) == -1)
                        e.consume();
                }
                else 
                    if (e.getSource() == texto4){
                        
                        
                        car = e.getKeyChar();
                        String cade = texto4.getText();
                        
                        if( (condecimal.indexOf(car) == -1))
                            e.consume();
                        else 
                            if (cade.indexOf(".") != -1)
                            usado=true;
                        else 
                                if (cade.indexOf(".") != -1 && car == '.')
                            e.consume();
                        else 
                                    if (car != '.' && usado2)
                            e.consume();
                        else 
                                        if (cadenita.indexOf(car) != -1)
                            usado2 = true;
                            
                           
                    }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
