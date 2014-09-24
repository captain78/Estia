package edu.uoa.estia.mobile.device;

import org.springframework.core.MethodParameter;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class DeviceHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		System.out.println("DeviceHandlerMethodArgumentResolver----------- 1 ------------");
		return Device.class.isAssignableFrom(parameter.getParameterType());
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest request,
			WebDataBinderFactory binderFactory) throws Exception {
		System.out.println("DeviceHandlerMethodArgumentResolver------------- 2 ------------");
		return DeviceUtils.getCurrentDevice(request);
	}

}