package com.cusft.lsl.meeting.browser;


import com.cusft.lsl.meeting.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//日志包
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Long
 * @Date 2020/4/21 18:30
 */
@Component//编程spring里面的一个bean
public class MyUserDetailsService implements UserDetailsService {

    //自动注入密码
    @Autowired
    private PasswordEncoder passwordEncoder;

    //注入EmployeeMapper,查询密码进行校验
    @Autowired
    private EmployeeMapper employeeMapper;
    //使用数据库进行查询出密码
//    @Autowired

    private Logger logger= (Logger) LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("登录用户名："+username);

        //根剧用户名，查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        String emp_pwd =employeeMapper.getEmpPassword(username);
//        String password =passwordEncoder.encode("abc123");

        logger.info("数据库密码是："+emp_pwd);
        return new User(username,emp_pwd,
                true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
