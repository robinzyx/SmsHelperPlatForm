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

import com.ginwavelz.sms.service.user.UserService;
import com.ginwavelz.sms.web.formbean.user.UserRegForm;
@Controller("/user/regUI")
public class UserRegUIAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return mapping.findForward("success");
	}
	

}
