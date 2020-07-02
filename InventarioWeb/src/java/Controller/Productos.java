
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Categoria;
import Model.Producto;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        response.setContentType("text/html;charset=UTF-8");
        
    }
    //Agregar metodo listaCategorias
    protected void listaProducto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Instancia a categoria DAO
        ProductoDAO producto = new ProductoDAOImplementar();  
        //crear instacia de session; true para iniciar session
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", producto.listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Producto/listarProducto.jsp");
        dispatcher.forward(request, response);
        
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
        String parametro = request.getParameter("opcion");
        if(parametro.equals("crear")){
            String pagina = "/Vistas-Producto/crearProducto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        }else if(parametro.equals("listar")){
            this.listaProducto(request, response);
        }else if(parametro.equals("editar")){
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            
            int id_producto = Integer.parseInt(request.getParameter("id_pro").replaceAll("\\s*$",""));
            
            String nom_producto = request.getParameter("nom_pro");
            String des_producto = request.getParameter("des_pro");
            int estado_producto = Integer.parseInt(request.getParameter("estado_pro").replaceAll("\\s*$",""));
            
            float stock = Float.parseFloat(request.getParameter("stock_pro").replaceAll("\\s*$",""));
            float precio = Float.parseFloat(request.getParameter("precio_pro").replaceAll("\\s*$",""));
            
            String unidad_de_medida = request.getParameter("unidad_pro");
            int categoria_id = Integer.parseInt(request.getParameter("categoria_pro").replaceAll("\\s*$",""));
     
         String fecha_entrada = request.getParameter("fecha_pro");
	
    	
        	
                String pagina = "/Vistas-Producto/crearProducto.jsp?id_p="+id_producto+"&&nom_p="
                    +nom_producto+"&&estado_p="+estado_producto+"&&des_p="+des_producto+"&&stock_p="+stock+
                    "&&precio_p="+precio+"&&unidad_p="+unidad_de_medida+"&&categoria_p="+categoria_id+
                    "&&fecha_p="+fecha_entrada+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
    	
            
           
           
            
            
        }else if(parametro.equals("eliminar")){
            int Producto_id = Integer.parseInt(request.getParameter("id"));
            ProductoDAO producto = new ProductoDAOImplementar();
            producto.borrarPro(Producto_id);    
            this.listaProducto(request, response);
        }
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
        // processRequest(request, response);
        
            
                
             Producto producto = new Producto();
             
        //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        
         int id_producto = Integer.parseInt(request.getParameter("txtId_producto"));
            String nom_producto = request.getParameter("txtNombreProducto");
            String des_producto = request.getParameter("txtDescripcionProducto");
            float stock = Float.parseFloat(request.getParameter("txtStockProducto"));
            float precio = Float.parseFloat(request.getParameter("txtPrecioProducto"));
            String unidad_de_medida = request.getParameter("txtUnidadProducto");
            int estado_producto = Integer.parseInt(request.getParameter("txtEstadoProducto"));
            int categoria_id = Integer.parseInt(request.getParameter("txtCategoriaProducto"));
            String fecha_entrada = request.getParameter("txtFechaProducto");
        
        producto.setId_producto(id_producto);
        producto.setNom_producto(nom_producto);
        producto.setDes_producto(des_producto);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setUnidadMedida(unidad_de_medida);
        producto.setEstado(estado_producto);
        producto.setFecha_entrada(fecha_entrada);
        producto.setCategoria_id(categoria_id);
        
        ProductoDAO guardarProducto = new ProductoDAOImplementar();
        guardarProducto.guardarPro(producto);
        
        this.listaProducto(request, response);
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
