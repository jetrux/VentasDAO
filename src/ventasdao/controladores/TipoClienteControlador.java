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
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author hchanampe
 */
public class TipoClienteControlador implements ICrud<TipoCliente>{
    
    private Connection connection;    
    private Statement stmt;    
    private PreparedStatement ps;
    private ResultSet rs;    
    private String sql;

    @Override
    public boolean crear(TipoCliente entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO tipo_cliente(nombre, descripcion) VALUES ( ?, ?)";
        
        ps = connection.prepareStatement(sql);
        ps.setString(1, entidad.getNombre());
        ps.setString(2, entidad.getDescripcion());
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public boolean eliminar(TipoCliente entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        this.sql="DELETE FROM tipo_cliente WHERE id=?";
        
        ps =connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public TipoCliente extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
            sql = "SELECT * FROM tipo_cliente WHERE id = ?";
            
            ps = connection.prepareStatement(sql);            
            ps.setInt(1, id);
                        
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            TipoCliente tipoCliente = new TipoCliente();
            
            tipoCliente.setId(id);
            tipoCliente.setNombre(rs.getString("nombre"));
            tipoCliente.setDescripcion(rs.getString("descripcion"));
            return tipoCliente;
    }

    @Override
    public boolean modificar(TipoCliente entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        this.sql="UPDATE tipo_cliente SET nombre=?, descripcion=? WHERE id=?";
        
        ps =connection.prepareStatement(sql);
        ps.setString(1, entidad.getNombre());
        ps.setString(2, entidad.getDescripcion());
        ps.setInt(3, entidad.getId());
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public List<TipoCliente> listar() throws SQLException, Exception 
    {
        connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM tipo_cliente";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<TipoCliente> tipoClientes = new ArrayList();
            
            while(rs.next()){
                
                TipoCliente tipoCliente = new TipoCliente();
                
                tipoCliente.setNombre(rs.getString("nombre"));
                tipoCliente.setDescripcion(rs.getString("descripcion"));
                tipoCliente.setId(rs.getInt("id"));

                tipoClientes.add(tipoCliente);                
            }
            //System.out.println(cont);
            return tipoClientes;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
