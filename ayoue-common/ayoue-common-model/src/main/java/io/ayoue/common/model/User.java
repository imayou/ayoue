package io.ayoue.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.ayoue.common.model.base.entity.DescribedEntity;

@Entity
@Table(name = "[user]")
public class User extends DescribedEntity {
	private static final long serialVersionUID = -4196311899336797033L;

	@ManyToOne()
	@JoinColumn(name = "group_uuid", referencedColumnName = "uuid")
	@JsonBackReference
	private Group group;

	@ManyToMany(cascade = {}, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
			joinColumns = { @JoinColumn(name = "user_uuid", referencedColumnName = "uuid") }, 
			inverseJoinColumns = { @JoinColumn(name = "role_uuid", referencedColumnName = "uuid") })
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
