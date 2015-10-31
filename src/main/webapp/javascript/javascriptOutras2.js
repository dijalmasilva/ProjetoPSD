$(document).ready(function () {

    var clickSol = 1;
    var clickNot = 0;

    abrirSol();
    jQuery("#menuabaixo").hide();
    jQuery("#notifications").hide();
    jQuery("#requests").hide();
    jQuery("#not").hide();
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
    
    
    jQuery("#newGroup").click(function (){
        jQuery("#cadastroGrupo").fadeIn(300);
    });
    
    jQuery("#closeGroup").click(function (){
        jQuery("#cadastroGrupo").fadeOut(100);
    });
    
    jQuery("#solicitacoes").click(function (){
        if (clickSol === 0){
            abrirSol();
            fecharNot();
            clickSol = 1;
            clickNot = 0;
        }else{
            fecharSol();
            clickSol = 0;
        }
    });
    
    jQuery("#notificacoes").click(function (){
       if (clickNot === 0) {
            abrirNot();
            fecharSol();
            clickNot = 1;
            clickSol = 0;
       }else{
            fecharNot();
            clickNot = 0;
       }
    });
});


function abrirSol(){
    jQuery("#sol").show();
}

function fecharSol(){
    jQuery("#sol").hide();
}

function abrirNot(){
    jQuery("#not").show();
}

function fecharNot(){
    jQuery("#not").hide();
}