<%-- 
    Document   : manterEstagio
    Created on : 09/04/2014, 17:07:31
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Estágio</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Manter Estágio - ${operacao}</h1>
        <hr/>
        <form action="ManterEstagioController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterEstagio" onSubmit = "return validarFormulario(this)">
            <table>
                <tr>    
                    <td>Código do Estágio: </td>
                    <td><input type="text" name="txtCodEst" value="${estagio.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>> </td>
                </tr>
                <tr>
                    <td>Aluno:</td>
                    <td><select name="optCodAluno">
                                <c:forEach items="${alunos}" var="aluno">
                                    <option value="${aluno.codigo}" <c:if test="${estagio.codAluno == aluno.codigo}"> selected</c:if> >
                                        ${aluno.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
                <tr>
                    <td>Empresa:</td>
                    <td><select name="optCodEmp">
                                <c:forEach items="${empresas}" var="empresa">
                                    <option value="${empresa.codigo}" <c:if test="${estagio.codEmpresa == empresa.codigo}"> selected</c:if> >
                                        ${empresa.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
               <tr>
                    <td>Orientador da Empresa:</td>
                    <td><select name="optCodOriEmp">
                                <c:forEach items="${orientadorempresas}" var="orientadorempresa">
                                    <option value="${orientadorempresa.codigo}" <c:if test="${estagio.codOrientadorEmpresa == orientadorempresa.codigo}"> selected</c:if> >
                                        ${orientadorempresa.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
               <tr>
                    <td>Orientador da Instituição:</td>
                    <td><select name="optCodOriInst">
                                <c:forEach items="${orientadorinstituicaos}" var="orientadorinstituicao">
                                    <option value="${orientadorinstituicao.codigo}" <c:if test="${estagio.codOrientadorInstituicao == orientadorinstituicao.codigo}"> selected</c:if> >
                                        ${orientadorinstituicao.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
                
                <tr>
                    <td>Descrição:</td>
                    <td><input type="text" name="txtDescEst" value="${estagio.descricao}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Remuneração:</td>
                    <td><input type="text" name="txtRemEst" value="${estagio.remuneracao}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Carga Horária:</td>
                    <td><input type="text" name="txtCHorariaEst" value="${estagio.cargaHoraria}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Data de início:</td>
                    <td><input type="text" name="txtDtInEst" value="${estagio.dataInicio}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Data de término:</td>
                    <td><input type="text" name="txtDtTermEst" value="${estagio.dataTermino}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td>&nbsp;<a href="index.jsp">Cancelar</a></td>
                </tr>
            </table>
        </div>    
        </form>
        <SCRIPT language="JavaScript">
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero === true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) === -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtCodEstagio.value === ""){
                    mensagem = mensagem + "Informe o Código do Estagio\n";
                }                             
                if (form.txtDescEst.value === ""){
                    mensagem = mensagem + "Informe a descrição do Estágio\n";
                }             
                if (form.txtRemEst.value === ""){
                    mensagem = mensagem + "Informe a remuneração do Estágio\n";
                }
                if (form.txtCHorariaEst.value === ""){
                    mensagem = mensagem + "Informe a carga horária do Estágio\n";
                }
                if (form.txtDtInEst.value === ""){
                    mensagem = mensagem + "Informe a data de início do Estágio\n";
                }
                if (form.txtDtTerEst.value === ""){
                    mensagem = mensagem + "Informe a data de término do Estágio\n";
                } 
                if (!campoNumerico(form.txtCodEstagio.value)){
                    mensagem = mensagem + "Código do Estágio deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCHorariaEst.value)){
                    mensagem = mensagem + "Carga Horária do Estágio deve ser numérico\n";
                }
                if (!campoNumerico(form.txtRemEst.value)){
                    mensagem = mensagem + "Remuneração do Estágio deve ser numérico\n";
                }
                if (mensagem === ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>
    </body>
</html>
