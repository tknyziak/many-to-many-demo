package io._10a.m2mdemo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/album")
@Produces(MediaType.APPLICATION_JSON)
public class AlbumResource {

    @Inject EntityManager em;

//    @Inject TransactionManager transactionManager;

    @GET
    @Path("/{id}")
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

    @PUT
    @Path("/new")
    @Transactional()
    public AlbumDTO saveNewAlbum(AlbumDTO albumDTO) {

        Album album = new Album();
        album.setTitle(albumDTO.title());


//        try {
//            transactionManager.begin();

            em.persist(album);
            em.flush();

//            transactionManager.commit();
//        } catch (Exception e) {
//            try {
//                transactionManager.rollback();
//            } catch (SystemException ex) {
//                throw new RuntimeException(ex);
//            }
//            throw new RuntimeException("Transaction error", e);
//        }

        return new AlbumDTO(album.getId(), album.getTitle(), Collections.emptyList());


    }


}