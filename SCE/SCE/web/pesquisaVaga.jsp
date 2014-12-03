<%-- 
    Document   : pesquisaVaga
    Created on : 19/11/2014, 18:16:10
    Author     : Warley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Vagas</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Vagas</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código da Vaga</th>
                <th>Curso da Vaga</th>
                <th colspan=3>Ação</th>
            </tr>
         <c:forEach items="${vagas}" var="vaga">
            <tr>
		<td><c:out value="${vaga.codigo}"/></td>
                <td><c:out value="${vaga.codCurso}"/></td>
		<td><a href="ManterVagaController?acao=prepararOperacao&operacao=Editar&codVaga=<c:out value="${vaga.codigo}"/>">Editar</a></td>
		<td><a href="ManterVagaController?acao=prepararOperacao&operacao=Excluir&codVaga=<c:out value="${vaga.codigo}"/>">Excluir</a></td>            </tr>
         </c:forEach>
        </table>
        <br/>
            <form action="ManterVagaController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        &nbsp;&nbsp;
            <form action="index.jsp">
                <input type ="submit" name ="btnVoltar" value="Voltar">
            </form>
        <br/>  
        </div>
    </body>
</html>