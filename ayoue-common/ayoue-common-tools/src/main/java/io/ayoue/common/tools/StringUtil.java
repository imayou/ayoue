package io.ayoue.common.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 正则表达式去掉xml空节点
	 * @param xml
	 * @return
	 */
	public static String processXmlBlankNodes(String xml) {
		Pattern p = Pattern.compile("<([^>]+)>\\s*</\\1>");
		while (p.matcher(xml).find()) {
			xml = xml.replaceAll("<([^>]+)>\\s*</\\1>", "");
			p.matcher(xml);
		}
		return xml;
	}

	/**
	 * 取xml节点
	 * @param data
	 * @param para
	 * @return
	 */
	public static String getParameter(String data, String para) {
		StringBuffer result = new StringBuffer();
		StringBuffer reStr = new StringBuffer();
		reStr.append("<");
		reStr.append(para);
		reStr.append(".*?>");
		reStr.append("(.*?)");
		reStr.append("</");
		reStr.append(para);
		reStr.append(">");
		Pattern pattern = Pattern.compile(reStr.toString(),Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(data);
		if (matcher.find()) {
			result.append("<");
			result.append(para);
			result.append(">");
			result.append(matcher.group(1));
			result.append("</");
			result.append(para);
			result.append(">");
		}
		return result.toString();
	}
	
	/**
	 * 取节点
	 * @param data
	 * @param para
	 * @param is 是否包含自己
	 * @return
	 */
	public static String getParameter(String data, String para,Boolean is) {
		if(!is){
			return getParameter(data, para);
		}else{
			StringBuffer result = new StringBuffer();
			StringBuffer reStr = new StringBuffer();
			reStr.append("<");
			reStr.append(para);
			reStr.append(".*?>");
			reStr.append("(.*?)");
			reStr.append("</");
			reStr.append(para);
			reStr.append(">");
			Pattern pattern = Pattern.compile(reStr.toString());
			Matcher matcher = pattern.matcher(data);
			if (matcher.find()) {
				result.append(matcher.group(1));
			}
			return result.toString();
		}
	}

	public static String getParameterValue(String data, String para) {
		StringBuffer result = new StringBuffer();
		StringBuffer reStr = new StringBuffer();
		reStr.append("<");
		reStr.append(para);
		reStr.append(".*?>");
		reStr.append("(.*?)");
		reStr.append("</");
		reStr.append(para);
		reStr.append(">");
		Pattern pattern = Pattern.compile(reStr.toString());
		Matcher matcher = pattern.matcher(data);
		if (matcher.find()) {
			result.append(matcher.group(1));
		}
		return result.toString();
	}

	/**
	 * 首字母转大写
	 * @param name
	 * @return
	 */
	public static String toUpperCaseFirstOne(String name) {
		String s = name.substring(0, 1);
		s = s.toUpperCase();
		name = s + name.substring(1, name.length());
		return name;
	}
}
