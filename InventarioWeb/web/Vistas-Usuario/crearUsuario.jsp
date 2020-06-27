<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />

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
       fecha_registro_usu = request.getParameter("fecha_registro_u");
    }else{
        id_usu = String.valueOf(producto.getId_producto());    
        nombre_usu = producto.getNom_producto();
       apellido_usu = String.valueOf(producto.getEstado());
        correo_usu = String.valueOf(producto.getPrecio());
         usuario_usu = String.valueOf(producto.getPrecio());
          tipo_usu  = String.valueOf(producto.getPrecio());
           estado_usu = String.valueOf(producto.getPrecio());
           pregunta_usu = String.valueOf(producto.getPrecio());
             respuesta_usu = String.valueOf(producto.getPrecio());
             fecha_registro_usu = String.valueOf(producto.getPrecio());
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
            <input type="hidden" name="id_p" value="<%= id_usu %>" >
            
            <div class="form-group">
                <label for="txtNomProducto" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtNomProducto" value="<%= nombre_usu %>" required>
                </div>
            </div>
                
           <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">APELLIDO:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= apellido_usu %>" required>
                </div>
            </div>
                
                 <div class="form-group">
                <label for="txtPrecioProducto" class="col-sm-2 control-label">CORREO:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtPrecioProducto" value="<%= correo_usu %>" required>
                </div>
            </div>
                
                <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">USUARIO:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= usuario_usu %>" required>
                </div>
            </div>
                
                <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">CLAVE:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= clave_usu %>" required>
                </div>
            </div>
                
                <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">TIPO:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= tipo_usu %>" required>
                </div>
            </div>
                
                <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= estado_usu %>" required>
                </div>
            </div>
                
                 <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">PREGUNTA:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= pregunta_usu %>" required>
                </div>
            </div>
                 <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">RESPUESTA:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= respuesta_usu %>" required>
                </div>
            </div>
                 <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">FECHA_REGISTRO:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= fecha_registro_usu %>" required>
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