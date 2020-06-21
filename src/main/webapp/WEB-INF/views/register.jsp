<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Big Sale | Registration Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="index2.html"><b>Order</b> Mission</a>
  </div>
  <div class="register-box-body">
    <p class="login-box-msg">Professeur inscription</p>
    <form action="starter.html" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" required="true" placeholder="Votre Nom">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
	   <div class="form-group has-feedback">
        <input type="text" class="form-control" required="true" placeholder="Votre Prénom">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
	  <div class="form-group has-feedback">
        <input type="text" class="form-control" required="true" placeholder=" Votre Matricule">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" required="true" placeholder="Votre Email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" required="true" placeholder="Votre mot de passe">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Reécrir mot de passe">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
	  <div class="form-group has-feedback">
        <input type="date" class="form-control" required="true" placeholder="Date de naissance" title="Votre Date de naissance">
        <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
      </div>
	  <div class="form-group has-feedback">
        <input type="file" class="form-control" required="true" placeholder="Photo" title="Votre Photo">
        <span class="glyphicon glyphicon-camera form-control-feedback"></span>
      </div>
	  <div class="form-group has-feedback">
        <input type="file" class="form-control" required="true" placeholder="CIN" title="Votre CIN">
        <span class="glyphicon glyphicon-paperclip form-control-feedback"></span>
      </div>
	  <div class="form-group has-feedback">
        <select class="form-control" required="true" placeholder="Departement">
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
			<option value="" selected >Votre departement</option>
			<option value="Informatique">Informatique</option>
			<option value="Informatique">Physique</option>
		</select>
      </div>
	  <div class="form-group has-feedback">
        <input type="text" class="form-control" required="true" placeholder="Phone">
        <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
      </div>
	  <div class="form-group has-feedback">
        <textarea type="textarea" rows="2" class="form-control" required="true" placeholder="Adresse"></textarea>
        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> J'accepte les <a href="#">terms & conditions</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Demande d'inscription</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <!--<div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
        Google+</a>
    </div>-->

    <a href="login.html" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
