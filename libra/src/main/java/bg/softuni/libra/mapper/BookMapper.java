//package bg.softuni.libra.mapper;
//
//import bg.softuni.libra.model.dto.AddBookDTO;
//import bg.softuni.libra.model.entity.BookEntity;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring")
//public interface BookMapper {
//    BookEntity addBookDtoToBookEntity(AddBookDTO addBookDTO);
//
//    @Mapping(source = "model.name", target = "model")
//    @Mapping(source = "model.brand.name", target = "brand")
//    CardListingOfferDTO offerEntityToCardListingOfferDto(OfferEntity offerEntity);
//}
