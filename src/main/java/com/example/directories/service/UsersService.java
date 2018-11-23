package com.example.directories.service;

import com.example.directories.mapper.UsersMapper;
import com.example.directories.model.Users;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan({"com.example.directories.mapper"})
@Service("usersService")
public class UsersService implements IUsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public boolean insert(Users users){
        return usersMapper.insert(users);
    }

    public boolean update(Users users){
        return usersMapper.update(users);
    }

    public Users find(int id){
        return usersMapper.find(id);
    }

    public boolean delete(int id){ return usersMapper.delete(id); }

    public List<Users> getAllUsers(){ return usersMapper.getAllUsers(); }

    @Override
    public Page<Users> getPageUsers(int page, int rows){
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(page,rows);
        return usersMapper.getPageUsers(map);
    }
}
