$(document).ready(function () {

    window.setInterval(function () {
        largura = $(document).width();

        if (largura <= 575) {
            jQuery("#menuNav").addClass("menuNavegacao generosTexto");
            jQuery("#menuNav").removeClass("nav");
            jQuery("#menuNav").removeClass("navbar-static-top");
            jQuery("#menuNav").removeClass("nav-tabs");

            for (i = 1; i < 6; i++) {
                jQuery("#a" + i + "").addClass(".menu");
            }

        } else {
            
            for (i = 1; i < 6; i++) {
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
    });

    jQuery("#voltar").click(function () {
        jQuery("#menuUser").removeClass("nav-perfil-maior");
        jQuery("#menuUser").addClass("nav-perfil");
    });



    window.setInterval(function () {
        heigth = $(document).height();
        console.log(heigth);
        jQuery("#fundo").css({
            heigth: heigth
        });
    }, 500);
});