var JCERTIF = {};

// Singleton utilisé pour les fonctions à appliquer au menu
JCERTIF.menu = function(){

    /**
	 * Initialisation des styles du menu
	 */
    var init = function(selector){
        $("#menu ul li a.current").removeClass("current");
        $(selector).addClass("current");
       
    };
    
    var initAnim = function(){
         $("ul#msg_animation").liScroll();
    };

    /**
	 * Methodes publiques
	 */
    return{
        init:init,
        initAnim:initAnim
    };
}();
