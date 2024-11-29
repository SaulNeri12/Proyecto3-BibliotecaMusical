package com.equipo7.persistencia.entidades;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la informacion que se utilizara para aplicarla a una busqueda de
 * contenido en el sistema
 *
 * @author Saul Neri
 */
public class FiltroBusqueda {

    private String coincidenciaBusqueda;
    private String nombreArtista;
    private int anioDesde;
    private int anioHasta;
    private List<String> generos;
    private List<String> generosRestringidos;

    /**
     * Crea una nueva instancia de filtro de busqueda usando los ajustes dados
     * por el Builder
     *
     * @param ajustes Objeto Builder de ajuste con informacion que contendra el
     * filtro de busqueda
     */
    public FiltroBusqueda(FiltroBusqueda.Builder ajustes) {
        this.nombreArtista = ajustes.nombreArtista;
        this.generos = ajustes.generos;
        this.anioDesde = ajustes.anioDesde;
        this.anioHasta = ajustes.anioHasta;
        this.generosRestringidos = ajustes.generosRestringidos;
        this.coincidenciaBusqueda = ajustes.coincidenciaBusqueda;
    }

    /**
     * Obtiene el nombre del artista.
     *
     * @return El nombre del artista que fue configurado en el filtro.
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * Obtiene el año de inicio del filtro.
     *
     * @return El año desde el que se comienza a aplicar el filtro.
     */
    public int getAnioDesde() {
        return anioDesde;
    }

    /**
     * Obtiene el año de fin del filtro.
     *
     * @return El año hasta el cual se aplica el filtro.
     */
    public int getAnioHasta() {
        return anioHasta;
    }

    /**
     * Obtiene la lista de géneros configurada en el filtro.
     *
     * @return La lista de géneros que se están utilizando para el filtro.
     */
    public List<String> getGeneros() {
        return generos;
    }

    /**
     * Convierte el objeto FiltroBusqueda a un filtro BSON para usar en las
     * consultas de MongoDB.
     *
     * @return un filtro BSON
     */
    public Bson toBson() {

        Bson filtro = Filters.empty();

        // Si el nombre del artista no es nulo o vacío, agregamos una condición de búsqueda para el nombre
        if (nombreArtista != null && !nombreArtista.isEmpty()) {
            filtro = Filters.and(filtro, Filters.regex("nombreArtista", nombreArtista, "i"));
        }

        // Si se ha especificado un rango de años, agregamos las condiciones de rango
        if (anioDesde > 0) {
            filtro = Filters.and(filtro, Filters.gte("anio", anioDesde));  // Año mayor o igual a 'anioDesde'
        }
        if (anioHasta > 0) {
            filtro = Filters.and(filtro, Filters.lte("anio", anioHasta));  // Año menor o igual a 'anioHasta'
        }

        // Si la lista de géneros no está vacía, agregamos la condición para buscar documentos que tengan géneros específicos
        if (generos != null && !generos.isEmpty()) {
            filtro = Filters.and(filtro, Filters.in("generoMusical", generos));  // Géneros especificados
        }

        // Si los géneros restringidos no están vacíos, agregamos una condición para excluir esos géneros
        if (generosRestringidos != null && !generosRestringidos.isEmpty()) {
            filtro = Filters.and(filtro, Filters.nin("generoMusical", generosRestringidos));  // Géneros restringidos (excluirlos)
        }
        
        return filtro;
    }

    /**
     * Clase que sirve como constructor de la misma usando el patron Builder
     *
     * @author Saul Neri
     */
    public static class Builder {

        private String coincidenciaBusqueda;
        private String nombreArtista;
        private Integer anioDesde;
        private Integer anioHasta;
        private List<String> generos;
        private List<String> generosRestringidos;

        /**
         * Prepara los ajustes del filtro
         */
        public Builder() {
            this.anioDesde = 1900;
            this.anioHasta = null;
            this.generos = new ArrayList<>();
            this.generosRestringidos = new ArrayList<>();
        }

        /**
         * Agrega un genero restringido al filtro
         *
         * @param generoRestringido Nombre del genero restringido.
         * @return El objeto Builder para el filtro.
         */
        public Builder agregarGeneroRestringido(String generoRestringido) {
            this.generosRestringidos.add(generoRestringido);
            return this;
        }

        /**
         * Asigna los generos restringidos para el filtro de busqueda.
         *
         * @param generosRestringidos Lista de generos restringidos.
         * @return El objeto builder para el filtro.
         */
        public Builder asignarGenerosRestringidos(List<String> generosRestringidos) {
            this.generosRestringidos = generosRestringidos;
            return this;
        }

        /**
         * Configura el nombre del artista para el filtro.
         *
         * @param nombreArtista El nombre del artista a filtrar.
         * @return El objeto Builder con el nombre del artista configurado.
         */
        public Builder conNombreArtista(String nombreArtista) {
            this.nombreArtista = nombreArtista;
            return this;
        }

        /**
         * Configura el año de inicio del filtro de búsqueda.
         *
         * @param anioDesde El año de inicio para el rango de búsqueda.
         * @return El objeto Builder con el año de inicio configurado.
         */
        public Builder desdeAnio(int anioDesde) {
            this.anioDesde = anioDesde;
            return this;
        }

        /**
         * Configura el año de fin del filtro de búsqueda.
         *
         * @param anioHasta El año de fin para el rango de búsqueda.
         * @return El objeto Builder con el año de fin configurado.
         */
        public Builder hastaAnio(int anioHasta) {
            this.anioHasta = anioHasta;
            return this;
        }

        /**
         * Configura la lista completa de géneros para el filtro.
         *
         * @param generos La lista de géneros a filtrar.
         * @return El objeto Builder con los géneros configurados.
         */
        public Builder conGeneros(List<String> generos) {
            this.generos = generos;
            return this;
        }

        /**
         * Agrega un género a la lista de géneros para el filtro.
         *
         * @param genero El género que se desea agregar.
         * @return El objeto Builder con el nuevo género agregado.
         */
        public Builder agregarGenero(String genero) {
            this.generos.add(genero);
            return this;
        }

        /**
         * Crea el objeto final FiltroBusqueda con los valores configurados en
         * el Builder.
         *
         * @return Un objeto FiltroBusqueda con los valores proporcionados.
         */
        public FiltroBusqueda build() {
            return new FiltroBusqueda(this);
        }

        /**
         * Obtiene el patron de la busqueda. Indica el patron que coincide con el nombre
         * de las canciones, albumes y artistas.
         * @return the coincidenciaBusqueda
         */
        public String getCoincidenciaBusqueda() {
            return coincidenciaBusqueda;
        }

        /**
         * Asigna el patron de la busqueda. Indica el patron que coincide con el nombre
         * de las canciones, albumes y artistas.
         * @param coincidenciaBusqueda the coincidenciaBusqueda to set
         */
        public void setCoincidenciaBusqueda(String coincidenciaBusqueda) {
            this.coincidenciaBusqueda = coincidenciaBusqueda;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FiltroBusqueda { ");

        if (nombreArtista != null && !nombreArtista.isEmpty()) {
            sb.append("nombreArtista='").append(nombreArtista).append("', ");
        } else {
            sb.append("nombreArtista=No especificado, ");
        }

        sb.append("anioDesde=").append(anioDesde > 0 ? anioDesde : "No especificado").append(", ");
        sb.append("anioHasta=").append(anioHasta > 0 ? anioHasta : "No especificado").append(", ");

        if (generos != null && !generos.isEmpty()) {
            sb.append("generos=").append(generos.toString());
        } else {
            sb.append("generos=No especificados");
        }

        sb.append(" }");
        return sb.toString();
    }

    /**
     * @return the generosRestringidos
     */
    public List<String> getGenerosRestringidos() {
        return generosRestringidos;
    }

    /**
     * @param generosRestringidos the generosRestringidos to set
     */
    public void setGenerosRestringidos(List<String> generosRestringidos) {
        this.generosRestringidos = generosRestringidos;
    }

    /**
     * @return the coincidenciaBusqueda
     */
    public String getCoincidenciaBusqueda() {
        return coincidenciaBusqueda;
    }

    /**
     * @param coincidenciaBusqueda the coincidenciaBusqueda to set
     */
    public void setCoincidenciaBusqueda(String coincidenciaBusqueda) {
        this.coincidenciaBusqueda = coincidenciaBusqueda;
    }
}