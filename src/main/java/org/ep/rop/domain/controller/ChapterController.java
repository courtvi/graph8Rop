package org.ep.rop.domain.controller;

import org.ep.rop.domain.dto.ChaptersWrapper;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.ep.rop.domain.model.Entities.SectionEntity;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.ep.rop.domain.repository.ArticleRepository;
import org.ep.rop.domain.repository.ChapterRepository;
import org.ep.rop.domain.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

    private final SectionRepository sectionRepository;
    private final ChapterRepository chapterRepository;
    private final ArticleRepository articleRepository;
    @Autowired
    public ChapterController(ChapterRepository chapterRepository, SectionRepository sectionRepository, ArticleRepository articleRepository) {
        this.chapterRepository = chapterRepository;
        this.sectionRepository = sectionRepository;
        this.articleRepository = articleRepository;
    }

    //reactive endpoints

    @PutMapping
    public Flux<ChapterEntity> createOrUpdateChapters(@RequestBody ChaptersWrapper wrapper) {
        return Flux.fromIterable(wrapper.getChapters())
                .flatMap(chapterRepository::save);
    }

    @PutMapping("/{id}")
    public Mono<ChapterEntity> updateChapter(@PathVariable UUID id, @RequestBody ChapterEntity chapter) {
        return chapterRepository.findById(id)
                .flatMap(updateChapter -> {
                    updateChapter.setNum(chapter.getNum());
                    updateChapter.setHeading(chapter.getHeading());
                    updateChapter.setComponentOrder(chapter.getComponentOrder());
                    updateChapter.setSections(chapter.getSections());
                    updateChapter.setArticles(chapter.getArticles());
                    return chapterRepository.save(updateChapter);
                });
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ChapterEntity> getChapters() {
        return chapterRepository.findAll();
    }

    @GetMapping("/by-heading")
    Mono<ChapterEntity> byHeading(@RequestParam UUID id) {
        return chapterRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable UUID id) {
        return chapterRepository.deleteById(id);
    }

    @QueryMapping
    public Flux<ChapterEntity> chapters() {
        return chapterRepository.findAll();
    }

    @SchemaMapping(typeName = "Chapter", field = "sections")
    public Flux<SectionEntity> getSections(ChapterEntity chapter) {
        return sectionRepository.findByChapterId(chapter.getId());
    }

    @SchemaMapping(typeName = "Chapter", field = "articles")
    public Flux<ArticleEntity> getArticles(ChapterEntity chapter) {
        return articleRepository.findByChapterId(chapter.getId());
    }
}