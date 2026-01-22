package ui.popup;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import hibernate.Customer;
import hibernate.Sale;
import hibernate.SaleItem;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.panel.Reports;
import util.BillPdfGenerator;
import util.Message;

public class BillHistory extends javax.swing.JDialog {

    private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(Reports.class);
    private Sale selectedSale;
    private List<Sale> saleList = new ArrayList<>();

    public BillHistory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        sessionFactory = hibernate.HibernateUtil.getSessionFactory();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));

        jPanel2.setBackground(new java.awt.Color(248, 249, 250));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 76, 129));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bill History");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(248, 249, 250));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Customer NIC:");

        jTextField1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N

        jButton1.setBackground(new java.awt.Color(66, 153, 225));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Date:");

        jDateChooser1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N

        jButton2.setBackground(new java.awt.Color(66, 153, 225));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(229, 62, 62));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(248, 249, 250));

        jTable1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sales ID", "NIC", "Name", "Date", "Cash/Credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(248, 249, 250));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Bill ID:");

        jTextField2.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Customer Name:");

        jTextField3.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N

        jButton4.setBackground(new java.awt.Color(66, 153, 225));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(56, 161, 105));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton5.setText("RePrint");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setText("Mobile:");

        jTextField4.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        forNic();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        forDate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jDateChooser1.setDate(null);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int viewRow = jTable1.getSelectedRow();

        if (viewRow == -1) {
            return;
        }

// Convert view row to model row (IMPORTANT)
        int modelRow = jTable1.convertRowIndexToModel(viewRow);

        if (saleList == null || modelRow < 0 || modelRow >= saleList.size()) {
            System.out.println("saleList empty or row out of bounds");
            return;
        }

        selectedSale = saleList.get(modelRow);

        Customer customer = selectedSale.getCustomer();

        jTextField2.setText(String.valueOf(selectedSale.getId()));
        jDateChooser1.setDate(selectedSale.getDate());

        if (customer != null) {
            jTextField3.setText(customer.getName() != null ? customer.getName() : "");
            jTextField1.setText(customer.getNic() != null ? customer.getNic() : "");
            jTextField4.setText(customer.getPhone() != null ? customer.getPhone() : "");
        } else {
            jTextField3.setText("");
            jTextField1.setText("");
            jTextField4.setText("");
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewSalePdf();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BillHistory dialog = new BillHistory(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void viewSalePdf() {
        // 1️⃣ Check selection
        if (selectedSale == null) {
            Message.warning("No Sale Selected!", "Select a row first");
            return;
        }

        Session session = null;
        Transaction tx = null;

        try {
            // 2️⃣ Open Hibernate session
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Reload sale to ensure saleItems are available
//            Sale sale = session.get(Sale.class, selectedSale.getId());
            Sale sale = (Sale) session.get(Sale.class, selectedSale.getId());
            if (sale == null) {
                Message.warning("Sale not found!", "Error");
                return;
            }

            List<SaleItem> items = sale.getSaleItems();
            if (items == null || items.isEmpty()) {
                Message.warning("No sale items found!", "Info");
                return;
            }

            tx.commit();
            
            //catch data
            String saleId = String.valueOf(sale.getId());
            String saleDate = new SimpleDateFormat("yyyy-MM-dd").format(sale.getDate());
            String subTotal = String.valueOf(sale.getSubTotal());
            String discount = Double.toString(sale.getDiscount());
            String total = Double.toString(sale.getTotal());
            String paid = Double.toString(sale.getPaid());
            String balance = sale.getBalance();

            // 3️⃣ Prepare Jasper DataSource from JTable
            JRTableModelDataSource dataSource
                    = new JRTableModelDataSource(jTable1.getModel());

            // 4️⃣ Prepare parameters (MUST match your report)
            HashMap<String, Object> params = new HashMap<>();
            params.put("Parameter1", saleId); // Sale ID
            params.put("Parameter2", saleDate);
            params.put("Parameter3", subTotal);
            params.put("Parameter4", discount);
            params.put("Parameter5", total);
            params.put("Parameter6", paid);
            params.put("Parameter7", balance);

            Customer customer = sale.getCustomer();
            if (customer != null) {
                params.put("customerName", customer.getName());
                params.put("customerNic", customer.getNic());
            }

            // 5️⃣ Load & VIEW Jasper Report
            String reportPath = "C:\\pos\\bill1.jasper";

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    reportPath,
                    params,
                    dataSource
            );

            // 👇 THIS OPENS THE PREVIEW WINDOW
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            Message.error("Unable to open report!", "Error");

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void forDate() {

        // 1. Validate date
        if (jDateChooser1.getDate() == null) {
            Message.warning("No date Selected !", "Empty value");
            return;
        }

        Date selectedDate = jDateChooser1.getDate();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Criteria c = session.createCriteria(Sale.class);
            c.add(Restrictions.eq("date", selectedDate));

            List<Sale> sales = c.list();

            // 2. Prepare table & list
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            saleList = new ArrayList<>();   // ⭐ always reset list ⭐

            // 3. No results
            if (sales == null || sales.isEmpty()) {
                Message.warning("No History found on this date.", "Billing Details");
                return;
            }

            // 4. Fill list and table together
            for (Sale sale : sales) {

                saleList.add(sale); // ⭐ keep list in sync ⭐

                Customer customer = sale.getCustomer();

                String nic = "--";
                String name = "--";

                if (customer != null) {
                    if (customer.getNic() != null) {
                        nic = customer.getNic();
                    }
                    if (customer.getName() != null) {
                        name = customer.getName();
                    }
                }

                String paymentType = sale.isIsCash() ? "Cash" : "Credit";

                model.addRow(new Object[]{
                    sale.getId(),
                    nic,
                    name,
                    sale.getDate(),
                    paymentType
                });
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    private void forNic() {
//        if (jTextField1 == null) {
//            Message.warning("NIC was empty!", "Empty value");
//        } else {
//            String selectedNic = jTextField1.getText();
//            Session session = sessionFactory.openSession();
//            Transaction t = null;
//
//            try {
//
//                t = session.beginTransaction();
//
//                Criteria c = session.createCriteria(Customer.class);
//                c.add(Restrictions.eq("nic", selectedNic));
//                Customer customer = (Customer) c.uniqueResult();
//
//                if (customer != null) {
//
//                    Criteria saleCriteria = session.createCriteria(Sale.class);
//                    saleCriteria.add(Restrictions.eq("customer", customer));
//
//                    List<Sale> sales = saleCriteria.list();
//
//                    // Now `sales` contains all sales for that customer
//                    Map<Integer, Object[]> itemMap = new LinkedHashMap<>();
//
//                    for (Sale sale : sales) {
//
//                        String nic = "--";
//                        String name = "--";
//
//                        if (customer != null) {
//                            nic = customer.getNic();     // may be null
//                            name = customer.getName();  // may be null
//                        }
//
//                        String paymentType = sale.isIsCash() ? "Cash" : "Credit";
//
//                        itemMap.put(sale.getId(), new Object[]{
//                            sale.getId(),
//                            nic,
//                            name,
//                            sale.getDate(),
//                            paymentType
//                        });
//                    }
//
//                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//                    model.setRowCount(0);
//
//                    for (Object[] row : itemMap.values()) {
//                        model.addRow(row);
//                    }
//                } else {
//                    Message.warning("No History found on this Customer.", "Billing Details");
//                }
//
//                t.commit();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            } finally {
//                session.close();
//            }
//
//        }
//    }
    private void forNic() {

        // 1. Validate NIC input
        if (jTextField1.getText() == null || jTextField1.getText().trim().isEmpty()) {
            Message.warning("NIC was empty!", "Empty value");
            return;
        }

        String selectedNic = jTextField1.getText().trim();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // 2. Find customer by NIC
            Criteria customerCriteria = session.createCriteria(Customer.class);
            customerCriteria.add(Restrictions.eq("nic", selectedNic));

            Customer customer = (Customer) customerCriteria.uniqueResult();

            // Prepare table & list
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            saleList = new ArrayList<>();

            if (customer == null) {
                Message.warning("No History found on this Customer.", "Billing Details");
                return;
            }

            // 3. Find sales for customer
            Criteria saleCriteria = session.createCriteria(Sale.class);
            saleCriteria.add(Restrictions.eq("customer", customer));

            List<Sale> sales = saleCriteria.list();

            if (sales == null || sales.isEmpty()) {
                Message.warning("No History found on this Customer.", "Billing Details");
                return;
            }

            // 4. Fill list and table together
            for (Sale sale : sales) {

                saleList.add(sale); // ⭐ IMPORTANT ⭐

                String nic = customer.getNic() != null ? customer.getNic() : "--";
                String name = customer.getName() != null ? customer.getName() : "--";
                String paymentType = sale.isIsCash() ? "Cash" : "Credit";

                model.addRow(new Object[]{
                    sale.getId(),
                    nic,
                    name,
                    sale.getDate(),
                    paymentType
                });
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
