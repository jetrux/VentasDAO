/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.FormaPago;

/**
 *
 * @author Gaston
 */
public class FormaPagoControlador implements ICrud<FormaPago>{

    private Connection connection;
    private Statement statementmt;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    @Override
    public boolean crear(FormaPago entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        this.sql = "INSERT INTO formas_pago(nombre, descripcion) VALUES (?, ?);";
        
        ps = connection.prepareStatement(sql);
        
        ps.setString(1, entidad.getNombre());
        ps.setString(2, entidad.getDescripcion());
        
        ps.executeUpdate();
        connection.close();
        
        return false;
    }

    @Override
    public boolean eliminar(FormaPago entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM formas_pago WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public FormaPago extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM formas_pago WHERE id = ?";
        
        ps = connection.prepareStatement(sql);            
        ps.setInt(1, id);
        
        this.rs   = ps.executeQuery();
        
        connection.close();
        
        this.rs.next();
        FormaPago formaPago = new FormaPago();
        formaPago.setId(id);
        formaPago.setNombre(rs.getString("nombre"));
        formaPago.setDescripcion(rs.getString("descripcion"));
        return formaPago;
    }

    @Override
    public boolean modificar(FormaPago entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        sql = "UPDATE formas_pago SET nombre=?, descripcion=? WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        
        ps.setString(1, entidad.getNombre());
        ps.setString(2,entidad.getDescripcion());
        ps.setInt(3, entidad.getId());
        
        ps.executeUpdate();        
        connection.close();
        
        return true;
    }

    @Override
    public List<FormaPago> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        try
        {            
            this.statementmt = connection.createStatement();
            this.sql = "SELECT * FROM formas_pago";
            this.rs   = statementmt.executeQuery(sql);
            connection.close();
            
            ArrayList<FormaPago> formasPagos = new ArrayList();
            
            while(rs.next())
            {                
                FormaPago formaPago = new FormaPago();
                
                formaPago.setNombre(rs.getString("nombre"));
                formaPago.setDescripcion(rs.getString("descripcion"));
                formaPago.setId(rs.getInt("id"));

                formasPagos.add(formaPago);
                
            }
            return formasPagos;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
