package io.ayoue.admin.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ayoue.common.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
