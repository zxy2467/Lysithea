package com.zxy.lysithea.Controller;

import com.zxy.lysithea.Entity.User;
import com.zxy.lysithea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class UserController {
    //获取服务对象
    @Autowired
    UserService userService;

    /**
     *根据条件查询用户信息
     * @param kw 查询关键字即条件
     * @param model 模型对象 也是试图界面的上下文环境对象
     * @param pageable 分页信息对象 包含了分页需要的基本信息 如当前页码 每页需要的条数
     * @return字符串 代表了界面文件
     */
    @RequestMapping("/listusers")
    public String list(String kw, Model model, Pageable pageable){
        Page<User> userPage = userService.findAll(kw, pageable);//默认分页从0页开始（第一页)每页20条数据
        model.addAttribute("pages", userPage);
        return "listusers";//返回界面
    }

    /**
     * 编辑用户信息
     * @param uid
     * @param model
     * @return
     */
    @GetMapping({"/edituser", "/edituser/{uid}"})
    public String edit(@PathVariable(name="uid", required = false)Integer uid, Model model){
        User u = new User();
        if(uid!=null&&uid>0){
            u = userService.findById(uid);
        }
        model.addAttribute("user", u);
        return "edituser";
    }

    /**
     * 存储用户
     * @param user
     * @param result
     * @return
     */
    @GetMapping("/saveuser")
    public String save(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/edituser";
        }
        userService.save(user);
        return "redirect:/listusers";
    }

    /**
     *
     * @param uid
     * @return
     */
    @GetMapping("/delete/{uid}")
    public String delete(@PathVariable("uid")Integer uid){
        userService.deleteById(uid);
        return "redirect:/listusers";
    }

}
