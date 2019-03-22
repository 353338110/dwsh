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

import io.renren.modules.app.entity.GradeEntity;
import io.renren.modules.app.service.GradeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 年段表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@RestController
@RequestMapping("app/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:grade:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gradeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:grade:info")
    public R info(@PathVariable("id") String id){
		GradeEntity grade = gradeService.getById(id);

        return R.ok().put("grade", grade);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:grade:save")
    public R save(@RequestBody GradeEntity grade){
		gradeService.save(grade);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:grade:update")
    public R update(@RequestBody GradeEntity grade){
		gradeService.updateById(grade);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:grade:delete")
    public R delete(@RequestBody String[] ids){
		gradeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
