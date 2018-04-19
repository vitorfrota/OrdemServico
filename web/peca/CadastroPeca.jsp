<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- FONTE ROBOTO -->
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
        <link rel="stylesheet" href="../assets/css/estilo.css">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/botstrap-theme.css">
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>  

        <script language="JavaScript" type="text/javascript" src="../assets/js/bootstrap.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/formata.js"></script>
        <script language="JavaScript" type="text/javascript" src="../assets/js/verifica.js"></script>
    </head>
    <body class="bg">
        <nav class="navbar navbar-inverse" style="border-radius: 0;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" style=" " data-toggle="collapse" data-target="#menu" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../index.jsp"><img src="../assets/img/logo.png"/></a>
                </div>
                <div class="collapse navbar-collapse"  id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="../os/Ordens.jsp">Ordens de Serviço</a></li>
                        <li><a href="../cliente/Clientes.jsp">Clientes</a></li>
                        <li><a href="../tecnico/Tecnicos.jsp">Técnicos</a></li>
                        <li><a href="../servico/Servicos.jsp">Serviços</a></li>
                        <li><a href="../peca/Pecas.jsp">Peças</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container form">
            <div class="page-header">
                <h1>Adicionar Peça</h1>
            </div>
            <article class="row">
                <div class="panel panel-default">
                    <form name="frm" id="frm" class="col-md-12" action="../ControllerPeca" method="post">
                        <fieldset>
                            <legend>Dados da Peça</legend>
                            <div class="form-group">
                                <label for="usr">Descrição:<span class="required">*</span></label>
                                <br>
                                <input type="text" class="form-control" id="txtdesc" name="txtdesc" placeholder="Conector DC Jack 2'5" required>
                            </div>
                            <div class="form-group">
                                <label for="">Valor:<span class="required">*</span></label>
                                <input type="text" class="form-control" id="txtvalor" name="txtvalor" maxlength="8" placeholder="30,00" required>
                            </div>

                        </fieldset>
                        <button type="submit" id="botao" name="botao" value="1" class="btn btn-primary" style="width: 100%;">Cadastrar</button>
                    </form>
                </div>
            </article>
        </div>
    </body>
</html>
