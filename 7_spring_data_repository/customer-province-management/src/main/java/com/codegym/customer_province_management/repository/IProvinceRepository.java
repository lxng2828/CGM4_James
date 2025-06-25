package com.codegym.customer_province_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegym.customer_province_management.model.Province;

@Repository
public interface IProvinceRepository extends CrudRepository<Province,Long>{

}
