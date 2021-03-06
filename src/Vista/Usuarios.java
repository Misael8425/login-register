//Misael Mejia Guerrero 2021-0331//

package Vista;

import Connection.Conexion;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuarios extends javax.swing.JFrame {

    public static Login frmLog;
    
    public Usuarios() {
        initComponents();
        
        try
        {
            
            DefaultTableModel Modelo = new DefaultTableModel();
            jtUsuarios.setModel(Modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion Con = new Conexion();
            Connection Conect = Con.getConexion();
            
            String sql = "Select Nombre_de_usuario, Nombre, Apellido, Número_de_teléfono, Correo_electrónico FROM usuarios";
            ps = Conect.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int CantCol = rsMd.getColumnCount();
            
            Modelo.addColumn("Nombre de usuario");
            Modelo.addColumn("Nombre");
            Modelo.addColumn("Apellido");
            Modelo.addColumn("Número de teléfono");
            Modelo.addColumn("Correo electrónico");
            
            
            while(rs.next()) {
                
                Object[] Filas = new Object[CantCol];
                
                for(int i = 0; i< CantCol; i++){
                    
                    Filas[i] = rs.getObject(i + 1);
                    
                }
                
                Modelo.addRow(Filas);
                
            }
            
        } catch (SQLException ex){
            System.out.println(ex.toString());
        
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar_Sesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre de usuario", "Nombre", "Apellido", "Número de teléfono", "Correo electrónico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuarios.setGridColor(new java.awt.Color(51, 51, 51));
        jtUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtUsuarios);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar_Sesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrar_Sesion.setText("Cerrar Sesion");
        btnCerrar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar_SesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnActualizar)
                        .addGap(88, 88, 88)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnCerrar_Sesion)))
                .addContainerGap(163, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(40, 40, 40)
                .addComponent(btnCerrar_Sesion)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
         try
        {
            
            DefaultTableModel Modelo = new DefaultTableModel();
            jtUsuarios.setModel(Modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion Con = new Conexion();
            Connection Conect = Con.getConexion();
            
            String sql = "Select Nombre_de_usuario, Nombre, Apellido, Número_de_teléfono, Correo_electrónico FROM usuarios";
            ps = Conect.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int CantCol = rsMd.getColumnCount();
            
            Modelo.addColumn("Nombre de usuario");
            Modelo.addColumn("Nombre");
            Modelo.addColumn("Apellido");
            Modelo.addColumn("Número de teléfono");
            Modelo.addColumn("Correo electrónico");
            
            
            while(rs.next()) {
                
                Object[] Filas = new Object[CantCol];
                
                for(int i = 0; i< CantCol; i++){
                    
                    Filas[i] = rs.getObject(i + 1);
                    
                }
                
                Modelo.addRow(Filas);
                
            }
            
        } catch (SQLException ex){
            System.out.println(ex.toString());
        
        }
        
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
            PreparedStatement Borrar = null;
            
            Conexion Con = new Conexion();
            Connection Conect = Con.getConexion();
            
            int fila = jtUsuarios.getSelectedRow();
            String Nombre_de_usuario = jtUsuarios.getValueAt(fila,0).toString();
            
            int C = JOptionPane.showConfirmDialog(null,"¿Desea eliminar este usuario?", "Usuarios", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(C == JOptionPane.YES_NO_OPTION){
                
        
        try {
            
            DefaultTableModel Modelo = new DefaultTableModel();
            jtUsuarios.setModel(Modelo);
            
            Borrar = Conect.prepareStatement("DELETE FROM usuarios WHERE Nombre_de_usuario = ?");
            Borrar.setString(1, Nombre_de_usuario);
            Borrar.execute();
            
            Modelo.removeRow(fila);
            
        }catch (SQLException ex){
            System.out.println(ex.toString());
        
        
}
            }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar_SesionActionPerformed
       
        Login.frmUser= null;
        this.dispose();
                
        Login frmLog = new Login();
        frmLog.setVisible(true);
        
        if(frmLog == null){
            
            frmLog = null;
            this.dispose();
            
            frmLog = new Login();
            frmLog.setVisible(true);
            
            
        }
        
    }//GEN-LAST:event_btnCerrar_SesionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
           Login.frmUser = null;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar_Sesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUsuarios;
    // End of variables declaration//GEN-END:variables
}
