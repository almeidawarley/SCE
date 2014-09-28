<%-- 
    Document   : relataAluno
    Created on : 24/09/2014, 16:47:37
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Relatório Aluno</h1>
        <form action="RelatorioAlunoController" 
              method="post" name="frmRelataAluno">
            <table>
                <tr>    
                    <td>Código do curso: </td>
                    <td><input type="text" name="txtCodCurso"> </td>
                </tr>
               
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td><input type="submit" name="btnCancelar" value = "Cancelar"></td>
                </tr>
            </table>
         
        </form>
    </body>
</html>
