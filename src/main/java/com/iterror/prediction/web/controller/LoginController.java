package com.iterror.prediction.web.controller;

import com.iterror.prediction.common.util.MD5;
import com.iterror.prediction.common.util.constants.CommonConstants;
import com.iterror.prediction.common.view.BaseController;
import com.iterror.prediction.common.view.CreateImageCode;
import com.iterror.prediction.common.view.RespCode;
import com.iterror.prediction.common.view.RespEntity;
import com.iterror.prediction.domain.AdminUserDO;
import com.iterror.prediction.service.AdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("admin")
public class LoginController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/login.do")
    public String toLoginPage() {
        return "/admin/login";
    }

    /**
     * 生成验证码
     */
    @RequestMapping("/captcha.do")
    public void Captcha(HttpServletResponse response, HttpSession session) throws IOException {
        CreateImageCode vCode = new CreateImageCode(116, 36, 5, 10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    /**
     * 登录验证处理
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/loginCheck.do")
    @ResponseBody
    public RespEntity loginCheck(String username, String password, String code, HttpServletRequest request) {
        logger.info("登陆验证处理开始");
        long start = System.currentTimeMillis();
        try {
            //1.用户名不能为空
            if (StringUtils.isEmpty(username)) {
                logger.error("登陆验证失败,原因:用户名不能为空");
                return new RespEntity(RespCode.GLOBAL_LOGIN_NAME_NULL);
            }
            //2.密码不能为空
            if (StringUtils.isEmpty(password)) {
                logger.error("登陆验证失败,原因:密码不能为空");
                return new RespEntity(RespCode.GLOBAL_LOGIN_PASS_NULL);
            }
            //3.验证码不能为空
            if (StringUtils.isEmpty(code)) {
                logger.error("登陆验证失败,原因:验证码不能为空");
                return new RespEntity(RespCode.GLOBAL_CAPTCHA_NULL);
            }
            //4.验证码输入错误
            String sessionCode = (String) request.getSession().getAttribute("code");
            if (!code.toLowerCase().equals(sessionCode)) {
                logger.error("登陆验证失败,原因:验证码错误：code:" + code + ",sessionCode:" + sessionCode);
                return new RespEntity(RespCode.GLOBAL_CAPTCHA_ERROR);
            }
            AdminUserDO adminUserDO = adminUserService.getByName(username);
            if (adminUserDO == null) {
                return new RespEntity(RespCode.GLOBAL_LOGIN_FAIL);
            }
            if (!adminUserDO.getPassword().equals(MD5.md5Digest(password))) {
                return new RespEntity(RespCode.GLOBAL_LOGIN_FAIL);
            }

            request.getSession().setAttribute(CommonConstants.SESSION_KEY_LOGIN_NAME, adminUserDO);
            return new RespEntity();
        } catch (Exception e) {
            logger.error("登陆验证失败,原因:系统登陆异常", e);
            return new RespEntity(RespCode.GLOBAL_LOGIN_ERROR);
        } finally {
            logger.info("登陆验证处理结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }

    }

    /**
     * 用户退出
     */
    @RequestMapping("/logout.do")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "/admin/login";

    }
}
