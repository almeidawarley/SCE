<%-- 
    Document   : pesquisaQuestionario
    Created on : 31/10/2014, 10:18:20
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Avaliações</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Avaliações</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código Avaliação</th>
                <th>Código do Estágio</th>
                <th>Avaliação Geral</th>
                <th colspan=2>Ação</th>
            </tr>
         <c:forEach items="${questionarios}" var="questionario">
            <tr>
		<td><c:out value="${questionario.codigo}"/></td>
		<td><c:out value="${questionario.codEstagio}"/></td>
                <td><c:out value="${questionario.avaliacaoGeral}"/></td>
		<td><a href="ManterQuestionarioController?acao=prepararOperacao&operacao=Editar&codQuestionario=<c:out value="${questionario.codigo}"/>">Editar</a></td>
		<td><a href="ManterQuestionarioController?acao=prepararOperacao&operacao=Excluir&codQuestionario=<c:out value="${questionario.codigo}"/>">Excluir</a></td>
            </tr>
         </c:forEach>
        </table>
        <br/>
            <form action="ManterQuestionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        &nbsp;&nbsp;
            <form action="PesquisaEstagioController">
                <input type ="submit" name ="btnVoltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
