package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.entity.Nonfooditem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NonfooditemMapper {

    @Mapping(source = "shoppinglistid", target = "shoppinglistid.id")
    Nonfooditem toEntity(NonfooditemDto nonfooditemDto);

    @Mapping(source = "shoppinglistid.id", target = "shoppinglistid")
    NonfooditemDto toDto(Nonfooditem nonfooditem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "shoppinglistid", ignore = true)
    Nonfooditem partialUpdate(NonfooditemDto nonfooditemDto, @MappingTarget Nonfooditem nonfooditem);
}