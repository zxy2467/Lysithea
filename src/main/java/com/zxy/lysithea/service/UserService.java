package com.zxy.lysithea.service;

import com.zxy.lysithea.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void save(User u);
    Page<User> findAll(String kw, Pageable pageable);
    User findById(Integer uid);
    void delete(User u);
    void deleteById(Integer uid);
    void deletes(List<User> users);


}
