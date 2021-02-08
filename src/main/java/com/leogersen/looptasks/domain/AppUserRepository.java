package com.leogersen.looptasks.domain;

import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsername(String username);

}
