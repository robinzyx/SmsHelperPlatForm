package com.ginwavelz.sms.web.action.user;

import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.PageView;
import com.ginwavelz.sms.bean.QueryResult;
import com.ginwavelz.sms.bean.user.User;
import com.ginwavelz.sms.service.user.UserService;
import com.ginwavelz.sms.web.formbean.user.UserListForm;
@Controller("/manag/user/list")
public class UserListAction extends Action {
	@Resource UserService userService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserListForm userListForm =(UserListForm) form;
		PageView<User> pageView= new PageView<User>(12, userListForm.getPage());
		LinkedHashMap<String, String> orderby= new LinkedHashMap<String, String>();
		orderby.put("regTime", "desc");
		pageView.setQueryResult(userService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), orderby));
		request.setAttribute("pageView", pageView);
		System.out.print(pageView.getRecords());
		return mapping.findForward("list");
	}
	
	

}
