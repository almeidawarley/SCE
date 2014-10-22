<%-- 
    Document   : manterEmpresa
    Created on : 09/04/2014, 16:44:58
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Empresa</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Manter Empresa - ${operacao}</h1>
        <hr/>
        <form action="ManterEmpresaController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterEmpresa" onSubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código da empresa:</td> 
                    <td><input type="text" name="txtCodEmpresa" value="${empresa.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Nome da empresa:</td> 
                    <td><input type="text" name="txtNomEmpresa" value="${empresa.nome}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Telefone da empresa:</td> 
                    <td><input type="text" name="txtTelEmpresa" value="${empresa.telefone}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>CNPJ:</td>
                    <td><input type="text" name="txtCNPJEmpresa" value="${empresa.cnpj}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Endereço</td> 
                </tr>
                <tr>
                    <td>Logradouro:</td> 
                    <td><input type="text" name="txtLogEndEmpresa" value="${empresa.logradouro}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Número:</td> 
                    <td><input type="text" name="txtNumEndEmpresa" value="${empresa.numero}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Complemento:</td> 
                    <td><input type="text" name="txtCompEndEmpresa" value="${empresa.complemento}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
              <tr>
                    <td>Bairro:</td> 
                    <td><input type="text" name="txtBairroEndEmpresa" value="${empresa.bairro}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>Cidade:</td> 
                    <td><input type="text" name="txtCidEndEmpresa" value="${empresa.cidade}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                <tr>
                    <td>UF:</td> 
                    <td><input type="text" name="txtUfEndEmpresa" value="${empresa.uf}" <c:if test="${operacao == 'Excluir '}"> readonly </c:if>></td>
                </tr>
                
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
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
                if (form.txtCodEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Código da Empresa\n";
                }                             
                if (form.txtNomEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Nome da Empresa\n";
                }             
                if (form.txtTelEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Telefone da Empresa\n";
                }
                if (form.txtCNPJEmpresa.value === ""){
                    mensagem = mensagem + "Informe o CNPJ da Empresa\n";
                }
                if (form.txtLogEndEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Logradouro da Empresa\n";
                }
                if (form.txtNumEndEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Número de endereço da Empresa\n";
                } 
                if (form.txtBairroEndEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Bairro da Empresa\n";
                } 
                if (form.txtCidEndEmpresa.value === ""){
                    mensagem = mensagem + "Informe a Cidade da Empresa\n";
                } 
                if (form.txtUfEndEmpresa.value === ""){
                    mensagem = mensagem + "Informe o Estado da Empresa\n";
                } 
                if (!campoNumerico(form.txtCodEmpresa.value)){
                    mensagem = mensagem + "Código da Empresa deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCNPJEmpresa.value)){
                    mensagem = mensagem + "CNPJ da Empresa deve ser numérico\n";
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
