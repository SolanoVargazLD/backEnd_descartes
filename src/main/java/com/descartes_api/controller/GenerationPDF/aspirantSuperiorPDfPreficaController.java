package com.descartes_api.controller.GenerationPDF;


import com.descartes_api.model.AspirantSuperior;
import com.descartes_api.model.FatherTutor;
import com.descartes_api.service.AspirantSuperiorService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@CrossOrigin
@RequestMapping(value ="/api/descartes/aspirantSuperior")
public class aspirantSuperiorPDfPreficaController {

    @Autowired
    private AspirantSuperiorService aspirantSuperiorService;

    private final TemplateEngine templateEngine;

    @Autowired
    public aspirantSuperiorPDfPreficaController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
    @GetMapping("/prefichaPDF")
    public void download(HttpServletResponse response, @RequestParam("aspirantB") int aspirantB) throws IOException, DocumentException {
        // Obtener los datos del aspirante
        AspirantSuperior aspirantSuperior =  aspirantSuperiorService.getAspirantBasicById(aspirantB);
        String nameC = aspirantSuperior.getAspirant().getName() + " " + aspirantSuperior.getAspirant().getLastNameP() + " " + aspirantSuperior.getAspirant().getLastNameM();
        String curp = aspirantSuperior.getAspirant().getCurp();
        String nivel = aspirantSuperior.getLevelHigher().getNivelEducativo();
        String career= aspirantSuperior.getLevelHigher().getNameCareer();
        String namePT = "";
        String email = "";
        String telefono1 = "";

        boolean isFirstIteration = true;
        for (FatherTutor fatherTutor : aspirantSuperior.getAspirant().getFatherTutor()) {
            if (isFirstIteration) {
                namePT = fatherTutor.getName() + " " + fatherTutor.getLastNameP() + " " + fatherTutor.getLastNameM();
                email = fatherTutor.getEmail();
                telefono1 = fatherTutor.getPhone1();
                isFirstIteration = false;
            } else {
                break;
            }
        }

        // Generar el HTML para la plantilla
        String html = generateHtmlFromTemplate(nameC, curp, career, nivel, namePT, email, telefono1);

        // Generar el archivo PDF
        ByteArrayOutputStream pdfBaos = generateVoucherDocumentBaos(html);

        // Configurar la respuesta HTTP para la descarga del archivo PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", ""+aspirantSuperior.getAspirant().getLastNameP()+aspirantSuperior.getAspirant().getLastNameM()+"_"+nivel+".pdf"));
        response.setContentLength(pdfBaos.size());

        // Copiar los datos del PDF al flujo de salida de la respuesta HTTP
        OutputStream outputStream = response.getOutputStream();
        pdfBaos.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public String generateHtmlFromTemplate(String nameC, String curp, String career,String nivel, String namePT, String email, String telefono1) {
        LocalDate fechaActual = LocalDate.now();

        // Crear el formateador de fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        // Formatear la fecha actual
        String fechaFormateada = fechaActual.format(formatter);

        // Generar el HTML a partir de los datos
        Context context = new Context();
        context.setVariable("nameC", nameC);
        context.setVariable("curp", curp);
        context.setVariable("career", career);
        context.setVariable("nivel", nivel);
        context.setVariable("namePT", namePT);
        context.setVariable("email", email);
        context.setVariable("telefono1", telefono1);
        context.setVariable("fechaFormateada", fechaFormateada);
        return templateEngine.process("prefichaLicenciature", context);
    }

    public ByteArrayOutputStream generateVoucherDocumentBaos(String html) throws IOException, DocumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(baos);
        baos.close();

        return baos;
    }
}
