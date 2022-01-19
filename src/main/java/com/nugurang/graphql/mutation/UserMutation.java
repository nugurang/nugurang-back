package com.nugurang.graphql.mutation;

import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserInputDto;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

@Service
public class UserMutation implements GraphQLMutationResolver {
    private final UserService userService;

    public UserDto createCurrentUser(UserInputDto userInputDto) {
        return userService.createUser(userInputDto).toDto();
    }

    public UserDto updateCurrentUser(UserInputDto userInputDto) {
        return userService.updateCurrentUser(userInputDto).toDto();
    }

    public Long deleteUser(Long userId) {
        return userService.deleteUser(userId);
    }

    public Long deleteCurrentUser() {
        return userService.deleteCurrentUser();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public UserMutation(final UserService userService) {
        this.userService = userService;
    }
    //</editor-fold>
}
