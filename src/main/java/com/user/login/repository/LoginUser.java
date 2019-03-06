package com.user.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.login.entity.Login;

@Repository
public interface LoginUser extends JpaRepository<Login, Long>{
	
	
	@Query("SELECT login FROM Login login where login.email = :email")
    public Optional<Login> findByEmail(@Param("email") String email); 
    

}
