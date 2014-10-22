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
        <title>Relatório de Estágio</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Relatório de Estágios</h1>
        <hr>
        <form action="RelatorioEstagioController?acao=confirmarOperacao" 
              method="post" name="frmRelataOriEmp">
            <table>
               <tr>    
                    <td>Aluno:</td>
                    <td><select name="optCodAluno">
                                <c:forEach items="${alunos}" var="aluno">
                                    <option value="${aluno.codigo}">
                                        ${aluno.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
               
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td><input type="submit" name="btnCancelar" value = "Cancelar"></td>
                </tr>
            </table>
         
        </form>
        <hr>
        <form action="RelatorioEstagioController?acao=confirmarOperacao" method="post">
            <table>
                <tr>
                    <td> Ou procure por matrícula do aluno: <input type="text" name="optCodAluno"> </td>
                    <td><input type="submit" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
