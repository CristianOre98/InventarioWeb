
package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDaoImplementar;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;


public class Usuarios extends HttpServlet {

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
    protected void listaUsuario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Instancia a categoria DAO
        UsuarioDAO usuario = new UsuarioDaoImplementar();  
        //crear instacia de session; true para iniciar session
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", usuario.listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
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
            String pagina = "/Vistas-Usuario/crearUsuario.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        }else if(parametro.equals("listar")){
            this.listaUsuario(request, response);
        }else if(parametro.equals("editar")){
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            
            int id = Integer.parseInt(request.getParameter("id_usu").replaceAll("\\s*$",""));
            
            String nombre = request.getParameter("nom_usu");
            String apellido = request.getParameter("apellido_usu");
            String correo = request.getParameter("correo_usu");
            String usuario = request.getParameter("usuario_usu");
            String clave = request.getParameter("clave_usu");
            
            int tipo = Integer.parseInt(request.getParameter("tipo_usu").replaceAll("\\s*$",""));
            int estado = Integer.parseInt(request.getParameter("estado_usu").replaceAll("\\s*$",""));
            String pregunta = request.getParameter("pregunta_usu");
            String respuesta = request.getParameter("respuesta_usu");
           
     
         
	
    	
        	
                String pagina = "/Vistas-Usuario/crearUsuario.jsp?id_u="+id+"&&nombre_u="
                    +nombre+"&&apellido_u="+apellido+"&&correo_u="+correo+"&&usuario_u="+usuario+
                    "&&clave_u="+clave+"&&tipo_u="+tipo+"&&estado_u="+estado+
                    "&&pregunta_u="+pregunta+"&&respuesta_u="+respuesta+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
    	
            
           
           
            
            
        }else if(parametro.equals("eliminar")){
            int Usuario_id = Integer.parseInt(request.getParameter("id").trim());
            UsuarioDAO usuario = new UsuarioDaoImplementar();
            usuario.borrarUsu(Usuario_id);    
            this.listaUsuario(request, response);
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
        
            
                
             Usuario usuario = new Usuario();
             
        //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        
         int id = Integer.parseInt(request.getParameter("txtId").trim());
            String nombre = request.getParameter("txtNombreUsuario");
            String apellido = request.getParameter("txtApellidoUsuario");
            String correo = request.getParameter("txtCorreoUsuario");
            String usuari = request.getParameter("txtUsuario");
           //incriptando la clave md5
            String clave = request.getParameter("txtClaveUsuario");
            String claveMD5=DigestUtils.md5Hex(clave); 
            int tipo = Integer.parseInt(request.getParameter("txtTipoUsuario").trim());
            int estado = Integer.parseInt(request.getParameter("txtEstadoUsuario").trim());
            String preguntas = request.getParameter("txtPreguntaUsuario");
            String respuesta = request.getParameter("txtRespuestaUsuario");
        
                usuario.setId(id);
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setCorreo(correo);
                usuario.setUsuario(usuari);
                usuario.setClave(claveMD5);
                usuario.setTipo(tipo);
                usuario.setEstado(estado);
                usuario.setPregunta(preguntas);
                usuario.setRespuesta(respuesta);
        
        
        UsuarioDAO guardarUsuario = new UsuarioDaoImplementar();
        guardarUsuario.guardarUsu(usuario);
        
        this.listaUsuario(request, response);
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
