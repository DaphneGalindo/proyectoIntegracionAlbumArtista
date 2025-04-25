package mx.artista.artista;

public class ArtistaNotFoundException extends RuntimeException {
    public ArtistaNotFoundException(Long id) {
        super("No se encontró el artista " + id);
    }
    
}
