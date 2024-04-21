<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicacion gention de usuarios</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
     <header>
         <nav class= "navbar navbar-expand-md navbar-dark">
              <div>
                   <a href="#" class="navbar-brand">Gestion de usarios</a>
              </div>
              <ul class="navbar-nav">
                   <li><a href="<%= request.getContextPath() %>/list " class="nav-link">Usuarios</a></li>
              </ul>
         </nav>
     </header>
     
     <div class="row">
           <!-- <div class="alert alert-success" *ngif='message'>{message}></div> -->
           
           <div class="container">
                <h3 class="text-center">Listado de usuarios</h3>
                <hr>
                <div class="container text-left">
                      <a href="<%= request.getContextPath() %>/new" class="btn btn-success">Agregar Nuevo Usuario</a>
                </div>
                <br>
                <table class="table table-bordered">
                     <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Pais</th>
                            <th>Acciones</th>
                        </tr>
                     </thead>
                     <tbody>
                          <!-- for(Todo todo: todos) { -->
                          <c:forEach var="usuario" items="${listUsuarios}">
                                 <tr>
                             <td>
                                 <c:out value="${usuario.id}"/>
                             </td>
                             <td>
                                 <c:out value="${usuario.nombre}"/>
                             </td>
                             <td>
                                 <c:out value="${usuario.email}"/>
                             </td>
                             <td>
                                 <c:out value="${usuario.pais}"/>
                             </td>
                             <td><a href="edit?id=<c:out value='${usario.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                 <a href="delete?id=<c:out value='${usuario.id}' />">Eliminar</a></td>
                          </tr>
                          </c:forEach>
                          <!-- } -->     
                     </tbody>
                </table>
           </div>
     </div>
</body>
</html>