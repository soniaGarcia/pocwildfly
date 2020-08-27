package sv.gob.mh.saif2.clasificadores.api.v1.repository;

import java.util.List;
import sv.gob.mh.common.querydsl.AbstractRepository;
import sv.gob.mh.safi2.clasificadores.api.v1.model.Itemclasificador;
import sv.gob.mh.safi2.clasificadores.api.v1.model.QClasificador;
import sv.gob.mh.safi2.clasificadores.api.v1.model.QItemclasificador;

public class ItemClasificadorRepository extends AbstractRepository<Itemclasificador, Long> {

    public List<Itemclasificador> findAllByClasificadorCode(String clasificadorCode) {
        return queryFactory.from(QItemclasificador.itemclasificador)
                .innerJoin(QItemclasificador.itemclasificador.itemclasificador50453R, QClasificador.clasificador)
                .where(QClasificador.clasificador.codigo.equalsIgnoreCase(clasificadorCode != null ? clasificadorCode : "NA"))
                .select(QItemclasificador.itemclasificador)
                .fetch();
    }

}
