package sbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sbs.model.Appointment;
import sbs.repository.AppointmentDao;

@Service
public class AppointmentService extends AbstractService<Appointment, Long> {
    @Autowired
    private AppointmentDao dao;


    @Override
    protected JpaRepository<Appointment, Long> getRepository() {
        return dao;
    }
}
