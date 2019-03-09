package com.kk.jpa;

import com.kk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User,Integer> {
}
