<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <jsp:useBean id="usuario" scope="session" class="Model.Usuario" />
<%
           try{
        HttpSession var_Session = request.getSession(false);
        String nombres = (String) var_Session.getAttribute("sessionNombres");
        String user = (String) var_Session.getAttribute("sessionUsuario");
        String tipo = (String) var_Session.getAttribute("sessionTipo");
        String correo = (String) var_Session.getAttribute("sessionEmail");
 
        if(user == null){
            out.print("<center><h2><font color='blue'>Debe de haber iniciado Sesion para poder ingresar a esta pagina.</font><br><hr><font color='blue'>Intentelo de Nuevo</font><hr><h2></center><br>");
            out.print("<center><h2><font color='blue'> Por Favor Epere...</font><hr><h2></center>");
            //out.print("<meta http-equiv='refresh' content='4; url=http:sesion'/ >");
            //out.print("<meta http-equiv='refresh' content='4; url=http:./'/ >");
            response.sendRedirect("./");
        }else if(user!=null){
%>

<!DOCTYPE html>
<%
    String id_usu = "";
    String nombre_usu = "";
    String apellido_usu = "";
                String correo_usu = "";
                String usuario_usu = "";
                String clave_usu = "";
                String tipo_usu = "";              
                String estado_usu = "";
                String pregunta_usu = "";
                String respuesta_usu = "";
                String fecha_registro_usu = "";
    if(request.getParameter("senal")!=null){
        id_usu  = request.getParameter("id_u");
        nombre_usu = request.getParameter("nombre_u");
        apellido_usu = request.getParameter("apellido_u");
       correo_usu = request.getParameter("correo_u");
       usuario_usu = request.getParameter("usuario_u");
       clave_usu = request.getParameter("clave_u");
       tipo_usu = request.getParameter("tipo_u");
       estado_usu = request.getParameter("estado_u");
       pregunta_usu = request.getParameter("pregunta_u");
       respuesta_usu = request.getParameter("respuesta_u");
      
    }else{
        id_usu = String.valueOf(usuario.getId());    
        nombre_usu = usuario.getNombre();
       apellido_usu = usuario.getApellido();
        correo_usu = usuario.getCorreo();
         usuario_usu = usuario.getUsuario();
         clave_usu = usuario.getClave();
          tipo_usu  = String.valueOf(usuario.getTipo());
           estado_usu = String.valueOf(usuario.getEstado());
           pregunta_usu = String.valueOf(usuario.getPregunta());
             respuesta_usu = String.valueOf(usuario.getRespuesta());
             
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
        <script type="text/javascript">
            //Función para el botón regresar.
            function regresar(url){
                location.href = url;
            }
        </script>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
           
        
        <div class="estilo_consulta">     
        <h3>Mantenimiento Usuario</h3>
        <form class="form-horizontal" name="frmUsuarios" action="<%= request.getContextPath() %>/usuarios" method="post">
            <input type="hidden" name="txtId" value="<%= id_usu %>" >
            
            <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >NOMBRE</label>
            <input class="form-control py-4"  type="text" name="txtNombreUsuario" value="<%= nombre_usu %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >APELLIDO</label>
            <input class="form-control py-4" type="text" name="txtApellidoUsuario" value="<%= apellido_usu %>" required />
            </div>
            </div>
            </div>
            
            <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >CORREO</label>
            <input class="form-control py-4"  type="text" name="txtCorreoUsuario" value="<%= correo_usu %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >USUARIO</label>
            <input class="form-control py-4" type="text" name="txtUsuario" value="<%= usuario_usu %>" required />
            </div>
            </div>
            </div>
            
            <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
                 
            <label class="small mb-1" >CLAVE</label>
         <input class="form-control py-4" type="text" name="txtClaveUsuario" value="<%= clave_usu %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >TIPO</label>
            <input class="form-control py-4" type="text" name="txtTipoUsuario" value="<%= tipo_usu %>" required />
            </div>
            </div>
            </div>
            
               <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >ESTADO</label>
            <input class="form-control py-4"  type="text" name="txtEstadoUsuario" value="<%= estado_usu %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >PREGUNTA</label>
           <input class="form-control py-4" type="text" name="txtPreguntaUsuario" value="<%= pregunta_usu %>" required />
            </div>
            </div>
            </div>
            <div class="form-row">
             <div class="col-md-6 float-left">
             <div class="form-group">
            <label class="small mb-1" >RESPUESTA</label>
            <input class="form-control py-4"  type="text" name="txtRespuestaUsuario" value="<%= respuesta_usu %>" required />
           </div>
              </div>
             
            </div>
            
          
               
                
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                       <%
                        if(request.getParameter("senal")!=null){
                    %>
                    <input type="submit" class="btn btn-success btn-lg" name="btnModificar" value="Actualizar" />
                    <%
                        }else{   
                    %>    
                    <input type="submit" class="btn btn-success btn-lg" name="btnGuardar" value="Guardar" />
                    <%
                        }  
                    %> 
                    
                    <input type="button" class="btn btn-warning btn-lg" onclick="regresar('<%= request.getContextPath() %>/usuarios?opcion=listar')" 
                           name="btnRegresar" value="Regresar" />
                </div>
            </div>   
        </form>
      </div>
    </div>
</main>
        
         <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
         
    </body>
</html>
<%
            }
               //Aca puede ir un mensaje para informar que no se ha iniciado sesión.
            }catch(Exception e){

            }
   %>