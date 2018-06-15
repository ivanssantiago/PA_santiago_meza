
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ángel Acaymo M. G. (Meta).
 */
//##############################JM################################################
/* La clase debe implementar la interfaz SerialPortEventListener porque esta 
 misma clase será la encargada de trabajar con el evento escucha cuando reciba 
 datos el puerto serie. */
public class EP_JAVA_Frame extends javax.swing.JFrame implements SerialPortEventListener {
//##############################JM################################################

    /**
     * Creates new form EP_JAVA_Frame
     */
    // Variables.
    private static final String Led_8_ON = "Led_8_ON";
    private static final String Led_8_OFF = "Led_8_OFF";
    private static final String Led_13_ON = "Led_13_ON";
    private static final String Led_13_OFF = "Led_13_OFF";

    // Variables de conexión.
    private OutputStream output = null;
//##############################JM################################################
/* Así como declaraste una variable ouuput para obtener el canal de salida 
     también creamos una variable para obtener el canal de entrada. */
    private InputStream input = null;
//##############################JM################################################
    SerialPort serialPort;
    private final String PUERTO = "COM4";
    private static final int TIMEOUT = 2000; // 2 segundos.
    private static final int DATA_RATE = 115200; // Baudios.

    public EP_JAVA_Frame() {
        initComponents();
        inicializarConexion();
    }

    public void inicializarConexion() {
        CommPortIdentifier puertoID = null;
        Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();

        while (puertoEnum.hasMoreElements()) {
            CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
            if (PUERTO.equals(actualPuertoID.getName())) {
                puertoID = actualPuertoID;
                break;
            }
        }

        if (puertoID == null) {
            mostrarError("No se puede conectar al puerto");
            System.exit(ERROR);
        }

        try {
            serialPort = (SerialPort) puertoID.open(this.getClass().getName(), TIMEOUT);
            // Parámatros puerto serie.

            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_2, SerialPort.PARITY_NONE);

            output = serialPort.getOutputStream();
        } catch (Exception e) {
            mostrarError(e.getMessage());
            System.exit(ERROR);
        }
//##############################JM################################################
/* Aquií asignamos el canal de entrada del puerto serie a nuestra variable input, 
         con sus debido capturador de error. */
        try {
            input = serialPort.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(EP_JAVA_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Aquí agregamos el evento de escucha del puerto serial a esta misma clase 
         (recordamos que nuestra clase implementa SerialPortEventListener), el método que 
         sobreescibiremos será serialevent. */
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException ex) {
            Logger.getLogger(EP_JAVA_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
//##############################JM################################################
    }
//##############################JM################################################
/* Este evento es el que sobreescribiremos de la interfaz SerialPortEventListener, 
     este es lanzado cuando se produce un evento en el puerto como por ejemplo 
     DATA_AVAILABLE (datos recibidos) */

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            byte[] readBuffer = new byte[20];
            try {
                int numBytes = 0;
                while (input.available() > 0) {
                    numBytes = input.read(readBuffer); //Hacemos uso de la variable input que 
//creamos antes, input es nuestro canal de entrada.
                }
                jTextArea1.append(new String(readBuffer, 0, numBytes, "us-ascii")); // Convertimos de bytes a String y asignamos al JTEXTAREA.
                
                // Leelos últimos datos.
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
//##############################JM################################################    

    private void enviarDatos(String datos) {
        try {
            output.write(datos.getBytes());
        } catch (Exception e) {
            mostrarError("ERROR");
            System.exit(ERROR);
        }
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini Interfaz Java");

        jLabel1.setText("Led 8");

        jLabel2.setText("Led 13");

        jButton1.setText("ON");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("OFF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ON");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("OFF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Mensajes desde Arduino:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("jLabel_Led_8");
        jButton1.getAccessibleContext().setAccessibleName("jButton_Led_8_ON");
        jButton2.getAccessibleContext().setAccessibleName("jButton_Led_8_OFF");
        jButton3.getAccessibleContext().setAccessibleName("jButton_Led_13_ON");
        jButton4.getAccessibleContext().setAccessibleName("jButton_Led_13_OFF");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        enviarDatos(Led_8_ON); // Enciende Led 8.
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        enviarDatos(Led_8_OFF); // Apaga Led 8.
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        enviarDatos(Led_13_ON); // Enciende Led 13.
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        enviarDatos(Led_13_OFF); // Apaga Led 13.
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(EP_JAVA_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EP_JAVA_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EP_JAVA_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EP_JAVA_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EP_JAVA_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
