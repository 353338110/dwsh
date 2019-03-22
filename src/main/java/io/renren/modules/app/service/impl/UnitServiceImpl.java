package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.UnitDao;
import io.renren.modules.app.entity.UnitEntity;
import io.renren.modules.app.service.UnitService;


@Service("unitService")
public class UnitServiceImpl extends ServiceImpl<UnitDao, UnitEntity> implements UnitService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UnitEntity> page = this.page(
                new Query<UnitEntity>().getPage(params),
                new QueryWrapper<UnitEntity>()
        );

        return new PageUtils(page);
    }

}