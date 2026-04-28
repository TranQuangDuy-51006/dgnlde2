package re.dgnlde02.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import re.dgnlde02.model.Artifact;
import re.dgnlde02.service.ArtifactService;

@Controller
@RequestMapping("/artifacts")
public class ArtifactController {
    @Autowired
    private ArtifactService service;

    @GetMapping
    public String list(Model model, @RequestParam(defaultValue = "0") int page){
        Page<Artifact> data = service.getAll(page);
        System.out.println("DATA");
        System.out.println(data.getContent());
        model.addAttribute("list", data);
        return  "artifact/list";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Artifact artifact, BindingResult result){
        if (result.hasErrors()){
            return "artifact/list";
        }

        service.save(artifact);
        return "redirect:/artifacts";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/artifact";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("artifact", service.findById(id));
        return "artifact/form";
    }
}
