/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Iván Pérez
 */
public class Categorias extends HttpServlet {

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
            throws ServletException, IOException {
        
        
    }

   
   //Agregar metodo listaCategorias
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Instancia a categoria DAO
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        //crear instacia de session; true para iniciar session
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", categoria.listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategoria.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");
        if(parametro.equals("crear")){
            String pagina = "/Vistas-Categorias/crearCategoria.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        }else if(parametro.equals("listar")){
            this.listaCategorias(request, response);
        }else if(parametro.equals("modificar")){
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            int id_categoria = Integer.parseInt(request.getParameter("id_cat"));
            String nom_categoria = request.getParameter("nombre_cat");
            int estado_categoria = Integer.parseInt(request.getParameter("estado_cat"));
            
            String pagina = "/Vistas-Categorias/crearCategoria.jsp?id_c="+id_categoria+"&&nombre_c="+nom_categoria+"&&estado_c="+estado_categoria+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        }else if(parametro.equals("eliminar")){
            int del_id = Integer.parseInt(request.getParameter("id"));
            CategoriaDAO categoria = new CategoriaDAOImplementar();
            categoria.borrarCat(del_id);    
            this.listaCategorias(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        String parametro = request.getParameter("accion");
            
                
             Categoria categoria = new Categoria();
        //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        String nom_categoria = request.getParameter("txtNomCategoria");
        int estado_categoria = Integer.parseInt(request.getParameter("txtEstadoCategoria"));
        
        categoria.setId_categoria(id_categoria);
        categoria.setNom_categoria(nom_categoria);
        categoria.setEstado_categoria(estado_categoria);
        
        CategoriaDAO guardarCategoria = new CategoriaDAOImplementar();
        guardarCategoria.guardarCat(categoria);
        
        this.listaCategorias(request, response);
        //se efectua el casting o conversion de datos porque lo ingresado en el formulario es texto
       
         
             
        
        
        
        
        
      
       
        
        
        
        
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
