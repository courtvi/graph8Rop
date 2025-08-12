package org.ep.rop.domain.repository;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.springframework.data.neo4j.repository.*;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TitleRepository extends ReactiveNeo4jRepository<TitleEntity, UUID> {
    Mono<TitleEntity> findById(UUID id);

    @Query("MATCH (r:Rop)-[:HAS_TITLE]->(t:Title) WHERE r.id = $ropId RETURN t ORDER BY t.componentOrder" )
    Flux<TitleEntity> findByRopId(UUID ropId);

}
