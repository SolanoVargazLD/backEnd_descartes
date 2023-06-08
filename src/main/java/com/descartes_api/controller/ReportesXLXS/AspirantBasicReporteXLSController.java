package com.descartes_api.controller.ReportesXLXS;

import com.descartes_api.model.AspirantBasic;
import com.descartes_api.model.FatherTutor;
import com.descartes_api.service.AspirantBasicService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/descartes/aspirantBasic")
public class AspirantBasicReporteXLSController {
    @Autowired
    private AspirantBasicService aspirantBasicService;

    //Para el Archivo Excel
    private XSSFWorkbook workbook;

    private XSSFSheet sheet;

    //Constructor
    public AspirantBasicReporteXLSController(){
        this.workbook= new XSSFWorkbook();  //Instaciar el archivo para el Excel
    }

    @GetMapping("/ReporteBasicXlxs")
    public void getAspirantBasicPreescolarXLSX(HttpServletResponse response,  @RequestParam("nivelBasic") String nivelBasic) throws IOException {

        response.setContentType("application/octet-stream");
        long time = System.currentTimeMillis();
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=reporte_"+nivelBasic+"_" + time + ".xlsx";

        response.setHeader(headerKey, headerValue);
        response.setHeader("time", time+"");

        workbook= new XSSFWorkbook();
        this.sheet = this.workbook.createSheet("Hola 1"+time);

        CellStyle style = this.workbook.createCellStyle();

        XSSFFont font = this.workbook.createFont();
        // font.setBold(true);
        // font.setFontHeight(16);
        style.setFont(font);

        Row row= this.sheet.createRow(0);
        createCell(row, 0,"ID", style);
        createCell(row, 1,"Nombre", style);
        createCell(row, 2,"Apellido Paterno", style);
        createCell(row, 3,"Apellido Materno", style);
        createCell(row, 4,"Curp", style);
        createCell(row, 5,"Sexo", style);
        createCell(row, 6,"Tipo de Sangre", style);
        createCell(row, 7,"Condición medica", style);
        createCell(row, 8,"Nombre_Padre/Tutor_1", style);
        createCell(row, 9,"Apellido Paterno_Padre/Tutor_1", style);
        createCell(row, 10,"Apellido Materno_Padre/Tutor_1", style);
        createCell(row, 11,"Email_Padre/Tutor_1", style);
        createCell(row, 12,"Telefono1_Padre/Tutor_1", style);
        createCell(row, 13,"Telefono2_Padre/Tutor_1", style);
        createCell(row, 14,"Nombre_Padre/Tutor_2", style);
        createCell(row, 15,"Apellido Paterno_Padre/Tutor_2", style);
        createCell(row, 16,"Apellido Materno_Padre/Tutor_2", style);
        createCell(row, 17,"Email_Padre/Tutor_2", style);
        createCell(row, 18,"Telefono1_Padre/Tutor_2", style);
        createCell(row, 19,"Telefono2_Padre/Tutor_2", style);
        createCell(row, 20,"Calle_Dirección ", style);
        createCell(row, 21,"Número_Dirección ", style);
        createCell(row, 22,"Colonia_Dirección ", style);
        createCell(row, 23,"Municipio_Dirección ", style);
        createCell(row, 24,"CodigoPostal_Dirección ", style);

        //Añador datos
        List<AspirantBasic> datos=aspirantBasicService.listAspirantBasicXLXS(nivelBasic);
        int rowCount = 1;
        for( AspirantBasic dato: datos){
            row =this.sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, rowCount-1, style);
            createCell(row, columnCount++, dato.getAspirant().getName(), style);
            createCell(row, columnCount++, dato.getAspirant().getLastNameP(), style);
            createCell(row, columnCount++, dato.getAspirant().getLastNameM(), style);
            createCell(row, columnCount++, dato.getAspirant().getCurp(), style);
            createCell(row, columnCount++, String.valueOf(dato.getAspirant().getSex()), style);
            createCell(row, columnCount++, dato.getAspirant().getBloodType(), style);
            createCell(row, columnCount++, dato.getAspirant().getConditionS(), style);
            for (FatherTutor datoF: dato.getAspirant().getFatherTutor()){
                createCell(row, columnCount++, datoF.getName(), style);
                createCell(row, columnCount++, datoF.getLastNameP(), style);
                createCell(row, columnCount++, datoF.getLastNameP(), style);
                createCell(row, columnCount++, datoF.getEmail(), style);
                createCell(row, columnCount++, datoF.getPhone1(), style);
                createCell(row, columnCount++, datoF.getPhone2(), style);
            }
            createCell(row, columnCount++, dato.getAspirant().getAddress().getStreet(), style);
            createCell(row, columnCount++, dato.getAspirant().getAddress().getNumber(), style);
            createCell(row, columnCount++, dato.getAspirant().getAddress().getColony(), style);
            createCell(row, columnCount++, dato.getAspirant().getAddress().getMunicipality(), style);
            createCell(row, columnCount++, dato.getAspirant().getAddress().getPostal_code(), style);
        }

        //Tamaño de las celdas
        for(int i=1; i<25;i++)
            sheet.setColumnWidth(i , 6000);

        //Formateo de la salida
        ServletOutputStream outputStream = response.getOutputStream();
        this.workbook.write(outputStream);
        this.workbook.close();
        outputStream.close();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
