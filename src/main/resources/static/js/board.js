let index = {
    init: function () {
        $("#btn-write").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteByArticle();
        });

    },

    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        }
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data), //http body 데이터
            contentType: "application/json; charset=utf-8", //보내는 body 데이터가 어떤 타입인지
            //MIME 유형을 기반으로 유추한다(default =Intelligent Guess (xml, json, script, or html)
            dataType: "json"//서버에서 어떤 타입을 받을 것인지를 의미 (요청이 서버로 응답이 왔을 때,javascript 오브젝트로 변경)
        }).done(function (res) {
            alert("글이 작성되었습니다!!🎉")
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    deleteByArticle: function () {
        let id = $("#id").text();
        // console.log(id);

        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
            dataType: "json"//서버에서 어떤 타입을 받을 것인지를 의미 (요청이 서버로 응답이 왔을 때,javascript 오브젝트로 변경)
        }).done(function (res) {
            alert("글이 삭제되었습니다!!🎉")
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },


}

index.init();
