<%-- 
    Document   : CursoInfo
    Created on : 9/04/2021, 01:35:18 PM
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./CursoInfo" method="POST">
            <table>
                <tr>
                    <td>Codigo curso</td>
                    <td><input type="text" name="codigoCurso" value="${curso.codigoCurso}" /></td>
                </tr>
              
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${curso.nombre}" /></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${curso.descripcion}" /></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        
                    </td>
                </tr>
            </table>
        </form>
        <br>
      
    </body>
</html>
