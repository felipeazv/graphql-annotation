package com.feazesa.graphql.entity;

import java.util.List;

import com.feazesa.graphql.handler.UserHandler;
import com.feazesa.graphql.utils.SchemaUtils;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@GraphQLName(SchemaUtils.USER)
public class User {

    @GraphQLField
    private Long id;
    @GraphQLField
    private String name;
    @GraphQLField
    private String email;
    @GraphQLField
    private Integer age;
    
    public User(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public static Long genId() {
        Long id = 1L;
        try {
            new UserHandler();
            List<User> users =  UserHandler.getUsers();
            for (User user : users)
                id = (user.getId() > id ? user.getId() : id) + 1;
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public String toString() {
        return "[id=" + id + ", name=" + name + ", email="+email+ ", age="+ age +"]";
    }
}