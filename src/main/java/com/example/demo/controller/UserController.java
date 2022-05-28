package com.example.demo.controller;
 
import com.example.demo.dao.mapper.WxappUserMapper;
import com.example.demo.model.WxappUser;
import com.example.demo.model.WxappUserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller 
public class UserController {
    @Resource
    private WxappUserMapper usersMapper;

    //添加页面
    @RequestMapping("add")
    public String add() {
        return "add";
    }

    //查找(用于查询)
    @RequestMapping("getUser")
    public String getUser(int id, Model model) throws Exception {
//        Users Users = usersMapper.(id);
//        model.addAttribute("Users", Users);
        return "userShow";
    }

    //添加
    @RequestMapping("addUser")
    public String addUser(WxappUser users, BindingResult bindingResult) throws Exception {
        boolean flag = usersMapper.insert(users) > 0;
        return "redirect:getUserList";
    }

    //删除
    @RequestMapping("deleteUser")
    public String deleteUser(WxappUser users) throws Exception {
        usersMapper.deleteByPrimaryKey(users.getId());
        return "redirect:getUserList";
    }

    //修改
    @RequestMapping("updateUser")
    public String updateUser(WxappUser Users) throws Exception {
        boolean flag = usersMapper.updateByPrimaryKeySelective(Users) > 0;
        return "redirect:getUserList";
    }

    //查找(用于修改)
    @RequestMapping("findUser")
    public String findUser(int id, Model model) throws Exception {
    	WxappUser Users = usersMapper.selectByPrimaryKey(id);
        model.addAttribute("Users", Users);
        return "modify";
    }

    //遍历
    @RequestMapping("/getUserList")
    public String getUserList(@RequestParam(value = "name",defaultValue = "") String name,
                           Model model, @RequestParam(value = "start", defaultValue = "1") int start,
                           @RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        WxappUserExample example =new WxappUserExample();
        example.setOrderByClause("id desc");
        example.setDistinct(false);
        example.createCriteria().andNicknameLike('%'+name+'%');
        List<WxappUser> userList = usersMapper.selectByExample(example);
        PageInfo<WxappUser> page = new PageInfo<>(userList);
        model.addAttribute("pages", page);
        model.addAttribute("name", name);
        return "index";
    }
}