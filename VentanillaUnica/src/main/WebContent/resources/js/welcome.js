(function() {


	var app = angular.module('SCTApp', ['adminPersonasApp']);


//// reportes  esta lanzando u  error del model view
	app.controller('SCTController', ['$http', function($http){
		
		var specs = this;
		specs.roles = [];
	
//		
//		$http.get('/SIPEWEB/catalogos/getUserRolSess.json').success(function(data) {
//			specs.roles = data;
////			var i;
////			for( i = 0; i < specs.roles.length; i++){
////				console.log("Rol: " + specs.roles[i].nombreRol);
////			}
//			
//		});
////		
////		
////		specs.hasAnyRole = function(rolesEntrantes){
////			
////			var rolesVer, rolesExt;
////			for(rolesVer = 0; rolesVer<rolesEntrantes.length;rolesVer++){
////				for(rolesExt = 0; rolesExt<specs.roles.length;rolesExt++){
////				
////					if(specs.roles[rolesExt].nombreRol==rolesEntrantes[rolesVer]){
////						return true;
////					}
////				}
////			}
////			return false;
////		};
////		
////		
	}]);
//
//	app.controller('TabController', function() {
//		this.tab = 1;
//		var ban = 0;
//		var admin=0;
//
//		this.setTab = function(newValue) {
//			if(newValue !== 8){
//				ban = 1;
//			
//			}
//		
//			
//			if(newValue === 8 && ban === 1){
//				location.reload();
//			}
//	
//			this.tab = newValue;
//		};
//
//		this.isSet = function(tabName) {
//			return this.tab === tabName;
//		};
//		
//		if(ban===0){
//		this.setTab(8);
//	}
//
//		//this.setTab(9);
//		
//	});

//	app.directive('oficialpld', function(){
//		return{
//			restrict: 'E',
//			templateUrl: 'pages/html/oficial.html', 
//			controller: function(){
//				this.subTab = 1;
//
//				this.setSubTab = function(newValue) {
//					this.subTab = newValue;
//				};
//
//				this.isSetSubTab = function(subTabName) {
//					return this.subTab === subTabName;
//				};
//			},
//			controllerAs: 'subPanel'
//		};
//	});


})();