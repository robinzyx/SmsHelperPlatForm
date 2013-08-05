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
import com.ginwavelz.sms.web.formbean.user.UserLogonForm;

@Controller("/user/logon")
public class UserLogonAction extends DispatchAction {
	@Resource(name="userServiceBean") 
	UserService userService;

	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 System.out.print("im"+mapping.getParameter());
			UserLogonForm userLogonForm =(UserLogonForm)form;
			if(userLogonForm.getUsername()!=null&&!"".equals(userLogonForm.getUsername().trim())
					&& userLogonForm.getPassword()!=null&&!"".equals(userLogonForm.getPassword().trim())){
				if(userService.validate(userLogonForm.getUsername().trim(), userLogonForm.getPassword().trim())){
					request.getSession().setAttribute("user", userService.find(userLogonForm.getUsername().trim()));
					request.setAttribute("message", "登陆成功");
					request.setAttribute("urladdress", "/manag/holiday/holidayListUI.do");
					return mapping.findForward("message");
				}else{
					request.setAttribute("error", "登陆失败！");
				}
				
			}
			
			return mapping.findForward("failure");
	}

	
//	public ActionForward logon(ActionMapping mapping, ValidateActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		
//		 System.out.print(mapping.getParameter());
//		UserLogonForm userLogonForm =(UserLogonForm)form;
//		if(userLogonForm.getUsername()!=null&&!"".equals(userLogonForm.getUsername().trim())
//				&& userLogonForm.getPassword()!=null&&!"".equals(userLogonForm.getPassword().trim())){
//			if(userService.validate(userLogonForm.getUsername().trim(), userLogonForm.getPassword().trim())){
//				request.getSession().setAttribute("user", userService.find(userLogonForm.getUsername().trim()));
//				request.setAttribute("message", "�û����½�ɹ�");
//				request.setAttribute("urladdress", "/");
//				return mapping.findForward("message");
//			}else{
//				request.setAttribute("error", "�û����������");
//			}
//			
//		}
//		
//		return mapping.findForward("failure");
//	}
	

}
