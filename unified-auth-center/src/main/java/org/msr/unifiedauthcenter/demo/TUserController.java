package org.msr.unifiedauthcenter.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2022-06-15 22:03
 **/
@RestController
@RequestMapping("user")
public class TUserController {

    @Autowired
    private TUserService userService;

    @GetMapping("list")
    public List<TUser> list() {
        return userService.getUsers();
    }
}
