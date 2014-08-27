<%-- 
    Document   : pesquisaCurso
    Created on : 21/05/2014, 14:02:31
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Cursos</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <h1>Pesquisa de Cursos</h1>
        <table border="1">
            <tr>
                <th>Código Curso</th>
                <th>Nome do Curso</th>
                <th colspan=2>Ação</th>
            </tr>
         <c:forEach items="${cursos}" var="curso">
            <tr>
		<td><c:out value="${curso.codigo}"/></td>
		<td><c:out value="${curso.nome}"/></td>
		<td><a href="ManterCursoController?acao=prepararOperacao&operacao=Editar&codCurso=<c:out value="${curso.codigo}"/>">Editar</a></td>
		<td><a href="ManterCursoController?acao=prepararOperacao&operacao=Excluir&codCurso=<c:out value="${curso.codigo}"/>">Excluir</a></td>
            </tr>
         </c:forEach>
        </table>
            <form action="ManterCursoController?acao=prepararOperacao&operacao=Incluir" method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
    </body>
</html>
