<%@page import="java.sql.ResultSet"%>
<%@page import="Model.Producto"%>
<%@page import="Model.Categoria"%>
<%@page import="Factory.ConexionBD"%>
<%@page import="Factory.FactoryConexionBD"%>
<%@page import="DAO.ProductoDAOImplementar"%>
<jsp:useBean id="cn" class="DAO.CategoriaDAOImplementar" scope="page"></jsp:useBean>
    <jsp:useBean id="producto" scope="session" class="Model.Producto" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
       
        <div class="col-lg-10">
         <div class="card shadow-lg border-0 rounded-lg  bg-info">
          <div class="card-header"><h3 class="text-center font-weight-light my-4 "><b>Registrar Producto</b></h3></div>
          <div class="card-body">
        <form class="form-horizontal" name="frmProductos" action="<%= request.getContextPath() %>/productos" method="post">
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
        <select class="form-control" name="txtCategoriaProducto" required>
               
            
            <%
            ResultSet rs = cn.mostrarCategoria();
                    while(rs.next()){   
                %>
                <option value="<%=rs.getString("id_categoria")%>"><%=rs.getString("nom_categoria")%></option>
           <%
                    }       
           %>
    </select>
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
           <%
           Producto p = new Producto();
           fecha_pro = p.fecha();
           %>
           <input class="form-control py-4" type="text" name="txtFechaProducto" value="<%= fecha_pro %>" readonly />
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
                    
                    <input type="button" class="btn btn-warning btn-lg" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')" 
                           name="btnRegresar" value="Regresar" />
                </div>
            </div>   
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