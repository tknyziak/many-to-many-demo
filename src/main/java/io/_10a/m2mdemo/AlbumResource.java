package io._10a.m2mdemo;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/album")
public class AlbumResource {

    @Inject EntityManager em;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AlbumDTO getAlbum(@PathParam("id") Long albumId) {
        final Album album = em.find(Album.class, albumId);
        if (album == null) {
            throw new NotFoundException();
        }

        List<SongDTO> songDtos = album.getSongs().stream().map(soa -> new SongDTO(soa.getSong().getId(), soa.getSong().getTitle())).toList();

        AlbumDTO albumDTO = new AlbumDTO(
                albumId,
                album.getTitle(),
                songDtos
        );

        return albumDTO;
    }
}