package sv.gob.mh.saif2.clasificadores.api.v1.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import sv.gob.mh.common.querydsl.AbstractRepository;
import sv.gob.mh.common.querydsl.AbstractService;
import sv.gob.mh.safi2.clasificadores.api.v1.model.Clasificador;
import sv.gob.mh.saif2.clasificadores.api.v1.repository.ClasificadorRepository;

@Stateless
public class ClasificadorService extends AbstractService<Clasificador, Long> {

    @Inject
    private ClasificadorRepository clasificadorRepository;

    @Override
    public AbstractRepository<Clasificador, Long> getRepository() {
        return clasificadorRepository;
    }

}
