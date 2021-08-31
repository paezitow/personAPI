package controller;


import com.htsproductions.com.usermanager.entity.Person;
import com.htsproductions.com.usermanager.entity.dto.MessageResponseDTO;
import com.htsproductions.com.usermanager.entity.dto.PersonDTO;
import com.htsproductions.com.usermanager.repository.PersonRepository;
import exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
       return personService.createPerson(personDTO);
    };

    @GetMapping
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteById (@PathVariable Long id) throws PersonNotFoundException{
        personService.delete(id);
    }

    @PutMapping
    @RequestMapping("/{id}")
    public MessageResponseDTO updateById (@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updateById(id, personDTO);
    }
}
