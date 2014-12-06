<%-- 
    Document   : manterAluno
    Created on : 09/04/2014, 16:35:28
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Aluno</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />

    </head>
    <body>
        <div id="container">
            <h1>Manter Aluno - ${operacao}</h1>
            <hr/>
            <form action="ManterAlunoController?acao=confirmarOperacao&operacao=${operacao}" 
                  method="post" name="frmManterAluno" onSubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td>Código do aluno:</td> 
                        <td><input type="text" name="txtCodAluno" value="${aluno.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> ></td>
                    </tr>
                    <tr>
                        <td>Nome do aluno:</td> 
                        <td><input type="text" name="txtNomAluno" value="${aluno.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Telefone do aluno:</td> 
                        <td><input type="text" name="txtTelAluno" value="${aluno.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Endereço</td> 
                    </tr>
                    <tr>
                        <td>Logradouro:</td> 
                        <td><input type="text" name="txtLogEndAluno" value="${aluno.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Número:</td> 
                        <td><input type="text" name="txtNumEndAluno" value="${aluno.numero}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Complemento:</td> 
                        <td><input type="text" name="txtCompEndAluno" value="${aluno.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                  <tr>
                        <td>Bairro:</td> 
                        <td><input type="text" name="txtBairroEndAluno" value="${aluno.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Cidade:</td> 
                        <td><input type="text" name="txtCidEndAluno" value="${aluno.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>UF:</td> 
                        <td><input type="text" name="txtUfEndAluno" value="${aluno.uf}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>></td>
                    </tr>

                    <tr>
                        <td>Curso:</td>
                        <td><select name="optCodCurso">
                                    <c:forEach items="${cursos}" var="curso">
                                        <option value="${curso.codigo}" <c:if test="${aluno.curso.codigo == curso.codigo}"> selected</c:if>>
                                            ${curso.nome}
                                        </option>
                                    </c:forEach>
                                </select></td>
                    </tr>

                    <tr>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
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
                if (form.txtCodAluno.value == ""){
                    mensagem = mensagem + "Informe o Código do Aluno\n";
                }                             
                if (form.txtNomeAluno.value == ""){
                    mensagem = mensagem + "Informe o Nome do Aluno\n";
                }             
                if (form.txtTelAluno.value == ""){
                    mensagem = mensagem + "Informe o Telefone do Aluno\n";
                }                  
                if (form.txtLogEndAluno.value == ""){
                    mensagem = mensagem + "Informe o Logradouro do Aluno\n";
                }
                if (form.txtNumEndAluno.value == ""){
                    mensagem = mensagem + "Informe o Número de endereço do Aluno\n";
                } 
                if (form.txtBairroEndAluno.value == ""){
                    mensagem = mensagem + "Informe o Bairro do Aluno\n";
                } 
                if (form.txtCidEndAluno.value == ""){
                    mensagem = mensagem + "Informe a Cidade do Aluno\n";
                } 
                if (form.txtUfEndAluno.value == ""){
                    mensagem = mensagem + "Informe o Estado do Aluno\n";
                } 
                if (!campoNumerico(form.txtCodAluno.value)){
                    mensagem = mensagem + "Código do Aluno deve ser numérico\n";
                }                  
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>        
         
    </body>
</html>
