package mx.album.album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    // This interface will automatically provide CRUD operations for the Employee entity
    // No need to implement any methods, Spring Data JPA will handle it for us
}
