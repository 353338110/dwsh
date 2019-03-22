package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.VersionDao;
import io.renren.modules.app.entity.VersionEntity;
import io.renren.modules.app.service.VersionService;


@Service("versionService")
public class VersionServiceImpl extends ServiceImpl<VersionDao, VersionEntity> implements VersionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VersionEntity> page = this.page(
                new Query<VersionEntity>().getPage(params),
                new QueryWrapper<VersionEntity>()
        );

        return new PageUtils(page);
    }

}