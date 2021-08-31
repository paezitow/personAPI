package com.htsproductions.com.usermanager.repository;

import com.htsproductions.com.usermanager.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
