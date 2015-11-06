$(document).ready(function () {

    var controle = Math.floor(Math.random() * 6);

    var videos = ['BXxnWyGE484', 'K6FFF8txIqY', 'ma3Rvl5SDuI', 'VWu0wF-xuzs', 'wyrOeSAF5NA', 'tCAgtzMUCaA'];

    var options = {videoId: videos[controle],
        start: 0,
        repeat: true,
        mute: true
    };

    $('.wrapper').tubular(options); // where idOfYourVideo is the YouTube ID.

    window.setInterval(function () {


        largura = $(document).width();

        if (largura <= 575) {
            jQuery("#fundo").removeClass("wrapper");
            jQuery("#fundo").addClass("gray-background");
            jQuery("#menuNav").addClass("menuNavegacao generosTexto");
            jQuery("#menuNav").removeClass("nav");
            jQuery("#menuNav").removeClass("navbar-static-top");
            jQuery("#menuNav").removeClass("nav-tabs");
            jQuery("#volume").hide();

            for (i = 1; i < 6; i++) {
                jQuery("#a" + i + "").addClass(".menu");
            }

        } else {
            jQuery("#volume").fadeIn(100);
            jQuery("#fundo").removeClass("gray-background");
            jQuery("#fundo").addClass("wrapper");

            for (i = 1; i < 6; i++) {
                jQuery("#a" + i + "").removeClass(".menu");
            }

            jQuery("#menuNav").removeClass("menuNavegacao generosTexto");
            jQuery("#menuNav").addClass("nav");
            jQuery("#menuNav").addClass("nav-tabs");
        }

    }, 400);
    
});