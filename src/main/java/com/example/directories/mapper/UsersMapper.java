package com.example.directories.mapper;

import com.example.directories.model.Users;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersMapper {

    boolean insert(Users users);

    boolean update(Users users);

    boolean delete(int id);

    @Select("select * from users where id = #{id}")
    Users find(int id);

    List<Users> getAllUsers();

    Page<Users> getPageUsers(Map<String,Object> map);

}
