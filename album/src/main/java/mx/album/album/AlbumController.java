package mx.album.album;

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
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde el frontend
@Tag(name = "Album", description = "Controlador para gestionar álbumes")
public class AlbumController {
    private final AlbumRepository repository;

    public AlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/album")
    @Operation(summary = "Obtener todos los álbumes")
    List<Album> all(){
    return repository.findAll();
}
    @PostMapping("/album")
    @Operation(summary = "Crear un nuevo álbum")
    Album newEmployee(@RequestBody Album newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item
    @GetMapping("/album/{id}")
    @Operation(summary = "Obtener un álbum por ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Álbum encontrado"),
            @ApiResponse(responseCode = "404", description = "Álbum no encontrado")
    })
    Album one(@Parameter(description="ID del album")@PathVariable("id") Long idAlbum) {
        return repository.findById(idAlbum)
                .orElseThrow(() -> new AlbumNotFoundException(idAlbum));
    }

    @PutMapping("/album/{id}")
    @Operation(summary = "Actualizar un álbum existente")
    Album replaceAlbum(@RequestBody Album newAlbum, 
    @Parameter(description="ID del album por actualizar")@PathVariable Long id) {
        return repository.findById(id)
                .map(album -> {
                    album.setTitulo(newAlbum.getTitulo());
                    album.setFecha_lanzamiento(newAlbum.getFecha_lanzamiento());
                    return repository.save(album);
                })
                .orElseGet(() -> {
                    newAlbum.setIdAlbum(id);
                    return repository.save(newAlbum);
                });
    }

    @DeleteMapping("/album/{id}")
    @Operation(summary = "Eliminar un álbum por ID")
    void deleteAlbum(@Parameter(description="ID del album a eliminar")@PathVariable Long id_album) {
        repository.deleteById(id_album);
    }

    

}
