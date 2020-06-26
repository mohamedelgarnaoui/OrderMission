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
    <!-- DataTables -->
  <link rel="stylesheet" href="${contextPath}/resources/plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${contextPath}/resources/dist/css/skins/skin-blue.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="starter.html" class="logo">
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
              <img src="${contextPath}/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
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
              <!-- Menu Body -->
              <li class="user-body">
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
        <li class="active treeview">
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
        <li>
          <a href="#">
            <i class="fa fa-th"></i> <span> Missions</span>
            <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
		  <li><a href="data2.html"><i class="fa fa-circle-o"></i> Tous les missions</a></li>
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
				  <th>Prénom</th>
                  <th>Matricule</th>
                  <th>Email</th>
				  <th>tél</th>
				  <th>Ville</th>
				  <th>Departement</th>
				  <th>Status</th>
				  <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>KHTML</td>
				  <td>DAWI</td>
                  <td>Konqureror 3.1</td>
                  <td>KDE 3.1</td>
				  <td>PSP</td>
                  <td>3.1</td>
                  <td>C</td>
				  <td><div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div></td>
				  <td><div class="btn-group">
                  <button type="button" class="btn btn-default">Action</button>
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                    <span class="sr-only">Toggle Dropdown</span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div></td>
                </tr>
                <tr>
                  <td>KHTML</td>
				  <td>DAWI</td>
                  <td>Konqureror 3.3</td>
                  <td>KDE 3.3</td>
                  <td>3.3</td>
                  <td>A</td>
				  <td>PSP</td>
				  <td><div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div></td>
				  <td><div class="btn-group">
                  <button type="button" class="btn btn-default">Action</button>
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                    <span class="sr-only">Toggle Dropdown</span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div></td>
                </tr>
                <tr>
                  <td>KHTML</td>
				  <td>DAWI</td>
                  <td>Konqureror 3.5</td>
                  <td>KDE 3.5</td>
                  <td>3.5</td>
                  <td>A</td>
				  <td>PSP</td>
				  <td><div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div></td>
				  <td><div class="btn-group">
                  <button type="button" class="btn btn-default">Action</button>
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                    <span class="sr-only">Toggle Dropdown</span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div></td>
                </tr>
                <tr>
                  <td>Tasman</td>
				  <td>DAWI</td>
                  <td>Internet Explorer 4.5</td>
                  <td>Mac OS 8-9</td>
                  <td>-</td>
                  <td>X</td>
				  <td>PSP</td>
				  <td><div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div></td>
				  <td><div class="btn-group">
                  <button type="button" class="btn btn-default">Action</button>
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                    <span class="sr-only">Toggle Dropdown</span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div></td>
                </tr>
                
                </tbody>
                <tfoot>
                <tr>
				  <th>Nom</th>
				  <th>Prénom</th>
                  <th>Matricule</th>
                  <th>Email</th>
				  <th>tél</th>
				  <th>Ville</th>
				  <th>Departement</th>
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

<!-- jQuery 2.2.3 -->
<script src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
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

<!-- AdminLTE for demo purposes -->
<script src="${contextPath}/resources/dist/js/demo.js"></script>
<script>
  $(function () {
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
