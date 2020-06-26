<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
  <link rel="stylesheet" href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/datepicker/datepicker3.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/colorpicker/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/select2/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/skin-blue.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
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
              <img src="${contextPath}/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Mohamed Elgarnaoui</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="${contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                 Mohamed Elgarnaoui - Java Professor
                  <small>Membre depuis 06/2020</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
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
          <img src="${contextPath}/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Mohamed Elgarnaoui</p>
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
        <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li>
          <a href="starter.html">
            <i class="fa fa-dashboard"></i> <span>tableau de bord</span>
          </a>
          
        </li>
        <li>
          <a href="#">
            <i class="fa fa-th"></i> <span> Professeurs</span>
            <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="data.html"><i class="fa fa-circle-o"></i> Tous les Professeurs</a></li>
            <li><a href="ajout_produit.html"><i class="fa fa-circle-o"></i> Ajouter professeur</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Modifier professeur</a></li>
          </ul>
        </li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-th"></i> <span> Missions</span>
            <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="active treeview-menu">
		  <li class="active"><a href="data2.html"><i class="fa fa-circle-o"></i> Tous les missions</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Ajouter mission</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Modifier mission</a></li>
          </ul>
        </li>
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
        <li>
          <a href="calendar.html">
            <i class="fa fa-calendar"></i> <span> Calendrier</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-red">3</small>
            </span>
          </a>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
   <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Professeur
        <small>Ajouter Professeur</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
        <li><a href="#">Professeur</a></li>
        <li class="active">Ajouter Professeur</li>
      </ol>
    </section>

   <!-- Main content -->
    <section class="content">
        <!-- SELECT2 EXAMPLE -->
      <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Ajouter Professeur</h3>
          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-md-6">
				<!-- text input -->
                <div class="form-group">
                  <label>Votre nom :</label>
                  <input type="text" class="form-control" placeholder="Nom ...">
                </div>
				<div class="form-group">
                  <label>Votre prénom :</label>
                  <input type="text" class="form-control" placeholder="Prénom ...">
                </div>
				<div class="form-group">
                  <label>Matricule :</label>
                  <input type="text" class="form-control" placeholder="matricule">
                </div>
				<div class="form-group">
                  <label>Mot de passe :</label>
                  <input type="password" class="form-control" placeholder="mot de passe ...">
                </div>
				<div class="form-group">
                  <label>Votre email :</label>
                  <input type="email" class="form-control" placeholder="email ...">
                </div>
				<div class="form-group">
                  <label>Votre tél :</label>
                  <input type="text" class="form-control" placeholder="tél ...">
                </div>
			
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
            <div class="col-md-6">
			  <!-- Date -->
              <div class="form-group">
                <label>Date de naissance :</label>
                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="datepicker">
                </div>
                <!-- /.input group -->
              </div>
			<div class="form-group">
                <label>Votre CIN :</label>
                <input type="text" class="form-control" placeholder="cin ...">
            </div>
			<div class="input-group">
                <label>Ville :</label>
                <select class="form-control select2" style="width: 100%;">
                  <option selected="selected">selectionner votre ville</option>
                  <option>Tanger</option>
                  <option>Rabat</option>
                </select>
				<br/>
				 <span class="input-group-btn">
					<p style="height: 15px;"></p>
					<button type="button" class="btn btn-info btn-flat" data-toggle="modal" data-target="#myModalVille">Ajouter une !</button>
				  </span>
              </div>
			  <div class="input-group">
                <label>Département :</label>
                <select class="form-control select2" style="width: 100%;">
                  <option selected="selected">selectionner votre Département</option>
                  <option>Informatique</option>
                  <option>Physique</option>
				  <option>Technologique</option>
                </select>
				<br/>
				 <span class="input-group-btn">
					<p style="height: 15px;"></p>
					<button type="button" class="btn btn-info btn-flat" data-toggle="modal" data-target="#myModalDep">Ajouter une !</button>
				  </span>
              </div>
			  <label>Status :</label>
			  <div class="input-group">
                
				<span class="input-group-btn">
					<button type="button" class="btn btn-info btn-flat" data-toggle="modal" data-target="#myModalStatus">Ajouter une !</button>
				</span>
                <select class="form-control select2" style="width: 100%;">
                  <option selected="selected">selectionner votre status</option>
                  <option>Valider</option>
                  <option>Actif</option>
                  <option>Rejter</option>
                  <option>Bloquer</option>
                </select>
				
				
              </div>
			 	<div class="form-group">
                  <label>Votre adresse :</label>
                  <textarea class="form-control" placeholder="adresse ..."></textarea>
                </div>
              
			   <div class="form-group">
                  <label for="exampleInputFile">Votre Photo :</label>
                  <input type="file" id="exampleInputFile">
                  <p class="help-block"></p>
               </div>
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
        <div class="box-footer " >
            <button type="submit" class="btn btn-primary pull-right margin">Ajouter mission</button>
			<button type="reset" class="btn btn-default pull-right margin">Réinistialiser</button>
        </div>
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
			  <div class="modal-body">
				<div class="form-group">
				  <label>Nom du departement :</label>
				  <input type="text" class="form-control" placeholder="Entrer nom dèpartement">
				</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
				<button type="button" class="btn btn-primary">Sauvgarder</button>
			  </div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<div class="modal fade" id="myModalVille" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title text-center" id="gridSystemModalLabel">Ajouter Département</h4>
			  </div>
			  <div class="modal-body">
				<div class="form-group">
				  <label>Nom du ville :</label>
				  <input type="text" class="form-control" placeholder="Entrer nom du ville">
				</div>
				<div class="form-group">
				  <label>A quel pays appartient :</label>
				  <input type="text" class="form-control" placeholder="Entrer nom du pays">
				</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
				<button type="button" class="btn btn-primary">Sauvgarder</button>
			  </div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!-- /.modal Status -->
	<div class="modal fade" id="myModalStatus" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title text-center" id="gridSystemModalLabel">Ajouter Status</h4>
			  </div>
			  <div class="modal-body">
				<div class="form-group">
				  <label>Nom du status :</label>
				  <input type="text" class="form-control" placeholder="Entrer status">
				</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
				<button type="button" class="btn btn-primary">Sauvgarder</button>
			  </div>
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
<script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="${contextPath}/resources/plugins/select2/select2.full.min.js"></script>
<!-- InputMask -->
<script src="${contextPath}/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${contextPath}/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${contextPath}/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="${contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="${contextPath}/resources/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- bootstrap color picker -->
<script src="${contextPath}/resources/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="${contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="${contextPath}/resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${contextPath}/resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${contextPath}/resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $(".select2").select2();

    //Datemask dd/mm/yyyy
    $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
    //Datemask2 mm/dd/yyyy
    $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
    //Money Euro
    $("[data-mask]").inputmask();

    //Date range picker
    $('#reservation').daterangepicker();
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
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
