package org.zerock.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//import java.awt.print.Pageable;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    //목록 화면에서 페이지 처리 경우 번호, 목록 개수, 검색 조건 등 DTO 처리
    //재사용 용이

    private int page;
    private int size;
    private String type;
    private String keyword;

    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
