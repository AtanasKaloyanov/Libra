package bg.softuni.libra.mapper;

import bg.softuni.libra.model.dto.AddBookDTO;
import bg.softuni.libra.model.dto.BookDetailDTO;
import bg.softuni.libra.model.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity addBookDtoToBookEntity(AddBookDTO addBookDTO);

    @Mapping(source = "writer.name", target = "writer")
    BookDetailDTO bookEntityToBookDetailDto(BookEntity bookEntity);


}
