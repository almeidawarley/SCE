<%-- 
    Document   : pesquisaOrientadorInstituicao
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
        <title>Pesquisa de Orientadores da Instituição</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Orientadores da Instituição</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código do Orientador da Instituição</th>
                <th>Nome do Orientador da Instituição</th>
                <th colspan=2>Ação</th>
            </tr>
         <c:forEach items="${orientadoresinstituicao}" var="orientadorinstituicao">
            <tr>
		<td><c:out value="${orientadorinstituicao.codigo}"/></td>
		<td><c:out value="${orientadorinstituicao.nome}"/></td>
		<td><a href="ManterOrientadorInstituicaoController?acao=prepararOperacao&operacao=Editar&codOriInst=<c:out value="${orientadorinstituicao.codigo}"/>">Editar</a></td>
		<td><a href="ManterOrientadorInstituicaoController?acao=prepararOperacao&operacao=Excluir&codOriInst=<c:out value="${orientadorinstituicao.codigo}"/>">Excluir</a></td>
            </tr>
         </c:forEach>
        </table>
        <br/>
            <form action="ManterOrientadorInstituicaoController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        
        &nbsp;&nbsp;
            <form action="index.jsp">
                <input type ="submit" name ="btnVoltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
