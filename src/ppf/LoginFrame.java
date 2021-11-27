package ppf;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Omar Pulido
 */
class LoginFrame extends JFrame {

    public LoginFrame() throws IOException {

        setLayout(null);

        bgImage = ImageIO.read(getClass().getResourceAsStream("background.jpg"));
        loginImage = ImageIO.read(getClass().getResourceAsStream("login.jpg"));
        registerImage = ImageIO.read(getClass().getResourceAsStream("register.jpg"));

        login = new ImageButton(loginImage);
        register = new ImageButton(registerImage);
        user = new JTextField();
        password = new JPasswordField();
        background = new ImageLabel(bgImage);

        userPlaceholder = new TextPrompt("Usuario", user);
        userPlaceholder.setForeground(new Color(150, 150, 150));

        passPlaceholder = new TextPrompt("Contraseña", password);
        passPlaceholder.setForeground(new Color(150, 150, 150));

        login.setBounds(345, 224, 66, 55);
        register.setBounds(20, 224, 66, 55);
        user.setBounds(115, 44, 221, 27);
        password.setBounds(115, 104, 221, 27);
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginVoid();
                }
            }

        });
        background.setBounds(0, 0, 451, 372);

        ////////////////////////////////////////////////////////////////////////
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    registerFrame regFrame;
                    regFrame = new registerFrame();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                dispose();
            }

        });

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                loginVoid();
            }

        });
        ////////////////////////////////////////////////////////////////////////
        add(login);
        add(register);
        add(user);
        add(password);
        add(background);

        setSize(451, 372);//500,350
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Ingresar:");
        setVisible(true);

    }

    JTextField user;
    JPasswordField password;
    ImageButton login, register;
    ImageLabel background;
    BufferedImage bgImage, loginImage, registerImage;
    TextPrompt userPlaceholder, passPlaceholder;

    void loginVoid(){
                    ArrayUsuarios usuariosLista = new ArrayUsuarios();

                if (Serializar.RECUPERAR_USUARIOS() != null) {

                    usuariosLista.setListaUsuarios(Serializar.RECUPERAR_USUARIOS());

                    if (usuariosLista.buscarUsuario(user.getText()) != null) {
                        Users userLogin = usuariosLista.buscarUsuario(user.getText());

                        if (password.getText().equals(userLogin.getPassword())) {
                            //abrir calculadora
                            GUI gui;
                            try {
                                gui = new GUI();
                                gui.setVisible(true);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            } catch (FontFormatException ex) {
                                System.out.println(ex);
                            }

                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario no existe!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe!");
                }
    }
}

class ImageButton extends JButton {

    private BufferedImage image;

    public ImageButton(BufferedImage img) {
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

////////////////////////////////////////////////////////////////////////////////
class registerFrame extends JFrame {

    public registerFrame() throws IOException {

        setLayout(null);

        bgImage = ImageIO.read(getClass().getResourceAsStream("background.jpg"));
        backImage = ImageIO.read(getClass().getResourceAsStream("goBack.jpg"));
        registerImage = ImageIO.read(getClass().getResourceAsStream("register.jpg"));

        goBack = new ImageButton(backImage);
        register = new ImageButton(registerImage);
        user = new JTextField();
        password = new JPasswordField();
        confirmPassword = new JPasswordField();
        background = new ImageLabel(bgImage);

        userPlaceholder = new TextPrompt("Usuario", user);
        userPlaceholder.setForeground(new Color(150, 150, 150));

        passPlaceholder = new TextPrompt("Contraseña", password);
        passPlaceholder.setForeground(new Color(150, 150, 150));

        confirmPassPlaceholder = new TextPrompt("Confirmar contraseña", confirmPassword);
        
        confirmPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    registerVoid();
                }
            }

        });
        
        confirmPassPlaceholder.setForeground(new Color(150, 150, 150));

        register.setBounds(345, 224, 66, 55);
        goBack.setBounds(20, 224, 66, 55);
        user.setBounds(115, 44, 221, 27);
        password.setBounds(115, 104, 221, 27);
        confirmPassword.setBounds(115, 149, 221, 27);
        background.setBounds(0, 0, 451, 372);

        ////////////////////////////////////////////////////////////////////////
        //configuramos cosas de pantalla de registro
        backImage = ImageIO.read(getClass().getResourceAsStream("goBack.jpg"));

        goBack = new ImageButton(backImage);

        goBack.setBounds(20, 224, 66, 55);
        confirmPassword.setBounds(115, 149, 221, 27);

        ////////////////////////////////////////////////////////////////////////
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                registerVoid();
            }
        });

        goBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    LoginFrame login = new LoginFrame();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                dispose();
            }

        });
        ////////////////////////////////////////////////////////////////////////
        add(goBack);
        add(register);
        add(user);
        add(password);
        add(confirmPassword);
        add(background);

        setSize(451, 372);//500,350
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Registrar:");
        setVisible(true);

    }
    
    void registerVoid (){
    
        String userText = user.getText();
        String passText = password.getText();
        String confPassText = confirmPassword.getText();

        if (!userText.isEmpty() && !passText.isEmpty() && !confPassText.isEmpty()) {
            if (passText.equals(confPassText)) {

                ArrayUsuarios usuariosLista = new ArrayUsuarios();

                if (Serializar.RECUPERAR_USUARIOS() != null) {
                    usuariosLista.setListaUsuarios(Serializar.RECUPERAR_USUARIOS());

                    if (usuariosLista.buscarUsuario(user.getText()) == null) {

                        Users usuario = new Users(user.getText(), password.getText());
                        usuariosLista.agregarUsuario(usuario);
                        Serializar.GUARDAR_USUARIOS(usuariosLista.getListaUsuarios());

                        try {
                            LoginFrame login = new LoginFrame();
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Usuario registrado!");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe ese usuario!");
                    }
                } else {
                    Users usuario = new Users(user.getText(), password.getText());
                    usuariosLista.agregarUsuario(usuario);
                    Serializar.GUARDAR_USUARIOS(usuariosLista.getListaUsuarios());

                    try {
                        LoginFrame login = new LoginFrame();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Usuario registrado!");
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios!");
        }
    }
    
    JTextField user;
    JPasswordField password, confirmPassword;
    ImageButton register, goBack;
    ImageLabel background;
    BufferedImage bgImage, registerImage, backImage;
    TextPrompt userPlaceholder, passPlaceholder, confirmPassPlaceholder;

}


  

