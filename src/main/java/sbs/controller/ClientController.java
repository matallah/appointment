package sbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sbs.model.Clients;
import sbs.service.ClientService;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/clients")
    public String index() {
        return "redirect:/clients/1";
    }

    @RequestMapping(value = "/clients/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        List<Clients> page = clientService.getList();
//        int current = page.getNumber() + 1;
//        int begin = Math.max(1, current - 5);
//        int end = Math.min(begin + 10, page.getTotalPages());
        model.addAttribute("list", page);
//        model.addAttribute("beginIndex", begin);
//        model.addAttribute("endIndex", end);
//        model.addAttribute("currentIndex", current);
        return "clients/list";
    }

    @RequestMapping("/clients/add")
    public String add(Model model) {
        model.addAttribute("client", new Clients());
        return "clients/form";
    }

    @RequestMapping("/clients/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.get(id));
        return "clients/form";
    }

    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public String save(Clients clients, final RedirectAttributes ra) {
        Clients save = clientService.save(clients);
        ra.addFlashAttribute("successFlash", "Save Success.");
        return "redirect:/clients";

    }

    @RequestMapping("/clients/delete/{id}")
    public String delete(@PathVariable Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }

}
