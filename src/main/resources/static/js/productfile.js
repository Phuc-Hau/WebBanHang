
var ids =0;
document.getElementById('ids').innerHTML=ids+1;

var forms = new FormData();

function readURL(input) {

    if (input.files && input.files[0] && input.files[0] != undefined) {
        let reader = new FileReader();
        reader.onload = function(e) {
            $('#imageResult'+ids).attr('src', e.target.result);
            $('#imageResult').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
        forms.append("files"+(ids),input.files[0]);
    }
}

function removed(){
    document.getElementById('imageResult').src='/file/user/avata.jpg';
    document.getElementById('imageResult'+ids).src='/assets/images/plus.png';
    forms.delete("files"+(ids-1));
}

function load(input,i) {
    ids=i;
    if(input.src.indexOf("/assets/images/plus.png")!=-1){
        document.getElementById('upf').click();
    }else {
        document.getElementById('imageResult').src = input.src;
    }
    document.getElementById('ids').innerHTML=ids+1;
}




