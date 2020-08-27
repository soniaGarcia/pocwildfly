package sv.gob.mh.saif2.clasificadores.api.v1.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sv.gob.mh.common.querydsl.AbstractRepository;
import sv.gob.mh.common.querydsl.AbstractService;
import sv.gob.mh.safi2.clasificadores.api.v1.model.Itemclasificador;
import sv.gob.mh.saif2.clasificadores.api.v1.repository.ItemClasificadorRepository;

@Stateless
public class ItemClasificadorService extends AbstractService<Itemclasificador, Long> {

    @Inject
    private ItemClasificadorRepository itemClasificadorRepository;

    @Override
    public AbstractRepository<Itemclasificador, Long> getRepository() {
        return itemClasificadorRepository;
    }

    public List<Itemclasificador> findAllByClasificadorCode(String clasificadorCode) {
        return itemClasificadorRepository.findAllByClasificadorCode(clasificadorCode);
    }

}
