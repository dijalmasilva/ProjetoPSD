$('#arq').click(function () {
    $('#upload').trigger('click');
});

$('input[type=file]').change(function () {
    var arq = $('#upload').val().replace(/^.*\\/, "");
    $('#arq').text(arq);
});