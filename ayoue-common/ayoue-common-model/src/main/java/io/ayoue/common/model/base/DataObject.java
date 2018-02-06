package io.ayoue.common.model.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import io.ayoue.common.tools.UUIDUtil;


@SuppressWarnings("serial")
public abstract class DataObject implements BaseData {

	private Integer tag;

	@Override
	public Integer getTag() {
		return tag;
	}

	@Override
	public void setTag(Integer tag) {
		this.tag = tag;
	}

	/*------------BM------------*/

	public abstract String getUuid();

	public abstract void setUuid(String uuid);

	@Override
	public int hashCode() {
		return getUuid() == null ? -1 : toString().hashCode();
	}

	@Override
	public String toString() {
		return "[uuid:" + getUuid() + "]";
	}

	@SuppressWarnings("unchecked")
	public <T extends DataObject> T checkData() {
		return isValidUuid() ? (T) this : null;
	}

	public boolean isValidUuid() {
		return isValidUuid(getUuid());
	}

	public String generateUuid() {
		String newUuid = UUIDUtil.generate();
		setUuid(newUuid);
		return newUuid;
	}

	/**
	 * 检查Entity的有效性，无效的将返回null
	 */
	public static <T extends DataObject> T checkData(T data) {
		if (data == null) {
			return null;
		}
		return data.checkData();
	}

	public static boolean isValidUuid(String uuid) {
		return StringUtils.isNotBlank(uuid);
	}

	public static String notNull(String v) {
		return v == null ? "" : v;
	}

	public static Integer notNull(Integer v) {
		return v == null ? 0 : v;
	}

	public static Double notNull(Double v) {
		return v == null ? 0 : v;
	}

	public static String[] notNull(String[] arr) {
		return arr == null ? new String[0] : arr;
	}

	public static Long[] notNull(Long[] arr) {
		return arr == null ? new Long[0] : arr;
	}

	@SuppressWarnings("unchecked")
	public static <D extends DataObject> List<D> notNull(List<D> c) {
		return (List<D>) notNull(c, List.class);
	}

	@SuppressWarnings("unchecked")
	public static <D extends DataObject> Set<D> notNull(Set<D> c) {
		return (Set<D>) notNull(c, Set.class);
	}

	public static <D extends DataObject, C extends Collection<D>> Collection<D> notNull(Collection<D> c,
			Class<C> clazz) {
		if (c == null) {
			if (ClassUtils.isAssignable(clazz, List.class)) {
				return new ArrayList<D>();
			} else if (ClassUtils.isAssignable(clazz, Set.class)) {
				return new HashSet<D>();
			} else {
				throw new UnsupportedOperationException();
			}
		}
		return c;
	}
}
