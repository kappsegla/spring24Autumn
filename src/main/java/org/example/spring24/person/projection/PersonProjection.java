package org.example.spring24.person.projection;

import org.springframework.beans.factory.annotation.Value;

public interface PersonProjection {

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
    Boolean getProgrammer();
}
