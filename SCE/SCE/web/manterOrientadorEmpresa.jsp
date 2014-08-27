<%-- 
    Document   : manterOrientadorEmpresa
    Created on : 09/04/2014, 16:53:21
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Orientador da Empresa</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <h1>Manter Orientador da Empresa - ${operacao}</h1>
        <hr/>
        <form action="ManterOrientadorEmpresaController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterOrientadorEmpresa" onSubmit="return validarFormulario(this)">            
            <table>
                <tr>    
                    <td>Código do orientador: </td>
                    <td><input type="text" name="txtCodOriEmp" value="${orientadorempresa.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>> </td>
                </tr>
                <tr>    
                    <td>Nome do orientador: </td>
                    <td><input type="text" name="txtNomOriEmp" value="${orientadorempresa.nome}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>> </td>
                </tr>
                <tr>
                    <td>Profissão:</td>
                    <td><input type="text" name="txtProfOriEmp" value="${orientadorempresa.profissao}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="txtTelOriEmp"value="${orientadorempresa.telefone}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
               <tr>
                    <td>Empresa:</td>
                    <td><select name="optCodEmp">
                                <c:forEach items="${empresas}" var="empresa">
                                    <option value="${empresa.codigo}" <c:if test="${orientadorempresa.empresa.codigo == empresa.codigo}"> selected</c:if>>
                                        ${empresa.nome}
                                    </option>
                                </c:forEach>
                            </select></td>
                </tr>
                
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td><input type="submit" name="btnCancelar" value = "Cancelar"></td>
                </tr>
            </table>
            
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
                if (form.txtCodOriEmp.value === ""){
                    mensagem = mensagem + "Informe o Código do Orientador da Empresa\n";
                }                             
                if (form.txtNomOriEmp.value === ""){
                    mensagem = mensagem + "Informe o nome do Orientador da Empresa\n";
                }             
                if (form.ProfOriEmp.value === ""){
                    mensagem = mensagem + "Informe a profissão do Orientador da Empresa\n";
                }
                if (form.txtTelOriEmp.value === ""){
                    mensagem = mensagem + "Informe o telefone do Orientador da Empresa\n";
                }
                if (!campoNumerico(form.txtCodOriEmp.value)){
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
