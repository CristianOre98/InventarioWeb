
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
<html>
    <head>
        <title>Control de Inventario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Incluimos la vista parcial la cual contiene las url de las librerias 
             correspondientes a estilos y js
        -->
        <%@include file="WEB-INF/Vistas-Parciales/css-js.jspf" %>
         
    </head>
    <body>
        <%@include file="WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <!-- Vistar parciales de la parte superior de nuestra aplicación -->
       
        
             <!-- Todo el contenido de la aplicación -->
             <h1 class="text-center tex-primary">Informacion de los Creadores.</h1>
             <div class="row">
            <div class="col-sm-6">
              <div class="card" style="width: 20rem; ">
                   <img class="card-img-top img-fluid" src="./img/Cristian.jpg" alt="Card image cap" style="max-height: 18rem">
              <div class="card-body">
              <h5 class="card-title">Cristian Vladimir Orellana Orellana 186319</h5>
              <p class="card-text">Scrum master <br>
                  <b>Grupo: </b>Sistemas 21. <br>
                  <b>Escuela de estudio: </b>Computación <br>
                  <b>Modulo: </b>Aplicación de metodologías agiles y testeo de software.
              </p>
              
              
              </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card" style="width: 20rem; ">
                  <img class="card-img-top img-fluid" src="./img/AdonisHD.jpg" alt="Card image cap" style="max-height: 18rem" >
              <div class="card-body">
              <h5 class="card-title">Adonis Alejandro Marin Bautista</h5>
              <p class="card-text">Back end <br>
                      <b>Grupo: </b>Sistemas 21. <br>
                  <b>Escuela de estudio: </b>Computación <br>
                  <b>Modulo: </b>Aplicación de metodologías agiles y testeo de software.
              </p>
              
              </div>
              </div>
            </div>
          </div>
             <br>
              <div class="row">
            <div class="col-sm-6">
              <div class="card" style="width: 20rem; ">
                  <img class="card-img-top img-fluid" src="./img/Douglas.jpg" alt="Card image cap" style="max-height: 18rem">
              <div class="card-body">
              <h5 class="card-title">Douglas Josue Ayala Cordoba 184119</h5>
              <p class="card-text">Analista<br>
                      <b>Grupo: </b>Sistemas 21. <br>
                  <b>Escuela de estudio: </b>Computación <br>
                  <b>Modulo: </b>Aplicación de metodologías agiles y testeo de software.
              </p>
              
              </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card" style="width: 20rem; ">
                  <img class="card-img-top img-fluid" src="./img/Chino.jpeg" alt="Card image cap" style="max-height: 18rem">
              <div class="card-body">
              <h5 class="card-title">Brayan Isaac Nalasco Ramirez </h5>
              <p class="card-text">Front end<br>
                      <b>Grupo: </b>Sistemas 21. <br>
                  <b>Escuela de estudio: </b>Computación <br>
                  <b>Modulo: </b>Aplicación de metodologías agiles y testeo de software.
              </p>
              
              </div>
              </div>
            </div>
          </div>
        
        </div>
</main>
         
        <!-- Vistar parciales de la parte inferior de nuestra aplicación -->
        <%@include file="WEB-INF/Vistas-Parciales/pie.jspf" %>
       
  
    </body>
</html>
<%
            }
               //Aca puede ir un mensaje para informar que no se ha iniciado sesión.
            }catch(Exception e){

            }
   %>
