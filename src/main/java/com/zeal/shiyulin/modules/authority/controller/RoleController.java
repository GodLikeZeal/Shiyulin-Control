/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.zeal.shiyulin.common.beans.Result;
import com.zeal.shiyulin.exception.ExceptionUtils;
import com.zeal.shiyulin.exception.ZealException;
import com.zeal.shiyulin.modules.authority.entity.RoleEntity;
import com.zeal.shiyulin.modules.authority.service.RoleService;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * roleRest服务接口
 *
 * @author zeal
 * @date 2017-12-07 15:55:14
 */
@RestController
@RequestMapping(value="role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 通过ID查找对象
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "通过ID查找对象[对象]", response=RoleEntity.class, notes = "通过ID查找对象")
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id, HttpServletRequest request,
                           HttpServletResponse response){
        try{
            return roleService.findById(id);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class查找对象
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "通过Class查找对象[List]", response=RoleEntity.class, notes = "通过Class查找对象")
    @RequestMapping(value="/findByClass",method = RequestMethod.POST)
    public Result findByClass(@RequestBody RoleEntity roleEntity,
                              HttpServletRequest request, HttpServletResponse response){
        try{
            return roleService.findByClass(roleEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class分页查找对象
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "通过Class分页查找对象[分页]", response=RoleEntity.class, notes = "通过Class分页查找对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.POST)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        @RequestBody RoleEntity roleEntity,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            if(allRequestParam.containsKey("size")){
                roleEntity.setSize(Integer.valueOf(allRequestParam.get("size")));
            }
            if(allRequestParam.containsKey("start")){
                roleEntity.setStart(Integer.valueOf(allRequestParam.get("start")));
            }
            if(allRequestParam.containsKey("order")){
                roleEntity.setOrder(String.valueOf(allRequestParam.get("order")));
            }
            if(allRequestParam.containsKey("sort")){
                roleEntity.setSort(String.valueOf(allRequestParam.get("sort")));
            }
            return roleService.listPage(roleEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过url参数查找分页对象
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "通过url参数查找分页对象[分页]", response=RoleEntity.class, notes = "通过url参数查找分页对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.GET)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            RoleEntity roleEntity = new RoleEntity(allRequestParam);
            return roleService.listPage(roleEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 新增记录
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "新增记录[对象]", response=RoleEntity.class, notes = "新增记录")
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody RoleEntity roleEntity, HttpServletRequest request,
                         HttpServletResponse response){
        try{
              return  roleService.insert(roleEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 更新数据
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "更新数据[对象]", response=RoleEntity.class, notes = "更新数据")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody RoleEntity roleEntity, HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return roleService.update(roleEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class删除信息
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "通过Class删除信息[int]", response=Integer.class, notes = "通过Class删除信息")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody RoleEntity roleEntity, HttpServletRequest request,
                         HttpServletResponse response){
        try{
             return roleService.delete(roleEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过ID删除信息
     * @author zeal
     * @date 2017-12-07 15:55:14
     */
    @ApiOperation(value = "通过ID删除信息[int]", response=Integer.class, notes = "通过ID删除信息")
    @RequestMapping(value="/deleteById/{id}",method = RequestMethod.POST)
    public Result deleteById(@PathVariable String id, HttpServletRequest request,
                             HttpServletResponse response){
        try{
            return roleService.deleteById(id);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
}