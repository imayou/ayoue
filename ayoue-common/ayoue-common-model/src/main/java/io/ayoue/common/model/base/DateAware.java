package io.ayoue.common.model.base;

import java.time.Instant;

/**
 * 日期敏感接口
 * 这里返回值和参数都是string 转换用java8里面的新API
 */
public interface DateAware {
	public Instant getCreateDate();

	public void setCreateDate(Instant createDate);

	public Instant getModifyDate();

	public void setModifyDate(Instant modifyDate);
}
