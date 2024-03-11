package com.Hackerverse.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Hackerverse.bean.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea,Integer>{
   public List<Idea> findByPanelistIdAndStatus(int id,String status);
}
