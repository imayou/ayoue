package io.ayoue.common.model.base.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import io.ayoue.common.model.base.DescribedData;
import io.ayoue.common.tools.PinyinUtil;

/**
 * 有一定描述信息（如：name，description）的持久化实体类的基类
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class DescribedEntity extends BaseEntity implements DescribedData<DescribedEntity> {
	/**
	 * 名称(标题)
	 */
	protected String name;

	/**
	 * 编号
	 */
	protected String no;

	/**
	 * 显示名称
	 */
	protected String description;

	protected String pinyin;

	protected String fullPinyin;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;

	/**
	 * 最后修改时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date modifyDate;

	protected Integer sortIdx;

	protected Integer version;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = fixValue(name);
	}

	@Override
	public String getNo() {
		return no;
	}

	@Override
	public void setNo(String no) {
		this.no = no;
		// this.no = fixNo(no);
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = fixValue(description);
	}

	@Override
	public String getPinyin() {
		return pinyin;
	}

	@Override
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	@Override
	public String getFullPinyin() {
		return fullPinyin;
	}

	@Override
	public void setFullPinyin(String fullPinyin) {
		this.fullPinyin = fullPinyin;
	}

	@Override
	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public void setCreateDate(Date date) {
		this.createDate = date;
	}

	@Override
	public Date getModifyDate() {
		return modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getSortIdx() {
		return sortIdx;
	}

	public void setSortIdx(Integer sortIdx) {
		this.sortIdx = sortIdx;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof DescribedEntity) {
			DescribedEntity entity = (DescribedEntity) o;
			return super.equals(entity) || (StringUtils.isNotEmpty(getNo()) && getNo().equals(entity.getNo()))
					|| (StringUtils.isNotEmpty(getName()) && getName().equals(entity.getName()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return StringUtils.isEmpty(getNo()) ? StringUtils.isEmpty(getName()) ? -1 : getName().hashCode()
				: getNo().hashCode();
	}

	@Override
	public String toString() {
		return "[id:" + getId() + ", no:" + getNo() + ", name:" + getName() + "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	public DescribedEntity checkData() {
		if (super.checkData() != null || StringUtils.isNotBlank(getName())) {
			return this;
		}
		return null;
	}

	/**
	 * 构造基本信息
	 * 
	 * @param newObject
	 *            是否新创建
	 */
	public void generate() {
		this.setFullPinyin(PinyinUtil.getFullPinyin(this.name));
		this.setPinyin(PinyinUtil.getFirstLetterPinyin(this.name));
		if (StringUtils.isBlank(this.getUuid())) {// 新对象
			this.setUuid(generateUuid());
			this.setCreateDate(new Date());
			this.setModifyDate(this.getCreateDate());
		} else {
			this.setModifyDate(new Date());
		}
	}
}
