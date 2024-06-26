package org.serratec.backend.redesocial.repository;

import java.util.Optional;

import org.serratec.backend.redesocial.model.Relationship;
import org.serratec.backend.redesocial.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
	Page<Relationship> findAll(Pageable pageable);

	Optional<Relationship> findByFollowerAndFollowed(Usuario follower, Usuario followed);
	
    @Modifying
    @Query("DELETE FROM Relationship r WHERE r.follower = :follower AND r.followed = :followed")
    void deleteByFollowerAndFollowed(Usuario follower, Usuario followed);
	
}
