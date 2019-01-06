/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author AHSAN
 */
public class frmRental extends javax.swing.JFrame {
private Connection con;
    private Statement st;
    private ResultSet RsRental;
    private ResultSet RsMobil;
    private ResultSet RsPenyewa;
    private String sql="";
    
    private String tanggal,idrental,idmobil,idpenyewa,namapenyewa,namamobil,bm,status,statusb;
    private int harga;
    /**
     * Creates new form frmRental
     */
    public frmRental() {
        initComponents();
        KoneksiRental();
        TampilData(sql);
    }
    
    private void KoneksiRental(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rental_mobil", "root","");
            System.out.println("Koneksi Berhasil");
        } catch (Exception e){
            System.out.println("Koneksi Gagal \n"+e);
        }
    }
    
    private void TampilData (String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID RENTAL");
        datalist.addColumn("ID MOBIL");
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("HARGA RENTAL");
        datalist.addColumn("TANGGAL RENTAL");
        datalist.addColumn("STATUS");
        try{
            int i = 1;
            st=con.createStatement();
            RsRental=st.executeQuery("select * from tb_rental");
            while (RsRental.next())
                datalist.addRow(new Object[]{
                (""+i++),
                RsRental.getString(1), RsRental.getString(2),
                RsRental.getString(3), RsRental.getString(6),
                RsRental.getString(7), RsRental.getString(8)});
            TABEL2.setModel(datalist);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
        }
    }
    
    private void bersih(){
        Txt_bm.setText("");
        Txt_harga.setText("");
        Txt_id_rental.setText("");
        Txt_nama_mobil.setText("");
        Txt_nama_penyewa.setText("");
        Txt_status.setText("");
        Txt_nama_mobil.setText("");
        Cmb_id_mobil.setSelectedItem("PILIH");
        Cmb_id_penyewa.setSelectedItem("PILIH");
        Cmb_status.setSelectedItem("PILIH");
        
        
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
        jLabel1 = new javax.swing.JLabel();
        Txt_id_rental = new javax.swing.JTextField();
        Cmb_status = new javax.swing.JComboBox();
        BTN_SIMPAN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BTN_EDIT = new javax.swing.JButton();
        BTN_BATAL = new javax.swing.JButton();
        BTN_HAPUS = new javax.swing.JButton();
        BTN_KELUAR = new javax.swing.JButton();
        Txt_nama_mobil = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_bm = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Txt_harga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Txt_nama_penyewa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tanggalrental = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Txt_status = new javax.swing.JTextField();
        Cmb_id_mobil = new javax.swing.JComboBox();
        Cmb_id_penyewa = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(660, 497));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID RENTAL");

        Txt_id_rental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_id_rentalActionPerformed(evt);
            }
        });
        Txt_id_rental.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_id_rentalKeyPressed(evt);
            }
        });

        Cmb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "SEWA" }));
        Cmb_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_statusActionPerformed(evt);
            }
        });

        BTN_SIMPAN.setBackground(new java.awt.Color(255, 255, 255));
        BTN_SIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/save.png"))); // NOI18N
        BTN_SIMPAN.setText("SIMPAN");
        BTN_SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SIMPANActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/pinjam2.png"))); // NOI18N

        BTN_EDIT.setBackground(new java.awt.Color(255, 255, 255));
        BTN_EDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/edit.png"))); // NOI18N
        BTN_EDIT.setText("EDIT");
        BTN_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EDITActionPerformed(evt);
            }
        });

        BTN_BATAL.setBackground(new java.awt.Color(255, 255, 255));
        BTN_BATAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/save-and-close.png"))); // NOI18N
        BTN_BATAL.setText("BATAL");
        BTN_BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BATALActionPerformed(evt);
            }
        });

        BTN_HAPUS.setBackground(new java.awt.Color(255, 255, 255));
        BTN_HAPUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/delete.png"))); // NOI18N
        BTN_HAPUS.setText("HAPUS");
        BTN_HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HAPUSActionPerformed(evt);
            }
        });

        BTN_KELUAR.setBackground(new java.awt.Color(255, 255, 255));
        BTN_KELUAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/close.png"))); // NOI18N
        BTN_KELUAR.setText("KELUAR");
        BTN_KELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_KELUARActionPerformed(evt);
            }
        });

        Txt_nama_mobil.setEnabled(false);
        Txt_nama_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_nama_mobilActionPerformed(evt);
            }
        });

        jLabel3.setText("NAMA MOBIL");

        jLabel4.setText("ID MOBIL");

        jLabel5.setText("PILIHAN SEWA");

        jLabel6.setText("ID PENYEWA");

        Txt_bm.setEnabled(false);
        Txt_bm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_bmActionPerformed(evt);
            }
        });

        jLabel8.setText("BM MOBIL");

        Txt_harga.setEnabled(false);
        Txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_hargaActionPerformed(evt);
            }
        });

        jLabel9.setText("HARGA RENTAL");

        Txt_nama_penyewa.setEnabled(false);
        Txt_nama_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_nama_penyewaActionPerformed(evt);
            }
        });

        jLabel10.setText("NAMA PENYEWA");

        tanggalrental.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalrentalPropertyChange(evt);
            }
        });

        jLabel11.setText("TANGGAL");

        jLabel12.setText("STATUS");

        Txt_status.setEnabled(false);
        Txt_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_statusActionPerformed(evt);
            }
        });

        Cmb_id_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_id_mobilActionPerformed(evt);
            }
        });

        Cmb_id_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_id_penyewaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/Home.png"))); // NOI18N
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(74, 74, 74)
                        .addComponent(Txt_status))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_id_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cmb_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cmb_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addComponent(Txt_nama_mobil))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_bm, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_harga)
                            .addComponent(Txt_nama_penyewa)
                            .addComponent(tanggalrental, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BTN_BATAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_HAPUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_SIMPAN))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_KELUAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txt_id_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_SIMPAN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_BATAL)
                            .addComponent(Cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_EDIT)
                            .addComponent(jLabel6)
                            .addComponent(Cmb_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_HAPUS)
                            .addComponent(jLabel4)
                            .addComponent(Cmb_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jButton1)))
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_KELUAR)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(Txt_bm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalrental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(Txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        TABEL2.setBackground(new java.awt.Color(204, 204, 204));
        TABEL2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID RENTAL", "ID PENYEWA", "ID MOBIL", "HARGA RENTAL", "TANGGAL RENTAL", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(TABEL2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 143, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_id_rentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_id_rentalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_id_rentalActionPerformed

    private void Txt_id_rentalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_id_rentalKeyPressed
        // TODO add your handling code here:
        idrental=Txt_id_rental.getText();
        int tekanenter=evt.getKeyCode();
        if(tekanenter==10){
            try{
                Cmb_id_mobil.removeAllItems();
                String sql = "select * from tb_mobil ";
                Statement st = con.createStatement();
                RsMobil = st.executeQuery(sql);
                while (RsMobil.next()){
                    String Aliaskd = RsMobil.getString("id_mobil");
                    Cmb_id_mobil.addItem(Aliaskd);
                    Cmb_status.setEnabled(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                        "Gagal menampilkan id mobil \n"
                    +e.getMessage());
            }
            try {
                Cmb_id_penyewa.removeAllItems();
                String sql = "select * from tb_penyewa ";
                Statement st = con.createStatement();
                RsPenyewa = st.executeQuery(sql);
                while (RsPenyewa.next()){
                    String Aliaskd= RsPenyewa.getString("id_penyewa");
                    Cmb_id_penyewa.addItem(Aliaskd);
                    Cmb_status.setEnabled(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                        "Gagal menampilkan id mobil \n" 
                +e.getMessage());
            
            } 
            try {
                sql = "select * from tb_rental " 
                        + "where id_rental='"+ idrental +"'";
                st = con.createStatement();
                RsRental=st.executeQuery(sql);
                while (RsRental.next()){
                    Cmb_id_mobil.setSelectedItem(RsRental.getString("id_mobil"));
                    Cmb_id_penyewa.setSelectedItem(RsRental.getString("id_penyewa"));
                    Txt_nama_penyewa.setText(RsRental.getString("nama_penyewa"));
                    Txt_nama_mobil.setText(RsRental.getString("nama_mobil"));
                    tanggalrental.setDate(RsRental.getDate("tgl_rental"));
                    Txt_harga.setText(RsRental.getString("harga_rental"));
                    Txt_status.setText(RsRental.getString("status"));
                    JOptionPane.showMessageDialog(null, "Data Ditemukan \n");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan \n"+e.getMessage());
                Cmb_id_mobil.requestFocus();
            }
        }
    }//GEN-LAST:event_Txt_id_rentalKeyPressed

    private void Cmb_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_statusActionPerformed
        // TODO add your handling code here:
        if (Cmb_status.getSelectedItem()=="SEWA"){
            status=String.valueOf(Cmb_status.getSelectedItem());
            status=String.valueOf(Txt_status.getText());
            statusb= "READY";
            Txt_status.setText(String.valueOf(statusb));
        }
            Txt_status.setText(String.valueOf(statusb));
            if(Cmb_status.getSelectedItem()== "SEWA"){
                Cmb_id_mobil.removeAllItems();
                Cmb_id_mobil.addItem("PILIH");
                try{
                    status=String.valueOf(Cmb_status.getSelectedItem());
                    status= "READY";
                    String sql = "select * from tb_mobil where status = '"+ status +"'";
                    Statement st = con.createStatement();
                    RsMobil=st.executeQuery(sql);
                    while (RsMobil.next()){
                        String AliasID =RsMobil.getString("id_mobil");
                        Cmb_id_mobil.addItem(AliasID);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal Menampilkan id mobil \n"+e.getMessage());
                }
                Cmb_id_penyewa.removeAllItems();
                Cmb_id_penyewa.addItem("PILIH");
                try {
                    status=String.valueOf(Cmb_status.getSelectedItem());
                    status = "READY";
                    String sql = "select * from tb_penyewa where status ='"+ status +"'";
                    Statement st = con.createStatement();
                    RsPenyewa=st.executeQuery(sql);
                    while (RsPenyewa.next()){
                        String Aliaskd =RsPenyewa.getString("id_penyewa");
                        Cmb_id_penyewa.addItem(Aliaskd);
                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal Menampilkan id mobil \n"+e.getMessage());
                }
            }
            
    
    }//GEN-LAST:event_Cmb_statusActionPerformed

    private void BTN_SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPANActionPerformed
        // TODO add your handling code here:
        idrental=String.valueOf(Txt_id_rental.getText());
        idmobil=Cmb_id_mobil.getItemAt(Cmb_id_mobil.getSelectedIndex()).toString();
        idpenyewa=Cmb_id_penyewa.getItemAt(Cmb_id_penyewa.getSelectedIndex()).toString();
        namapenyewa=String.valueOf(Txt_nama_penyewa.getText());
        namamobil=String.valueOf(Txt_nama_mobil.getText());
        bm=String.valueOf(Txt_bm.getText());
        harga=Integer.parseInt(Txt_harga.getText());
        status=Cmb_status.getItemAt(Cmb_status.getSelectedIndex()).toString();
        if (Cmb_status.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null, "STATUS BELUM DIPILIH");
        }
        else { 
            try{
                sql="INSERT INTO tb_rental(id_rental, id_mobil,"
                + "id_penyewa, nama_penyewa, nama_mobil, "
                + "tgl_rental, harga_rental,status)VALUE"
                + "('"+ idrental +"','"+ idmobil +"','"+ idpenyewa +"','"+ namapenyewa +"',"
                + "'"+ namamobil +"','"+ tanggal +"','"+ harga +"','"+ status +"')";
                st=con.createStatement();
                st.execute(sql);
                bersih();
                TampilData(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal Disimpan \n"+e.getMessage());
            }
        }
        try {
            status = "NOTREADY";
            sql="update tb_mobil set status ='"+ status +"' where id_mobil = '"+ idmobil +"'";
            st=con.createStatement();
            st.execute(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf Error" +e.getMessage());
        }
        
        try {
            String sql="select * from tb_penyewa";
            Statement st = con.createStatement();
            RsPenyewa=st.executeQuery(sql);
            status = "NOTREADY";
            sql="update tb_penyewa set status = '"+ status +"' where id_penyewa = '"+ idpenyewa +"'";
            st=con.createStatement();
            st.execute(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf Error" +e.getMessage());
        }
    

    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed
        // TODO add your handling code here:
        idrental=String.valueOf(Txt_id_rental.getText());
        idmobil=String.valueOf(Cmb_id_mobil.getSelectedItem());
        idpenyewa=String.valueOf(Cmb_id_penyewa.getSelectedItem());
        namapenyewa=String.valueOf(Txt_nama_penyewa.getText());
        namamobil=String.valueOf(Txt_nama_mobil.getText());
        harga=Integer.parseInt(Txt_harga.getText());
        status=String.valueOf(Cmb_status.getSelectedItem());
        try {
            sql="update tb_rental set id_mobil='"+ idmobil +"',id_penyewa='"+ idpenyewa +"',nama_penyewa='"+ namapenyewa +"',nama_mobil='"+ namamobil +"',tgl_rental='"+ tanggal +"',harga_rental='"+ harga +"',status='"+ status +"' where id_rental = '"+ idrental +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Edit \n"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_EDITActionPerformed

    private void BTN_BATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BATALActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_BTN_BATALActionPerformed

    private void BTN_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HAPUSActionPerformed
        // TODO add your handling code here:
        idrental=String.valueOf(Txt_id_rental.getText());
        try {
            sql="delete from tb_rental where id_rental='"+ idrental +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_HAPUSActionPerformed

    private void BTN_KELUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_KELUARActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BTN_KELUARActionPerformed

    private void Txt_nama_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_nama_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_nama_mobilActionPerformed

    private void Txt_bmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_bmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_bmActionPerformed

    private void Txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_hargaActionPerformed

    private void Txt_nama_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_nama_penyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_nama_penyewaActionPerformed

    private void Txt_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_statusActionPerformed

    private void Cmb_id_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_id_mobilActionPerformed
        // TODO add your handling code here:
        try {
            sql="select * from tb_mobil where " 
                    + "id_mobil='"+ Cmb_id_mobil.getSelectedItem() +"'";
            st=con.createStatement();
            RsMobil=st.executeQuery(sql);
            while (RsMobil.next()){
                Txt_nama_mobil.setText(RsMobil.getString("nama_mobil"));
                Txt_bm.setText(RsMobil.getString(4));
                Txt_harga.setText(RsMobil.getString(5));
                Cmb_status.setSelectedItem(RsMobil.getString(6));
            }
            Txt_nama_mobil.requestFocus();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Cmb_id_mobilActionPerformed

    private void Cmb_id_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_id_penyewaActionPerformed
        // TODO add your handling code here:
        try {
            sql="select * from tb_penyewa where " 
                    + "id_penyewa='"+ Cmb_id_penyewa.getSelectedItem() +"'";
            st=con.createStatement();
            RsPenyewa=st.executeQuery(sql);
            while (RsPenyewa.next()){
                Txt_nama_penyewa.setText(RsPenyewa.getString("nama_penyewa")); 
            }
            Txt_nama_penyewa.requestFocus();
        } catch (Exception e) {
        }
 
    }//GEN-LAST:event_Cmb_id_penyewaActionPerformed

    private void tanggalrentalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalrentalPropertyChange
        // TODO add your handling code here:
        if(tanggalrental.getDate() !=null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tanggal=format.format(tanggalrental.getDate());
        }
    }//GEN-LAST:event_tanggalrentalPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MENU_UTAMA home = new MENU_UTAMA();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_BATAL;
    private javax.swing.JButton BTN_EDIT;
    private javax.swing.JButton BTN_HAPUS;
    private javax.swing.JButton BTN_KELUAR;
    private javax.swing.JButton BTN_SIMPAN;
    private javax.swing.JComboBox Cmb_id_mobil;
    private javax.swing.JComboBox Cmb_id_penyewa;
    private javax.swing.JComboBox Cmb_status;
    private javax.swing.JTable TABEL2;
    private javax.swing.JTextField Txt_bm;
    private javax.swing.JTextField Txt_harga;
    private javax.swing.JTextField Txt_id_rental;
    private javax.swing.JTextField Txt_nama_mobil;
    private javax.swing.JTextField Txt_nama_penyewa;
    private javax.swing.JTextField Txt_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser tanggalrental;
    // End of variables declaration//GEN-END:variables
}
