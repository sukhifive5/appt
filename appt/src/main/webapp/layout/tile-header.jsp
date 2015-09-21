
<div class="container">
	<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand">Appointments</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#/ViewAppointment">View Appointments <span class="sr-only">(current)</span></a></li>
        <li><a href="#/CreateAppointment">Create Appointment</a></li>
       </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      	 <li><a href="#/MonthView">Month View</a></li>
      	 <li><a href="#/DayView">Day View</a></li>
        <li><a href="#/MonthView">Current User</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Actions <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Create Employee</a></li>
            <li><a href="#">Update Employee</a></li>
            <li><a href="#">Find Customers</a></li>
            <li><a href="#">Update Customers</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>

<script>
$('.navbar-collapse a').click(function(){
    $(".navbar-collapse").collapse('hide');
});
</script>

<!-- 
			<style>
.md-toolbar-tools h1 {
  font-size: inherit;
  font-weight: inherit;
  margin: inherit;
  
  .menuBardemoBasicUsage .page-container {
  background-color: #f1f1f1;
  padding: 32px; }
.menuBardemoBasicUsage .page {
  margin: 0 auto;
  background-color: black;
  padding: 24px;
  max-width: 680px;
  box-shadow: 0px 1px 2px 1px rgba(0, 0, 0, 0.25); }
.menuBardemoBasicUsage .page h1 {
  text-align: center;
  font-size: 1.8rem;
  margin-top: 0;
  font-weight: normal; }
.menuBardemoBasicUsage .page p {
  line-height: 1.6rem; }
}
</style>
 	
<md-content class="md-padding">
    <md-tabs md-dynamic-height md-border-bottom>
      <md-tab label="one">
        <md-content class="md-padding">
          <h1 class="md-display-2">Tab One</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla venenatis ante augue. Phasellus volutpat neque ac dui mattis vulputate. Etiam consequat aliquam cursus. In sodales pretium ultrices. Maecenas lectus est, sollicitudin consectetur felis nec, feugiat ultricies mi.</p>
        </md-content>
      </md-tab>
      <md-tab label="two">
        <md-content class="md-padding">
          <h1 class="md-display-2">Tab two</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla venenatis ante augue. Phasellus volutpat neque ac dui mattis vulputate. Etiam consequat aliquam cursus. In sodales pretium ultrices. Maecenas lectus est, sollicitudin consectetur felis nec, feugiat ultricies mi.</p>
        </md-content>
      </md-tab>
      <md-tab label="three">
        <md-content class="md-padding">
          <h1 class="md-display-2">Tab three</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla venenatis ante augue. Phasellus volutpat neque ac dui mattis vulputate. Etiam consequat aliquam cursus. In sodales pretium ultrices. Maecenas lectus est, sollicitudin consectetur felis nec, feugiat ultricies mi.</p>
        </md-content>
      </md-tab>
      <md-tab label="four">
        <md-content class="md-padding">
          <h1 class="md-display-2">Tab four</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla venenatis ante augue. Phasellus volutpat neque ac dui mattis vulputate. Etiam consequat aliquam cursus. In sodales pretium ultrices. Maecenas lectus est, sollicitudin consectetur felis nec, feugiat ultricies mi.</p>
        </md-content>
      </md-tab>
      </md-tabs>
      </md-content>
			
			 <div layout="column" ng-controller="AppCtrl">
			    <md-toolbar layout="row">
			      <div class="md-toolbar-tools">
			        <md-button ng-click="toggleSidenav('left')" hide-gt-sm class="md-icon-button">
			          <md-icon aria-label="Menu" md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg"></md-icon>
			        </md-button>
			        <h1>Appointments</h1>
			        
			       
			      </div>
			    </md-toolbar>
			    
			    <div layout="row" flex>
			        <md-sidenav layout="column" class="md-sidenav-left md-whiteframe-z2" md-component-id="left" md-is-locked-open="$mdMedia('gt-sm')">
			          	<md-button ng-click="#/ViewAppointment">
						        View Appointments
						      </md-button>
			        </md-sidenav>
			        <div layout="column" flex id="content">
			            <md-content layout="column" flex class="md-padding">
			            	
			            </md-content>
			    </div>
    		</div>

 

<script>


</script> -->