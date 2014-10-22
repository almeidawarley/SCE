<%-- 
    Document   : pesquisaOrientadorEmpresa
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
        <title>Pesquisa de Orientadores da Empresa</title>
    <a href="pesquisaOrientadorEmpresa.jsp"></a>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Orientadores da Empresa</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código do Orientador da Empresa</th>
                <th>Nome do Orientador da Empresa</th>
                <th colspan=2>Ação</th>
            </tr>
         <c:forEach items="${orientadoresempresa}" var="orientadorempresa">
            <tr>
		<td><c:out value="${orientadorempresa.codigo}"/></td>
		<td><c:out value="${orientadorempresa.nome}"/></td>
		<td><a href="ManterOrientadorEmpresaController?acao=prepararOperacao&operacao=Editar&codOriEmp=<c:out value="${orientadorempresa.codigo}"/>">Editar</a></td>
		<td><a href="ManterOrientadorEmpresaController?acao=prepararOperacao&operacao=Excluir&codOriEmp=<c:out value="${orientadorempresa.codigo}"/>">Excluir</a></td>
            </tr>
         </c:forEach>
        </table>
            <form action="ManterOrientadorEmpresaController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
