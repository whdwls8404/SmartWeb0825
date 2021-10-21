// 페이지 로드 이벤트를 활용하면,
// 모든 HTML구성요소를 어디서든 인식할 수 있다.
onload = function(){

    // 1. 아이디 체크하기
    let userId = document.getElementById('userId');
    let msg = document.getElementsByClassName('msg');
    
    // 대소문자 + 숫자 + 특수문자(-, _) 사용해서 4자 이상
    let regId = /^[a-zA-Z0-9-_]{4,}$/;

    // 첫 글자는 숫자, 특수문자 제외
    // 전체 4 ~ 20글자
    // /^[a-zA-Z][a-zA-Z0-9-_]{3,19}$/

    userId.onkeyup = function(event) {
        // this == event.target == userId
        if (this.value.length < 4) {
            msg[0].textContent = '아이디는 4자 이상이어야 합니다.';
            // msg[0].className = 'dont';  // class="dont"      클래스 수정
            msg[0].className += ' dont';   // class="msg dont"  클래스 추가
        } else if (this.value.length >= 4) {
            if (regId.test(this.value)) {
                msg[0].textContent = '중복확인이 필요합니다.';
            } else {
                msg[0].textContent = '아이디는 영문자, 숫자, -, _ 문자만 사용 가능합니다.';
            }
        }
    }

    userId.onblur = function(){
        // ajax : DB 다녀오기
        if (this.value.length >= 4) {
            msg[0].textContent = '사용 가능한 아이디입니다.';
            msg[0].className = 'msg';
        }
    }

    // 2. 비밀번호 체크하기
    let userPw = document.getElementById('userPw');
    let regPw = /^[a-zA-Z0-9!@#$%^&*()]{8,20}$/;
    userPw.addEventListener('keyup', function() {
        let pwValidResult = /[a-z]/.test(this.value) +
                            /[A-Z]/.test(this.value) +
                            /[0-9]/.test(this.value) +
                            /[^a-zA-Z0-9]/.test(this.value);
        if ( regPw.test(this.value) && pwValidResult >= 3 ) {
            msg[1].textContent = '사용 가능한 비밀번호 입니다.';
            msg[1].className = 'msg';
        } else {
            msg[1].textContent = '비밀번호는 8~20자의 영문 대/소문자, 숫자, 특수문자 등 3종류 이상으로 조합해주세요.';
            msg[1].className = 'msg dont';
        }
        if ( /[0-9]{4}/.test(this.value) ) {
            msg[1].textContent = '비밀번호는 연속되거나 동일한 숫자, 문자(4개 이상)의 입력을 제한합니다.';
            msg[1].className = 'msg dont';
        }
    });

    // 3. 비밀번호 재확인
    let userPwConfirm = document.getElementById('userPwConfirm');
    function fn_userPwConfirm(userPw, userPwConfirm) {
        if (userPw.value == userPwConfirm.value) {
            userPwConfirm.parentNode.className = 'input checked';
        } else {
            userPwConfirm.parentNode.className = 'input';
            msg[2].textContent = '비밀번호가 일치하지 않습니다.';
            msg[2].className = 'msg dont';
        }
    }
    userPw.addEventListener('keyup', function(){
        if (userPwConfirm.value == '') {
            msg[2].textContent = '필수 정보입니다.';
            msg[2].className = 'msg dont';
        }
        fn_userPwConfirm(userPw, userPwConfirm);
    });
    userPwConfirm.addEventListener('keyup', function(){
        fn_userPwConfirm(userPw, userPwConfirm);
    });

    // 4. 이름
    let userName = document.getElementById('userName');
    let regName = /^[a-zA-Z가-힣]{1,30}$/;
    function fn_validName(){
        if (userName.value == '') {
            userName.parentNode.className = 'input';
            msg[3].textContent = '이름을 입력해주세요.';
            msg[3].className = 'msg dont';
        } else if (regName.test(userName.value)) {
            userName.parentNode.className = 'input checked';
        } else {
            userName.parentNode.className = 'input';
            msg[3].textContent = '이름은 한글, 영문 대소문자만 사용해주세요.';
            msg[3].className = 'msg dont';
        }
    }
    userName.addEventListener('keyup', fn_validName);
    userName.addEventListener('blur', function(){
        fn_validName();
    });

    // 5. 생년월일
    // 1-1) 년도 만들기
    let yearList = document.querySelector('#year > ul');
    let strYearList = '<li><a href="#" data-uri="년도">년도</a></li>';
    for (let y = 2007; y >= 1911; y--) {
        strYearList += '<li><a href="#" data-uri="' + y + '">' + y + '</a></li>';
    }
    yearList.innerHTML = strYearList;
    // 1-2) select 태그의 하위 태그 <option> 태그 추가하기
    let yearSelect = document.getElementById('year_select');
    let strYearOption = '<option value="">선택</option>';
    for (let y = 2007; y >= 1911; y--) {
        strYearOption += '<option value="' + y + '">' + y + '</option>';
    }
    yearSelect.innerHTML = strYearOption;
    // 2) 년도 클릭하면 ul(yearList) 보여주기
    let year = document.getElementById('year');
    year.addEventListener('click', function(){
        yearList.className = 'lst show';
    });
    year.addEventListener('mouseout', function(){
        yearList.className = 'lst';
    });
    // 3) ul(yearList) 선택
    yearList.addEventListener('mouseover', function(){
        yearList.className = 'lst show';
    });
    // 4) 선택한 년도(a 태그)를 year_value에 표시
    let yearLink = document.querySelectorAll('#year > ul > li > a');
    let yearValue = document.getElementById('year_value');
    for (let i = 0; i < yearLink.length; i++) {
        yearLink[i].addEventListener('click', function(){
            yearValue.textContent = this.textContent;  // this == yearLink[i]
            yearSelect.value = Number(this.textContent);
        });
    } 

    // 6. 이메일
    let userEmail = document.getElementById('userEmail');
    let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}$/;
    let btnSendMail = document.getElementsByClassName('btn_send_mail')[0];
    function fn_vaildEmail(){
        if (userEmail.value == '') {
            msg[4].textContent = '이메일을 입력해 주세요.';
            msg[4].className = 'msg dont';
            userEmail.parentNode.className = 'input';
            btnSendMail.style.display = 'none';
        } else if (regEmail.test(userEmail.value)) {
            userEmail.parentNode.className = 'input checked';
            btnSendMail.style.display = 'block';
        } else {
            msg[4].textContent = '올바른 이메일 형식을 입력해주세요.';
            msg[4].className = 'msg dont';
            userEmail.parentNode.className = 'input';
            btnSendMail.style.display = 'none';
        }
    }
    userEmail.addEventListener('keyup', fn_vaildEmail);
    userEmail.addEventListener('blur', fn_vaildEmail);

}