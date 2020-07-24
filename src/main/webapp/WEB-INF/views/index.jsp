<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OrderMission | Profil</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/skin-blue.min.css">
<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">
			<!-- Logo -->
			<a href="./index" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>O</b>M</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Order</b> Mission</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"role="button"> 
					<span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown notifications-menu">
							<!-- Menu toggle button -->
						</li>
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar-->
								<img src="${pageContext.request.contextPath}/resources/images/${missionModel.image}" class="user-image"
								alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">${missionModel.prof.firstName} ${missionModel.prof.lastName}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img
									src="${pageContext.request.contextPath}/resources/images/${missionModel.image}" class="img-circle"
									alt="User Image">

									<p>
										${missionModel.prof.firstName} ${missionModel.prof.lastName} <br>${missionModel.prof.profession} 
										<small>Membre depuis ${missionModel.prof.dateCreation}</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body"></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<form id="logoutForm" method="POST" action="./login?logout">
							            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							        </form>
									<div class="pull-right">
										<a href="#" onclick="document.forms['logoutForm'].submit()" class="btn btn-default btn-flat">Sign out</a>
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
						<img src="${pageContext.request.contextPath}/resources/images/${missionModel.image}" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${missionModel.prof.firstName} ${missionModel.prof.lastName}</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i>
							Connecté</a>
					</div>
				</div>

				<!-- search form (Optional) -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->

				<!-- Sidebar Menu -->
				<ul class="sidebar-menu">
						<li class="header">MAIN NAVIGATION</li>
						<li class="active treeview"><a href="./index"> <i
								class="fa fa-dashboard"></i> <span>tableau de bord</span>
						</a></li>
						<sec:authorize access="hasAuthority('ADMIN')">
							<li>
								<a href="#"> <i class="fa fa-th"></i> <span>
											Professeurs</span> <span class="pull-right-container"> <i
											class="fa fa-angle-left pull-right"></i>
									</span>
								</a>
								<ul class="treeview-menu">
									<li><a href="./professor"><i class="fa fa-circle-o"></i>
											Tous les Professeurs</a></li>
									<li><a href="./addProfessor"><i
											class="fa fa-circle-o"></i> Ajouter professeur</a></li>
								</ul>
							</li>
						</sec:authorize>
						<li><a href="#"> <i class="fa fa-th"></i> <span>
									Missions</span> <span class="pull-right-container"> <i
									class="fa fa-angle-left pull-right"></i>
							</span>
						</a>
							<ul class="treeview-menu">
								<li><a href="./mission"><i class="fa fa-circle-o"></i>
										Tous les missions</a></li>
								<li><a href="./addMission"><i class="fa fa-circle-o"></i> Ajouter
										mission</a></li>
							</ul></li>
					</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Mission <small>Tous les Missions</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
					<li><a href="#">Mission</a></li>
					<li class="active">Tous les Missions</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Tous les Missions</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Sujet</th>
											<th>Destination</th>
											<th>Date de départ</th>
											<th>Date de retour</th>
											<th>Date d'expiration</th>
											<th>Professeur</th>
											<th>Status</th>
											<th style="width: 10%;">Actions</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${missionModel.missions}" var="m">	
											<tr>
												<td>${m.subject}</td>
												<td>${m.destination.name}</td>
												<td>${m.departureTime}</td>
												<td>${m.returnTime}</td>
												<td>${m.expiryDate}</td>
												<td>${m.professor.matricule}</td>
												<td>${m.state.name}</td>
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
															<li><a href="./downloadMission/${m.idMission}">Télecharger</a></li>
															<li><a href="./updateMission?idm=${m.idMission}">Modifier</a></li>
															<sec:authorize access="hasAnyAuthority('ADMIN','DEPCHEF')"><li><a href="#" data-href="./deleteMission/${m.idMission}" data-toggle="modal" data-target="#confirm-delete">Supprimer</a></li></sec:authorize>
															<li class="divider"></li>
															<sec:authorize access="hasAnyAuthority('ADMIN','CHEFETAB','${m.state.privilege.name}')">
																<c:choose>
																	 <c:when test="${m.state.state.idState == 3 && m.hasUniversiteTrans}">
																	 	<li style="display: ${m.state.state.state == null ? 'none' : ''}">
																			<a data-id="${m.idMission}" title="Valider" class="open-advanceDialog">${m.state.state.action}</a>
																		</li>
																	</c:when>
																	<c:otherwise>
																		<li style="display: ${m.state.state.state == null ? 'none' : ''}">
																			<a href="./advanceMission/${m.idMission}">${m.state.state.action}</a>
																		</li>
																	</c:otherwise>
																</c:choose>
															</sec:authorize>
															<li style="display: ${m.state.state.state == null ? '' : 'none'}">
																<a href="./printMission/${m.idMission}">${m.state.state.action}</a>
															</li>
															<sec:authorize access="hasAnyAuthority('ADMIN','CHEFDEP','CHEFETAB','CHEFPERS')"><li style="display: ${m.state.idState == 5 ? 'none' : ''}"><a data-id="${m.idMission}" title="Rejeter" class="open-rejeterDialog">Rejeter</a></li></sec:authorize>
														</ul>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Sujet</th>
											<th>Destination</th>
											<th>Date de départ</th>
											<th>Date de retour</th>
											<th>Date d'expiration</th>
											<th>Professeur</th>
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
		
		
		<div id="advanceDialog" class="modal fade" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
			  <div class="modal-header">
		      		Confirmation
		      </div>
		      <form action="./advMission" method="post">
			      <div class="modal-body">
					<input type="hidden" name="idMiss" id="idMiss" value=""/>
			        <div class="form-group">
	                	<label>chauffeur :</label>
	                  	<input type="text" name="driver" class="form-control" placeholder="Entrer le chauffeur"/>
	                </div>
	                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			      </div>
			      <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
		                <button type="submit" class="btn btn-primary">Confirmer</button>
		          </div>
	          </form>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		
		
		
		<div id="rejeterDialog" class="modal fade" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
			  <div class="modal-header">
		      		Rejection
		      </div>
		      <form action="./rejectMission" method="post">
			      <div class="modal-body">
					<input type="hidden" name="idMission" id="idMission" value=""/>
			        <div class="form-group">
	                	<label>Raison de la rejection :</label>
	                  	<textarea name="raison" cols="2" class="form-control" placeholder="Entrer votre raison"></textarea>
	                </div>
	                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			      </div>
			      <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
		                <button type="submit" class="btn btn-primary">Confirmer Rejection</button>
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
	                <p>Etes-vous sur vous voullez supprimer cette mission ??</p>
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
		  $(".open-rejeterDialog").click(function(){
		     $('#idMission').val($(this).data('id'));
		    $("#rejeterDialog").modal("show");
		  });
		});
		
		$(function(){
		  $(".open-advanceDialog").click(function(){
		     $('#idMiss').val($(this).data('id'));
		    $("#advanceDialog").modal("show");
		  });
		});
	</script>

		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div class="pull-right hidden-xs">Conditions d'utilisations</div>
			<!-- Default to the left -->
			<strong>Copyright &copy; 2016 <a href="#">Order Mission</a>.
			</strong> All rights reserved.
		</footer>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->

	<script src="${pageContext.request.contextPath}/resources/dist/js/app.min.js"></script>
	<!-- FastClick -->
	<script src="${pageContext.request.contextPath}/resources/plugins/fastclick/fastclick.js"></script>
	<!-- Sparkline -->
	<script src="${pageContext.request.contextPath}/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="${pageContext.request.contextPath}/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- SlimScroll 1.3.0 -->
	<script src="${pageContext.request.contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- DataTables -->
	<script src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>
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
