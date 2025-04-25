package mx.artista.artista;

import java.util.Objects;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
@Tag(name = "Artista", description = "Entidad Artista que representa a un artista en la base de datos")
class Artista {

  private @Id
  @GeneratedValue Long id_artista;
  private String nombre;
  private String paisOrigen;

  public Artista() {}

  public Artista(String nombre, String paisOrigen) {
    this.nombre = nombre;
    this.paisOrigen = paisOrigen;
  }
  @Operation(summary = "Obtener el ID del artista")
  public Long getId_Artista() {
    return this.id_artista;
  }
  @Operation(summary = "Obtener el nombre del artista")
  public String getNombre() {
    return this.nombre;
  }
  @Operation(summary = "Obtener el país de origen del artista")
  public String getPaisOrigen() {
    return this.paisOrigen;
  }

  @Operation(summary = "Establecer el ID del artista")
  public void setId_artista(Long id_artista) {
    this.id_artista = id_artista;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Operation(summary = "Establecer el país de origen del artista")
  public void setPaisOrigen(String paisOrigen) {
    this.paisOrigen = paisOrigen;
  }

  @Override
  @Operation(summary = "Comparar dos objetos Artista para verificar si son iguales")
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Artista))
      return false;
    Artista artista = (Artista) o;
    return Objects.equals(this.id_artista,artista.id_artista) && Objects.equals(this.nombre,artista.nombre) && Objects.equals(this.paisOrigen,artista.paisOrigen);
  }

  @Override
  @Operation(summary = "Obtener el código hash del objeto Artista")
  public int hashCode() {
    return Objects.hash(this.id_artista, this.nombre, this.paisOrigen);
  }

  @Override
  @Operation(summary = "Obtener una representación en cadena del objeto Artista")
  public String toString() {
    return "Artistas{" + "id_artista=" + this.id_artista + ", nombre='" + this.nombre + '\'' + ", pais de origen='" + this.paisOrigen + '\'' + '}';
  }
}