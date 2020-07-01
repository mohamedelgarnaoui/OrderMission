<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OrderMission | Profil</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
   <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/datepicker/datepicker3.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/colorpicker/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/skin-blue.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<header class="main-header">
    <!-- Logo -->
    <a href="./index" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>O</b>M</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Order</b> Mission</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${pageContext.request.contextPath}/resources/images/${missionModel.image}" class="user-image" alt="User Image">
              <span class="hidden-xs">${missionModel.prof.firstName} ${missionModel.prof.lastName}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="${pageContext.request.contextPath}/resources/images/${missionModel.image}" class="img-circle" alt="User Image">

                <p>
                 ${missionModel.prof.firstName} ${missionModel.prof.lastName} <br>
                  ${missionModel.prof.profession}
                  <small>Membre depuis  ${missionModel.prof.dateCreation}</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
	                <form id="logoutForm" method="POST" action="./login?logout">
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        </form>
                  	<a href="#" onclick="document.forms['logoutForm'].submit()" class="btn btn-default btn-flat">Se deconnecté</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/images/${missionModel.image}" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${missionModel.prof.firstName} ${missionModel.prof.lastName}</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Connecté</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li>
          <a href="./index">
            <i class="fa fa-dashboard"></i> <span>Tableau de Bord</span>
          </a>
          
        </li>
        <sec:authorize access="hasAuthority('ADMIN')">
	        <li>
	          <a href="#">
	            <i class="fa fa-th"></i> <span>Professeurs</span>
	            <span class="pull-right-container">
	            <i class="fa fa-angle-left pull-right"></i>
	            </span>
	          </a>
	          <ul class="treeview-menu">
	            <li><a href="./professor"><i class="fa fa-circle-o"></i> Tous les Professeurs</a></li>
	            <li><a href="./addProfessor"><i class="fa fa-circle-o"></i> Ajouter professeur</a></li>
	          </ul>
	        </li>
        </sec:authorize>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-th"></i> <span> Missions</span>
            <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="active treeview-menu">
			<li ><a href="./mission"><i class="fa fa-circle-o"></i>Tous les missions</a></li>
			<li class="active"><a href="./addMission"><i class="fa fa-circle-o"></i>Ajouter mission</a></li>
          </ul>
        </li>
        <!--<sec:authorize access="hasAuthority('ADMIN')">
	        <li class="treeview">
	          <a href="#">
	            <i class="fa fa-table"></i> <span> Département</span>
	            <span class="pull-right-container">
	            <i class="fa fa-angle-left pull-right"></i>
	            </span>
	          </a>
	          <ul class="treeview-menu">
	            <li><a href="data3.html"><i class="fa fa-circle-o"></i>Toutes les départements</a></li>
	            <li><a href="#"><i class="fa fa-circle-o"></i>Ajouter département</a></li>
	          </ul>
	        </li>
        </sec:authorize>
        <li>
          <a href="calendar.html">
            <i class="fa fa-calendar"></i> <span> Calendrier</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-red">3</small>
            </span>
          </a>
        </li>-->
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
   <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Mission
        <small>Ajouter Mission</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
        <li><a href="#">Mission</a></li>
        <li class="active">Ajouter Mission</li>
      </ol>
    </section>

   <!-- Main content -->
    <section class="content">
        <!-- SELECT2 EXAMPLE -->
      <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Ajouter Mission</h3>
          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <f:form modelAttribute="missionModel" action="./addMission?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	        <div class="box-body">
	          <div class="row">
	            <div class="col-md-6">
					<!-- text input -->
	                <div class="form-group" style="display: ${!missionModel.isupdate ? 'none' : ''}">
	                  <label>Id mission :</label>
	                  <f:input type="text" path="idMission" required="required" class="form-control" disabled="true"></f:input>
	                </div>
	                <div class="form-group">
	                  <label>Sujet de la mission :</label>
	                  <f:input type="text" path="subject" required="required" class="form-control" placeholder="Entrer le sujet de votre Mission"></f:input>
	                </div>
	              <div class="input-group ${messagev != null ? 'has-success' : ''}">
	                <label>Destination :</label>
	                <f:select class="form-control select2" path="destination" required="required" style="width: 100%;">
	                  <f:option selected="selected" value="" >selectionner votre destination</f:option>
	                  <c:forEach items="${missionModel.villes}" var="v">
							<f:option value="${v.idVille}">${v.name}</f:option>
					  </c:forEach>
	                </f:select>
	                <span>${messagev}</span>
					<br/>
					<p style="height: 15px;"></p>
					 <span class="input-group-btn">
						<button type="button" class="btn btn-info btn-flat" data-toggle="modal" data-target="#myModalVille">Ajouter une !</button>
					  </span>					  
	              </div>
				  <div class="input-group ${messaged != null ? 'has-success' : ''}">
	                <label>Département :</label>
	                <f:select class="form-control select2"  path="departement" required="required" style="width: 100%;">
						<f:option selected="selected" value="">selectionner votre Département</f:option>
						<c:forEach items="${missionModel.departements}" var="dep">
							<f:option value="${dep.idDep}">${dep.name}</f:option>
						</c:forEach>
	                </f:select>
					<br/>
					<p style="height: 15px;"></p>
					 <span class="input-group-btn">
						<button type="button" class="btn btn-info btn-flat" data-toggle="modal" data-target="#myModalDep">Ajouter une !</button>
					  </span>
					  <span>${messaged}</span>
	              </div>
				  <div class="form-group">
	                <label>Moyen de transport :</label>
	                <f:select class="form-control select2" multiple="multiple"  path="moyenTrans" required="required" data-placeholder="choisissez vos moyens de transport" style="width: 100%;">
	                  <f:option value="">choisissez vos moyens de transport</f:option>
	                  <c:forEach items="${missionModel.transports}" var="trs">
							<f:option value="${trs.idTransport}">${trs.typeTransport}</f:option>
						</c:forEach>
	                </f:select>
	              </div>
	              <!-- /.form-group -->
	            </div>
	            <!-- /.col -->
	            <div class="col-md-6">
				  <!-- Date and time range -->
	              <div class="form-group">
	                <label>Date d'aller et de retour :</label>
	                <div class="input-group">
	                  <div class="input-group-addon">
	                    <i class="fa fa-clock-o"></i>
	                  </div>
	                  <f:input type="text"  path="departureTime" required="required" class="form-control pull-right" id="reservationtime"></f:input>
	                </div>
	                <!-- /.input group -->
	              </div>
				   <!-- Date -->
	              <div class="form-group">
	                <label>Date d'expiration :</label>
	                <div class="input-group date">
	                  <div class="input-group-addon">
	                    <i class="fa fa-calendar"></i>
	                  </div>
	                  <f:input type="text" path="expiryDate" class="form-control pull-right" required="required" id="datepicker"></f:input>
	                </div>
	                <!-- /.input group -->
	              </div>
				   <div class="form-group ${message != null ? 'has-error' : ''}">
	                  <label for="exampleInputFile">Votre Justification :</label>
	                  <input type="file" required="required" name="justif" id="exampleInputFile"></input>
	                  <p class="help-block">
	                  <span>${message}</span>
	                  </p>
	               </div>
	               <div class="form-group">
	                	<label>Commentaire :</label>
	                  	<f:textarea path="comment" cols="2" class="form-control" placeholder="Entrer un commentaire"></f:textarea>
	               </div>
	               
	               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	              <!-- /.form-group -->
	            </div>
	            <!-- /.col -->
	          </div>
	          <!-- /.row -->
	      
	        </div>
	        <!-- /.box-body -->
	        <div class="box-footer">
				<button type="reset" class="btn btn-default">Réinistialiser</button>
	            <button type="submit" class="btn btn-primary">Ajouter mission</button>
	        </div>
        </f:form>
      
      </div>
      
      <!-- /.row -->
    </section>
	<div class="modal fade" id="myModalDep" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title text-center" id="gridSystemModalLabel">Ajouter Département</h4>
			  </div>
			  <f:form modelAttribute="missionModel" action="./addDepartement" method="post">
				  <div class="modal-body">
					<div class="form-group">
					  <label>Nom du departement :</label>
					  <f:input type="text"  path="departementName" class="form-control" placeholder="Entrer nom département"></f:input>
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</div>
				  </div>
				  <div class="modal-footer">
					<button type="reset" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save changes</button>
				  </div>
			  </f:form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<div class="modal fade" id="myModalVille" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title text-center" id="gridSystemModalLabel">Ajouter Ville</h4>
			  </div>
			  <f:form modelAttribute="missionModel" action="./addVille" method="post">
				  <div class="modal-body">
					<div class="form-group">
					  <label>Nom du ville :</label>
					  <f:input type="text"  path="nameVille" class="form-control" placeholder="Entrer nom du ville"></f:input>
					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</div>
					<div class="form-group">
					  <label>A quel pays appartient :</label>
					  <f:input type="text"  path="pays" class="form-control" placeholder="Entrer nom du pays"></f:input>
					</div>
				  </div>
				  <div class="modal-footer">
					<button type="reset" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Save changes</button>
				  </div>
			  </f:form>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</div>
 <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Conditions d'utilisations
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">Order Mission</a>.</strong> All rights reserved.
  </footer>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/resources/plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="${pageContext.request.contextPath}/resources/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- bootstrap color picker -->
<script src="${pageContext.request.contextPath}/resources/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="${pageContext.request.contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${pageContext.request.contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/resources/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/resources/dist/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $(".select2").select2();

    //Datemask dd/mm/yyyy
    $("#datemask").inputmask("dd/MM/yyyy", {"placeholder": "dd/MM/yyyy"});
    //Datemask2 mm/dd/yyyy
    $("#datemask2").inputmask("dd/MM/yyyy", {"placeholder": "dd/MM/yyyy"});
    //Money Euro
    $("[data-mask]").inputmask();

    //Date range picker
    $('#reservation').daterangepicker();
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({autoApply: true, timePicker: true, timePickerIncrement: 30, format: 'dd/MM/yyyy hh:mm'});
    //Date range as a button
    $('#daterange-btn').daterangepicker(
        {
          ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          startDate: moment().subtract(29, 'days'),
          endDate: moment()
        },
        function (start, end) {
          $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        }
    );

    //Date picker
    $('#datepicker').datepicker({
      autoclose: true
    });

    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass: 'iradio_minimal-blue'
    });
    //Red color scheme for iCheck
    $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
      checkboxClass: 'icheckbox_minimal-red',
      radioClass: 'iradio_minimal-red'
    });
    //Flat red color scheme for iCheck
    $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
      checkboxClass: 'icheckbox_flat-green',
      radioClass: 'iradio_flat-green'
    });

    //Colorpicker
    $(".my-colorpicker1").colorpicker();
    //color picker with addon
    $(".my-colorpicker2").colorpicker();

    //Timepicker
    $(".timepicker").timepicker({
      showInputs: false
    });
  });
</script>
</body>
</html>
