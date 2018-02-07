package io.ayoue.admin.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ayoue.common.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
