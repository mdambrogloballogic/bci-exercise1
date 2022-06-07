package com.mdambro.bci.exercise1.mapper;

import com.mdambro.bci.exercise1.dto.user.PhoneDTO;
import com.mdambro.bci.exercise1.entity.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper( PhoneMapper.class );

    PhoneDTO phoneEntityToPhoneDTO( PhoneEntity phone );

    @Mapping( target = "userId", ignore = true )
    PhoneEntity phoneDTOToPhoneEntity( PhoneDTO phone );
}
