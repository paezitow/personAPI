package mapper;

import com.htsproductions.com.usermanager.entity.Person;
import com.htsproductions.com.usermanager.entity.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyy")
    Person toModel (PersonDTO personDTO);

    PersonDTO toDTO (Person person);
;}
