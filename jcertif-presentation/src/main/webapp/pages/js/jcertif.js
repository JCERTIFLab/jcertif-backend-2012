var JCERTIF = {};

// Singleton utilis� pour les fonctions � appliquer au menu
JCERTIF.menu = function(){

	/**
	 * Initialisation des styles du menu
	 */
	var init = function(selector){
		 $("#menu ul li a.current").removeClass("current");
		 $(selector).addClass("current");
	};

	/**
	 * Methodes publiques
	 */
	return{
		init:init
	};
}();