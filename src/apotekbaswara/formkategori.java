
package apotekbaswara;

import Koneksi_DB.koneksinya;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import Koneksi_DB.koneksinya;
/**
 *
 * @author USER
 */
public class formkategori extends javax.swing.JFrame {

     Statement Stm;
    ResultSet Rs;
    obat fo = null;
    /**
     * Creates new form formkategori
     */
    public formkategori() {
        initComponents();
          Datatabel();
    }

     public void Datatabel(){
       DefaultTableModel tabel = new DefaultTableModel();
       tabel.addColumn("ID KATEGORI");
       tabel.addColumn("NAMA KATEGORI");
       try{
           Statement state  = koneksinya.GetConnection().createStatement();
           Rs = state.executeQuery("Select * from kategori");
           while(Rs.next()){
               tabel.addRow(new Object[]{
                   Rs.getString(1),
                   Rs.getString(2),
               });
               TabelKate.setModel(tabel);
           }
           Stm.close();
           Rs.close();
       }
       catch(Exception e){
           System.out.println(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKate = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelKate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID KATEGORI", "KATEGORI"
            }
        ));
        TabelKate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelKateMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelKate);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelKateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelKateMouseClicked
        // TODO add your handling code here:
        int tabelkate = TabelKate.getSelectedRow();
        fo.idobat = TabelKate.getValueAt(tabelkate, 0).toString();
        fo.katobat = TabelKate.getValueAt(tabelkate, 1).toString();
        fo.Itemterpilih();
        this.dispose();
    }//GEN-LAST:event_TabelKateMouseClicked

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
            java.util.logging.Logger.getLogger(formkategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formkategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formkategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formkategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formkategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelKate;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
