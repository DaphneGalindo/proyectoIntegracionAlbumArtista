package mx.album.album;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import java.util.String;

@Entity
@Tag(name = "Album", description = "Modelo de datos para un álbum musical")
public class Album {
    
    private @Id
    @GeneratedValue Long id_album;
    private String titulo;
    private String fecha_lanzamiento;
   
    public Album() {
    }

    Album(String titulo, String fecha_lanzamiento) {
        this.titulo = titulo;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    @Operation(summary = "Obtener el ID del álbum")
    public Long getIdAlbum() {
        return id_album;
    }

    @Operation(summary = "Establecer el ID del álbum")
    public void setIdAlbum(Long id_album) {
        this.id_album = id_album;
    }

    @Operation(summary = "Obtener el título del álbum")
    public String getTitulo() {
        return titulo;
    }

    @Operation(summary = "Establecer el título del álbum")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Operation(summary = "Obtener la fecha de lanzamiento del álbum")
    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    @Operation(summary = "Establecer la fecha de lanzamiento del álbum")
    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }
    @Override
    @Operation(summary = "Representación en cadena del álbum")
    public String toString() {
        return "Album{" +
                "ID del Album=" + id_album +
                ", Titulo del Album='" + titulo + '\'' +
                ", Fecha de Lanzamiento='" + fecha_lanzamiento + '\'' +
                '}';
    }
    @Override
    @Operation(summary = "Comparar dos álbumes")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album Album = (Album) o;

        if (!id_album.equals(Album.id_album)) return false;
        if (!titulo.equals(Album.titulo)) return false;
        return fecha_lanzamiento.equals(Album.fecha_lanzamiento);
    }
    @Override
    @Operation(summary = "Generar código hash del álbum")
    public int hashCode() {
        int result = id_album.hashCode();
        result = 31 * result + titulo.hashCode();
        result = 31 * result + fecha_lanzamiento.hashCode();
        return result;
    }

}