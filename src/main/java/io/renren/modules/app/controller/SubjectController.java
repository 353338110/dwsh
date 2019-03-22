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

import io.renren.modules.app.entity.SubjectEntity;
import io.renren.modules.app.service.SubjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学科表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@RestController
@RequestMapping("app/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:subject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = subjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:subject:info")
    public R info(@PathVariable("id") String id){
		SubjectEntity subject = subjectService.getById(id);

        return R.ok().put("subject", subject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:subject:save")
    public R save(@RequestBody SubjectEntity subject){
		subjectService.save(subject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:subject:update")
    public R update(@RequestBody SubjectEntity subject){
		subjectService.updateById(subject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:subject:delete")
    public R delete(@RequestBody String[] ids){
		subjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
