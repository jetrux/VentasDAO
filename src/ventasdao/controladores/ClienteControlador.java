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
import java.util.logging.Level;
import java.util.logging.Logger;

import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author Hugo Chanampe
 */
public class ClienteControlador implements ICrud<Cliente>{
    
    private Connection connection;    
    private Statement stmt;    
    private PreparedStatement ps;
    private ResultSet rs;    
    private String sql;
    private TipoClienteControlador tipoClienteControlador;
        
    @Override
    public ArrayList<Cliente> listar() throws SQLException,Exception{        
     connection = Conexion.obtenerConexion ();
        try{            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM clientes";
            this.rs = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Cliente> clientes = new ArrayList();
            
            while(rs.next())
            {                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCuil(rs.getString("cuil"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                //cliente.setTipoCliente(rs.getInt("tipo_cliente_id"));
                cliente.setTipoCliente(getTipoCliente(rs.getInt("tipo_cliente_id")));
                
                clientes.add(cliente);                
            }
            return clientes;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean crear(Cliente entidad) throws SQLException, Exception{
        connection = Conexion.obtenerConexion ();
        this.sql="INSERT INTO clientes(nombre, cuil, razon_social, tipo_cliente_id) VALUES (?, ?, ? ,?)";
        
        ps = connection.prepareStatement(sql);
        ps.setString(1,entidad.getNombre());
        ps.setString(2,entidad.getCuil());
        ps.setString(3,entidad.getRazonSocial());
        ps.setInt(4, entidad.getTipoCliente().getId());        
        ps.executeUpdate();
        connection.close();
        
        return false;
    }

    @Override
    public boolean eliminar(Cliente entidad) throws SQLException, Exception{
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM clientes WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;      
    }

    @Override
    public boolean modificar(Cliente entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="UPDATE clientes SET nombre=?, cuil=?, razon_social=? WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setString(1,entidad.getNombre());
        ps.setString(2,entidad.getCuil());
        ps.setString(3,entidad.getRazonSocial());
        ps.setInt(4, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        
        return true;
    }

    @Override
    public Cliente extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM clientes WHERE id = ?";
        
        ps = connection.prepareStatement(sql);            
        ps.setInt(1, id);
        
        this.rs   = ps.executeQuery();
        
        connection.close();
        
        this.rs.next();
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(rs.getString("nombre"));
        cliente.setCuil(rs.getString("cuil"));
        cliente.setRazonSocial(rs.getString("razon_social"));
        cliente.setTipoCliente(getTipoCliente(rs.getInt("tipo_cliente_id")));
        
        return cliente;
    }
    
    private TipoCliente getTipoCliente(Integer id) throws Exception
    {
     this.tipoClienteControlador = new TipoClienteControlador();
     
     TipoCliente tipoCliente = tipoClienteControlador.extraer(id);
     
     return tipoCliente;
    }  
}
