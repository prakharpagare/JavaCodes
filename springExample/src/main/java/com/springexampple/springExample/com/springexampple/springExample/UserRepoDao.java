package com.springexampple.springExample.com.springexampple.springExample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoDao extends JpaRepository<UserDetails, Integer>  {

}
