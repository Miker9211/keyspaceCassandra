package com.demoach2.ach2.entity;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(
        base = "ou=u2",
        objectClasses = { "person", "inetOrgPerson", "top" })
@Getter
@Setter
public class User {
    @Id
    private Name id;

    private @Attribute(name = "cn") String username;
    private @Attribute(name = "sn") String password;

    // standard getters/setters
}
