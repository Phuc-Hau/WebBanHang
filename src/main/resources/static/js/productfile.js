
var ids =0;

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            $('#imageResult'+ids).attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }

}


function removed(){

    document.getElementById('imageResult'+ids).src='/assets/images/images/plus.png';
    document.getElementById('imageResult').src='/file/user/avata.jpg';

}

function load(input,i) {
    ids=i;
    if(input.src=="/assets/images/plus.png"){
        document.getElementById('imageResult').src='/file/user/avata.jpg';
    }else{
        document.getElementById('imageResult').src= input.src;
    }
}




