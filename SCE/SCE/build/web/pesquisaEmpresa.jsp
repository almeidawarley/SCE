<%-- 
    Document   : pesquisaEmpresa
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
        <title>Pesquisa de Empresas</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Empresas</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código Empresa</th>
                <th>Nome do Empresa</th>
                <th colspan=2>Ação</th>
            </tr>
         <c:forEach items="${empresas}" var="empresa">
            <tr>
		<td><c:out value="${empresa.codigo}"/></td>
		<td><c:out value="${empresa.nome}"/></td>
		<td><a href="ManterEmpresaController?acao=prepararOperacao&operacao=Editar&codEmpresa=<c:out value="${empresa.codigo}"/>">Editar</a></td>
		<td><a href="ManterEmpresaController?acao=prepararOperacao&operacao=Excluir&codEmpresa=<c:out value="${empresa.codigo}"/>">Excluir</a></td>
            </tr>
         </c:forEach>
        </table>
            <form action="ManterEmpresaController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
