/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author Hugo Chanampe
 */
public class GrillaTipoCliente extends AbstractTableModel{
    
    private ArrayList<TipoCliente> tipoClientes = new ArrayList<>();  
    
    public GrillaTipoCliente(ArrayList<TipoCliente> datos) {
        this.tipoClientes = datos;
    }

    @Override
    public int getRowCount() {
        return tipoClientes.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        TipoCliente cliente = tipoClientes.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return cliente.getId();
            case 1: return cliente.getNombre();
            case 2: return cliente.getDescripcion();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) 
    {
        switch(column)
        {
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "DESCRIPCION";
            default: return "";
        }
    }

    public TipoCliente getClienteFromRow(int rowIndex)
   {
       return tipoClientes.get(rowIndex);
   }
}
