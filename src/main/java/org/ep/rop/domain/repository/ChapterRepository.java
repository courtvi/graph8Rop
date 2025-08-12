package org.ep.rop.domain.repository;
import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.springframework.data.neo4j.repository.*;

import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ChapterRepository extends ReactiveNeo4jRepository<ChapterEntity, UUID> {
    Mono<ChapterEntity> findById(UUID id);

    @Query("MATCH (t:Title)-[:HAS_CHAPTER]->(c:Chapter) WHERE t.id = $titleId RETURN c ORDER BY c.componentOrder")
    Flux<ChapterEntity> findByTitleId(UUID titleId);
}
