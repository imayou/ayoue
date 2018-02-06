package io.ayoue.common.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.ayoue.common.model.base.entity.DescribedEntity;

public class User extends DescribedEntity {
	private static final long serialVersionUID = -4196311899336797033L;

	@JoinColumn(name = "group")
	@JsonBackReference
	private Group group;

	@ManyToMany(cascade = {}, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_uuid") }, inverseJoinColumns = { @JoinColumn(name = "roles_uuid") })
	private List<Role> roles;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
