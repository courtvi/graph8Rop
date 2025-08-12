package org.ep.rop.domain.model.Entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.UUID;

@Node("Subparagraph")
public class SubparagraphEntity {

        @Id
        @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
        private UUID id;

        @Relationship(type = "CONTENT", direction = Relationship.Direction.OUTGOING)
        private ContentEntity content;

    public ListEntity list;

        public SubparagraphEntity() {
            // Constructeur par défaut
        }


        public SubparagraphEntity(ContentEntity content) {
            this.content = content;
        }

        public SubparagraphEntity(ListEntity list) {
            this.list = list;
        }

        // Getters and setters
        public UUID getId() {
            return id;
        }

        public ContentEntity getContent() {
            return content;
        }

        public ListEntity getList() {
            return list;
        }
        public void setList(ListEntity list) { this.list = list;}

        public void setContent(ContentEntity content) {
        this.content = content;
    }


}
