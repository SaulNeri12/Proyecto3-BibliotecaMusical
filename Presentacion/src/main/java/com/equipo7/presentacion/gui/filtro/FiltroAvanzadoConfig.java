
package com.equipo7.presentacion.gui.filtro;

/**
 * Contiene la configuracion del filtro de busqueda avanzado de la aplicacion.
 * @author Saul Neri
 */
public class FiltroAvanzadoConfig {
    private static FiltroAvanzadoConfig instance;
    
    private String busqueda;
    private boolean mostrarAlbumes;
    private boolean mostrarArtistas;
    private boolean mostrarCanciones;
    private String genero;
    
    /**
     * Constructor privado para la construccion de una instancia unica.
     */
    private FiltroAvanzadoConfig() {
        this.restablecerFiltro();
    }
    
    /**
     * Restablece los ajustes del filtro a su estado inicial.
     */
    public void restablecerFiltro() {
        this.setBusqueda("");
        this.setMostrarAlbumes(true);
        this.setMostrarArtistas(true);
        this.setMostrarCanciones(true);
        this.setGenero("");
    }
    
    /**
     * Obtiene la instacia unica de configuracion del filtro de busqueda.
     * @return Configuracion del filtro de busqueda avanzada.
     */
    public static FiltroAvanzadoConfig getInstance() {
        if (instance == null)
            instance = new FiltroAvanzadoConfig();
        return instance;
    }

    /**
     * Obtiene el término de búsqueda actual.
     * 
     * @return El término de búsqueda.
     */
    public String getBusqueda() {
        return busqueda;
    }

    /**
     * Establece el término de búsqueda para filtrar los resultados.
     * 
     * @param busqueda El término de búsqueda que se quiere establecer.
     */
    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    /**
     * Indica si se deben mostrar los álbumes en los resultados de búsqueda.
     * 
     * @return true si se deben mostrar álbumes, false si no.
     */
    public boolean mostrarAlbumes() {
        return mostrarAlbumes;
    }

    /**
     * Establece si se deben mostrar los álbumes en los resultados de búsqueda.
     * 
     * @param mostrarAlbumes true para mostrar álbumes, false para no mostrarlos.
     */
    public void setMostrarAlbumes(boolean mostrarAlbumes) {
        this.mostrarAlbumes = mostrarAlbumes;
    }

    /**
     * Indica si se deben mostrar los artistas en los resultados de búsqueda.
     * 
     * @return true si se deben mostrar artistas, false si no.
     */
    public boolean mostrarArtistas() {
        return mostrarArtistas;
    }

    /**
     * Establece si se deben mostrar los artistas en los resultados de búsqueda.
     * 
     * @param mostrarArtistas true para mostrar artistas, false para no mostrarlos.
     */
    public void setMostrarArtistas(boolean mostrarArtistas) {
        this.mostrarArtistas = mostrarArtistas;
    }

    /**
     * Indica si se deben mostrar las canciones en los resultados de búsqueda.
     * 
     * @return true si se deben mostrar canciones, false si no.
     */
    public boolean mostrarCanciones() {
        return mostrarCanciones;
    }

    /**
     * Establece si se deben mostrar las canciones en los resultados de búsqueda.
     * 
     * @param mostrarCanciones true para mostrar canciones, false para no mostrarlas.
     */
    public void setMostrarCanciones(boolean mostrarCanciones) {
        this.mostrarCanciones = mostrarCanciones;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
