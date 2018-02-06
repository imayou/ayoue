package io.ayoue.common.model.base;

import org.apache.commons.lang3.StringUtils;

import io.ayoue.common.tools.Pinyinable;


/**
 * 有一定描述信息（如：name，description）的数据
 */
public interface DescribedData<T extends DescribedData<?>> extends DateAware, Pinyinable {
	public String getName();

	public void setName(String name);

	public String getNo();

	public void setNo(String no);

	public String getDescription();

	public void setDescription(String description);

	//==========================Domain Method==============================//

	@Override
	default String getPinyinableValue() {
		//return StringUtils.isBlank(getName()) ? getDescription() : getName();
		//description是名称；name是系统名称，系统的唯一名称可能为uuid其他
		return StringUtils.isBlank(getDescription()) ? getName():getDescription();
	}

	@SuppressWarnings("unchecked")
	default  T checkData() {
		return StringUtils.isNotBlank(getName()) ? (T) this : null;
	}

	default String fixNo(String value) {
//		return StringUtils.isBlank(getNo()) ? null : StringUtils.trim(getNo().toUpperCase());
		return StringUtils.isBlank(value) ? null : StringUtils.trim(value.toUpperCase());
	}

	default String fixValue(String value) {
//		return StringUtils.isBlank(value) ? null : StringUtils.trim(getName());
		return StringUtils.isBlank(value) ? null : StringUtils.trim(value);
	}

	public static final String[] jsonListFields = {"uuid", "tag", "no", "name", "description", "createDate", "modifyDate"};
}
