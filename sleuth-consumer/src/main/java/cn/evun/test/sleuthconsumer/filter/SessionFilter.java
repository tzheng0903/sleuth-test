package cn.evun.test.sleuthconsumer.filter;

import brave.propagation.ExtraFieldPropagation;
import org.springframework.cloud.sleuth.instrument.web.SleuthWebProperties;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@Component
@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER)
public class SessionFilter extends GenericFilterBean {

    private Pattern pattern = Pattern.compile(SleuthWebProperties.DEFAULT_SKIP_PATTERN);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)){
            throw new RuntimeException("unsupport request...........");
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        if(!pattern.matcher(httpServletRequest.getRequestURI()).matches()){
            ExtraFieldPropagation.set("SessionId",httpServletRequest.getSession().getId());
        }
        chain.doFilter(request,response);
    }
}
