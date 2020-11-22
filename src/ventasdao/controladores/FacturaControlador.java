/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Producto;

/**
 *
 * @author Gaston
 */
public class FacturaControlador implements ICrud<Factura>{
    
    private Connection connection;
    private Statement statementmt;
    private PreparedStatement ps;
    private ResultSet resultSet;
    private String sql;
    private FormaPagoControlador formaPagoControlador;
    private ProductoControlador productoControlador;
    private ClienteControlador clienteControlador;

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO facturas(producto_id, cantidad_producto, cliente_id, formas_pago_id, fecha, observacion) VALUES (?, ?, ?, ?, ?, ?);";
        Date fecha = new Date(entidad.getFecha().getTime());
        
        ps = connection.prepareStatement(sql);
        
        ps.setInt(1, entidad.getProducto().getId());
        ps.setInt(2, entidad.getCantidadProd());
        ps.setInt(3, entidad.getCliente().getId());
        ps.setInt(4, entidad.getFormaPago().getId());
        ps.setDate(5, fecha);
        ps.setString(6, entidad.getObservacion());
        
        ps.executeUpdate();
        connection.close();
        
        return false;
    }

    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM facturas WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public Factura extraer(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        sql = "UPDATE facturas SET producto_id=?, cantidad_producto=?, cliente_id=?, formas_pago_id=?, numero_factura=?, fecha=?, observacion=? WHERE id=?";
        Date fecha = new Date(entidad.getFecha().getTime());
        
        ps = connection.prepareStatement(sql);
        
        ps.setInt(1, entidad.getProducto().getId());
        ps.setInt(2,entidad.getCantidadProd());
        ps.setInt(3,entidad.getCliente().getId());
        ps.setInt(4,entidad.getFormaPago().getId());
        ps.setInt(5,entidad.getNumFactura());
        ps.setDate(6, fecha);
        ps.setString(7, entidad.getObservacion());
        ps.setInt(8, entidad.getId());
        
        ps.executeUpdate();        
        connection.close();
        
        return true;
    }

    @Override
    public List<Factura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        try{            
            this.statementmt = connection.createStatement();
            this.sql = "SELECT * FROM facturas";
            this.resultSet   = statementmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Factura> facturas = new ArrayList();
            
            while(resultSet.next())
            {                
                Factura factura = new Factura();
                
                factura.setId(resultSet.getInt("id"));
                factura.setProducto(getProducto(resultSet.getInt("producto_id")));
                factura.setCantidadProd(resultSet.getInt("cantidad_producto"));
                factura.setCliente(getCliente(resultSet.getInt("cliente_id")));
                factura.setFormaPago(getFormaPago(resultSet.getInt("formas_pago_id")));
                factura.setNumFactura(resultSet.getInt("numero_factura"));
                factura.setFecha(resultSet.getDate("fecha"));
                factura.setObservacion(resultSet.getString("observacion"));

                facturas.add(factura);                
            }
            return facturas;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private FormaPago getFormaPago(Integer id) throws Exception
    {
     this.formaPagoControlador = new FormaPagoControlador();
     
     FormaPago formaPago = formaPagoControlador.extraer(id);
     
     return formaPago;
    }  
    
    private Producto getProducto(Integer id) throws Exception
    {
     this.productoControlador = new ProductoControlador();
     
     Producto producto = productoControlador.extraer(id);
     
     return producto;
    }  
    
    private Cliente getCliente(Integer id) throws Exception
    {
     this.clienteControlador = new ClienteControlador();
     
     Cliente cliente = clienteControlador.extraer(id);
     
     return cliente;
    }  
}
