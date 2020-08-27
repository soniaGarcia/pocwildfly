package sv.gob.mh.saif2.clasificadores.api.v1.resource;

import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import sv.gob.mh.safi2.clasificadores.api.v1.model.Clasificador;
import sv.gob.mh.saif2.clasificadores.api.v1.service.ClasificadorService;

@Path("/clasificadores")
@Getter
@Setter
@Log
public class ClasificadorResource {

    @Inject
    transient ClasificadorService clasificadorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Response ret;
        try {
            List<Clasificador> list = clasificadorService.findAll();
            ret = Response.status(Response.Status.OK).entity(list).build();
        } catch (Exception ex) {
            ret = Response.serverError().build();
            log.log(Level.SEVERE, null, ex);
        }
        return ret;
    }

}
