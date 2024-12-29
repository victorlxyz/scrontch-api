package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.entity.Nonfooditem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NonfooditemMapper {
    Nonfooditem toEntity(NonfooditemDto nonfooditemDto);

    NonfooditemDto toDto(Nonfooditem nonfooditem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Nonfooditem partialUpdate(NonfooditemDto nonfooditemDto, @MappingTarget Nonfooditem nonfooditem);
}