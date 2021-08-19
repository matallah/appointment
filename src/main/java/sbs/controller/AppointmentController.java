package sbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sbs.model.Appointment;
import sbs.model.Clients;
import sbs.service.AbstractService;
import sbs.service.AppointmentService;
import sbs.service.ClientService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static sbs.model.AbstractModel.DATE_FORMAT;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ClientService clientService;

    protected AbstractService service() {
        return appointmentService;
    }

    @RequestMapping(value = "/appointment")
    public String index() {
        return "redirect:/appointment/1";
    }

    @RequestMapping(value = "/appointment/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        List<Appointment> page = appointmentService.getList();
//        int current = page.getNumber() + 1;
//        int begin = Math.max(1, current - 5);
//        int end = Math.min(begin + 10, page.getTotalPages());
        model.addAttribute("list", page);
//        model.addAttribute("beginIndex", begin);
//        model.addAttribute("endIndex", end);
//        model.addAttribute("currentIndex", current);
        return "appointment/list";
    }

    @ModelAttribute("allEmployees")
    public List<Clients> employeesList() {
        List<Clients> clientsList = clientService.getList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        List<Appointment> all = this.appointmentService.getList();
        for (Appointment appointment : all) {
            String formatCreationDate = simpleDateFormat.format(appointment.getCreationDate());
            String formatNewDate = simpleDateFormat.format(new Date());
            if (formatCreationDate.equals(formatNewDate)) {
                clientsList.remove(appointment.getClientId());
            }
        }
        return clientsList;
    }

    @RequestMapping("/appointment/add")
    public String add(Model model) {
        model.addAttribute("attendanc", new Appointment());
        return "appointment/form";
    }

    @RequestMapping("/appointment/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("attendanc", appointmentService.get(id));
        return "appointment/form";
    }

    @RequestMapping(value = "/appointment/save", method = RequestMethod.POST)
    public String save(Appointment appointment, final RedirectAttributes ra) {
        Appointment save = appointmentService.save(appointment);
        ra.addFlashAttribute("successFlash", "Save Success.");
        return "redirect:/appointment";

    }

    @RequestMapping("/appointment/delete/{id}")
    public String delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return "redirect:/appointment";
    }

}
