package com.example.directories.controller;

import com.example.directories.model.JsonResult;
import com.example.directories.model.Users;
import com.example.directories.service.UsersService;
import com.example.directories.tools.JsonUtility;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@MapperScan("com.example.directories.mapper")
@ComponentScan({"com.example.directories.service"})
@Api("UsersController 相关的Api")
public class UsersController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UsersService usersService;

    @ApiOperation(value = "根据id查询用户信息",notes="查询数据库某个用户信息")
    @ApiImplicitParam(name="id",value = "用户id",paramType = "query",dataType = "Integer")
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public Object find(@RequestParam(value = "id",required=true) Integer id){
        logger.error("开始 根据id查询用户信息 用户ID:"+id);
        Users users =null;
        try{
            users= usersService.find(id);
            //return JsonUtility.convertBean2Json(users);
        }
        catch (Exception ex){
            logger.error("根据id查询用户信息 error:"+ex.getMessage());
        }
        return users;
    }

    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    @ApiOperation(value="添加用户信息")
    public Object insert(@RequestBody Users users){
        if(users.getUserName()==""){
            return ReturnOperterResult(false,"姓名不能为空！",null);
        }

        boolean isSuccess=usersService.insert(users);
        if(isSuccess==true){
            logger.info("添加用户信息成功");
            return  ReturnOperterResult(true,"操作成功！",null);
        }
        else {
            logger.info("添加用户信息失败");
            return  ReturnOperterResult(false,"操作失败！",null);
        }
    }

    @ApiOperation(value="通过ID更新用户信息")
    @ApiImplicitParam(name="id",value = "用户id",paramType = "query",required = true,dataType = "int")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object update(@ApiParam(value = "用户",required = true) @ModelAttribute Users users){
        boolean isSuccess=usersService.update(users);
        if(isSuccess==true){
            logger.info("更新用户信息成功:"+ JsonUtility.convertBean2Json(users));
            return  ReturnOperterResult(true,"操作成功！",null);
        }
        else {
            logger.info("更新用户信息失败:"+ JsonUtility.convertBean2Json(users));
            return  ReturnOperterResult(false,"操作失败！",null);
        }
    }

    @ApiOperation(value="通过ID删除数据")
    @ApiImplicitParam(name="id",value = "用户id",paramType = "query", required = true,dataType = "Integer")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Object delete(@RequestParam(value = "id",required = true) Integer id){
        boolean isSuccess=usersService.delete(id);
        if(isSuccess==true){
            logger.info("删除用户信息成功:"+ id);
            return  ReturnOperterResult(true,"操作成功！",null);
        }
        else {
            logger.info("删除用户信息失败:"+ id);
            return  ReturnOperterResult(false,"操作失败！",null);
        }
    }

    @ApiOperation(value = "获取全部数据")
    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    public Object getAllUsers(){
        //List<Users> list=usersService.getAllUsers();
        //return JsonUtility.convertBean2Json(list);
        return usersService.getAllUsers();
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "第几页",paramType = "path",dataType = "int"),
            @ApiImplicitParam(name="rows",value = "每页共几条",paramType = "path",dataType = "int")
    })
    @RequestMapping(value = "/getPageUsers",method = RequestMethod.GET)
    public Object getPageUsers(@RequestParam(name="page", defaultValue = "1") int page,
                               @RequestParam(name="rows", defaultValue = "10") int rows){
        Page<Users> list=usersService.getPageUsers(page,rows);
       // String json=JsonUtility.convertBean2Json(list);
        return list;
    }

    private  Object ReturnOperterResult(boolean isSuccess, String errorMsg,Object Content)
    {
        JsonResult result = new JsonResult();
        result.setMsg(errorMsg);
        result.setContent(Content);
        result.setSuccess(isSuccess);
        //return JsonUtility.convertBean2Json(result);
        return result;
    }
}
