<%-- 
    Document   : manterQuestionario
    Created on : 16/04/2014, 15:23:47
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avaliar Estágio</title>
    </head>
    <body>
        <div id="container">
        <h1>Manter Questionário - ${operacao}</h1>
        <hr/>
        <form action="" method="post" name="frmManterAluno">
            <table>
                <tr>    
                    <td>Código: </td>
                    <td><input type="text" name="txtCodQuest"> </td>
                </tr>
                <tr>
                    <td>Código do Estágio:</td>
                    <td><select name="optCodEstagio">
                            <option value="teste1">54612</option>
                            <option value="teste2">46531</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Digite uma nota de 0 a 10:</td>
                </tr>
                <tr>    
                    <td>Frequência: </td>
                    <td><input type="text" name="txtFreqQuest"> </td>
                </tr>
                <tr>
                    <td>Dedicação:</td>
                    <td><input type="text" name="txtDedQuest"</td>
                </tr>
                <tr>
                    <td>Interesse:</td>
                    <td><input type="text" name="txtIntQuest"</td>
                </tr>
                <tr>
                    <td>Avaliação Geral:</td>
                    <td><input type="text" name="txtAvalQuest"</td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value = "Confirmar"></td>
                    <td><input type="submit" name="btnCancelar" value = "Cancelar"></td>
                </tr>
            </table>
        </div>
    </body>
</html>
