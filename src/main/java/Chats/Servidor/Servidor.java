/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chats.Servidor;

import Object.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author PERSONAL
 */
public class Servidor extends javax.swing.JFrame {

    static ServerSocket servidor = null;
    static Socket sc = null;
    static DataInputStream in;
    static DataOutputStream out; 
    static ObjectInputStream objectIn;
    static DefaultListModel lstModel = new DefaultListModel();
    
    public Servidor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txta_msgServer = new javax.swing.JTextArea();
        txt_msgSendServer = new javax.swing.JTextField();
        btn_Servidor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFiles = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnIniciarServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txta_msgServer.setEditable(false);
        txta_msgServer.setColumns(20);
        txta_msgServer.setRows(5);
        jScrollPane1.setViewportView(txta_msgServer);

        txt_msgSendServer.setToolTipText("");
        txt_msgSendServer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btn_Servidor.setText("Enviar Respuesta");
        btn_Servidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ServidorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SERVIDOR");

        lstFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstFilesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstFiles);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Archivos Cargados");

        btnOpen.setText("Abrir");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnIniciarServer.setText("Iniciar");
        btnIniciarServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_msgSendServer, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnSave))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIniciarServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnIniciarServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_msgSendServer, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnOpen)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Servidor)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ServidorActionPerformed
        try {
            String mensajeSalida = "";
            mensajeSalida = txt_msgSendServer.getText().trim();
            out.writeUTF(mensajeSalida); //Enviar un mensaje
            txt_msgSendServer.setText("");
        } catch (Exception e) {
            System.out.println("No se pudo enviar el mensaje!: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_ServidorActionPerformed

    private void lstFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFilesMouseClicked
        if (evt.getClickCount() == 2) {
            if (!lstFiles.isSelectionEmpty()) {
                if (SwingUtilities.isLeftMouseButton(evt)) {
                    open();
                } else if (SwingUtilities.isRightMouseButton(evt)) {
                    save();
                }

            }
        }
    }//GEN-LAST:event_lstFilesMouseClicked

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        if (!lstFiles.isSelectionEmpty()) {
            open();
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!lstFiles.isSelectionEmpty()) {
            save();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnIniciarServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarServerActionPerformed
        lstFiles.setModel(lstModel);
         new Thread(new Runnable() {
            @Override
            public void run() {
                String msgEntrada = "";
                try {
                    servidor = new ServerSocket(2345);
                    System.out.println("Servidor Iniciado en el puerto " + servidor.getLocalPort());
                    txta_msgServer.append("Server Iniciado ...\n");
                    sc = servidor.accept(); //Se queda a la espera

                    in = new DataInputStream(sc.getInputStream()); // Se crea la comunicación, sirve para leer o recibir los mensajes del cliente.
                    out = new DataOutputStream(sc.getOutputStream());
                    objectIn = new ObjectInputStream(sc.getInputStream()); // Sirve para leer o recibir objetos
                    Data data = (Data) objectIn.readObject();
                    String name = data.getName();
                    txta_msgServer.append("Cliente Nuevo: " + name + " está Conectado \n");
//                    while(!msgEntrada.equals("exit")){
//                        msgEntrada = in.readUTF();
//                        txta_msgServer.setText(txta_msgServer.getText().trim() + "\nCliente: \t" + msgEntrada);
//                    }
                    while (true) {
                        data = (Data) objectIn.readObject();
                        lstModel.addElement(data);
                        txta_msgServer.append("\nArchivo Recibido: " + data.getName() + "\n");
                        //while(!msgEntrada.equals("exit")){
                        //    msgEntrada = in.readUTF();
                        //    txta_msgServer.setText(txta_msgServer.getText().trim() + "\nCliente: \t" + msgEntrada);
                        //}
                    }

                } catch (IOException e) {
                    System.out.println("Error en el Servidor!: " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error:" + e.getLocalizedMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }//GEN-LAST:event_btnIniciarServerActionPerformed

    private void open() {
        Data data = (Data) lstModel.getElementAt(lstFiles.getSelectedIndex());
        if (data.getStatus().equals("Image")) {
            MostrarImagen obj = new MostrarImagen(this, true);
            ImageIcon icon = new ImageIcon(data.getFile());
            obj.set(icon);
            obj.setVisible(true);
        }
    }

    private void save() {
        Data data = (Data) lstModel.getElementAt(lstFiles.getSelectedIndex());
        JFileChooser ch = new JFileChooser();
        int c = ch.showSaveDialog(this);
        if (c == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream out = new FileOutputStream(ch.getSelectedFile());
                out.write(data.getFile());
                out.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Servidor().setVisible(true);
        });
        
//        lstFiles.setModel(lstModel);
//        String msgEntrada = "";
//        try {
//            servidor = new ServerSocket(2345);
//            System.out.println("Servidor Iniciado en el puerto " + servidor.getLocalPort());
//            sc = servidor.accept(); //Se queda a la espera
//            
//            in = new DataInputStream(sc.getInputStream()); // Se crea la comunicación, sirve para leer o recibir los mensajes del cliente.
//            out = new DataOutputStream(sc.getOutputStream());
//            objectIn = new ObjectInputStream(sc.getInputStream()); // Sirve para leer o recibir objetos
//            Data data;
//            data = (Data) objectIn.readObject();
//            String name = data.getName();
//            txta_msgServer.append("Nuevo Cliente " + name + " esta conectado ...\n");
//            while(!msgEntrada.equals("exit")){
//                msgEntrada = in.readUTF();
//                data = (Data) objectIn.readObject();
//                lstModel.addElement(data);
//                txta_msgServer.append("Archivo Recibido... \n");
//                txta_msgServer.setText(txta_msgServer.getText().trim() + "\nCliente: \t" + msgEntrada);
//            }
//            
//        } catch (IOException e) {
//            System.out.println("Error en el Servidor!: " + e.getMessage());
//            JOptionPane.showMessageDialog(null,"Error en el Servidor: " + e.getMessage());
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarServer;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_Servidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JList<String> lstFiles;
    private javax.swing.JTextField txt_msgSendServer;
    private static javax.swing.JTextArea txta_msgServer;
    // End of variables declaration//GEN-END:variables
}
