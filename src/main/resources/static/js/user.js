let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-login").on("click", () => {
            this.login();
        });
    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        }
        $.ajax({
            type: "POST",
            url: "/api/user",
            data: JSON.stringify(data), //http body 데이터
            contentType: "application/json; charset=utf-8", //보내는 body 데이터가 어떤 타입인지
            //MIME 유형을 기반으로 유추한다(default =Intelligent Guess (xml, json, script, or html)
            dataType: "json"//서버에서 어떤 타입을 받을 것인지를 의미 (요청이 서버로 응답이 왔을 때,javascript 오브젝트로 변경)
        }).done(function (res) {
            alert("회원가입 완료!🎉")
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    login: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
        }
        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data), //http body 데이터
            contentType: "application/json; charset=utf-8", //보내는 body 데이터가 어떤 타입인지
            //MIME 유형을 기반으로 유추한다(default =Intelligent Guess (xml, json, script, or html)
            dataType: "json"//서버에서 어떤 타입을 받을 것인지를 의미 (요청이 서버로 응답이 왔을 때,javascript 오브젝트로 변경)
        }).done(function (res) {
            alert("로그인 완료!✔️")
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();