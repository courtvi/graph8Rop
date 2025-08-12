package org.ep.rop.domain.controller;

import org.ep.rop.domain.dto.RopsWrapper;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.ep.rop.domain.model.Entities.RopEntity;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.ep.rop.domain.repository.ChapterRepository;
import org.ep.rop.domain.repository.RopRepository;
import org.ep.rop.domain.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/rop")
public class RopController {


    private final RopRepository ropRepository;
    private final TitleRepository titleRepository;


    @Autowired
    public RopController(RopRepository ropRepository, TitleRepository titleRepository) {
        this.ropRepository = ropRepository;
        this.titleRepository = titleRepository;

    }

    // ===== REST API =====

    @PutMapping
    public Flux<RopEntity> createOrUpdateRops(@RequestBody RopsWrapper wrapper) {
        return Flux.fromIterable(wrapper.getRops())
              .flatMap(ropRepository::save);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<RopEntity> getTitles() {
            return ropRepository.findAll();
        }

    @GetMapping("/by-heading")
    Mono<RopEntity> byHeading(@RequestParam UUID id) {
            return ropRepository.findById(id);
        }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable UUID id) {
            return ropRepository.deleteById(id);
        }

    @PutMapping("/{id}")
    public Mono<RopEntity> updateRopLegislature(@PathVariable UUID id, @RequestBody RopEntity rop) {
        return ropRepository.findById(id)
                .flatMap(updateRop -> {
                    updateRop.setLegislature(rop.getLegislature());
                    updateRop.setDocTitle(rop.getDocTitle());
                    updateRop.setTitles(rop.getTitles());
                    updateRop.setAnnexes(rop.getAnnexes());
                    return ropRepository.save(updateRop);
                });
    }

    // ===== GraphQL API =====

    @QueryMapping
    public Flux<RopEntity> rops() {
        return ropRepository.findAll();
    }

    @QueryMapping
    public Mono<RopEntity> rop(@Argument UUID id) {
        return ropRepository.findById(id);
    }

    @SchemaMapping(typeName = "Rop", field = "titles")
    public Flux<TitleEntity> getTitles(RopEntity rop) {
        return titleRepository.findByRopId(rop.getId());
    }

}