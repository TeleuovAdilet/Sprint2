package kz.bitlab.JavaSpring.Sprint2.Controller;

import kz.bitlab.JavaSpring.Sprint2.model.ApplicationModel;
import kz.bitlab.JavaSpring.Sprint2.repository.ApplicationRequestRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestRepositiry applicationRequestRepositiry;

    @GetMapping ("/")
    public String login(Model model) {
        List<ApplicationModel> sprints = applicationRequestRepositiry.sortByHandle();
        model.addAttribute("request", sprints);
        return "AllApplications";
    }

    @PostMapping("/AddApplications")
    public String addApplication(ApplicationModel applicationModel) {
        applicationRequestRepositiry.save(applicationModel);
        return "redirect:/";
    }
    @GetMapping("/AddApplications")
    public String addApplication() {
        return "AddApplications";
    }

    @PostMapping("/DeleteApplications")
    public String deleteApplication(@RequestParam(name="id") Long id) {
        applicationRequestRepositiry.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/ProcessedApplications")
    public String processedApplications(Model model) {
        List<ApplicationModel> sprints = applicationRequestRepositiry.findAllByHandledIsTrue();
        model.addAttribute("request", sprints);
        return "ProcessedApplications";
    }

    @PostMapping("/ProcessedApplications")
    public String processedApplications() {
        return "redirect:/";
    }

    @GetMapping("/NewApplications")
    public String NewApplications(Model model) {
        List<ApplicationModel> sprints = applicationRequestRepositiry.findAllByHandledIsFalse();
        model.addAttribute("request", sprints);
        return "NewApplications";
    }

    @GetMapping("/details")
    public String Details(@RequestParam(name="id") Long id, Model model){
        ApplicationModel applicationModel = applicationRequestRepositiry.findById(id).orElse(null);
        model.addAttribute("detailsrequest", applicationModel);
        return "details";
    }

    @PostMapping("/SaveDetails")
    public String saveDetails(@RequestParam(name = "id")  long id) {
    ApplicationModel applicationModel = applicationRequestRepositiry.findById(id).orElse(null);
    if(applicationModel != null) {
        if(!applicationModel.isHandled()){
            applicationModel.setHandled(true);
        }
        applicationRequestRepositiry.save(applicationModel);
    }
        return "redirect:/";
    }


}
