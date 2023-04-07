package bg.softuni.libra.repository;

import bg.softuni.libra.model.dto.SearchBookDTO;
import bg.softuni.libra.model.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookSpecification implements Specification<BookEntity> {
    private final SearchBookDTO searchBookDTO;

    public BookSpecification(SearchBookDTO searchBookDTO) {
        this.searchBookDTO = searchBookDTO;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {

        Predicate p = cb.conjunction();

        if (searchBookDTO.getWriter() != null && !searchBookDTO.getWriter().isEmpty()) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.join("writer").get("name"), searchBookDTO.getWriter()))
            );
        }

        if (searchBookDTO.getMinPrice() != null) {
            p.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("price"), searchBookDTO.getMinPrice()))
            );
        }

        if (searchBookDTO.getMaxPrice() != null) {
            p.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("price"), searchBookDTO.getMaxPrice()))
            );
        }

        return p;

    }
}