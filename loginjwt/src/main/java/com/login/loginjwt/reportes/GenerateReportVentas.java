package com.login.loginjwt.reportes;

import com.login.loginjwt.domain.Ventas;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GenerateReportVentas {
    private List<Ventas> listaVentas;

    public GenerateReportVentas(List<Ventas> listaVentas) {
        super();
        this.listaVentas = listaVentas;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);

        com.lowagie.text.Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Fecha", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Medicamento", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Cantidad", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("PrecioUnitario", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("PrecioVenta", fuente));
        tabla.addCell(celda);

    }

    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (Ventas ventas : listaVentas) {
            tabla.addCell(String.valueOf(ventas.getId()));
            tabla.addCell(String.valueOf(ventas.getFecha_venta()));
            tabla.addCell(ventas.getMedicamento());
            tabla.addCell(String.valueOf(ventas.getCantidad()));
            tabla.addCell(String.valueOf(ventas.getPvp_venta()));
            tabla.addCell(String.valueOf(ventas.getPvp_compra()));
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Ventas Realizadas", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(6);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 2.3f, 4.5f, 6f, 3.9f, 4.5f });
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
