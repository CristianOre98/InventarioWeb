<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />

<%
    String id_pro = "";
    String nombre_pro = "";
    String estado_pro = "";
    String precio_pro = "";
    if(request.getParameter("senal")!=null){
        id_pro = request.getParameter("id_p");
        nombre_pro = request.getParameter("nombre_p");
        estado_pro = request.getParameter("estado_p");
        precio_pro = request.getParameter("precio_p");
    }else{
        id_pro = String.valueOf(producto.getId_producto());    
        nombre_pro = producto.getNom_producto();
        estado_pro = String.valueOf(producto.getEstado());
        precio_pro = String.valueOf(producto.getPrecio());
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css.jspf" %>
        
        <script type="text/javascript">
            //Función para el botón regresar.
            function regresar(url){
                location.href = url;
            }
        </script>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
           
        <h3>Mantenimiento Productos</h3>
        <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/categorias" method="post">
            <input type="hidden" name="id_p" value="<%= id_pro %>" >
            
            <div class="form-group">
                <label for="txtNomProducto" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtNomProducto" value="<%= nombre_pro %>" required>
                </div>
            </div>
                
           <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= estado_pro %>" required>
                </div>
            </div>
                
                 <div class="form-group">
                <label for="txtPrecioProducto" class="col-sm-2 control-label">Precio:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtPrecioProducto" value="<%= precio_pro %>" required>
                </div>
            </div>
                
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                        if(request.getParameter("senal")!=null){
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnModificar" value="Actualizar" />
                    <%
                        }else{   
                    %>    
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" />
                    <%
                        }  
                    %> 
                    <input type="button" class="btn btn-info btn-sm" onclick="regresar('<%= request.getContextPath() %>/producto?opcion=listar')" 
                           name="btnRegresar" value="Regresar" />
                </div>
            </div>   
        </form>

         <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
