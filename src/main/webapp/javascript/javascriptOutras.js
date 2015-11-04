$(document).ready(function () {

    clickSol = 0;
    clickNot = 0;
    star = 1;

    jQuery("#menuabaixo").hide();
    jQuery("#notifications").hide();
    jQuery("#requests").hide();
    jQuery("#sol").hide();
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


    jQuery("#newGroup").click(function () {
        jQuery("#cadastroGrupo").fadeIn(300);
    });

    jQuery("#closeGroup").click(function () {
        jQuery("#cadastroGrupo").fadeOut(100);
    });

    jQuery("#solicitacoes").click(function () {
        if (clickSol === 0) {
            abrirSol();
            fecharNot();
            clickSol = 1;
            clickNot = 0;
        } else {
            fecharSol();
            clickSol = 0;
        }
    });

    jQuery("#notificacoes").click(function () {
        if (clickNot === 0) {
            abrirNot();
            fecharSol();
            clickNot = 1;
            clickSol = 0;
        } else {
            fecharNot();
            clickNot = 0;
        }
    });

    jQuery("#star1").mouseenter(function () {

        preencherEstrela(1);

        for (i = 2; i < 6; i++) {
            esvaziarEstrela(i);
        }

        jQuery("#rating").attr("value", 1);
    });

    jQuery("#star2").mouseenter(function () {
        for (i = 1; i < 3; i++) {
            preencherEstrela(i);
        }
        for (i = 3; i < 6; i++) {
            esvaziarEstrela(i);
        }

        jQuery("#rating").attr("value", 2);
    });

    jQuery("#star3").mouseenter(function () {
        for (i = 1; i < 4; i++) {
            preencherEstrela(i);
        }
        for (i = 4; i < 6; i++) {
            esvaziarEstrela(i);
        }

        jQuery("#rating").attr("value", 3);
    });

    jQuery("#star4").mouseenter(function () {
        for (i = 1; i < 5; i++) {
            preencherEstrela(i);
        }
        for (i = 5; i < 6; i++) {
            esvaziarEstrela(i);
        }
        jQuery("#rating").attr("value", 4);
    });

    jQuery("#star5").mouseenter(function () {
        for (i = 1; i < 6; i++) {
            preencherEstrela(i);
        }

        jQuery("#rating").attr("value", 5);
    });

});


function abrirSol() {
    jQuery("#sol").show();
}

function fecharSol() {
    jQuery("#sol").hide();
}

function abrirNot() {
    jQuery("#not").show();
}

function fecharNot() {
    jQuery("#not").hide();
}

function preencherEstrela(i) {
    jQuery("#star" + i + "").attr("src", "imagens/starP.png");
}

function esvaziarEstrela(i) {
    jQuery("#star" + i + "").attr("src", "imagens/starV.png");
}
