package com.aries.cloud.common.mybatisplus.api;

import com.aries.scloud.common.core.result.Pr;
import com.aries.scloud.common.core.result.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IApi<T> {
    @PostMapping("/saveBatch")
    R<Boolean> saveBatch(@RequestBody List<T> list);

    @PostMapping("/save")
    R<Boolean> save(@RequestBody T t);

    @PostMapping("/removeById")
    R<Boolean> removeById(@RequestParam("id") String id);

    @PostMapping("/updateById")
    R<Boolean> updateById(@RequestBody T t);

    @PostMapping("/saveOrUpdate")
    public R<Boolean> saveOrUpdate(T t);

    @PostMapping("/list")
    R<List<T>> list(@RequestBody T t);

    @PostMapping("/listAll")
    R<List<T>> listAll();

    @PostMapping("/page")
    R<Pr<T>> page(@RequestBody T t, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize);

    @PostMapping("/getById")
    R<T> getById(@RequestParam("id") String id);

    @PostMapping("/listByIds")
    R<List<T>> listByIds(@RequestBody List<String> idList);
}
