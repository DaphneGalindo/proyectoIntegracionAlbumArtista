package mx.artista.artista;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "ArtistaControlador", description = "Controlador de Artistas que ayuda a dar sesion")
class ArtistaController {

    private final ArtistaRepository repository;
    ArtistaController(ArtistaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/artistas")
    @Operation(summary = "Obtener todos los artistas", description = "Devuelve una lista de todos los artistas en la base de datos")
    List<Artista> all() {
      return repository.findAll();
    }

    @PostMapping("/artistas")
    @Operation(summary = "Crear un nuevo artista", description = "Crea un nuevo artista en la base de datos")
    Artista newArtista(@RequestBody Artista newArtista) {
      return repository.save(newArtista);
    }
    @GetMapping("/artistas/{id}")
    @Operation(summary = "Obtener un artista por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artista encontrado"),
        @ApiResponse(responseCode = "404", description = "Artista no encontrado")
    })
    Artista one(@Parameter(description = "ID del artista")@PathVariable Long id) {
      return repository.findById(id)
        .orElseThrow(() -> new ArtistaNotFoundException(id));
    }

    @PutMapping("/artistas/{id}")
    @Operation(summary = "Actualizar un artista existente")
    Artista replaceArtista(@RequestBody Artista newArtista, 
    @Parameter(description = "ID del artista a actualizar") @PathVariable Long id) {
      return repository.findById(id)
        .map(artista -> {
          artista.setNombre(newArtista.getNombre());
          artista.setPaisOrigen(newArtista.getPaisOrigen());
          return repository.save(artista);
        })
        .orElseGet(() -> {
          newArtista.setId_artista(id);
          return repository.save(newArtista);
        });
    }
    @DeleteMapping("/artistas/{id}")
    @Operation(summary = "Eliminar un artista por su ID")
    void deleteArtista(@Parameter(description = "ID del artista a eliminar")@PathVariable Long id) {
      repository.deleteById(id);
    }

}
