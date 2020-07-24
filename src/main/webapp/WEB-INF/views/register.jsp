<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OrderMission | Page d'inscription</title>
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
<body class="hold-transition register-page" style="height: 100vh; width: 100vw; background-image: url('${contextPath}/resources/dist/img/fssm-bg.jpg'); background-size: cover;">
<div class="register-box">
  
  <div class="register-box-body">
  	  <div class="login-logo">
	    <a href="#"><img src="${contextPath}/resources/dist/img/logoo.png"></a>
	  </div>
    <p class="login-box-msg">Professeur inscription</p>
    <f:form  modelAttribute="userForm" method="post" action="./registration?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
		<spring:bind path="lastName">
			<div class="form-group has-feedback">
				<f:input type="text" class="form-control" path="lastName" required="required" placeholder="Votre Nom"></f:input>
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
				<f:errors path="lastName"></f:errors>
			</div>
		</spring:bind>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<spring:bind path="firstName">
			<div class="form-group has-feedback">
		        <f:input type="text" class="form-control" path="firstName" required="required" placeholder="Votre Prénom"></f:input>
		        <span class="glyphicon glyphicon-user form-control-feedback"></span>
		        <f:errors path="firstName"></f:errors>
	        </div>
     	 </spring:bind>
     	 <spring:bind path="username">
			  <div class="form-group has-feedback">
		        <f:input type="text" class="form-control" path="username" required="required" placeholder=" Votre Matricule"></f:input>
		        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
		        <f:errors path="username"></f:errors>
		      </div>
      	</spring:bind>
      	<spring:bind path="profession">
			  <div class="form-group has-feedback">
		        <f:input type="text" class="form-control" path="profession" required="required" placeholder=" Votre profession"></f:input>
		        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
		        <f:errors path="profession"></f:errors>
		      </div>
      	</spring:bind>
	    <spring:bind path="email">
			 <div class="form-group has-feedback">
			   <f:input type="email" class="form-control" path="email" required="required" placeholder="Votre Email"></f:input>
			   <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			   <f:errors path="email"></f:errors>
			 </div>
	    </spring:bind>
      <spring:bind path="password">
	      <div class="form-group has-feedback">
	        <f:input type="password" class="form-control" path="password" required="required" placeholder="Votre mot de passe"></f:input>
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	        <f:errors path="password"></f:errors>
	      </div>
      </spring:bind>
      <spring:bind path="passwordConfirm">
	      <div class="form-group has-feedback">
	        <f:input type="password" class="form-control" path="passwordConfirm" placeholder="Confirmer le mot de passe"></f:input>
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	        <f:errors path="passwordConfirm"></f:errors>
	      </div>
      </spring:bind>
      <spring:bind path="birthDate">
		  <div class="form-group has-feedback">
	        <f:input type="date" class="form-control" path="birthDate" required="required" placeholder="Date de naissance" title="Votre Date de naissance"></f:input>
	        <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
	        <f:errors path="birthDate"></f:errors>
	      </div>
      </spring:bind>
		  <div class="form-group has-feedback">
	        <input type="file" class="form-control" name="file" required="required" placeholder="Photo" title="Votre Photo"></input>
	        <span class="glyphicon glyphicon-camera form-control-feedback"></span>
	      </div>
      <spring:bind path="numCIN">
		  <div class="form-group has-feedback">
	        <f:input type="text" class="form-control" path="numCIN" required="required" placeholder="Numéro CIN" title="Votre numéro CIN"></f:input>
	        <span class="glyphicon glyphicon-paperclip form-control-feedback"></span>
	        <f:errors path="numCIN"></f:errors>
	      </div>
      </spring:bind>
      <spring:bind path="departement">
		  <div class="form-group has-feedback">
	        <f:select class="form-control select2"  path="departement" required="required" style="width: 100%;">
				<f:option selected="selected" value="">Selectionner Département</f:option>
				<c:forEach items="${missionModel.departements}" var="dep">
					<f:option value="${dep.idDep}">${dep.name}</f:option>
				</c:forEach>
            </f:select>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
			<f:errors path="departement"></f:errors>
	      </div>
      </spring:bind>
      <spring:bind path="phone">
		  <div class="form-group has-feedback">
	        <f:input type="text" class="form-control" path="phone" required="required" placeholder="Phone"></f:input>
	        <span class="glyphicon glyphicon-earphone form-control-feedback"></span>
	        <f:errors path="phone"></f:errors>
	      </div>
      </spring:bind>
      <spring:bind path="adresses">
		  <div class="form-group has-feedback">
	        <f:textarea rows="2" class="form-control" path="adresses" required="required" placeholder="Adresse"></f:textarea>
	        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
	        <f:errors path="adresses"></f:errors>
	      </div>
      </spring:bind>
      <span>${message}</span>
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
    </f:form>
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
