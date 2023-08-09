package com.onlinecourse.userservice.service;

import com.onlinecourse.userservice.entity.UserEntity;
import com.onlinecourse.userservice.exception.BusinessException;
import com.onlinecourse.userservice.exception.RequestException;
import com.onlinecourse.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * clase que maneja la logica detras de los metodos del controlador
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * se crea un usuario siempre y cuando cumpla con las condicionales establecidas, si no, se devuelve una excepcion
     * @param userEntity
     * @return
     */
    @Override
    public UserEntity createUser(UserEntity userEntity) {

        if(userEntity.getEmail().equals("") || userEntity.getEmail() == null){
            throw new RequestException("E-401","email is required");
        }
        if(userEntity.getUserName().equals("") || userEntity.getUserName() == null){
            throw new RequestException("E-402","user name is required");
        }
        if(userEntity.getEmail().equals("heriberto@gmail.com")){
            throw new BusinessException("E-300", HttpStatus.INTERNAL_SERVER_ERROR, "email already exists");
        }

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity, String id) {
        Optional<UserEntity> userEntityOld = userRepository.findById(id);
        if(!userEntityOld.isEmpty()){
            userEntityOld = Optional.ofNullable(userEntity);
            return userRepository.save(userEntityOld.get());
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    @Cacheable("list")
    public List<UserEntity> list() {
        return (List<UserEntity>) userRepository.findAll();
    }

}
