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
        <title>Relatório dos Orientadores da Empresa</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Relatório Orientadores da Empresa</h1>
        <hr>
        <form action="RelatorioOriEmpController?acao=confirmarOperacao" 
              method="post" name="frmRelataOriEmp">
            <table>
                <tr>    
                    <td>Empresa:</td>
                    <td><select name="optCodEmpresa">
                                <c:forEach items="${empresas}" var="empresa">
                                    <option value="${empresa.codigo}">
                                        ${empresa.nome}
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
