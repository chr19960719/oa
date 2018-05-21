package xcl.oa.test.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;

public class TestAction extends ActionSupport{
	
	@Autowired
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	public String json() {
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        JSONObject json = new JSONObject();
        List<Dept> list = deptService.findAll();
        json.put("list", list);
        try {
            response.getWriter().print(json.toString());
            response.getWriter().close();
        } catch (Exception e) {
            //log.fatal(e);
        }
		return NONE;
	}
}
