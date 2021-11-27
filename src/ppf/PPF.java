package ppf;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 *
 * @author Omar Pulido
 */
public class PPF {

    public static void main(String[] args) throws IOException, FontFormatException {
        //GUI gui = new GUI();
        //gui.setVisible(true);

        LoginFrame login = new LoginFrame();
    }

}

class GUI extends JFrame {

    //variables de valores de posicion de mouse
    int xMouse, yMouse;
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Herramientas");
    JMenuItem elemento1 = new JMenuItem("Historial de ecuaciones");
    Ecuation ecuation = new Ecuation();

    public GUI(Users user, ArrayUsuarios usuariosLista) throws IOException, FontFormatException {
        //declaramos variable de ecuacion

        //declaramos las fuentes que utilizaremos
        SF65Bold = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Bold.ttf")).deriveFont(Font.PLAIN, 65);
        SF22Bold = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Bold.ttf")).deriveFont(Font.PLAIN, 22);
        SF12Med = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Medium.ttf")).deriveFont(Font.PLAIN, 12);
        SF26SemiBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Semibold.ttf")).deriveFont(Font.PLAIN, 26);
        SF23SemiBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Semibold.ttf")).deriveFont(Font.PLAIN, 23);
        SF20SemiBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Semibold.ttf")).deriveFont(Font.PLAIN, 20);
        SF10Normal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Regular.ttf")).deriveFont(Font.PLAIN, 10);
        SF12Normal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Regular.ttf")).deriveFont(Font.PLAIN, 12);

        //declaramos imagenes que utilizaremos
        impliesLight = ImageIO.read(getClass().getResourceAsStream("impliesLight.png"));
        impliesDark = ImageIO.read(getClass().getResourceAsStream("impliesDark.png"));
        lineDark = ImageIO.read(getClass().getResourceAsStream("lineDark.png"));
        lineLight = ImageIO.read(getClass().getResourceAsStream("lineLight.png"));
        lineNone = ImageIO.read(getClass().getResourceAsStream("lineNone.png"));
        impliesNone = ImageIO.read(getClass().getResourceAsStream("impliesNone.png"));
        lightMode1 = ImageIO.read(getClass().getResourceAsStream("lightMode.png"));
        lightMode2 = ImageIO.read(getClass().getResourceAsStream("lightMode2.png"));
        lightMode3 = ImageIO.read(getClass().getResourceAsStream("lightMode3.png"));
        darkMode1 = ImageIO.read(getClass().getResourceAsStream("darkMode.png"));
        darkMode2 = ImageIO.read(getClass().getResourceAsStream("darkMode2.png"));
        darkMode3 = ImageIO.read(getClass().getResourceAsStream("darkMode3.png"));
        goButton1 = ImageIO.read(getClass().getResourceAsStream("goButton1.png"));
        goButton2 = ImageIO.read(getClass().getResourceAsStream("goButton2.png"));
        goButton3 = ImageIO.read(getClass().getResourceAsStream("goButton3.png"));
        darkButton1 = ImageIO.read(getClass().getResourceAsStream("darkButton1.png"));
        darkButton2 = ImageIO.read(getClass().getResourceAsStream("darkButton2.png"));
        darkButton3 = ImageIO.read(getClass().getResourceAsStream("darkButton3.png"));

        //declaramos usuario
        userEC = user;

        //declaramos lista de usuarios
        listaUsuarios = usuariosLista;

        //declaramos colores
        letter = new Color(0, 0, 0);
        header = new Color(242, 242, 247);
        panelBG = new Color(250, 250, 250);
        results = new Color(255, 255, 255);
        secondLetter = new Color(136, 136, 140);

        darkLetter = new Color(255, 255, 255);
        darkHeader = new Color(44, 44, 46);
        darkPanelBG = new Color(58, 58, 60);
        darkResults = new Color(28, 28, 30);
        darkSecondLetter = new Color(164, 164, 171);

        //declaramos objetos
        equationTextField = new JTextField();
        equationPanel = new JPanel();
        modeImageLabel = new ImageLabel(lightMode1);
        goLabel = new ImageLabel(goButton1);
        closeLabel = new JLabel();
        minLabel = new JLabel();
        resultsPanel = new JPanel();
        despejesPanel = new RoundedPanel(24, panelBG);
        simetriaPanel = new RoundedPanel(24, panelBG);
        intervalosPanel = new RoundedPanel(24, panelBG);
        interceptosPanel = new RoundedPanel(24, panelBG);
        asintPanel = new RoundedPanel(24, panelBG);

        graphPanel = new Grafica();

        //objetos el panel de despesjes
        despejesLabel = new JLabel();
        paso1Label = new JLabel();
        impliesDesp = new ImageLabel(impliesLight);
        impliesDesp2 = new ImageLabel(impliesLight);
        despXLabel = new JLabel();
        despYLabel = new JLabel();
        lineDesp = new ImageLabel(lineLight);
        ////////////////////////////////////////////////////////////////////////////////////////

        //objetos del panel de intervalos
        varLabel = new JLabel();
        paso2Label = new JLabel();
        impliesVar = new ImageLabel(impliesLight);
        impliesVar2 = new ImageLabel(impliesLight);
        varXLabel = new JLabel();
        varYLabel = new JLabel();
        lineVar = new ImageLabel(lineLight);
        ////////////////////////////////////////////////////////////////////////////////////////

        //objetos del panel de simetria
        simLabel = new JLabel();
        paso3Label = new JLabel();
        impliesSim = new ImageLabel(impliesLight);
        impliesSim2 = new ImageLabel(impliesLight);
        simXLabel = new JLabel();
        simYLabel = new JLabel();
        lineSim = new ImageLabel(lineLight);
        ////////////////////////////////////////////////////////////////////////////////////////

        //objetos del panel de interceptos
        interLabel = new JLabel();
        paso4Label = new JLabel();
        impliesInter = new ImageLabel(impliesLight);
        impliesInter2 = new ImageLabel(impliesLight);
        interXLabel = new JLabel();
        interYLabel = new JLabel();
        lineInter = new ImageLabel(lineLight);
        ////////////////////////////////////////////////////////////////////////////////////////

        //objetos del panel de asintotas
        asintLabel = new JLabel();
        paso5Label = new JLabel();
        impliesAsint = new ImageLabel(impliesLight);
        impliesAsint2 = new ImageLabel(impliesLight);
        asintXLabel = new JLabel();
        asintYLabel = new JLabel();
        lineAsint = new ImageLabel(lineLight);
        ////////////////////////////////////////////////////////////////////////////////////////

        //que acabe el programa cuando se cierre el frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //que no tenga botones
        setUndecorated(true);

        //que no se pueda cambiar el tamaño
        setResizable(false);

        //establecer que se vea la ventana en el centro
        setSize(1250, 750);
        setLocationRelativeTo(null);

        setBackground(results);

        //ponerle bordes al frame
        setShape(new RoundRectangle2D.Double(0, 0, 1250, 750, 16, 16));

        //establecer layout absoluto
        getContentPane().setLayout(null);

        //establecer color del panel de ecuaciones
        equationPanel.setBackground(header);
        //mouse listeners a el panel de ecuacion para poder mover la ventana
        equationPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        equationPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });

        modeImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modeImageLabel.setToolTipText("modo oscuro");

        //establecer mouselisteners
        modeImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {

                if (isInDarkMode) {
                    modeImageLabel.setImage(darkMode2);
                } else {
                    modeImageLabel.setImage(lightMode2);
                }

            }

            @Override
            public void mouseExited(MouseEvent evt) {

                if (isInDarkMode) {
                    modeImageLabel.setImage(darkMode1);
                } else {
                    modeImageLabel.setImage(lightMode1);
                }

            }

            @Override
            public void mousePressed(MouseEvent evt) {

                if (isInDarkMode) {
                    modeImageLabel.setImage(darkMode3);
                } else {
                    modeImageLabel.setImage(lightMode3);
                }

            }

            @Override
            public void mouseReleased(MouseEvent evt) {

                if (isInDarkMode) {
                    modeImageLabel.setImage(darkMode1);
                } else {
                    modeImageLabel.setImage(lightMode1);
                }

            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    if (!isInDarkMode) {
                        modeImageLabel.setImage(darkMode1);
                        setDarkMode(true);
                        isInDarkMode = true;
                        graphPanel.setDarkMode(true);
                        modeImageLabel.setToolTipText("modo claro");

                    } else {
                        modeImageLabel.setImage(lightMode1);
                        setDarkMode(false);
                        isInDarkMode = false;
                        graphPanel.setDarkMode(false);
                        modeImageLabel.setToolTipText("modo oscuro");

                    }
                } catch (IOException e) {

                }
            }
        });

        //establecer labels para minimizar y cerrar ventana
        closeLabel.setFont(new Font("Open Sans", 1, 48));
        closeLabel.setForeground(new Color(242, 8, 8));
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel.setText("•");
        closeLabel.setToolTipText("cerrar");
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                closeLabel.setForeground(new Color(195, 11, 11));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                closeLabel.setForeground(new Color(242, 8, 8));
            }
        });

        minLabel.setFont(new Font("Open Sans", 1, 48));
        minLabel.setForeground(new Color(234, 213, 28));
        minLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minLabel.setToolTipText("minimizar");
        minLabel.setText("•");
        minLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setState(Frame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                minLabel.setForeground(new Color(197, 179, 24));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                minLabel.setForeground(new Color(234, 213, 28));
            }
        });
        ////////////////////////////////////////////////////////////////////////

        //estableces configuraciones del textField donde se ingresa la ecuacion
        equationTextField.setBackground(header);
        equationTextField.setFont(SF65Bold);
        equationTextField.setForeground(letter);

        //establecemos placeholder
        placeholder = new TextPrompt("                 ax + by + c = 0", equationTextField);

        placeholder.setForeground(secondLetter);

        //que no se pueda pegar texto en el JTextField
        equationTextField.setTransferHandler(null);

        equationTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    goVoid();
                }
            }

        });

        //validacion de datos del input
        equationTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String numeros = "1234567890";
                String caracteres = "+-=xy";

                String cadena = numeros + caracteres;

                char c = e.getKeyChar();
                String text = equationTextField.getText();

                //no poner caracteres no permitidos
                if (cadena.indexOf(c) == -1) {
                    e.consume();
                } //no repetir 'x', 'y' ni '='
                else if ((text.indexOf(c) != -1) && (c == 'x' || c == 'y' || c == '=')) {
                    e.consume();
                } //no repetir '+' o '-' seguido de un '+' o '-'
                else if (/**/(((text.length() - 1) == text.lastIndexOf('+')) || ((text.length() - 1) == text.lastIndexOf('-')))/**/ && (text.indexOf('+') != -1 || text.indexOf('-') != -1) && (c == '+' || c == '-')) {
                    e.consume();
                }// no poner 'y' antes de que haya un 'x' 
                else if (c == 'y' && text.indexOf('x') == -1) {
                    e.consume();
                }// no poner 'y' antes de que haya un 'x' 
                else if (c == '=' && text.indexOf('y') == -1) {
                    e.consume();
                }//no poner numeros despues de una letra
                else if (numeros.indexOf(c) != -1 && (((text.length() - 1) == text.lastIndexOf('x')) || ((text.length() - 1) == text.lastIndexOf('y'))) && (text.indexOf('x') != -1 || text.indexOf('y') != -1)) {
                    e.consume();
                }//poner solo cero despues del igual
                else if (c != '0' && ((text.length() - 1) == text.lastIndexOf('=')) && text.indexOf('=') != -1) {
                    e.consume();
                }//que se pueda poner solo un cero despues del '='
                else if ((text.length() - 2) == text.lastIndexOf('=') && text.indexOf('=') != -1) {
                    e.consume();
                }//que no se pueda poner igual despues de un 'x' o 'y' o '+' o '-'
                else if (((text.length() - 1) == text.lastIndexOf('+') || (text.length() - 1) == text.lastIndexOf('-') || (text.length() - 1) == text.lastIndexOf('y') || (text.length() - 1) == text.lastIndexOf('x')) && c == '=') {
                    e.consume();
                }//que no se pueda poner 'y' despues de una 'x'
                else if ((text.length() - 1) == text.lastIndexOf('x') && c == 'y') {
                    e.consume();
                }//que no pueda poner 'y' sin un numero antes
                else if ((c == 'x' || c == 'y') && text.length() != 0 && numeros.indexOf(text.charAt(text.length() - 1)) == -1) {
                    e.consume();
                }//que no se pueda poner 'x' sin un numero antes
                else if (text.length() == 0 && c == 'x') {
                    e.consume();
                }
            }
        });

        equationTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //que no se pueda pulsar la flecha de izquierda o derecha
                if ((e.getKeyCode() == 37) || (e.getKeyCode() == 39)) {
                    e.consume();
                }
            }
        });

        equationTextField.setBorder(null);
        equationTextField.setToolTipText("ingresa la ecuacion lineal en su forma general");
        //establecemos icono y mouselisteners para el boton de Go
        goLabel.setIcon(new ImageIcon(getClass().getResource("goButton1.png")));
        goLabel.setToolTipText("Go");
        goLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {

                if (!isInDarkMode) {
                    goLabel.setImage(goButton2);
                } else {
                    goLabel.setImage(darkButton2);
                }

            }

            @Override
            public void mouseExited(MouseEvent evt) {

                if (!isInDarkMode) {
                    goLabel.setImage(goButton1);
                } else {
                    goLabel.setImage(darkButton1);
                }

            }

            @Override
            public void mousePressed(MouseEvent evt) {
                if (!isInDarkMode) {
                    goLabel.setImage(goButton3);
                } else {
                    goLabel.setImage(darkButton3);
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (!isInDarkMode) {
                    goLabel.setImage(goButton2);
                } else {
                    goLabel.setImage(darkButton2);
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                goVoid();
            }
        });

        //configuraciones de groupLayouts del panel de ecuacion
        GroupLayout equationPanelLayout = new GroupLayout(equationPanel);

        equationPanel.setLayout(equationPanelLayout);
        equationPanelLayout.setHorizontalGroup(
                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, equationPanelLayout.createSequentialGroup()
                                .addGroup(equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(equationPanelLayout.createSequentialGroup()
                                                .addGap(49)
                                                .addComponent(modeImageLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(equationPanelLayout.createSequentialGroup()
                                                .addGap(100)
                                                .addComponent(equationTextField, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addGroup(equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, equationPanelLayout.createSequentialGroup()
                                                .addComponent(goLabel)
                                                .addGap(46, 46, 46))
                                        .addGroup(GroupLayout.Alignment.TRAILING, equationPanelLayout.createSequentialGroup()
                                                .addComponent(minLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))))
        );
        equationPanelLayout.setVerticalGroup(
                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(equationPanelLayout.createSequentialGroup()
                                .addGroup(equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(equationPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(modeImageLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(equationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(closeLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(minLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(equationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goLabel))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        //establecemos color del panel de resultados
        resultsPanel.setBackground(results);
        resultsPanel.setAlignmentX(0.0F);
        resultsPanel.setAlignmentY(0.0F);

        //quitamos los bordes a los paneles
        despejesPanel.setBackground(results);
        interceptosPanel.setBackground(results);
        intervalosPanel.setBackground(results);
        simetriaPanel.setBackground(results);
        asintPanel.setBackground(results);
        asintPanel.setPreferredSize(new Dimension(380, 255));
        graphPanel.setBackground(results);

        //configuramos groupLayout de panel de despejes
        despejesPanel.setPreferredSize(new Dimension(380, 255));

        ///////////////////////////////////////////////////////////////////////////////////////////
        //configuramos labels del panel de despejes
        despejesLabel.setFont(SF22Bold);
        despejesLabel.setForeground(letter);
        despejesLabel.setText("Despejes");

        lineDesp.setIcon(new ImageIcon(getClass().getResource("lineNone.png")));

        impliesDesp.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));
        impliesDesp2.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));

        paso1Label.setFont(SF12Med);
        paso1Label.setForeground(secondLetter);
        paso1Label.setText("Paso 1");

        despXLabel.setFont(SF23SemiBold);
        despXLabel.setForeground(letter);
        despXLabel.setText("x = 1 - y ");

        despYLabel.setFont(SF23SemiBold);
        despYLabel.setForeground(letter);
        despYLabel.setText("y = 1 - x ");
        ///////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////
        //configuramos labels del panel de variacion
        varLabel.setFont(SF22Bold);
        varLabel.setForeground(letter);
        varLabel.setText("Intervalos");

        lineVar.setIcon(new ImageIcon(getClass().getResource("lineNone.png")));
        impliesVar.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));
        impliesVar2.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));

        paso2Label.setFont(SF12Med);
        paso2Label.setForeground(secondLetter);
        paso2Label.setText("Paso 2");

        varXLabel.setFont(SF20SemiBold);
        varXLabel.setForeground(letter);
        varXLabel.setText("x \u20AC [ R ]");

        varYLabel.setFont(SF20SemiBold);
        varYLabel.setForeground(letter);
        varYLabel.setText("y \u20AC [ R ]");
        ///////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////
        //configuramos labels del panel de simetria
        simLabel.setFont(SF22Bold);
        simLabel.setForeground(letter);
        simLabel.setText("Simetria");

        lineSim.setIcon(new ImageIcon(getClass().getResource("lineNone.png")));

        impliesSim.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));
        impliesSim2.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));

        paso3Label.setFont(SF12Med);
        paso3Label.setForeground(secondLetter);
        paso3Label.setText("Paso 3");

        simXLabel.setFont(SF26SemiBold);
        simXLabel.setForeground(letter);
        simXLabel.setText("X = NO");

        simYLabel.setFont(SF26SemiBold);
        simYLabel.setForeground(letter);
        simYLabel.setText("Y = NO");
        ///////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////
        //configuramos labels del panel de interceptos
        interLabel.setFont(SF22Bold);
        interLabel.setForeground(letter);
        interLabel.setText("Interceptos");

        lineInter.setIcon(new ImageIcon(getClass().getResource("lineNone.png")));
        impliesInter.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));
        impliesInter2.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));

        paso4Label.setFont(SF12Med);
        paso4Label.setForeground(secondLetter);
        paso4Label.setText("Paso 4");

        interXLabel.setFont(SF26SemiBold);
        interXLabel.setForeground(letter);
        interXLabel.setText("x = (1,0)");

        interYLabel.setFont(SF26SemiBold);
        interYLabel.setForeground(letter);
        interYLabel.setText("y = (0,1)");
        ///////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////
        //configuramos labels del panel de asintotas
        asintLabel.setFont(SF22Bold);
        asintLabel.setForeground(letter);
        asintLabel.setText("Asintotas");

        lineAsint.setIcon(new ImageIcon(getClass().getResource("lineNone.png")));
        impliesAsint.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));
        impliesAsint2.setIcon(new ImageIcon(getClass().getResource("impliesNone.png")));

        paso5Label.setFont(SF12Med);
        paso5Label.setForeground(secondLetter);
        paso5Label.setText("Paso 5");

        asintXLabel.setFont(SF26SemiBold);
        asintXLabel.setForeground(letter);
        asintXLabel.setText("Sin asin horizontales");

        asintYLabel.setFont(SF26SemiBold);
        asintYLabel.setForeground(letter);
        asintYLabel.setText("Sin asin verticales");
        ///////////////////////////////////////////////////////////////////////////////////////////

        //configuracion panel de despejes
        GroupLayout despejesPanelLayout = new GroupLayout(despejesPanel);
        despejesPanel.setLayout(despejesPanelLayout);

        despejesPanelLayout.setHorizontalGroup(
                despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(despejesPanelLayout.createSequentialGroup()
                                                        .addComponent(lineDesp, 250, 250, 250))
                                                .addGroup(GroupLayout.Alignment.LEADING, despejesPanelLayout.createSequentialGroup()
                                                        .addGroup(despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.LEADING, despejesPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesDesp2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(despYLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, despejesPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesDesp, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(despXLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                                .addComponent(despejesLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                .addGap(150)
                                                .addComponent(paso1Label))))
        );
        despejesPanelLayout.linkSize(SwingConstants.HORIZONTAL, lineDesp, despYLabel, despXLabel);//importante

        despejesPanelLayout.setVerticalGroup(
                despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)//margen de arriba

                                .addGroup(despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(despejesLabel)
                                        .addComponent(paso1Label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineDesp)
                                .addGroup(despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)//espacio entre linea y texto
                                                .addComponent(impliesDesp))
                                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)//espacio entre la flecha y el texto
                                                .addComponent(despXLabel)))
                                .addGroup(despejesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)//espacio entre linea y texto
                                                .addComponent(impliesDesp2))
                                        .addGroup(despejesPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)//espacio entre la flecha y el texto
                                                .addComponent(despYLabel)))
                        )
        );

        ///////////////////////////////////////////////////////////////////////////////////////
        //configuraciones del panel de simetria
        simetriaPanel.setPreferredSize(new Dimension(380, 255));

        GroupLayout simetriaPanelLayout = new GroupLayout(simetriaPanel);
        simetriaPanel.setLayout(simetriaPanelLayout);

        /*
         * BRANDONDOC 
         */
        simetriaPanelLayout.setHorizontalGroup(
                simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                .addGap(15)
                                .addGroup(simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(simetriaPanelLayout.createSequentialGroup()
                                                        .addComponent(lineSim, 250, 250, 250))
                                                .addGroup(GroupLayout.Alignment.LEADING, simetriaPanelLayout.createSequentialGroup()
                                                        .addGroup(simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.LEADING, simetriaPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesSim2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(simYLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, simetriaPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesSim, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(simXLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                                .addComponent(simLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                .addGap(150)
                                                .addComponent(paso3Label))))
        );
        simetriaPanelLayout.linkSize(SwingConstants.HORIZONTAL, lineSim, simYLabel, simXLabel);//importante

        simetriaPanelLayout.setVerticalGroup(
                simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                .addGap(26)//margen de arriba

                                .addGroup(simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(simLabel)
                                        .addComponent(paso3Label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineSim)
                                .addGroup(simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesSim))
                                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(simXLabel)))
                                .addGroup(simetriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesSim2))
                                        .addGroup(simetriaPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(simYLabel)))
                        )
        );
        /*
         * BRANDONDOC 
         */

        ////////////////////////////////////////////////////////////////////////////////////
        //configuracion del panel de intervalos
        intervalosPanel.setPreferredSize(new Dimension(380, 255));

        GroupLayout intervalosPanelLayout = new GroupLayout(intervalosPanel);
        intervalosPanel.setLayout(intervalosPanelLayout);

        /*
         * BRANDONDOC 
         */
        intervalosPanelLayout.setHorizontalGroup(
                intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                .addGap(15)
                                .addGroup(intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(intervalosPanelLayout.createSequentialGroup()
                                                        .addComponent(lineVar, 250, 250, 250))
                                                .addGroup(GroupLayout.Alignment.LEADING, intervalosPanelLayout.createSequentialGroup()
                                                        .addGroup(intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.LEADING, intervalosPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesVar2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(varYLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, intervalosPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesVar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(varXLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                                .addComponent(varLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                .addGap(150)
                                                .addComponent(paso2Label))))
        );
        intervalosPanelLayout.linkSize(SwingConstants.HORIZONTAL, lineVar, varYLabel, varXLabel);//importante

        intervalosPanelLayout.setVerticalGroup(
                intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                .addGap(26)//margen de arriba

                                .addGroup(intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(varLabel)
                                        .addComponent(paso2Label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineVar)
                                .addGroup(intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesVar))
                                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(varXLabel)))
                                .addGroup(intervalosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesVar2))
                                        .addGroup(intervalosPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(varYLabel)))
                        )
        );
        /*
         * BRANDONDOC 
         */

//        
        //////////////////////////////////////////////////////////////////////////////////////////
        //configuracion del panel de interceptos
        interceptosPanel.setPreferredSize(new Dimension(380, 255));

        GroupLayout interceptosPanelLayout = new GroupLayout(interceptosPanel);
        interceptosPanel.setLayout(interceptosPanelLayout);
        /*
         * BRANDONDOC 
         */
        interceptosPanelLayout.setHorizontalGroup(
                interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                .addGap(15)
                                .addGroup(interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(interceptosPanelLayout.createSequentialGroup()
                                                        .addComponent(lineInter, 250, 250, 250))
                                                .addGroup(GroupLayout.Alignment.LEADING, interceptosPanelLayout.createSequentialGroup()
                                                        .addGroup(interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.LEADING, interceptosPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesInter2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(interYLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, interceptosPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesInter, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(interXLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                                .addComponent(interLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                .addGap(150)
                                                .addComponent(paso4Label))))
        );
        interceptosPanelLayout.linkSize(SwingConstants.HORIZONTAL, lineInter, interYLabel, interXLabel);//importante

        interceptosPanelLayout.setVerticalGroup(
                interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                .addGap(26)//margen de arriba

                                .addGroup(interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(interLabel)
                                        .addComponent(paso4Label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineInter)
                                .addGroup(interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesInter))
                                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(interXLabel)))
                                .addGroup(interceptosPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesInter2))
                                        .addGroup(interceptosPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(interYLabel)))
                        )
        );
        /*
         * BRANDONDOC 
         */

        //////////////////////////////////////////////////////////////////////////////////////////
        GroupLayout asintPanelLayout = new GroupLayout(asintPanel);
        asintPanel.setLayout(asintPanelLayout);

        /*
         * BRANDONDOC 
         */
        asintPanelLayout.setHorizontalGroup(
                asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(asintPanelLayout.createSequentialGroup()
                                .addGap(15)
                                .addGroup(asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(asintPanelLayout.createSequentialGroup()
                                                        .addComponent(lineAsint, 250, 250, 250))
                                                .addGroup(GroupLayout.Alignment.LEADING, asintPanelLayout.createSequentialGroup()
                                                        .addGroup(asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.LEADING, asintPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesAsint2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(asintYLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.LEADING, asintPanelLayout.createSequentialGroup()
                                                                        .addComponent(impliesAsint, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(asintXLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(asintPanelLayout.createSequentialGroup()
                                                .addComponent(asintLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                .addGap(150)
                                                .addComponent(paso5Label))))
        );
        asintPanelLayout.linkSize(SwingConstants.HORIZONTAL, lineAsint, asintYLabel, asintXLabel);//importante

        asintPanelLayout.setVerticalGroup(
                asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(asintPanelLayout.createSequentialGroup()
                                .addGap(26)//margen de arriba

                                .addGroup(asintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(asintLabel)
                                        .addComponent(paso5Label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lineAsint)
                                .addGroup(asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(asintPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesAsint))
                                        .addGroup(asintPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(asintXLabel)))
                                .addGroup(asintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(asintPanelLayout.createSequentialGroup()
                                                .addGap(27)//espacio entre linea y texto
                                                .addComponent(impliesAsint2))
                                        .addGroup(asintPanelLayout.createSequentialGroup()
                                                .addGap(18)//espacio entre la flecha y el texto
                                                .addComponent(asintYLabel)))
                        )
        );
        /*
         * BRANDONDOC 
         */

        /////////////////////////////////////////////////////////////////////////////////////////////////////
        graphPanel.setPreferredSize(new Dimension(380, 255));

        GroupLayout graphPanelLayout = new GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
                graphPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 240, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
                graphPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 170, Short.MAX_VALUE)
        );

        ///////////////////////////////////////////////////////////////////////////////////////
        //configuraciones del panel que tiene todos los paneles
        GroupLayout resultsPanelLayout = new GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
                resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(interceptosPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(despejesPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(intervalosPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(asintPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(simetriaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        resultsPanelLayout.setVerticalGroup(
                resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, resultsPanelLayout.createSequentialGroup()
                                .addGroup(resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(despejesPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(intervalosPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, resultsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(simetriaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(resultsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(interceptosPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(asintPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(graphPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
        );
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7

        //establecemos los valores de a,b y c para graficar
        graphPanel.setValues(1.25, 1.75, -1.0);

        //añadimos el panel de ecuacion
        equationPanel.setBounds(0, 0, 1250, 161);
        getContentPane().add(equationPanel);

        //añadimos el panel de resultados
        resultsPanel.setBounds(0, 160, 1250, 580);
        getContentPane().add(resultsPanel);

        /*
        GERDOC
         */
        elemento1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //codigo del historial
                ArrayList<Ecuaciones> ecuaciones = new ArrayList();

                ecuaciones = userEC.regresarListaEcuaciones();

                if (!ecuaciones.isEmpty()) {
                    String rows[][] = new String[ecuaciones.size()][12];
                    for (int i = 0; i < ecuaciones.size(); i++) {
                        rows[i][0] = ecuaciones.get(i).getExpresion();
                        rows[i][1] = ecuaciones.get(i).getDespejeX();
                        rows[i][2] = ecuaciones.get(i).getDespejeY();
                        rows[i][3] = ecuaciones.get(i).getIntervaloX();
                        rows[i][4] = ecuaciones.get(i).getIntervaloY();
                        rows[i][5] = ecuaciones.get(i).getSimetriaX();
                        rows[i][6] = ecuaciones.get(i).getSimetriaY();
                        rows[i][7] = ecuaciones.get(i).getSimetriaO();
                        rows[i][8] = ecuaciones.get(i).getInterceptoX();
                        rows[i][9] = ecuaciones.get(i).getInterceptoY();
                        rows[i][10] = ecuaciones.get(i).getAsintotaH();
                        rows[i][11] = ecuaciones.get(i).getAsintotaV();

                    }
                    Object[] cols = {"Expresion", "Desp X", "Desp Y", "Var X", "Var Y", "Sim X", "Sim Y", "Sim O", "Inter X", "Inter Y", "Asin H", "Asin V"};
                    JTable table = new JTable(rows, cols);
                    JScrollPane scrollPane = new JScrollPane(table);

                    JFrame ecFrame = new JFrame();

                    ecFrame.setLayout(null);
                    ecFrame.setSize(1200, 800);
                    ecFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    ecFrame.setResizable(false);
                    ecFrame.setLocationRelativeTo(null);
                    ecFrame.setTitle("Historial de ecuaciones:");
                    scrollPane.setBounds(0, 40, 1200, 760);
                    ecFrame.add(scrollPane);
                    ecFrame.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No hay ecuaciones registradas!");
                }

            }
        });

        menuBar.setBackground(header);
        menuBar.setOpaque(true);
        menuBar.setBorderPainted(false);
        menuBar.setBorder(null);

        menu.setBackground(results);
        menu.setOpaque(true);
        menu.setBorderPainted(false);
        menu.setBorder(null);
        menu.setForeground(secondLetter);

        elemento1.setBackground(panelBG);
        elemento1.setOpaque(true);
        elemento1.setBorderPainted(false);
        elemento1.setBorder(null);
        elemento1.setForeground(secondLetter);

        menu.add(elemento1);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        /*
        GERDOC
         */

    }

    private void goVoid() {

        if (equationTextField.getText().contains("=0")) {
            //parseamos la ecuacion
            ecuation.parseEcuation(equationTextField.getText());

            //resolvemos los pasos del ppf
            EntradaEcuacion ec = new EntradaEcuacion();
            ec.pedirEcuacion(ecuation.getA(), ecuation.getB(), ecuation.getC());

            String simplificar = ec.simplificarEcuacion();
            String ecuacionSimplificada = ec.imprimirEcuacion();

            if (simplificar != null) {
                JOptionPane.showMessageDialog(null, simplificar + "\n" + ecuacionSimplificada);
                this.equationTextField.setText(ecuacionSimplificada);
            }

            String simetrias[];

            int[] ecuacion = ec.getEcuacion();
            String[] literal = ec.getLiteral();
            boolean esEcuacion = ec.esEcuacion();

            //////////////////////////////////////////////////////////////////////
            if (esEcuacion) {

                //la graficamos asignando los valores de a,b y c
                graphPanel.setValues(ecuation.getA(), ecuation.getB(), ecuation.getC());

                Paso_1 ec1 = new Paso_1(ecuacion, literal);
                despXLabel.setText(ec1.despejeX());
                String definicionX = ec1.getDefinicionX();
                despYLabel.setText(ec1.despejeY());
                String definicionY = ec1.getDefinicionY();

                Paso_2 ec2 = new Paso_2(ecuacion, literal);
                varXLabel.setText(ec2.extencionX(definicionX));
                varYLabel.setText(ec2.extencionY(definicionY));

                Paso_3 ec3 = new Paso_3(ecuacion, literal);
                simetrias = ec3.simetrias();
                simXLabel.setText(simetrias[0]);
                simYLabel.setText(simetrias[1]);

                //pendiente = ec3.getPendiente();
                Paso_4 ec4 = new Paso_4(ecuacion, literal, definicionX, definicionY);
                interXLabel.setText(ec4.interseccionX());
                interYLabel.setText(ec4.interseccionY());

                Paso_5 ec5 = new Paso_5(ecuacion, literal);
                asintXLabel.setText(ec5.asintotaH());
                asintYLabel.setText(ec5.asintotaV());
                ec5.asintotas();

                Ecuaciones ecuacionHistorial = new Ecuaciones();
                ecuacionHistorial.setExpresion(ecuacionSimplificada);
                ecuacionHistorial.setDespejeX(ec1.despejeX());
                ecuacionHistorial.setDespejeY(ec1.despejeY());
                ecuacionHistorial.setIntervaloX(ec2.extencionX(definicionX));
                ecuacionHistorial.setIntervaloY(ec2.extencionY(definicionY));
                ecuacionHistorial.setSimetriaX(simetrias[0]);
                ecuacionHistorial.setSimetriaY(simetrias[1]);
                ecuacionHistorial.setSimetriaO(simetrias[2]);
                ecuacionHistorial.setInterceptoX(ec4.interseccionX());
                ecuacionHistorial.setInterceptoY(ec4.interseccionY());
                ecuacionHistorial.setAsintotaH(ec5.asintotaH());
                ecuacionHistorial.setAsintotaV(ec5.asintotaV());

                userEC.agregarEcuacion(ecuacionHistorial);

                Serializar.GUARDAR_USUARIOS(listaUsuarios.getListaUsuarios());

            } else {
                JOptionPane.showMessageDialog(null, "Ingresa una ecuacion valida!");
            }

            //////////////////////////////////////////////////////////////////////
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa una ecuacion valida!");
        }
    }

    public void setDarkMode(boolean bool) throws IOException {
        if (!bool) {
            //configuraciones menu
            menuBar.setBackground(header);
            menuBar.setOpaque(true);
            menuBar.setBorderPainted(false);
            menuBar.setBorder(null);

            menu.setBackground(results);
            menu.setOpaque(true);
            menu.setBorderPainted(false);
            menu.setBorder(null);
            menu.setForeground(secondLetter);

            elemento1.setBackground(panelBG);
            elemento1.setOpaque(true);
            elemento1.setBorderPainted(false);
            elemento1.setBorder(null);
            elemento1.setForeground(secondLetter);

            equationTextField.setForeground(letter);
            despejesLabel.setForeground(letter);
            despXLabel.setForeground(letter);
            despYLabel.setForeground(letter);
            varLabel.setForeground(letter);
            varXLabel.setForeground(letter);
            varYLabel.setForeground(letter);
            simLabel.setForeground(letter);
            simXLabel.setForeground(letter);
            simYLabel.setForeground(letter);
            interLabel.setForeground(letter);
            interXLabel.setForeground(letter);
            interYLabel.setForeground(letter);
            asintLabel.setForeground(letter);
            asintXLabel.setForeground(letter);
            asintYLabel.setForeground(letter);

            equationPanel.setBackground(header);
            equationTextField.setBackground(header);

            despejesPanel.setBGColor(panelBG);
            simetriaPanel.setBGColor(panelBG);
            intervalosPanel.setBGColor(panelBG);
            interceptosPanel.setBGColor(panelBG);
            asintPanel.setBGColor(panelBG);
            //graphPanel.setBGColor(panelBG);

            setBackground(results);
            resultsPanel.setBackground(results);

            despejesPanel.setBackground(results);
            interceptosPanel.setBackground(results);
            intervalosPanel.setBackground(results);
            simetriaPanel.setBackground(results);
            asintPanel.setBackground(results);
            graphPanel.setBackground(results);

            placeholder.setForeground(secondLetter);
            paso1Label.setForeground(secondLetter);
            paso2Label.setForeground(secondLetter);
            paso3Label.setForeground(secondLetter);
            paso4Label.setForeground(secondLetter);
            paso5Label.setForeground(secondLetter);

            goLabel.setImage(goButton1);

            impliesDesp.setImage(impliesLight);
            impliesDesp2.setImage(impliesLight);
            lineDesp.setImage(lineLight);

            impliesVar.setImage(impliesLight);
            impliesVar2.setImage(impliesLight);
            lineVar.setImage(lineLight);

            impliesSim.setImage(impliesLight);
            impliesSim2.setImage(impliesLight);
            lineSim.setImage(lineLight);

            impliesInter.setImage(impliesLight);
            impliesInter2.setImage(impliesLight);
            lineInter.setImage(lineLight);

            impliesAsint.setImage(impliesLight);
            impliesAsint2.setImage(impliesLight);
            lineAsint.setImage(lineLight);

            repaint();
        } else {
            //configs menu
            menuBar.setBackground(darkHeader);
            menuBar.setOpaque(true);
            menuBar.setBorderPainted(false);
            menuBar.setBorder(null);

            menu.setBackground(darkResults);
            menu.setOpaque(true);
            menu.setBorderPainted(false);
            menu.setBorder(null);
            menu.setForeground(darkSecondLetter);

            elemento1.setBackground(darkPanelBG);
            elemento1.setOpaque(true);
            elemento1.setBorderPainted(false);
            elemento1.setBorder(null);
            elemento1.setForeground(darkSecondLetter);

            equationTextField.setForeground(darkLetter);
            despejesLabel.setForeground(darkLetter);
            despXLabel.setForeground(darkLetter);
            despYLabel.setForeground(darkLetter);
            varLabel.setForeground(darkLetter);
            varXLabel.setForeground(darkLetter);
            varYLabel.setForeground(darkLetter);
            simLabel.setForeground(darkLetter);
            simXLabel.setForeground(darkLetter);
            simYLabel.setForeground(darkLetter);
            interLabel.setForeground(darkLetter);
            interXLabel.setForeground(darkLetter);
            interYLabel.setForeground(darkLetter);
            asintLabel.setForeground(darkLetter);
            asintXLabel.setForeground(darkLetter);
            asintYLabel.setForeground(darkLetter);

            equationPanel.setBackground(darkHeader);
            equationTextField.setBackground(darkHeader);

            despejesPanel.setBGColor(darkPanelBG);
            simetriaPanel.setBGColor(darkPanelBG);
            intervalosPanel.setBGColor(darkPanelBG);
            interceptosPanel.setBGColor(darkPanelBG);
            asintPanel.setBGColor(darkPanelBG);
            //graphPanel.setBGColor(darkPanelBG);

            setBackground(darkResults);
            resultsPanel.setBackground(darkResults);

            despejesPanel.setBackground(darkResults);
            interceptosPanel.setBackground(darkResults);
            intervalosPanel.setBackground(darkResults);
            simetriaPanel.setBackground(darkResults);
            asintPanel.setBackground(darkResults);
            graphPanel.setBackground(darkResults);

            placeholder.setForeground(darkSecondLetter);
            paso1Label.setForeground(darkSecondLetter);
            paso2Label.setForeground(darkSecondLetter);
            paso3Label.setForeground(darkSecondLetter);
            paso4Label.setForeground(darkSecondLetter);
            paso5Label.setForeground(darkSecondLetter);

            goLabel.setImage(darkButton1);

            impliesDesp.setImage(impliesDark);
            impliesDesp2.setImage(impliesDark);
            lineDesp.setImage(lineDark);

            impliesVar.setImage(impliesDark);
            impliesVar2.setImage(impliesDark);
            lineVar.setImage(lineDark);

            impliesSim.setImage(impliesDark);
            impliesSim2.setImage(impliesDark);
            lineSim.setImage(lineDark);

            impliesInter.setImage(impliesDark);
            impliesInter2.setImage(impliesDark);
            lineInter.setImage(lineDark);

            impliesAsint.setImage(impliesDark);
            impliesAsint2.setImage(impliesDark);
            lineAsint.setImage(lineDark);

            repaint();
        }
    }

    private final JPanel equationPanel,
            resultsPanel;

    private final RoundedPanel despejesPanel,
            simetriaPanel,
            interceptosPanel,
            //graphPanel,
            intervalosPanel,
            asintPanel;

    private final Grafica graphPanel;

    private final JLabel despXLabel,
            despYLabel,
            minLabel,
            closeLabel,
            paso1Label,
            despejesLabel,
            varLabel,
            paso2Label,
            varXLabel,
            varYLabel,
            simLabel,
            paso3Label,
            simXLabel,
            simYLabel,
            interLabel,
            paso4Label,
            interXLabel,
            interYLabel,
            asintLabel,
            paso5Label,
            asintXLabel,
            asintYLabel;

    private ImageLabel modeImageLabel,
            goLabel,
            impliesDesp,
            impliesDesp2,
            lineDesp,
            impliesVar,
            impliesVar2,
            lineVar,
            impliesSim,
            impliesSim2,
            lineSim,
            impliesInter,
            impliesInter2,
            lineInter,
            impliesAsint,
            impliesAsint2,
            lineAsint;

    private JTextField equationTextField;

    private Color letter,
            header,
            panelBG,
            results,
            secondLetter,
            darkLetter,
            darkHeader,
            darkPanelBG,
            darkResults,
            darkSecondLetter;

    private TextPrompt placeholder;

    private BufferedImage impliesLight, impliesDark, lineDark, lineLight, lineNone, impliesNone, lightMode1, lightMode2, lightMode3, darkMode1, darkMode2, darkMode3, goButton1, goButton2, goButton3, darkButton1, darkButton2, darkButton3;

    private Font SF65Bold, SF22Bold, SF12Med, SF26SemiBold, SF20SemiBold, SF23SemiBold, SF10Normal, SF12Normal;

    private boolean isInDarkMode = false;

    private Users userEC;

    private ArrayUsuarios listaUsuarios;
}

///////////////////////////////////////////////////////////////////////////////
//clase del panel con bordes redondos
class RoundedPanel extends JPanel {

    private Color panelColor;
    private int cornerRadius = 15;

    public RoundedPanel(int radius, Color color) {
        super();
        cornerRadius = radius;
        panelColor = color;
    }

    public void setBGColor(Color bgcolor) {
        panelColor = bgcolor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        //Draws the rounded panel with borders.
        graphics.setColor(panelColor);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background

    }
}

////////////////////////////////////////////////////////////////////////////////
//clase para label con imagen
class ImageLabel extends JLabel {

    private BufferedImage image;

    public ImageLabel(BufferedImage img) {
        super();
        this.image = img;
    }

    public void setImage(BufferedImage newImg) {
        this.image = newImg;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////

class Grafica extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

    Color letter = new Color(0, 0, 0),
            secondLetter = new Color(219, 219, 221),
            purple = new Color(88, 86, 214),
            background = new Color(250, 250, 250),
            darkLetter = new Color(255, 255, 255),
            darkSecondLetter = new Color(73, 73, 76),
            darkPurple = new Color(94, 92, 230),
            darkBackground = new Color(58, 58, 60);

    //VARIABLES PARA GROSOR DE LAS LINEAS
    final static BasicStroke grosor1 = new BasicStroke(1.5f); //thickness

    boolean darkMode = false;

    int puntosInt;
    int Galto = 255, Gancho = 380;       //dimesiones de la zona de graficacion
    int x0, y0;           //origen
    int escalaX, escalaY;
    int aumento1, aumento2;
    int intervaloA, intervaloB;
    int numeroDeInteraciones;
    double xmin, xmax, imgx;

    int offsetX, offsetY;
    boolean dragging;
    double a = 0.0, b = 0.0, c = 0.0;

    Font SF10Normal, SF12Normal;

    public Grafica() throws FontFormatException, IOException {

        SF10Normal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Regular.ttf")).deriveFont(Font.PLAIN, 10);
        SF12Normal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("SF-Regular.ttf")).deriveFont(Font.PLAIN, 12);
        escalaX = 30;
        escalaY = 30;
        x0 = Gancho / 2;
        y0 = Galto / 2;
        aumento1 = 7;

        offsetX = x0;
        offsetY = y0;

        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        setPreferredSize(new Dimension(380, 255));
    }

    public void setDarkMode(boolean bool) {
        darkMode = bool;
        repaint();
    }

    public void setValues(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        repaint();
    }

    public double getYValue(double x) {
        double yValue;
        yValue = ((-a / b) * x) - (c / b);
        return yValue;
    }

    public double getVarValue(char var) {
        double varValue = 0.0;

        switch (var) {
            case 'a': {
                varValue = this.a;
                break;
            }
            case 'b': {
                varValue = this.b;
                break;
            }
            case 'c': {
                varValue = this.c;
                break;
            }
        }
        return varValue;
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (dragging) {
            return;
        }
        int x = evt.getX();  // clic inicial
        int y = evt.getY();
        offsetX = x - x0;
        offsetY = y - y0;
        dragging = true;
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        dragging = false;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        if (dragging == false) {
            return;
        }
        int x = evt.getX();   // posicion del mouse
        int y = evt.getY();
        x0 = x - offsetX;     // mover origen
        y0 = y - offsetY;
        repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent evt) {
        int zoom = evt.getWheelRotation() * 2;

        if ((escalaY - zoom) > 10) {
            escalaY += -zoom;
            escalaX += -zoom;
            repaint();
        }
    }

    //el resto hace nada 
    @Override
    public void mouseMoved(MouseEvent evt) {
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
    }

    @Override
    public void mouseExited(MouseEvent evt) {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!darkMode) {
            Graficar(g, x0, y0, letter, secondLetter, purple, background);
        } else {
            Graficar(g, x0, y0, darkLetter, darkSecondLetter, darkPurple, darkBackground);
        }
    }

    //METODO QUE PINTA TODA LA GRAFICA
    void Graficar(Graphics ap, int xg, int yg, Color l, Color sL, Color p, Color bg) {

        Dimension arcs = new Dimension(15, 15);
        int width = getWidth();
        int height = getHeight();
        int xi, yi, xi1, yi1;
        int cxmin, cxmax, cymin, cymax;
        double valxi, valxi1, valyi, valyi1;

        //convertimos el objeto ap en un objeto Graphics2D para usar los metodos Java2D
        Graphics2D g = (Graphics2D) ap;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //dibuja el panel con bordes redondeados
        g.setColor(bg);
        g.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background

        g.setFont(SF10Normal);

        g.setColor(l);
        //PINTAMOS EL EJE X Y EL EJE Y
        g.draw(new Line2D.Double(xg, 0, xg, Galto - 0)); //EJE Y
        g.draw(new Line2D.Double(0, yg, Gancho - 0, yg));//EJE X

        xmin = (float) -xg / escalaX;
        xmax = (float) (Gancho - xg) / escalaX;
        cxmin = (int) Math.round(xmin); //pantalla
        cxmax = (int) Math.round(xmax);

        intervaloA = cxmin;
        intervaloB = cxmax;

        //intervalos para pintar funcion
        cymin = (int) Math.round((double) -(Galto - yg) / escalaY);
        cymax = (int) Math.round((double) (yg + 5 * escalaY) / escalaY); //--------------------------------------------------------------------------------------------------I GOT IT GG---------------------------------

        g.setPaint(sL); //COLOR CUADRICULA
        g.setFont(SF10Normal);

        //PINTAMOS TODOS LOS EJES PARA FORMAR LA CUADRICULA
        if (escalaX > 5) //--------------------------------------------------------------------------------------------------------------------------------------------24 A MI PARECER ES LA ESCALA MINIMA----------------------------------
        {
            for (int i = cxmin; i <= cxmax; i++) {   //EJES PARALELOS AL EJE Y
                g.setPaint(sL); //COLOR CUADRICULA
                double coordenadaX = xg + i * escalaX;

                //                g.draw(new Line2D.Double(coordenadaX, yg - 2, coordenadaX, yg + 2)); --------------------------------------------------------------------------CREO QUE ESTO NO SE OCUPA
                if (coordenadaX != xg) {
                    g.draw(new Line2D.Double(coordenadaX, 0, coordenadaX, Galto));//-------------------------------------------------------------------------QUITAR 10 Y -0 
                }
                if (i != 0) { //-----------------------------------------------------------------------------------------------------------DIBUJAR NUMEROS  OPTIMIZADO----------------------
                    g.setPaint(l);//COLOR NUMEROS
                    g.drawString("" + i, Math.round(coordenadaX) - aumento1, yg + 12);
                }
            }
        }

        if (escalaY > 5) {
            for (int i = cymin; i < cymax; i++) {   //EJES PARALELOS AL EJE X
                g.setPaint(sL); //COLOR CUADRICULA
                double coordenadaY = yg - i * escalaY;

                //g.draw(new Line2D.Double(xg - 2, coordenadaY, xg + 2, coordenadaY));
                if (coordenadaY != yg) {
                    g.draw(new Line2D.Double(0, coordenadaY, Gancho, coordenadaY));
                }

                String numMostrar = String.valueOf(i);
                int widthNum = g.getFontMetrics().stringWidth(numMostrar) + 5;
                if (i != 0) {    //----------------------------------------------------------------------------------------------------------------------------------------------------IF OPTIMIZADO, INCLUSO AUN MAS-------------------------------------------
                    g.setPaint(l);//COLOR NUMEROS
                    g.drawString(numMostrar, xg - widthNum, Math.round(coordenadaY) - 2);
                }

            }
        }

        g.setPaint(p);//COLOR DE LA FUNCION

        g.setStroke(grosor1);

        //for que pinta la linea
        if (getVarValue('a') != 0.0 && getVarValue('b') != 0.0) {
            for (int i = (xg + intervaloA * escalaX); i < (xg + intervaloB * escalaY) - 1; i++) {
                valxi = xmin + i * 1.0 / escalaX;
                valxi1 = xmin + (i + 1) * 1.0 / escalaX;
                valyi = getYValue(valxi);
                valyi1 = getYValue(valxi1);
                xi = (int) Math.round(escalaX * (valxi));
                yi = (int) Math.round(escalaY * valyi);
                xi1 = (int) Math.round(escalaX * (valxi1));
                yi1 = (int) Math.round(escalaY * valyi1);

                g.draw(new Line2D.Double(xg + xi, yg - yi, xg + xi1, yg - yi1));
            }
            //checha si a o sea x = 0
        } else if (getVarValue('a') == 0.0) {
            for (int i = (xg + intervaloA * escalaX); i < (xg + intervaloB * escalaY) - 1; i++) {
                valxi = xmin + i * 1.0 / escalaX;
                valxi1 = xmin + (i + 1) * 1.0 / escalaX;

                valyi = (-1 * (this.c / this.b));
                valyi1 = (-1 * (this.c / this.b));

                xi = (int) Math.round(escalaX * (valxi));
                yi = (int) Math.round(escalaY * valyi);
                xi1 = (int) Math.round(escalaX * (valxi1));
                yi1 = (int) Math.round(escalaY * valyi1);

                g.draw(new Line2D.Double(xg + xi, yg - yi, xg + xi1, yg - yi1));
            }
            //checa si b o sea y = 0
        } else if (getVarValue('b') == 0.0) {
            for (int i = (yg + intervaloA * escalaX); i < (yg + intervaloB * escalaY) - 1; i++) {
                valyi = xmin + i * 1.0 / escalaY;
                valyi1 = xmin + (i + 1) * 1.0 / escalaY;

                valxi = (-1.0 * (this.c / this.a));
                valxi1 = (-1.0 * (this.c / this.a));

                xi = (int) Math.round(escalaX * (valxi));
                yi = (int) Math.round(escalaY * valyi);
                xi1 = (int) Math.round(escalaX * (valxi1));
                yi1 = (int) Math.round(escalaY * valyi1);

                g.draw(new Line2D.Double(xg + xi, yg - yi, xg + xi1, yg - yi1));
            }
        }
    }
}

class TextPrompt extends JLabel
        implements FocusListener, DocumentListener {

    private Document document;

    private int focusLost;

    public TextPrompt(String text, JTextComponent component) {
        document = component.getDocument();

        setText(text);
        setFont(component.getFont());
        setForeground(component.getForeground());
        setBorder(new EmptyBorder(component.getInsets()));
        setHorizontalAlignment(JLabel.LEADING);

        component.addFocusListener(this);
        document.addDocumentListener(this);

        component.setLayout(new BorderLayout());
        component.add(this);
        checkForPrompt();
    }

    private void checkForPrompt() {
        if (document.getLength() > 0) {
            setVisible(false);
            return;
        }

        setVisible(true);
    }

//  Implement FocusListener
    @Override
    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    @Override
    public void focusLost(FocusEvent e) {
        focusLost++;
        checkForPrompt();
    }

//  Implement DocumentListener
    @Override
    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}

///////////////////////////////////////////////////////////////////////////////
class Ecuation {

    double a = 0.0, b = 0.0, c = 0.0;

    public void parseEcuation(String ecuation) {
        String ecNo0 = ecuation.replace("=0", "");
        a = Double.parseDouble(ecNo0.substring(0, ecNo0.indexOf('x')));
        b = Double.parseDouble(ecNo0.substring(ecNo0.indexOf('x') + 1, ecNo0.indexOf('y')));
        c = Double.parseDouble(ecNo0.substring(ecNo0.indexOf('y') + 1, ecNo0.length()));
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }
}
