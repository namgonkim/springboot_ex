var main = {
    init : function () {
        var _this = this;
        $('#btn-find').on('click', function () {
            _this.call_api();
        });
    },

    call_api : function (e) {

        var data = {
            pageNo : $("#pageNo").val(),
            numOfRows : $("#numOfRows").val(),
            startCreateDt : $("#startCreateDt").val(),
            endCreateDt : $("#endCreateDt").val()
        }

        $.ajax({
            type: 'POST',
            url : '/api/v2/corona',
            contentType: 'application/json; charset=utf-8',
            dataType : 'json',
            data : JSON.stringify(data),
            success : [
                function(response) {
                    let retCode = JSON.parse(JSON.stringify(response)).response.header.resultCode;
                    if (retCode != '00') {
                        alert('Open API Call 에러 : ' + JSON.parse(JSON.stringify(response)).response.header.resultMsg);
                        window.location.href = "/";
                    } else {
                        alert('성공');
                        // console.log(JSON.parse(JSON.stringify(response)).response.body.items);
                        let JSON_itemList = JSON.parse(JSON.stringify(response)).response.body.items.item;
                        console.log(JSON_itemList);
                        for (let i = 0; i < JSON_itemList.length; i++) {
                            for (let key in JSON_itemList[i]) {
                                console.log(key + ' : ' + JSON_itemList[i][key]);
                                if (key == "seq")
                                    $('#APIData').append('<span>' + "번호 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "accDefRate")
                                    $('#APIData').append('<span>' + "누적 확진률 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "clearCnt")
                                    $('#APIData').append('<span>' + "격리해제 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "stateDt")
                                    $('#APIData').append('<span>' + "기준일 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "updateDt")
                                    $('#APIData').append('<span>' + "수정일시분초 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "createDt")
                                    $('#APIData').append('<span>' + "등록일시분초 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "examCnt")
                                    $('#APIData').append('<span>' + "검사진행 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "accExamCnt")
                                    $('#APIData').append('<span>' + "누적 검사 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "stateTime")
                                    $('#APIData').append('<span>' + "기준 시간 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "deathCnt")
                                    $('#APIData').append('<span>' + "사망자 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "decideCnt")
                                    $('#APIData').append('<span>' + "확진자 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "resutlNegCnt")
                                    $('#APIData').append('<span>' + "결과 음성 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "accExamCompCnt")
                                    $('#APIData').append('<span>' + "누적 검사 완료 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');
                                else if (key == "careCnt")
                                    $('#APIData').append('<span>' + "치료 중인 환자 수 : " + JSON.stringify(JSON_itemList[i][key]) + '</span><br/>');

                            }
                        }
                    }
                }
            ],
            error: [
                function(response) {
                    alert('실패');
                }
            ]
        });
    }
};

main.init();