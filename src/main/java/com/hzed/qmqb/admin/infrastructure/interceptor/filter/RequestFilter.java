package com.hzed.qmqb.admin.infrastructure.interceptor.filter;

import com.hzed.qmqb.admin.infrastructure.utils.MdcUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Locale;

/**
 * 过滤器，用户替换request
 *
 * @author guichang
 */
@Slf4j
@WebFilter(urlPatterns = {"/test/**"})
@Component
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            MdcUtil.clear();
            // 日志加入trace
            MdcUtil.putTrace();
            // local替换成请求头中的
            /*Locale locale = LocaleEnum.getLocale(RequestUtil.getGlobalHead().getI18n());
            Locale.setDefault(locale);*/

            Locale locale = Locale.getDefault();
            RequestWrapper request = new RequestWrapper((HttpServletRequest) servletRequest, locale);
            request.setAttribute("body", request.getBody());
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    @Data
    class RequestWrapper extends HttpServletRequestWrapper {
        private final String body;

        public RequestWrapper(HttpServletRequest request, Locale locale) throws IOException {
            super(request);

            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = request.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }
            bufferedReader.close();
            // 替换换行符和回车符
            body = stringBuilder.toString().replaceAll("\n|\t", "");
        }

        @Override
        public ServletInputStream getInputStream() {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
            ServletInputStream servletInputStream = new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return false;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener listener) {

                }

                @Override
                public int read() {
                    return byteArrayInputStream.read();
                }
            };
            return servletInputStream;
        }

        @Override
        public BufferedReader getReader() {
            return new BufferedReader(new InputStreamReader(this.getInputStream()));
        }

    }
}