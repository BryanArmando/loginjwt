package com.login.loginjwt.api;

import com.login.loginjwt.domain.Personal;
import com.login.loginjwt.domain.Ventas;
import com.login.loginjwt.repo.VentasRepo;
import com.login.loginjwt.reportes.GenerateReportVentas;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VentasController {

    @Autowired
    private VentasRepo ventasRepo;

    @GetMapping("/private/sucursal/{sucursalId}/ventas")
    public List<Ventas> listarpersonal(@PathVariable(value = "sucursalId") Integer sucursalId){
        return ventasRepo.findBySucursalId(sucursalId);
    }

    @GetMapping("/private/ventas")
    public List<Ventas> listaventas(){
        return ventasRepo.findAll();
    }


    @GetMapping("/private/exportarPDF")
    public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Ventas_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Ventas> ventas = ventasRepo.findAll();

        GenerateReportVentas exporter = new GenerateReportVentas(ventas);
        exporter.exportar(response);
    }
    @GetMapping("/private/fechasPDF")
    public void exportarVentasEntreFechas(HttpServletResponse response, @Param("fecha1") String fecha1, @Param("fecha2") String fecha2) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Ventas_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Ventas> ventas = ventasRepo.getPVentaFilter(fecha1, fecha2);

        GenerateReportVentas exporter = new GenerateReportVentas(ventas);
        exporter.exportar(response);
    }

    @GetMapping("/private/sucursal/{sucursalId}/reporteventas")
    public void exportarVentasSucursal(@PathVariable(value = "sucursalId") Integer sucursalId, HttpServletResponse response) throws DocumentException, IOException{

        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Ventas_"+sucursalId+"Sucursal_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Ventas> ventas = ventasRepo.findBySucursalId(sucursalId);

        GenerateReportVentas exporter = new GenerateReportVentas(ventas);
        exporter.exportar(response);
    }


}
