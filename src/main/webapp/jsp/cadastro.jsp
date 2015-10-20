<!DOCTYPE html>
<html lang="pt-br">
<head>
	<title>Cadastro</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Carregar css-->

	<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../css/estilo.css">

	<!-- Carregar scripts-->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="../javascript/jquery.tubular.1.0.js"></script>
	<script src="../javascript/javascript.js"></script>

</head>
<body class="deadPool2">
	<div>
		<div class="container nav-justified">
			<a href="index.html"><h1 class="text-center textoBranco">Social Movies</h1></a>
			<br>    
			<ul class="nav nav-tabs navbar-static-top" id="menuNav">
				<li class="active"><a data-toggle="tab" href="#inicio" id="home">Início</a></li>
				<li><a data-toggle="tab" href="#generos">Gêneros</a></li>
				<li><a data-toggle="tab" href="#login">Login</a></li>
				<li><a data-toggle="tab" href="#cadastro">Cadastre-se</a></li>
				<li class="flutuarADireita"><a data-toggle="tab" href="#buscar">Buscar</a></li>
			</ul>

			<div class="tab-content">
				<div id="inicio" class="tab-pane text-center fade in active">
					<br><br><br><br>
					<div class="">
						<h3>SUA REDE SOCIAL</h3>
						<p>Aqui você compartilha todas suas opniões sobre os filmes favoritos ou não com o mundo.</p>
						<br><br><br><br>
						<button class="btn-link text-uppercase botaoMedio"><a data-toggle="tab" href="#cadastro" id="btCadastro">Cadastre-se agora</a></button>
					</div>
				</div>
				<div id="generos" class="tab-pane fade text-center">
					<br>
					<h3>Categorias</h3>
					<p>Selecione a categoria do filme.</p>
					<br><br>
					<div class="generosTexto brancoOpaco">
						<ul class="menuNavegacao">
							<li><a href="#action">Ação</a></li>
							<li><a href="#action">Aventura</a></li>
							<li><a href="#action">Animação</a></li>
							<li><a href="#action">Comédia</a></li>
							<li><a href="#action">Clássico</a></li>
							<li><a href="#action">Documentário</a></li>
							<li><a href="#action">Drama</a></li>
							<li><a href="#action">Ficção Científica</a></li>
							<li><a href="#action">Musical</a></li>
							<li><a href="#action">Romance</a></li>
							<li><a href="#action">Terror</a></li>
							<li><a href="#action">Suspense</a></li>
						</ul>
					</div>
				</div>
				<div id="login" class="tab-pane fade text-center">
					<br>
					<h3>Faça seu login</h3>
					<p>Preencha com seus dados</p>
					<div class="form-group">
						<form class="container" action="#" method="post">
                                                    <input class="botaoMedio margin-top" type="email" name="emailLogin" placeholder="Email" value="${sessionScope.emailCadastro}"> <br>
							<input class="botaoMedio margin-top" type="password" name="senhaLogin" placeholder="Senha"><br><br><br>
							<input class="botaoPequeno" type="submit" value="Logar">
						</form>
					</div>
				</div>
				<div id="cadastro" class="tab-pane fade text-center">
					<br>
					<h3>Cadastro</h3>
					<p>Informe seus dados.</p>
					<div class="form-group">
                                            <form class="container" action="cadastro.jsp" method="post">
							<img src="../imagens/user.png" alt="fotoDoPerfil"><br>
							<input class="botaoMedio margin-top" type="text" name="nomeCompleto" placeholder="Nome Completo"> <br>
							<input class="botaoMedio margin-top" type="email" name="emailCadastro" placeholder="Email"> <br>
							<input class="botaoMedio margin-top" type="password" name="senhaCadastro" placeholder="Senha"><br>
							<input class="botaoMedio margin-top" type="text" name="apelido" placeholder="Apelido"> <br>
							<input class="botaoMedio margin-top" type="text" name="estado" placeholder="Estado"> <br>
							<input class="botaoMedio margin-top" type="text" name="cidade" placeholder="Cidade"> <br>
							<input class="botaoMedio margin-top" type="date" name="dataDeNascimento"> <br><br><br>
							<input class="botaoPequeno" type="submit" value="Cadastrar">
						</form>
					</div>
				</div>
				<div id="buscar" class="tab-pane fade text-center">
					<br>
					<h3>Buscar</h3>
					<p>Digite sua busca.</p><br><br><br>
					<div>
						<input class="botaoMedio" type="text" name="busca" placeholder="Buscar">
						<input class="botaoPequeno" type="submit" value="Search">
					</div>
				</div>
			</div>
		</div>
	</body>
	</html>