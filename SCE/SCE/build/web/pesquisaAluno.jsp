<%-- 
    Document   : pesquisaAluno
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
        <title>Pesquisa de Alunos</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Pesquisa de Alunos</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Código Aluno</th>
                <th>Nome do Aluno</th>
                <th colspan=2>Ação</th>
            </tr>
         <c:forEach items="${alunos}" var="aluno">
            <tr>
		<td><c:out value="${aluno.codigo}"/></td>
		<td><c:out value="${aluno.nome}"/></td>
		<td><a href="ManterAlunoController?acao=prepararOperacao&operacao=Editar&codAluno=<c:out value="${aluno.codigo}"/>">Editar</a></td>
		<td><a href="ManterAlunoController?acao=prepararOperacao&operacao=Excluir&codAluno=<c:out value="${aluno.codigo}"/>">Excluir</a></td>
            </tr>
         </c:forEach>
        </table>
            <form action="ManterAlunoController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </div>
    </body>
</html>
