package com.baidu.ueditor.upload;

import com.baidu.ueditor.define.State;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Uploader {
	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;
    private String siteId = null;
    private MultipartFile file;

	public Uploader(MultipartFile file,HttpServletRequest request, Map<String, Object> conf,String siteId) {
        this.file = file;
		this.request = request;
        this.siteId = siteId;
		this.conf = conf;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64"))) {
			state = Base64Uploader.save(this.request.getParameter(filedName),this.conf);
		} else {
			state = BinaryUploader.save(file,siteId,this.conf);
		}

		return state;
	}
}
