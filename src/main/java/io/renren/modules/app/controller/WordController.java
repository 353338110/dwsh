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

import io.renren.modules.app.entity.WordEntity;
import io.renren.modules.app.service.WordService;
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
@RequestMapping("app/word")
public class WordController {
    @Autowired
    private WordService wordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:word:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:word:info")
    public R info(@PathVariable("id") String id){
		WordEntity word = wordService.getById(id);

        return R.ok().put("word", word);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:word:save")
    public R save(@RequestBody WordEntity word){
		wordService.save(word);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:word:update")
    public R update(@RequestBody WordEntity word){
		wordService.updateById(word);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:word:delete")
    public R delete(@RequestBody String[] ids){
		wordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
