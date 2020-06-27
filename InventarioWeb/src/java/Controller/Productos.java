/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
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
 * @author Nolasco
 */
public class Productos extends HttpServlet {

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
    protected void listaProducto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Instancia a categoria DAO
        ProductoDAO categoria = new ProductoDAOImplementar();
        //crear instacia de session; true para iniciar session
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", producto.listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Producto/listarProducto.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");
        if(parametro.equals("crear")){
            String pagina = "/Vistas-Producto/crearProducto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        }else if(parametro.equals("listar")){
            this.listaProducto(request, response);
        }else if(parametro.equals("modificar")){
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            int id_producto = Integer.parseInt(request.getParameter("id_pro"));
            String nom_producto = request.getParameter("nombre_pro");
            int estado_producto = Integer.parseInt(request.getParameter("estado_pro"));
            
            String pagina = "/Vistas-Producto/crearProducto.jsp?id_pro="+id_producto+"&&nombre_pro="+nom_producto+"&&estado_pro="+estado_producto+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        }else if(parametro.equals("eliminar")){
            int del_id = Integer.parseInt(request.getParameter("id"));
            ProductoDAO producto = new ProductoDAOImplementar();
            producto.borrarCat(del_id);    
            this.listaProducto(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        String parametro = request.getParameter("accion");
            
                
             Productos producto = new Productos();
        //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));
        String nom_producto = request.getParameter("txtNomproducto");
        int estado_producto = Integer.parseInt(request.getParameter("txtEstadoProducto"));
        
        Productos.setId_producto(id_producto);
        Productos.setNom_producto(nom_producto);
        Productos.setEstado_producto(estado_producto);
        
        ProductoDAO guardarCategoria = new ProductoDAOImplementar();
        guardarCategoria.guardarCat(producto);
        
        this.listaProducto(request, response);
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