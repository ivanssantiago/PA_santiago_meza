/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Programacion_juego.Memorama;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class Juego extends javax.swing.JFrame {
    //importamos la clase memorama al paquete interfaz
    private Memorama meme=new Memorama();
    //creamos variable tipo boolean para inicializar caraArriba como false
    private boolean caraArriba=false;
    //variables de tiopo ImageIcon que nos ayudarán a comparar los pares
    private ImageIcon Img1;
    private ImageIcon Img2;
    //arreglo de botones que guarde aquellos que han sido presionados
    private JButton[] push=new JButton[2];
    private boolean primerc=false;
    //puntaje +20 pts si se encuentra un par
    //-5 pts si se falla
    private int puntos=0;
    
    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
        setCards();
    }

    //metodo para orden aleatorio de cartas
    //llamamos a un nuevo objeto tipo memorama
    public void setCards(){
        int[] num=meme.getCardNumbers();
        //DAMOS A LOS BOTONES UNA IMAGEN PARA EL MODO DESHABILITADO
        B1.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[0]+".png")));
        B2.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[1]+".png")));
        B3.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[2]+".png")));
        B4.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[3]+".png")));
        B5.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[4]+".png")));
        B6.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[5]+".png")));
        B7.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[6]+".png")));
        B8.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[7]+".png")));
        B9.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[8]+".png")));
        B10.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[9]+".png")));
        B11.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[10]+".png")));
        B12.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[11]+".png")));
        B13.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[12]+".png")));
        B14.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[13]+".png")));
        B15.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[14]+".png")));
        B16.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes_Simpsons/c"+num[15]+".png")));
        
    }
    
    //método para habilitar y deshabilitar los botones
    
    public void Bx_Habilitado(JButton B){
        if(!caraArriba){
            B.setEnabled(false);
            //YA QUE NO SE PUEDE HACER COMPARACIÓN DIRECTA DE IMÁGENES, SE HARÁ MEDIANTE SUS DESCRIPCIONES
            Img1=(ImageIcon)B.getDisabledIcon();
            push[0]=B;
            caraArriba=true;
            primerc=false;
            
        }
        else
        {
            B.setEnabled(false);
            primerc=true;
            Img2=(ImageIcon)B.getDisabledIcon();
            push[1]=B;
            primerc=true;
            puntos +=20;
            mensaje();
            
        }
    }
    
    //METODO DE COMPARACIÓN DE CARTAS
    
    public void comparar(){
        if(caraArriba && primerc){ 
            if(Img1.getDescription().compareTo(Img2.getDescription())!=0)
            {
                //Si después de voltear dos cartas, estas no son iguales, estas se vuelven a habilitar
                push[0].setEnabled(true);
                push[1].setEnabled(true);
                if(puntos>10){
                    puntos -=5;
                }
                
            }
        caraArriba=false;
        }
    }
     
    //metodo del reinicio del juego
    //habilita de nuevo el uso de botones
    //inicia las condiciones como en un principio
    //vuelve a generar un arreglo aleatorio
    private void reiniciar(){
        B1.setEnabled(true);
        B2.setEnabled(true);
        B3.setEnabled(true);
        B4.setEnabled(true);
        B5.setEnabled(true);
        B6.setEnabled(true);
        B7.setEnabled(true);
        B8.setEnabled(true);
        B9.setEnabled(true);
        B10.setEnabled(true);
        B11.setEnabled(true);
        B12.setEnabled(true);
        B13.setEnabled(true);
        B14.setEnabled(true);
        B15.setEnabled(true);
        B16.setEnabled(true);
        setCards();
        caraArriba=false;
        primerc=false;
        puntos=0;
    }
    
    //mensaje enviado cuando ganas y muestra puntaje
    //verifica que todos los botones esten deshabilitados
    
    private void mensaje(){
        if(!B1.isEnabled() &&
           !B2.isEnabled() &&
           !B3.isEnabled() &&
           !B4.isEnabled() &&
           !B5.isEnabled() &&
           !B6.isEnabled() &&
           !B7.isEnabled() &&
           !B8.isEnabled() &&
           !B9.isEnabled() &&
           !B10.isEnabled() &&
           !B11.isEnabled() &&
           !B12.isEnabled() &&
           !B13.isEnabled() &&
           !B14.isEnabled() &&
           !B15.isEnabled() &&
           !B16.isEnabled())
        {
            JOptionPane.showMessageDialog(this,"FELICIDADES!!!! HAS GANADO MEMORAMA SIMPSON\n\nTu puntaje es:"+puntos,"Ganaste!!!",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        B11 = new javax.swing.JButton();
        B12 = new javax.swing.JButton();
        B13 = new javax.swing.JButton();
        B14 = new javax.swing.JButton();
        B15 = new javax.swing.JButton();
        B16 = new javax.swing.JButton();
        Br = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("¡MEMORAMA SIMPSONS!");

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B1.setBorderPainted(false);
        B1.setContentAreaFilled(false);
        B1.setFocusable(false);
        B1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B1MouseExited(evt);
            }
        });
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B2.setBorderPainted(false);
        B2.setContentAreaFilled(false);
        B2.setFocusable(false);
        B2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B2MouseExited(evt);
            }
        });
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B3.setBorderPainted(false);
        B3.setContentAreaFilled(false);
        B3.setFocusable(false);
        B3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B3MouseExited(evt);
            }
        });
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B4.setBorderPainted(false);
        B4.setContentAreaFilled(false);
        B4.setFocusable(false);
        B4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B4MouseExited(evt);
            }
        });
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B5.setBorderPainted(false);
        B5.setContentAreaFilled(false);
        B5.setFocusable(false);
        B5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B5MouseExited(evt);
            }
        });
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B6.setBorderPainted(false);
        B6.setContentAreaFilled(false);
        B6.setFocusable(false);
        B6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B6MouseExited(evt);
            }
        });
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        B7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B7.setBorderPainted(false);
        B7.setContentAreaFilled(false);
        B7.setFocusable(false);
        B7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B7MouseExited(evt);
            }
        });
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B8.setBorderPainted(false);
        B8.setContentAreaFilled(false);
        B8.setFocusable(false);
        B8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B8MouseExited(evt);
            }
        });
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B9.setBorderPainted(false);
        B9.setContentAreaFilled(false);
        B9.setFocusable(false);
        B9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B9MouseExited(evt);
            }
        });
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });

        B10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B10.setBorderPainted(false);
        B10.setContentAreaFilled(false);
        B10.setFocusable(false);
        B10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B10MouseExited(evt);
            }
        });
        B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B10ActionPerformed(evt);
            }
        });

        B11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B11.setBorderPainted(false);
        B11.setContentAreaFilled(false);
        B11.setFocusable(false);
        B11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B11MouseExited(evt);
            }
        });
        B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B11ActionPerformed(evt);
            }
        });

        B12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B12.setBorderPainted(false);
        B12.setContentAreaFilled(false);
        B12.setFocusable(false);
        B12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B12MouseExited(evt);
            }
        });
        B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B12ActionPerformed(evt);
            }
        });

        B13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B13.setBorderPainted(false);
        B13.setContentAreaFilled(false);
        B13.setFocusable(false);
        B13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B13MouseExited(evt);
            }
        });
        B13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B13ActionPerformed(evt);
            }
        });

        B14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B14.setBorderPainted(false);
        B14.setContentAreaFilled(false);
        B14.setFocusable(false);
        B14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B14MouseExited(evt);
            }
        });
        B14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B14ActionPerformed(evt);
            }
        });

        B15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B15.setBorderPainted(false);
        B15.setContentAreaFilled(false);
        B15.setFocusable(false);
        B15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B15MouseExited(evt);
            }
        });
        B15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B15ActionPerformed(evt);
            }
        });

        B16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/cr.png"))); // NOI18N
        B16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B16.setBorderPainted(false);
        B16.setContentAreaFilled(false);
        B16.setFocusable(false);
        B16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/c0.png"))); // NOI18N
        B16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B16MouseExited(evt);
            }
        });
        B16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B16ActionPerformed(evt);
            }
        });

        Br.setBackground(new java.awt.Color(255, 255, 255));
        Br.setForeground(new java.awt.Color(255, 255, 255));
        Br.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Simpsons/ct.png"))); // NOI18N
        Br.setActionCommand("");
        Br.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Br.setContentAreaFilled(false);
        Br.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B5)
                            .addComponent(B1)
                            .addComponent(B9)
                            .addComponent(B13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B6)
                            .addComponent(B2)
                            .addComponent(B10)
                            .addComponent(B14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(B15)
                                .addGap(18, 18, 18)
                                .addComponent(B16))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(B11)
                                .addGap(18, 18, 18)
                                .addComponent(B12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(B3)
                                .addGap(18, 18, 18)
                                .addComponent(B4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(B7)
                                .addGap(18, 18, 18)
                                .addComponent(B8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Br)
                        .addGap(103, 103, 103))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B2)
                    .addComponent(B1)
                    .addComponent(B3)
                    .addComponent(B4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B6)
                    .addComponent(B5)
                    .addComponent(B7)
                    .addComponent(B8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B10)
                    .addComponent(B9)
                    .addComponent(B11)
                    .addComponent(B12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B14)
                    .addComponent(B13)
                    .addComponent(B15)
                    .addComponent(B16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Br, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //DECLARAMOS LOS EVENTOS POR DEFECTO PARA SER CAMBIADOS Y MODIFICADOS POR EL METODO "Bx_Habilitado"
    
    
    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        Bx_Habilitado(B1);
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        Bx_Habilitado(B2);
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
       Bx_Habilitado(B3);
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        Bx_Habilitado(B4);
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        Bx_Habilitado(B5);
    }//GEN-LAST:event_B5ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
       Bx_Habilitado(B6);
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        Bx_Habilitado(B7);
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        Bx_Habilitado(B8);
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        Bx_Habilitado(B9);
    }//GEN-LAST:event_B9ActionPerformed

    private void B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B10ActionPerformed
        Bx_Habilitado(B10);
    }//GEN-LAST:event_B10ActionPerformed

    private void B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B11ActionPerformed
      Bx_Habilitado(B11);
    }//GEN-LAST:event_B11ActionPerformed

    private void B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B12ActionPerformed
        Bx_Habilitado(B12);
    }//GEN-LAST:event_B12ActionPerformed

    private void B13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B13ActionPerformed
        Bx_Habilitado(B13);
    }//GEN-LAST:event_B13ActionPerformed

    private void B14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B14ActionPerformed
        Bx_Habilitado(B14);
    }//GEN-LAST:event_B14ActionPerformed

    private void B15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B15ActionPerformed
       Bx_Habilitado(B15);
    }//GEN-LAST:event_B15ActionPerformed

    private void B16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B16ActionPerformed
       Bx_Habilitado(B16);
    }//GEN-LAST:event_B16ActionPerformed

    private void B1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseExited
        comparar();
    }//GEN-LAST:event_B1MouseExited

    private void B2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseExited
       comparar();
    }//GEN-LAST:event_B2MouseExited

    private void B3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseExited
     comparar();
    }//GEN-LAST:event_B3MouseExited

    private void B4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseExited
        comparar();
    }//GEN-LAST:event_B4MouseExited

    private void B5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseExited
        comparar();
    }//GEN-LAST:event_B5MouseExited

    private void B6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B6MouseExited
        comparar();
    }//GEN-LAST:event_B6MouseExited

    private void B7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseExited
        comparar();
    }//GEN-LAST:event_B7MouseExited

    private void B8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B8MouseExited
        comparar();
    }//GEN-LAST:event_B8MouseExited

    private void B9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseExited
        comparar();
    }//GEN-LAST:event_B9MouseExited

    private void B10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B10MouseExited
        comparar();
    }//GEN-LAST:event_B10MouseExited

    private void B11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B11MouseExited
      comparar();
    }//GEN-LAST:event_B11MouseExited

    private void B12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B12MouseExited
        comparar();
    }//GEN-LAST:event_B12MouseExited

    private void B13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B13MouseExited
        comparar();
    }//GEN-LAST:event_B13MouseExited

    private void B14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B14MouseExited
      comparar();
    }//GEN-LAST:event_B14MouseExited

    private void B15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B15MouseExited
        comparar();
    }//GEN-LAST:event_B15MouseExited

    private void B16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B16MouseExited
        comparar();
    }//GEN-LAST:event_B16MouseExited

    private void BrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrActionPerformed
        reiniciar();
    }//GEN-LAST:event_BrActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B10;
    private javax.swing.JButton B11;
    private javax.swing.JButton B12;
    private javax.swing.JButton B13;
    private javax.swing.JButton B14;
    private javax.swing.JButton B15;
    private javax.swing.JButton B16;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JButton Br;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
