<%-- 
    Document   : manterOrientadorInstituicao
    Created on : 09/04/2014, 17:03:35
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Orientador da Instituição</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Manter Orientador da Instituição - ${operacao}</h1>
        <hr/>
        <form action="ManterOrientadorInstituicaoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterOrientadorInstituicao" onSubmit="return validarFormulario(this)">            <table>
                <tr>    
                    <td>Código do orientador: </td>
                    <td><input type="text" name="txtCodOriInst" value="${orientadorinstituicao.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>> </td>
                </tr>
                <tr>    
                    <td>Nome do orientador: </td>
                    <td><input type="text" name="txtNomOriInst" value="${orientadorinstituicao.nome}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>> </td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="txtTelOriInst" value="${orientadorinstituicao.telefone}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Curso:</td>
                    <td><select name="optCodCurso">
                                <c:forEach items="${cursos}" var="curso">
                                    <option value="${curso.codigo}" <c:if test="${orientadorinstituicao.codCurso == curso.codigo}"> selected</c:if>>
                                        ${curso.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
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
                for (i = 0; i < valor.length && ehNumero == true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) == -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtCodOriInst.value === ""){
                    mensagem = mensagem + "Informe o Código do Orientador da Instituição\n";
                }                             
                if (form.txtNomOriInst.value === ""){
                    mensagem = mensagem + "Informe o nome do Orientador da Instituição\n";
                }
                if (form.txtTelOriInst.value === ""){
                    mensagem = mensagem + "Informe o telefone do Orientador da Instituição\n";
                }
                if (!campoNumerico(form.txtCodOriInst.value)){
                    mensagem = mensagem + "Código do Orientador da Empresa deve ser numérico\n";
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
