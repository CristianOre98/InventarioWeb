<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<!-- Para importar los datos de la clase Categoria -->
<jsp:useBean id="categoria" scope="session" class="Model.Categoria" />

<%
    String id = "";
    String nombre_cat = "";
    String estado_cat = "";
    if(request.getParameter("senal")!=null){
        /*String id = request.getParameter("id_c");
        String nombre_cat = request.getParameter("nombre_c");
        String estado_cat = request.getParameter("estado_c");*/
        id = request.getParameter("id_c");
        nombre_cat = request.getParameter("nombre_c");
        estado_cat = request.getParameter("estado_c");
    }else{
        id = String.valueOf(categoria.getId_categoria());    //Id predeterminado cero definido en el constructor
        nombre_cat = categoria.getNom_categoria();
        estado_cat = String.valueOf(categoria.getEstado_categoria());
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
           
        <h3 class="text-center font-weight-bold">Mantenimiento Categorias</h3>
        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5 bg-info">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4 "><b>Registrar Categoria</b></h3></div>
                                    <div class="card-body">
                                        <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/categorias" method="post">
                                            <input type="hidden" name="id_categoria" value="<%= id %>" >
                                            <div class="form-group">
                                                <label class="display-6 mb-1 col-3" >Nombre</label>
                                                <input class="form-control py-4"  type="text"  name="txtNomCategoria" value="<%= nombre_cat %>" required />
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="display-6 mb-1 col-3" >Estado</label>
                                                <input class="form-control py-4"  type="text"  name="txtEstadoCategoria" value="<%= estado_cat %>" required/>
                                            </div>
                                            
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
                    
                    <input type="button" class="btn btn-warning btn-lg" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')" 
                           name="btnRegresar" value="Regresar" />
                                        </form>
                                    </div>
                                    
                                </div>
                            </div>
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