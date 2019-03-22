package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.UserCourseEntity;
import io.renren.modules.app.service.UserCourseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学生课程表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@RestController
@RequestMapping("app/usercourse")
public class UserCourseController {
    @Autowired
    private UserCourseService userCourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:usercourse:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userCourseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:usercourse:info")
    public R info(@PathVariable("id") String id){
		UserCourseEntity userCourse = userCourseService.getById(id);

        return R.ok().put("userCourse", userCourse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:usercourse:save")
    public R save(@RequestBody UserCourseEntity userCourse){
		userCourseService.save(userCourse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:usercourse:update")
    public R update(@RequestBody UserCourseEntity userCourse){
		userCourseService.updateById(userCourse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:usercourse:delete")
    public R delete(@RequestBody String[] ids){
		userCourseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
