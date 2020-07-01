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
	  <!-- DataTables -->
	<link rel="stylesheet" href="${contextPath}/resources/plugins/datatables/dataTables.bootstrap.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/skin-blue.min.css">
	<!-- jQuery 2.2.3 -->
	<script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="./index" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>O</b>M</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Order</b> Mission</span>
    </a>

    <!-- Header Navbar -->
   <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          
          <!-- /.messages-menu -->

          <!-- Notifications Menu -->
          <li class="dropdown notifications-menu">
            <!-- Menu toggle button -->
            
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="${contextPath}/resources/images/${userForm.image}" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${userForm.prof.firstName} ${userForm.prof.lastName}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="${contextPath}/resources/images/${userForm.image}" class="img-circle" alt="User Image">

                <p>
                 ${userForm.prof.firstName} ${userForm.prof.lastName} <br>${userForm.prof.profession} 
				 <small>Membre depuis ${userForm.prof.dateCreation}</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
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
          <img src="${contextPath}/resources/images/${userForm.image}" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${userForm.prof.firstName} ${userForm.prof.lastName}</p>
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
        <li class="treeview">
          <a href="./index">
            <i class="fa fa-dashboard"></i> <span>tableau de bord</span>
          </a>
          
        </li>
        <li class="active treeview">
          <a href="#" class="active treeview">
            <i class="fa fa-th"></i> <span> Professeurs</span>
            <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="active treeview-menu">
            <li class="active"><a href="./professor"><i class="fa fa-circle-o"></i> Tous les Professeurs</a></li>
            <li><a href="./addProfessor"><i class="fa fa-circle-o"></i> Ajouter professeur</a></li>
          </ul>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-th"></i> <span> Missions</span>
            <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
		  <li><a href="./mission"><i class="fa fa-circle-o"></i> Tous les missions</a></li>
            <li><a href="./addMission"><i class="fa fa-circle-o"></i> Ajouter mission</a></li>
          </ul>
        </li>
       <!-- <li class="treeview">
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
        Professeur
        <small>Tous les Professeurs</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
        <li><a href="#">Professeur</a></li>
        <li class="active">Tous les Professeurs</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
	
      <div class="row">
        <div class="col-md-12">
               <div class="box">
            <div class="box-header">
              <h3 class="box-title">Tous les Professeurs</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Nom</th>
                  <th>Matricule</th>
                  <th>Profession</th>
                  <th>Email</th>
				  <th>Tél</th>
				  <th>Ville</th>
				  <th>Département</th>
				  <th>Status</th>
				  <th style='width: 10%;'>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userForm.professors}" var="p">	
	                <tr>			  
						<td>${p.firstName} ${p.lastName}</td>
						<td>${p.matricule}</td>
						<td>${p.profession}</td>
						<td>${p.email}</td>
						<td>${p.phone}</td>
						<td>${p.city}</td>
						<td>${p.departement.name}</td>
						<td>${p.status}</td>
						<td>
							<div class="btn-group">
								<button type="button" class="btn btn-default">Action</button>
								<button type="button"
									class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									<span class="caret"></span> <span class="sr-only">Toggle
										Dropdown</span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#" data-href="./deleteProfessor/${p.idProfessor}" data-toggle="modal" data-target="#confirm-delete">Supprimer</a></li>
									<li><a href="#">Modifier</a></li>
									<li class="divider"></li>
									<li><a data-id="${p.idProfessor}" title="Ajouter grade" class="open-gradeDialog">Attribuer grade</a></li>
								</ul>
							</div>
						</td>
					</tr>
				</c:forEach>
                </tbody>
                <tfoot>
                <tr>
				  <th>Nom</th>
                  <th>Matricule</th>
                  <th>Profession</th>
                  <th>Email</th>
				  <th>Tél</th>
				  <th>Ville</th>
				  <th>Département</th>
				  <th>Status</th>
				  <th>Actions</th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
	</section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <div id="gradeDialog" class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
		  <div class="modal-header">
	      		Rejection
	      </div>
	      <form action="./addGrade" method="post">
		      <div class="modal-body">
				<input type="hidden" name="idProf" id="idProf" value=""/>
		        <div class="form-group">
                	<label>Attribuer les grades à ce professeur :</label>
                </div>
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  <div class="form-group">
	                <label>Grade de professeur :</label>
	                <select class="form-control select2" multiple="multiple" name="grade" required="required" data-placeholder="Choisissez les grades a donner a ce professeur :" style="width: 100%;">
	                  <option value="">Choisissez les grades</option>
	                  <c:forEach items="${userForm.grades}" var="g">
							<option value="${g.idGrade}">${g.grade}</option>
						</c:forEach>
	                </select>
	              </div>
		      </div>
		      <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
	                <button type="submit" class="btn btn-primary">Ajouter</button>
	          </div>
          </form>
	    
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		
		
	 <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	            	Supprission
	            </div>
	            <div class="modal-body">
	                <p>Etes-vous sur vous voullez supprimer ce Professeur ??</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
	                <a class="btn btn-danger btn-ok">Supprimer</a>
	            </div>
	        </div>
	    </div>
	</div>
	
	<script type="text/javascript">
		$('#confirm-delete').on('show.bs.modal', function(e) {
		    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
		});
		
		$(function(){
		  $(".open-gradeDialog").click(function(){
		     $('#idProfessor').val($(this).data('id'));
		    $("#gradeDialog").modal("show");
		  });
		});
	</script>

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

<!-- REQUIRED JS SCRIPTS -->

<!-- AdminLTE App -->
<script src="${contextPath}/resources/dist/js/app.min.js"></script>
<!-- FastClick -->
<script src="${contextPath}/resources/plugins/fastclick/fastclick.js"></script>
<!-- Sparkline -->
<script src="${contextPath}/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="${contextPath}/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${contextPath}/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<!-- DataTables -->
<script src="${contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${contextPath}/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>

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
<!-- AdminLTE for demo purposes -->
<script src="${contextPath}/resources/dist/js/demo.js"></script>
<script>
  $(function () {
	//Initialize Select2 Elements
	    $(".select2").select2();
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>
