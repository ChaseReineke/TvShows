package com.chase.main.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chase.main.models.Tv;

@Repository
public interface TvRepo extends CrudRepository<Tv, Long> {
	List<Tv> findAll();
	

}