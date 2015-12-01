package de.helfenkannjeder.come2help.server.rest;

import de.helfenkannjeder.come2help.server.rest.dto.UserDto;
import java.util.HashMap;
import javax.transaction.Transactional;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Transactional
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public UserDto user(OAuth2Authentication principal) {
        HashMap<String, String> detailsMap = (HashMap<String, String>) principal.getUserAuthentication().getDetails();
        UserDto userDto = new UserDto(detailsMap.get("first_name"), detailsMap.get("last_name"), detailsMap.get("email"), Boolean.TRUE);
        return userDto;
    }
}