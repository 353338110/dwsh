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

import io.renren.modules.app.entity.UnitEntity;
import io.renren.modules.app.service.UnitService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 单元表
 *
 * @author csh
 * @email csh@gmail.com
 * @date 2019-03-22 17:16:09
 */
@RestController
@RequestMapping("app/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:unit:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = unitService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:unit:info")
    public R info(@PathVariable("id") String id){
		UnitEntity unit = unitService.getById(id);

        return R.ok().put("unit", unit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:unit:save")
    public R save(@RequestBody UnitEntity unit){
		unitService.save(unit);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:unit:update")
    public R update(@RequestBody UnitEntity unit){
		unitService.updateById(unit);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:unit:delete")
    public R delete(@RequestBody String[] ids){
		unitService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
