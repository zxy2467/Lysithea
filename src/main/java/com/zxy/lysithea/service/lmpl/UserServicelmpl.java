package com.zxy.lysithea.service.lmpl;

import com.zxy.lysithea.Entity.User;
import com.zxy.lysithea.dao.UserRepository;
import com.zxy.lysithea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserRepository userRepository;//操作用户实体
    @Override
    public void save(User u) {
        userRepository.save(u);

    }

    @Override
    public Page<User> findAll(String kw, Pageable pageable) {
        return userRepository.findByKeyword(kw, pageable);
    }

    @Override
    public User findById(Integer uid) {
        return userRepository.findById(uid).get();

    }

    @Override
    public void delete(User u) {
        userRepository.delete(u);

    }

    @Override
    public void deleteById(Integer uid) {
        userRepository.deleteById(uid);

    }
    @Transactional
    @Override
    public void deletes(List<User> users) {
        for(User u : users){
            userRepository.delete(u);
        }

    }
}
