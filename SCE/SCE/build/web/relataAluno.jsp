<%-- 
    Document   : relataAluno
    Created on : 24/09/2014, 16:47:37
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Aluno</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Relatório Aluno</h1>
        <hr>
        <form action="RelatorioAlunoController?acao=confirmarOperacao" 
              method="post" name="frmRelataAluno">
            <table>
                <tr>    
                    <td>Curso:</td>
                    <td><select name="optCodCurso">
                                <c:forEach items="${cursos}" var="curso">
                                    <option value="${curso.codigo}">
                                        ${curso.nome}
                                    </option>
                                </c:forEach>
                                    
                                    
                            </select></td>
                </tr>
               
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td>&nbsp;<a href="index.jsp">Cancelar</a></td>
                </tr>
            </table>
         
        </form>
        </div>
    </body>
</html>
