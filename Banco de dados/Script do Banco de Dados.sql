

CREATE TABLE tbCurso (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(40) NULL,
  cargaHoraria INTEGER UNSIGNED NULL,
  obrigatoriedade BOOL NULL,
  PRIMARY KEY(codigo)
);

CREATE TABLE tbAluno (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbCurso_codigo INTEGER UNSIGNED NOT NULL,
  logradouro VARCHAR(50) NULL,
  numero VARCHAR(10) NULL,
  complemento VARCHAR(30) NULL,
  bairro VARCHAR(30) NULL,
  cidade VARCHAR(30) NULL,
  uf VARCHAR(2) NULL,
  PRIMARY KEY(codigo),
  FOREIGN KEY(tbCurso_codigo)
	REFERENCES tbCurso(codigo)
);

CREATE TABLE tbEmpresa (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  telefone VARCHAR(12) NULL,
  logradouro VARCHAR(20) NULL,
  numero VARCHAR(10) NULL,
  complemento VARCHAR(30) NULL,
  bairro VARCHAR(30) NULL,
  cidade VARCHAR(30) NULL,
  uf VARCHAR(2) NULL,
  cnpj VARCHAR(20) NULL,
  PRIMARY KEY(codigo)
);



CREATE TABLE tbOrientadorInstituicao (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbCurso_codigo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(codigo),
  FOREIGN KEY(tbCurso_codigo)
	REFERENCES tbCurso(codigo)
);

CREATE TABLE tbPessoa (
  codigo INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(30) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  PRIMARY KEY(codigo)
);
CREATE TABLE tbOrientadorEmpresa (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbEmpresa_codigo INTEGER UNSIGNED NOT NULL,
  profissao VARCHAR(20) NULL,
  PRIMARY KEY(codigo),
  FOREIGN KEY(tbEmpresa_codigo)
	REFERENCES tbEmpresa(codigo)
);
CREATE TABLE tbEstagio (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbEmpresa_codigo INTEGER UNSIGNED NOT NULL,
  tbAluno_codigo INTEGER UNSIGNED NOT NULL,
  tbOrientadorEmpresa_codigo INTEGER UNSIGNED NOT NULL,
  tbOrientadorInstituicao_codigo INTEGER UNSIGNED NOT NULL,
  cargaHoraria INTEGER UNSIGNED NULL,
  descricao VARCHAR(300) NULL,
  remuneracao FLOAT NULL,
  dataInicio DATE NULL,
  dataTermino DATE NULL,
  PRIMARY KEY(codigo),
  FOREIGN KEY(tbEmpresa_codigo)
	REFERENCES tbEmpresa(codigo),
  FOREIGN KEY(tbAluno_codigo)
	REFERENCES tbAluno(codigo),
  FOREIGN KEY(tbOrientadorEmpresa_codigo)
	REFERENCES tbOrientadorEmpresa(codigo),
  FOREIGN KEY(tbOrientadorInstituicao_codigo)
	REFERENCES tbOrientadorInstituicao(codigo)
	
);



CREATE TABLE tbQuestionario (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tbEstagio_codigo INTEGER UNSIGNED NOT NULL,
  frequencia INTEGER UNSIGNED NULL,
  dedicacao INTEGER UNSIGNED NULL,
  interesse INTEGER UNSIGNED NULL,
  avaliacaoGeral INTEGER UNSIGNED NULL,
  PRIMARY KEY(codigo),
   FOREIGN KEY(tbEstagio_codigo)
	REFERENCES tbEstagio(codigo)
);

CREATE TABLE tbVaga(
	codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
	tbCurso_codigo INTEGER UNSIGNED NOT NULL,
	tbEmpresa_codigo INTEGER UNSIGNED NOT NULL,
	preenchido TINYINT UNSIGNED NULL,
	
	PRIMARY KEY(codigo),
	FOREIGN KEY(tbCurso_codigo)
		REFERENCES tbCurso(codigo),
	FOREIGN KEY(tbEmpresa_codigo)
		REFERENCES tbEmpresa(codigo)
)