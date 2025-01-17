package com.guleni.project.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
@Data
public class Tpage<T> {

    private int number;
    private int size;
    private Sort sort;
    private int totalPages;
    private Long totalElements;
    private List<T> content;

    public void setStat(Page page,List<T> list)
    {
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalElements=page.getTotalElements();
        this.totalPages=page.getTotalPages();
        this.content=list;
    }
}
