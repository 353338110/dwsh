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

import io.renren.modules.app.entity.CourseEntity;
import io.renren.modules.app.service.CourseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 课程表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:23:50
 */
@RestController
@RequestMapping("app/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:course:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:course:info")
    public R info(@PathVariable("id") String id){
		CourseEntity course = courseService.getById(id);

        return R.ok().put("course", course);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:course:save")
    public R save(@RequestBody CourseEntity course){
		courseService.save(course);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:course:update")
    public R update(@RequestBody CourseEntity course){
		courseService.updateById(course);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:course:delete")
    public R delete(@RequestBody String[] ids){
		courseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
