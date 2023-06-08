package com.descartes_api.controller.GenerationPDF;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.model.FatherTutor;
import com.descartes_api.service.AspirantBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class aspirantBasicPDfController {

    @Autowired
    private AspirantBasicService aspirantBasicService;

    @GetMapping("/api/descartes/aspirantBasic/pdfBasic")
    public String mostrarBasic(Model model, @RequestParam("aspirantB") int aspirantB){
        AspirantBasic aspirantBasic= aspirantBasicService.getAspirantBasicById(aspirantB);

        String nameC= aspirantBasic.getAspirant().getName()+" "+aspirantBasic.getAspirant().getLastNameP()+" "+aspirantBasic.getAspirant().getLastNameM();
        String curp=  aspirantBasic.getAspirant().getCurp();
        String nivel= aspirantBasic.getLevelBasic().getName();

        String namePT="";
        String email="";
        String telefono1="";

        boolean isFirstIteration = true;
        for (FatherTutor fatherTutor: aspirantBasic.getAspirant().getFatherTutor()){
            if (isFirstIteration) {
                    namePT= fatherTutor.getName()+" "+ fatherTutor.getLastNameP()+" "+fatherTutor.getLastNameM();
                    email=  fatherTutor.getEmail();
                    telefono1= fatherTutor.getPhone1();
                isFirstIteration = false;
            }else{
                break;
            }
        }

        model.addAttribute("nameC", nameC);
        model.addAttribute("curp", curp);
        model.addAttribute("nivel", nivel);

        model.addAttribute("namePT", namePT);
        model.addAttribute("email", email);
        model.addAttribute("telefono1", telefono1);

        return "prefichaBasic";
    }

}
