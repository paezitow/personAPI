package com.htsproductions.com.usermanager.entity.dto;

import com.htsproductions.com.usermanager.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {


    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @CPF
    @NotEmpty
    private String cpf;


    private LocalDate birthDate;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;
}

