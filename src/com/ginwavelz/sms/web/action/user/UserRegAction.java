package com.ginwavelz.sms.web.action.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.chain.commands.servlet.ValidateActionForm;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.user.User;
import com.ginwavelz.sms.service.user.UserService;
import com.ginwavelz.sms.web.formbean.user.UserRegForm;

@Controller("/user/reg")
public class UserRegAction extends DispatchAction{
	@Resource(name="userServiceBean")
	UserService userService;

	/**
	 * ��ʾע�����
	 */
	public ActionForward regUI(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		return actionMapping.findForward("regUI");
	}

	/**
	 * �û�ע��
	 */
	public ActionForward reg(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		UserRegForm userRegForm = (UserRegForm) actionForm;
		if (userService.exsit(userRegForm.getUsername().trim())) {
			httpServletRequest.setAttribute("error", "���û��Ѵ��ڣ�");
			return actionMapping.findForward("regUI");
		} else {
			User user = new User();
			user.setUsername(userRegForm.getUsername().trim());
			user.setPassword(userRegForm.getPassword().trim());
			user.setEmail(userRegForm.getEmail().trim());
			userService.save(user);
			httpServletRequest.setAttribute("message", "�û�ע��ɹ���");
			httpServletRequest.setAttribute("urladdress", "/");
			return actionMapping.findForward("success");
		}
	}


	/**
	 * ����û����Ƿ����
	 */
	public ActionForward isUserExsit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		UserRegForm userRegForm = (UserRegForm) actionForm;
		httpServletRequest.setAttribute("exsit",
				userService.exsit(userRegForm.getUsername().trim()));
		return actionMapping.findForward("checkuser");
	}

}
