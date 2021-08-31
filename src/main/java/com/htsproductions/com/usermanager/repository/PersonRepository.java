package com.htsproductions.com.usermanager.repository;

import com.htsproductions.com.usermanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
