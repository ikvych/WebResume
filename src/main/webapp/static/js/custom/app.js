function initCertificateViewer() {
    $('a.certificate-link').click(function(e) {
        e.preventDefault();
        var title = $(this).attr("data-title");
        $('#certificateViewer .modal-title').html(title);
        $('#certificateViewer .modal-body img').attr('src',$(this).attr("data-url"));
        $('#certificateViewer').modal({
            show : true
        });
    });
}

function createCertificateUploader(){
    //https://github.com/kartik-v/bootstrap-fileinput
    $("#certificateFile").fileinput({
        uploadUrl: '/edit/certificates/upload',
        allowedFileExtensions : ['jpg', 'png'],
        maxFileCount: 1,
        showPreview:true,
        language : 'es',
        showUpload:true,
        allowedFileType : ['image'],
        previewFileType :'image',
        showCaption: true,
        dropZoneEnabled: false,
        showRemove: true,
        maxFileSize: 100000,
        browseClass: "btn btn-success",
        browseLabel: "Browse image",
        browseIcon: "<i class=\"fa fa-file-image-o\"></i> ",
        removeClass: 'btn btn-danger',
        removeTitle: 'Borrar Imagen',
        removeLabel: "Remove",
        removeIcon: "<i class=\"fa fa-trash-o\"></i> ",
        uploadClass: "btn btn-info",
        uploadLabel: "Upload",
        uploadIcon: "<i class=\"fa fa-upload\"></i> ",
        cancelClass: "btn btn-info",
        cancelLabel: "Cancel",
        cancelIcon: "<i class=\"fa fa-retweet\"></i> "
    });
    $('#certificateFile').on('fileuploaded', function(event, data, previewId, index) {

        var response = data.response;
        console.log(response.certificateName)
        console.log(response.smallUrl)
        console.log(response.largeUrl)
        if(response.certificateName != null) {
            if($('#certificateName').val().trim() == '') {
                $('#certificateName').val(response.certificateName);
            }
        }
        $('#certificateUploader').attr('data-small-url', response.smallUrl);
        $('#certificateUploader').attr('data-large-url', response.largeUrl);
    });
    $('#certificateFile').on('fileuploaderror', function(event, data, msg) {
        showErrorDialog(messages.errorUploadCertificate);
    });
}

function showErrorDialog (message) {
    alert(message);
}

function moreProfiles () {
    var page = parseInt($('#profileContainer').attr('data-profile-number')) + 1;
    var total= parseInt($('#profileContainer').attr('data-profile-total'));
    if (page >= total) {
        $('#loadMoreIndicator').remove();
        $('#loadMoreContainer').remove();
        return;
    }
    var url = '/fragment/more?page=' + page;
/*    if(searchQuery !== undefined && searchQuery.trim() !== '') {
        url += '&query='+searchQuery;
    }*/

    $('#loadMoreContainer').css('display', 'none');
    $('#loadMoreIndicator').css('display', 'block');
    $.ajax({
        url : url,
        success : function(data) {
            $('#loadMoreIndicator').css('display', 'none');
            $('#profileContainer').append(data);
            $('#profileContainer').attr('data-profile-number', page);
            if (page >= total-1) {
                $('#loadMoreIndicator').remove();
                $('#loadMoreContainer').remove();
            } else {
                $('#loadMoreContainer').css('display', 'block');
            }
        },
        error : function(data) {
            console.log(data);
            showErrorDialog('Ось така хуйня малята');
        }
    });
}

function addCertificate() {
    var certificateName = $('#certificateName').val();
    //https://www.tjvantoll.com/2012/08/05/html5-form-validation-showing-all-error-messages/
    if(certificateName.trim() == '') {
        alert('certificateName is null')
        return;
    }
    console.log(certificateName)
    var container = $('#EditContainer');
    var blockIndex = container.find('.edit-item').length;
    var context = {
        index : blockIndex,
        largeUrl : $('#certificateUploader').attr('data-large-url'),
        smallUrl : $('#certificateUploader').attr('data-small-url'),
        name : $('#certificateName').val(),
    };
    console.log(context)
    var source = $("#ui-block-template").html();
    var template = Handlebars.compile(source);
    container.append(template(context));
    $('#certificateUploader').modal('hide');
    $('#certificateName').val('');
    $('#certificateFile').fileinput('clear');
}

function getMinDate() {
    document.getElementById("birth").setAttribute("min", getCurrentDateMinusYear(90));
}

function getMaxDate() {
    document.getElementById("birth").setAttribute("max", getCurrentDateMinusYear(18));
}

function getCurrentDateMinusYear(years) {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    return (yyyy - years) + '-' + mm + '-' + dd;
}

function addSkills() {
    var container = $("#EditContainer");
    var index = container.find(".edit-item").length;
    var context = {
        blockIndex: index
    };
    var source = $("#ui-block-template").html();
    var template = Handlebars.compile(source);

    container.append(template(context));
    container.find('input.level-slider').slider();
}




