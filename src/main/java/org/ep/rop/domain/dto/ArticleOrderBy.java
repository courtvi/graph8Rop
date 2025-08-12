package org.ep.rop.domain.dto;

public class ArticleOrderBy {
    private SortDirection num;

    public SortDirection getNum() {
        return num;
    }

    public void setNum(SortDirection num) {
        this.num = num;
    }

    public enum SortDirection {
        ASC, DESC
    }
}