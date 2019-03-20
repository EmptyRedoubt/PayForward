package com.SaladinA.PF.repositories;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
import com.SaladinA.PF.models.Role;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor{
	Role findByRole(String role);
	List<Role> findAll();
	//@Query("FROM Role r JOIN r.personRoles p WHERE p.id = ?1")
	public List<Role> findByPersonRoles_Id(Long id);
	@Query(value = "SELECT r.role FROM prsn p INNER JOIN prsn_role pr ON (p.prsn_id=pr.prsn_id) INNER JOIN Role r ON(pr.role_id=r.ROLE_ID) WHERE p.prsn_id=?1", nativeQuery = true)

	public List<String> findAllRolesByPrsnId(Long prsn_id);

}
