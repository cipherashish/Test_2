package com.spring.angular.xfs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.angular.xfs.Xfs;

@Repository
public interface XfsRepository extends CrudRepository<Xfs, Long>{}