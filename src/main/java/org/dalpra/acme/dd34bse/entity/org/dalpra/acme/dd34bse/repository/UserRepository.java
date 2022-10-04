package org.dalpra.acme.dd34bse.entity.org.dalpra.acme.dd34bse.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.dalpra.acme.dd34bse.entity.User;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}