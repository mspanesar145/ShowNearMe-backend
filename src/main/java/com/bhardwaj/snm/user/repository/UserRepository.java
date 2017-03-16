package com.bhardwaj.snm.user.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bhardwaj.snm.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findOneByPhone(String phone);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update User u set u.device=:device, u.token =:token where u.userId =:userId")
	public User updateUser(@Param("userId") Long userId, @Param("device") String device, @Param("token") String token);

}
