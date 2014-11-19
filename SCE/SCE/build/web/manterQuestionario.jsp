<%-- 
    Document   : manterQuestionario
    Created on : 16/04/2014, 15:23:47
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avaliar Estágio</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Manter Questionário - ${operacao}</h1>
        <hr/>
        <form action="ManterQuestionarioController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterAluno"  onSubmit = "return validarFormulario(this)">
            <table>
                <tr>    
                    <td>Código: </td>
                    <td><input type="text" name="txtCodQuest" value="${questionario.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>> </td>
                </tr>
                <tr>
                    <td>Código do Estágio:</td>
                    <td><select name="optCodEstagio">
                            <c:forEach items="${estagios}" var="estagio">
                                    <option value="${estagio.codigo}" <c:if test="${operacao == 'Incluir'}"><c:if test="${estagio.codigo == codestagio}"> selected</c:if></c:if> 
                                                                      <c:if test="${operacao != 'Incluir'}">  <c:if test="${estagio.codigo == questionario.codEstagio}"> selected</c:if></c:if>>
                                        ${estagio.codigo}
                                    </option>
                                </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Digite uma nota de 0 a 10:</td>
                </tr>
                <tr>    
                    <td>Frequência: </td>
                    <td><input type="text" name="txtFreqQuest" value="${questionario.frequencia}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>> </td>
                </tr>
                <tr>
                    <td>Dedicação:</td>
                    <td><input type="text" name="txtDedQuest" value="${questionario.dedicacao}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Interesse:</td>
                    <td><input type="text" name="txtIntQuest" value="${questionario.interesse}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Avaliação Geral:</td>
                    <td><input type="text" name="txtAvalQuest" value="${questionario.avaliacaoGeral}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td><input type="submit" name="btnCancelar" value = "Cancelar"></td>
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
                if (form.txtCodQuest.value === ""){
                    mensagem = mensagem + "Informe o Código do Questionario\n";
                }                             
                if (form.txtFreqQuest.value === ""){
                    mensagem = mensagem + "Informe a Frequência do estagiário\n";
                }             
                if (form.txtDedQuest.value === ""){
                    mensagem = mensagem + "Informe a Dedicação\n";
                }
                if (form.txtIntQuest.value === ""){
                    mensagem = mensagem + "Informe o Interesse do estagiário\n";
                }
                if (form.txtAvalQuest.value === ""){
                    mensagem = mensagem + "Informe a Avaliação Geral do estágio\n";
                }
                
                if (!campoNumerico(form.txtCodQuest.value)){
                    mensagem = mensagem + "Codigo deve ser numérico\n";
                }
                if (!campoNumerico(form.txtFreqQuest.value)){
                    mensagem = mensagem + "Frequência deve ser numérico\n";
                }
                if (!campoNumerico(form.txtDedQuest.value)){
                    mensagem = mensagem + "Dedicação deve ser numérico\n";
                }
                if (!campoNumerico(form.txtIntQuest.value)){
                    mensagem = mensagem + "Interesse deve ser numérico\n";
                }
                if (!campoNumerico(form.txtAvalQuest.value)){
                    mensagem = mensagem + "Avaliacao Geral deve ser numérico\n";
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
