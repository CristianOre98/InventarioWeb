<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />

<%

    String id_pro = "";
    String nom_pro = "";
    String des_pro = "";
    String precio_pro = "";
    String stock_pro = "";
    String unidad_pro = "";
    String estado_pro = "";
    String categoria_pro = "";
    String fecha_pro = "";
    
    if(request.getParameter("senal")!=null){
        id_pro = request.getParameter("id_p");
        nom_pro = request.getParameter("nom_p");
        des_pro = request.getParameter("des_p");
        precio_pro = request.getParameter("precio_p");
        stock_pro = request.getParameter("stock_p");
        unidad_pro = request.getParameter("unidad_p");
        estado_pro = request.getParameter("estado_p");
        categoria_pro = request.getParameter("categoria_p");
        fecha_pro = request.getParameter("fecha_p");


    }else{
        id_pro = String.valueOf(producto.getId_producto());    
        nom_pro = producto.getNom_producto();
        estado_pro = String.valueOf(producto.getEstado());
        precio_pro = String.valueOf(producto.getPrecio());
        stock_pro = String.valueOf(producto.getStock());
        unidad_pro = producto.getUnidadMedida();
        estado_pro = String.valueOf(producto.getEstado());
        categoria_pro = String.valueOf(producto.getCategoria_id());
        fecha_pro = producto.getFecha_entrada();
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
        <h3>Mantenimiento Categorias</h3>
        <form class="form-horizontal" id="frmCategoria" name="frmProductos" action="<%= request.getContextPath() %>/productos" method="post">
            <input type="hidden" name="txtId_producto" value="<%= id_pro %>" >
            
            <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >NOMBRE</label>
            <input class="form-control py-4"  type="text" name="txtNombreProducto" value="<%= nom_pro %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >PRECIO</label>
            <input class="form-control py-4" type="text" name="txtPrecioProducto" value="<%= precio_pro %>" required />
            </div>
            </div>
            </div>
            
            <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >STOCK</label>
            <input class="form-control py-4"  type="text" name="txtStockProducto" value="<%= stock_pro %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >MEDIDAS</label>
            <input class="form-control py-4" type="text" name="txtUnidadProducto" value="<%= unidad_pro %>" required />
            </div>
            </div>
            </div>
            
            <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >CATEGORIA</label>
            <input class="form-control py-4"  type="text" name="txtCategoriaProducto" value="<%= categoria_pro %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >ESTADO</label>
            <input class="form-control py-4" type="text" name="txtEstadoProducto" value="<%= estado_pro %>" required />
            </div>
            </div>
            </div>
            
               <div class="form-row">
             <div class="col-md-6">
             <div class="form-group">
            <label class="small mb-1" >DESCRIPCION</label>
            <input class="form-control py-4"  type="text" name="txtDescripcionProducto" value="<%= des_pro %>" required />
           </div>
              </div>
             <div class="col-md-6">
             <div class="form-group">
           <label class="small mb-1" >FECHA</label>
            <input class="form-control py-4" type="text" name="txtFechaProducto" value="<%= fecha_pro %>" required />
            </div>
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
                    <input type="button" class="btn btn-info btn-sm" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')" 
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