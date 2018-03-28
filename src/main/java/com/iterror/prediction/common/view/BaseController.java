package com.iterror.prediction.common.view;

import com.iterror.prediction.common.dao.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tony.yan on 2017/10/30.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
