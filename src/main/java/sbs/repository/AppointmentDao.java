package sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbs.model.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {

}
