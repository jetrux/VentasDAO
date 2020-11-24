/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.FormaPago;

/**
 *
 * @author Gaston
 */
public class GrillaFormaPago extends AbstractTableModel{
    
    private ArrayList<FormaPago> formaPagos = new ArrayList<>();

    public GrillaFormaPago(ArrayList<FormaPago> datos) {
        this.formaPagos = datos;
    }

    @Override
    public int getRowCount() {
        return formaPagos.size(); 
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
             FormaPago formaPago = formaPagos.get(rowIndex);
                
          switch(columnIndex)
          {
              case 0: return formaPago.getId();
              case 1: return formaPago.getNombre();
              case 2: return formaPago.getDescripcion();
              default: return "";
          }
    }

    @Override
    public String getColumnName(int column)
    {        
        switch(column)
        {
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Descripcion";
            default: return "";
        }
    }
    
   public FormaPago getFormaPagoFromRow(int rowIndex)
   {
       return formaPagos.get(rowIndex);
   }
}
