package com.onlinecourse.userservice.controller;

import com.onlinecourse.userservice.entity.UserEntity;
import com.onlinecourse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * metodo que se encarga de crear un usuario
     * @param userEntity
     * @return entidad usuario, response status CREATED
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    /**
     * metodo para modificar los datos del usuario al cual corresponda el id proporcionado
     * @param userEntity
     * @param id
     * @return response status OK
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable String id){
        return userService.updateUser(userEntity, id);
    }

    /**
     * listar los usuarios creados
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> listUsers(){
        return userService.list();
    }


}
