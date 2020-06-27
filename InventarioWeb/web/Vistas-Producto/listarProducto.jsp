<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Producto"%> 
<jsp:useBean id="lista" scope="session" class="java.util.List"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROL DE INVENTARIO</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <h1>BIENVENID@!</h1>
        <div style="width: 600px;">
            <a href="<%= request.getContextPath()%>/producto?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva Producto</a>
            <h3>Listado de Productos</h3>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>ESTADO</th>
                    <th>PRECIO</th>
                    <th>ACCION</th>
                </tr>
                <%
                    for(int i = 0; i < lista.size(); i ++){
                        Producto producto = new Producto ();
                        producto = (Producto)lista.get(i);
                    
                %>
                <tr>
                    <td><%= producto.getId_producto()%></td>
                    <td><%= producto.getNom_producto()%></td>
                    <td><%= producto.getEstado()%></td>
                     <td><%= producto.getPrecio()%></td>
                    <td>
                      <a href="<%= request.getContextPath() %>/producto?opcion=modificar&&id_pro=<%= producto.getId_producto() %>&&nombre_pro=<%= producto.getNom_producto() %>&&estado_pro=<%= producto.getEstado() %>&&precio_pro=<%= producto.getPrecio() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
                        
                        <a href="<%= request.getContextPath() %>/producto?opcion=eliminar&&id=<%= producto.getId_producto() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>   
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            
        </div>
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
