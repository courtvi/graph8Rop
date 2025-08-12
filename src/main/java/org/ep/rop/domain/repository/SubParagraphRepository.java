package org.ep.rop.domain.repository;

import org.ep.rop.domain.model.Entities.SubparagraphEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SubParagraphRepository extends ReactiveNeo4jRepository<SubparagraphEntity, UUID> {
    Mono<SubparagraphEntity> findById(UUID id);
}
