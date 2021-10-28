package com.application.server.utils;

import com.application.server.constant.ContextConstants;

public class ContextUtils {

	public static String getImagePath(String context, String imageName) {
		return ContextConstants.IMAGE_CONTEXT + context + imageName;
	}

}
