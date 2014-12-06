<%-- 
    Document   : relataVaga
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
        <title>Relatório de Avaliações</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Relatório Avaliação</h1>
        <hr>
        <form action="RelatorioQuestionarioController?acao=confirmarOperacao" 
              method="post" name="frmRelataAluno">
            <table>
                <tr>    
                    <td>Estágio:</td>
                    <td><select name="optCodEstagio">
                                <c:forEach items="${estagios}" var="estagio">
                                    <option value="${estagio.codigo}">
                                        ${estagio.descricao}
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
