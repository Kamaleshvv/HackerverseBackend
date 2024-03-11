package com.Hackerverse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Hackerverse.bean.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Integer>{

}
