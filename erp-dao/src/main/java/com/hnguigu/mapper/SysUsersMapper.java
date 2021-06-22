package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.SysUsers;
import org.apache.ibatis.annotations.Select;

public interface SysUsersMapper extends BaseMapper<SysUsers> {
    /**
     * 登陆的方法
     * @param sysUsers 登录所需账号，密码
     * @return
     * user skl
     */
    @Select("select * from sys_users where LOGIN_ID=#{loginId} and password=#{password} ")
    public SysUsers login(SysUsers sysUsers);
}
