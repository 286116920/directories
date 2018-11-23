package com.example.directories.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsersControllerTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void find()  {
        try {
            String responseString = mockMvc.perform
                    (
                            MockMvcRequestBuilders
                                    .get("/user/find")//请求的url,请求的方法是get
                                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)//发送数据的格式
                                    .param("id","1")   //添加参数(可以添加多个)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                    .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
            System.out.println("-----返回的json = " + responseString);
            logger.info("日志输出:"+responseString);
        }
        catch (Exception ex){
            logger.error("测试 find 异常："+ex.getMessage() );
        }
    }

    @Test
    public void insert()  {
        try {
            String responseString = mockMvc.perform
                    (
                            MockMvcRequestBuilders
                                    .post("/user/insert")//请求的url,请求的方法是post
                                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)//发送数据的格式
                                    .param("UserName","用户100")   //添加参数(可以添加多个)
                                    .param("Sex","男")   //添加参数(可以添加多个)
                                    .param("Age","18")   //添加参数(可以添加多个)
                                    .param("Phone","15003943003")   //添加参数(可以添加多个)
                                    .param("Address","上海市徐汇区钦州北路1001号")   //添加参数(可以添加多个)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                    .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
            System.out.println("-----返回的json = " + responseString);
        }
        catch (Exception ex){
            logger.error("测试 insert 异常："+ex.getMessage() );
        }
    }

    @Test
    public void update()  {
        try {
            String responseString = mockMvc.perform
                    (
                            MockMvcRequestBuilders
                                    .post("/user/update")//请求的url,请求的方法是post
                                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)//发送数据的格式
                                    .param("id","1")   //添加参数(可以添加多个)
                                    .param("UserName","用户100")   //添加参数(可以添加多个)
                                    .param("Sex","男")   //添加参数(可以添加多个)
                                    .param("Age","18")   //添加参数(可以添加多个)
                                    .param("Phone","15003943003")   //添加参数(可以添加多个)
                                    .param("Address","上海市徐汇区钦州北路1001号")   //添加参数(可以添加多个)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                    .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
            System.out.println("-----返回的json = " + responseString);
        }
        catch (Exception ex){
            logger.error("测试 update 异常："+ex.getMessage() );
        }
    }

    @Test
    public void delete()  {
        try {
            String responseString = mockMvc.perform
                    (
                            MockMvcRequestBuilders
                                    .get("/user/delete")//请求的url,请求的方法是post
                                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)//发送数据的格式
                                    .param("id","8")   //添加参数(可以添加多个)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                    .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
            System.out.println("-----返回的json = " + responseString);
        }
        catch (Exception ex){
            logger.error("测试 delete 异常："+ex.getMessage() );
        }
    }

    @Test
    public void getAllUsers(){
        try {
            String responseString = mockMvc.perform
                    (
                            MockMvcRequestBuilders
                                    .get("/user/getAllUsers")//请求的url,请求的方法是post
                                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)//发送数据的格式
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                    .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
            System.out.println("-----返回的json = " + responseString);
        }
        catch (Exception ex){
            logger.error("测试 getAllUsers 异常："+ex.getMessage() );
        }
    }

    @Test
    public void getPageUsers(){
        try {
            String responseString = mockMvc.perform
                    (
                            MockMvcRequestBuilders
                                    .get("/user/getPageUsers")//请求的url,请求的方法是post
                                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)//发送数据的格式
                                    .param("page", "1")
                                    .param("rows", "3")
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                    .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
            System.out.println("-----返回的json = " + responseString);
        }
        catch (Exception ex){
            logger.error("测试 getPageUsers 异常："+ex.getMessage() );
        }
    }

}