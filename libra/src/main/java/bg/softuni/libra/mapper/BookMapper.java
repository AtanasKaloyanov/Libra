package bg.softuni.libra.mapper;

import bg.softuni.libra.model.dto.AddBookDTO;
import bg.softuni.libra.model.dto.BookDetailDTO;
import bg.softuni.libra.model.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity addBookDtoToBookEntity(AddBookDTO addBookDTO);

    AddBookDTO bookEntityToCreateOrUpdateBookDtoTo(BookEntity bookEntity);

    @Mapping(source = "writer.name", target = "writer")
    @Mapping(source = "writer.publisher.name", target = "publisher")
    @Mapping(source = "reader.firstName", target = "readerFirstName")
    @Mapping(source = "reader.lastName", target = "readerLastName")

    BookDetailDTO bookEntityToBookDetailDto(BookEntity bookEntity);


}
