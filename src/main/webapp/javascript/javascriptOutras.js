$(document).ready(function () {

    jQuery("#menuabaixo").hide();
    jQuery("#notifications").hide();
    jQuery("#requests").hide();
    jQuery("#cadastroGrupo").hide();

    window.setInterval(function () {
        largura = $(document).width();

        if (largura <= 575) {
            jQuery("#menuNav").addClass("menuNavegacao generosTexto");
            jQuery("#menuNav").removeClass("nav");
            jQuery("#menuNav").removeClass("navbar-static-top");
            jQuery("#menuNav").removeClass("nav-tabs");

            for (i = 1; i <= 6; i++) {
                jQuery("#a" + i + "").addClass(".menu");
            }

        } else {
            
            for (i = 1; i <= 6; i++) {
                jQuery("#a" + i + "").removeClass(".menu");
            }
            jQuery("#menuNav").removeClass("menuNavegacao generosTexto");
            jQuery("#menuNav").addClass("nav");
            jQuery("#menuNav").addClass("nav-tabs");
        }

    }, 400);

    jQuery("#apelido").click(function () {

        jQuery("#menuUser").removeClass("nav-perfil");
        jQuery("#menuUser").addClass("nav-perfil-maior");
        jQuery("#menuabaixo").fadeIn(2000);
    });

    jQuery("#voltar").click(function () {
        jQuery("#menuabaixo").hide();
        jQuery("#menuUser").removeClass("nav-perfil-maior");
        jQuery("#menuUser").addClass("nav-perfil");
    });
    
    jQuery("#notificacoes").click(function (){
        jQuery("#notifications").fadeIn(100);
        jQuery(".barraLateralDireita").animate({
            width: "+=15%"
        },100);
    });
    
    jQuery("#sairNotifications").click(function (){
        jQuery("#notifications").fadeOut(300);
        jQuery(".barraLateralDireita").css({
           width: '0px' 
        });
    });
    
    jQuery("#solicitacoes").click(function (){
        jQuery("#requests").fadeIn(100);
        jQuery(".barraLateralDireita").animate({
            width: "+=15%"
        },100);
    });
    
    jQuery("#sairSolicitacoes").click(function (){
        jQuery("#requests").fadeOut(300);
        jQuery(".barraLateralDireita").css({
           width: '0px' 
        });
    });
    
    jQuery("#newGroup").click(function (){
        jQuery("#cadastroGrupo").fadeIn(300);
    });
    
    jQuery("#closeGroup").click(function (){
        jQuery("#cadastroGrupo").fadeOut(100);
    });
});