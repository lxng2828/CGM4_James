package com.example.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

}
