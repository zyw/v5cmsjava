package com.baidu.ueditor.upload;

import com.baidu.ueditor.define.State;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Uploader {
	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;
    private MultipartFile file;

	public Uploader(MultipartFile file,HttpServletRequest request, Map<String, Object> conf) {
        this.file = file;
		this.request = request;
		this.conf = conf;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64"))) {
			state = Base64Uploader.save(this.request.getParameter(filedName),this.conf);
		} else {
			state = BinaryUploader.save(file,this.request, this.conf);
		}

		return state;
	}
}
