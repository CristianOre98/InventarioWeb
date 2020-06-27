<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Producto"%> 
<jsp:useBean id="lista" scope="session" class="java.util.List"/>

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
            <table id="example" class="table-responsive text-center table-striped table-bordered" style="width:100%">
             <thead class="table-dark">
                <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>CORREO</th>
                <th>USUARIO</th>
                <th>CLAVE</th>
                <th>TIPO</th>
                <th>ESTADO</th>
                <th>PREGUNTA</th>
                <th>RESPUESTA</th
                <th>FECHA_REGISTRO</th>
                </tr>
             </thead>
                <%
                    for(int i = 0; i < lista.size(); i ++){
                        Producto producto = new Producto();
                        producto = (Producto)lista.get(i);
                    
                %>
                
                <tr>
                    <td><%= producto.getId_producto()%></td>
                    <td><%= producto.getNom_producto()%></td>
                    <td><%= producto.getStock()%></td>
                    <td><%= producto.getPrecio()%></td>
                    <td><%= producto.getEstado()%></td>
                    <td><%= producto.getCategoria_id()%></td>
                    <td><%= producto.getUnidadMedida()%></td>
                    <td><%= producto.getDes_producto()%></td>
                    <td><%= producto.getFecha_entrada()%></td>
                    <td>
                      <a href="<%= request.getContextPath() %>/productos?opcion=editar&&id_pro=<%= producto.getId_producto()%>&&nom_pro=<%= producto.getNom_producto()%>&&estado_pro=<%= producto.getEstado() %>&&des_pro=<%= producto.getDes_producto()%>&&stock_pro=<%= producto.getStock()%>
                    &&precio_pro=<%= producto.getPrecio()%>&&unidad_pro=<%= producto.getUnidadMedida() %>&&categoria_pro=<%= producto.getCategoria_id()%>
                    &&fecha_pro=<%= producto.getFecha_entrada()%>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
                        
                        <a href="<%= request.getContextPath() %>/productos?opcion=eliminar&&id=<%= producto.getId_producto() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>   
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            
         </div>
                </main>
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
        <script>
            $(document).ready(function() {
            $('#example').DataTable();
            } );
        </script>
    </body>
</html>