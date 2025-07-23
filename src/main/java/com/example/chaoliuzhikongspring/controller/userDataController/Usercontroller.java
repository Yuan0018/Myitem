package com.example.chaoliuzhikongspring.controller.userDataController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.UserInfo;
import com.example.chaoliuzhikongspring.entity.historyInfo;
import com.example.chaoliuzhikongspring.entity.loginRequest;
import com.example.chaoliuzhikongspring.entity.waterInfo;
import com.example.chaoliuzhikongspring.service.User.Userservice;
import com.example.chaoliuzhikongspring.service.historyOperation.historyService;
import com.example.chaoliuzhikongspring.service.waterData.waterDataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Usercontroller {

    @Autowired
    private Userservice userservice;
    @Autowired
    private waterDataservice waterDataservice;
    @Autowired
    private historyService historyService;
//  新增用户
    @PostMapping("/user")
    public Result adduser(@RequestBody UserInfo user){
//      设置随机10位数为用户ID
        long randomNum = (long) (Math.random() * 10000000000L);
        String id = String.format("%010d", randomNum);
        user.setUserId(id);
        boolean success = userservice.save(user);
//        用户表更新成功
        if(success){
//            更新用水量水表数据
            waterInfo NewwaterInfo = new waterInfo();
            NewwaterInfo.setUserId(id);
            boolean waterdata = waterDataservice.save(NewwaterInfo);
//            用户水表数据新增成功
            if(waterdata){
//            新增注册记录
                historyInfo addInfo = historyService.saveAddhistory(id);
                historyService.save(addInfo);
                return Result.success("用户新增成功,用水表新增成功,用户新增记录成功");
            }
            else return Result.error("用户新增成功,用水表新增失败");
        }else {
            return Result.error("注册失败");
        }
    }
//  根据ID修改用户数据  ID不能为空
    @PutMapping("/user/change/{adminID}")
    public Result updateuser(@RequestBody UserInfo user,@PathVariable String adminID){
        if(user.getUserId()==null){
            return Result.error("ID不能为空");
        }
        boolean success = userservice.updateById(user);
        if(success){
            UserInfo updateuser = userservice.mygetUser(user.getUserId());
            historyInfo addInfo = historyService.AdminchangeAddhistory(user.getUserId(),adminID);
            historyService.save(addInfo);
//           新增管理员修改记录
            return Result.success(updateuser);
        }
        else return Result.error();
    }
//    根据用户ID查询用户数据
    @GetMapping("/user/{user_id}")
    public Result getuser(@PathVariable String user_id) {
        UserInfo user = userservice.mygetUser(user_id);
        if (user != null) return Result.success(user);
        else return Result.error("没有查询到数据，当前请求用户ID：" + user_id );

    }
//    根据用户邮箱查询用户数据
    @GetMapping("/user/email/{user_email}")
    public Result getuserByemail(@PathVariable String user_email) {
        UserInfo user = userservice.getUserByemail(user_email);
        if (user != null) return Result.success(user);
        else return Result.error();
    }
//    用户数据分页查询
    @GetMapping ("/user/page")
    public Result getuserpage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        IPage<UserInfo> userPage = userservice.getUserPage(pageNum,pageSize);
        if (userPage != null && !userPage.getRecords().isEmpty()) return Result.success(userPage);
        else return Result.error("查询不到数据");
    }

//    用户登录
    @PostMapping("/user/login")
    public Result login(@RequestBody loginRequest LoginRequest){
        loginRequest myloginRequest  = userservice.login(LoginRequest);
        if(myloginRequest == null){
            return Result.error("404","error","查询错误,请检查账号或手机号");
        }
        if(!myloginRequest.getPermissions().equals(LoginRequest.getPermissions())) return Result.error("400","error","用户权限不匹配");
        if(myloginRequest.getUserPassword().equals(LoginRequest.getUserPassword())){
//            新增记录登录
            userservice.updateUserInfo(LoginRequest);
            historyInfo addInfo = historyService.loginAddhistory(userservice.getUserByemail(LoginRequest.getUserEmail()).getUserId(), LoginRequest.getPermissions());
            historyService.save(addInfo);
            return Result.success("200","success","登录成功");
        }else return Result.error("409","error","密码错误");
    }
//    用户删除
    @DeleteMapping("/user/{delAdminid}")
    public Result deleteuser(@RequestBody UserInfo deluser,@PathVariable String delAdminid){
        boolean del = userservice.removeById(deluser.getUserId());
        if(del) {
//            记录删除操作
            historyInfo addInfo =  historyService.AdmindelAddhistory(deluser.getUserId(),delAdminid);
            historyService.save(addInfo);
            return Result.success("删除成功");
        }
        else return Result.error("删除失败,无此用户存在");
    }
//    根据用户手机号查询用户数据
    @GetMapping("/user/phone/{userPhone}")
    public Result getuserphone(@PathVariable String userPhone){
        UserInfo user = userservice.getUserByPhone(userPhone);
        if (user != null) return Result.success(user);
        else return Result.error("查询失败");
    }
}
