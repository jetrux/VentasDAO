/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Factura;

/**
 *
 * @author Gaston
 */
public class GrillaFactura extends AbstractTableModel{
    
    private ArrayList<Factura> facturas = new ArrayList<>();
    
    public GrillaFactura(ArrayList<Factura> datos) {
        this.facturas = datos;
    }
    
    @Override
    public int getRowCount() {
        return facturas.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura factura = facturas.get(rowIndex);
        switch(columnIndex){
              case 0: return factura.getId();
              case 1: return factura.getProducto();
              case 2: return factura.getCantidadProd();
              case 3: return factura.getCliente();
              case 4: return factura.getFormaPago();
              case 5: return factura.getNumFactura();
              case 6: return factura.getFecha();
              case 7: return factura.getObservacion();
              case 8: return factura.getTotal();
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Producto";
            case 2: return "Cantidad";
            case 3: return "Cliente";
            case 4: return "Forma de Pago";
            case 5: return "Numero de Factura";
            case 6: return "Fecha";
            case 7: return "Observacion";
            case 8: return "Total";
            default: return "";
        }
    }
    
    public Factura getFacturaFromRow(int rowIndex)
   {
       return facturas.get(rowIndex);
   }
}
