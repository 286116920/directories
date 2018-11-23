package com.example.directories.service;

import com.example.directories.model.Users;
import com.github.pagehelper.Page;

import java.util.List;

public interface IUsersService {

    boolean insert(Users users);

    boolean update(Users users);

    boolean delete(int id);

    Users find(int id);

    List<Users> getAllUsers();

    Page<Users> getPageUsers(int page, int rows);

}
