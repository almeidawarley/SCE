<%-- 
    Document   : manterVaga
    Created on : 19/11/2014, 14:40:36
    Author     : Aluno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Vagas</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Manter Vagas - ${operacao}</h1>
        <hr/>
        <form action="ManterVagaController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterVaga" onSubmit = "return validarFormulario(this)">
            <table>
                <tr>    
                    <td>Código da Vaga: </td>
                    <td><input type="text" name="txtCodVaga" value="${vaga.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>> </td>
                </tr>
                <tr>
                    <td>Curso:</td>
                    <td><select name="optCodCurso">
                                <c:forEach items="${cursos}" var="curso">
                                    <option value="${curso.codigo}" <c:if test="${vaga.codCurso == curso.codigo}"> selected</c:if> >
                                        ${curso.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
                <tr>
                    <td>Empresa:</td>
                    <td><select name="optCodEmp">
                                <c:forEach items="${empresas}" var="empresa">
                                    <option value="${empresa.codigo}" <c:if test="${vaga.codEmpresa == empresa.codigo}"> selected</c:if> >
                                        ${empresa.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
                <tr>
                    <td>Preenchida:</td>
                    <td><select name="optPreen"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            <option value=1 <c:if test="${vaga.preenchido == 1}"> selected</c:if>>Sim</option>
                            <option value=0 <c:if test="${vaga.preenchido == 0}"> selected</c:if>>Não</option>
                        </select></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td>&nbsp;<a href="index.jsp">Cancelar</a></td>
                </tr>
            </table>
        </div>    
        </form>
    </body>
</html>
