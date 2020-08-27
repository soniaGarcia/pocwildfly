package sv.gob.mh.saif2.clasificadores.api.v1.config;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api/v1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sv.gob.mh.saif2.clasificadores.api.v1.resource.ClasificadorResource.class);
        resources.add(sv.gob.mh.saif2.clasificadores.api.v1.resource.ItemClasificadorResource.class);
    }

}
