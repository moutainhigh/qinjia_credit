package com.marvels.interceptor;

import com.marvels.common.util.CommonUtil;
import com.marvels.common.util.EncryptUtil;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 玖富拦截器
 * @author houyl
 * @date 2019/10/11 18:08
 */
@Component
public class JfInterceptor implements HandlerInterceptor {
    /** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();

    /**
     * 在执行controller方法之前进行请求处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 签名
        String code = request.getHeader("code");
        String time = request.getHeader("time");
        String sign = request.getHeader("sign");
        if(CommonUtil.validEmpty(code,time,sign)) {
            // 必填参数不能为空
            log.error("非正常请求！");
            return false;
        }

        // 验签
        String jfCode = PropertiesLoadUtil.getPropertiesValue("jiufu.code", "forms-openapi.properties");
        String jfToken = PropertiesLoadUtil.getPropertiesValue("jiufu.token", "forms-openapi.properties");
        String mySign = EncryptUtil.MD5Encode(jfCode + time + jfToken);
        if(sign.equals(mySign)) {
            request.getRequestDispatcher(request.getHeader("intfCode")).forward(request,response);
            // 验签通过
            return true;
        }else {
            return false;
        }
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}
