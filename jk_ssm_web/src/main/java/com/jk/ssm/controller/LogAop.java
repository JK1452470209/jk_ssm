package com.jk.ssm.controller;

import com.jk.ssm.domain.SysLog;
import com.jk.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @outhor Mr.JK
 * @create 2020-05-05  9:19
 */
@Controller
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//开始的时间
    private Class clazz;//访问的类
    private Method method;//访问的方法



    //前置通知  主要是获取开始时间，执行的类是哪一个，执行的是哪个方法
    @Before("execution(* com.jk.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = jp.getTarget().getClass();//具体要访问的类
        String methodName = jp.getSignature().getName();//获取访问方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }


    }

    //后置通知
    @After("execution(* com.jk.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        Long time = new Date().getTime() - visitTime.getTime();

        String url = "";
        if (clazz.getName() == "com.jk.ssm.controller.SysLogController"){
            return;
        }

        //获取url
        if (clazz != null && method != null && clazz != LogAop.class){

            //获取类上的注解
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);

            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();

                //2.获取方法上的注解
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];


                    //获取访问的ip
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用
                    sysLogService.save(sysLog);
                }
            }
        }



    }

}
