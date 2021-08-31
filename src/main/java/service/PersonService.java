package service;


import com.htsproductions.com.usermanager.entity.Person;
import com.htsproductions.com.usermanager.entity.dto.MessageResponseDTO;
import com.htsproductions.com.usermanager.entity.dto.PersonDTO;
import com.htsproductions.com.usermanager.repository.PersonRepository;
import exception.PersonNotFoundException;
import mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository repository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = repository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Person created with ID: " + savedPerson.getId())
                .build();
    };

    public List<PersonDTO> listAll() {
        List<Person> allPerson = repository.findAll();
        return allPerson.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person =   verifyIfExists(id);
        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        repository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO)throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = repository.save(personToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Person updated with ID: " + updatedPerson.getId())
                .build();
    }

    //retorno da verificação se existe no banco
    public Person verifyIfExists(Long id) throws PersonNotFoundException {
        return repository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
    }
}
