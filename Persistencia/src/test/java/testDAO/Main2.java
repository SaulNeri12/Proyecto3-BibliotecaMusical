/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testDAO;

/**
 *
 * @author caarl
 */
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Simulación de usuario con géneros restringidos
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario("Usuario1");
            usuario.setGenerosRestringidos(List.of("Pop", "Reggaeton")); // Ejemplo de géneros no deseados

            // Obtén todos los álbumes desde la base de datos
            AlbumesDAO albumesDAO = AlbumesDAO.getInstance();
            List<Album> todosAlbumes = albumesDAO.obtenerTodos();

            // Filtrar álbumes según géneros no deseados
            List<Album> albumesFiltrados = filtrarAlbumesPorGenero(todosAlbumes, usuario.getGenerosRestringidos());

            // Mostrar los álbumes filtrados
            System.out.println("Álbumes disponibles después de filtrar géneros no deseados:");
            for (Album album : albumesFiltrados) {
                System.out.println("- " + album.getNombre() + " (" + album.getGeneroMusical() + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Filtra los álbumes eliminando aquellos cuyos géneros están en la lista de géneros restringidos.
     *
     * @param albumes Lista de álbumes a filtrar.
     * @param generosRestringidos Lista de géneros restringidos.
     * @return Lista de álbumes filtrados.
     */
    private static List<Album> filtrarAlbumesPorGenero(List<Album> albumes, List<String> generosRestringidos) {
        List<Album> filtrados = new ArrayList<>();
        for (Album album : albumes) {
            if (!generosRestringidos.contains(album.getGeneroMusical())) {
                filtrados.add(album);
            }
        }
        return filtrados;
    }
}