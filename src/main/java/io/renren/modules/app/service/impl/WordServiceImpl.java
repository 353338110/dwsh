package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.WordDao;
import io.renren.modules.app.entity.WordEntity;
import io.renren.modules.app.service.WordService;


@Service("wordService")
public class WordServiceImpl extends ServiceImpl<WordDao, WordEntity> implements WordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WordEntity> page = this.page(
                new Query<WordEntity>().getPage(params),
                new QueryWrapper<WordEntity>()
        );

        return new PageUtils(page);
    }

}