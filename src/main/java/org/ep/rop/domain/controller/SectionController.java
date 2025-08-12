package org.ep.rop.domain.controller;

import org.ep.rop.domain.dto.SectionsWrapper;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.ep.rop.domain.model.Entities.SectionEntity;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.ep.rop.domain.repository.ArticleRepository;
import org.ep.rop.domain.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/sections")
public class SectionController {

    private final SectionRepository sectionRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public SectionController(SectionRepository sectionRepository, ArticleRepository articleRepository) {
        this.sectionRepository = sectionRepository;
        this.articleRepository = articleRepository;
    }

    //reactive endpoints

    @PutMapping
    public Flux<SectionEntity> createOrUpdateSections(@RequestBody SectionsWrapper wrapper) {
        return Flux.fromIterable(wrapper.getSections())
                .flatMap(sectionRepository::save);
    }

    @PutMapping("/{id}")
    public Mono<SectionEntity> updateSection(@PathVariable UUID id, @RequestBody SectionEntity section) {
        return sectionRepository.findById(id)
                .flatMap(updateSection -> {
                    updateSection.setNum(section.getNum());
                    updateSection.setHeading(section.getHeading());
                    updateSection.setComponentOrder(section.getComponentOrder());
                    updateSection.setArticles(section.getArticles());
                    return sectionRepository.save(updateSection);
                });
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<SectionEntity> getSections() {
        return sectionRepository.findAll();
    }

    @GetMapping("/by-heading")
    Mono<SectionEntity> byHeading(@RequestParam UUID id) {
        return sectionRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable UUID id) {
        return sectionRepository.deleteById(id);
    }

    @QueryMapping
    public Flux<SectionEntity> sections() {
        return sectionRepository.findAll();
    }

    @SchemaMapping(typeName = "Section", field = "articles")
    public Flux<ArticleEntity> getArticles(SectionEntity section) {
        return articleRepository.findBySectionId(section.getId());
    }
}