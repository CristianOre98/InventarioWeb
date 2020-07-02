<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Producto"%> 
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
        
            <a href="<%= request.getContextPath()%>/productos?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva Producto</a>
            <h3>Listado de Productos</h3>
            <table id="tablaProducto" class="table-responsive text-center table-striped table-bordered" style="width:100%">
             <thead class="table-dark">
                <tr>
                <th style="text-align: center;">N°</th>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">NOMBRE</th>
                <th style="text-align: center;">STOCK</th>
                <th style="text-align: center;">PRECIO</th>
                <th style="text-align: center;">ESTADO</th>
                <th style="text-align: center;">CATEGORIA</th>
                <th style="text-align: center;">MEDIDA</th>
                <th style="text-align: center;">DESCRIPCION</th>
                <th style="text-align: center;">FECHA ENTRADA</th>
                <th style="text-align: center;">ACCIONES</th>
                </tr>
             </thead>
             <tfoot class="table-dark">
                <th style="text-align: center;">| N° |</th>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">NOMBRE</th>
                <th style="text-align: center;">STOCK</th>
                <th style="text-align: center;">PRECIO</th>
                <th style="text-align: center;">ESTADO</th>
                <th style="text-align: center;">CATEGORIA</th>
                <th style="text-align: center;">MEDIDA</th>
                <th style="text-align: center;">DESCRIPCION</th>
                <th style="text-align: center;">FECHA ENTRADA</th>
                <th style="text-align: center;">ACCIONES</th>
             </tfoot>
             <tbody id="employee_data">
                <%
                    for(int i = 0; i < lista.size(); i ++){
                        Producto producto = new Producto();
                        producto = (Producto)lista.get(i);
                    
                %>
                
                <tr>
                    <td style="text-align: center;"><% out.print(i+1); %></td>
                    <td style="text-align: center;"><%= producto.getId_producto()%></td>
                    <td style="text-align: center;"><%= producto.getNom_producto()%></td>
                    <td style="text-align: center;"><%= producto.getStock()%></td>
                    <td style="text-align: center;"><%= producto.getPrecio()%></td>
                    <td style="text-align: center;"><%= producto.getEstado()%></td>
                    <td style="text-align: center;"><%= producto.getCategoria_id()%></td>
                    <td style="text-align: center;"><%= producto.getUnidadMedida()%></td>
                    <td style="text-align: center;"><%= producto.getDes_producto()%></td>
                    <td style="text-align: center;"><%= producto.getFecha_entrada()%></td>
                    <td style="text-align: center;">
                      <a href="<%= request.getContextPath() %>/productos?opcion=editar&&id_pro=<%= producto.getId_producto()%>&&nom_pro=<%= producto.getNom_producto()%>&&estado_pro=<%= producto.getEstado() %>&&des_pro=<%= producto.getDes_producto()%>&&stock_pro=<%= producto.getStock()%>
                    &&precio_pro=<%= producto.getPrecio()%>&&unidad_pro=<%= producto.getUnidadMedida() %>&&categoria_pro=<%= producto.getCategoria_id()%>
                    &&fecha_pro=<%= producto.getFecha_entrada()%>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
                        
                        <a href="<%= request.getContextPath() %>/productos?opcion=eliminar&&id=<%= producto.getId_producto() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>   
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
        $('#tablaProducto').DataTable();
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