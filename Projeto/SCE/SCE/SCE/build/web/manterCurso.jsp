<%-- 
    Document   : manterCurso
    Created on : 09/04/2014, 16:19:00
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Curso</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
        <h1>Manter Curso - ${operacao}</h1>
           <hr/>
        <form action="ManterCursoController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="frmManterCurso" onSubmit = "return validarFormulario(this)">
            <table>
                <tr>    
                    <td>Código do curso: </td>
                    <td><input type="text" name="txtCodCurso" value="${curso.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if> > </td>
                </tr>
                <tr>    
                    <td>Nome do curso: </td>
                    <td><input type="text" name="txtNomCurso" value="${curso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>
                </tr>
                <tr>
                    <td>Carga Horária:</td>
                    <td><input type="text" name="txtCargaHoraria" value="${curso.cargaHoraria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Obrigatoriedade:</td>
                    <td><select name="optObrig"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                            <option value=1 <c:if test="${curso.obrigatoriedade == 1}"> selected</c:if>>Sim</option>
                            <option value=0 <c:if test="${curso.obrigatoriedade == 0}"> selected</c:if>>Não</option>
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
                if (form.txtCodCurso.value === ""){
                    mensagem = mensagem + "Informe o Código do Curso\n";
                }                             
                if (form.txtNomCurso.value === ""){
                    mensagem = mensagem + "Informe o Nome do Curso\n";
                }             
                if (form.txtCargaHoraria.value === ""){
                    mensagem = mensagem + "Informe a Carga Horaria\n";
                }                  
               
                if (!campoNumerico(form.txtCodCurso.value)){
                    mensagem = mensagem + "Codigo do Curso deve ser numérico\n";
                }                  
                
                if (!campoNumerico(form.txtCargaHoraria.value)){
                    mensagem = mensagem + "Carga Horaria deve ser numérico\n";
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
