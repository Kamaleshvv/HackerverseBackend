package com.Hackerverse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Hackerverse.bean.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer>{

}
