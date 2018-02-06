package io.ayoue.common.model.base;

import java.util.Date;

/**
 * 日期敏感接口
 * 这里返回值和参数都是string 转换用java8里面的新API
 */
public interface DateAware {
	public Date getCreateDate();

	public void setCreateDate(Date createDate);

	public Date getModifyDate();

	public void setModifyDate(Date modifyDate);
}
