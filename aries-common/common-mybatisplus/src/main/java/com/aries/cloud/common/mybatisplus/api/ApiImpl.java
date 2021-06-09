package com.aries.cloud.common.mybatisplus.api;

import com.aries.cloud.common.mybatisplus.entity.BaseEntity;
import com.aries.scloud.common.core.result.Pr;
import com.aries.scloud.common.core.result.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApiImpl<T extends BaseEntity> implements IApi<T> {
    @Autowired
    IService<T> service;

    @Override
    public R<Boolean> saveBatch(List<T> list) {
        if (list == null || list.size() == 0) {
            return R.fail("数据不存在");
        }
        return R.success(service.saveBatch(list));
    }

    @Override
    public R<Boolean> save(T t) {
        return R.success(service.save(t));
    }

    @Override
    public R<Boolean> removeById(String id) {
        if (StringUtils.isBlank(id)) {
            return R.fail("数据不存在");
        }
        return service.removeById(id) ? R.success() : R.fail("删除失败");
    }

    @Override
    public R<Boolean> updateById(T t) {
        boolean update = service.updateById(t);
        return update ? R.success(update) : R.fail("修改失败");
    }

    @Override
    public R<Boolean> saveOrUpdate(T t) {
        boolean update = service.saveOrUpdate(t);
        return update ? R.success(update) : R.fail("修改失败");
    }

    @Override
    public R<List<T>> list(T sysUserAdmin) {
        return R.success(service.list(new QueryWrapper<>(sysUserAdmin)));
    }

    @Override
    public R<List<T>> listAll() {
        return R.success(service.list());
    }

    @Override
    public R<Pr<T>> page(T sysUserAdmin, Integer page, Integer pageSize) {
        Page<T> result = service.page(new Page<>(page, pageSize), new QueryWrapper<>(sysUserAdmin));
        Pr<T> pr = new Pr<>(result.getTotal(), result.getRecords());
        return R.success(pr);
    }

    @Override
    public R<T> getById(String id) {
        return R.success(service.getById(id));
    }

    @Override
    public R<List<T>> listByIds(List<String> idList) {
        if (idList == null || idList.size() == 0) {
            return R.fail("idList不能为空");
        }
        QueryWrapper q = new QueryWrapper();
        q.in("id", idList);
        return R.success(service.list(q));
    }
}
