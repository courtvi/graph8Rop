package org.ep.rop.domain.repository;
import org.ep.rop.domain.model.Entities.AnnexEntity;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.springframework.data.neo4j.repository.*;

import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AnnexRepository extends ReactiveNeo4jRepository<AnnexEntity, UUID> {
    Mono<AnnexEntity> findById(UUID id);

    @Query("MATCH (r:Rop)-[:HAS_ANNEX]->(a:Annex) WHERE r.id = $ropId RETURN a ORDER BY a.component" )
    Flux<TitleEntity> findByRopId(UUID ropId);
}
