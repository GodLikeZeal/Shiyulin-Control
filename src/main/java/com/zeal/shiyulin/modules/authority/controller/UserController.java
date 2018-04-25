/** 
 * Copyright ® 2016-2017 zeal  1332949188@qq.com.
 * All right reserved. 
 */
package com.zeal.shiyulin.modules.authority.controller;


import com.wordnik.swagger.annotations.ApiOperation;
import com.zeal.shiyulin.common.beans.Result;
import com.zeal.shiyulin.paginate.PaginateDataResponse;
import com.zeal.shiyulin.modules.authority.entity.UserEntity;
import com.zeal.shiyulin.modules.authority.service.UserService;
import com.zeal.shiyulin.exception.ExceptionUtils;
import com.zeal.shiyulin.exception.ZealException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * userRest服务接口
 *
 * @author zeal
 * @date 2017-11-05 16:39:27
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 通过ID查找对象
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "通过ID查找对象[对象]", response=UserEntity.class, notes = "通过ID查找对象")
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id,HttpServletRequest request,
                           HttpServletResponse response){
        try{
            return userService.findById(id);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class查找对象
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "通过Class查找对象[List]", response=UserEntity.class, notes = "通过Class查找对象")
    @RequestMapping(value="/findByClass",method = RequestMethod.POST)
    public Result findByClass(@RequestBody UserEntity userEntity,
                              HttpServletRequest request,HttpServletResponse response){
        try{
            return userService.findByClass(userEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class分页查找对象
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "通过Class分页查找对象[分页]", response=UserEntity.class, notes = "通过Class分页查找对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.POST)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        @RequestBody UserEntity userEntity,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            if(allRequestParam.containsKey("size")){
                userEntity.setSize(Integer.valueOf(allRequestParam.get("size")));
            }
            if(allRequestParam.containsKey("start")){
                userEntity.setStart(Integer.valueOf(allRequestParam.get("start")));
            }
            if(allRequestParam.containsKey("order")){
                userEntity.setOrder(String.valueOf(allRequestParam.get("order")));
            }
            if(allRequestParam.containsKey("sort")){
                userEntity.setSort(String.valueOf(allRequestParam.get("sort")));
            }
            return userService.listPage(userEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过url参数查找分页对象
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "通过url参数查找分页对象[分页]", response=UserEntity.class, notes = "通过url参数查找分页对象")
    @RequestMapping(value="/findByClassWithPaginate",method = RequestMethod.GET)
    public PaginateDataResponse findByClassWithPaginate(@RequestParam Map<String,String> allRequestParam,
                                                        HttpServletRequest request, HttpServletResponse response){

        try{
            UserEntity userEntity = new UserEntity(allRequestParam);
            return userService.listPage(userEntity);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 新增记录
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "新增记录[对象]", response=UserEntity.class, notes = "新增记录")
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public Result insert(@RequestBody UserEntity userEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return  userService.insert(userEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 更新数据
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "更新数据[对象]", response=UserEntity.class, notes = "更新数据")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody UserEntity userEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return userService.update(userEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过Class删除信息
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "通过Class删除信息[int]", response=Integer.class, notes = "通过Class删除信息")
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody UserEntity userEntity,HttpServletRequest request,
                         HttpServletResponse response){
        try{
            return userService.delete(userEntity);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }

    /**
     * 通过ID删除信息
     * @author zeal
     * @date 2017-12-08 15:57:29
     */
    @ApiOperation(value = "通过ID删除信息[int]", response=Integer.class, notes = "通过ID删除信息")
    @RequestMapping(value="/deleteById/{id}",method = RequestMethod.POST)
    public Result deleteById(@PathVariable String id,HttpServletRequest request,
                             HttpServletResponse response){
        try{
            return userService.deleteById(id);
        }
        catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
    /**
    * @auther Zeal
    * @description 用户登录
    * @date 2017/11/5 16:52
    */
    @RequestMapping(value="/userLogin")
    public void  userLogin(@RequestParam Map<String,String> allRequestParam,HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        String u=request.getParameter("uname");
        String username = allRequestParam.get("uname"); //获取用户名
        String password = allRequestParam.get("pword"); //获取密码
        try{
            if (username!=null&&password!=null) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                token.setRememberMe(true);
                Subject subject = SecurityUtils.getSubject();
                //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
                        //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
                        //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
                System.out.println("对用户[" + username + "]进行登录验证..验证开始");
                subject.login(token);
                System.out.println("对用户[" + username + "]进行登录验证..验证通过");
                //验证是否登录成功
                if (subject.isAuthenticated()) {
                    System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数 初始化操作)");
                    response.getWriter().write("yes");
                } else {
                    token.clear();
                }
            }else {
                request.setAttribute("message_login", "用户名或密码不能为空");
            }
        }catch(UnknownAccountException uae){
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            //request.setAttribute("message_login", "未知账户");
            response.getWriter().write("该用户不存在");
        }catch(IncorrectCredentialsException ice){
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            //request.setAttribute("message_login", "密码不正确");
            response.getWriter().write("密码不正确");
        }catch(LockedAccountException lae){
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            //request.setAttribute("message_login", "账户已锁定");
            response.getWriter().write("账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            //request.setAttribute("message_login", "用户名或密码错误次数过多");
            response.getWriter().write("用户名或密码错误次数超过5次，请稍后登录");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            //request.setAttribute("message_login", "用户名或密码不正确");
            response.getWriter().write("用户名或密码不正确");
        } catch(Exception er) {
            ExceptionUtils.LoadLog(er);
            throw new ZealException(ExceptionUtils.DealErrorMsg(er));
        }
    }
}