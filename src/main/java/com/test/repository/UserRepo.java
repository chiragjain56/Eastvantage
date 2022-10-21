package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}

//interface x {
//void fun1();
//}
//
//interface y extends x {
//
//}

//spring data jpa fram. will provide the impl. of the password repo of interface(ie spring data jpa fram. will create an internal class which impl.
//password repo interface and create its object and register with spring container as spring bean.