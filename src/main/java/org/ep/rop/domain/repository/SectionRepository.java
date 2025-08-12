package org.ep.rop.domain.repository;

import org.ep.rop.domain.model.Entities.SectionEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SectionRepository extends ReactiveNeo4jRepository<SectionEntity, UUID> {

    Mono<SectionEntity> findById(UUID id);

    @Query("MATCH (c:Chapter)-[:HAS_SECTION]->(s:Section) WHERE c.id = $chapterId RETURN s")
    Flux<SectionEntity> findByChapterId(UUID chapterId);

    @Query("MATCH (a:Annex)-[:HAS_SECTION]->(s:Section) WHERE a.id = $annexId RETURN s")
    Flux<SectionEntity> findByAnnexId(UUID annexId);
}
