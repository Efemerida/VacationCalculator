package neoflex.repositories;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class HolidaysRepositoryImpl implements HolidaysRepository{

    public List<LocalDate> getHolidays(){
        return List.of(
                LocalDate.of(LocalDate.now().getYear(),1,1),
                LocalDate.of(LocalDate.now().getYear(),1,2),
                LocalDate.of(LocalDate.now().getYear(),1,3),
                LocalDate.of(LocalDate.now().getYear(),1,4),
                LocalDate.of(LocalDate.now().getYear(),1,5),
                LocalDate.of(LocalDate.now().getYear(),1,6),
                LocalDate.of(LocalDate.now().getYear(),1,7),
                LocalDate.of(LocalDate.now().getYear(),1,8),
                LocalDate.of(LocalDate.now().getYear(),2,23),
                LocalDate.of(LocalDate.now().getYear(),3,8),
                LocalDate.of(LocalDate.now().getYear(),5,1),
                LocalDate.of(LocalDate.now().getYear(),5,8),
                LocalDate.of(LocalDate.now().getYear(),5,9),
                LocalDate.of(LocalDate.now().getYear(),5,10),
                LocalDate.of(LocalDate.now().getYear(),6,12),
                LocalDate.of(LocalDate.now().getYear(),12,31)
        );

    }

}
