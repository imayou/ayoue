package io.ayoue.common.tools;

public interface Pinyinable {
	/**
	 * 获取可转换拼音的原始值
	 * 
	 * @return
	 */
	public String getPinyinableValue();

	/**
	 * pinyinableValue对应的简拼(首字母拼音)
	 * 
	 * @return
	 */
	public String getPinyin();

	public void setPinyin(String pinyin);

	/**
	 * pinyinableValue对应的全拼
	 * 
	 * @return
	 */
	public String getFullPinyin();

	public void setFullPinyin(String pinyin);
}
