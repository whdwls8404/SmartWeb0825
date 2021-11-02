$(document).ready(function(){
    fnCheckId();
    fnCheckPw();
    fnCheckName();
    fnCheckEmail();
    fnCheckSubmit();
});

// 1. 아이디
function fnCheckId(){
    let userId = $('#userId');
    let msgId = $('#msgId');
    let regId = /^[a-z0-9]{4,20}$/;
    $(userId).on('keyup', function(){
        if (regId.test($(this).val())) {
            $(msgId).text('올바른 형식입니다.');
            $(msgId).addClass('ok');
            $(msgId).removeClass('not_ok');
        } else {
            $(msgId).text('아이디는 소문자/숫자 4자 이상 사용 가능합니다.');
            $(msgId).addClass('not_ok');
            $(msgId).removeClass('ok');
        }
    });
}

// 2. 비밀번호
function fnCheckPw(){
    let userPw = $('#userPw');
    let regPw = /^[a-zA-Z0-9!@#$%^&*]{8,20}$/;
    let msgPw = $('#msgPw');
    $(userPw).on('blur', function(){
        let pwValidResult = /* 소문자   검사 */ /[a-z]/.test($(this).val()) +
                            /* 대문자   검사 */ /[A-Z]/.test($(this).val()) +
                            /* 숫자     검사 */ /[0-9]/.test($(this).val()) +
                            /* 특수문자 검사 */ /[^a-zA-Z0-9]/.test($(this).val());
        if ( regPw.test($(userPw).val()) && pwValidResult >= 3 ) {
            $(msgPw).text('사용 가능한 비밀번호 입니다.');
            $(msgPw).addClass('ok');
            $(msgPw).removeClass('not_ok');
        } else {
            $(msgPw).text('비밀번호는 8~20자의 영문 대/소문자, 숫자, 특수문자 등 3종류 이상으로 조합해주세요.');
            $(msgPw).addClass('not_ok');
            $(msgPw).removeClass('ok');
        }
    });
}
 
// 3. 이름
function fnCheckName(){
    let userName = $('#userName');
    let regName = /^[a-zA-Z가-힣]{1,30}$/;
    let msgName = $('#msgName');
    $(userName).on('keyup blur', function(){
        if ($(userName).val() == '') {
            $(msgName).text('이름을 입력해 주세요.');
            $(msgName).addClass('not_ok');
            $(msgName).removeClass('ok');
        } else if (regName.test($(userName).val()) == false) {
            $(msgName).text('이름은 한글, 영문 대소문자만 사용해 주세요.');
            $(msgName).addClass('not_ok');
            $(msgName).removeClass('ok');
        } else {
            $(msgName).text('사용 가능한 이름입니다.');
            $(msgName).addClass('ok');
            $(msgName).removeClass('not_ok');
        }
    });
}

// 4. 이메일
function fnCheckEmail(){
    let userEmail = $('#userEmail');
    let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}$/;
    let msgEmail = $('#msgEmail');
    $(userEmail).on('keyup blur', function(){
        if (regEmail.test($(userEmail).val())) {
            $(msgEmail).text('올바른 이메일 형식입니다.');
            $(msgEmail).addClass('ok');
            $(msgEmail).removeClass('not_ok');
        } else {
            $(msgEmail).text('올바른 형식의 이메일을 입력해 주세요.');
            $(msgEmail).addClass('not_ok');
            $(msgEmail).removeClass('ok');
        }
    });
}

// 5. 서브밋
function fnCheckSubmit(){
    let joinForm = $('#join_form');
    $(joinForm).on('submit', function(event){
        if (confirm('가입할까요?') == false) {
            event.preventDefault();
            return false;
        }
        return true;
    })
}