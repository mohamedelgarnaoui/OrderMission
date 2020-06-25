<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Big Sale | Registration Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="index2.html"><b>Order</b> Mission</a>
  </div>
  <div class="register-box-body">
    <p class="login-box-msg">Professeur inscription</p>
    <form action="starter.html" method="post">
		<spring:bind path="lastName">
			<div class="form-group has-feedback">
				<f:input type="text" class="form-control" path="lastName" required="required" placeholder="Votre Nom"></f:input>
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
		</spring:bind>
		<spring:bind path="firstName">
			<div class="form-group has-feedback">
		        <input type="text" class="form-control" name="firstName" required="required" placeholder="Votre PrÃ©nom">
		        <span class="glyphicon glyphicon-user form-control-feedback"></span>
	        </div>
     	 </spring:bind>
     	 <spring:bind path="usrename">
			  <div class="form-group has-feedback">
		        <input type="text" class="form-control" name="usrename" required="required" placeholder=" Votre Matricule">
		        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
		      </div>
      	</spring:bind>
	      <spring:bind path="email">
		      <div class="form-group has-feedback">
		        <input type="email" class="form-control" name="email" required="required" placeholder="Votre Email">
		        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		      </div>
	      </spring:bind>
      <spring:bind path="password">
	      <div class="form-group has-feedback">
	        <input type="password" class="form-control" name="password" required="required" placeholder="Votre mot de passe">
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="passwordConfirm">
	      <div class="form-group has-feedback">
	        <input type="password" class="form-control" name="passwordConfirm" placeholder="Confirmer le mot de passe">
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="birthDate">
		  <div class="form-group has-feedback">
	        <input type="date" class="form-control" name="birthDate" required="required" placeholder="Date de naissance" title="Votre Date de naissance">
	        <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="photo">
		  <div class="form-group has-feedback">
	        <input type="file" class="form-control" name="photo" required="required" placeholder="Photo" title="Votre Photo">
	        <span class="glyphicon glyphicon-camera form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="numCIN">
		  <div class="form-group has-feedback">
	        <input type="text" class="form-control" name="numCIN" required="required" placeholder="Numéro CIN" title="Votre numéro CIN">
	        <span class="glyphicon glyphicon-paperclip form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="departement">
		  <div class="form-group has-feedback">
	        <select class="form-control" name="departement" required="required" >
				<option value="" selected >Votre departement</option>
				<option value="Informatique">Informatique</option>
				<option value="Informatique">Physique</option>
			</select>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="phone">
		  <div class="form-group has-feedback">
	        <input type="text" class="form-control" name="phone" required="required" placeholder="Phone">
	        <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
	      </div>
      </spring:bind>
      <spring:bind path="adresses">
		  <div class="form-group has-feedback">
	        <textarea rows="2" class="form-control" name="adresses" required="required" placeholder="Adresse"></textarea>
	        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
	      </div>
      </spring:bind>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> J'accepte les <a href="#">terms and conditions</a>
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
    <a href="${contextPath}/login" class="text-center">J'ai dèja un compte</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
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
