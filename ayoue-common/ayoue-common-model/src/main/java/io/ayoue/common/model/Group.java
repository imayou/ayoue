package io.ayoue.common.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.ayoue.common.model.base.entity.DescribedEntity;

@Entity
@Table(name = "[group]")
public class Group extends DescribedEntity{
	private static final long serialVersionUID = 3299648368441830601L;
}
