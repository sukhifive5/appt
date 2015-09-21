var app = angular.module('myApp', ['ngRoute']);
				
				// configure our routes
			    app.config(function($routeProvider) {
			        $routeProvider

			            // route for the home page
			            .when('/CreateAppointment', {
			                templateUrl : 'CreateAppointment.jhtml',
			                controller  : 'myCtrl',
			                preload: true
			            })
			            .when('/ViewAppointment', {
			                templateUrl : 'ViewAppointments.jhtml',
			                preload: false
			            })
			            .when('/MonthView', {
			                templateUrl : 'monthView.jhtml',
			                controller  : 'calendarDemo',
			                preload: false
			            })
			            .when('/DayView', {
			                templateUrl : 'dayView.jhtml',
			                controller  : 'dayView',
			                preload: false
			            })

			           
			    });
				//pre loading of templates
			    app.run([
                       '$route', '$templateCache', '$http', (function ($route, $templateCache, $http) {
                           var url;
                           for (var i in $route.routes) {
                               if ($route.routes[i].preload) {
                                   if (url = $route.routes[i].templateUrl) {
                                       $http.get(url, { cache: $templateCache });
                                   }
                               }
                           }
                       })
                   ]);
			    
			    app.controller('myCtrl', function($scope) {
				    $scope.firstName= "John";
				    $scope.lastName= "Doe";
				    
				});
			   
			    app.controller("calendarDemo", function($scope) {
			        $scope.day = moment();
			    });
			    
			    app.controller('dayView', function($scope) {
			    	$scope.name = 'Superhero';
				    $scope.dayHours=[8,9,10,11,12,1,2,3,4,5];
				    $scope.employees = ["Employee 1", "Employee 2"];
				    
				});
			
			    app.run(function($rootScope, $templateCache) {
			    	   $rootScope.$on('$viewContentLoaded', function() {
			    	      $templateCache.removeAll();
			    	   });
			    	});
			    
			    
			    app.directive("calendar", function() {
			    	
			        return {
			            restrict: "E",
			            templateUrl: "templates/calendar.jhtml",
			            scope: {
			                selected: "=",

			            },
			            link: function(scope) {
			                scope.selected = _removeTime(scope.selected || moment());
			                scope.month = scope.selected.clone();

			                var start = scope.selected.clone();
			                start.date(1);
			                _removeTime(start.day(0));

			                _buildMonth(scope, start, scope.month);

			                scope.select = function(day) {
			                    scope.selected = day.date;  
			                };

			                scope.next = function() {
			                    var next = scope.month.clone();
			                    _removeTime(next.month(next.month()+1)).date(1);
			                    scope.month.month(scope.month.month()+1);
			                    _buildMonth(scope, next, scope.month);
			                };

			                scope.previous = function() {
			                    var previous = scope.month.clone();
			                    _removeTime(previous.month(previous.month()-1).date(1));
			                    scope.month.month(scope.month.month()-1);
			                    _buildMonth(scope, previous, scope.month);
			                };

			            }
			        };
			        
			        function _removeTime(date) {
			            return date.day(0).hour(0).minute(0).second(0).millisecond(0);
			        }

			        function _buildMonth(scope, start, month) {
			            scope.weeks = [];
			            var done = false, date = start.clone(), monthIndex = date.month(), count = 0;
			            while (!done) {
			                scope.weeks.push({ days: _buildWeek(date.clone(), month) });
			                date.add(1, "w");
			                done = count++ > 2 && monthIndex !== date.month();
			                monthIndex = date.month();
			            }
			        }

			        function _buildWeek(date, month) {

			            var days = [];
			            for (var i = 0; i < 7; i++) {
			                days.push({
			                    name: date.format("dd").substring(0, 1),
			                    number: date.date(),
			                    isCurrentMonth: date.month() === month.month(),
			                    isToday: date.isSame(new Date(), "day"),
			                    date: date
			                });
			                date = date.clone();
			                date.add(1, "d");
			            }
			            return days;
			        }
			    });
			    
			    
			

		