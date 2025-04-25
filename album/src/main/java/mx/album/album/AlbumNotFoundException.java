package mx.album.album;
public class AlbumNotFoundException extends RuntimeException {

    AlbumNotFoundException(Long id_album) {
        super("Could not find album " + id_album);
    }


}
