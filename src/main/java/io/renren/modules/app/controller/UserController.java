package io.renren.modules.app.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.config.ConfigUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * 用户表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-20 23:53:45
 */
@RestController
@RequestMapping("app/user")
@Api("APP用户")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;
    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("app:user:list")
    @ApiOperation("用户列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    @RequiresPermissions("app:user:info")
    @ApiOperation("用户信息")
    public R info(@PathVariable("id") String id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("app:user:save")
    @ApiOperation("保存用户")
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    //@RequiresPermissions("app:user:update")
    @ApiOperation("更新用户")
    public R update(@RequestBody UserEntity user){
        if (null==user.getId()){
            return R.error("用户id不能为空");
        }
        user.setUpdateTime(new Date());
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("app:user:delete")
    @ApiOperation("删除用户")
    public R delete(@RequestBody String[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody UserEntity user){
        if (null==user.getUsername() || "".equals(user.getUsername())){
            return R.error("username不能为空");
        }
        if (null==user.getMobile() || "".equals(user.getMobile())){
            return R.error("mobile不能为空");
        }

        UserEntity tempUser = userService.queryByMobile(user.getMobile());
        if (null!=tempUser){
            return R.error("手机号已经被注册");
        }
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        if (ConfigUtils.selfSetDate){
            Date date = new Date();
            user.setLastLogin(date);
            user.setCreateTime(date);
            user.setUpdateTime(date);
        }
        user.setLoginAcount(0);
        userService.save(user);
        return R.ok();
    }

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);
        //用户登录
        UserEntity user = userService.login(form);
        //登录次数加一
        user.setLoginAcount(user.getLoginAcount()+1);
        //保存当前登录时间
        if (ConfigUtils.selfSetDate){
            Date date = new Date();
            user.setLastLogin(date);
        }
        userService.updateById(user);
        //生成token
        String token = jwtUtils.generateToken(user.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        return R.ok(map);
    }

}
