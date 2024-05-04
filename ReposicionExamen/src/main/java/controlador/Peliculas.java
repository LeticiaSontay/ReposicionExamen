/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author alumno
 */
public class Peliculas {
   private String nombre;
    private String clasificacion;
    private String subtitulado;
    private String idioma;
    private String tipo;
    private String precio;
    

    public Peliculas() {
    }

    @Override
    public String toString() {
        return "Peliculas{" + "nombre=" + nombre + ", clasificacion=" + clasificacion + ", subtitulado=" + subtitulado + "idioma=" + idioma + ", tipo=" + tipo + ", precio=" + precio + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getSubtitulado() {
        return subtitulado;
    }

    public void setSubtitulado(String subtitulado) {
        this.subtitulado = subtitulado;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
