package io.ayoue.common.model.base;

import java.io.Serializable;

public interface BaseData extends Serializable, Cloneable {
	public Integer getTag();

	public void setTag(Integer tag);
}
