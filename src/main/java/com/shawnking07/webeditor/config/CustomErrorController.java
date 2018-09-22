package com.shawnking07.webeditor.config;

import com.shawnking07.webeditor.bean.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Map;

/**
 * Custom Error Handle Controller
 *
 * @author shawn
 */
@RestController
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";

    private final ErrorAttributes errorAttributes;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping
    public ErrorInfo doHandleError(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributesData = errorAttributes.getErrorAttributes(servletWebRequest, true);
        Integer status = (Integer) errorAttributesData.get("status");
        String path = (String) errorAttributesData.get("path");
        String message = (String) errorAttributesData.get("message");
        String error = (String) errorAttributesData.get("error");

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setTimestamp(Instant.now());
        errorInfo.setStatus(status);
        errorInfo.setMessage(message);
        errorInfo.setPath(path);
        errorInfo.setError(error);
        return errorInfo;
    }
}