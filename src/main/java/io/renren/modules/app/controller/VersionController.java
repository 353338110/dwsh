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

import io.renren.modules.app.entity.VersionEntity;
import io.renren.modules.app.service.VersionService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 版本表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@RestController
@RequestMapping("app/version")
public class VersionController {
    @Autowired
    private VersionService versionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:version:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = versionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:version:info")
    public R info(@PathVariable("id") String id){
		VersionEntity version = versionService.getById(id);

        return R.ok().put("version", version);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:version:save")
    public R save(@RequestBody VersionEntity version){
		versionService.save(version);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:version:update")
    public R update(@RequestBody VersionEntity version){
		versionService.updateById(version);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:version:delete")
    public R delete(@RequestBody String[] ids){
		versionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
