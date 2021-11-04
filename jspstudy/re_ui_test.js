$(document).ready(function(){
    $('#id').on('blur', function(){ fnIdCheck(); });
    $('#pwd').on('blur', function(){ fnPwdCheck(); fnRePwdCheck(); });
    $('#re_pwd').on('blur', function(){ fnPwdCheck(); fnRePwdCheck(); });
    $('#name').on('blur', function(){ fnNameCheck(); });
    fnSubmit();
});

let idPass = false;
let pwPass = false;
let pwRePass = false;
let namePass = false;

function fnIdCheck(){
    let regID = /^[a-z0-9][a-z0-9_-]{4,19}$/;
    if ($('#id').val() == '') {
        $('#id_check').text('필수 정보입니다.');
        $('#id_check').addClass('check_fail');
        $('#id_check').removeClass('check_pass');
        idPass = false;
    } else {
        if (regID.test($(id).val())) {
            $('#id_check').text('멋진 아이디네요!');
            $('#id_check').addClass('check_pass');
            $('#id_check').removeClass('check_fail');
            idPass = true;
        } else {
            $('#id_check').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
            $('#id_check').addClass('check_fail');
            $('#id_check').removeClass('check_pass');
            idPass = false;
        }
    }
}

function fnPwdCheck(){
    let regPWD = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*]{4,16}$/;
    if ($('#pwd').val() == '') {
        $('#pwd + span').addClass('check_fail');
        $('#pwd + span').removeClass('check_pass');
        $('#pwd_check').val('필수 정보입니다.');
        $('#pwd_check').addClass('check_fail');
        $('#pwd_check').removeClass('check_pass');
        pwPass = false;
    } else {
        if (regPWD.test($('#pwd').val())) {
            $('#pwd + span').addClass('check_pass');
            $('#pwd + span').removeClass('check_fail');
            pwPass = true;
        } else {
            $('#pwd + span').addClass('check_fail');
            $('#pwd + span').removeClass('check_pass');
            $('#pwd_check').val('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
            $('#pwd_check').addClass('check_fail');
            $('#pwd_check').removeClass('check_pass');
            pwPass = false;
        }
    }
}

function fnRePwdCheck(){
    if ($('#re_pwd').val() == '') {
        $('#re_pwd + span').removeClass('check_pass');
        $('#re_pwd_check').text('필수 정보입니다.');
        $('#re_pwd_check').addClass('check_fail');
        $('#re_pwd_check').removeClass('check_pass');
        pwRePass = false;
    } else if ($('#re_pwd').val() == $('#pwd').val()) {
        $('#re_pwd + span').addClass('check_pass');
        $('#re_pwd_check').text('');
        pwRePass = true;
    } else {
        $('#re_pwd + span').removeClass('check_pass');
        $('#re_pwd_check').text('비밀번호가 일치하지 않습니다.');
        $('#re_pwd_check').addClass('check_fail');
        $('#re_pwd_check').removeClass('check_pass');
        pwRePass = false;
    }
}

function fnNameCheck(){
    let regName = /^[가-힣a-zA-Z]+$/;
    if ($('#name').val() == '') {
        $('#name_check').text('필수 정보입니다.');
        namePass = false;
    } else {
        if (regName.test($('#name').val())) {
            $('#name_check').text('');
            namePass = true;
        } else {
            $('#name_check').text('한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)');
            namePass = false;
        }
    }
}

function fnSubmit(){
    $('#join_form').on('submit', function(event){
        if (idPass && pwPass && pwRePass && namePass) {
            if(confirm('가입할까요?')) {
                alert('가입되었습니다.');
                return true;
            } else {
                event.preventDefault();
                return false;
            }
        } else {
            event.preventDefault();
            return false;
        }
    });
}