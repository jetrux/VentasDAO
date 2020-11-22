/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import ventasdao.controladores.ClienteControlador;
import ventasdao.controladores.FacturaControlador;
import ventasdao.controladores.FormaPagoControlador;
import ventasdao.controladores.ProductoControlador;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaFactura;

/**
 *
 * @author Gaston
 */
public class AbmFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form AbmFactura
     */
    
    private FacturaControlador facturaControlador;
    private ProductoControlador productoControlador;
    private ClienteControlador clienteControlador;
    private FormaPagoControlador formaPagoControlador;
    private GrillaFactura grillaFactura;
    private DefaultComboBoxModel modelCombo;
    
    public AbmFactura() {
        initComponents();
        
        facturaControlador = new FacturaControlador();
        productoControlador = new ProductoControlador();
        clienteControlador = new ClienteControlador();
        formaPagoControlador = new FormaPagoControlador();
        
        try {
            grillaFactura = new GrillaFactura((ArrayList<Factura>) facturaControlador.listar());            
            jtListadoFactura.setModel(grillaFactura);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<Producto> producto = productoControlador.listar();            
            
            modelCombo = new DefaultComboBoxModel(producto.toArray());
            jcbProducto.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<Cliente> cliente = clienteControlador.listar();            
            
            modelCombo = new DefaultComboBoxModel(cliente.toArray());
            jcbCliente.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<FormaPago> formaPago = (ArrayList<FormaPago>) formaPagoControlador.listar();            
            
            modelCombo = new DefaultComboBoxModel(formaPago.toArray());
            jcbFormaPago.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbEliminarProducto = new javax.swing.JButton();
        jbEditarProducto = new javax.swing.JButton();
        jtfId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jbAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoFactura = new javax.swing.JTable();
        jcbCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtfNumFactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbProducto = new javax.swing.JComboBox<>();
        jcbFormaPago = new javax.swing.JComboBox<>();
        jtfCantidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaObservacion = new javax.swing.JTextArea();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Factura");

        jLabel1.setText("Producto");

        jLabel2.setText("Cantidad");

        jLabel3.setText("Cliente");

        jLabel4.setText("Forma de Pago");

        jbEliminarProducto.setText("Eliminar");
        jbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarProductoActionPerformed(evt);
            }
        });

        jbEditarProducto.setText("Editar");
        jbEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarProductoActionPerformed(evt);
            }
        });

        jtfId.setEnabled(false);

        jLabel6.setText("Id");

        jLabel5.setText("Fecha");

        jbAgregarProducto.setText("Agregar");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jtListadoFactura.setAutoCreateRowSorter(true);
        jtListadoFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtListadoFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoFactura);

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Nuumero Factura");

        jtfNumFactura.setEnabled(false);

        jLabel8.setText("Observacion");

        jcbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCantidadActionPerformed(evt);
            }
        });

        jtaObservacion.setColumns(20);
        jtaObservacion.setRows(5);
        jScrollPane2.setViewportView(jtaObservacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbFormaPago, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNumFactura, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jbAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminarProducto)))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarProducto)
                    .addComponent(jbEditarProducto)
                    .addComponent(jbEliminarProducto))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarProductoActionPerformed
        // TODO add your handling code here:
        Factura factura = new Factura();

        factura.setId(Integer.parseInt(jtfId.getText()));

        try {
            facturaControlador.eliminar(factura);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoFactura.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiarCampos();
        this.refreshTable();
    }//GEN-LAST:event_jbEliminarProductoActionPerformed

    private void jbEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarProductoActionPerformed
        // TODO add your handling code here:
        Factura factura = new Factura();

        factura.setId(Integer.parseInt(jtfId.getText()));
        factura.setProducto((Producto)jcbProducto.getSelectedItem());
        factura.setCantidadProd(Integer.parseInt(jtfCantidad.getText()));
        factura.setCliente((Cliente)jcbCliente.getSelectedItem());
        factura.setFormaPago((FormaPago)(jcbFormaPago.getSelectedItem()));
        factura.setNumFactura(Integer.parseInt(jtfNumFactura.getText()));
        factura.setFecha((Date)jdcFecha.getDate());
        factura.setObservacion(jtaObservacion.getText());

        try {
            facturaControlador.modificar(factura);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoFactura.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiarCampos();
        this.refreshTable();
    }//GEN-LAST:event_jbEditarProductoActionPerformed

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
        // TODO add your handling code here:
        Factura factura = new Factura();
        
        factura.setProducto((Producto)jcbProducto.getSelectedItem());
        factura.setCantidadProd(Integer.parseInt(jtfCantidad.getText()));
        factura.setCliente((Cliente)jcbCliente.getSelectedItem());
        factura.setFormaPago((FormaPago)(jcbFormaPago.getSelectedItem()));
        factura.setFecha((Date)jdcFecha.getDate());
        factura.setObservacion(jtaObservacion.getText());

        try {
            facturaControlador.crear(factura);
            limpiarCampos();
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiarCampos();
        this.refreshTable();
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jtListadoFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoFacturaMouseClicked
        // TODO add your handling code here:
        Factura factura = grillaFactura.getFacturaFromRow(jtListadoFactura.getSelectedRow());
        
        jtfId.setText(factura.getId().toString());
        jcbProducto.setSelectedItem(factura.getProducto());
        jtfCantidad.setText(factura.getCantidadProd().toString());
        jcbCliente.setSelectedItem(factura.getCliente());
        jcbFormaPago.setSelectedItem(factura.getFormaPago());
        jtfNumFactura.setText(factura.getNumFactura().toString());
        jdcFecha.setDate(factura.getFecha());
        jtaObservacion.setText(factura.getObservacion());
    }//GEN-LAST:event_jtListadoFacturaMouseClicked

    private void jtfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadActionPerformed

    private void refreshTable(){
        try 
        {
            jtListadoFactura.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(AbmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void limpiarCampos()
    {
        jtfId.setText("");
        jtfCantidad.setText("");
        jtfNumFactura.setText("");
        jtaObservacion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbEditarProducto;
    private javax.swing.JButton jbEliminarProducto;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbFormaPago;
    private javax.swing.JComboBox<String> jcbProducto;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable jtListadoFactura;
    private javax.swing.JTextArea jtaObservacion;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNumFactura;
    // End of variables declaration//GEN-END:variables
}
