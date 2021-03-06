<%-- 
    Document   : pesquisaEstagio
    Created on : 21/05/2014, 14:42:19
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Estagios</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Estágios</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código Estágio</th>
                <th>Descrição do Estágio</th>
                <th colspan=3>Ação</th>
            </tr>
         <c:forEach items="${estagios}" var="estagio">
            <tr>
		<td><c:out value="${estagio.codigo}"/></td>
                <td><c:out value="${estagio.descricao}"/></td>
		<td><a href="ManterEstagioController?acao=prepararOperacao&operacao=Editar&codEstagio=<c:out value="${estagio.codigo}"/>">Editar</a></td>
		<td><a href="ManterEstagioController?acao=prepararOperacao&operacao=Excluir&codEstagio=<c:out value="${estagio.codigo}"/>">Excluir</a></td>
                <td><a href="ManterQuestionarioController?acao=prepararOperacao&operacao=Incluir&codEstagio=<c:out value="${estagio.codigo}"/>">Avaliar</a></td>
            </tr>
         </c:forEach>
        </table>
        <br/>
            <form action="ManterEstagioController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        &nbsp;&nbsp;
            <form action="index.jsp">
                <input type ="submit" name ="btnVoltar" value="Voltar">
            </form>
        <br/>
        ->
        <a href="PesquisaQuestionarioController">Ver todas as avaliações</a><br>
        <a href="RelatorioQuestionarioController?acao=prepararOperacao">-> Avaliações por estágio</a>
            
        </div>
    </body>
</html>
