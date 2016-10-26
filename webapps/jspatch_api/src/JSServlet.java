
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSServlet extends HttpServlet{

	private static final long serialVersionUID = -2910730214903663112L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/javascript; charset=utf-8");
		String uri = req.getServletPath();
		
		JsFile jsFile = null;
		try {
			jsFile = JSReader.getJsPatch(uri);
		} catch (Exception e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
        
		String version = req.getParameter("v");
		PrintWriter out = resp.getWriter();
        	//将JS文件的MD5值作为文件的版本号
		resp.setHeader("version", jsFile.getMd5());
        
        	if (version != null && version.trim().length() > 0) {
			//比较将要下发的热更新JS脚本文件MD5值 与 客户端的version(上一次下发成功的热更新JS脚本的MD5值)，
			//如果这两个字符串一样表示JS文件没有修改
			if (jsFile.getMd5().equalsIgnoreCase(version)) {
				out.print("");
				return;
			}
		}
        
		String content = jsFile.getBody();
        	String pkKey = getPK(uri);
        	String pk = KeysUtils.getPK(pkKey);
        
		if (pk != null) {
			try {
                		//对JS脚本内容进行DES加密
                		content = Des3Util.encode(content, pk);
			} catch (Exception e) {
				e.printStackTrace();
				content = "";
			}
		}
		out.println(content);
	}
	
	private String getPK(String uri) {
		int in = uri.indexOf('/', 1);
		if (in <= 0) {
			return "ROOT";
		}
		return uri.substring(1, in);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
