package io.ayoue.common.tools;

import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PinyinUtil {
	private static final Log log = LogFactory.getLog(PinyinUtil.class);

	private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

	static {
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
	}

	public static String getFullPinyin(String word) {
		return getPinyin(word, false);
	}

	public static String getFirstLetterPinyin(String word) {
		return getPinyin(word, true);
	}

	private static String getPinyin(String word, boolean isFirstLetter) {
		if(StringUtils.isBlank(word)) {
			return null;
		}
		if(isFirstLetter) {
			format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		} else {
			format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		}
		StringBuffer buf = new StringBuffer();
		char[] chs = word.toCharArray();
		for(char c : chs) {
			if(CharUtils.isAsciiAlphanumeric(c)) {
				buf.append(c);
			} else {
				try {
					String[] result = PinyinHelper.toHanyuPinyinStringArray(c, format);
					if(!ArrayUtils.isEmpty(result)) {
						String pinyin = StringUtils.capitalize(result[0]);
						if(!StringUtils.isEmpty(pinyin)) {
							buf.append(isFirstLetter ? pinyin.charAt(0) : pinyin);
						}
					}
				} catch(BadHanyuPinyinOutputFormatCombination e) {
					log.error("生成(" + word + ")拼音时产生错误", e);
				}
			}
		}
		return buf.toString();
	}

	/**
	 * 更新简拼
	 * @param pinyinObj
	 */
	public static void updatePinyin(Pinyinable pinyinObj) {
		updatePinyin(pinyinObj, false);
	}

	/**
	 * 更新简拼和可选全拼
	 * @param pinyinObj
	 * @param updateFullPinyin
	 */
	public static void updatePinyin(Pinyinable pinyinObj, boolean updateFullPinyin) {
		String word = pinyinObj.getPinyinableValue();
		String pinyin = StringUtils.substring(getFirstLetterPinyin(word), 0, 50);
		pinyinObj.setPinyin(pinyin);
		if(updateFullPinyin) {
			updateFullPinyin(pinyinObj);
		}
	}

	public static void updateFullPinyin(Pinyinable pinyinObj) {
		String word = pinyinObj.getPinyinableValue();
		String fullPinyin = StringUtils.substring(getFullPinyin(word), 0, 255);
		pinyinObj.setFullPinyin(fullPinyin);
	}

	public static void updatePinyin(List<Pinyinable> pinyinObjs) {
		updatePinyin(pinyinObjs, false);
	}

	public static void updatePinyin(List<Pinyinable> pinyinObjs, boolean updateFullPinyin) {
		if(CollectionUtils.isNotEmpty(pinyinObjs)) {
			for(Pinyinable pinyinObj : pinyinObjs) {
				updatePinyin(pinyinObj, updateFullPinyin);
			}
		}
	}

	public static void main(String... args) {
		String word = "中华打印";
		System.out.println(getFullPinyin(word));
		System.out.println(getFirstLetterPinyin(word));
		System.out.println(System.currentTimeMillis());
	}
}
