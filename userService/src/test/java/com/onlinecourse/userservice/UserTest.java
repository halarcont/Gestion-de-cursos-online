package com.onlinecourse.userservice;
import com.onlinecourse.userservice.entity.UserEntity;
import com.onlinecourse.userservice.exception.RequestException;
import com.onlinecourse.userservice.repository.UserRepository;
import com.onlinecourse.userservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUserSuccess() {
        UserEntity userEntity = new UserEntity(null, "Heriberto", "A", "ads");
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        userService.createUser(userEntity);

        verify(userRepository).save(userEntity);
    }

    @Test
    public void createUserEmptyEmail() {
        UserEntity userEntity = new UserEntity(null, "Heriberto", "A", "");

        assertThrows(RequestException.class, () -> userService.createUser(userEntity));
    }

    @Test
    public void createUserEmptyUserName() {
        UserEntity userEntity = new UserEntity(null, "", "A", "asd");

        assertThrows(RequestException.class, () -> userService.createUser(userEntity));
    }
}
