package lab.model;

import lab.dao.common.Identifiable;

public interface User extends Identifiable<User, Long> {

    String getFirstName();

    String getLastName();
}
