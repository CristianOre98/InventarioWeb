/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iván Pérez
 */
@WebServlet(urlPatterns = {"/ReporteUsuario"})
public class ReporteUsuario extends HttpServlet {
  /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/pdf");
        OutputStream salida = response.getOutputStream();//nombre del pdf

        try {
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario", "root" , "");
            st = (Statement)con.createStatement();
            rs = st.executeQuery("SELECT * FROM tb_usuario");
            
            if (con!=null) {
                try {
                    Document Documento = new Document();
                    PdfWriter.getInstance(Documento, salida);
                    Documento.open();// abrir documento
                    // Metadatos
                    Documento.addAuthor("Anonimo");
                    Documento.addCreator("Anonimo");
                    Documento.addSubject("Usando itext");
                    Documento.addKeywords("Reporte Producto");

                    Paragraph titulo = new Paragraph();
                    Paragraph parrafo = new Paragraph(); // objeto parrafo contiene el string
                    // Propiedades de la fuente
                    Font font_titulo = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD, BaseColor.BLACK);
                    Font font_parrafos = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.NORMAL, BaseColor.DARK_GRAY);
                    // Agregar texto
                    titulo.add(new Phrase("Reporte de Productos",font_titulo));
                    titulo.setAlignment(Element.ALIGN_CENTER);
                    // agregar saltos de linea
                    titulo.add(new Phrase(Chunk.NEWLINE));
                    titulo.add(new Phrase(Chunk.NEWLINE));
                    Documento.add(titulo); // Agregar el elemento al pdf
                    parrafo.add(new Phrase(Chunk.NEWLINE));
                    parrafo.add(new Phrase(Chunk.NEWLINE));
                    parrafo.setAlignment(Element.ALIGN_JUSTIFIED);
                    parrafo.add(new Phrase("Lista de Productos disponibles de la base de datos", font_parrafos));
                    parrafo.add(new Phrase(Chunk.NEWLINE));
                    parrafo.add(new Phrase(Chunk.NEWLINE));
                    Documento.add(parrafo);// Agregar elemento al pdf

                    //Agregar tabla
                    PdfPTable tabla = new PdfPTable(11);// Columnas
                    //               texto      fuente
                    PdfPCell celda1 = new PdfPCell(new Paragraph("Codigo", FontFactory.getFont("Arial Black",12 ,BaseColor.BLUE)));
                    PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda3 = new PdfPCell(new Paragraph("Apellido", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda4 = new PdfPCell(new Paragraph("Correo", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda5 = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda6 = new PdfPCell(new Paragraph("Clave", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda7 = new PdfPCell(new Paragraph("Tipo", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda8 = new PdfPCell(new Paragraph("Estado", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda9 = new PdfPCell(new Paragraph("Pregunta", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda10 = new PdfPCell(new Paragraph("Pregunta", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));
                    PdfPCell celda11 = new PdfPCell(new Paragraph("Pregunta", FontFactory.getFont("Arial Black",12,BaseColor.BLUE)));

                    celda1.setPaddingBottom(5);// padding
                    celda9.setPaddingBottom(5);// padding
                    tabla.setWidthPercentage(95F);
                   
                    //Agregar celdas a la tabla aconsejo usar un bucle para esto
                    tabla.addCell(celda1);
                    tabla.addCell(celda2);
                    tabla.addCell(celda3);
                    tabla.addCell(celda4);
                    tabla.addCell(celda5);
                    tabla.addCell(celda6);
                    tabla.addCell(celda7);
                    tabla.addCell(celda8);
                    tabla.addCell(celda9);
                    tabla.addCell(celda10);
                    tabla.addCell(celda11);
                    
                   

                    while(rs.next()){
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                        tabla.addCell(rs.getString(10));
                        tabla.addCell(rs.getString(11));
                    }


                    Documento.add(tabla);// Meter al documento
                    Documento.close();// no olvidar cerrar el doc
                    
                } catch (DocumentException ex) {
                    System.out.println("Error: " + ex);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}