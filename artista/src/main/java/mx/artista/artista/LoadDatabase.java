package mx.artista.artista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Configuration
@Tag(name = "LoadDatabase", description = "Carga inicial de datos en la base de datos")
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    @Operation(summary = "Carga inicial de datos en la base de datos con algunos artistas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Datos precargados correctamente"),
        @ApiResponse(responseCode = "500", description = "Error al cargar los datos")
    })
    CommandLineRunner initDatabase(@Parameter(description="Inicialización de la base de datos") ArtistaRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Artista("Luis Miguel", "Mexico")));
            log.info("Preloading " + repository.save(new Artista("Jean Jungkook", "Corea del Sur")));
            
        };
    }
}
