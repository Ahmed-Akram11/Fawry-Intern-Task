package Task.Interfacess;

import java.time.LocalDate;

public interface IsExpired {
    boolean isExpired();
    LocalDate expiringDate();
}
