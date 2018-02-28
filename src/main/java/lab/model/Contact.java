package lab.model;

import lab.dao.common.Identifiable;

public interface Contact extends Identifiable<Contact, Long> {
    String getType();
    String getValue();
}
