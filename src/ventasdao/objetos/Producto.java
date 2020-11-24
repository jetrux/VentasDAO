package ventasdao.objetos;

import java.util.Date;

public class Producto {
    
    private Integer Id;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    public Float precio;    
    private Date FechaCreacion;    
    //private Integer StockMax;    
    //private Integer StockMin;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }    
/*
    public Integer getStockMax() {
        return StockMax;
    }

    public void setStockMax(Integer StockMax) {
        this.StockMax = StockMax;
    }

    public Integer getStockMin() {
        return StockMin;
    }

    public void setStockMin(Integer StockMin) {
        this.StockMin = StockMin;
    }
    */
    public String toString() {
        return "" + nombre;
    }
}
