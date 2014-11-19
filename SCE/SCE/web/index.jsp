<%-- 
    Document   : index
    Created on : 09/04/2014, 16:17:13
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Início</title>
        <link rel="stylesheet" type= "text/css" href="style.css" />
    </head>
    <body>
        <div id="container">
            <h1 align="center"> Página Inicial</font> </h1>
            <hr/>
            
            <div id="manters">

            <h3><a href="PesquisaCursoController"> Manter Curso </a><br/></h3>
            <h3><a href="PesquisaAlunoController"> Manter Aluno </a><br/></h3>
            <h3><a href="PesquisaEmpresaController"> Manter Empresa </a><br/></h3>
            <h3><a href="PesquisaOrientadorEmpresaController"> Manter Orientador da Empresa </a><br/></h3>
            <h3><a href="PesquisaOrientadorInstituicaoController"> Manter Orientador da Instituição</a><br/></h3>
            <h3><a href="PesquisaEstagioController"> Manter Estágio </a><br/></h3>
            <h3><a href="PesquisaVagaController"> Manter Vaga</a><br/></h3>

            </div>
            
            <div id="relatorio">
            <h3><a href="RelatorioCursoController"> Relatório Curso </a><br/></h3>
            <h3><a href="RelatorioAlunoController?acao=prepararOperacao"> Relatório Aluno </a><br/></h3>
            <h3><a href="RelatorioEmpresaController"> Relatório Empresa </a><br/></h3>
            <h3><a href="RelatorioOriEmpController?acao=prepararOperacao"> Relatório Orientador da Empresa </a><br/></h3>
            <h3><a href="RelatorioOriInstController?acao=prepararOperacao"> Relatório Orientador da Instituição </a><br/></h3>
            <h3><a href="RelatorioEstagioController?acao=prepararOperacao"> Relatório Estágio </a><br/></h3>
            
            </div>
        </div>
    </body>
</html>
