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
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;

/**
 *
 * @author Gaston
 */
public class ProductoControlador implements ICrud<Producto> {
    
    private Connection connection;
    private Statement statementmt;
    private PreparedStatement ps;
    private ResultSet resultSet;
    private String sql;    
    private CategoriaControlador categoriaControlador;

    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO productos (nombre,descripcion,precio,fecha_creacion, categoria_id) VALUES (?,?,?,?,?)";
        Date fecha = new Date(entidad.getFechaCreacion().getTime());
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setDate(4, fecha);
            ps.setInt(5, entidad.getCategoria().getId());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Producto entidad) throws SQLException, Exception {
        connection=Conexion.obtenerConexion();
        this.sql="DELETE FROM productos WHERE id=?";
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
       
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public Producto extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM productos WHERE id = ?";
        
        ps = connection.prepareStatement(sql);            
        ps.setInt(1, id);
        
        this.resultSet   = ps.executeQuery();
        
        connection.close();
        
        this.resultSet.next();
        Producto producto = new Producto();
        producto.setId(id);
        producto.setCategoria(getCategoria(resultSet.getInt("categoria_id")));
        producto.setNombre(resultSet.getString("nombre"));
        //producto.setStockMin(resultSet.getInt("stock_minimo"));
        //producto.setStockMax(resultSet.getInt("stock_maximo"));
        producto.setPrecio(resultSet.getFloat("precio"));
        producto.setDescripcion(resultSet.getString("descripcion"));
        producto.setFechaCreacion(resultSet.getDate("fecha_creacion"));        
        
        return producto;
    }

    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        //sql = "UPDATE productos SET categoria_id=?, nombre=?, stock_minimo=?, stock_maximo=?, precio=?, descripcion=?, fecha_creacion=? WHERE id=?";
        sql = "UPDATE productos SET categoria_id=?, nombre=?, precio=?, descripcion=?, fecha_creacion=? WHERE id=?";
       Date fecha = new Date(entidad.getFechaCreacion().getTime());
        
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getCategoria().getId());
        ps.setString(2,entidad.getNombre());
        //ps.setInt(3,entidad.getStockMax());
        //ps.setInt(4,entidad.getStockMin());
        ps.setFloat(3,entidad.getPrecio());
        ps.setString(4,entidad.getDescripcion() );
        ps.setDate(5, fecha);
        ps.setInt(6, entidad.getId());
        ps.executeUpdate();
        
        connection.close();
        return true;
    }

    @Override
    public ArrayList <Producto> listar() throws Exception {
         connection = Conexion.obtenerConexion ();
        try{
            
            this.statementmt = connection.createStatement();
            this.sql = "SELECT * FROM productos";
            this.resultSet   = statementmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList();
            
            while(resultSet.next())
            {                
                Producto producto = new Producto();
                
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setId(resultSet.getInt("id"));
                producto.setPrecio (resultSet.getFloat("precio"));
                producto.setFechaCreacion(resultSet.getDate("fecha_creacion"));
                producto.setCategoria(getCategoria(resultSet.getInt("categoria_id")));
                        //System.out.println(cliente);

                productos.add(producto);
                
            }
            return productos;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private Categoria getCategoria(Integer id) throws Exception
    {
     this.categoriaControlador = new CategoriaControlador();
     
     Categoria categoria = categoriaControlador.extraer(id);
     
     return categoria;
    }  
}
