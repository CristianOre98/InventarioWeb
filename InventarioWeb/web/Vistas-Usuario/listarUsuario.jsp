<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Usuario"%> 
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROL DE INVENTARIO</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <h1>BIENVENID@!</h1>
        
            <a href="<%= request.getContextPath()%>/usuarios?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva Producto</a>
            <h3>Listado de Usuarios</h3>
            <table id="tablaUsuario" class="table-responsive text-center text-justify table-striped table-bordered" style="width:100%">
             <thead class="table-dark">
                <tr>
                <th style="text-align: center;"> N° </th>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">NOMBRE</th>
                <th style="text-align: center;">APELLIDO</th>
                <th style="text-align: center;">CORREO</th>
                <th style="text-align: center;">USUARIO</th>
                <th style="text-align: center;">CLAVE</th>
                <th style="text-align: center;">TIPO</th>
                <th style="text-align: center;">ESTADO</th>
                <th style="text-align: center;">PREGUNTA</th>
                <th style="text-align: center;">RESPUESTA</th>
                <th style="text-align: center;">ACCIONES</th>
                </tr>
             </thead>
                <tfoot class="table-dark">
                    <tr>
                <th style="text-align: center;">| N°|</th>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">NOMBRE</th>
                <th style="text-align: center;">APELLIDO</th>
                <th style="text-align: center;">CORREO</th>
                <th style="text-align: center;">USUARIO</th>
                <th style="text-align: center;">CLAVE</th>
                <th style="text-align: center;">TIPO</th>
                <th style="text-align: center;">ESTADO</th>
                <th style="text-align: center;">PREGUNTA</th>
                <th style="text-align: center;">RESPUESTA</th>
                <th style="text-align: center;">ACCIONES</th>
                </tr>
                </tfoot>
                <tbody id="employee_data">
                <%
                    for(int i = 0; i < lista.size(); i ++){
                        Usuario usuario = new Usuario();
                        usuario = (Usuario)lista.get(i);
                    
                %>
                
                <tr>
                    <td style="text-align: center;"><% out.print(i+1); %></td>
                    <td style="text-align: center;"><%= usuario.getId()%></td>
                    <td style="text-align: center;"><%= usuario.getNombre()%></td>
                    <td style="text-align: center;"><%= usuario.getApellido()%></td>
                    <td style="text-align: center;"><%= usuario.getCorreo()%></td>
                    <td style="text-align: center;"><%= usuario.getUsuario()%></td>
                    <td style="text-align: center;"><%= usuario.getClave()%></td>
                    <td style="text-align: center;"><%= usuario.getTipo()%></td>
                    <td style="text-align: center;"><%= usuario.getEstado()%></td>
                    <td style="text-align: center;"><%= usuario.getPregunta()%></td>
                    <td style="text-align: center;"><%= usuario.getRespuesta()%></td>
                    <td>
                        <a href="<%= request.getContextPath() %>/usuarios?opcion=editar&&id_usu=<%= usuario.getId()%>
                           &&nom_usu=<%= usuario.getNombre()%>&&apellido_usu=<%= usuario.getApellido()%>&&correo_usu=<%= usuario.getCorreo()%>&&usuario_usu=<%= usuario.getUsuario()%>
                        &&clave_usu=<%= usuario.getClave()%>&&tipo_usu=<%= usuario.getTipo()%>&&estado_usu=<%= usuario.getEstado()%>
                    &&pregunta_usu=<%= usuario.getUsuario()%>&&respuesta_usu=<%= usuario.getRespuesta() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
                        <a href="<%= request.getContextPath() %>/usuarios?opcion=eliminar&&id=<%= usuario.getId()%>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>   
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            
         </div>
                </main>
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
<script>
    $(document).ready(function(){
        $('#tablaUsuario').DataTable();
    });
</script>
    </body>
</html>
<%
            }
               //Aca puede ir un mensaje para informar que no se ha iniciado sesión.
            }catch(Exception e){

            }
   %>