package kz.bitlab.JavaSpring.Sprint2.repository;
import java.util.*;

import kz.bitlab.JavaSpring.Sprint2.model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRequestRepositiry extends JpaRepository<ApplicationModel, Long> {


    @Query("SELECT a FROM ApplicationModel a where a.handled = false")
    List<ApplicationModel> searchApplicationRequest();

    @Query("SELECT a FROM  ApplicationModel a ORDER BY a.handled")
    List<ApplicationModel> sortByHandle();

    List<ApplicationModel> searchApplicationModelByID(Long id);
    List<ApplicationModel> searchApplicationModelByHandled(boolean handled);
    List<ApplicationModel> findAllByHandledIsTrue();
    List<ApplicationModel> findAllByHandledIsFalse();

}
