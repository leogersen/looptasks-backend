package com.leogersen.looptasks.domain;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsername(String username);

}
