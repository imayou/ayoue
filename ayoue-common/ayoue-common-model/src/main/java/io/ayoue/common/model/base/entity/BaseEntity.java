package io.ayoue.common.model.base.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.ayoue.common.model.base.DataObject;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity extends DataObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "uuid", length = 48, unique = true)
	protected String uuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 编辑时判断是否是新创建的对象
	 * 
	 * @return
	 */
	public boolean isNew() {
		return !isValidId() && !isValidUuid();
	}

	public boolean isValidId() {
		return isValidId(getId());
	}

	public static boolean isValidId(Long entityId) {
		return entityId != null && entityId > 0;
	}

	public static Long parseBoId(BaseEntity entity) {
		if (entity != null) {
			Long entityId = entity.getId();
			if (isValidId(entityId)) {
				return entityId;
			}
		}
		return null;
	}

	public static <B extends BaseEntity> String[] getBoIdsArray(Collection<B> entities) {
		return getBoIds(entities).toArray(new String[] {});
	}

	public static <B extends BaseEntity> List<Long> getBoIds(Collection<B> entities) {
		List<Long> ids = new ArrayList<>();
		if (entities != null) {
			for (B entity : entities) {
				if (entity != null) {
					ids.add(entity.getId());
				}
			}
		}
		return ids;
		// return entities.stream().filter(entitie -> (null != entitie.getId())).collect(Collectors.toList());
	}

	public static <B extends BaseEntity> B getBo(Collection<B> col, Long id) {
		if (col != null && id != null) {
			for (B b : col) {
				if (b != null && id.equals(b.getId())) {
					return b;
				}
			}
		}
		return null;
	}

	public static <E extends BaseEntity> void addItem(Collection<E> col, E item) {
		if (!col.contains(item)) {
			col.add(item);
		}
	}

	public static <E extends BaseEntity> void removeItem(Collection<E> col, E item) {
		if (col != null && col.contains(item)) {
			col.remove(item);
		}
	}

	public static final List<Long> convertToLong(List<Integer> ids) {
		List<Long> newIds = new ArrayList<>();
		for (Integer id : ids) {
			newIds.add(id.longValue());
		}
		return newIds;
	}
}
