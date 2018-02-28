package lab.dao.common;

public interface Identifiable<T extends Identifiable<T, I>, I> {
    I getId();
    T setId(I id);
}
