package ru.demi.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.demi.webapp.dao.IUserDao;
import ru.demi.webapp.dao.UserDao;
import ru.demi.webapp.dao.UserFilterDao;
import ru.demi.webapp.entity.User;
import ru.demi.webapp.utils.Pager;

import java.io.IOException;
import java.util.List;

/**
 * Created by demi
 * on 06.08.15.
 */
@Controller
@RequestMapping("/")
public class UserController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootAction()
    {
        return "forward:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexAction(@RequestParam(value = "page", defaultValue = "") String page,
                              @RequestParam(value = "name", defaultValue = "") String name,
                              @RequestParam(value = "age", defaultValue = "") String age,
                              @RequestParam(value = "isAdmin", defaultValue = "") String isAdmin,
                              Model model) throws IOException
    {
        Pager pager = new Pager(page);
        UserFilterDao userFilterDao = new UserFilterDao(name, age, isAdmin);
        userFilterDao.setLimit(pager.getLimit());
        int count = userFilterDao.getCount();
        String paramsString = userFilterDao.getParamsString();
        String pagination = pager.buildHtml(count, paramsString);
        List<User> users = userFilterDao.findBy();
        model.addAttribute("users", users);
        model.addAttribute("pagination", pagination);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("isAdmin", isAdmin);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@ModelAttribute("user") User user, Model model) throws IOException
    {
        try {
            UserDao userDao = new UserDao();
            userDao.createUser(user.getName(), user.getAge(), user.isAdmin());
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editAction(@ModelAttribute("user") User user, Model model) throws IOException
    {
        try {
            UserDao userDao = new UserDao();
            userDao.updateUser(user.getId(), user.getName(), user.getAge(), user.isAdmin());
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String deleteAction(@PathVariable("id") Integer id, Model model) throws IOException
    {
        IUserDao userDao = new UserDao();
        userDao.deleteUser(id);
        return "success";
    }
}
