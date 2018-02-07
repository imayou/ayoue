package io.ayoue.common.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.ayoue.common.model.base.entity.DescribedEntity;

@Entity
@Table(name = "[role]")
public class Role extends DescribedEntity {
	private static final long serialVersionUID = -8789114912252792514L;

}
