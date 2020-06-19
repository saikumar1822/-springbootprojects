package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Tranfer;
@Repository
public interface T1Repo extends JpaRepository<Tranfer, Integer>{

}
