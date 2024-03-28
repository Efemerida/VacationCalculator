package neoflex.repositories;

import java.time.LocalDate;
import java.util.List;

public interface HolidaysRepository {

    List<LocalDate> getHolidays();

}
