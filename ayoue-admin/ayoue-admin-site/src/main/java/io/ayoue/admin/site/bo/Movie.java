package io.ayoue.admin.site.bo;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Movie {
	@GraphId
	Long id;
	String title;
	String year;
	String tagline;
	@Relationship(type = "ACTS_IN", direction = Relationship.INCOMING)
	List<Role> roles = new ArrayList<>();

	public Role addRole(Actor actor, String name) {
		Role role = new Role(actor, this, name);
		this.roles.add(role);
		return role;
	}
}
